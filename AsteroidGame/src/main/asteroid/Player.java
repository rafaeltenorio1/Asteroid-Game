package main.asteroid;

import main.engine.Engine;
import main.engine.GraphicObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends GraphicObject {
    public int health = 3;
    protected BufferedImage spriteHealth;
    public BufferedImage sprite, spriteLeft, spriteRight;
    public String direction = "stop";
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);

        pathname = "/res/Player/player.png";
        playerLeft = "/res/Player/playerLeft.png";
        playerRight = "/res/Player/playerRight.png";


        try{
            spriteHealth = ImageIO.read(getClass().getResource("/res/Player/playerLife1_red.png"));
            spriteLeft = ImageIO.read(getClass().getResource(playerLeft));
            spriteRight = ImageIO.read(getClass().getResource(playerRight));
            sprite = ImageIO.read(getClass().getResource(pathname));

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



    public Point attack(){
        return new Point(getX(), getY());
    }
}
