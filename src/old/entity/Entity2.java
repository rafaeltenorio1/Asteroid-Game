package old.entity;

public abstract class Entity2 {
    protected int x,y, width, height, right, bottom;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x ;
        this.right = x + this.width;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.bottom = y + this.height;
    }

    public void traslate(int dx, int dy){
        x += dx;
        y += dy;
    };
    public abstract void update();
    public abstract void draw();



}
