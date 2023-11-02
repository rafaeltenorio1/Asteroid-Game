package main.asteroid;

import main.asteroid.flyweight.laser.Laser;
import main.asteroid.flyweight.laser.LaserFactory;
import main.asteroid.flyweight.laser.LaserType;
import main.asteroid.flyweight.stars.Star;
import main.asteroid.flyweight.stars.StarFactory;
import main.asteroid.flyweight.stars.StarType;
import main.engine.Engine;
import main.engine.Game;


import java.awt.*;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Asteroid implements Game {
    private Player player;
    private Shot shot;
    private Brackground background;
    private FlyingSaucer enemy;
    private final List<Point> shotsPositions = new ArrayList<>();
    private final List<Boolean> shotsDisparados = new ArrayList<>();
    Laser laser;
    private final List<Star> stars = new ArrayList<>();
    private final int maxShots = 10;
    private boolean gameOver = false;

    @Override
    public void init() {
        Engine.canvas.setBackground(new Color(0x5e, 0x3f, 0x6b, 255));

        player = new Player(Engine.canvas.getWidth() / 2 - 32, Engine.canvas.getHeight() / 2, 99, 75);
        background = new Brackground(0, 0, 254, 256);
        shot = new Shot(0, 0, 9, 33);
        enemy = new FlyingSaucer(10, 10, 91, 91);

        LaserType laserType = LaserFactory.getLaserType("LaserGreen", "/res/Player/laserGreen.png");
        laser = new Laser(0, 0, 9, 33, laserType);

        StarType starBig = StarFactory.getLaserType("StarBig", "/res/Player/starBig.png");
        StarType starSmall = StarFactory.getLaserType("StarBig", "/res/Player/starSmall.png");

        for (int i = 0; i < 40; i++) {
            int x = ThreadLocalRandom.current().nextInt(0, Engine.canvas.getHeight() * 2) - Engine.canvas.getHeight();
            int y = ThreadLocalRandom.current().nextInt(0, Engine.canvas.getWidth() * 2) - Engine.canvas.getWidth();
            stars.add(new Star(x, y, 23, 21, starBig));

            x = ThreadLocalRandom.current().nextInt(0, Engine.canvas.getHeight() * 2) - Engine.canvas.getHeight();
            y = ThreadLocalRandom.current().nextInt(0, Engine.canvas.getWidth() * 2) - Engine.canvas.getWidth();
            stars.add(new Star(x, y, 11, 11, starSmall));
        }

        for (int i = 0; i < maxShots; i++) {
            shotsPositions.add(new Point(0, 0));
            shotsDisparados.add(false);
        }

        player.speed = 4;
    }

    @Override
    public void update() {
        if (gameOver) {
            return;
        }
        if (Engine.keyboard.keyDown(KeyEvent.VK_D)) {
            player.moveToRight();
        }

        if (Engine.keyboard.keyDown(KeyEvent.VK_A)) {
            player.moveToLeft();
        }

        if (Engine.keyboard.keyDown(KeyEvent.VK_W)) {
            player.moveToTop();
        }
        if (Engine.keyboard.keyDown(KeyEvent.VK_S)) {
            player.moveToDown();
        }

        if (Engine.keyboard.keyUp(KeyEvent.VK_A) && Engine.keyboard.keyUp(KeyEvent.VK_D)) {
            player.moveStop();
        }

        // Testa a vida, para ela sumir
        if (Engine.keyboard.keyPress(KeyEvent.VK_Q)) {
            player.health -= 1;
        }


        if (Engine.keyboard.keyPress(KeyEvent.VK_SPACE)) {
            //System.out.println("space");
            for (int i = 0; i < maxShots; i++) {
                if (shotsDisparados.get(i)) {
                    continue;
                } else {
                    shotsDisparados.set(i, true);
                    shotsPositions.set(i, player.attack());
                    break;
                }
            }
        }

        for (int i = 0; i < maxShots; i++) {
            if (shotsPositions.get(i).y < -40) {
                shotsDisparados.set(i, false);
            }
            if (shotsDisparados.get(i)) {
                shotsPositions.get(i).translate(0, -10);
            }

        }

        background.update();
        player.update();
        enemy.update();
        for (Star star : stars) {
            star.update();
        }
    }

    @Override
    public void draw() {
        Graphics graphics = Engine.canvas.getBufferStrategy().getDrawGraphics();
        laser.draw(graphics);

        for (Star star : stars) {
            star.draw(graphics);
        }

        //background.draw(graphics);
        player.draw(graphics);
        enemy.draw(graphics);

        for (int i = 0; i < maxShots; i++) {

            if (shotsDisparados.get(i)) {
                //System.out.println("Desenha tiro: " + i + " na posição " + shotsPositions.get(i));
                shot.shoot(shotsPositions.get(i));
                shot.draw(graphics);

            }

        }

        Font fonte = new Font("Arial", Font.PLAIN, 24);
        graphics.setFont(fonte);

        // Definindo a cor do texto
        graphics.setColor(Color.BLACK);

        //for(int i = 0; i < player.health; i++){
        //    graphics.drawImage(player.spriteHealth, 463 - (i*34), 10,null);
        //}

        if (gameOver) {
            graphics.setFont(new Font("arial", Font.BOLD, 56));
            graphics.setColor(Color.black);
            graphics.drawString("GAME OVER", 100, 250);
            graphics.setFont(new Font("arial", Font.BOLD, 30));
            graphics.setColor(Color.black);
            graphics.drawString("Pressione 'ENTER' para reiniciar", 30, 280);
        }


    }

    @Override
    public void end() {

    }
}
