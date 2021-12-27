package engine.manager;

import engine.PaperEngine;
import engine.renderer.IWindow;
import org.joml.Vector2f;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;

public class InputManager {
    private static InputManager inputManager = null;
    private IWindow window;

    private InputManager() {
        window = PaperEngine.window;
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

    public boolean isKeyPressed(int keyCode) {
        return window.GetInput(keyCode) == GLFW_PRESS;
    }

    public Vector2f GetMousePosition() {
        return window.GetCursorPosVector2f();
    }
}
