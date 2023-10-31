package main.asteroid;

import java.awt.*;

public class Laser {
    private int px;
    private int py;
    private int width;
    private int height;
    private LaserType type;
    private boolean visible = false;

    public Laser(int px, int py, int width, int height, LaserType type) {
        this.px = px;
        this.py = py;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public void draw (Graphics g){
        type.draw(g, px, py, width, height);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
