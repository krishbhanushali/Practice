import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MostCommonWord {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String paragraph = scanner.nextLine();
		int n = scanner.nextInt();
		String[] banned = new String[n]; 
		scanner.nextLine();
		for(int i=0;i < n; i++) {
			banned[i] = scanner.nextLine();
		}
		System.out.println(mostCommonWord(paragraph, banned));
		scanner.close();
	}
	
	
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> ban = new HashSet<String>();
        for(String eachBan: banned) {
        	ban.add(eachBan);
        }
        
        Map<String, Integer> count = new HashMap<String, Integer>();
        
        String ans = "";
        int freq = 0;
        
        StringBuilder word = new StringBuilder();
        for(char c : paragraph.toCharArray()) {
        	if(Character.isLetter(c)) {
        		word.append(Character.toLowerCase(c));
        	}else if(word.length() > 0){
        		String finalWord = word.toString();
        		if (!ban.contains(finalWord)) {
        			count.put(finalWord, count.getOrDefault(finalWord, 0) + 1);
        			
        			if (count.get(finalWord) > freq) {
        				ans = finalWord;
        				freq = count.get(finalWord);
        			}
        		}
        		word = new StringBuilder();
        	}
        }
        return ans;
    }
}
