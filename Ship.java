public class Ship {
 
 //Declaration of Variables
 int size; //Integer size for ship
 String direction; //String direction for direction of ships
 boolean isDestroyed; //Boolean isDestroyed to check if a ship is destroyed
 int xpos; //x-value of coordinate
 int ypos; //y-value of coordinate
 int partsHit; //Integer partsHit to see how many parts of ship have been hit
 
 
 //Creating methods that set and get variables
 
 
 public void setSize (int i){
   size = i;
 }
 
 public int getSize(){
   return size;
 }
 
 public void setDirection (String c){
   direction = c;
 }
 
 public String getDirection () {
   return direction;
 }
 
 public boolean isDestroyed() {
   return isDestroyed;
 }
 
 public void setPosition(int i, int j){
   xpos = i;
   ypos = j;
 }
 
 public int getXPosition() {
   return xpos;
 }
 
 public int getYPostition() {
   return ypos;
 }
 
 public void increasePartsHit() {
   partsHit++;
 }
 
 public int getPartsHit() {
   return partsHit;
 }

}//End of ship class


  
