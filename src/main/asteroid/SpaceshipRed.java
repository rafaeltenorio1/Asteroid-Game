package main.asteroid;

import main.engine.GraphicObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpaceshipRed implements Spaceship {
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private int maxHealth = 3;
    private int health = 3;
    private int speed = 1;
    private int damage = 10;



    @Override
    public int maxHealth() {
        return maxHealth;
    }

    @Override
    public int health() {
        return health;
    }

    @Override
    public int speed() {
        return speed;
    }

    @Override
    public int damage() {
        return damage;
    }

    public void moveToRight() {

    }

    public void moveToLeft() {

    }

    public void moveToTop() {

    }

    public void moveToDown() {

    }

    public void moveStop() {

    }

    @Override
    public BufferedImage spriteToRight() {
        try{
            playerRight = ImageIO.read(getClass().getResource("/res/Player/playerRight.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
        return playerRight;
    }

    @Override
    public BufferedImage spriteToLeft() {
        try{
            playerLeft = ImageIO.read(getClass().getResource("/res/Player/playerLeft.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
        return playerLeft;
    }

    @Override
    public String spriteStop() {

        return "/res/Player/player.png";
    }

    @Override
    public Point attack() {
        return null;
    }
}
