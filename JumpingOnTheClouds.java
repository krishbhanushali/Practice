import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JumpingOnTheClouds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int current = 0;
        int count = 0;
        for(int i=current;i<n-2;){
            if(c[i+1]==0 && c[i+2]==1){
                current = i+1;
                count++;
            }
            if(c[i+1]==0 && c[i+2]==0){
                current = i+2;
                count++;
            }
            if(c[i+1]==1 && c[i+2]==0){
                current= i+2;
                count++;
            }
            i = current;        	
        }
        if(current==n-2){
        	count++;
        }
        System.out.print(count);
        in.close();
    }
}
