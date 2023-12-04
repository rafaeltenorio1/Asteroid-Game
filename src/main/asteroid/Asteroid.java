package main.asteroid;

import main.asteroid.flyweight.stars.Star;
import main.asteroid.flyweight.stars.StarFactory;
import main.asteroid.flyweight.stars.StarType;
import main.engine.Engine;
import main.engine.Game;
import main.engine.GraphicObject;
import main.spaceships.Spaceship;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;


public class Asteroid implements Game {
    private Player player;
    private Shot shot;
    private Store store;
    private int score = 0;
    private int health = 0;
    public String GameState = "run";
    private Brackground background;
    private FlyingSaucer enemy;
    private final List<Point> shotsPositions = new ArrayList<>();
    private final List<Boolean> shotsDisparados = new ArrayList<>();
    private final List<Star> stars = new ArrayList<>();
    private final int maxShots = 10;
    private boolean gameOver = false;
    private boolean options = false;
    private BufferedImage lifeImage;
    private  BufferedImage starScore;


    @Override
    public void init() {
        Engine.canvas.setBackground(new Color(0x5e, 0x3f, 0x6b, 255));

        store = new Store();
        player = new Player(Engine.canvas.getWidth() / 2 - 32, Engine.canvas.getHeight() / 2, 99, 75);
        background = new Brackground(0, 0, 254, 256);
        shot = new Shot(0, 0, 9, 33);
        enemy = new FlyingSaucer(10, 10, 91, 91);

        lifeImage = GraphicObject.setImage("/res/Player/playerLife1_red.png");
        starScore = GraphicObject.setImage("/res/Player/star_gold.png");

        health = player.getHealth();

        StarType starBig = StarFactory.getStarType("StarBig", "/res/Player/starBig.png");
        StarType starSmall = StarFactory.getStarType("StarSmall", "/res/Player/starSmall.png");

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

    }

    @Override
    public void update() {
        if (!gameOver) {
            if (GameState == "run") {

                gameOver = false;

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
                if (player.getHealth() == 0) {
                    gameOver = true;
                }
                if (Engine.keyboard.keyPress(KeyEvent.VK_X)) {
                    System.out.println(gameOver);
                }

                // Testa a vida, para ela sumir
                if (Engine.keyboard.keyPress(KeyEvent.VK_Q)) {
                    health -= 1;
                }
                // Testar o score
                if (Engine.keyboard.keyPress((KeyEvent.VK_F))) {
                    score += 10;
                }
                if (Engine.keyboard.keyPress((KeyEvent.VK_E))) {
                    GameState = "pause";
                    options = true;
                }
                if (Engine.keyboard.keyPress((KeyEvent.VK_P))) {
                    GameState = "pause";
                }
                if(Engine.keyboard.keyPress(KeyEvent.VK_1)){
                    player.setShip(Player.Spaceships.RED);
                }
                if(Engine.keyboard.keyPress(KeyEvent.VK_2)){
                    if(score == 100) {
                        score -= 200;
                        player.setShip(Player.Spaceships.BLUE);
                    }
                }
                if(Engine.keyboard.keyPress(KeyEvent.VK_3)){
                    if (score == 200) {
                        score -= 700;
                        player.setShip(Player.Spaceships.GREEN);
                        health = player.getHealth();
                    }
                }

                if (Engine.keyboard.keyPress(KeyEvent.VK_SPACE)) {

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
            if(Objects.equals(GameState, "pause")){
                if (Engine.keyboard.keyPress((KeyEvent.VK_ESCAPE))) {
                    GameState = "run";

                }


            }
            if (health == 0){
                gameOver = true;
            }
        }
        if(gameOver){
            if(Engine.keyboard.keyPress(KeyEvent.VK_ENTER)){
                health = player.getHealth();
                gameOver = false;
            }

        }
    }

    @Override
    public void draw() {
        Graphics graphics = Engine.canvas.getBufferStrategy().getDrawGraphics();


        for (Star star : stars) {
            star.draw(graphics);
        }

        player.draw(graphics);
        enemy.draw(graphics);

        for (int i = 0; i < maxShots; i++) {

            if (shotsDisparados.get(i)) {
                shot.shoot(shotsPositions.get(i));
                shot.draw(graphics);
            }

        }
        // Cria a janela da loja
        if(options){
            options = false;
            store.window();

        }


        for (int i = 0; i < health; i++) {
            graphics.drawImage(lifeImage, 463 - (i * 34), 10, null);
        }


        graphics.drawImage(starScore,2,2,null);
        Font fonte = new Font("Arial", Font.BOLD, 25);
        graphics.setFont(fonte);
        graphics.setColor(Color.white);
        graphics.drawString("" + score,35,27);


        if (gameOver) {
            graphics.setFont(new Font("Arial", Font.BOLD, 56));
            graphics.setColor(Color.black);
            graphics.drawString("GAME OVER", 100, 250);
            graphics.setFont(new Font("Arial", Font.BOLD, 30));
            graphics.setColor(Color.black);
            graphics.drawString("Pressione 'ENTER' para reiniciar", 30, 280);
        }
        if (Objects.equals(GameState, "pause")){
            graphics.setFont(new Font("Arial", Font.BOLD, 56));
            graphics.setColor(Color.black);
            graphics.drawString("PAUSE", 160, 220);
            graphics.setFont(new Font("Arial", Font.BOLD, 30));
            graphics.setColor(Color.black);
            graphics.drawString("Pressione 'ESC' para continuar", 30, 280);
        }



    }

    @Override
    public void end() {

    }
}
