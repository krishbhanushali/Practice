import java.io.*;
import java.util.*;

public class GridlandMetro {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int noOfTracks = scan.nextInt();
        int[][] gridland = new int[n][m];
        for(int i=1;i<=n;i++){
        	for(int j=1;j<=m;j++){
        		gridland[i-1][j-1]=0;
        	}
        }
        HashMap<Integer, Collection<Integer>> tracks = new HashMap<Integer,Collection<Integer>>();
        
        while((noOfTracks+1)>0){
        	String temp = scan.nextLine();
        	String[] line = new String[m];
        	Collection<Integer> columns = new ArrayList<Integer>();
        	if(!temp.isEmpty()){
        		line = temp.split(" ");
        		int rowNo = Integer.parseInt(line[0]);
        		if(tracks.get(rowNo)!=null){
        			columns = tracks.get(rowNo);
        		}
            	for(int i=1;i<line.length;i++){
            		columns.add(Integer.parseInt(line[i]));
            	}
            	tracks.put(rowNo, columns);
        	}
        	noOfTracks--;
        }
        for(int i=1;i<=n;i++){
        	Collection<Integer> columns = tracks.get(i);
        	int firstColumn = 0;
    		int secondColumn = 0;
    		int count = 0;
    		if(columns!=null){
	        	for(Integer column:columns){
	        		if(count%2==0){
	        			firstColumn = column;
	        			count++;
	        		}
	        		else{
	        			secondColumn = column;
	        			count++;
	        		}
	        		for(int j=firstColumn;j<=secondColumn;j++){
		        		if(gridland[i-1][j-1]==0)
		        			gridland[i-1][j-1] =1;
	    			}
	        	}
	        	
    		}
        }
        int count = 0;
        for(int i=1;i<=n;i++){
        	for(int j=1;j<=m;j++){
        		if(gridland[i-1][j-1]==0){
        			count++;
        		}
        	}
        }
        System.out.println(count);
        scan.close();
    }
}