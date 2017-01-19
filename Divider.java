import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Divider extends JPanel {
  
  //Creating 6 JButtons
  JButton[] boatButtons = new JButton[6];
  
  //Declaring final String array size
  public final String[] size = new String[1];
  
  //Declares left filed instance
  LeftField leftField;

  //Creates an instance of left field in divider
   public Divider(LeftField fieldLeft)
  {
    leftField = fieldLeft;
    init();
  }
   
  //Initializes Divider 
  public Divider()
  {
    init();
  }
  
  //Divider constructor
  private void init() {
    
    //Declaring picture variables to call images
    ImageIcon ac=new ImageIcon (this.getClass().getResource("aircraftcarrier.jpg"));
    ImageIcon destroyer=new ImageIcon (this.getClass().getResource("destroyer.jpg"));
    ImageIcon sub=new ImageIcon (this.getClass().getResource("submarine.jpg"));
    ImageIcon patrol=new ImageIcon (this.getClass().getResource("patrol.jpg"));
    ImageIcon raft=new ImageIcon (this.getClass().getResource("raft.jpg"));
    ImageIcon done = new ImageIcon (this.getClass().getResource("done.jpg"));
    
    //Setting layout 
    setLayout(new BorderLayout());
    
    //Creating new JPanel divider
    JPanel divider = new JPanel();
    add(divider, BorderLayout.NORTH); //Adding divider with border layout 
    
    //Adding title of Label
    JLabel title = new JLabel("                                                                    Ships");
    add(title, BorderLayout.NORTH); //Adding title with border layout
    
    //Adding middle panel
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(6 , 1)); //Setting layout of middlePanel
    
    //ActionListener buttonListen = new ActionListener();
    
    
    //For loop to create buttons and adding an action listener to each of them
    for (int i = 5; i >= 0; i--){
      boatButtons[i] = new JButton(); //Creating new button
      boatButtons[i].setName((i+1)+""); //Setting name
      boatButtons[i].setPreferredSize(new Dimension(10,10)); //Setting size of button                               
      //jb[i][j].addActionListener(buttonListen);
      middlePanel.add(boatButtons[i]);
      
      //Adding action listener to each button
      boatButtons[i].addActionListener(new ActionListener(){
                
        public void actionPerformed(ActionEvent event) {
          
          size[0] = ((JButton)event.getSource()).getName();
          
        }
      });     
    }
    
    //Setting each button with appropriate image
    boatButtons[5].setIcon(ac);
    boatButtons[4].setIcon(destroyer);
    boatButtons[3].setIcon(sub);
    boatButtons[2].setIcon(patrol);
    boatButtons[1].setIcon(raft);
    boatButtons[0].setIcon(done);
    
     //Add action listener for all boat buttons       
  boatButtons[1].addActionListener(new ActionListener(){
             
        public void actionPerformed(ActionEvent event) {
          
          boatButtons[1].setEnabled(false);
          
          
        }
      });
  
    
  boatButtons[2].addActionListener(new ActionListener(){
             
        public void actionPerformed(ActionEvent event) {
          
          boatButtons[2].setEnabled(false);
          
          
        }
      });
  
    
  boatButtons[3].addActionListener(new ActionListener(){
             
        public void actionPerformed(ActionEvent event) {
          
          boatButtons[3].setEnabled(false);
          
          
        }
      });
  
    
  boatButtons[4].addActionListener(new ActionListener(){
             
        public void actionPerformed(ActionEvent event) {
          
          boatButtons[4].setEnabled(false);
          
          
        }
      });
    
  boatButtons[5].addActionListener(new ActionListener(){
             
        public void actionPerformed(ActionEvent event) {
          
          boatButtons[5].setEnabled(false);
          
          
        }
      }); //end of action listeners for all boat buttons
    
   //Add action listener for done button 
  boatButtons[0].addActionListener(new ActionListener(){
             
        public void actionPerformed(ActionEvent event) {
          
          for (int i = 5; i >= 0; i--){
          boatButtons[i].setEnabled(false);
          }     

          
        }
      });//end of done button action listener
    
  
   
    add(middlePanel, BorderLayout.CENTER);  
  }
  
  /**
    * getButtons 
    * 
    * @return jb  JButton
    */
  public JButton[] getButtons(){
    return boatButtons;  }
}
