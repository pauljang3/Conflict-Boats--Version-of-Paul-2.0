public class Player {
  
  //Declaration of Variables
  boolean isWin; //boolean value to see winner
  int money; //integer value of money
  int[][] shipPosition = new int[15][15]; //int array of 15 by 15
  Ship[] ships = new Ship[6]; //Ship array of 6 ships
 
     
  public Player () {
    //Creating 6 new ships
    ships[0] = new Ship();
    ships[1] = new Ship();
    ships[2] = new Ship();
    ships[3] = new Ship();
    ships[4] = new Ship();
    ships[5] = new Ship();    
  }
  
/**
  * isWin Method                          
  * @return isWin    Returns boolean value to see if win is valid
  */
 public boolean isWin() {
   return isWin;
 }
 
/**
  * setMoney Method                          
  * @return money    Returns money which is equal to money
  */
 public void setMoney(int i){
   money = i;
 }
 
/**
  * getMoney Method                          
  * @return money    Returns money
  */
 public int getMoney() {
   return money;
 }

/**
  * getShips Method                          
  * @return ships    Returns ships array value
  */  
 public Ship[] getShips() {
   return ships;
 }
 
/**
  * getShipPosition Method
  * @param i  x-value of ship placement coordinate
  * @param j  y-value of ship placement coordinate
  * @return shipPosition    Returns the ship position 
  */  
 public int getShipPosition(int i, int j){
   return shipPosition[i][j];
 }
  
/**
  * setShipPosition Method       
  * @param i  x-value of ship placement coordinate
  * @param j  y-value of ship placement coordinate
  * @param value  integer value to set how many squares the ship occupies
  * @return shipPosition[i][j]    Returns ships coordinates which is now equal to value
  */ 
 public void setShipPosition(int i, int j, int value){
   shipPosition[i][j] = value;
 }

} //End of Player class 
    



