import java.io.*;
import java.util.*;

public class PalindromeIndex {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n>0){
            String str = scanner.next();
            if(!isPalindrome(str)){
                int index = 0;
                int last = str.length()-1;
                int left = Integer.MIN_VALUE;
                int right = Integer.MIN_VALUE;
                while(last>index){
                    if(str.charAt(last)!=str.charAt(index)){
                        left = (isPalindrome(str.substring(0,index)+str.substring(index+1))?index:Integer.MIN_VALUE);
                        right = (isPalindrome(str.substring(0,last)+str.substring(last+1))?last:Integer.MIN_VALUE);
                        if(left!=Integer.MIN_VALUE){
                        	System.out.println(left);
                        	break;
                        }
                        if(right!=Integer.MIN_VALUE){
                        	System.out.println(right);
                        	break;
                        }
                            
                    }
                    last--;
                    index++;
                    
                }
                
            }
            else{
                System.out.println("-1");
            }
            n--;
        }
        scanner.close();
    }
    
    public static boolean isPalindrome(String str){
        int last = str.length()-1;
        int index = 0;
        while(last>index){
            if(str.charAt(index)!=str.charAt(last))
                return false;
            last--;
            index++;
        }
        return true;
    }
    
}