package main.spaceships;

import main.engine.Engine;
import main.engine.GraphicObject;

import java.awt.*;

public abstract class Spaceship extends GraphicObject {
    protected int speed = 0;
    protected int health = 3;
    protected int damage = 0;

    public Spaceship(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void moveToRight(){
        translate(new Point(speed, 0));
    }

    public void moveToLeft(){
        translate(new Point(-speed, 0));
    }

    public void moveToTop() {
        translate(new Point(0, -speed));
    }

    public void moveToDown() {
        translate(new Point(0, speed));;
    }

    @Override
    public void update() {

        if(px < -(width/2)-10){
            px = Engine.canvas.getWidth() - width/2 + 10;
        }
        if(px > Engine.canvas.getWidth() - width/2 + 10){
            px = -(width/2)-10;
        }
        if(py < -5){
            translate(new Point(0, 1));
        }
        if (py > Engine.canvas.getHeight() - height){
            translate(new Point(0, -1));
        }

    }

    public int getHealth() {
        return health;
    }
    public int getDamage(){
        return damage;
    }
}
