package engine;

import org.joml.Vector2d;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;

public class InputManager {
    private static InputManager inputManager = null;
    private Window window;

    private InputManager() {
        window = Window.get();
    }

    public static InputManager get() {
        if(InputManager.inputManager == null) {
            InputManager.inputManager = new InputManager();
        }
        return InputManager.inputManager;
    }

    public int GetInput(int keyCode) {
        return window.GetInput(keyCode);
    }

    public Vector2d GetCursorPosition() {
        return window.GetCursorPos();
    }

    public boolean isKeyPressed(int keyCode) {
        return window.GetInput(keyCode) == GLFW_PRESS;
    }

    public void GetMousePosition() {

    }
}
