package WeekOfCode30;

import java.util.*;

public class FindTheMinimumNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str="";
        for(int i = 0 ; i < n-1 ; i++){
        	str+="min(int,";
        }
        str+="int";
        for(int i=0;i<n-1;i++){
        	str+=")";
        }
        System.out.println(str);
        in.close();
    }

}
