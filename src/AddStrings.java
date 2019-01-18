import java.util.Scanner;

public class AddStrings {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String num1 = scanner.nextLine();
		String num2 = scanner.nextLine();
		System.out.println(addStrings(num1, num2));
		scanner.close();
	}

	private static String addStrings(String num1, String num2) {
		// TODO Auto-generated method stub
		int i = num1.length();
        int j = num2.length();
        int carry = 0;
        
        String sum = "";
        while((i-1) >=0 || (j-1) >=0) {
            int num1Char = 0;
            int num2Char = 0;
            int sumC = 0;
            if((i-1) >= 0) {
                num1Char = Integer.parseInt(""+num1.charAt(i-1));
            }
            if((j-1) >= 0) {
                num2Char = Integer.parseInt(""+num2.charAt(j-1));
            }
            
            if ((num1Char + num2Char + carry) >= 10) {
                sumC = (num1Char+num2Char+carry)%10;
                carry = 1;
            }else {
                sumC = (num1Char+num2Char+carry);
                carry = 0;
            }
            
            sum = ""+sumC + sum;
            i--;
            j--;
        }
        if (carry == 1) {
        	sum = "1"+sum;
        }
        return sum;
	}
}
