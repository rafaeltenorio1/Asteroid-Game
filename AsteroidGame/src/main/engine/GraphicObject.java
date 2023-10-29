package main.engine;

import main.asteroid.Asteroid;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class GraphicObject {
    protected BufferedImage sprite;
    protected int px, py, width, height, right, bottom;
    protected String pathname, playerLeft, playerRight = "";
    public int speed = 1;
    public GraphicObject(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        this.width = width;
        this.height = height;
    }



    public int getX() {
        return px;
    }

    public void setX(int x) {
        this.px = x;
        this.right = x + this.width;
    }

    public int getY() {
        return py;
    }

    public void setY(int y) {
        this.py = y;
        this.bottom = y + this.height;
    }

    public void translate(Point point) {
        px += point.x * speed;
        py += point.y * speed;
    }

    public abstract void update();

    public void draw(Graphics g, BufferedImage i){
        g.drawImage(i, px, py, width, height, null);
    }


}
