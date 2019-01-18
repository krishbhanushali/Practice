import java.util.Scanner;

public class SQRT {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(mySqrt(n));
		scanner.close();

	}

	private static int mySqrt(int x) {
		// TODO Auto-generated method stub
		if (x == 0) return x;
		int low = 1;
		int high = x;
		long mid = x/2;
		while ( low <= high) {
			if ( mid * mid > x) {
				high = (int)mid - 1;
			}else if (mid * mid < x) {
				low = (int)mid + 1;
			}else {
				return (int)mid;
			}
			mid = (low + high) / 2;
		}
		return (int)mid;
	}

}
