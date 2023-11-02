package main.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private static final boolean[] windowKeys = new boolean[256];
    private static final boolean[] windowCtrl = new boolean[256];

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 256) {
            windowKeys[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 256) {
            windowKeys[e.getKeyCode()] = false;
        }
    }

    public boolean keyDown(int keycode) {
        return windowKeys[keycode];
    }

    public boolean keyUp(int keycode) {
        return !windowKeys[keycode];
    }

    public boolean keyPress(int keycode) {
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
