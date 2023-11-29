package main.asteroid;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpaceshipGreen implements Spaceship{

    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private int maxHealth = 5;
    private int health = 5;
    private int speed = 1;
    private int damage = 20;

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

    @Override
    public void moveToRight() {

    }

    @Override
    public void moveToLeft() {

    }

    @Override
    public void moveToTop() {

    }

    @Override
    public void moveToDown() {

    }

    @Override
    public void moveStop() {

    }

    @Override
    public BufferedImage spriteToRight() {
        return null;
    }

    @Override
    public BufferedImage spriteToLeft() {
        return null;
    }

    @Override
    public String spriteStop() {
        return "/res/PlayerplayerShip3_green.png";
    }

    @Override
    public Point attack() {
        return null;
    }
}
