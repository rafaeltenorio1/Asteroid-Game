package main.asteroid;

import main.engine.GraphicObject;
import main.spaceships.Spaceship;
import main.spaceships.SpaceshipBlue;
import main.spaceships.SpaceshipGreen;
import main.spaceships.SpaceshipRed;

import java.awt.*;

public class Player {
    private Spaceship spaceship;
    private int health;
    private int x, y, height, width;
    private boolean side = true;


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
                health = spaceship.getHealth();
            break;
            case BLUE: spaceship = new SpaceshipBlue(x, y, width, height);
                health = spaceship.getHealth();
            break;
            case GREEN: spaceship = new SpaceshipGreen(x, y, width, height);
                health = spaceship.getHealth();
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

    public void draw(Graphics2D g){
        spaceship.draw(g);

    }

    public int getHealth() {
        return health;
    }

    public Point attack(){
        side = !side;

        return spaceship.getPosition();
    }

    public boolean getShield(){
        return spaceship.getShield();
    }
    public void setShield(boolean value){
        spaceship.setShield(value);
    }
    public int getDamage(){
        return spaceship.getDamage();
    }
}
