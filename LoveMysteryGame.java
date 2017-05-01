import java.io.*;
import java.util.*;

public class LoveMysteryGame {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0 ; i < n; i++){
            String str = scanner.next();
            if(!isPalindrome(str)){
            	
               int index = 0;
               int diff = 0; 
               int j = str.length()-1;
               while(j>=index){
                   if(str.charAt(j)!=str.charAt(index)){
                       diff += Math.abs(str.charAt(j)-str.charAt(index));
                   }
                   index++;
                   j--;
               }
               System.out.println(diff);
            }
            else{
                System.out.println("0");
            }
        }
        scanner.close();
    }
    
    public static boolean isPalindrome(String str){
        int last = str.length()-1;
        for(int i = 0 ; i < str.length();i++){
            if(str.charAt(i)!=str.charAt(last)){
                return false;
            }
            last--;
        }
        return true;
    }
}