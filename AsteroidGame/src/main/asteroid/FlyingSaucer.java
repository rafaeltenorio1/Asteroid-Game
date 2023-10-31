package main.asteroid;

import main.engine.Engine;
import main.engine.GraphicObject;

import java.awt.*;
import java.io.IOException;

public class FlyingSaucer extends Spaceship{
    public FlyingSaucer(int x, int y, int width, int height) {
        super(x, y, width, height);
        sprite = GraphicObject.setImage("/res/Player/enemyUFO.png");
    }

    @Override
    public void moveToRight() {
        px += 2;
    }

    @Override
    public void moveToLeft() {
        px -= 2;
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
    public void update() {
        moveToRight();

        if(px < -width-10){
            px = Engine.canvas.getWidth() - width/2 + 10;
        }
        if(px > Engine.canvas.getWidth()){
            px = -(width)-10;
        }
        if(py < -5){
            translate(new Point(0, 1));
        }
        if (py > Engine.canvas.getHeight() - height){
            translate(new Point(0, -1));
        }
    }
}
