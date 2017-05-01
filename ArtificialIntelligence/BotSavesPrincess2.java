package ArtificialIntelligence;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotSavesPrincess2 {
static void nextMove(int n, int botY, int botX, String [] grid){
        int princessX = 0;
        int princessY = 0;
        for(int i = 0 ; i < grid.length;i++){
            for(int j = 0 ; j < grid[i].length(); j++){
                if(grid[i].charAt(j)=='p'){
                    princessX = j;
                    princessY = i;
                }
            }
        }
        int distanceForUp = getDistance(botX,botY-1,princessX,princessY);
        int distanceForRight = getDistance(botX+1,botY,princessX,princessY);
        int distanceForDown = getDistance(botX,botY+1,princessX,princessY);
        int distanceForLeft = getDistance(botX-1,botY,princessX,princessY);
        if(distanceForUp <= distanceForRight && distanceForUp <= distanceForDown && distanceForUp <= distanceForLeft){
            
            botY = botY-1;
            System.out.println("UP");
        }
        else if(distanceForRight <= distanceForUp && distanceForRight <= distanceForDown && distanceForRight <= distanceForLeft){
            
            botX = botX+1;
            System.out.println("RIGHT");
        }
        else if(distanceForDown <= distanceForUp && distanceForDown <= distanceForRight && distanceForDown <= distanceForLeft){
            
            botY = botY+1;
            System.out.println("DOWN");
        }
        else if(distanceForLeft <= distanceForUp && distanceForLeft <= distanceForRight && distanceForLeft <= distanceForDown){
            
            botX = botX-1;
            System.out.println("LEFT");
        }
}
    
static int getDistance(int botX, int botY, int princessX, int princessY) {
    return (int)Math.sqrt(((princessX-botX)*(princessX-botX))+((princessY-botY)*(princessY-botY)));
}

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

    nextMove(n,r,c,grid);

    }
}
