package main.asteroid;

import main.spaceships.Spaceship;
import main.spaceships.SpaceshipBlue;
import main.spaceships.SpaceshipGreen;
import main.spaceships.SpaceshipRed;

import java.awt.*;

public class Player {
    private Spaceship spaceship;
    private int health;
    private int x, y, height, width;

    public enum Spaceships{
        RED,
        BLUE,
        GREEN
    }

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        spaceship = new SpaceshipRed(x, y, width, height);
        health = spaceship.getHealth();
    }

    public void setShip(Spaceships type){
        switch (type){
            case RED: spaceship = new SpaceshipRed(x, y, width, height);
            break;
            case BLUE: spaceship = new SpaceshipBlue(x, y, width, height);
            break;
            case GREEN: spaceship = new SpaceshipGreen(x, y, width, height);
        }
    }

    public void moveToRight(){
        spaceship.moveToRight();
    }
    public void moveToLeft(){
        spaceship.moveToLeft();
    }
    public void moveToTop(){
        spaceship.moveToTop();
    }
    public void moveToDown(){
        spaceship.moveToDown();
    }

    public void update(){
        spaceship.update();
    }

    public void draw(Graphics g){
        spaceship.draw(g);
    }

    public int getHealth() {
        return health;
    }

    public Point attack(){
        return new Point(x, y);
    }
}
