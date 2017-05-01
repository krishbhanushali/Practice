import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxSet {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr,Collections.reverseOrder());
        for(int i = 0 ; i < n ; i++){
        	System.out.println(arr[i]);
        }
        scan.close();
    }
}