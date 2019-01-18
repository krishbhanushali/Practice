import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangleII {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n  = scanner.nextInt();
		List<Integer> row = getRow(n);
		System.out.println(row);
		scanner.close();
	}

	private static List<Integer> getRow(int rowIndex) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        if (rowIndex == 0) {
            return triangle.get(0);
        }
        for(int i = 1; i <=rowIndex; i++) {
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> prevRow = triangle.get(i-1);
            
            row.add(1);
            for(int j = 1; j < i; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        
        return triangle.get(rowIndex);
	}
}
