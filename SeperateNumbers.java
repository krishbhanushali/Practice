import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SeperateNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            // your code goes here
            int currentNumber = Integer.parseInt(""+s.charAt(0));
            boolean isBeautiful = false;
            int noOfDigits = 1;
        	for(int i = 0; i<s.length()-1 || i< s.length()-noOfDigits;){
        		int canBeNextNo = currentNumber + 1;
        		noOfDigits = getDigits(canBeNextNo);
        		//System.out.println(s.substring(i+1,i+1+noOfDigits));
        		if(Integer.parseInt(s.substring(i+1,i+1+noOfDigits))==canBeNextNo){
        			currentNumber = canBeNextNo;
        			isBeautiful = true;
        			if(i+noOfDigits<=s.length())
            			i=i+noOfDigits;
        		}
        		else{
        			currentNumber = Integer.parseInt(currentNumber+""+s.charAt(i+1));
        			isBeautiful = false;
        			if(i+1<=s.length())
        				i = i+1;
        		}
        		
        	}
        	System.out.println(isBeautiful);
        }
        in.close();
    }
    
    public static int getDigits(int number){
    	int digits = 0;
    	while(number>0){
    		number = number / 10;
    		digits ++;
    	}
    	return digits;
    }
}
