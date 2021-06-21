
// CrazyEightMore.java         ITCS
//
// Use conditional statements and loops to
// solve challenges

  
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;
   
public class CrazyEightMore
{
   public static void main(String[] args) 
   {
      String filename = JOptionPane.showInputDialog("What robot world?\n eightMore1, eightMore2, eightMore3, eightMore4");
      Display.openWorld("maps/" + filename + ".map");
      Display.setSize(10, 10);
      Display.setSpeed(10);
      
      task_09(); //put down 5 different piles with 4 beepers  in each pile. Use definte loops
      task_10(); //fill in the gaps with a beeper and stop when you reach a wall 
      task_11(); //As long as  there is a wall to your right, put down one beeper at each step
      task_12(); //go until there is a wall to your right and you are standing on a beeper
   
      task_13(); // Go to the wall.  Only pick up 1 beeper in each pile, if there is a pile.
      task_14(); // Go to the beeper.  Count and print out the number of walls you pass.
      task_15(); // Go to the wall.  Pick up all the beepers (max 1 per pile) and put down a beeper in any gap.
      task_16(); // Pick up the row of beepers (max 1 per pile).  Then return ONE space before the original starting position.  You may NOT get to the wall, turn around, and go back one spot.  
   
   }
   
      
		
	    
   // Put down 5 different piles with 4 beepers  in each pile. Use definte loops
   public static void task_09() {
      Robot temp = new Robot(1, 1, Display.EAST, 20);
   	for(int i = 0; i<5; i++){
         for(int y = 0; y<4; y++){
            temp.putBeeper();
         }
         temp.move();
      }
 
      	
   }
     
     
      
   // Fill in the gaps with a beeper and stop when you reach a wall 
   public static void task_10() {
      Robot temp = new Robot(1, 2, Display.EAST, Display.INFINITY);
   	while(temp.frontIsClear()){        
         if(!temp.nextToABeeper()){
            temp.putBeeper();
         }
         temp.move();
      }
      if(!temp.frontIsClear()){
         temp.putBeeper();
      }

      
   }
     
     
      
   // As long as there is a wall to your right, put down one beeper at each step
   public static void task_11() {
      Robot temp = new Robot(1, 3, Display.EAST, Display.INFINITY);
   	while(!temp.rightIsClear()){
         temp.putBeeper();
         temp.move();
      }
      

      
   }
   
   
      
   // Go until there is a wall to your right and you are standing on a beeper
   public static void task_12() {
      Robot temp = new Robot(1, 4, Display.EAST, 0);
   	while(temp.rightIsClear() || !temp.nextToABeeper()){
         temp.move();
      }
            
        
 
   }
   
    
      
   // Go to the wall.  Only pick up 1 beeper in each pile, if there is a pile.
   public static void task_13() {
      Robot temp = new Robot(1, 5, Display.EAST, 0);
      while(temp.frontIsClear()){
         if(temp.nextToABeeper()){
            temp.pickBeeper();
         } 
         temp.move();
      }
   	
      if(!temp.frontIsClear() && temp.nextToABeeper()){
         temp.pickBeeper();
      }
   }



   // Go to the beeper.  Count and print out the number of walls you pass.
   public static void task_14() {
      Robot temp = new Robot(1, 6, Display.EAST, 0);
      int x = 0;
      int y = 0;
      while(!temp.nextToABeeper()){
         if(!temp.rightIsClear()){
            x++;
         }
         if(!temp.leftIsClear()){
            y++;
         }
         
         temp.move();
      }
   		System.out.println(x+" Walls to the Right");
         System.out.println(y+" Walls to the Left");
   }
   
   
   
   // Go to the wall.  Pick up all the beepers (max 1 per pile) and put down a beeper in any gap.
   public static void task_15() {
      Robot temp = new Robot(1, 7, Display.EAST, Display.INFINITY);
   	while(temp.frontIsClear()){
         if(temp.nextToABeeper()){
            temp.pickBeeper();
         } 
         if(temp.rightIsClear()){
            temp.putBeeper();
         }
          temp.move();

      }
      if(!temp.frontIsClear()&& temp.rightIsClear()){
         temp.putBeeper();
      }
      
      	
   }
   
   
   
   // Pick up the row of beepers (max 1 per pile).  Then return ONE space before the original starting position.  You may NOT get to the wall, turn around, and go back one spot.  
   public static void task_16() {
      Robot temp = new Robot(1, 8, Display.EAST, 0);
      int x = -1;
      while(temp.nextToABeeper()){
         temp.pickBeeper();
         temp.move();
         x++;
      }
      temp.turnLeft();
      temp.turnLeft();
      // System.out.println(x);
      
      for(int i = 0; i<x; i++){
         temp.move();
      }
   }

        


   
}
