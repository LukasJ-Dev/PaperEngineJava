package engine.manager;

import org.joml.Vector2f;

public interface IInput {
    boolean isKeyPressed(int keycode);
    boolean isMouseButtonPressed(int button);

    Vector2f GetMousePosition();

    float GetMouseX();
    float getMouseY();


}
