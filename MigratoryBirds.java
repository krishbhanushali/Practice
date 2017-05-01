import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MigratoryBirds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] types = new int[n];
        for(int types_i=0; types_i < n; types_i++){
            types[types_i] = in.nextInt();
        }
        int max = largest(types);
        int[] temp = new int[max+1];
        for(int i = 0 ; i < types.length; i ++){
            if(temp[types[i]]==0)
                temp[types[i]] = 1;
            else{
                temp[types[i]] = temp[types[i]] + 1;
            }
        }
        System.out.println(largest(temp));
        
        // your code goes here
    }
    
    public static int largest(int[] arr){
        int max = 0;
        for(int i = 0 ; i < arr.length; i ++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
