import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class LeftField extends JPanel{

  //Creation of variables
  JButton[][] jb = new JButton[15][15];
  int cash = 4000;
  Player p1 = new Player();
  Divider divider;
  
  public LeftField(Divider d){
    divider = d;
    begin();
  }
  
  
  
  private void begin() {
    //Sets BorderLayout for LeftField 
    setLayout(new BorderLayout());
    
    //Creates new title on the top, showing Player 1's board
    JLabel title = new JLabel("                                               Player 1");
    add(title, BorderLayout.NORTH);
    
    //------------------MIDDLE PANEL CREATION------------------
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(15,15)); //Sets GridLayout for water buttons
    ActionListener buttonListen = new buttonListener(); //Creates action listener for water buttons
    
    //Creation of 15 by 15 box of buttons
    for (int i = 0; i < 15; i++){
      for (int j = 0 ; j < 15; j++){
        jb[i][j] = new JButton();
        jb[i][j].setPreferredSize(new Dimension(10,10)); //Sets size of buttons
        
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
    bottomPanel.setLayout(new GridLayout(1,2)); //Sets GridLayout to (1,2) so bombPanel and cashPanel can be placed 
    
    //Declares bomb and clear sub-panels
    JPanel bombPanel = new JPanel (); 
    JPanel clearPanel = new JPanel (); 
    
    //Adds the sub-panels to the bottom panel
    bottomPanel.add(bombPanel); 
    bottomPanel.add(clearPanel); 
       
    //******BOMB PANEL******
    bombPanel.setLayout(new GridLayout(3,1)); //Sets GridLayout to (3,1) for bomb panel so that 3 radio buttons can be placed
    
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
   
    //Action listner for missile option
    missileB.addActionListener(new ActionListener (){
      
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "First action listener");
        
      }     
    }); 
    
    //Action listner for air strike option
    airStrikeB.addActionListener(new ActionListener (){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "Second action listener");
      }
    });
    
    //Action listner for bombardment option
    bombardmentB.addActionListener(new ActionListener (){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "Third action listener");
      }    
    }); 
    

    
    
    
    
    
    //******CLEAR PANEL******
    clearPanel.setLayout(new GridLayout(2,1)); 
    JLabel cashDisplay = new JLabel("                                        CASH: $" + cash); //Displays player's cash
    JButton clear = new JButton("CLEAR"); //Creates new clear button
    
    //Adds the cashDisplay and clear to the clear panel
    clearPanel.add(cashDisplay);
    clearPanel.add(clear);
    
    clear.addActionListener(new ActionListener (){
      
      //Clear function action listener
      public void actionPerformed(ActionEvent e){       
        for (int i = 0; i < 15; i++){
              for (int j = 0 ; j < 15; j++){
                ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg")); 
                jb[i][j].setIcon(Water); //Resets all the buttons to the water image
              }
        }
      }
      
      
    }); //End of action listener for clear function
    
        add(bottomPanel, BorderLayout.SOUTH); //Puts the bottomPanel in the bttom of border layout     
    
  } //end of begin()
  
  public Player getPlayer(){
    return p1; 
  }
  
  
  
  //Boat placement action listener
  class buttonListener implements ActionListener {
    
    public void actionPerformed(ActionEvent event) {
    
    //Apply action listener to all water buttons  
      for(int i=0;i<jb.length;i++){
        for(int j=0;j<jb[0].length;j++){

          //If a water button is pressed
          if(jb[i][j]==event.getSource()){
            

           String Direction = null;
        
          Direction = JOptionPane.showInputDialog (null, "Please choose a direction");
          boolean isValid = false;   
           while (!isValid){
        

            if (!Direction.substring(0,1).equalsIgnoreCase("N") && !Direction.substring(0,1).equalsIgnoreCase("E") && 
              !Direction.substring(0,1).equalsIgnoreCase("W") && !Direction.substring(0,1).equalsIgnoreCase("S")){
               JOptionPane.showInputDialog (null, "Sorry, you did not enter a direction, please enter 'North', 'East', 'South', or 'West'.");
               isValid = false;
             }
            
            else {
               isValid = true;     
             }
        
           }
           
           
           if (!isPositionValid(i, j, Direction.substring(0,1), Integer.parseInt(divider.size[0]))){
             JOptionPane.showMessageDialog(null, "Wrong Position! Try Again!");
             return;
           }
        
      //If user chooses North Direction 
        if (Direction.substring(0,1).equalsIgnoreCase("N")){
            for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                    ImageIcon shipImage=new ImageIcon (this.getClass().getResource("ship.jpg"));
                    jb[i-a][j].setIcon(shipImage);  
            }
        } //end of north option
        
        //If user chooses South Direction
        if (Direction.substring(0,1).equalsIgnoreCase("S")){
            for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                    ImageIcon shipImage=new ImageIcon (this.getClass().getResource("ship.jpg"));
                    jb[i+a][j].setIcon(shipImage); 
              
            }
        } //end of south direction
        
        //If user chooses East Direction
        if (Direction.substring(0,1).equalsIgnoreCase("E")){
             for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                    ImageIcon shipImage=new ImageIcon (this.getClass().getResource("ship.jpg"));
                    jb[i][j+a].setIcon(shipImage); 
             }
        } //end of east direction
        
        //If user chooses West Direction
        if (Direction.substring(0,1).equalsIgnoreCase("W")){
             for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                    ImageIcon shipImage=new ImageIcon (this.getClass().getResource("ship.jpg"));
                    jb[i][j-a].setIcon(shipImage); 
             }
        } //end of west direction
        
        
            
          }

        }
      }
      
    }
    
    boolean isPositionValid(int i, int j, String direction, int size){
      boolean result = true;
      if (direction.equalsIgnoreCase("N")){
        
        if (i - size < -1) result =  false;
        else {
          for (int k = i; k < i + size; k++){
            if (p1.getShipPosition(k, j) != 0) result = false;
          }
        }
        
        
      } else if (direction.equalsIgnoreCase("S")){
        if (i + size > 15) result =  false;
       
      } else if (direction.equalsIgnoreCase("E")){
        
      } else {
        
      }
      
      
      return result;
    } 
    
  }//End of action listener for water buttons
  
  
             
    
  }//end of whole LeftField class
  
  
  
  
