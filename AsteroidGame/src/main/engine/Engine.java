package main.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Engine implements Runnable {
    public static JFrame frame;
    public static Canvas canvas;
    public static Keyboard keyboard;
    private Game game;
    private boolean running;
    private static final int TARGET_FPS = 70;
    private static final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

    public Engine() {
        frame = new JFrame();
        canvas = new Canvas();
        keyboard = new Keyboard();
    }

    public void start(Game game) {
        this.game = game;
        canvas.setPreferredSize(new Dimension(500, 500));
        frame.add(canvas);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.
        frame.setVisible(true);

        canvas.createBufferStrategy(3);
        canvas.requestFocusInWindow();
        canvas.addKeyListener(keyboard);

        running = true;

        game.init();


        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        long lastUpdateTime = System.nanoTime();

        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        while (running) {
            long now = System.nanoTime();
            long updateTime = now - lastUpdateTime;
            lastUpdateTime = now;
            double delta = updateTime / ((double) OPTIMAL_TIME);
            game.update();

            do {
                do {
                    Graphics graphics = bufferStrategy.getDrawGraphics();
                    graphics.clearRect(0, 0, frame.getWidth(), frame.getHeight());
                    game.draw();
                    graphics.dispose();
                } while (bufferStrategy.contentsRestored());
                bufferStrategy.show();
            } while (bufferStrategy.contentsLost());

            try {
                long sleepTime = (lastUpdateTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        game.end();
    }
}
