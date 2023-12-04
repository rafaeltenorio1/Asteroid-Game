package main.spaceships;

import main.engine.GraphicObject;

public class SpaceshipRed extends Spaceship{
    public SpaceshipRed(int x, int y, int width, int height) {
        super(x, y, width, height);
        sprite = GraphicObject.setImage("/res/Player/player.png");
        speed = 3;
        health = 3;
    }
}
