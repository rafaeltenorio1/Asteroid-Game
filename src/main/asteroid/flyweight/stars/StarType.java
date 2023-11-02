package main.asteroid.flyweight.stars;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StarType {
    private final String name;
    private final BufferedImage sprite;

    public StarType(String name, BufferedImage sprite) {
        this.name = name;
        this.sprite = sprite;
    }

    public void draw(Graphics g, int px, int py, int width, int height) {
        g.drawImage(sprite, px, py, width, height, null);
    }
}
