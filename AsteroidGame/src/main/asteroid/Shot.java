package main.asteroid;


import main.engine.GraphicObject;

import javax.imageio.ImageIO;
import java.awt.*;

import java.io.IOException;

public class Shot extends GraphicObject {
    public Shot(int x, int y, int width, int height) {
        super(x, y, width, height);

        try {
            sprite = ImageIO.read(getClass().getResource("/res/Player/laserGreen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        }

    public void shoot(Point point) {
        px = point.x + 44;
        py = point.y - 33;
    }
}
