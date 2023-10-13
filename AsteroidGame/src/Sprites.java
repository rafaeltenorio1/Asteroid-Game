import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprites {

    private BufferedImage sprites;

    public Sprites(String path) throws IOException {
        try {
            sprites = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedImage getSprites(int x, int y, int width, int height ){
         return sprites.getSubimage(x, y, width, height);
    }

}
