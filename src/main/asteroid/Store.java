package main.asteroid;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Store{



    public void window() {
        JFrame frame2 = new JFrame();
        frame2.setSize(new Dimension(400, 400));
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);


        frame2.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e){
            }
        });
    }


}
