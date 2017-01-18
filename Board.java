import java.awt.*;
import javax.swing.*;

public class Board {
  
  //Setting boolean variables accordingly
  static boolean isGameOn = true;
  static boolean hasSetupDonePlayer1 = false;
  static boolean hasSetupDonePlayer2 = false;
  public static boolean isSelected = false;
  
 //Main Method to run the game 
 public static void main(String[] args) {
  
  //Creating new frame with appropriate layouts
  JFrame frame = new JFrame("Battleship");
  frame.setSize(1900, 1000);
  frame.setLayout(new GridLayout(1, 3));
  
  //Creating divider and leftfield objects
  Divider divider = new Divider();
  LeftField leftField = new LeftField(divider);
  RightField rightField = new RightField(divider);
  //Adding classes 
  frame.add(leftField);
  frame.add(divider);
  frame.add(rightField);
   
  //Setting up game window 
  frame.setLocationRelativeTo(null);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
  
 // while(isGameOn){
   // JOptionPane.showMessageDialog (null, "Welcome to Conflict Boats!");
  // JOptionPane.showMessageDialog (null, "Player 1 please choose the placement of you boats and Player 2 please look away.");
    
    
    

    
  // isGameOn = false;
 // }

 }

}
