package old;

import old.entity.Player;
import old.entity.Shot;
import tile.TileManager;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{

    public static JFrame frame;


    public boolean isRunning = true;
    public Thread thread;

    // Tamanho da Janela
    public static int height = 135;
    public static int width = 240;
    public static int scale = 4;



    public static BufferedImage image;
    public static BufferedImage nave;
    public String direction;

    //Movimento
    KeyHandler keys = new KeyHandler();
    public int x = 100, y = 100, speed = 3;

    Player player = new Player(this, keys);

    //Spaceship spaceship = new Spaceship(g,0, 0, 64, 64, "/res/Player/playerShip2_blue.png");
    TileManager tile = new TileManager(this);
    Shot shot = new Shot(this);




    public Game(){
        addKeyListener(keys);
        this.setPreferredSize(new Dimension(width*scale, height*scale));
        Frame();

    }


    public void Frame() {

        frame = new JFrame("AsteroidGame");
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public synchronized void start(){

        thread = new Thread(this);
        isRunning = true;
        thread.start();;

    }


    public synchronized void stop(){

        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }



    public void  render(){

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        requestFocus();
        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(0,0,0, 255));
        g.fillRect(0, 0, Game.width*Game.scale,Game.height*Game.scale);

        tile.draw(g);
        player.draw(g);
        //spaceship.draw(g);
        if(Player.shoting){
            shot.draw(g);

        }



        bs.show();
    }

    public void tick(){
        shot.tick();
        player.tick();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double FPS = 60.0;
        double ns = 1000000000 / FPS;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                render();
                tick();
                frames++;
                delta--;
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer += 1000;
            }
        }
        stop();
    }
}