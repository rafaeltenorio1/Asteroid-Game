package main.asteroid;

import main.engine.Engine;
import main.engine.GraphicObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Brackground extends GraphicObject {
    public Brackground(int x, int y, int width, int height) {
        super(x, y, width, height);

        try{
            sprite = ImageIO.read(getClass().getResource("/res/Player/starBackground.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        py += 10;

        if (py > Engine.canvas.getHeight()) {
            py = -256;
            px = ThreadLocalRandom.current().nextInt(0, Engine.canvas.getWidth());
        }
    }
}
