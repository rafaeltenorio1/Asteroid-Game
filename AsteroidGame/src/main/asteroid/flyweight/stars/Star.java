package main.asteroid.flyweight.stars;

import main.engine.Engine;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Star {
    private int px;
    private int py;
    private int width;
    private int height;
    private int speed = 1;
    private StarType type;
    private boolean visible = false;

    public Star(int px, int py, int width, int height, StarType type) {
        this.px = px;
        this.py = py;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public void update(){
        if (py > Engine.canvas.getHeight()) {
            py = -1 * ThreadLocalRandom.current().nextInt(0, Engine.canvas.getHeight() * 2);
            px = ThreadLocalRandom.current().nextInt(0, Engine.canvas.getWidth());
            speed = ThreadLocalRandom.current().nextInt(1, 3);
        } else {
            py += speed;
        }
    }

    public void draw (Graphics g) {
        type.draw(g, px, py, width, height);
    }
}
