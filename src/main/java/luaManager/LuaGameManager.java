package luaManager;

import engine.IApplication;
import engine.PaperEngine;
import engine.manager.ResourceManager;
import engine.renderer.Camera;
import engine.renderer.SpriteRenderer;
import org.joml.Vector2f;
import org.joml.Vector4f;

public class LuaGameManager implements IApplication {

    public String game = "flappybird";
    SpriteRenderer spriteRenderer;
    private Camera camera;
    @Override
    public void init()  {
        camera = new Camera(new Vector2f());
        spriteRenderer = new SpriteRenderer();
        LuaGame.Load(game, spriteRenderer, camera);
        LuaGame.init();
    }

    @Override
    public void render() {

        camera.adjustProjection();
        spriteRenderer.setProjectionMatrix(camera.getProjection(), camera.getViewMatrix());

        LuaGame.render();

    }

    @Override
    public void update(double delta) {
        LuaGame.update(delta);
    }

    @Override
    public void input() {

    }
}
