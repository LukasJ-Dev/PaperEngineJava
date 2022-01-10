package engine;

public interface IApplication {
    void init();
    void render();
    void update(double delta);
    void input();
}