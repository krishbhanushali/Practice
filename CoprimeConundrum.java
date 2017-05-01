import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoprimeConundrum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for(int k=1;k<=n;k++){
        	for(int p=2;p<=n;p++){
        		for(int q=p;q<=n;q++){
            		if(areCoPrime(p, q) && (p*q)==k){
            			count++;
            		}
            	}
        	}
        }
        System.out.println(count);
    }
    
    public static boolean areCoPrime(int p,int q){
    	if(gcd(p, q)==1){
    		return true;
    	}
    	else 
    		return false;
    }
    private static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}
