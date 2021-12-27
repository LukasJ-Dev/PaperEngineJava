import FlappyBirdTest.Game1;
import engine.GLFWWindow;
import engine.IApplication;
import engine.PaperEngine;

public class Main {
    public static void main(String[] args) {
        IApplication game = new Game1();
        PaperEngine paperEngine = new PaperEngine(new GLFWWindow());
        try {
            paperEngine.run(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}