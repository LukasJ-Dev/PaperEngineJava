import engine.GLFWWindow;
import engine.IApplication;
import engine.PaperEngine;
import engine.manager.GLFWInput;
import example.flappybird.FlappyBird;
import luaManager.LuaGameManager;

public class Main {
    public static void main(String[] args) {
        //IApplication game = new FlappyBird();
        //PaperEngine paperEngine = new PaperEngine(new GLFWWindow(), new GLFWInput());
        new LuaGameManager().init();
        try {
            //paperEngine.run(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}