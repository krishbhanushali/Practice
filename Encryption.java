import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Encryption {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replaceAll("\\s","");
        int len = s.length();
        int rows = (int) Math.floor(Math.sqrt(len));
        int columns = (int)Math.ceil(Math.sqrt(len));
        if(rows*columns<s.length()){
        	rows = columns;
        }
        for(int column = 0 ; column<columns;column++){
        	int columnIndex = column;
        	System.out.print(s.charAt(columnIndex));
        	for(int row=0;row<rows-1;row++){
        		if(columnIndex+columns<s.length()){
        			System.out.print(s.charAt(columnIndex+columns));
            		columnIndex+=columns;
        		}
        	}
        	System.out.print(" ");
        }
    }
}