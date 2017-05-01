package WorldCodeSpring10;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ZigZagArray {

    static int minimumDeletions(int[] a){
        // Complete this function
    	int count = 0;
    	for(int i = 0 ; i < a.length-2;i++){
    		if((a[i]<a[i+1] && a[i+1]<a[i+2]) || (a[i]>a[i+1] && a[i+1]>a[i+2])){
    			count+=1;
    		}
    	}
    	return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Return the minimum number of elements to delete to make the array zigzag
        int result = minimumDeletions(a);
        System.out.println(result);
    }
}
