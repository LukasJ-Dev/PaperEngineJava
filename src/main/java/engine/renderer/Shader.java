package engine.renderer;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.joml.Vector3f;
import org.joml.Vector2f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;

public class Shader {

    private final int shaderProgram;
    private int vertexID, fragmentID;

    private boolean beingUsed = false;

    public Shader() throws Exception {
        shaderProgram = glCreateProgram();
        if (shaderProgram == 0) {
            throw new Exception("Could not create Shader");
        }
    }

    public void createVertexShader(String shaderCode) throws Exception {
        vertexID = createShader(shaderCode, GL_VERTEX_SHADER);
    }

    public void createFragmentShader(String shaderCode) throws Exception {
        fragmentID = createShader(shaderCode, GL_FRAGMENT_SHADER);
    }

    protected int createShader(String code, int shaderType) {
        int shaderId = glCreateShader(shaderType);
        glShaderSource(shaderId, code);
        glCompileShader(shaderId);

        int success = glGetShaderi(shaderId, GL_COMPILE_STATUS);
        if (success == GL_FALSE) {
            int len = glGetShaderi(shaderId, GL_INFO_LOG_LENGTH);
            System.out.println("ERROR: 'defaultShader.glsl'\n\tVertex shader compilation failed.");
            System.out.println(glGetShaderInfoLog(shaderId, len));
            assert false : "";

        }

        glAttachShader(shaderProgram, shaderId);
        return shaderId;

    }

    public void link() throws Exception {
        glLinkProgram(shaderProgram);
        if (glGetProgrami(shaderProgram, GL_LINK_STATUS) == 0) {
            throw new Exception("Error linking Shader code: " + glGetProgramInfoLog(shaderProgram, 1024));
        }

        if (vertexID != 0) {
            glDetachShader(shaderProgram, vertexID);
        }
        if (fragmentID != 0) {
            glDetachShader(shaderProgram, fragmentID);
        }

        glValidateProgram(shaderProgram);
        if (glGetProgrami(shaderProgram, GL_VALIDATE_STATUS) == 0) {
            System.err.println("Warning validating Shader code: " + glGetProgramInfoLog(shaderProgram, 1024));
        }

    }

    public void bind() {
        if(!beingUsed) {
            glUseProgram(shaderProgram);
            beingUsed = true;
        }
    }

    public void unbind() {
        glUseProgram(0);
        beingUsed = false;
    }

    public void cleanup() {
        unbind();
        if (shaderProgram != 0) {
            glDeleteProgram(shaderProgram);
        }
    }

    public void uploadMat4f(String varName, Matrix4f mat4) {
        int varLocation = glGetUniformLocation(shaderProgram, varName);
        bind();
        FloatBuffer matBuffer = BufferUtils.createFloatBuffer(16);
        mat4.get(matBuffer);
        glUniformMatrix4fv(varLocation, false, matBuffer);
    }

    public void uploadMat3f(String varName, Matrix3f mat3) {
        int varLocation = glGetUniformLocation(shaderProgram, varName);
        bind();
        FloatBuffer matBuffer = BufferUtils.createFloatBuffer(9);
        mat3.get(matBuffer);
        glUniformMatrix3fv(varLocation, false, matBuffer);
    }

    public void uploadVec4f(String varName, Vector4f vec) {
        int varLocation = glGetUniformLocation(shaderProgram, varName);
        bind();
        glUniform4f(varLocation, vec.x, vec.y, vec.z, vec.w);
    }

    public void uploadVec3f(String varName, Vector3f vec) {
        int varLocation = glGetUniformLocation(shaderProgram, varName);
        bind();
        glUniform3f(varLocation, vec.x, vec.y, vec.z);
    }

    public void uploadVec2f(String varName, Vector2f vec) {
        int varLocation = glGetUniformLocation(shaderProgram, varName);
        bind();
        glUniform2f(varLocation, vec.x, vec.y);
    }

    public void uploadFloat(String varName, float val) {
        int varLocation = glGetUniformLocation(shaderProgram, varName);
        bind();
        glUniform1f(varLocation, val);
    }

    public void uploadInt(String varName, int val) {
        int varLocation = glGetUniformLocation(shaderProgram, varName);
        bind();
        glUniform1i(varLocation, val);
    }

    public void uploadTexture(String varName, int slot) {
        int varLocation = glGetUniformLocation(shaderProgram, varName);
        bind();
        glUniform1i(varLocation, slot);
    }
}
