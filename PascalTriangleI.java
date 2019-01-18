import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangleI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n  = scanner.nextInt();
		List<List<Integer>> pascals = generate(n);
		System.out.println(pascals);
		scanner.close();
	}

	private static List<List<Integer>> generate(int n) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if ( n == 0) {
			return triangle;
		}
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);
		
		for (int i=1; i < n; i++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(i-1);
			row.add(1);
			for(int j=1; j < i; j++) {
				row.add(prevRow.get(j-1) + prevRow.get(j));
			}
			row.add(1);
			triangle.add(row);
		}
		return triangle;
	}
}
