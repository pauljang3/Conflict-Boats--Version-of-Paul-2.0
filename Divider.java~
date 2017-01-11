
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Divider extends JPanel {
  
  JButton[][] jb = new JButton[15][15];
  public Divider()
  {
    init();
  }
  private void init() {
    ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
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
    middlePanel.setLayout(new GridLayout(15,15));
    // ActionListener buttonListen = new ActionListener();
    for (int i = 7; i < 8; i++){
      for (int j = 0 ; j < 8; j++){
        jb[i][j] = new JButton();
        jb[i][j].setPreferredSize(new Dimension(10,10));                                
        //  jb[i][j].addActionListener(buttonListen);
        middlePanel.add(jb[i][j]);
      }
    }
    jb[7][0].setIcon(ac);
    jb[7][1].setIcon(destroyer);
    jb[7][2].setIcon(sub);
    jb[7][3].setIcon(patrol);
    
    add(middlePanel, BorderLayout.CENTER);
    
  }
}
