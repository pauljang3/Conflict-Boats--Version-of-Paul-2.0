public class Ship {
 int size;
 char direction;
 boolean isDestroyed;
 int xpos;
 int ypos;
 int partsHit;
 
 
 //Create methods that set and get variables
 public void setSize (int i){
   size = i;
 }
 
 public int getSize(){
   return size;
 }
 
 public void setDirection (char c){
   direction = c;
 }
 
 public char getDirection () {
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
 
 
 
 
 
}


  