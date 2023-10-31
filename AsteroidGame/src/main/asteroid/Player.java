package main.asteroid;

import main.engine.Engine;
import main.engine.GraphicObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Spaceship {

    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private BufferedImage playerStop;
    private BufferedImage spriteHealth;

    enum Directions {
        STOP,
        LEFT,
        RIGHT
    }

    public int health = 3;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);

        try{
            playerStop = GraphicObject.setImage("/res/Player/player.png");
            playerRight = ImageIO.read(getClass().getResource("/res/Player/playerRight.png"));
            playerLeft = ImageIO.read(getClass().getResource("/res/Player/playerLeft.png"));
            sprite = playerStop;
        }catch (IOException e){
            e.printStackTrace();
        }

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

    public void moveToRight(){
        translate(new Point(1, 0));
        sprite = playerRight;
    }

    public void moveToLeft(){
        translate(new Point(-1, 0));
        sprite = playerLeft;
    }

    public void moveToTop() {
        translate(new Point(0, -1));
        sprite = playerStop;
    }

    public void moveToDown() {
        translate(new Point(0, 1));
        sprite = playerStop;
    }

    public void moveStop() {
        sprite = playerStop;
    }

    public Point attack(){
        return new Point(px, py);
    }
}
