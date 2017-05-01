package WorldCodeSpring10;

import java.util.Scanner;

public class RewardPoints {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		
		for(int i = 0 ; i < 3; i ++){
			int numberOfSwipes = scanner.nextInt();
			int rewardsForTheMonth = (numberOfSwipes*10>100)?100:numberOfSwipes*10;
			sum+= rewardsForTheMonth;
		}
		
		System.out.println(sum);
		scanner.close();
	}
}
