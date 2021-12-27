package engine;

public interface IApplicationLogic {
    void init() throws Exception;
    void render();
    void update(double delta);
    void input();
}
