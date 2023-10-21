package main;

import entity.Player;
import entity.Shot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean right, left, up, down;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {



        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = true;

        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            left = true;

        }
        else if (e.getKeyCode() == KeyEvent.VK_W) {
            up = true;

        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            down = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            Player.shoting = true;

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
