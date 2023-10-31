package main.asteroid;

import main.engine.GraphicObject;

import java.awt.*;

public abstract class Spaceship extends GraphicObject {
    public Spaceship(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public abstract void moveToRight();
    public abstract void moveToLeft();
    public  abstract void moveToTop() ;
    public abstract void moveToDown();
    public abstract void moveStop();

    public Point attack(){
        return new Point(px, py);
    }
}
