package WeekOfCode31;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AccurateSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            // Write Your Code Here
            boolean isSorted = true;
            
	            for(int i = 0; i < n-1 ; i ++){
	        		if(Math.abs(a[i]-a[i+1])==1 && a[i]>a[i+1]){
	        			int temp = a[i];
	        			a[i] = a[i+1];
	        			a[i+1] = temp;
	        		}
	            }
	            
	            for(int i=0;i<n-1;i++){
	            	if(a[i]>a[i+1]){
	            		isSorted = false;
	            		break;
	            	}            		
	            }
            
            if(isSorted)
            	System.out.println("Yes");
            else
            	System.out.println("No");
        }
    }
    
}
