import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] arr = new int[m];
		for(int i = 0 ; i < m ; i++){
			arr[i] = scanner.nextInt();
		}
		Arrays.sort(arr);
		int paths = makeChange(n,arr,0);
		System.out.println(paths);
		scanner.close();
	}

	private static int makeChange(int money, int[] arr,int index) {
		// TODO Auto-generated method stub
		int amountOfCoin = 0;
		int ways = 0;
		if(money==0)
			return 1;
		if(index>=arr.length)
			return 0;
		while(amountOfCoin<=money){
			int remaining = money-amountOfCoin;
			ways+=makeChange(remaining,arr,index+1);
			amountOfCoin+=arr[index];
		}
		return ways;
	}
}
