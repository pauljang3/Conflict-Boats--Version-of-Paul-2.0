import java.awt.*;
import javax.swing.*;

public class Board {

 public static void main(String[] args) {
  
  JFrame frame = new JFrame("Battleship");
  frame.setSize(1900, 1000);
  frame.setLayout(new GridLayout(1, 3));
  
  Divider divider = new Divider();
  
  frame.add(new LeftField(divider));
  frame.add(divider);
  frame.add(new RightField());
  frame.setLocationRelativeTo(null);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
  

 }

}
