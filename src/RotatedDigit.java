import java.util.Scanner;

class RotatedDigit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(rotatedDigits(scanner.nextInt()));
		scanner.close();
	}
    public static int rotatedDigits(int N) {
        int count = 0;
        for(int i=1; i <= N; i++) {
            if(i <= 10) {
                if (i==2 || i == 5 || i == 6 || i == 9) {
                    count ++;
                }
            }else {
                int rotatedDigit = rotate(i);
                if(rotatedDigit!= Integer.MAX_VALUE && rotatedDigit != i)
                    count++;
            }
        }
        return count;
    }
    public static int rotate(int num) {
        StringBuilder str = new StringBuilder("");
        while(num > 0) {
            int digit = num % 10;
            if (digit == 2) { str.append("5"); }
            else if(digit == 5) { str.append("2"); }
            else if( digit == 6) { str.append("6"); }
            else if(digit == 9) {str.append("7"); }
            else if((digit == 0) || (digit==1) || (digit==8)) {str.append(digit);}
            else {
                return Integer.MAX_VALUE;
            }
            num /= 10;
        }
        return Integer.parseInt(""+str.reverse());
    }
}