import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Divider extends JPanel {
  
  //Creating 6 JButtons
  JButton[] jb = new JButton[6];
  
  //Declaring final String array size
  public final String[] size = new String[1];

  //Divider 
  public Divider()
  {
    init();
  }
  
  //Divider constructor
  private void init() {
    
    //Declaring picture variables to call images
    ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
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
    JLabel title = new JLabel("                                                                                                 Ships");
    add(title, BorderLayout.NORTH); //Adding title with border layout
    
    //Adding middle panel
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(6 , 1)); //Setting layout of middlePanel
    
    //ActionListener buttonListen = new ActionListener();
    //For loop to create buttons and adding an action listener to each of them
    for (int i = 5; i >= 0; i--){
      jb[i] = new JButton(); //Creating new button
      jb[i].setName((i+1)+""); //Setting name
      jb[i].setPreferredSize(new Dimension(10,10)); //Setting size of button                               
      //jb[i][j].addActionListener(buttonListen);
      middlePanel.add(jb[i]);
      
      //Adding action listener to each button
      jb[i].addActionListener(new ActionListener(){
                
        public void actionPerformed(ActionEvent event) {
          
          size[0] = ((JButton)event.getSource()).getName();
          
        }

      });
      
    }
    
    //Setting each button with appropriate image
    jb[5].setIcon(ac);
    jb[4].setIcon(destroyer);
    jb[3].setIcon(sub);
    jb[2].setIcon(patrol);
    jb[1].setIcon(raft);
    jb[0].setIcon(done);
    
    add(middlePanel, BorderLayout.CENTER);
    
  }
  
  /**
    * getButtons 
    * 
    * @return jb  JButton
    */
  public JButton[] getButtons(){
    return jb;
  }
  
  
}
