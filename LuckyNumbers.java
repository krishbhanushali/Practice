import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class LuckyNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int noOfTestCases = scan.nextInt();
        for(int testCase = 1; testCase<=noOfTestCases;testCase++){
        	BigInteger minLimit = scan.nextBigInteger();
        	BigInteger maxLimit = scan.nextBigInteger();
        	int totalLuckyNumbers = 0;
        	for(int i=minLimit.intValue();i<maxLimit.intValue();i++){
        		if(new LuckyNumbers().isLucky(""+i)){
        			totalLuckyNumbers ++;
        		}
        	}
        	System.out.println(totalLuckyNumbers);
        }
        scan.close();
    }
    boolean isLucky(String num){
    	int sum = 0;
    	int sumOfSquare = 0;
    	for(int i=0;i<num.length();i++){
    		sum += Integer.parseInt(""+num.charAt(i));
    		sumOfSquare += Integer.parseInt(""+num.charAt(i))*Integer.parseInt(""+num.charAt(i));
    	}
    	if(isPrime(sum) && isPrime(sumOfSquare))
    		return true;
    	else
    		return false;
    }
    boolean isPrime(int num){
    	double sqrt = Math.sqrt(num);
    	if(num==1){
    		return false;
    	}
    	if(num==2){
    		return true;
    	}
    	else{
	    	for(int i=2;i<=sqrt;i++){
    			if(num%i==0){
    				return false;
    			}
    			
	    	}
    	}
    	return true;
    }
}