package example.flappybird;

import engine.manager.ResourceManager;
import engine.renderer.SpriteRenderer;
import org.joml.Vector2f;
import org.joml.Vector4f;

public class PipeObstacle {

    private int pipeHeight = 10;
    private int height = 2;
    private Vector2f position;
    private int gap = 2;

    private Vector2f scale = new Vector2f(8.0f,8.0f);

    private int size = 128;

    public PipeObstacle(Vector2f position, int pipeHeight, int height, int gap) {
        this.position = position;
        this.pipeHeight = pipeHeight;
        this.height = height;
        this.gap = gap;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void render(SpriteRenderer spriteRenderer) {
        for (int i = 0; i < height; i++) {
            spriteRenderer.DrawSprite(
                    ResourceManager.get().getTexture("pipe"),
                    new Vector2f(position.x,position.y+(i*size)),
                    scale, 0, new Vector4f(1.0f,1.0f,1.0f,1.0f)
            );
        }
        spriteRenderer.DrawSprite(
                ResourceManager.get().getTexture("pipetop"),
                new Vector2f(position.x,position.y+((height-0.125f)*size)),
                scale, 0, new Vector4f(1.0f,1.0f,1.0f,1.0f)
        );

        spriteRenderer.DrawSprite(
                ResourceManager.get().getTexture("pipetop"),
                new Vector2f(position.x,position.y+((height+gap+1.125f)*size)),
                scale, 180, new Vector4f(1.0f,1.0f,1.0f,1.0f)
        );

        for (int i = height+gap+2; i < pipeHeight-1; i++) {
            spriteRenderer.DrawSprite(
                    ResourceManager.get().getTexture("pipe"),
                    new Vector2f(position.x,position.y+(i*size)),
                    scale, 0, new Vector4f(1.0f,1.0f,1.0f,1.0f)
            );
        }


    }


}
