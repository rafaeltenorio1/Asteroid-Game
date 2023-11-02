package tile;

import old.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager extends Tile {

    Game gp;

    public TileManager(Game gp){

        this.gp = gp;
        getTileImage();

    }

    public void getTileImage(){

        try{

            tile = ImageIO.read(getClass().getResourceAsStream("/res/tiles/blue.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        g.drawImage(tile, 0, 0, null);
        g.drawImage(tile, 0, 255, null);
        g.drawImage(tile, 255, 0, null);
        g.drawImage(tile, 255, 255, null);
        g.drawImage(tile, 765, 0, null);
        g.drawImage(tile, 510, 0, null);
        g.drawImage(tile, 0, 510, null);
        g.drawImage(tile, 510, 510, null);
        g.drawImage(tile, 510, 255, null);
        g.drawImage(tile, 255, 510, null);
        g.drawImage(tile, 510, 765, null);
        g.drawImage(tile, 765, 255, null);
        g.drawImage(tile, 765, 510, null);



    }

}
