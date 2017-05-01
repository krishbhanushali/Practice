import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        char[] allChars = new char[len];
        s.getChars(0,len,allChars,0);
        for(int i=0;i<allChars.length;i++){
            for(int j=i+1;j<allChars.length;j++){
                if(allChars[i]==allChars[j]){
                    allChars = deleteElement(allChars,j);
                    j--;
                }
            }
        }
    	int maxLength = 0;
    	String temp = "";
    	for(int i=0;i<allChars.length-1;i++){
    		for(int j=i+1;j<allChars.length;j++){
    			temp = deleteRestAllChars(s,allChars[i],allChars[j]);
    			if(isProperSequence(temp)){
    				if(temp.length() > maxLength){
    					maxLength = temp.length();
    				}
    			}
    		}
    	}
    	System.out.println(maxLength);
        in.close();
    }
    static char[] deleteElement(char[] arr,int i){
        char[] copy = new char[arr.length-1];            
        System.arraycopy(arr, 0, copy, 0, i);
        System.arraycopy(arr, i+1, copy, i, arr.length-i-1);
        return copy;
    }
    static boolean isProperSequence(String temp){
    	Set<Character> sets = new HashSet<Character>();
    	boolean isConsecutive = false;
    	for(int j=0;j< temp.length();j++){
    		sets.add(temp.charAt(j));
    	}
    	for(int i=0;i<temp.length()-1;i++){
			if(temp.charAt(i)==temp.charAt(i+1))
				isConsecutive = true;
    	}
    	if(sets.size() == 2 && !isConsecutive){
    		return true;	
    	}
    	return false;
    }
    static String deleteRestAllChars(String s,char first,char second){
    	String temp = "";
    	for(int i = 0;i<s.length();i++){
    		if(s.charAt(i)==first || s.charAt(i)==second){
    			temp +=s.charAt(i);
    		}
    	}
    	return temp;
    }
}
