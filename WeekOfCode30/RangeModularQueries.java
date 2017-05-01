package WeekOfCode30;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RangeModularQueries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            int left = in.nextInt();
            int right = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int mid = (left+right)/2;
            int count = isDivisible(left,mid,right,a,x,y,0);
            System.out.println(count);
            // your code goes here
        }
    }
    
    public static int isDivisible(int low, int mid, int high, int[] arr, int x,int y,int count){
    	if(low<0 || high >= arr.length)
    		return 0;
        if(arr[mid]%x==y)
            count++;
        if(mid==high)
            return count;
        int tempHigh = mid-1;
        int tempMid = (low+tempHigh)/2;
        int count1 = isDivisible(low,tempMid,tempHigh,arr,x,y,count);
        int tempLow = mid+1;
        tempMid = (tempLow + high)/2;
        int count2 = isDivisible(tempLow,tempMid,high,arr,x,y,count);
        return count1+count2;
    }
}
