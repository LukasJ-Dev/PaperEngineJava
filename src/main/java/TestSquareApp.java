import engine.FileManager;
import engine.IApplication;

import engine.Window;
import engine.renderer.Camera;
import engine.renderer.Shader;
import engine.renderer.Texture;
import org.joml.Vector2f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.glfwGetTime;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class TestSquareApp implements IApplication {

    private int vertexID, fragmentID, shaderProgram;
    private Texture texture;

    private Shader shader;

    private float[] vertexArray = {
            //pos                   // color                            UV Coords
             100.5f, -100.5f, 0.0f,      1.0f, 0.0f, 0.0f, 1.0f,        1, 1, //Bottom right
            -100.5f,  100.5f, 0.0f,      0.0f, 1.0f, 0.0f, 1.0f,        0, 0, //Top left
             100.5f,  100.5f, 0.0f,      0.0f, 0.0f, 1.0f, 1.0f,        1, 0, //Top right
            -100.5f, -100.5f, 0.0f,      1.0f, 1.0f, 0.0f, 1.0f,        0, 1 //Bottom left
    };

    private int[] elementArray = {
            2, 1, 0,
            0, 1, 3
    };

    private int vaoID, vboID, eboID;

    private Camera camera;

    @Override
    public void init() throws Exception {
        camera = new Camera(new Vector2f());
        texture = new Texture("tux.jpg");

        String vertexShaderSrc = FileManager.loadResource("defaultVertex.vert");
        String fragmentShaderSrc = FileManager.loadResource("defaultFragment.frag");

        try {
            shader = new Shader();
            shader.createVertexShader(vertexShaderSrc);
            shader.createFragmentShader(fragmentShaderSrc);
            shader.link();
        } catch (Exception e) {
            e.printStackTrace();
        }


        vaoID = glGenVertexArrays();
        glBindVertexArray(vaoID);

        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertexArray.length);
        vertexBuffer.put(vertexArray).flip();

        vboID = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);

        IntBuffer elementBuffer = BufferUtils.createIntBuffer(elementArray.length);
        elementBuffer.put(elementArray).flip();

        eboID = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, eboID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, elementBuffer, GL_STATIC_DRAW);

        int positionsSize = 3;
        int colorSize = 4;
        int uvSize = 2;
        int vertexSizeBytes = (positionsSize + colorSize + uvSize) * Float.BYTES;
        glVertexAttribPointer(0, positionsSize, GL_FLOAT, false, vertexSizeBytes, 0);
        glEnableVertexAttribArray(0);

        glVertexAttribPointer(1, colorSize, GL_FLOAT, false, vertexSizeBytes, positionsSize * Float.BYTES);
        glEnableVertexAttribArray(1);

        glVertexAttribPointer(2, uvSize, GL_FLOAT, false, vertexSizeBytes, (positionsSize + colorSize) * Float.BYTES);
        glEnableVertexAttribArray(2);

    }

    @Override
    public void render() {
        Window.get().clearColor(0.0f,0.0f,0.0f,1.0f);
        Window.get().clear();
        shader.bind();

        shader.uploadTexture("TEX_SAMPLER", 0);
        glActiveTexture(GL_TEXTURE0);
        texture.bind();

        shader.uploadMat4f("uProjection", camera.getProjectionMatrix());
        shader.uploadMat4f("uView", camera.getViewMatrix());
        shader.uploadFloat("uTime", (float)glfwGetTime());

        glBindVertexArray(vaoID);

        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);

        glDrawElements(GL_TRIANGLES, elementArray.length, GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);

        glBindVertexArray(0);

        shader.unbind();



    }

    @Override
    public void update(double delta) {

        camera.position.x=-600;
        camera.position.y=-300;
    }

    @Override
    public void input() {

    }
}
