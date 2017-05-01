package WeekOfCode30;

import java.util.Scanner;

public class CandyReplenishingRobot {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		int candiesAdded = 0;
		int candiesInBowl = n;
		for(int time = 1 ; time <= t-1 ; time++){
			int candiesNeeded = in.nextInt();
			candiesInBowl -= candiesNeeded;
			if(candiesInBowl<5){
				candiesAdded+=(n-candiesInBowl);
				candiesInBowl = n;
			}
		}
		System.out.println(candiesAdded);
		in.close();
	}
}
