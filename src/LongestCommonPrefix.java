import java.util.Scanner;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] strs = new String[n];
		for(int i=0; i < n; i++) {
			strs[i] = scanner.nextLine();
		}
		System.out.println(longestCommonPrefix(strs));
		scanner.close();

	}

	private static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0 ) return "";
        String common = "";
        boolean equalNotFound = false;
        // aa
        // a
        for(int i=0; i < strs[0].length(); i++) {
            for(int j=1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    equalNotFound = true;
                    break;
                }
            }
            if (equalNotFound) break;
            else common += strs[0].charAt(i);
        }
        return common;
	}

}
