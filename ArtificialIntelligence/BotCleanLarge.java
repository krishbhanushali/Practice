package ArtificialIntelligence;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotCleanLarge {
static void next_move(int currentY, int currentX, int dimh, int dimw, String[] board){
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
		
		if(currentY-1>=0 && distanceForUp <= distanceForRight && distanceForUp <= distanceForDown && distanceForUp <= distanceForLeft){
            currentY = currentY-1;
            System.out.println("UP");
        }
        else if(currentX+1<=dimw && distanceForRight <= distanceForUp && distanceForRight <= distanceForDown && distanceForRight <= distanceForLeft){
            
            currentX = currentX+1;
            System.out.println("RIGHT");
        }
        else if(currentY+1<=dimh && distanceForDown <= distanceForUp && distanceForDown <= distanceForRight && distanceForDown <= distanceForLeft){
            
            currentY = currentY+1;
            System.out.println("DOWN");
        }
        else if(currentX-1>=0 && distanceForLeft <= distanceForUp && distanceForLeft <= distanceForRight && distanceForLeft <= distanceForDown){
            
            currentX = currentX-1;
            System.out.println("LEFT");
        }
	}
}

private static int getDistance(int currentX, int currentY, int nextDestinationX, int nextDestinationY) {
	// TODO Auto-generated method stub
	return Math.abs(currentX-nextDestinationX) + Math.abs(currentY-nextDestinationY);
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
			int distance = 1* Math.abs(currentX-x) + Math.abs(currentY-y);
			
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
        int [] dim = new int[2];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<2;i++) dim[i] = in.nextInt();
        String board[] = new String[dim[0]];
        for(int i=0;i<dim[0];i++) board[i] = in.next();
        next_move(pos[0], pos[1], dim[0], dim[1], board);
    }
}
