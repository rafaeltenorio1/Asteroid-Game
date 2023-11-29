package main.asteroid.flyweight.laser;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LaserType {
    private String name;
    private BufferedImage sprite;

    public LaserType(String name, BufferedImage sprite) {
        this.name = name;
        this.sprite = sprite;
    }

    public void draw(Graphics g, int px, int py, int width, int height) {
        g.drawImage(sprite, px, py, width, height, null);
    }
}
