import java.util.Scanner;

public class CountAndSay {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(countAndSay(n));
		scanner.close();
	}
	
	public static String countAndSay(int n) {
        String returnStr = "1";
        if (n == 1) {
            return returnStr;
        }
        for(int j = 0; j < n-1 ; j++) {
            String newStr= new String();
            char[] numbers = returnStr.toCharArray();
            char currentChar = numbers[0];
            int count = 0;
            for(int i = 0; i < numbers.length; i++ ) {
                
                if (currentChar == numbers[i]) {
                    count++;
                }else {
                    newStr += ""+count+""+currentChar;
                    count = 1;
                    currentChar = numbers[i];
                }
            }
            newStr += ""+count+""+currentChar;
            returnStr = newStr;
        }
        return returnStr;
    }
}
