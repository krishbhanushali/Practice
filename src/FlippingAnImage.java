import java.util.Scanner;

public class FlippingAnImage {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] A = new int[m][n];
		for(int i=0; i<m;i++) {
			for(int j=0; j<n;j++) {
				A[i][j] = scanner.nextInt();
			}
		}
		A = flipAndInvertImage(A);
		for(int i=0; i<m;i++) {
			for(int j=0; j<n;j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		scanner.close();
	}

	private static int[][] flipAndInvertImage(int[][] A) {
		int[][] newA = new int[A.length][A[0].length];
		for(int i=0; i<A.length;i++) {
			int[] eachRow = A[i];
			int k = 0;
			for(int j=eachRow.length-1;j>=0; j--) {
				newA[i][k] = eachRow[j];
				newA[i][k] = (newA[i][k]==0)?1:0;
				k++;
			}
		}
		return newA;
	}
}
