package main.asteroid;

import main.engine.GraphicObject;

import java.awt.*;

public interface Spaceship {

    void moveToRight();

    void moveToLeft();

    void moveToTop();

    void moveToDown();

    void moveStop();

    Point attack();
}
