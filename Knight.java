// you can also use imports, for example:

 import java.util.*;
 import java.lang.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Knight {
    public static void main(String[] args){
        // write your code in Java SE 8
        int  minSolution = getAllSolutions(0,0,7,7,0);
        System.out.println(minSolution);
    }
    
    public static double getDistance(int x1, int y1, int x2, int y2){
        double value = Math.pow(x2-x1,2) + Math.pow(y2-y1,2);
       // System.out.println(Math.sqrt(value));
        return Math.sqrt(value);
    }
    
    public static int getAllSolutions(int x1, int y1, int x2, int y2,int steps){
    	//System.out.println(getDistance(x1,y1,x2,y2));
        if(destinationReached(x1, y1, x2, y2)){
        	steps++;
            return steps;
        }
        else{
        	if(getDistance(x1, y1, x2, y2)<=1){
        		return steps;
        	}
            String X1AndY1 = getMinimum(getDistance(x1,y1,x2,y2),x1,x2,y1,y2);
            String[] x1AndY1Split = X1AndY1.split("#");
            x1 = Integer.parseInt(x1AndY1Split[0]);
            y1 = Integer.parseInt(x1AndY1Split[1]);
            
            steps++;
            System.out.println("Step "+steps+": "+""+x1+" "+y1);
            return getAllSolutions(x1,y1,x2,y2,steps);
        }
    }
    
    public static boolean destinationReached(int x1,int y1, int x2, int y2){
    	if(Math.abs(x2-x1)==2 && Math.abs(y2-y1)==1){
    		return true;
    	}
    	if(Math.abs(x2-x1)==1 && Math.abs(y2-y1)==2){
    		return true;
    	}
    	return false;
    }
    public static String getMinimum(double distance,int x1,int x2, int y1, int y2){
        double minimumDistance = distance;
        int tempX1 = x1;
        int tempY1 = y1;
        if(getDistance(x1+1,y1+2,x2,y2)<minimumDistance){
        	if(x1+1>0 && y1+2>0){
	            minimumDistance = distance;
	            tempX1 = x1+1;
	            tempY1 = y1+2;
        	}
        }
        else if(getDistance(x1+2,y1+1,x2,y2)<minimumDistance){
        	if(x1+2>0 && y1+1>0){
                minimumDistance = distance;
                tempX1 = x1+2;
                tempY1 = y1+1;
        	}
        }
        else if(getDistance(x1+2,y1-1,x2,y2)<minimumDistance){
        	if(x1+2>0 && y1-1>0){
	            minimumDistance = distance;
	            tempX1 = x1;
	            tempY1 = y1-1;
        	}
        }
        else if(getDistance(x1+1,y1-2,x2,y2)<minimumDistance){
        	if(x1+1>0 && y1-2>0){
	            minimumDistance = distance;
	            tempX1 = x1+1;
	            tempY1 = y1-2;
        	}
        }
        else if(getDistance(x1-1,y1-2,x2,y2)<minimumDistance){
        	if(x1-1>0 && y1-2>0){
	            minimumDistance = distance;
	            tempX1 = x1-1;
	            tempY1 = y1-2;
        	}
        }
        else if(getDistance(x1-2,y1-1,x2,y2)<minimumDistance){
        	if(x1-2>0 && y1-1>0){
	            minimumDistance = distance;
	            tempX1 = x1-2;
	            tempY1 = y1-1;
        	}
        }
        else if(getDistance(x1-2,y1+1,x2,y2)<minimumDistance){
        	if(x1-2>0 && y1+1>0){
	            minimumDistance = distance;
	            tempX1 = x1-2;
	            tempY1 = y1+1;
        	}
        }
        else if(getDistance(x1-1,y1+2,x2,y2)<minimumDistance){
        	if(x1-1>0 && y1+2>0){
	            minimumDistance = distance;
	            tempX1 = x1-1;
	            tempY1 = y1+2;
        	}
        }
        
        return tempX1+"#"+tempY1;
    }
}
