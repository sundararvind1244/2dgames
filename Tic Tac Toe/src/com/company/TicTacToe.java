package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener  {
    private final Random random = new Random();
    private final JFrame frame =  new JFrame();
    private final JPanel titlePanel = new JPanel();
    private final JPanel buttonPanel =  new JPanel();
    private final JLabel textField = new JLabel();
    private final JButton[] buttons = new JButton[9];
    private boolean player1 ;


public TicTacToe() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(650, 650);
    frame.getContentPane().setBackground(Color.PINK);
    frame.setLayout(new BorderLayout());
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);


    textField.setBackground(Color.white);
    textField.setForeground(Color.black);
    textField.setFont(new Font("Ink Free", Font.BOLD, 50));
    textField.setHorizontalAlignment(JLabel.CENTER);
    textField.setText("TIC TAC TOE");
    textField.setOpaque(true);

    titlePanel.setLayout(new BorderLayout());
    titlePanel.setBounds(0, 0, 650, 100);

    buttonPanel.setLayout(new GridLayout(3, 3));
    buttonPanel.setBackground(Color.GREEN);

    for (int i = 0; i < buttons.length; i++) {
        buttons[i] = new JButton();
        buttonPanel.add(buttons[i]);
        buttons[i].setBackground(Color.CYAN);
        buttons[i].setFont(new Font("Chill", Font.ITALIC, 100));
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this);
    }


    titlePanel.add(textField);
    frame.add(titlePanel, BorderLayout.NORTH);
    frame.add(buttonPanel);

    firstTurn();
}


@Override
public void actionPerformed(ActionEvent event) {
    for (int i = 0; i < buttons.length; i++) {
        if (event.getSource() == buttons[i]) {
            if (player1) {
                if (buttons[i].getText() == "") {
                    buttons[i].setForeground(Color.MAGENTA);
                    buttons[i].setText("X");
                    player1 = false;
                    textField.setText("O turn");
                    check();

                }

            } else {
                if (buttons[i].getText() == "") {
                    buttons[i].setForeground(Color.BLACK);
                    buttons[i].setText("O");
                    player1 = true;
                    textField.setText("X turn");
                    check();

                }

            }
        }


    }
}
public void firstTurn(){

    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    if (random.nextInt(2) == 0){
        player1 = true;
        textField.setText("X turn");
    }
    else {
        player1 = false;
        textField.setText("O turn");
    }

}

public void check(){
    //check X win conditions
    if(
            (buttons[0].getText().equals("X") )&&
                    (buttons[1].getText().equals("X")) &&
                    (buttons[2].getText().equals("X"))
    ) {
        xWins(0,1,2);
    }
    if(
            (buttons[3].getText().equals("X") &&
                    (buttons[4].getText().equals("X")) &&
                    (buttons[5].getText().equals("X"))
            )
    )
     {
        xWins(3,4,5);
    }
    if(
            (buttons[6].getText().equals("X")) &&
                    (buttons[7].getText().equals("X")) &&
                    (buttons[8].getText().equals("X"))
    ) {
        xWins(6,7,8);
    }
    if(
            (buttons[0].getText().equals("X")) &&
                    (buttons[3].getText().equals("X")) &&
                    (buttons[6].getText().equals("X"))
    ) {
        xWins(0,3,6);
    }
    if(
            (buttons[1].getText().equals("X")) &&
                    (buttons[4].getText().equals("X")) &&
                    (buttons[7].getText().equals("X"))
    ) {
        xWins(1,4,7);
    }
    if(
            (buttons[2].getText().equals("X")) &&
                    (buttons[5].getText().equals("X")) &&
                    (buttons[8].getText().equals("X"))
    ) {
        xWins(2,5,8);
    }
    if(
            (buttons[0].getText().equals("X")) &&
                    (buttons[4].getText().equals("X")) &&
                    (buttons[8].getText().equals("X"))
    ) {
        xWins(0,4,8);
    }
    if(
            (buttons[2].getText().equals("X")) &&
                    (buttons[4].getText().equals("X")) &&
                    (buttons[6].getText().equals("X"))
    ) {
        xWins(2,4,6);
    }
    //check O win conditions
    if(
            (buttons[0].getText().equals("O")) &&
                    (buttons[1].getText().equals("O")) &&
                    (buttons[2].getText().equals("O"))
    ) {
        oWins(0,1,2);
    }
    if(
            (buttons[3].getText().equals("O")) &&
                    (buttons[4].getText().equals("O")) &&
                    (buttons[5].getText().equals("O"))
    ) {
        oWins(3,4,5);
    }
    if(
            (buttons[6].getText().equals("O")) &&
                    (buttons[7].getText().equals("O")) &&
                    (buttons[8].getText().equals("O"))
    ) {
        oWins(6,7,8);
    }
    if(
            (buttons[0].getText().equals("O")) &&
                    (buttons[3].getText().equals("O")) &&
                    (buttons[6].getText().equals("O"))
    ) {
        oWins(0,3,6);
    }
    if(
            (buttons[1].getText().equals("O")) &&
                    (buttons[4].getText().equals("O")) &&
                    (buttons[7].getText().equals("O"))
    ) {
        oWins(1,4,7);
    }
    if(
            (buttons[2].getText().equals("O")) &&
                    (buttons[5].getText().equals("O")) &&
                    (buttons[8].getText().equals("O"))
    ) {
        oWins(2,5,8);
    }
    if(
            (buttons[0].getText().equals("O")) &&
                    (buttons[4].getText().equals("O")) &&
                    (buttons[8].getText().equals("O"))
    ) {
        oWins(0,4,8);
    }
    if(
            (buttons[2].getText().equals("O")) &&
                    (buttons[4].getText().equals("O")) &&
                    (buttons[6].getText().equals("O"))
    ) {
        oWins(2,4,6);
    }

}

public void xWins(int a, int b, int c){
    buttons[a].setBackground(Color.RED);
    buttons[b].setBackground(Color.RED);
    buttons[c].setBackground(Color.RED);

    for(int i=0;i<buttons.length;i++) {
        buttons[i].setEnabled(false);
    }
    textField.setText("X wins");

}
public void oWins(int a, int b, int c){
    buttons[a].setBackground(Color.RED);
    buttons[b].setBackground(Color.RED);
    buttons[c].setBackground(Color.RED);

    for(int i=0;i<buttons.length;i++) {
        buttons[i].setEnabled(false);
    }
    textField.setText("O wins");
}

}



