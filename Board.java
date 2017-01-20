/* Conflicts Boats
 * You play against a computer, and try to hit their ships
 * Wisley Chen, Paul Jang, Leon Wang
 * January 20, 2017
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

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
    final RightField rightField = new RightField(leftField);
    
    final JPanel credits = new JPanel ();    
    
    //Sets up instruction panel image
    final JPanel instructions = new JPanel ();
    ImageIcon instructionsImage = new ImageIcon ("instructionsImage.jpg");
    JLabel imageLabel2 = new JLabel(instructionsImage);
    instructions.add(imageLabel2);
    
    //Sets up main menu background
    final JPanel mainMenu = new JPanel();    
    frame.add(mainMenu);

    
    //Setting up game window 
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    
   
//------------------ACTION LISTENER FOR MAIN MENU BUTTONS------------------
    ActionListener al = new ActionListener(){
      public void actionPerformed(ActionEvent e){
        
        //If the button is pressed
        if(!(e.getSource() instanceof JButton)){
          return; 
        }
        
        JButton button = (JButton) e.getSource();
        
        //If start button is pressed
        if(button.getText().equalsIgnoreCase("Start")){
          frame.remove(mainMenu);
          frame.add(leftField);
          frame.add(divider);
          frame.add(rightField);
          frame.validate(); 
        }//end of start 
        
        //If credits button is pressed        
        else if(button.getText().equalsIgnoreCase("Credits")){
          frame.remove(mainMenu);
          frame.add(credits);
          frame.validate();         
        }//end of credits
        
        //If instructions button is pressed
        else if(button.getText().equalsIgnoreCase("Instructions")){
          frame.remove(mainMenu);
          frame.add(instructions);
          frame.validate();       
        }//end of instructions
        
        //If quit button is pressed
        else if(button.getText().equalsIgnoreCase("Quit")){
          System.exit(0); 
        }//end of quit
        
      }   
    };//end of action listener
    
    //Creation of main menu buttons
    JButton start = new JButton ("Start");
    start.setFont(new Font(start.getFont().getName(), Font.PLAIN, 50));
    start.addActionListener(al);
    mainMenu.add(start);
    
    JButton instructionButton = new JButton("Instructions");
    instructionButton.setFont(new Font(start.getFont().getName(), Font.PLAIN, 50));
    instructionButton.addActionListener(al);
    mainMenu.add(instructionButton);
    
    JButton creditsButton= new JButton ("Credits");
    creditsButton.setFont(new Font(start.getFont().getName(), Font.PLAIN, 50));
    creditsButton.addActionListener(al);
    mainMenu.add(creditsButton);
    
    JButton quit = new JButton("Quit");
    quit.setFont(new Font(start.getFont().getName(), Font.PLAIN, 50));
    quit.addActionListener(al);
    mainMenu.add(quit);
    
//------------------CREDIT SCREEN CREATION------------------
    
    //Adds all the text 
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
    JLabel background = new JLabel ("http://wonderfulengineering.com/amazing-hd-navy-wallpapers-and-backgrounds-for-free-download/");
    JLabel name1 = new JLabel("Wisley Chen");
    JLabel name2 = new JLabel("Paul Jang");
    JLabel name3 = new JLabel("Leon Wang");
    
    //Sets font and size for all the text
    jlabel1.setFont(new Font("Verdana",1,50));
    jlabel2.setFont(new Font("Verdana",1,25));
    jlabel3.setFont(new Font("Verdana",1,25));
    destroyer.setFont(new Font("Verdana",1,20));
    aircraftcarrier.setFont(new Font("Verdana",1,20));
    submarine.setFont(new Font("Verdana",1,20));
    patrolboat.setFont(new Font("Verdana",1,20));
    raft.setFont(new Font("Verdana",1,20));
    waterLink.setFont(new Font("Verdana",1,20));
    background.setFont(new Font("Verdana",1,20));
    name1.setFont(new Font("Verdana",1,20));
    name2.setFont(new Font("Verdana",1,20));
    name3.setFont(new Font("Verdana",1,20));
    
    //Adds all of text to the panel
    credits.add(jlabel1);
    credits.add(jlabel2);
    credits.add(destroyer);
    credits.add(aircraftcarrier);
    credits.add(submarine);
    credits.add(patrolboat);
    credits.add(raft);
    credits.add(waterLink);
    credits.add(background);
    credits.add(space);
    credits.add(jlabel3);
    credits.add(name1);
    credits.add(name2);
    credits.add(name3);
    
    //Sets some text to different colours
    name1.setForeground (Color.red);
    name2.setForeground (Color.green);
    name3.setForeground (Color.magenta);
    
    //Sets credits page as a box layout
    credits.setLayout(new BoxLayout(credits, BoxLayout.Y_AXIS));
    
       
  }//end of main
}//end of board
