package luaManager;

import engine.manager.ResourceManager;
import engine.renderer.SpriteRenderer;
import engine.renderer.Texture;
import org.joml.Vector2f;
import org.joml.Vector4f;

import static org.lwjgl.opengl.GL11.*;

public class LuaPaperEngine {

    public SpriteRenderer spriteRenderer;

    private static LuaPaperEngine instance;

    public LuaPaperEngine() {

    }

    public static LuaPaperEngine get() {
        if(instance == null) {
            instance = new LuaPaperEngine();
        }
        return instance;
    }

    public void setSpriteRenderer(SpriteRenderer spriteRenderer) {
        this.spriteRenderer = spriteRenderer;
    }

    public void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void clearColor(float r, float g, float b, float a) {
        glClearColor(a,g,b,a);
    }

    public void drawSprite(String name, float x, float y, float scaleX, float scaleY, float rotate, float R, float G, float B, float A) {
        spriteRenderer.DrawSprite(ResourceManager.get().getTexture(name), new Vector2f(x,y), new Vector2f(scaleX,scaleY), rotate, new Vector4f(R,G,B,A));
    }

    public void drawSprite(String name, float x, float y, float scaleX, float scaleY, float rotate) {
        spriteRenderer.DrawSprite(ResourceManager.get().getTexture(name), new Vector2f(x,y), new Vector2f(scaleX,scaleY), rotate, new Vector4f(1,1,1,1));
    }

    public void drawSprite(String name, float x, float y, float scaleX, float scaleY) {
        spriteRenderer.DrawSprite(ResourceManager.get().getTexture(name), new Vector2f(x,y), new Vector2f(scaleX,scaleY), 0, new Vector4f(1,1,1,1));
    }

    public void drawSprite(String name, float x, float y) {
        spriteRenderer.DrawSprite(ResourceManager.get().getTexture(name), new Vector2f(x,y), new Vector2f(1,1), 0, new Vector4f(1,1,1,1));
    }

    public boolean isTrue() {
        return true;
    }
}
