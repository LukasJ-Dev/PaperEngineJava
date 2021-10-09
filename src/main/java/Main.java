import engine.IApplication;
import engine.PaperEngine;

public class Main {
    public static void main(String[] args) {
        System.out.println("a");
        IApplication game = new TestSquareApp();
        PaperEngine paperEngine = PaperEngine.get();
        paperEngine.run(game);
    }
}