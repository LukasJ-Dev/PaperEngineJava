package engine;

import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;

public class PaperEngine {

    private static PaperEngine paperEngine;
    private IApplication game;
    private Window window;
    private InputManager inputManager;


    private PaperEngine() {
        window = Window.get();
        inputManager = InputManager.get();
    }

    public static PaperEngine get() {
        if(paperEngine == null) {
            paperEngine = new PaperEngine();
        }
        return paperEngine;
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

    private void init() throws Exception {
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