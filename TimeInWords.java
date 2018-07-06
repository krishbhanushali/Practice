import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TimeInWords {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int h = scanner.nextInt();
		int m = scanner.nextInt();
		
		String result = timeInWords(h, m);
		System.out.println(result);
		scanner.close();
	}
	
	static String timeInWords(int hour, int minutes) {
		Map<Integer, String> numbers = new HashMap<Integer, String>();
		numbers.put(1, "one");numbers.put(2, "two");numbers.put(3, "three");numbers.put(4, "four");numbers.put(5, "five");numbers.put(6, "six");
		numbers.put(7, "seven");numbers.put(8, "eight");numbers.put(9, "nine");numbers.put(10, "ten");numbers.put(11, "eleven");numbers.put(12, "twelve");
		numbers.put(13, "thirteen");numbers.put(14,"fourteen");
		numbers.put(15, "fifteen");numbers.put(16,"sixteen");
		numbers.put(17, "seventeen");numbers.put(18,"eighteen");
		numbers.put(19, "nineteen");numbers.put(20,"twenty");
		numbers.put(21, "twenty one");numbers.put(22,"twenty two");
		numbers.put(23, "twenty three");numbers.put(24,"twenty four");
		numbers.put(25, "twenty five");numbers.put(26,"twenty six");
		numbers.put(27, "twenty seven");numbers.put(28,"twenty eight");
		numbers.put(29, "twenty nine");
		
		
		if (minutes == 0 ) {
			return numbers.get(hour)+" o' clock";
		}else if (minutes >= 1 && minutes <= 30 )  {
			if(minutes == 15) {
				return "quarter past " + numbers.get(hour);
			}
			else if (minutes == 30) {
				return "half past " + numbers.get(hour);
			}else {
				String minutesString = "minutes";
				if (minutes == 1) {
					minutesString = "minute";
				}
				return numbers.get(minutes) +" "+ minutesString + " past " + numbers.get(hour);
			}
		}else{
			if(minutes == 45) {
				return "quarter to "+numbers.get(hour+1);
			}
			int remainder = 60 - minutes;
			String minutesString = "minutes";
			if (remainder == 1) {
				minutesString = "minute";
			}
			return numbers.get(remainder) + " "+ minutesString + " to " + numbers.get(hour+1);
		}
    }
}
