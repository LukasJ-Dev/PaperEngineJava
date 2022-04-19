package example.flappybird;

import engine.IApplication;
import engine.KeyCode;
import engine.PaperEngine;
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
    private ObstacleGenerator obstacleGenerator;

    @Override
    public void init() {
        ResourceManager.get().setTexture("bird", new Texture("PaperEngineGames/assets/flappybird/bird_wingdown.png"));
        ResourceManager.get().setTexture("bird2", new Texture("PaperEngineGames/assets/flappybird/bird_wingup.png"));
        ResourceManager.get().setTexture("pipe", new Texture("PaperEngineGames/assets/flappybird/pipe_middle.png"));
        ResourceManager.get().setTexture("pipetop", new Texture("PaperEngineGames/assets/flappybird/pipe_top.png"));
        camera = new Camera(new Vector2f());


        spriteRenderer = new SpriteRenderer();

        obstacleGenerator = new ObstacleGenerator();
        obstacleGenerator.Generate(10);
    }

    String birdTexture = "bird";

    @Override
    public void render() {
        camera.adjustProjection();
        spriteRenderer.setProjectionMatrix(camera.getProjection(), camera.getViewMatrix());

        glClearColor(0.0f,0.5f,5.0f,1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        obstacleGenerator.render(spriteRenderer);
        spriteRenderer.DrawSprite(ResourceManager.get().getTexture(birdTexture), pos1, new Vector2f(5.0f,5.0f), rotate, new Vector4f(1.0f,1.0f,1.0f,1.0f));
    }

    float speed = 250.0f;

    float rotate = 0;

    float timer = 0;

    boolean press = false;
    float fly = 0.0f;



    @Override
    public void update(double delta) {
        camera.setFocusPosition(pos1);
        pos1.y -= speed * delta;
        pos1.x += speed * delta;
        if(PaperEngine.input.isKeyPressed(KeyCode.PAPER_KEY_SPACE)) {
            pos1.y+=speed*delta;
        }


/*
        if((pos1.x+128.0f) % (256.0f * 3.0f) < 64) {
            System.out.println("hello: " + Math.round((pos1.x) / (256.0f * 3.0f)));
        }*/
    }

    @Override
    public void input() {

    }
}
