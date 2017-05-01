package ArtificialIntelligence;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotCleanStochastic {
static void nextMove(int currentY, int currentX, String[] board){
        //add logic here
		ArrayList<String> destinations = new ArrayList<String>();
        for(int i = 0 ; i < board.length;i++){
        	String s = board[i];
        	for(int j = 0 ; j < s.length();j++){
        		if(s.charAt(j)=='d'){
        			destinations.add(j+"#"+i);
        		}
        	}
        }
        String shortestDestination = getShortestDestination(currentX,currentY,destinations);
        int nextDestinationX = Integer.parseInt(shortestDestination.split("#")[0]);
        int nextDestinationY = Integer.parseInt(shortestDestination.split("#")[1]);
        if(nextDestinationX==currentX && nextDestinationY==currentY){
			System.out.println("CLEAN");
		}
		else{
			int distanceForUp = getDistance(currentX,currentY-1,nextDestinationX,nextDestinationY);
			int distanceForRight = getDistance(currentX+1,currentY,nextDestinationX,nextDestinationY);
			int distanceForDown = getDistance(currentX,currentY+1,nextDestinationX,nextDestinationY);
			int distanceForLeft = getDistance(currentX-1,currentY,nextDestinationX,nextDestinationY);
			
			if(distanceForUp <= distanceForRight && distanceForUp <= distanceForDown && distanceForUp <= distanceForLeft){
	            currentY = currentY-1;
	            System.out.println("UP");
	        }
	        else if(distanceForRight <= distanceForUp && distanceForRight <= distanceForDown && distanceForRight <= distanceForLeft){
	            
	            currentX = currentX+1;
	            System.out.println("RIGHT");
	        }
	        else if(distanceForDown <= distanceForUp && distanceForDown <= distanceForRight && distanceForDown <= distanceForLeft){
	            
	            currentY = currentY+1;
	            System.out.println("DOWN");
	        }
	        else if(distanceForLeft <= distanceForUp && distanceForLeft <= distanceForRight && distanceForLeft <= distanceForDown){
	            
	            currentX = currentX-1;
	            System.out.println("LEFT");
	        }
		}		
}
private static int getDistance(int currentX, int currentY, int nextDestinationX, int nextDestinationY) {
	// TODO Auto-generated method stub
	return (int)Math.sqrt(((nextDestinationX-currentX)*(nextDestinationX-currentX))+((nextDestinationY-currentY)*(nextDestinationY-currentY)));
}
private static String getShortestDestination(int currentX, int currentY, ArrayList<String> destinations) {
	// TODO Auto-generated method stub
	int min = Integer.MAX_VALUE;
	String minDest = "";
	int k =0;
	for(int i = 0 ; i < destinations.size();i++){
		if(destinations.get(i)!=null){
			int x = Integer.parseInt(destinations.get(i).split("#")[0]);
			int y = Integer.parseInt(destinations.get(i).split("#")[1]);
			int distance = (int)Math.sqrt(((x-currentX)*(x-currentX))+((y-currentY)*(y-currentY)));
			if(distance<min){
				min = distance;
				minDest = destinations.get(i);
				k=i;
			}
		}
	}
	destinations.remove(k);
	return minDest;
}
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        nextMove(pos[0], pos[1], board);
    }
}
