import java.util.Scanner;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int parsedInteger = myAtoi(str);
		System.out.println(parsedInteger);
		scanner.close();
	}

	private static int myAtoi(String str) {
		
		str = str.trim();
		char[] charArr = str.toCharArray();
		int end = charArr.length-1;
		int i = charArr.length-1;
		while(i >=0) {
			if(charArr[i] < '0' || charArr[i] > '9') {
				if(i>=1)
					end=i-1;
			}
			i--;
		}
		long num = 0;
		int power = 0;
		if(end >= 0) {
			while (end >=0) {
				if (charArr[end] < '0' || charArr[end] > '9') {
					break;
				}
				num += Character.getNumericValue(charArr[end]) * Math.pow(10, power);
				power++;
				end--;
			}
			if (end >=0 && charArr[end] == '-') {
				end--;
				num = num * -1;
			}
			if (end >=0 && charArr[end] == '+') {
				end--;
				num = num * 1;
			}
		}
		if(end>=0) {
			while(end >=0) {
				if (charArr[end] < '0' || charArr[end] > '9') {
					return 0;
				}
				end--;
			}
		}
		if(num >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if(num <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int)num;
		
	}

}
