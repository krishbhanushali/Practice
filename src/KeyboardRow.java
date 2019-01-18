import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class KeyboardRow {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] words = new String[n];
		scanner.nextLine();
		for(int i=0; i < n; i++) {
			words[i] = scanner.nextLine();
		}
		String[] keyboardWords = findWords(words);
		for(int i=0; i < keyboardWords.length; i++) {
			System.out.println(keyboardWords[i]);
		}
		scanner.close();
	}

	private static String[] findWords(String[] words) {
		Character[] firstLine = new Character[]{'q','w','e','r','t','y','u','i','o','p'};
        Character[] secondLine = new Character[]{'a','s','d','f','g','h','j','k','l'};
        Character[] thirdLine = new Character[]{'z','x','c','v','b','n','m'};
        Set<Character> firstLineSet = new HashSet<>(Arrays.asList(firstLine));
        Set<Character> secondLineSet = new HashSet<>(Arrays.asList(secondLine));
        Set<Character> thirdLineSet = new HashSet<>(Arrays.asList(thirdLine));
        List<String> keyboardRows = new ArrayList<String>();
        for(String eachWord:words) {
        	String word = eachWord.toLowerCase();
            char firstChar = word.charAt(0);
            boolean shouldAllBeInFirstLine = firstLineSet.contains(firstChar);
            boolean shouldAllBeInSecondLine = secondLineSet.contains(firstChar);
            boolean shouldAllBeInThirdLine = thirdLineSet.contains(firstChar);
            boolean keyboardRow = true;
            for(int i=1; i < word.length();i++) {
                if(shouldAllBeInFirstLine) {
                    if(!firstLineSet.contains(word.charAt(i))) {
                        keyboardRow = false;
                        break;
                    }
                }
                if(shouldAllBeInSecondLine) {
                	//System.out.println(word.charAt(i));
                   if (!secondLineSet.contains(word.charAt(i))) {
                       keyboardRow = false;
                       break;
                   }
                }
                if(shouldAllBeInThirdLine) {
                   if (!thirdLineSet.contains(word.charAt(i))) {
                       keyboardRow = false;
                       break;
                   }
                }
            }
            if (keyboardRow) {
                keyboardRows.add(eachWord);
            }
        }
        String[] kr = new String[keyboardRows.size()];
        kr = keyboardRows.toArray(kr);
        return kr;
		
	}
}
//["aadsdfghjkla","qwertyuiadfopq","zxadfazm","asadfaedfghjkala","qadfzwertyuiopq","zxcvbnzzm"]