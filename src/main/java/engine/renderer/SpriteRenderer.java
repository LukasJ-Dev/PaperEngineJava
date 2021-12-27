package engine.renderer;

import engine.FileManager;
import engine.manager.ResourceManager;
import org.joml.*;

import java.lang.Math;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class SpriteRenderer {

    private int vaoID, vboID, eboID;
    private Matrix4f projectionMatrix;

    public SpriteRenderer() {

        String vertexShaderSrc = null;
        try {
            vertexShaderSrc = FileManager.loadResource("spriteVertex.vert");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fragmentShaderSrc = null;
        try {
            fragmentShaderSrc = FileManager.loadResource("spriteFragment.frag");
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            ResourceManager.get().setShader("Sprite", new Shader());
            ResourceManager.get().getShader("Sprite").createVertexShader(vertexShaderSrc);
            ResourceManager.get().getShader("Sprite").createFragmentShader(fragmentShaderSrc);
            ResourceManager.get().getShader("Sprite").link();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResourceManager.get().getShader("Sprite").bind();
        ResourceManager.get().getShader("Sprite").uploadInt("image", 0);
        initRenderData();

        ResourceManager.get().getShader("Sprite").unbind();
    }

    public void setProjectionMatrix(Matrix4f projectionMatrix) {
        ResourceManager.get().getShader("Sprite").bind();
        ResourceManager.get().getShader("Sprite").uploadMat4f("projection", projectionMatrix);
        ResourceManager.get().getShader("Sprite").unbind();

        this.projectionMatrix = projectionMatrix;
    }

    public void DrawSprite(Texture texture, Vector2f position, Vector2f scale, float rotate, Vector4f color) {
        ResourceManager.get().getShader("Sprite").bind();

        Matrix4f model = new Matrix4f(
                1.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 1.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 1.0f
        );

        Vector2f size = new Vector2f(texture.getWidth() * scale.x * 0.5f, texture.getHeight() * scale.y * 0.5f);

        model.translate(new Vector3f(new Vector2f(position.x - size.x*0.5f, position.y - size.y *0.5f), 0.0f));
        model.translate(new Vector3f(new Vector2f(size.x*0.5f, size.y*0.5f), 0.0f));
        model.rotate((float) Math.toRadians(rotate), new Vector3f(0.0f, 0.0f, 1.0f));
        model.translate(new Vector3f(new Vector2f(size.x * -0.5f, size.y * -0.5f), 0.0f));

        model.scale(new Vector3f(size, 1.0f));

        ResourceManager.get().getShader("Sprite").uploadMat4f("model", model);

        ResourceManager.get().getShader("Sprite").uploadVec4f("spriteColor", color);

        //shader.uploadTexture("TEX_SAMPLER", 0);
        glActiveTexture(GL_TEXTURE0);
        texture.bind();

        glBindVertexArray(vaoID);
        glDrawArrays(GL_TRIANGLES, 0, 6);
        glBindVertexArray(0);

        ResourceManager.get().getShader("Sprite").unbind();

    }

    public void initRenderData() {
        float[] vertices = {
                0.0f, 1.0f, 0.0f, 1.0f,
                1.0f, 0.0f, 1.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 0.0f,

                0.0f, 1.0f, 0.0f, 1.0f,
                1.0f, 1.0f, 1.0f, 1.0f,
                1.0f, 0.0f, 1.0f, 0.0f,
        };

        vaoID = glGenVertexArrays();
        vboID = glGenBuffers();

        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);


        glBindVertexArray(vaoID);

        glEnableVertexAttribArray(0);
        int positionsSize = 4;
        glVertexAttribPointer(0, positionsSize, GL_FLOAT, false, positionsSize * Float.BYTES, 0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);

    }
}
