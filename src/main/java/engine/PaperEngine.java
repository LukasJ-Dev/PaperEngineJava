package engine;

import engine.manager.GLFWInput;
import engine.manager.IInput;
import engine.renderer.IWindow;

import static org.lwjgl.glfw.GLFW.*;

public class PaperEngine {

    private static PaperEngine paperEngine;
    public static IApplication game;
    public static IWindow window;
    public static IInput input;


    public PaperEngine(IWindow window, IInput inputClass) {
        this.window = window;
        input = inputClass;
    }

    public void run(IApplication game) throws Exception {
        this.game = game;
        init();
        loop();
        // Free the window callbacks and destroy the window
        window.Destroy();

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init()  {
        window.init();

        game.init();
    }

    private void loop() {
        double deltaTime = 0;
        double lastFrame = 0;
        while ( window.isWindowOpen()) {
            double currentFrame = glfwGetTime();
            deltaTime = currentFrame - lastFrame;
            lastFrame = currentFrame;
            game.input();

            game.update(deltaTime);

            window.loop();
            game.render();



        }
    }
}