import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KaprekarNumber {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        long p = scan.nextLong();
        long q = scan.nextLong();
        int count=0;
        for(long i = p ; i <=q;i++){
            long square = i*i;
            if(i==1){
                System.out.print(i+" ");
                count++;
            }
            else{
                String str = ""+square;
                
                if(str.length()>=2){
                    long firstHalf = Integer.parseInt(str.substring(0,(str.length()/2)));
                    long secondHalf = Integer.parseInt(str.substring(str.length()/2,str.length()));
                    if(firstHalf+secondHalf==i){
                    	System.out.print(i+" ");
                    	count++;
                    }
                        
                }    
            }
            
        }
        if(count==0)
        	System.out.println("INVALID RANGE");
        scan.close();
    }
}