package ArtificialIntelligence;

import java.util.Scanner;

public class BotSavesPrincess {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int botX=0;
		int botY=0;
		int princessX=0;
		int princessY=0;
		for(int i = 0 ; i < n; i++){
			String line = scanner.next();
			for(int j = 0 ; j < n ; j++){
				char current = line.charAt(j);
				if(current=='m'){
					botX = j;
					botY = i;
				}
				if(current=='p'){
					princessX = j;
					princessY = i;
				}
			}
		}
		int distance = getDistance(botX,botY,princessX,princessY);
		
		while(distance>0){
			int distanceForUp = getDistance(botX,botY-1,princessX,princessY);
			int distanceForRight = getDistance(botX+1,botY,princessX,princessY);
			int distanceForDown = getDistance(botX,botY+1,princessX,princessY);
			int distanceForLeft = getDistance(botX-1,botY,princessX,princessY);
			if(distanceForUp <= distanceForRight && distanceForUp <= distanceForDown && distanceForUp <= distanceForLeft){
				distance = distanceForUp;
				botY = botY-1;
				System.out.println("UP");
			}
			else if(distanceForRight <= distanceForUp && distanceForRight <= distanceForDown && distanceForRight <= distanceForLeft){
				distance = distanceForRight;
				botX = botX+1;
				System.out.println("RIGHT");
			}
			else if(distanceForDown <= distanceForUp && distanceForDown <= distanceForRight && distanceForDown <= distanceForLeft){
				distance = distanceForDown;
				botY = botY+1;
				System.out.println("DOWN");
			}
			else if(distanceForLeft <= distanceForUp && distanceForLeft <= distanceForRight && distanceForLeft <= distanceForDown){
				distance = distanceForLeft;
				botX = botX-1;
				System.out.println("LEFT");
			}
		}
		scanner.close();
	}

	private static int getDistance(int botX, int botY, int princessX, int princessY) {
		// TODO Auto-generated method stub
		return (int)Math.sqrt(((princessX-botX)*(princessX-botX))+((princessY-botY)*(princessY-botY)));
	}
}
