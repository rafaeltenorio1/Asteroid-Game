package old.entity;
import old.Game;

import java.awt.image.BufferedImage;

public abstract class Entity {

    Game gp;
    public int x, y;
    public int speed;

    public BufferedImage player;
    public BufferedImage shot;

    public abstract void draw();
    public abstract void translate(int dx, int dy);


    public Entity(Game gp) {
        this.gp = gp;
    }
}