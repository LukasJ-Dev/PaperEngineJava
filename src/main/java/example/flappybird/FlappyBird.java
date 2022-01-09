package example.flappybird;

import engine.IApplication;
import engine.manager.ResourceManager;
import engine.renderer.Camera;
import engine.renderer.SpriteRenderer;
import engine.renderer.Texture;
import org.joml.Vector2f;
import org.joml.Vector4f;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;

public class FlappyBird implements IApplication {

    private SpriteRenderer spriteRenderer;
    private Camera camera;
    private Vector2f pos1 = new Vector2f(0.0f, 600.0f);
    private Vector2f pos2 = new Vector2f(0.0f, 0.0f);
    private ObstacleGenerator obstacleGenerator;

    @Override
    public void init() throws Exception {
        ResourceManager.get().setTexture("bird", new Texture("resources/flappybird/bird_wingdown.png"));
        ResourceManager.get().setTexture("pipe", new Texture("resources/flappybird/pipe_middle.png"));
        ResourceManager.get().setTexture("pipetop", new Texture("resources/flappybird/pipe_top.png"));
        camera = new Camera(new Vector2f());

        spriteRenderer = new SpriteRenderer();

        obstacleGenerator = new ObstacleGenerator();
        obstacleGenerator.Generate(10);
    }

    @Override
    public void render() {
        camera.adjustProjection();
        spriteRenderer.setProjectionMatrix(camera.getProjection(), camera.getViewMatrix());

        glClearColor(0.0f,0.5f,5.0f,1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        obstacleGenerator.render(spriteRenderer);
        spriteRenderer.DrawSprite(ResourceManager.get().getTexture("bird"), pos1, new Vector2f(5.0f,5.0f), 0, new Vector4f(1.0f,1.0f,1.0f,1.0f));
    }

    float speed = 250.0f;

    @Override
    public void update(double delta) {
        pos1.x+=speed*delta;
        camera.setFocusPosition(pos1);
    }

    @Override
    public void input() {

    }
}
