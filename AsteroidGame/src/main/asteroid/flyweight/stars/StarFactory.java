package main.asteroid.flyweight.stars;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StarFactory {
    static Map<String, StarType> laserTypes = new HashMap<>();

    public static StarType getStarType(String name, String pathname) {
        StarType result = laserTypes.get(name);

        BufferedImage sprite = null;
        try{
            sprite = ImageIO.read(StarFactory.class.getResource(pathname));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (result == null) {
            result = new StarType(name, sprite);
            laserTypes.put(name, result);
        }

        return result;
    }
}
