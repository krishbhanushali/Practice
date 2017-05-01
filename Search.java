import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Search {
	public static void main(String[] args){
		int n = 0;
		System.out.println("Enter n :");
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[scanner.nextInt()];
		populateArray(array);
		
	}

	private static void populateArray(int[] array) {
		// TODO Auto-generated method stub
		for(int i = 0;i<array.length;i++){
			array[i] = i;
		}
	}
}
