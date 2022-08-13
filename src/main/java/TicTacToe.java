import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener{

    private final Random random = new Random();
    private final JFrame frame = new JFrame();
    private final JPanel titlePanel = new JPanel();
    private final JPanel buttonPanel = new JPanel();
    private final JLabel textLabel = new JLabel();
    private final JButton[] buttons = new JButton[9];
    private boolean playerTurn;

    private final static char firstPlayerSymbol = 'X';

    private final static char secondPlayerSymbol = 'O';

    //constructor
     TicTacToe() {
         initializeFrame();
         initializeTextLabel();
         initializeTitlePanel();
         initializeButtonPanel();
         playFirstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource().equals(buttons[i])) {
                if (buttons[i].getText().equals("")) {
                    if (playerTurn) {
                        playAction(i, firstPlayerSymbol, false, new Color(255, 0, 0));
                    } else {
                        playAction(i, secondPlayerSymbol, true, new Color(0, 0, 255));
                    }
                }
            }
        }
    }

    private void initializeButtonPanel() {
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        for(int i=0; i<9;i++){
            buttons[i]=new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        frame.add(buttonPanel);
    }

    private void initializeTitlePanel() {
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);
        titlePanel.add(textLabel);
        frame.add(titlePanel, BorderLayout.NORTH);
    }

    private void initializeTextLabel() {
        textLabel.setBackground(new Color(25,25,25));
        textLabel.setForeground(new Color(25,255,0));
        textLabel.setFont(new Font("Ink Free",Font.BOLD,75));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);
    }

    private void initializeFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }

    private void playAction(int pos, char symbol, boolean isPlayerTurn, Color color) {
        buttons[pos].setForeground(color);
        buttons[pos].setText(String.valueOf(symbol));
        playerTurn = isPlayerTurn;
        textLabel.setText(symbol + " turn");
        checkWhoWin();
    }

    private void playFirstTurn() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        if (random.nextInt(2) == 0){
            playerTurn=true;
            textLabel.setText(firstPlayerSymbol + " turn");
        }
        else{
            playerTurn=false;
            textLabel.setText(secondPlayerSymbol + " turn");
        }
    }

    private int getIndInOneDimensionArr(int row, int column) {
        return row * 3 + column;
    }

    private void checkWinner(int indOne, int indTwo, int indThree) {
        String curChar = buttons[indOne].getText();
        if (!curChar.isEmpty() && buttons[indTwo].getText().equals(curChar)
                && (buttons[indThree]).getText().equals(curChar)) {
            callWinner(indOne, indTwo, indThree, curChar);
        }
    }
    private void checkWhoWin(){
        for (int row = 0; row < 3; row++) {
            checkWinner(getIndInOneDimensionArr(row, 0),
                    getIndInOneDimensionArr(row, 1),
                    getIndInOneDimensionArr(row, 2));
        }

        for (int col = 0; col < 3; col++) {
            checkWinner(getIndInOneDimensionArr(0, col),
                    getIndInOneDimensionArr(1, col),
                    getIndInOneDimensionArr(2, col));
        }

        // check for first diagonal on the left side
        checkWinner(getIndInOneDimensionArr(0, 0),
                getIndInOneDimensionArr(1, 1),
                getIndInOneDimensionArr(2, 2));

        // check for first diagonal on the right side
        checkWinner(getIndInOneDimensionArr(0, 2),
                getIndInOneDimensionArr(1, 1),
                getIndInOneDimensionArr(2, 0));
    }

    private void callWinner(int a, int b, int c, String winnerSymbol){
         System.out.println("callWinner is running ");
        buttons[a].setForeground(Color.GREEN);
        buttons[b].setForeground(Color.GREEN);
        buttons[c].setForeground(Color.GREEN);
        System.out.println("a = " + a +  " ,b = " + b +  " ,c = " + c + "  has set to GREEN");

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textLabel.setText(winnerSymbol + " wins");
    }
}
