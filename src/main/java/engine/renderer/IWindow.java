package engine.renderer;
import org.joml.Vector2d;
import org.joml.Vector2f;

public interface IWindow {
    void Destroy();
    void init();
    boolean isWindowOpen();
    void loop();

    int getWidth();
    int getHeight();

    int GetInput(int keyCode);
    Vector2f GetCursorPosVector2f();
    Vector2d GetCursorPosVector2d();
}
