package main.asteroid;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface Spaceship {
    int maxHealth();
    int health();

    int speed();

    int damage();
    void moveToRight();

    void moveToLeft();

    void moveToTop();

    void moveToDown();

    void moveStop();

    BufferedImage spriteToRight();
    BufferedImage spriteToLeft();
    String spriteStop();

    Point attack();
}
