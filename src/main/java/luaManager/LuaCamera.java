package luaManager;

import engine.renderer.Camera;
import engine.renderer.SpriteRenderer;
import org.joml.Vector2f;

public class LuaCamera {

    public Camera camera;

    private static LuaCamera instance;

    public LuaCamera() {

    }

    public static LuaCamera get() {
        if(instance == null) {
            instance = new LuaCamera();
        }
        return instance;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setFocusPosition(float x, float y) {
        camera.setFocusPosition(new Vector2f(x,y));
    }
}
