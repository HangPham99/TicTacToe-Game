import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{

    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel titlePanel=new JPanel();
    JPanel buttonPanel=new JPanel();
    JLabel textLabel=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean playerTurn;

    //constructor
     TicTacToe() throws InterruptedException {

         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(800,800);
         frame.getContentPane().setBackground(new Color(50,50,50));
         frame.setLayout(new BorderLayout());
         frame.setVisible(true);

         textLabel.setBackground(new Color(25,25,25));
         textLabel.setForeground(new Color(25,255,0));
         textLabel.setFont(new Font("Ink Free",Font.BOLD,75));
         textLabel.setHorizontalAlignment(JLabel.CENTER);
         textLabel.setText("Tic-Tac-Toe");
         textLabel.setOpaque(true);

         titlePanel.setLayout(new BorderLayout());
         titlePanel.setBounds(0,0,800,100);
         buttonPanel.setLayout(new GridLayout(3,3));
         buttonPanel.setBackground(new Color(150,150,150));

         for(int i=0; i<9;i++){
             buttons[i]=new JButton();
             buttonPanel.add(buttons[i]);
             buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
             buttons[i].setFocusable(false);
             buttons[i].addActionListener(this);
         }
         titlePanel.add(textLabel);
         frame.add(titlePanel, BorderLayout.NORTH);
         frame.add(buttonPanel);

         playFirstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (playerTurn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        playerTurn = false;
                        textLabel.setText("O turn");
                        checkWhoWin();
                    }
                } else {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(0, 0, 255));
                            buttons[i].setText("O");
                            playerTurn = true;
                            textLabel.setText("X turn");
                            checkWhoWin();
                        }
                    }
                }
            }
        }


    public void playFirstTurn() throws InterruptedException {
            try {
                Thread.sleep(200);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            //chuong trinh co 2 nguoi choi, random tu 0-1 ra so 0 x choi trc
        if(random.nextInt(2)==0){
            playerTurn=true;
            textLabel.setText("X turn");
        }
        else{
            playerTurn=false;
            textLabel.setText("O turn");
        }
    }

    public void checkWhoWin(){
        //check X win conditions
        if(
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")
        ) {
            checkXWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")
        ) {
            checkXWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")
        ) {
            checkXWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")
        ) {
            checkXWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")
        ) {
            checkXWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")
        ) {
            checkXWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
        ) {
            checkXWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")
        ) {
            checkXWins(2,4,6);
        }
        //check O win conditions
        if(
                (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")
        ) {
            checkOWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")
        ) {
            checkOWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")
        ) {
            checkOWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")
        ) {
            checkOWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")
        ) {
            checkOWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")
        ) {
            checkOWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")
        ) {
            checkOWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")
        ) {
            checkOWins(2,4,6);
        }
    }


    public void checkXWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false); //ca ban co bi freeze
        }
        textLabel.setText("X wins");

    }

    public void checkOWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false); //ca ban co bi freeze
        }
        textLabel.setText("O wins");
    }
}
