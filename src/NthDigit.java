import java.util.Scanner;

public class NthDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n  = scanner.nextInt();
		System.out.println(findNthDigit(n));
		scanner.close();
	}
	public static int findNthDigit(int n) {
        long nthCounter = 0;
        int i = 1;
        for(i=1; i <= n ; i++) {
            int numberOfDigits = getNumberOfDigits(i);
            nthCounter += numberOfDigits;
            if (nthCounter >= n) {
                break;
            }
        }
        int diff = (int)nthCounter - n;
        int digit = Integer.MAX_VALUE;
        while(diff>=0) {
          digit = i % 10;
          i/=10;
          diff--;
        }
        return digit;
    }
    
    public static int getNumberOfDigits(int number) {
        int digits = 0;
        while(number > 0) {
            number /= 10;
            digits ++;
        }
        return digits;
    }
}
