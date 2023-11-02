package main.asteroid.flyweight.laser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LaserFactory {
    static Map<String, LaserType> laserTypes = new HashMap<>();

    public static LaserType getLaserType(String name, String pathname) {
        LaserType result = laserTypes.get(name);

        BufferedImage sprite = null;
        try{
            sprite = ImageIO.read(LaserFactory.class.getResource(pathname));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (result == null) {
            result = new LaserType(name, sprite);
            laserTypes.put(name, result);
        }

        return result;
    }
}
