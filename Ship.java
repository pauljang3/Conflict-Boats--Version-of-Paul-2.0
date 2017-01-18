public class Ship {
 
 //Declaration of Variables
 int size; //Integer size for ship
 String direction; //String direction for direction of ships
 boolean isDestroyed; //Boolean isDestroyed to check if a ship is destroyed
 int xpos; //x-value of coordinate
 int ypos; //y-value of coordinate
 int partsHit; //Integer partsHit to see how many parts of ship have been hit
 
 
 //Creating methods that set and get variables
 
 /**
   * setSize Method
   * @param i  
   * @return size    Returns the size which is int i 
   */   
 public void setSize (int i){
   size = i;
 }
 
/**
  * getSize Method
  * @return shipPosition    Returns size of ship
  */   
 public int getSize(){
   return size;
 }
 
/**
  * setDirection Method
  * @param c  User-entered direction
  * @return direction    Returns the direction of ship
  */   
 public void setDirection (String c){
   direction = c;
 }
 
/**
  * getDirection Method
  * @return direction    Returns the direction of ship
  */  
 public String getDirection () {
   return direction;
 }

/**
  * isDestroyed Method
  * @return isDestroyed    Returns isDestroyed to check if boat has been destroyed
  */   
 public boolean isDestroyed() {
   return isDestroyed;
 }
 
/**
  * setPosition Method
  * @param i   x-value of coordinate
  * @param j   y-value of coordinate
  */   
 public void setPosition(int i, int j){
   xpos = i;
   ypos = j;
 }
 
/**
   * getXPosition Method
   * @return xpos    Returns the x-value 
   */   
 public int getXPosition() {
   return xpos;
 }
 
/**
  * getYPosition Method
  * @return ypos   Returns the y-value 
  */  
 public int getYPosition() {
   return ypos;
 }
 
/**
  * increasePartsHit Method
  * Increases parts hit by 1
  */   
 public void increasePartsHit() {
   partsHit++;
 }
 
/**
  * getPartsHit Method
  * @param i  
  * @return getPartsHit    Returns the value of parts hit
  */   
 public int getPartsHit() {
   return partsHit;
 }

}//End of ship class


  
