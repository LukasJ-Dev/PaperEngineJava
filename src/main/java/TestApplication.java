import engine.IApplication;
import engine.InputManager;

import engine.Window;

import java.util.Random;

import static org.lwjgl.glfw.GLFW.*;

public class TestApplication implements IApplication {

    @Override
    public void init() {
        GenerateTargetColor();
    }

    public void GenerateTargetColor() {
        Random r = new Random();
        float min = 0.0f;
        float max = 1.0f;
        t_red = min + r.nextFloat() * (max - min);

        t_green = min + r.nextFloat() * (max - min);

        t_blue = min + r.nextFloat() * (max - min);
    }

    private float red = 0.0f, green = 0.0f, blue = 0.0f, alpha = 0.0f;
    private float t_red = 0.0f, t_green = 0.0f, t_blue = 0.0f, t_alpha = 0.0f;

    @Override
    public void render() {

        Window.get().clearColor(red, green, blue, alpha);
    }

    @Override
    public void update(double deltaTime) {

        if(false) {
            double posX = InputManager.get().GetCursorPosition().x;
            double posY = InputManager.get().GetCursorPosition().y;
            int width = Window.get().GetWidth();
            int height = Window.get().GetHeight();

            red = (float) (posX / width);
            green = (float) (posY / height);
            blue = (float) ((posX / width) + (posY / height)) / 2;


            System.out.println((posX / width) + ", " + (posY / height));
        }
        if(false) {
        if(t_red < red) {
            red -= 0.005f;
        } else if(t_red > red) {
            red += 0.005f;
        }

        if(t_green < green) {
            green -= 0.005f;
        } else if(t_green > green) {
            green += 0.005f;
        }

        if(t_blue < blue) {
            blue -= 0.005f;
        } else if(t_blue > blue) {
            blue += 0.005f;
        }

        if(
                (t_red + 0.01f > red && t_red - 0.01f < red) &&

                        (t_green + 0.01f > green && t_green - 0.01f < green) &&

                        (t_green + 0.01f > green && t_green - 0.01f < green)
        ) {
            GenerateTargetColor();
        }
        }
    }

    boolean press = false;

    @Override
    public void input() {
        if(InputManager.get().isKeyPressed(GLFW_KEY_W)) {
            red+=0.01f;
        }
        if(InputManager.get().isKeyPressed(GLFW_KEY_S)) {
            red-=0.01f;
        }
        if(InputManager.get().isKeyPressed(GLFW_KEY_I)) {
            green+=0.01f;
        }
        if(InputManager.get().isKeyPressed(GLFW_KEY_K)) {
            green-=0.01f;
        }
        if(InputManager.get().isKeyPressed(GLFW_KEY_UP)) {
             blue+=0.01f;
        }
        if(InputManager.get().isKeyPressed(GLFW_KEY_DOWN)) {
            blue-=0.01f;
        }
        if(InputManager.get().isKeyPressed(GLFW_KEY_R)) {
            red = 0.0f;
            blue = 0.0f;
            green = 0.0f;
        }
        if(InputManager.get().isKeyPressed(GLFW_KEY_V) && !press) {
            Random r = new Random();
            float min = 0.0f;
            float max = 1.0f;
            red = min + r.nextFloat() * (max - min);

            green = min + r.nextFloat() * (max - min);

            blue = min + r.nextFloat() * (max - min);
            press = true;
        } else if(!InputManager.get().isKeyPressed(GLFW_KEY_V)) {
            press = false;
        }
    }
}
