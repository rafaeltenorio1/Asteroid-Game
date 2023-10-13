
import java.awt.*;
import java.awt.image.BufferedImage;
public class Objetos {


    protected  double x;
    protected double y;
    protected int width;
    protected int height;
    protected BufferedImage sprite;

    public Objetos(double x,double y, int width,int height, BufferedImage sprite){

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;

    }

    public void setX (double newX){
        this.x = newX;

    }

    public void setY (double newY){
        this.y = newY;
    }

    public int getX () {
        return (int)this.x;
    }

    public int getY () {
        return (int)this.y;
    }

    public void setWidth (int newWidth){
        this.width = newWidth;

    }

    public void setHeight (int newHeight){
        this.height = newHeight;

    }

    public int getWidth () {
        return (int)this.width;
    }

    public int getHeight () {
        return (int)this.height;
    }

    public static boolean isCollidding(Objetos o1, Objetos o2){
        Rectangle o1Mask = new Rectangle(o1.getX(), o1.getY(), o1.getWidth(), o1.getHeight());
        Rectangle o2Mask = new Rectangle(o2.getX(), o2.getY(), o2.getWidth(), o2.getHeight());
        return o1Mask.intersects(o2Mask);

    }
    public void tick(){}
    public void render(Graphics g){
        g.drawImage(sprite, this.getX(), this.getY(),null);
    }

}
