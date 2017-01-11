public class Player {
  
  boolean isWin;
  int money;
 Ship[] ships = new Ship[5];
 
 public boolean isWin() {
   return isWin;
 }
 
 public void setMoney(int i){
   money = i;
 }
 
 public int getMoney() {
   return money;
 }
 
 public Ship[] getShips() {
   return ships;
 }
 
    
    public Player () {
    ships[0] = new Ship();
    ships[1] = new Ship();
    ships[2] = new Ship();
    ships[3] = new Ship();
    ships[4] = new Ship();
    
    }
}  
    



