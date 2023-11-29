package main.asteroid;

import main.engine.Engine;
import main.engine.GraphicObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FlyingSaucer extends GraphicObject implements Spaceship {
    public FlyingSaucer(int x, int y, int width, int height) {
        super(x, y, width, height);
        sprite = GraphicObject.setImage("/res/Player/enemyUFO.png");
    }

    @Override
    public int maxHealth() {
        return 0;
    }

    @Override
    public int health() {

        return 0;
    }

    @Override
    public int speed() {
        return 0;
    }

    @Override
    public int damage() {
        return 0;
    }

    @Override
    public void moveToRight() {
        px += 2 * speed;
    }

    @Override
    public void moveToLeft() {
        px -= 2 * speed;
    }

    @Override
    public void moveToTop() {

    }

    @Override
    public void moveToDown() {

    }

    @Override
    public void moveStop() {

    }

    @Override
    public BufferedImage spriteToRight() {
        return null;
    }

    @Override
    public BufferedImage spriteToLeft() {
        return null;
    }

    @Override
    public String spriteStop() {
        return null;
    }

    @Override
    public Point attack() {
        return null;
    }

    @Override
    public void update() {
        if (px < Engine.canvas.getWidth()) {
            moveToRight();
        }
        if (px > Engine.canvas.getWidth() - width) {
            speed = -1;
        }
        if (px <= 0) {
            speed = 1;
        }
    }
}
