import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable, KeyListener {

    public static JFrame frame;

    // Definem o fps
    public boolean isRunning = true;
    public Thread thread;

    // Tamanho da Janela
    private static int height = 135;
    private static int width = 240;
    private static int scale = 4;

    public static BufferedImage image;
    public static BufferedImage nave;
    public String direction;

    // Movimento
    public int x = 100, y = 100, speed = 3;
    public boolean right, left, up, down;




    public Game(){
        addKeyListener(this);
        this.setPreferredSize(new Dimension(width*scale, height*scale));
        image = new BufferedImage(width*scale, height*scale, BufferedImage.TYPE_INT_RGB);
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


    public static void main(String args[]){
        Game game = new Game();
        game.start();

    }

    public void tick(){
        if(right){
            x += speed;
        }else if (left){
            x -= speed;
        }
        else if(up){
            y -= speed;
        }else if (down){
            y += speed;
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
        g.setColor(Color.blue);
        g.fillRect(x, y, 64, 64);


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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = true;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            left = true;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
               up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            down = true;
        }
        

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            right = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_A){
            left = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_W){
            up = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S){
            down = false;
        }
    }
}
