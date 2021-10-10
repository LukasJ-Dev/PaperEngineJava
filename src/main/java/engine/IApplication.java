package engine;

public interface IApplication {
    void init() throws Exception;
    void render();
    void update(double delta);
    void input();
}