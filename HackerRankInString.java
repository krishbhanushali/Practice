
import java.util.*;

public class HackerRankInString {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n;i++){
            String s = scanner.next();
            System.out.println(containsHackerRank(s)?"YES":"NO");
        }
            
        scanner.close();
    }

	private static boolean containsHackerRank(String s) {
		// TODO Auto-generated method stub
		char[] hackerrank = {'h','a','c','k','e','r','r','a','n','k'};
		boolean contains = false;
		int index = 0;
		for(int i = 0 ; i < hackerrank.length;i++){
			contains = false;
			while(index<s.length()){
				if(s.charAt(index)==hackerrank[i]){
					contains = true;
					index++;
					break;
				}
				else{
					index++;
				}
			}
		}
		if(!contains) return false;
		return true;
	}
}
