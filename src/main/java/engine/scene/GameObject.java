package engine.scene;

import engine.scene.components.Component;
import engine.scene.components.Transform;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private Transform transform;
    private List<Component> components = new ArrayList<Component>();

    public GameObject(Transform transform) {
        this.transform = transform;
    }

    public void AttachComponent(Component component) {
        components.add(component);
    }
}
