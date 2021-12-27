package engine.scene;

import engine.IApplicationLogic;

import java.util.ArrayList;
import java.util.List;

public class Scene {


    private List<GameObject> gameobjects;

    private String name = "";

    public Scene(String name) {
        gameobjects = new ArrayList<GameObject>();
        this.name = name;
    }

    public void Add(GameObject gameObject) {
        gameobjects.add(gameObject);
    }

    public String getName() {
        return name;
    }
}
