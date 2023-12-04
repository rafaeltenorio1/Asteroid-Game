package old;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame {
    private static final int height = 135;
    private static final int width = 240;

    private static final boolean[] windowKeys = new boolean[256];
    private static final boolean[] windowCtrl = new boolean[256];

    public Window() throws HeadlessException {
        setTitle("Game");
        setSize(width, height);
        setResizable(false);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                windowKeys[e.getKeyCode()] = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                windowKeys[e.getKeyCode()] = false;
            }
        });
    }


    public boolean keyDown(int keycode) {
        return windowKeys[keycode];
    }

    public boolean keyUp(int keycode) {
        return !windowKeys[keycode];
    }

    public boolean keyPess(int keycode) {
        if (windowCtrl[keycode]) {
            if (keyDown(keycode)) {
                windowCtrl[keycode] = false;
                return true;
            }
        } else if (keyUp(keycode)) {
            windowCtrl[keycode] = true;
        }

        return false;
    }
}
