package main.spaceships;

import main.engine.GraphicObject;

public class SpaceshipBlue extends Spaceship{
    public SpaceshipBlue(int x, int y, int width, int height) {
        super(x, y, width, height);
        sprite = GraphicObject.setImage("/res/Player/playerShip2_blue.png");
        speed = 4;
        health = 3;
    }
}
