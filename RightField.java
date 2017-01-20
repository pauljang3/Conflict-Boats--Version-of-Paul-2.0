import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class RightField extends JPanel{
  
  //Declares cariables
  JButton[][] jb = new JButton[15][15];
  int cash = 4000;
  LeftField lf; 
  
  //Creates an instance of left field, so that parts of it can be called
  public RightField(LeftField lf){
    this.lf = lf;
    begin();
  }
  
  //Start putting everythng in right field
  private void begin() {
    
    //Sets the layout to Border Layout
    setLayout(new BorderLayout());
    
    //Adds a title to display it's a computer playing
    JLabel title = new JLabel("                                                    Computer");
    add(title, BorderLayout.NORTH);
    
    //------------------MIDDLE PANEL CREATION------------------
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(15,15));//Sets GridLayout for water buttons
    ActionListener buttonListen = new buttonListener();//Creates action listener for water buttons
    
    //Creation of 15 by 15 box of buttons
    for (int i = 0; i < 15; i++){
      for (int j = 0 ; j < 15; j++){
        jb[i][j] = new JButton();
        jb[i][j].setPreferredSize(new Dimension(10,10));//Sets size of buttons
        
        //Gets water image, stored in water.jpg
        ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
        
        //Sets water as the image for all buttons
        jb[i][j].setIcon(Water);
        jb[i][j].addActionListener(buttonListen);
        middlePanel.add(jb[i][j]);
      }
    }//end of for loop for creation of buttons
    
    //Puts the middlePanel in the center of border layout
    add(middlePanel, BorderLayout.CENTER);
    
    //------------------BOTTOM PANEL CREATION------------------ 
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(1,2));//Sets GridLayout to (1,2) so bombPanel and cashPanel can be placed 
    
    //Declares bomb and clear sub-panels
    JPanel bombPanel = new JPanel ();
    JPanel cashPanel = new JPanel ();
    
    //Adds the sub-panels to the bottom panel
    bottomPanel.add(bombPanel);
    bottomPanel.add(cashPanel);
    
    //******bomb panel******
    bombPanel.setLayout(new GridLayout(3,1));
    
    //Declares the radio buttons
    JRadioButton missileB = new JRadioButton("Missile ($1000)");
    JRadioButton airStrikeB = new JRadioButton("Air Strike ($3000)");
    JRadioButton bombardmentB = new JRadioButton("Bombardment ($10000)");
    
    //Creates a new group for the 3 radio buttons and adds them to the new group
    ButtonGroup group = new ButtonGroup();
    group.add(missileB);
    group.add(airStrikeB);
    group.add(bombardmentB);
    
    //Adds the radio buttons to the bomb panel
    bombPanel.add(missileB);
    bombPanel.add(airStrikeB);
    bombPanel.add(bombardmentB);
    
    missileB.addActionListener(new ActionListener (){
      
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "First action listener");
        
      }
      
      
    }); 
    
    airStrikeB.addActionListener(new ActionListener (){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "Second action listener");
      }
    });
    
    bombardmentB.addActionListener(new ActionListener (){
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
      
      
      //***RANDOM BOAT PLACEMENT***
      for(int a=0;a<15;a++){  
        for(int b=0;b<15;b++){ 
          reference[a][b]=0;
        } 
      }
      
      for (int i=0;i<100;i++){
        int a = (int) (Math.random()*15);
        int b = (int) (Math.random()*15);
        reference[a][b]=-1; 
      }
      
      
    }
    
    
   
    
    
    
    
    public void actionPerformed(ActionEvent event) {
      
      
      
      for(int i=0;i<jb.length;i++){
        for(int j=0;j<jb[0].length;j++){
          
          
          if(jb[i][j]==event.getSource()){
            
            if (reference [i][j] ==-1){
              jb[i][j].setEnabled(true);
              ImageIcon xImage=new ImageIcon (this.getClass().getResource("x.jpg"));
              ImageIcon missImage=new ImageIcon (this.getClass().getResource("waterMiss.jpg"));
              jb[i][j].setIcon(xImage);
              
              int a = (int) (Math.random()*15);
              int b = (int) (Math.random()*15);
              
              if (lf.referenceBoard[a][b] == -1){
                lf.jb[a][b].setIcon(missImage);
              }
              
              if (lf.referenceBoard[a][b] == 0){
                lf.jb[a][b].setIcon(xImage);
              }
              
              
              
            }
            
            if(reference[i][j] ==0){
              jb[i][j].setEnabled(true);
              ImageIcon xImage=new ImageIcon (this.getClass().getResource("x.jpg"));
              ImageIcon missImage=new ImageIcon (this.getClass().getResource("waterMiss.jpg"));
              jb[i][j].setIcon(missImage);   
              
              
              int a = (int) (Math.random()*15);
              int b = (int) (Math.random()*15);
              
              if (lf.referenceBoard[a][b] == -1){
                lf.jb[a][b].setIcon(missImage);
              }
              
              if (lf.referenceBoard[a][b] == 0){
                lf.jb[a][b].setIcon(xImage);
              }
            }
            
            
            
            
            
            
            
            
          }
        }       
      }//end of for loop for buttons
    }//end of action listener         
  }//end of action listener class
  
}//end of WHOLE THING


