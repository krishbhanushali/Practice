package WeekOfCode30;

import java.util.Scanner;

public class GraphProblem {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    int[][] g = new int[n][n];
	    for(int g_i=0; g_i < n; g_i++){
	        for(int g_j=0; g_j < n; g_j++){
	            g[g_i][g_j] = in.nextInt();
	        }
	    }
	    in.close();
	}
	
}
