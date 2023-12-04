package main.asteroid;


import main.engine.Engine;
import main.engine.GraphicObject;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Shot extends GraphicObject {
    BufferedImage sprite_right = GraphicObject.setImage("/res/Player/laserGreen_right.png");
    BufferedImage sprite_left = GraphicObject.setImage("/res/Player/laserGreen_left.png");
    public Shot(int x, int y, int width, int height) {
        super(x, y, width, height);

        sprite = GraphicObject.setImage("/res/Player/laserGreen.png");

    }

    private boolean sideShot = false;
    private boolean middleShot = true;

    @Override
    public void update() {
        }

    public void shoot(Point point) {
        px = point.x + 44;
        py = point.y - 33;
    }

    public void draw(Graphics2D g){
        if (sprite == null){
            throw new NullPointerException();
        }


        if (middleShot){
            g.drawImage(sprite, px, py, width, height, null);
        }

        if (sideShot) {
            g.drawImage(sprite, px - 25, py+45, width, height, null);
            g.drawImage(sprite, px+25, py+45, width, height, null);
        }
    }

    public void setSideShot(boolean sideShot) {
        this.sideShot = sideShot;
    }

    public void setMiddleShot(boolean middleShot) {
        this.middleShot = middleShot;
    }
}
