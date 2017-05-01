import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        if(n>m){
        	System.out.println("No");
        }
        HashMap<String, Integer> magazineHash = new HashMap<String, Integer>();
        for(int i = 0 ; i < m; i ++){
        	if(!magazineHash.containsKey(magazine[i])){
        		magazineHash.put(magazine[i],1);
        	}
        	else{
        		magazineHash.put(magazine[i], magazineHash.get(magazine[i])+1);
        	}
        }
        boolean no = false;
        for(int i = 0 ; i < n ; i ++){
        	if(!magazineHash.containsKey(ransom[i])){
        		magazineHash.put(ransom[i],0);
        	}
        	else if(magazineHash.get(ransom[i])==0){
        		no = true;
        		break;
        	}
        	else{
        		magazineHash.put(ransom[i], magazineHash.get(ransom[i])-1);
        		
        	}
        }
        if(no){
        	System.out.println("No");
        }
        else{
        	System.out.println("Yes");
        }
    }
}
