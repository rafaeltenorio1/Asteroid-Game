package main.asteroid;

import main.engine.Engine;
import main.engine.Game;
import main.engine.GraphicObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Asteroid implements Game {
    private Player player;
    private GraphicObject grafico;
    private Shot shot;
    private  Brackground background;
    private final List<Point> shotsPositions = new ArrayList<>();
    private final List<Boolean> shotsDisparados = new ArrayList<>();
    private final int maxShots = 10;
    private boolean gameOver = false;

    private final ArrayList<Shot> shots = new ArrayList<>();

    @Override
    public void init() {
        Engine.canvas.setBackground(new Color(0x5e, 0x3f, 0x6b, 255));

        player = new Player(Engine.canvas.getWidth() / 2 - 32, Engine.canvas.getHeight() / 2, 99, 75);
        background = new Brackground(0, 0, 254, 256);
        shot = new Shot(0, 0, 9, 33);

        for (int i = 0; i < maxShots; i++) {
            shotsPositions.add(new Point(0, 0));
            shotsDisparados.add(false);
        }
        player.speed = 4;
    }

    @Override
    public void update() {
        if(!gameOver) {

            if (Engine.keyboard.keyDown(KeyEvent.VK_D)) {
                player.direction = "right";
                player.translate(new Point(1, 0));
            } else {
                player.direction = "stop";
            }
            if (Engine.keyboard.keyDown(KeyEvent.VK_A)) {
                player.direction = "left";
                player.translate(new Point(-1, 0));
            }

            if (Engine.keyboard.keyDown(KeyEvent.VK_W)) {
                player.translate(new Point(0, -1));
            }
            if (Engine.keyboard.keyDown(KeyEvent.VK_S)) {
                player.translate(new Point(0, 1));
            }
            // Testa a vida, para ela sumir
            if (Engine.keyboard.keyPress(KeyEvent.VK_Q)) {
                player.health -= 1;
            }
            if (player.health == 0) {
                gameOver = true;
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
        }else if(gameOver){
            if(Engine.keyboard.keyPress(KeyEvent.VK_ENTER)){
                player.health = 3;
                gameOver = false;
            }
        }
    }

    @Override
    public void draw() {
        Graphics graphics = Engine.canvas.getBufferStrategy().getDrawGraphics();
        background.draw(graphics,  background.sprite);

        if(player.direction == "right"){
            player.draw(graphics, player.spriteRight);
        }
        if(player.direction == "left"){
            player.draw(graphics, player.spriteLeft);
        }
        if(player.direction == "stop"){
            player.draw(graphics, player.sprite);
        }


        for (int i = 0; i < maxShots; i++) {

            if (shotsDisparados.get(i)) {
                shot.shoot(shotsPositions.get(i));
                shot.draw(graphics, shot.sprite);

            }

        }

        Font fonte = new Font("Arial", Font.PLAIN, 24);
        graphics.setFont(fonte);

        // Definindo a cor do texto
        graphics.setColor(Color.BLACK);

        for(int i = 0; i < player.health; i++){
            graphics.drawImage(player.spriteHealth, 463 - (i*34), 10,null);
        }

        if(gameOver){
            graphics.setFont(new Font("arial",Font.BOLD, 56));
            graphics.setColor(Color.black);
            graphics.drawString("GAME OVER",100,250);
            graphics.setFont(new Font("arial",Font.BOLD, 30));
            graphics.setColor(Color.black);
            graphics.drawString("Pressione 'ENTER' para reiniciar",30,280);
        }


    }

    @Override
    public void end() {

    }
}
