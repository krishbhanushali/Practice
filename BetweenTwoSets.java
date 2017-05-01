import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BetweenTwoSets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        
        int start = findGreatest(a);
        int end = b[0];
        List<Integer> result = new ArrayList<Integer>();
        for(int i = start; i <= end; i++){
        	int count = 0;
            for(int k = 0 ; k < n ; k ++){
            	if(i%a[k]==0)
            		count++;
            }
            if(count==n){
            	count = 0;
            	for(int k = 0 ; k < m ; k ++){
            		if(b[k]%i==0){
            			count++;
            		}
            	}
            	if(count == m){
                	result.add(i);
                }
            }
            
        }
        System.out.println(result.size());
        
    }
    
    public static int findGreatest(int[] arr){
    	int max = 0;
    	for(int i = 0 ; i < arr.length; i ++){
    		if(arr[i]> max){
    			max = arr[i];
    		}
    	}
    	return max;
    }
}
