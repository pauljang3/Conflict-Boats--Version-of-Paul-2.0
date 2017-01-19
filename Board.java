import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Board {
  
  //Setting boolean variables accordingly
  static boolean isGameOn = true;
  static boolean hasSetupDonePlayer1 = false;
  static boolean hasSetupDonePlayer2 = false;
  public static boolean isSelected = false;
  
  //Main Method to run the game 
  public static void main(String[] args) {
    
    //Creating new frame with appropriate layouts
   final JFrame frame = new JFrame("Battleship");
    frame.setSize(1900, 1000);
    frame.setLayout(new GridLayout(1, 3));
    
    //Creating divider and leftfield objects
   final Divider divider = new Divider();
    final LeftField leftField = new LeftField(divider);
    
    
    
    //Setting up game window 
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    
   final JPanel mainMenu = new JPanel();    
    frame.add(mainMenu);
    
    ActionListener al = new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(!(e.getSource() instanceof JButton)){
          return; 
        }
        
        JButton button = (JButton) e.getSource();
        
        
        if(button.getText().equalsIgnoreCase("Start")){
          // Button got pressed 
          //Adding classes 
          frame.remove(mainMenu);
          frame.add(leftField);
          frame.add(divider);
          frame.add(new RightField());
          frame.validate();
          
        }else if(button.getText().equalsIgnoreCase("quit")){
         System.exit(0); 
        }
      }
    };
    
    JButton start = new JButton ("Start");
    start.setFont(new Font(start.getFont().getName(), Font.PLAIN, 200));
    start.addActionListener(al);
    mainMenu.add(start);
    
    JButton quit = new JButton("Quit");
    quit.setFont(new Font(start.getFont().getName(), Font.PLAIN, 200));
    quit.addActionListener(al);
    mainMenu.add(quit);
    
    JButton instructions = new JButton("Instructions");
    instructions.setFont(new Font(start.getFont().getName(), Font.PLAIN, 200));
    instructions.addActionListener(al);
    mainMenu.add(instructions);
    
    // while(isGameOn){
    // JOptionPane.showMessageDialog (null, "Welcome to Conflict Boats!");
    // JOptionPane.showMessageDialog (null, "Player 1 please choose the placement of you boats and Player 2 please look away.");
    
    
    
    
    
    // isGameOn = false;
    // }
    
  }
  
}
