package example.flappybird;

import engine.renderer.SpriteRenderer;
import org.joml.Vector2f;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleGenerator {

    private ArrayList<PipeObstacle> obstacles = new ArrayList<PipeObstacle>();

    private int size = 256;
    private int spacing = 3;
    public ObstacleGenerator() {

    }

    public void render(SpriteRenderer spriteRenderer) {
        for (int i = 0; i < obstacles.size(); i++) {
            obstacles.get(i).render(spriteRenderer);
        }
    }
    public void addObstacle(int height) {

        Vector2f position = new Vector2f(0,0);
        if(obstacles.size() > 0) {
            Vector2f lastPositionOfObstacle = obstacles.get(obstacles.size()-1).getPosition();
            position = new Vector2f(size * spacing,0.0f).add(lastPositionOfObstacle);

        }
        PipeObstacle pipeObstacle = new PipeObstacle(position, 14,height,2);

        obstacles.add(
                pipeObstacle
        );
    }

    private int min = 2;
    private int max = 5;

    public void Generate(int amount) {
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            int height = random.nextInt((max - min) + 1) + min;
            addObstacle(height);
        }
    }
}
