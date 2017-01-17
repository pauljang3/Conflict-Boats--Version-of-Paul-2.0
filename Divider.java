import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Divider extends JPanel {
  
  //Creating 5 new buttons for selection of ships
  JButton[] jb = new JButton[5];
  
  //Setting up final variable array size
  public final String[] size = new String[1];
  
  //Calls divider class
  public Divider()
  {
    init();
  }
  
  //Constructor for divider
  private void init() {
    
    //Declaring and getting 5 images of boats
    ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
    ImageIcon ac=new ImageIcon (this.getClass().getResource("aircraftcarrier.jpg"));
    ImageIcon destroyer=new ImageIcon (this.getClass().getResource("destroyer.jpg"));
    ImageIcon sub=new ImageIcon (this.getClass().getResource("submarine.jpg"));
    ImageIcon patrol=new ImageIcon (this.getClass().getResource("patrol.jpg"));
    
    //Setting layout as border layout
    setLayout(new BorderLayout());
   
    //Setting divider panel 
    JPanel divider = new JPanel();
    add(divider, BorderLayout.NORTH);
    
    //Adding title
    JLabel title = new JLabel("                                                                                                 Ships");
    add(title, BorderLayout.NORTH);
    
    //Creating middle panel
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(6 , 1));
    
    // ActionListener b5ttonListen = new ActionListener();
    for (int i = 4; i >= 0; i--){
        jb[i] = new JButton();
        jb[i].setName((i+1)+"");
        jb[i].setPreferredSize(new Dimension(10,10));                                
        //  jb[i][j].addActionListener(buttonListen);
        middlePanel.add(jb[i]);
        jb[i].addActionListener(new ActionListener(){
          
          public void actionPerformed(ActionEvent event) {                       
            System.out.println(((JButton)event.getSource()).getName());
            size[0] = ((JButton)event.getSource()).getName();
          }        
        });
    }
    
    //Setting the 4 buttons with images
    jb[4].setIcon(ac);
    jb[3].setIcon(destroyer);
    jb[2].setIcon(sub);
    jb[1].setIcon(patrol);
    
    //Adding final middle panel
    add(middlePanel, BorderLayout.CENTER); 
  }
  
  public JButton[] getButtons(){
    return jb;
  } //End of getButton method
  
}//end of Divider Class
