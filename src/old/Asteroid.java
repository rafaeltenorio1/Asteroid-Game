package old;

import old.entity.Entity2;
import old.entity.Spaceship;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Asteroid extends Game2 {

    private Entity2 player;
    private static int i;
    @Override
    public void init() {
        player = new Spaceship(Game2.graphics,20,20,64,64, "/res/Player/playerShip2_blue.png");
    }

    @Override
    public void update() {
        if (window.keyDown(KeyEvent.VK_SPACE)) {
            System.out.println(i++);
        };
        player.traslate(1, 1);
    }

    @Override
    public void draw() {
        Game2.graphics.setColor(Color.white);
        player.draw();
    }

    @Override
    public void end() {

    }
}
