import engine.GLFWWindow;
import engine.IApplication;
import engine.PaperEngine;
import engine.manager.GLFWInput;
import example.flappybird.FlappyBird;
import luaManager.LuaGameManager;

public class Main {
    public static void main(String[] args) {
        IApplication game = new LuaGameManager();
        PaperEngine paperEngine = new PaperEngine(new GLFWWindow(), new GLFWInput());
        try {
            paperEngine.run(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}