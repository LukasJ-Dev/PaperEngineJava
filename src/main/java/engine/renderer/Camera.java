package engine.renderer;

import engine.PaperEngine;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class Camera {
    private Matrix4f projection, viewMatrix;
    public Vector2f position;

    public Camera(Vector2f position) {
        this.position = position;
        this.projection = new Matrix4f();
        this.viewMatrix = new Matrix4f();
        adjustProjection();
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public void adjustProjection() {
        projection.identity();
        projection = projection.ortho(position.x, position.x + PaperEngine.window.getWidth(), position.y + PaperEngine.window.getHeight(), position.y, -1.0f, 1.0f);
        //projectionMatrix.ortho(0.0f, 32.0f * 40.0f, 0.0f, 32.0f * 21.0f, 0.0f,100.0f);
    }
/*
    public Matrix4f getViewMatrix() {
        Vector3f cameraFront = new Vector3f(0.0f, 0.0f, -1.0f);
        Vector3f cameraUp = new Vector3f(0.0f, 1.0f, 0.0f);
        this.viewMatrix.identity();
        viewMatrix.lookAt(
                new Vector3f(position.x, position.y, 20.0f),
                cameraFront.add(position.x, position.y, 0.0f),
                cameraUp
                );
        return viewMatrix;
    }*/

    public Matrix4f getProjection() {
        return projection;
    }
}
