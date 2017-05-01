import java.io.*;
import java.util.*;

public class BinaryNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        String binary = Integer.toString(number,2);
        int maxCount = 0;
        for(int i=0;i<binary.length()-1;i++){
        	char current = binary.charAt(i);
        	int count = 1;
        	if(current=='1'){
        		
        		for(int j = i+1;j<binary.length();j++){
        			char next = binary.charAt(j);
        			if(current == next){
        				count++;
        			}
        			else break;
        		}
        	}
        	if(maxCount<count){
        		maxCount = count;
        	}
        }
        System.out.println(maxCount);
        
        scan.close();
    }
    
}