package engine.manager;

import engine.GLFWWindow;
import engine.PaperEngine;
import org.joml.Vector2f;
import org.lwjgl.BufferUtils;

import java.nio.DoubleBuffer;

import static org.lwjgl.glfw.GLFW.*;

public class GLFWInput implements IInput {
    @Override
    public boolean isKeyPressed(int keycode) {
        long window = ((GLFWWindow) PaperEngine.window).GetNativeWindow();
        int state = glfwGetKey(window, keycode);
        return state == GLFW_PRESS ||state == GLFW_REPEAT;
    }

    @Override
    public boolean isMouseButtonPressed(int button) {
        long window = ((GLFWWindow) PaperEngine.window).GetNativeWindow();
        int state = glfwGetMouseButton(window, button);
        return state == GLFW_PRESS ||state == GLFW_REPEAT;
    }

    @Override
    public Vector2f GetMousePosition() {
        long window = ((GLFWWindow) PaperEngine.window).GetNativeWindow();
        DoubleBuffer posX = BufferUtils.createDoubleBuffer(1);
        DoubleBuffer posY = BufferUtils.createDoubleBuffer(1);
        glfwGetCursorPos(window,posX,posY);
        return new Vector2f((float)posX.get(0),(float)posY.get(0));
    }

    @Override
    public float GetMouseX() {
        long window = ((GLFWWindow) PaperEngine.window).GetNativeWindow();
        DoubleBuffer posX = BufferUtils.createDoubleBuffer(1);
        DoubleBuffer posY = BufferUtils.createDoubleBuffer(1);
        glfwGetCursorPos(window,posX,posY);
        return (float) posX.get(0);
    }

    @Override
    public float getMouseY() {
        long window = ((GLFWWindow) PaperEngine.window).GetNativeWindow();
        DoubleBuffer posX = BufferUtils.createDoubleBuffer(1);
        DoubleBuffer posY = BufferUtils.createDoubleBuffer(1);
        glfwGetCursorPos(window,posX,posY);
        return (float) posY.get(0);
    }
}
