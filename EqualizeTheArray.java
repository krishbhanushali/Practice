import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EqualizeTheArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++){
            arr[i] = scan.nextInt();
            if(arr[i]>max){
            	max = arr[i];
            }
           // temp[arr[i]]++;    
        }
        int[] temp = new int[max+1];
        for(int i = 0 ; i < n ; i ++){
            temp[arr[i]]++;    
        }
        int maxCount = 0;
        int equalNumbersCount = 0;
        for(int i = 0; i < n;i++){
            if(temp[i]>maxCount){
                maxCount = temp[i];
                equalNumbersCount = i;
            }
        }
        int count = 0;
        for(int i = 0 ; i < n ; i ++){
            if(arr[i]!=equalNumbersCount){
                count++;
            }
        }
        System.out.println(count);
    }
}