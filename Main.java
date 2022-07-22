/*

███╗░░░███╗███████╗███╗░░░███╗░█████╗░██████╗░██╗░░░██╗  ░██████╗░░█████╗░███╗░░░███╗███████╗
████╗░████║██╔════╝████╗░████║██╔══██╗██╔══██╗╚██╗░██╔╝  ██╔════╝░██╔══██╗████╗░████║██╔════╝
██╔████╔██║█████╗░░██╔████╔██║██║░░██║██████╔╝░╚████╔╝░  ██║░░██╗░███████║██╔████╔██║█████╗░░
██║╚██╔╝██║██╔══╝░░██║╚██╔╝██║██║░░██║██╔══██╗░░╚██╔╝░░  ██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░
██║░╚═╝░██║███████╗██║░╚═╝░██║╚█████╔╝██║░░██║░░░██║░░░  ╚██████╔╝██║░░██║██║░╚═╝░██║███████╗
╚═╝░░░░░╚═╝╚══════╝╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░  ░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝
By Burak Unlu                                                                                                                   
There is no point of putting this here it just looks really cool
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

class Main {

  // values taht will be inside the cards
  static ArrayList<String> cardValues = new ArrayList<>();
  // array that stores the values of the cards - not seen by player
  static String[][] gridOfCards = new String[4][4];

  // variable that stores the amount of pairs that the player found
  static int score = 0;
  // variable that stores the number of turns
  static int turns = 0;
  // boolean that dictates wether the program is accepting button clicks or not
  static boolean acceptingButtonClicks = true;

  // row and col vars for selections
  static int row = 7;
  static int col = 7;
  static int row2 = 7;
  static int col2 = 7;

  // list that will hold 4 values - row, col, row2, col2
  static ArrayList<Integer> coordinates = new ArrayList<>(4);

  static String[][] grid = {
      { ".", ".", ".", "." },
      { ".", ".", ".", "." },
      { ".", ".", ".", "." },
      { ".", ".", ".", "." }
  };

  // creating a new JFrame and other things neeeded for the gui
  static JFrame frame = new JFrame("Memory Game");
  static JPanel panel = new JPanel();
  static JLabel label = new JLabel("Welcome to the memory game!");
  static Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
  static GridBagLayout layout = new GridBagLayout();
  static GridBagConstraints gbc = new GridBagConstraints();

  // the buttons
  static JButton button1 = new JButton(".");
  static JButton button2 = new JButton(".");
  static JButton button3 = new JButton(".");
  static JButton button4 = new JButton(".");
  static JButton button5 = new JButton(".");
  static JButton button6 = new JButton(".");
  static JButton button7 = new JButton(".");
  static JButton button8 = new JButton(".");
  static JButton button9 = new JButton(".");
  static JButton button10 = new JButton(".");
  static JButton button11 = new JButton(".");
  static JButton button12 = new JButton(".");
  static JButton button13 = new JButton(".");
  static JButton button14 = new JButton(".");
  static JButton button15 = new JButton(".");
  static JButton button16 = new JButton(".");

  // continue button
  static JButton cont = new JButton("Press This button to continue");

  // array to store all the buttons and make it easier to manage their properties
  static JButton[][] buttonList = { { button1, button2, button3, button4 }, { button5, button6, button7, button8 },
      { button9, button10, button11, button12 }, { button13, button14, button15, button16 } };

  public static void main(String[] args) {
    // Animals insan = new Animals(8);

    // frame
    frame.setSize(600, 400); // you can alos .setBounds(x, y, width, height) to set size and location at once
    frame.setLocation(0, 0);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // panel
    panel.setBackground(Color.cyan);
    panel.setLayout(layout);

    // buttons
    for (int r = 0; r < buttonList.length; r++) {
      for (var c = 0; c < buttonList[r].length; c++) {
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 10 * c + 200;
        gbc.gridy = 10 * r;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.weightx = 1;
        gbc.weighty = 1;
        buttonList[r][c].setForeground(Color.WHITE);
        buttonList[r][c].setBackground(Color.GRAY);
        buttonList[r][c].setCursor(cursor);
        final int row = r;
        final int col = c;
        buttonList[r][c].addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            if (acceptingButtonClicks) {
              if (e.getSource() == button1) {
                System.out.println("button 1 pressed");
                buttonList[row][col].setText(gridOfCards[row][col]);
                chooseCard(1, 1);
              } else if (e.getSource() == button2) {
                System.out.println("button 2 pressed");
                buttonList[row][col].setText(gridOfCards[row][col]);
                chooseCard(1, 2);
              } else if (e.getSource() == button3) {
                System.out.println("button 3 pressed");
                buttonList[row][col].setText(gridOfCards[row][col]);
                chooseCard(1, 3);
              } else if (e.getSource() == button4) {
                System.out.println("button 4 pressed");
                buttonList[row][col].setText(gridOfCards[row][col]);
                chooseCard(1, 4);
              } else if (e.getSource() == button5) {
                System.out.println("button 5 pressed");
                chooseCard(2, 1);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button6) {
                System.out.println("button 6 pressed");
                chooseCard(2, 2);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button7) {
                System.out.println("button 7 pressed");
                chooseCard(2, 3);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button8) {
                System.out.println("button 8 pressed");
                chooseCard(2, 4);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button9) {
                System.out.println("button 9 pressed");
                chooseCard(3, 1);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button10) {
                System.out.println("button 10 pressed");
                chooseCard(3, 2);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button11) {
                System.out.println("button 11 pressed");
                chooseCard(3, 3);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button12) {
                System.out.println("button 12 pressed");
                chooseCard(3, 4);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button13) {
                System.out.println("button 13 pressed");
                chooseCard(4, 1);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button14) {
                System.out.println("button 14 pressed");
                chooseCard(4, 2);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button15) {
                System.out.println("button 15 pressed");
                chooseCard(4, 3);
                buttonList[row][col].setText(gridOfCards[row][col]);
              } else if (e.getSource() == button16) {
                System.out.println("button 16 pressed");
                chooseCard(4, 4);
                buttonList[row][col].setText(gridOfCards[row][col]);
              }
            }
          }
        });
        panel.add(buttonList[r][c], gbc);
      }
    }

    // label
    label.setText("<html>Welcome<br>to the<br> memory game!</html>");
    label.setForeground(Color.BLACK);
    label.setBounds(0, 0, 50, 50);

    // continue button
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridx = 0;
    gbc.gridy = 30;
    gbc.ipadx = 20;
    gbc.ipady = 20;
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.weightx = 1;
    gbc.weighty = 1;
    cont.setForeground(Color.WHITE);
    cont.setBackground(Color.GRAY);
    cont.setCursor(cursor);
    cont.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
      
    }});

    panel.add(cont, gbc);
    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(label, gbc);
    frame.add(panel);
    frame.setVisible(true);

    cardValues.add("A");
    cardValues.add("A");
    cardValues.add("a");
    cardValues.add("a");
    cardValues.add("B");
    cardValues.add("B");
    cardValues.add("b");
    cardValues.add("b");
    cardValues.add("C");
    cardValues.add("C");
    cardValues.add("c");
    cardValues.add("c");
    cardValues.add("D");
    cardValues.add("D");
    cardValues.add("d");
    cardValues.add("d");

    shuffleCards();
  }

  // make the array that holds the random values of the cards
  public static void shuffleCards() {
    Random random = new Random();

    for (var i = 0; i < gridOfCards.length; i++) {
      for (var j = 0; j < gridOfCards.length; j++) {
        // cycle through each index in the array and set it to a random letter from the
        // cardValues list then delete that letter from cardValues so that it doesnt get
        // used
        int randomIndex = random.nextInt(cardValues.size());
        gridOfCards[i][j] = cardValues.get(randomIndex);
        cardValues.remove(randomIndex);
      }
    }
    // prints out the array that has the values of the cards - only used for testing
    // purposes
    for (var k = 0; k < gridOfCards.length; k++) {
      for (String str : gridOfCards[k]) {
        System.out.print(str + " ");
      }
      System.out.print("\n");
    }
  }

  public static void chooseCard(int row, int col) {
    // CHOOSE YOUR FIRST CARD
    // this loop makes sure that the player cannot choose the same card twice
    if (row > 4 || col > 4 || !grid[row - 1][col - 1].equals(".")) {
      System.out.println("Make sure you do not choose a card that you have already found the pair for");
      return;
    }
    grid[row - 1][col - 1] = gridOfCards[row - 1][col - 1];
    coordinates.add(row);
    coordinates.add(col);
    System.out.println(grid[row - 1][col - 1]);
    System.out.println(coordinates.toString());
    if (gameOver()) {
      // GAME OVER
      turns++;
      System.out.println("You found all the pairs in " + turns + " turns");
      System.exit(0);
    }
    if (coordinates.size() == 4) {
      checkForPair(coordinates.get(0), coordinates.get(1), coordinates.get(2), coordinates.get(3));
    }
  }

  public static void checkForPair(int row, int col, int row2, int col2) {
    // keeps track of the number of turns
    turns++;
    // checks if any pairs were found
    if (gridOfCards[row - 1][col - 1].equals(gridOfCards[row2 - 1][col2 - 1])) {
      System.out.println("You found a pair!");
      score++;
    } else {
      System.out.println("You did not find a pair");
      // resets the cards that were flipped over
      grid[row - 1][col - 1] = ".";
      grid[row2 - 1][col2 - 1] = ".";
      buttonList[row - 1][col - 1].setText(".");
      buttonList[row2 - 1][col2 - 1].setText(".");
    }
    coordinates.clear();
  }

  public static boolean gameOver() {
    // check wether the game is over by checking if there are any "." left on the
    // board
    for (var r = 0; r < grid.length; r++) {
      for (var c = 0; c < grid[r].length; c++) {
        if (grid[r][c].equals(".")) {
          return false;
        }
      }
    }
    return true;
  }

}