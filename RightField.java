import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class RightField extends JPanel{
  
  //Creating 15 by 15 JButtons
  JButton[][] jb = new JButton[15][15];
  
  //Declaring integer cash
  int cash = 4000;
  
  //Setting up new object player
  Player p2 = new Player();
  
  //Creating divider object named divider
  Divider divider;
  
  //Creating right field
  public RightField(Divider d){
    divider = d;
    begin();
  }
 
  //Right Field Constructor
  private void begin() {
    
    //Setting up border layout
    setLayout(new BorderLayout());
    
    //Setting title as Player two
    JLabel title = new JLabel("                                               Player 2");
    add(title, BorderLayout.NORTH);
    
    //Setting up middle panel
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(15,15)); //Creating new GridLayout for the buttons
    ActionListener buttonListen = new buttonListener(); //Creating actionlistener
    
    //Creating for loop to allow buttons to be created
    for (int i = 0; i < 15; i++){
      for (int j = 0 ; j < 15; j++){
        jb[i][j] = new JButton();
        jb[i][j].setPreferredSize(new Dimension(10,10)); //Setting up button dimension size
        ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));//Creating water image for each button
        jb[i][j].setIcon(Water); //Setting image
        jb[i][j].addActionListener(buttonListen); //Adding action listener for each button
        middlePanel.add(jb[i][j]); //Adding buttons to middle panel
        
      }
    }
    
    //Setting border layout to center
    add(middlePanel, BorderLayout.CENTER);
    
    //Creating bottomPanel
    JPanel bottomPanel = new JPanel();
    
    //Setting up Gridlayout
    bottomPanel.setLayout(new GridLayout(1,2));
    
    //Declaring and adding bomb and cash panel
    JPanel bombPanel = new JPanel ();
    JPanel cashPanel = new JPanel ();
    bottomPanel.add(bombPanel);
    bottomPanel.add(cashPanel);
       
    //Bomb Panel
    bombPanel.setLayout(new GridLayout(3,1));
    
    //Creating 3 radio buttons for different types of missiles
    JRadioButton missileB = new JRadioButton("Missile ($1000)");
    JRadioButton airStrikeB = new JRadioButton("Air Strike ($3000)");
    JRadioButton bombardmentB = new JRadioButton("Bombardment ($10000)");
    
    //Creating new buttongroup 
    ButtonGroup group = new ButtonGroup();
    
    //Adding each button to group
    group.add(missileB);
    group.add(airStrikeB);
    group.add(bombardmentB);
    
    //Adding each button to bombPanel
    bombPanel.add(missileB);
    bombPanel.add(airStrikeB);
    bombPanel.add(bombardmentB);
    
    //Missile Action Listeners
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
        
        //For loop that sets image to each button 
        for (int i = 0; i < 15; i++){
          for (int j = 0 ; j < 15; j++){
            ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
            jb[i][j].setIcon(Water);
          }
        }
      }           
    });   
  }
  
  //getPlayer method that returns player two value
  public Player getPlayer(){
    return p2; 
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
            boolean isValid = false;   
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
            if (!isPositionValid(i, j, Direction.substring(0,1), Integer.parseInt(divider.size[0]))){
              JOptionPane.showMessageDialog(null, "Invalid Position! Please try again!");
              return;
            }
            
            //If user chooses North Direction
            if (Direction.substring(0,1).equalsIgnoreCase("N")){
              for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                ImageIcon destroyer=new ImageIcon (this.getClass().getResource("x.jpg"));
                jb[i-a][j].setIcon(destroyer); 
                p2.getShips()[Integer.parseInt(divider.size[0])-1].setSize(Integer.parseInt(divider.size[0]));
                p2.setShipPosition(i-a, j, Integer.parseInt(divider.size[0]));
                p2.getShips()[Integer.parseInt(divider.size[0])-1].setDirection("N");
          //      System.out.println((i-a) + ", " + j + ", " + p2.getShipPosition(i-a, j));
                
              }//end of for loop
            }
            
            //If user chooses East Direction
            if (Direction.substring(0,1).equalsIgnoreCase("E")){
              for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                ImageIcon destroyer=new ImageIcon (this.getClass().getResource("x.jpg"));
                jb[i][j+a].setIcon(destroyer); 
                p2.getShips()[Integer.parseInt(divider.size[0])-1].setSize(Integer.parseInt(divider.size[0]));
                p2.setShipPosition(i, j+a, Integer.parseInt(divider.size[0]));     
                p2.getShips()[Integer.parseInt(divider.size[0])-1].setDirection("E");
              }
            }
            //If user chooses West Direction
            if (Direction.substring(0,1).equalsIgnoreCase("W")){
              for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                ImageIcon destroyer=new ImageIcon (this.getClass().getResource("x.jpg"));
                jb[i][j-a].setIcon(destroyer); 
                p2.getShips()[Integer.parseInt(divider.size[0])-1].setSize(Integer.parseInt(divider.size[0]));
                p2.setShipPosition(i, j-a, Integer.parseInt(divider.size[0]));   
                p2.getShips()[Integer.parseInt(divider.size[0])-1].setDirection("W");
              }
            }
            
            //If user chooses South Direction
            if (Direction.substring(0,1).equalsIgnoreCase("S")){
              for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                ImageIcon destroyer=new ImageIcon (this.getClass().getResource("x.jpg"));
                jb[i+a][j].setIcon(destroyer); 
                p2.getShips()[Integer.parseInt(divider.size[0])-1].setSize(Integer.parseInt(divider.size[0]));
                p2.setShipPosition(i+a, j, Integer.parseInt(divider.size[0]));         
                p2.getShips()[Integer.parseInt(divider.size[0])-1].setDirection("S");
              }
            }
            System.out.println("###### " + divider.size[0]);
            
          }          
        }
      }      
    }
    
    /**
      * isPositionValid
      * Checking if placement of ship is valid
      * @param  int i  x-value of placement coordinates
      * @param  int j  y-value of placement coordinates
      * @param  String direction  User-entered letter for direction of ship
      * @param  int size  Number of squares ship occupies in board
      * @return true or false (valid or invalid)
      */
    boolean isPositionValid(int i, int j, String direction, int size){
      boolean result = true; //Setting result to true first
      System.out.println("# " + i + ", " + j + ", " + direction + ", " + size);
      if (direction.equalsIgnoreCase("N")){
        System.out.println("NNN " + i + ", " + j + ", " + direction + ", " + size);       
        if (i - size < -1) {
          System.out.println("size "+ i + ", " + j + ", " + direction + ", " + size);
          result =  false;        
        }
        
        else {
          for (int k = i; k > i - size; k--){
         //   System.out.println("*** " + k + ", " + j + ", " + p1.getShipPosition(k,j));
            if (p2.getShipPosition(k, j) != 0) result = false;
          }
        }
                
      } else if (direction.equalsIgnoreCase("S")){
        if (i + size > 15) result =  false;
        else {
          for (int k = i; k < i + size; k ++) {
            
            if (p2.getShipPosition(k,j) !=0) result = false;
          }
        }
        
      } else if (direction.equalsIgnoreCase("E")){
        if (j + size > 15) result = false;
        else {
          for (int k = j; k < j + size; k++){
            if (p2.getShipPosition(i,k)!= 0 ) result = false;
          }
        }
      }
        else {
          if (j - size < -1) result = false;
          else {
            for(int k = j; k > j - size; k--) {
              if (p2.getShipPosition(i,k)!=0) result = false;
            }
          }         
        }          
        return result;
      }   
    }
  
  }//end of whole THING HERE
  
  
  
  
