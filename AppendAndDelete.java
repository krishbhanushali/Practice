import java.util.*;

public class AppendAndDelete {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        in.close();
        int unequalIndex = getUnequalIndex(s,t);
        int diff = s.length() - unequalIndex;
        int diffForT = t.length() - unequalIndex;
        int count = diff-diffForT-k;
        if(count==k)
        	System.out.println("Yes");
        else
        	System.out.println("No");
        
    }
    
    public static int getUnequalIndex(String a, String b){
        int i = 0;
        for(i= 0 ; i < a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                break;
            }
        }
        if(i==a.length())
            return 0;
        return i;
    }
}
