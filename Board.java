import java.awt.*;
import javax.swing.*;

public class Board {
  
  //Setting boolean values for game setup
  static boolean isGameOn = true;
  static boolean hasSetupDonePlayer1 = false;
  static boolean hasSetupDonePlayer2 = false;

 //Main Method to run whole the game
 public static void main(String[] args) {
  
  //Creating and setting new Frame with GridLayout 
  JFrame frame = new JFrame("Battleship");
  frame.setSize(1900, 1000);
  frame.setLayout(new GridLayout(1, 3));
  
  //Declaring divider and leftfield classes
  Divider divider = new Divider();
  LeftField leftField = new LeftField(divider);
  
  //Adding 3 classes to board
  frame.add(leftField);
  frame.add(divider);
  frame.add(new RightField());
   
  frame.setLocationRelativeTo(null);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
  
//  while(isGameOn){
    

    
    

    
//    isGameOn = false;
//  }

 }

}

