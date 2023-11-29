package old.entity;

import old.Game;
import old.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    Game gp;
    KeyHandler keys;
    public static int x = 450, y = 400, speed = 4;
    public static boolean shoting = false;


    public Player(Game gp, KeyHandler keys){

        super (gp);

        this.gp = gp;
        this.keys = keys;
        getPlayerImage();
    }




    public void getPlayerImage(){
        try {
            player = ImageIO.read(getClass(). getResourceAsStream("/res/Player/playerShip2_blue.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void tick(){
        if(keys.right){
            x += speed;
        }
        if (keys.left){
            x -= speed;
        }
        if(keys.up){
            y -= speed;

        }
        if (keys.down){
            y += speed;


        }
        if (x >= Game.width*Game.scale){
            x = -30;

        }
        else if (x  < -50){
            x = Game.width*Game.scale - 30;
        }

    }

    public void draw(Graphics g){

        BufferedImage image = player;
        g.drawImage(image, x, y,64,64, null );


    }

    @Override
    public void draw() {

    }

    @Override
    public void translate(int dx, int dy) {

    }
}
