import java.util.*;

public class SuperReducedString {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int pointer = 0;
        for(int i = 0 ; i < s.length()-1;i=pointer){
        	if(s.charAt(i)==s.charAt(i+1)){
        		s = s.substring(0,i)+s.substring(i+2,s.length());
        		pointer = 0;
        	}
        	else{
        		pointer+=1;
        	}
        }
        if(s.isEmpty()){
            System.out.println("Empty String");
        }
        else{
            System.out.println(s);    
        }
        scanner.close();
    }
    
}


/*Steve has a string, , consisting of  lowercase English alphabetic letters. In one operation, he can delete any pair of adjacent letters with same value. For example, string "aabcc" would become either "aab" or "bcc" after operation.

Steve wants to reduce  as much as possible. To do this, he will repeat the above operation as many times as it can be performed. Help Steve out by finding and printing 's non-reducible form!

Note: If the final string is empty, print Empty String .

Input Format

A single string, .

Constraints

Output Format

If the final string is empty, print Empty String; otherwise, print the final non-reducible string.*/