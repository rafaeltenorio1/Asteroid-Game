package main.asteroid;

import main.engine.Engine;
import main.engine.GraphicObject;
import main.spaceships.Spaceship;

public class FlyingSaucer extends Spaceship {
    public FlyingSaucer(int x, int y, int width, int height) {
        super(x, y, width, height);
        sprite = GraphicObject.setImage("/res/Player/enemyUFO.png");
        speed = 1;
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
