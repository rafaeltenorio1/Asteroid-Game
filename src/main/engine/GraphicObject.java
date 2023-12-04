package main.engine;




import main.asteroid.Player;
import main.spaceships.Spaceship;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public abstract class GraphicObject {
    protected BufferedImage sprite;
    protected int px, py, width, height;
    public int speed = 1;
    public GraphicObject(int x, int y, int width, int height) {
        this.px = x;
        this.py = y;
        this.width = width;
        this.height = height;
    }

    public static BufferedImage setImage(String pathname) {
        BufferedImage i = null;
        try {
            i = ImageIO.read(Objects.requireNonNull(Player.class.getResource(pathname)));
            return i;
        } catch (IOException e){
            e.printStackTrace();
        }
        return i;

    }

    public void translate(Point point) {
        px += point.x * speed;
        py += point.y * speed;
    }

    public abstract void update();

    public void draw(Graphics2D g){
        if (sprite == null){
            throw new NullPointerException();
        }
        g.drawImage(sprite, px, py, width, height, null);


        g.drawImage(GraphicObject.setImage("/res/Player/shield3.png"), px - 26, py - 30, width + 50, height + 50, null);



    }

    public Point getPosition(){
        return new Point(px, py);
    }

}
