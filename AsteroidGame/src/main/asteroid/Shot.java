package main.asteroid;

import main.engine.Engine;
import main.engine.GraphicObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Shot extends GraphicObject {
    public boolean atirou = false;
    public BufferedImage sprite;

    public Shot(int x, int y, int width, int height) {
        super(x, y, width, height);
        pathname = "/res/Player/laserGreen.png";

        try{
            sprite = ImageIO.read(getClass().getResource(pathname));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        if (atirou) {
            py -= 10;
            if (py < -40) {
                atirou = false;
                System.out.println(atirou);
            }
        }


    }

    public void shoot(Point point) {
        setX(point.x + 44       );
        setY(point.y - 33);
    }
}
