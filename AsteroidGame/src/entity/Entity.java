package entity;
import main.Game;

import java.awt.image.BufferedImage;

public class Entity {

    Game gp;
    public int x, y;
    public int speed;

    public BufferedImage player;
    public BufferedImage shot;


    public Entity(Game gp) {
        this.gp = gp;
    }
}