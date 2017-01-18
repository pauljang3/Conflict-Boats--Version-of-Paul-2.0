import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LeftField extends JPanel{
  
  //Creating 15 by 15 array of buttons
  JButton[][] jb = new JButton[15][15];
  int cash = 4000; //Declaring int cash of 4000
  Player p1 = new Player(); //Creating an object for player one
  Divider divider; //Creating divider object
  
  //Calls divider into leftfield
  public LeftField(Divider d){
    divider = d;
    begin();
  }
  
  //Constructor for game process
  private void begin() {
    setLayout(new BorderLayout()); //Setting layout 
    JLabel title = new JLabel("                                               Player 1"); //Setting up title
    add(title, BorderLayout.NORTH); //Adding title with BorderLayout
    
    JPanel middlePanel = new JPanel(); //Creating new JPanel
    middlePanel.setLayout(new GridLayout(15,15)); //Setting layout as gridLayout 
    ActionListener buttonListen = new buttonListener(); //Declaring actionListener for buttons
    
    //For loop to create 15 by 15 array buttons
    for (int i = 0; i < 15; i++){
      for (int j = 0 ; j < 15; j++){
        jb[i][j] = new JButton(); //Creating new buttons for each time it runs through
        jb[i][j].setPreferredSize(new Dimension(10,10)); //Setting up dimensions of each button
        ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg")); //Getting water jpg for buttons
        jb[i][j].setIcon(Water); //Setting image to button
        jb[i][j].addActionListener(buttonListen); //Adding action listener for each button
        middlePanel.add(jb[i][j]); //Adding buttons to middle panel
        
      }
    }
    
    add(middlePanel, BorderLayout.CENTER); //Adding middlepanel and setting BorderLayout
    
    JPanel bottomPanel = new JPanel(); //Creating new bottom panel
    bottomPanel.setLayout(new GridLayout(1,2)); //Setting up bottom panel with gridlayout
    
    //Creating and adding bomb and cash panels
    JPanel bombPanel = new JPanel (); 
    JPanel cashPanel = new JPanel (); 
    bottomPanel.add(bombPanel);
    bottomPanel.add(cashPanel);
    
    //Bomb Panel
    bombPanel.setLayout(new GridLayout(3,1));
    
    //Creating 3 radio buttons for types of missiles
    JRadioButton missileB = new JRadioButton("Missile ($1000)");
    JRadioButton airStrikeB = new JRadioButton("Air Strike ($3000)");
    JRadioButton bombardmentB = new JRadioButton("Bombardment ($10000)");
    
    //Creating new button group
    ButtonGroup group = new ButtonGroup();
    
    //Adding missiles to button group
    group.add(missileB);
    group.add(airStrikeB);
    group.add(bombardmentB);
    
    //Adding buttons to bomb panel
    bombPanel.add(missileB);
    bombPanel.add(airStrikeB);
    bombPanel.add(bombardmentB);
    
    //Adding action listener to each missile
    bombardmentB.addActionListener(new ActionListener (){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "First missile");
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
    cashPanel.setLayout(new GridLayout(2,1)); //Setting up layout for cash panel
    JLabel cashDisplay = new JLabel("                                        CASH: $" + cash); //Adding label for cash
    JButton done = new JButton("CLEAR"); //Creating button for clearing board
    cashPanel.add(cashDisplay); //Adding cash display for cash panel
    cashPanel.add(done); //Adding done button to cash panel
    add(bottomPanel, BorderLayout.SOUTH); //Adding bottom panel with border layout
    
    //Creating action listener for done 
    done.addActionListener(new ActionListener (){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "Clearing board..");
        //For loop to reset each button with icon of water
        for (int i = 0; i < 15; i++){
          for (int j = 0 ; j < 15; j++){
            ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
            jb[i][j].setIcon(Water);
          }
        }
      }           
    });    
  }
  
  /**
    * getPlayer method                               
    * @return p1  Player one
    */
  public Player getPlayer(){
    return p1; 
  }
  
  //Action listener for water buttons
  class buttonListener implements ActionListener {
    
    public void actionPerformed(ActionEvent event) {
      for(int i=0;i<jb.length;i++){
        for(int j=0;j<jb[0].length;j++){
          jb[i][j].setEnabled(true);          
          if(jb[i][j]==event.getSource()){
                   
            String Direction = null;
            
            Direction = JOptionPane.showInputDialog (null, "Please choose a direction");
            boolean isValid = false; //Setting valid ship placement to false 
            
            //While loop for error checking of ship placement
            while (!isValid){
              
              //If user chooses North Direction
              if (!Direction.substring(0,1).equalsIgnoreCase("N") && !Direction.substring(0,1).equalsIgnoreCase("E") && 
                  !Direction.substring(0,1).equalsIgnoreCase("W") && !Direction.substring(0,1).equalsIgnoreCase("S")){
                JOptionPane.showMessageDialog (null, "Sorry, you did not enter a direction, please enter 'North', 'East', 'South', or 'West'.");
                isValid = false;
              } else {
                
                isValid = true;     
              }
              
            } 
            
            //If loop to see if placement of ship is outside of board
            if (!isPositionValid(i, j, Direction.substring(0,1), Integer.parseInt(divider.size[0]))){
              JOptionPane.showMessageDialog(null, "Invalid Position! Please try again!");
              return;
            }
            
            //If user chooses North Direction
            if (Direction.substring(0,1).equalsIgnoreCase("N")){
              for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                ImageIcon destroyer=new ImageIcon (this.getClass().getResource("x.jpg"));
                jb[i-a][j].setIcon(destroyer); 
                p1.getShips()[Integer.parseInt(divider.size[0])-1].setSize(Integer.parseInt(divider.size[0]));
                p1.setShipPosition(i-a, j, Integer.parseInt(divider.size[0]));
                p1.getShips()[Integer.parseInt(divider.size[0])-1].setDirection("N");
                System.out.println((i-a) + ", " + j + ", " + p1.getShipPosition(i-a, j));
                
              }//end of for loop
            }
            
            //If user chooses East Direction
            if (Direction.substring(0,1).equalsIgnoreCase("E")){
              for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                ImageIcon destroyer=new ImageIcon (this.getClass().getResource("x.jpg"));
                jb[i][j+a].setIcon(destroyer); 
                p1.getShips()[Integer.parseInt(divider.size[0])-1].setSize(Integer.parseInt(divider.size[0]));
                p1.setShipPosition(i, j+a, Integer.parseInt(divider.size[0]));     
                p1.getShips()[Integer.parseInt(divider.size[0])-1].setDirection("E");
              }
            }
            //If user chooses West Direction
            if (Direction.substring(0,1).equalsIgnoreCase("W")){
              for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                ImageIcon destroyer=new ImageIcon (this.getClass().getResource("x.jpg"));
                jb[i][j-a].setIcon(destroyer); 
                p1.getShips()[Integer.parseInt(divider.size[0])-1].setSize(Integer.parseInt(divider.size[0]));
                p1.setShipPosition(i, j-a, Integer.parseInt(divider.size[0]));   
                p1.getShips()[Integer.parseInt(divider.size[0])-1].setDirection("W");
              }
            }
            
            //If user chooses South Direction
            if (Direction.substring(0,1).equalsIgnoreCase("S")){
              for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                ImageIcon destroyer=new ImageIcon (this.getClass().getResource("x.jpg"));
                jb[i+a][j].setIcon(destroyer); 
                p1.getShips()[Integer.parseInt(divider.size[0])-1].setSize(Integer.parseInt(divider.size[0]));
                p1.setShipPosition(i+a, j, Integer.parseInt(divider.size[0]));         
                p1.getShips()[Integer.parseInt(divider.size[0])-1].setDirection("S");
              }
            }
            System.out.println("###### " + divider.size[0]); //Printing size of ship in console          
          }          
        }
      }     
    }
    
    /**
      * isPositionValid Method                          
      * @param i          x-value of ship placement coordinate   
      * @param j          y-value of ship placement coordinate  
      * @param direction  User-entered direction
      * @param size       Size of selected ship
      * @return result    Boolean value to see if placement is valid
      */
    boolean isPositionValid(int i, int j, String direction, int size){
      boolean result = true;
      System.out.println("# " + i + ", " + j + ", " + direction + ", " + size);
      if (direction.equalsIgnoreCase("N")){
        System.out.println("NNN " + i + ", " + j + ", " + direction + ", " + size);       
        if (i - size < -1) {
          System.out.println("size "+ i + ", " + j + ", " + direction + ", " + size);
          result =  false;
          
        }
        else {
          for (int k = i; k > i - size; k--){
            System.out.println("*** " + k + ", " + j + ", " + p1.getShipPosition(k,j));
            if (p1.getShipPosition(k, j) != 0) result = false;
          }
        }
        
        
      } else if (direction.equalsIgnoreCase("S")){
        if (i + size > 15) result =  false;
        else {
          for (int k = i; k < i + size; k ++) {
            
            if (p1.getShipPosition(k,j) !=0) result = false;
          }
        }
        
      } else if (direction.equalsIgnoreCase("E")){
        if (j + size > 15) result = false;
        else {
          for (int k = j; k < j + size; k++){
            if (p1.getShipPosition(i,k)!= 0 ) result = false;
          }
        }
      }
        else {
          if (j - size < -1) result = false;
          else {
            for(int k = j; k > j - size; k--) {
              if (p1.getShipPosition(i,k)!=0) result = false;
            }
          }          
        }         
        return result;
      }       
    }   
  
  }//end of whole THING HERE
  
  
  
  
