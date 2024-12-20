package engine.renderer;
import org.joml.Vector2d;
import org.joml.Vector2f;

public interface IWindow {
    void Destroy();
    void init();
    boolean isWindowOpen();
    void loop();
    void setTitle(String title);

    int getWidth();
    int getHeight();
}
