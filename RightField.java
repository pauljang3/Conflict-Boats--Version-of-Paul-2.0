import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class RightField extends JPanel{
  
  JButton[][] jb = new JButton[15][15];
  int cash = 4000;
  Divider divider;
  public RightField(Divider d){
    Divider = d;
    begin();
  }
  
  
  
  private void begin() {
    setLayout(new BorderLayout());
    JLabel title = new JLabel("                                               Player 2");
    add(title, BorderLayout.NORTH);
    
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(15,15));
    ActionListener buttonListen = new buttonListener();
    for (int i = 0; i < 15; i++){
      for (int j = 0 ; j < 15; j++){
        jb[i][j] = new JButton();
        jb[i][j].setPreferredSize(new Dimension(10,10));
        ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
        jb[i][j].setIcon(Water);
        jb[i][j].addActionListener(buttonListen);
        middlePanel.add(jb[i][j]);
      }
    }
    
    
    add(middlePanel, BorderLayout.CENTER);
    
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(1,2));
    JPanel bombPanel = new JPanel ();
    JPanel cashPanel = new JPanel ();
    
    bottomPanel.add(bombPanel);
    bottomPanel.add(cashPanel);
    //Bomb Panel
    bombPanel.setLayout(new GridLayout(3,1));
    
    
    JRadioButton missileB = new JRadioButton("Missile ($1000)");
    JRadioButton airStrikeB = new JRadioButton("Air Strike ($3000)");
    JRadioButton bombardmentB = new JRadioButton("Bombardment ($10000)");
    
    ButtonGroup group = new ButtonGroup();
    
    group.add(missileB);
    group.add(airStrikeB);
    group.add(bombardmentB);
    
    bombPanel.add(missileB);
    bombPanel.add(airStrikeB);
    bombPanel.add(bombardmentB);
    
    bombardmentB.addActionListener(new ActionListener (){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "First action listener");
      }
      
      
    }); 
    
    missileB.addActionListener(new ActionListener (){
      
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "Second action listener");
        
      }
      
      
    }); 
    
    airStrikeB.addActionListener(new ActionListener (){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "Third action listener");
      }
    });
    
    
    
    
    //CLEAR Panel
    cashPanel.setLayout(new GridLayout(2,1));
    JLabel cashDisplay = new JLabel("                                        CASH: $" + cash);
    JButton done = new JButton("CLEAR");
    cashPanel.add(cashDisplay);
    cashPanel.add(done);
    add(bottomPanel, BorderLayout.SOUTH);
    
    done.addActionListener(new ActionListener (){
      
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "I want to clear everything");
        
        for (int i = 0; i < 15; i++){
              for (int j = 0 ; j < 15; j++){
                ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
                jb[i][j].setIcon(Water);
              }
        }
      }
      
      
    }); 
    
  }
  
  
  //Action listener for water buttons
  class buttonListener implements ActionListener {
    
    int buttonpress=1;
    
    int[] storea = new int[5];
    int[] storeb = new int[5];
    
    int reference [][]; {
      reference = new int [15][15];
      
      
      //***SAMPLE BOAT PLACEMENT***
      for(int a=0;a<15;a++){  
        for(int b=0;b<15;b++){ 
          reference[a][b]=0;
        } 
       }
      
      for (int i=0;i<15;i++){
      int a = (int) (Math.random()*15);
       int b = (int) (Math.random()*15);
          reference[a][b]=-1;    
      }
             
      
      
    }
    
    
    //Test case for boat placement
    
    
    
    
    public void actionPerformed(ActionEvent event) {
      
      
      
      for(int i=0;i<jb.length;i++){
        for(int j=0;j<jb[0].length;j++){
          
          
          if(jb[i][j]==event.getSource()){

            if (reference [i][j] ==-1){
            jb[i][j].setEnabled(true);
            ImageIcon xImage=new ImageIcon (this.getClass().getResource("x.jpg"));
            jb[i][j].setIcon(xImage);
            }
            
            if(reference[i][j] ==0){
             jb[i][j].setEnabled(true);
            ImageIcon missImage=new ImageIcon (this.getClass().getResource("waterMiss.jpg"));
            jb[i][j].setIcon(missImage);
              
              
            }
            
             
            
            
            
            
          }
        }       
      }//end of for loop for buttons
    }//end of action listener         
  }//end of action listener class
  
}//end of WHOLE THING


