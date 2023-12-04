package old;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Engine implements Runnable {

    public Game2 game;
    public static Window window;
    private static Canvas canvas;

    private final Thread thread = new Thread(this);
    private static BufferStrategy bufferStrategy;
    public Engine() {
        window = new Window();
        canvas = new Canvas();
    }

    public synchronized void start(Game2 level){
        game = level;

        canvas.setSize(500, 500);

        window.add(canvas);
        window.pack();
        window.setVisible(true);
        window.setFocusable(true);

        canvas.createBufferStrategy(3);
        bufferStrategy = canvas.getBufferStrategy();

        Game2.graphics = bufferStrategy.getDrawGraphics();
        Game2.window = window;
        thread.start();
    }

    public void loop () {


        game.init();

        while (true) {

            game.update();
            Game2.graphics.clearRect(0,0, 500, 500);
            game.draw();
            bufferStrategy.show();
        }
    }

    @Override
    public void run() {
        loop();
    }
}
