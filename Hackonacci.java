import java.util.Scanner;

public class Hackonacci {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		char[][] matrix = new char[n][n];
		for(int i = 0 ; i < n ; i ++){
			for(int j = 0 ; j < n ; j ++){
				int result = getHackoNacci((i*j)^2,1);
				System.out.println(result);
			}
		}
		scan.close();
	}
	
	public static int getHackoNacci(int number,int index){
		return index * getHackoNacci(number-1, index+1);
	}
}
