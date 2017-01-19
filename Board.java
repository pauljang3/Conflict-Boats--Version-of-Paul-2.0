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
    final RightField rightField = new RightField(divider);
    
    final JPanel credits = new JPanel ();
    final JPanel instructions = new JPanel ();
    
    
    //Setting up game window 
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
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
          frame.add(rightField);
          frame.validate();
          
        }else if(button.getText().equalsIgnoreCase("quit")){
          System.exit(0); 
        }
      }
      
    };
    
    ActionListener alCredits = new ActionListener(){
      public void actionPerformed(ActionEvent d){
        if(!(d.getSource() instanceof JButton)){
          return; 
        }
        
        JButton button = (JButton) d.getSource();
        
        
        if(button.getText().equalsIgnoreCase("Credits")){
          //Button got pressed 
          //Adding classes 
          frame.remove(mainMenu);
          frame.add(credits);
          frame.setVisible(false);
          frame.setVisible(true);
          frame.validate();
          
        }
        else if(button.getText().equalsIgnoreCase("quit")){
          System.exit(0); 
        }
      }
    };
    
    ActionListener alInstruction = new ActionListener(){
      public void actionPerformed(ActionEvent f){
        if(!(f.getSource() instanceof JButton)){
          return; 
        }
        
        JButton button = (JButton) f.getSource();
        
        
        if(button.getText().equalsIgnoreCase("Instructions")){
          //Button got pressed 
          //Adding classes 
          frame.remove(mainMenu);
          frame.add(instructions);
          frame.validate();
          frame.setVisible(false);
          frame.setVisible(true);
          
        }
        else if(button.getText().equalsIgnoreCase("quit")){
          System.exit(0); 
        }
      }
    };
    
    ActionListener backInstructions = new ActionListener(){
      public void actionPerformed(ActionEvent g){
        if(!(g.getSource() instanceof JButton)){
          return; 
        }
        
        JButton button = (JButton) g.getSource();
        
        
        if(button.getText().equalsIgnoreCase("Back")){
          //Button got pressed 
          //Adding classes         
          frame.remove(instructions);
          frame.add(mainMenu);
          frame.validate();
          frame.setVisible(false);
          frame.setVisible(true);
        }
        else if(button.getText().equalsIgnoreCase("quit")){
          System.exit(0); 
        }
      }
    };
    
    ActionListener backCredits = new ActionListener(){
      public void actionPerformed(ActionEvent h){
        if(!(h.getSource() instanceof JButton)){
          return; 
        }
        
        JButton button = (JButton) h.getSource();
        
        
        if(button.getText().equalsIgnoreCase("Back")){
          //Button got pressed 
          //Adding classes         
          frame.remove(credits);
          frame.add(mainMenu);
          frame.validate();
          frame.setVisible(false);
          frame.setVisible(true);
          
        }
        else if(button.getText().equalsIgnoreCase("quit")){
          System.exit(0); 
        }
      }
    };
    
    
    JButton start = new JButton ("Start");
    start.setFont(new Font(start.getFont().getName(), Font.PLAIN, 50));
    start.addActionListener(al);
    mainMenu.add(start);
     
    JButton instructionButton = new JButton("Instructions");
    instructionButton.setFont(new Font(start.getFont().getName(), Font.PLAIN, 50));
    instructionButton.addActionListener(alInstruction);
    mainMenu.add(instructionButton);
    
    JButton creditsButton= new JButton ("Credits");
    creditsButton.setFont(new Font(start.getFont().getName(), Font.PLAIN, 50));
    creditsButton.addActionListener(alCredits);
    mainMenu.add(creditsButton);
    
    JButton back1 = new JButton("Back");
    JButton back2 = new JButton("Back");
    back1.setFont(new Font(start.getFont().getName(), Font.PLAIN, 50));
    back2.setFont(new Font(start.getFont().getName(), Font.PLAIN, 50));
    back1.addActionListener(backInstructions);
    back2.addActionListener(backCredits);
    instructions.add(back1);
    
    JButton quit = new JButton("Quit");
    quit.setFont(new Font(start.getFont().getName(), Font.PLAIN, 50));
    quit.addActionListener(al);
    mainMenu.add(quit);
    
    JLabel jlabel1 = new JLabel("CREDITS");
    JLabel jlabel2 = new JLabel("Images:");
    JLabel jlabel3 = new JLabel("Developers:");
    JLabel space = new JLabel (" ");
    JLabel destroyer = new JLabel("http://www.wallhogs.com/in_stock/category/639?page=2");
    JLabel aircraftcarrier = new JLabel("https://commons.wikimedia.org/wiki/File:Flugzeugtr%C3%A4ger_Silhouette.svg");
    JLabel submarine = new JLabel("http://worldartsme.com/submarine-silhouette-clipart.html#gal_post_108271_submarine-silhouette-clipart-1.jpg");
    JLabel patrolboat = new JLabel("https://it.pinterest.com/pin/288934132325552202/");
    JLabel raft = new JLabel("http://www.supercoloring.com/silhouettes/rafting");
    JLabel waterLink = new JLabel ("https://www.johnweiss.ca/single-post/2016/10/08/The-Water-Element");
    JLabel x = new JLabel ("http://www.freeiconspng.com/png-images/x-png");
    JLabel name1 = new JLabel("Wisley Chen");
    JLabel name2 = new JLabel("Paul Jang");
    JLabel name3 = new JLabel("Leon Wang");
    
    jlabel1.setFont(new Font("Verdana",1,50));
    jlabel2.setFont(new Font("Verdana",1,25));
    jlabel3.setFont(new Font("Verdana",1,25));
    destroyer.setFont(new Font("Verdana",1,20));
    aircraftcarrier.setFont(new Font("Verdana",1,20));
    submarine.setFont(new Font("Verdana",1,20));
    patrolboat.setFont(new Font("Verdana",1,20));
    raft.setFont(new Font("Verdana",1,20));
    waterLink.setFont(new Font("Verdana",1,20));
    x.setFont(new Font("Verdana",1,20));
    name1.setFont(new Font("Verdana",1,20));
    name2.setFont(new Font("Verdana",1,20));
    name3.setFont(new Font("Verdana",1,20));
    
    
    credits.add(jlabel1);
    credits.add(jlabel2);
    credits.add(destroyer);
    credits.add(aircraftcarrier);
    credits.add(submarine);
    credits.add(patrolboat);
    credits.add(raft);
    credits.add(waterLink);
    credits.add(x);
    credits.add(space);
    credits.add(jlabel3);
    credits.add(name1);
    credits.add(name2);
    credits.add(name3);
    credits.add(Box.createRigidArea(new Dimension(0,400)));
    credits.add(back2);
    name1.setForeground (Color.red);
    name2.setForeground (Color.green);
    name3.setForeground (Color.magenta);
    frame.setVisible(true);
    
    credits.setLayout(new BoxLayout(credits, BoxLayout.Y_AXIS));
  
  }
}
