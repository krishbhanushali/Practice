import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        while(k!=0){
            int current = a[0];
            for(int i=0;i<a.length-1;i++){
                a[i]=a[i+1];
            }
            a[n-1] = current;
            k--;
        }
        for(int a_i=0; a_i < n; a_i++){
            System.out.println(a[a_i]);
        }
        
    }
}
