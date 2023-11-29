package main.asteroid;

import main.engine.Engine;
import main.engine.GraphicObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends GraphicObject  {


    private Spaceship spaceship;
    private BufferedImage playerStop;
    private BufferedImage playerHealth;
    private BufferedImage playerScore;


    public void start(Spaceship spaceship){
        this.spaceship = spaceship;
    }

    public int score = 0;
    public int health = spaceship.health();
    public int maxHealth = spaceship.maxHealth();
    public int speed = spaceship.speed();
    private int damage = spaceship.damage();

    enum Directions {
        STOP,
        LEFT,
        RIGHT;

    }

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);

        try{
            playerStop = GraphicObject.setImage(spaceship.spriteStop());
            playerHealth = ImageIO.read(getClass().getResource("/res/Player/playerLife1_red.png"));
            playerScore = ImageIO.read(getClass().getResource("/res/Player/star_gold.png"));
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
        translate(new Point(speed, 0));
        sprite = spaceship.spriteToRight();
    }

    public void moveToLeft(){
        translate(new Point(-speed, 0));
        sprite = spaceship.spriteToLeft();
    }

    public void moveToTop() {
        translate(new Point(0, -speed));
        sprite = playerStop;
    }

    public void moveToDown() {
        translate(new Point(0, speed));;
        sprite = playerStop;
    }

    public void moveStop() {
        sprite = playerStop;
    }

    public Point attack(){
        return new Point(px, py);
    }

    public BufferedImage life(){
        return playerHealth;
    }
    public BufferedImage score(){
        return playerScore;
    }
}
