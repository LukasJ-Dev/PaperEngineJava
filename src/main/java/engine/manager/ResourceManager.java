package engine.manager;

import engine.renderer.Shader;
import engine.renderer.Texture;
import engine.scene.Scene;

import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
    private Map<String, Shader> shaders = new HashMap<String, Shader>();
    private Map<String, Texture> textures = new HashMap<String,Texture>();
    private static ResourceManager instance = null;

    public ResourceManager() {
    }

    public static ResourceManager get() {
        if(ResourceManager.instance == null) {
            ResourceManager.instance = new ResourceManager();
        }
        return ResourceManager.instance;
    }

    public void setShader(String name, Shader shader) {
        shaders.put(name, shader);
    }

    public Shader getShader(String name) {
        return shaders.get(name);
    }

    public void setTexture(String name, Texture texture) {
        textures.put(name, texture);
    }

    public Texture getTexture(String name) {
        return textures.get(name);
    }
}
