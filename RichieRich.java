import java.io.*;
import java.util.*;
import java.math.*;

public class RichieRich {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        String str = scan.next();
        int length = str.length();
        boolean isEven = false;
        if(length%2==0)
        	isEven = true;
        if(isEven){
        	int mid = (str.length()/2);
        	String firstPart = str.substring(0,mid);
        	String secondPart = str.substring(mid,str.length());
        	int count = 0;
        	int temp=k;
        	while(temp>0){
        		for(int i = mid,j=0;i>0 && j<mid;i--,j++){
            		//System.out.print(firstPart.charAt(i-1)+" is checked with "+secondPart.charAt(j));
            		if(firstPart.charAt(i-1)!=secondPart.charAt(j)){
            			char[] secondPartChar = secondPart.toCharArray();
        				secondPartChar[j] = firstPart.charAt(i-1);
        				secondPart = "";
        				for(Character ch:secondPartChar){
        					secondPart+=ch;
        				}
        				count++;
        				temp--;
            		}
            	}
        		if(isPalindrome(firstPart+secondPart))
        			break;
        	}
        	if(count>k){
				System.out.println("-1");
			}
        	else
        		System.out.println(firstPart+secondPart);
        }
        else{
        	
        }
        scan.close();
    }

	private static boolean isPalindrome(String string) {
		// TODO Auto-generated method stub
		int last = string.length()-1;
		int i = 0;
		while(i<=string.length()/2){
			if(string.charAt(i)!=string.charAt(last)){
				return false;
			}
			last--;
			i++;
		}
		return true;
	}
}