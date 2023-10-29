package old.entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spaceship extends Entity2 {
    private BufferedImage sprite;
    private final Graphics graphics;
    private final int width, height;
    public Spaceship(Graphics g, int x, int y, int width, int height, String pathname) {
        this.graphics = g;
        setX(x);
        setY(y);
        this.width = width;
        this.height = height;


        try{
            this.sprite = ImageIO.read(getClass().getResource(pathname));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void draw() {
        graphics.drawImage(sprite, x, y, width, height, null);
    }

    @Override
    public void update() {

    }
}
