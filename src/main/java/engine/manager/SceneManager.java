package engine.manager;

import engine.scene.Scene;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {

    private Map<String, Scene> sceneList = new HashMap<String,Scene>();
    private String currentScene;
    private static SceneManager instance = null;

    public SceneManager() {
    }

    public static SceneManager get() {
        if(SceneManager.instance == null) {
            SceneManager.instance = new SceneManager();
        }
        return SceneManager.instance;
    }

    public void addScene(Scene scene) {
        System.out.println(scene.getName());
        sceneList.put(scene.getName(), scene);
    }

    public void setScene(String world) {
        currentScene = world;
    }

    public Scene getCurrentScene() {
        return sceneList.get(currentScene);
    }
}
