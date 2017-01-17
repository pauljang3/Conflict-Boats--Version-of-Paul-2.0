import java.awt.*;
import javax.swing.*;

public class Board {
  
  static boolean isGameOn = true;
  static boolean hasSetupDonePlayer1 = false;
  static boolean hasSetupDonePlayer2 = false;

 public static void main(String[] args) {
  
  JFrame frame = new JFrame("Battleship");
  frame.setSize(1900, 1000);
  frame.setLayout(new GridLayout(1, 3));
  
  Divider divider = new Divider();
  LeftField leftField = new LeftField(divider);
  
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

