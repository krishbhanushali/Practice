import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class LuckyEight {
    public static List<String> allCombinations = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String number = in.next();
        List<String> allCombinations = new ArrayList<String>();
        for(int i = 0 ; i < number.length()-1; i ++){
        	for(int j = i+1; j < number.length(); j++){
        		allCombinations.add(number.charAt(i)+""+number.charAt(j));
        	}
        }
        for(int i = 0 ; i < number.length(); i ++){
        	allCombinations.add(""+number.charAt(i));
        }
        allCombinations.add(number);
        int count = 0;
        for(String substr:allCombinations){
        	if(Integer.parseInt(substr)%8 == 0 ){
        		count ++;
        	}
        }
        int result = count%((int)Math.pow(10,9)+7);
        System.out.println(result);
    }

}
