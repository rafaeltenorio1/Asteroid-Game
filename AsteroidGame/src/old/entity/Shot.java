package old.entity;

import old.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Shot extends Entity {

    public int x = Player.x + 27;
    public int y = Player.y - 25;


    @Override
    public void draw() {

    }

    @Override
    public void translate(int dx, int dy) {

    }

    public Shot(Game gp){
        super(gp);
        speed = 5;
        getImage();

    }

    public void getImage(){
        try {
            shot = ImageIO.read(getClass(). getResourceAsStream("/res/Player/laserBlue02.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void tick(){
        if(Player.shoting){
            y -= speed;
            if(y <= 0){
                y = Player.y - 23;
                Player.shoting = false;

            }

        }


    }

    public void draw(Graphics g){

        BufferedImage image = shot;
        g.drawImage(image, x, y,10,25, null );


    }

}
