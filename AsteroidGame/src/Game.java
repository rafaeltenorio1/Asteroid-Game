import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{

    public static JFrame frame;

    // Movimento do sprite
    public int x, y;

    public static BufferedImage image;
    public static BufferedImage player;
    public Sprites sprite;

    // Definem o fps
    public boolean isRunning = true;
    public Thread thread;


    // Tamanho da Janela
    private static int height = 250;
    private static int width = 400;
    private static int scale = 3;

    public Game(){

        this.setPreferredSize(new Dimension(width*scale, height*scale));
        image = new BufferedImage(width*scale, height*scale, BufferedImage.TYPE_INT_RGB);
        startwindow();
        //sprite = new Sprites("/sprites.png");
        //player = sprite.getSprites(0,0,0,0);

    }


    public void startwindow() {
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


    public static void main(String args[]){
        Game game = new Game();
        game.start();

    }

    public void tick(){
        x++;
        y++;

    };

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
        g.setColor(Color.BLACK);
        //g.setFont(new Font("Arial",Font.BOLD, 26));
        //g.drawString("Ola", 50, 50);

        //g.drawImage(player,150,0,null);
        bs.show();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountofTicks = 120.0;
        double ns = 1000000000 / amountofTicks;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                render();
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
