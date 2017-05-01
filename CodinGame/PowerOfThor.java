package CodinGame;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
            int distanceForNorth = getDistance(initialTX,initialTY-1,lightX,lightY);
            int distanceForNorthEast = getDistance(initialTX+1,initialTY-1,lightX,lightY);
            int distanceForEast = getDistance(initialTX+1,initialTY,lightX,lightY);
            int distanceForSouthEast = getDistance(initialTX+1,initialTY+1,lightX,lightY);
            int distanceForSouth = getDistance(initialTX,initialTY+1,lightX,lightY);
            int distanceForSouthWest = getDistance(initialTX-1,initialTY+1,lightX,lightY);
            int distanceForWest = getDistance(initialTX-1,initialTY,lightX,lightY);
            int distanceForNorthWest = getDistance(initialTX-1,initialTY-1,lightX,lightY);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            if(initialTY-1>=0 && distanceForNorth <= distanceForNorthEast && distanceForNorth <= distanceForEast && distanceForNorth <= distanceForSouthEast && distanceForNorth <= distanceForSouth && 
            		distanceForNorth <= distanceForSouthWest && distanceForNorth <= distanceForWest && distanceForNorth <= distanceForNorthWest && initialTY-1>=0){
            	initialTY= initialTY-1;
            	System.out.println("N");
            }
            else if(initialTX+1<=39 && initialTY-1>=0 && distanceForNorthEast <= distanceForNorth && distanceForNorthEast <= distanceForEast && distanceForNorthEast <= distanceForSouthEast && distanceForNorthEast <= distanceForSouth && 
            		distanceForNorthEast <= distanceForSouthWest && distanceForNorthEast <= distanceForWest && distanceForNorthEast <= distanceForNorthWest){
            	initialTX = initialTX+1;
            	initialTY = initialTY-1;
            	System.out.println("NE");
            }
            else if(initialTX+1<=39 && distanceForEast <= distanceForNorth && distanceForEast <= distanceForNorthEast && distanceForEast <= distanceForSouthEast && distanceForEast <= distanceForSouth && 
            		distanceForEast <= distanceForSouthWest && distanceForEast <= distanceForWest && distanceForEast <= distanceForNorthWest){
            	initialTX = initialTX+1;
            	System.out.println("E");
            }
            else if(initialTX+1<=39 && initialTY+1<=17 && distanceForSouthEast <= distanceForNorth && distanceForSouthEast <= distanceForNorthEast && distanceForSouthEast <= distanceForEast && distanceForSouthEast <= distanceForSouth && 
            		distanceForSouthEast <= distanceForSouthWest && distanceForSouthEast <= distanceForWest && distanceForSouthEast <= distanceForNorthWest){
            	initialTX+=1;
            	initialTY+=1;
            	System.out.println("SE");
            }
            else if(initialTY+1<=17 && distanceForSouth <= distanceForNorth && distanceForSouth <= distanceForNorthEast && distanceForSouth <= distanceForEast && distanceForSouth <= distanceForSouthEast && 
            		distanceForSouth <= distanceForSouthWest && distanceForSouth <= distanceForWest && distanceForSouth <= distanceForNorthWest){
            	initialTY+=1;
            	System.out.println("S");
            }
            else if(initialTX-1>=0 && initialTY+1<=17 && distanceForSouthWest <= distanceForNorth && distanceForSouthWest <= distanceForNorthEast && distanceForSouthWest <= distanceForEast && distanceForSouthWest <= distanceForSouthEast && 
            		distanceForSouthWest <= distanceForSouth && distanceForSouthWest <= distanceForWest && distanceForSouthWest <= distanceForNorthWest){
            	initialTX-=1;
            	initialTY+=1;
            	System.out.println("SW");
            }
            else if(initialTX-1>=0 && distanceForWest <= distanceForNorth && distanceForWest <= distanceForNorthEast && distanceForWest <= distanceForEast && distanceForWest <= distanceForSouthEast && 
            		distanceForWest <= distanceForSouth && distanceForWest <= distanceForSouthWest && distanceForWest <= distanceForNorthWest){
            	initialTX-=1;
            	System.out.println("W");
            }
            else if(initialTX-1>=0 && initialTY-1>=0 && distanceForNorthWest <= distanceForNorth && distanceForNorthWest <= distanceForNorthEast && distanceForNorthWest <= distanceForEast && distanceForNorthWest <= distanceForSouthEast && 
            		distanceForNorthWest <= distanceForSouth && distanceForNorthWest <= distanceForSouthWest && distanceForNorthWest <= distanceForWest){
            	initialTX-=1;
            	initialTY-=1;
            	System.out.println("NW");
            }
            // A single line providing the move to be made: N NE E SE S SW W or NW
            remainingTurns-=1;
        }
    }
    
    public static int getDistance(int initialTX, int initialTY, int lightX, int lightY){
    	return (int)Math.sqrt(((lightX-initialTX)*(lightX-initialTX))+((lightY-initialTY)*(lightY-initialTY)));
    }
}