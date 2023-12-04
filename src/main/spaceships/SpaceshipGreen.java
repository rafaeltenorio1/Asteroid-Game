package main.spaceships;

import main.engine.GraphicObject;

public class SpaceshipGreen extends Spaceship{
    public SpaceshipGreen(int x, int y, int width, int height) {
        super(x, y, width, height);
        sprite = GraphicObject.setImage("/res/Player/playerShip3_green.png");
        speed = 1;
        health = 4;
    }
}
