import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumVsXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long count=0;
        
        for(long i=0;i<=n;i++){        		
    		if((i+n)==(i^n) && (n+i)==(n^i)){
    			count++;
    		}
        }
        long i = 0;
        System.out.println(count);
        //System.out.println(""+checkCondition(i,n,count));
    }
    public static long checkCondition(long i,long n,long count){
    	
    	if(i<=n){
	    	if((i+n)==(i^n) && (n+i)==(n^i)){
	    		count++;
	    	}
	    	i++;
	    	return checkCondition(i, n,count);
    	}
    	return count;
    }
}
