package engine.renderer;

import engine.PaperEngine;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class Camera {
    private Matrix4f projection, viewMatrix;
    public Vector2f focusPosition;

    public Camera(Vector2f focusPosition) {
        this.focusPosition = focusPosition;
        this.projection = new Matrix4f();
        this.viewMatrix = new Matrix4f();
        adjustProjection();
    }

    public void setFocusPosition(Vector2f focusPosition) {
        this.focusPosition = focusPosition;
    }

    public void adjustProjection() {
        projection.identity();

        projection.ortho(0.0f, PaperEngine.window.getWidth(), 0.0f, PaperEngine.window.getHeight(), 0.0f, 100.0f);
        /*projection = projection.ortho(position.x - PaperEngine.window.getWidth()/2, position.x + PaperEngine.window.getWidth()/2,
                position.y + PaperEngine.window.getHeight()/2, position.y - PaperEngine.window.getHeight()/2, -1.0f, 1.0f);*/
    }

    public Matrix4f getViewMatrix() {
        Vector3f cameraFront = new Vector3f(0.0f, 0.0f, -1.0f);
        Vector3f cameraUp = new Vector3f(0.0f, 1.0f, 0.0f);

        Vector2f position = new Vector2f(focusPosition.x - PaperEngine.window.getWidth()/2, focusPosition.y - PaperEngine.window.getHeight()/2);

        this.viewMatrix.identity();
        viewMatrix.lookAt(new Vector3f(position.x, position.y, 20.0f),
                cameraFront.add(position.x, position.y, 0.0f),
                cameraUp);

        return this.viewMatrix;
    }

    public Matrix4f getProjection() {
        return projection;
    }
}
