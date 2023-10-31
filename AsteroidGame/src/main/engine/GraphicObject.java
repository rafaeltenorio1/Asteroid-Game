package main.engine;




import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class GraphicObject {
    protected BufferedImage sprite;
    protected int px, py, width, height;
    public int speed = 1;
    public GraphicObject(int x, int y, int width, int height) {
        this.px = x;
        this.py = y;
        this.width = width;
        this.height = height;
    }

    public void translate(Point point) {
        px += point.x * speed;
        py += point.y * speed;
    }

    public abstract void update();

    public void draw(Graphics g){
        g.drawImage(sprite, px, py, width, height, null);
    }


}
