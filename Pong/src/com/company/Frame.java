package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * This class implements the frame of the game.
 * @author SUNDAR
 */
public class Frame extends JFrame {
    Panel panel;
    public Frame(){



            panel = new Panel();
            this.add(panel);
            this.setTitle("A simple 2d double player Pong game");
            this.setResizable(false);
            this.setBackground(Color.black);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pack();
            this.setVisible(true);
            this.setLocationRelativeTo(null);


    }
}
