import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Divider extends JPanel {
  
  //Creating five buttons for selection of boats
  JButton[] boatButtons = new JButton[5];
  
  public final String[] size = new String[1];
  
  public Divider()
  {
    init();
  }
  private void init() {
    ImageIcon ac=new ImageIcon (this.getClass().getResource("aircraftcarrier.jpg"));
    ImageIcon destroyer=new ImageIcon (this.getClass().getResource("destroyer.jpg"));
    ImageIcon sub=new ImageIcon (this.getClass().getResource("submarine.jpg"));
    ImageIcon patrol=new ImageIcon (this.getClass().getResource("patrol.jpg"));
    
    setLayout(new BorderLayout());
    JPanel divider = new JPanel();
    add(divider, BorderLayout.NORTH);
    
    
    JLabel title = new JLabel("                                                                                                 Ships");
    add(title, BorderLayout.NORTH);
    
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(6 , 1));
    // ActionListener buttonListen = new ActionListener();
    for (int i = 4; i >= 0; i--){
        boatButtons[i] = new JButton();
        boatButtons[i].setName((i+1)+"");
        boatButtons[i].setPreferredSize(new Dimension(10,10));                                
        //  jb[i][j].addActionListener(buttonListen);
        middlePanel.add(boatButtons[i]);
        boatButtons[i].addActionListener(new ActionListener(){
          
          public void actionPerformed(ActionEvent event) {
            
            
            System.out.println(((JButton)event.getSource()).getName());
            size[0] = ((JButton)event.getSource()).getName();
            
          }
          
        });
      
    }
    boatButtons[4].setIcon(ac);
    boatButtons[3].setIcon(destroyer);
    boatButtons[2].setIcon(sub);
    boatButtons[1].setIcon(patrol);
    
    add(middlePanel, BorderLayout.CENTER);
    
  }
  
  public JButton[] getButtons(){
    return boatButtons;
  }
  

}
