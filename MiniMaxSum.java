import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiniMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        
        long sum1 = b+c+d+e;
        long sum2 = a+c+d+e;
        long sum3 = a+b+d+e;
        long sum4 = a+b+c+e;
        long sum5 = a+b+c+d;
        
        long[] arr = new long[5];
        arr[0]=sum1; arr[1]=sum2; arr[2]=sum3; arr[3]=sum4; arr[4]=sum5; 
        long minValue = arr[0] ; long maxValue = arr[0];
        
        for(int i = 0 ; i < 5 ; i ++){
            if(arr[i]<=minValue){
                minValue = arr[i];
            }
            if(arr[i]>=maxValue){
                maxValue = arr[i];
            }
        }
        System.out.println(minValue+" "+maxValue);
    }
}
