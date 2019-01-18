import java.util.Scanner;

public class IntToRoman {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(intToRoman(n));
		scanner.close();
	}
	public static String intToRoman(int num) {
        String roman = "";
        
        //1234
        int previous = 0;
        while(num > 0) {
            if (num >= 1000) {
                num = num - 1000;
                previous = 1000;
                roman += "M";
            }
            else if (num >= 500) {
                num = num - 500;
                previous = 500;
                roman += "D";
            }
            else if (num >= 100) {
                num = num - 100;
                previous = 100;
                roman += "C";
            }else if(num >= 50) {
            	num = num - 50;
            	previous = 50;
            	roman += "L";
            }else if (num >= 10) {
            	num = num - 10;
            	previous = 10;
            	roman += "X";
            }else if (num >= 5) {
            	num = num - 5;
            	previous = 5;
            	roman += "V";
            }else if (num >=1) {
            	num = num - 1;
            	previous = 1;
            	roman += "I";
            }
        }
        return roman;
    }

}
