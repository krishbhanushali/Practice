package WeekOfCode30;
import java.util.Scanner;

public class Poles {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int numberOfPoles = scanner.nextInt();
		int numberOfStacks = scanner.nextInt();
		int[] altitudeOfPoles = new int[numberOfPoles];
		int[] weightOfPoles = new int[numberOfPoles];
		int[] costOfRearrange = new int[numberOfPoles];
		for(int i = 0 ; i < numberOfPoles; i ++){
			altitudeOfPoles[i] = scanner.nextInt();
			weightOfPoles[i] = scanner.nextInt();
		}
		int[] stackIndexes = new int[numberOfPoles];
		stackIndexes[0] = 1;
		int numberOfStacksCounted=1;
		for(int i = 2;i<stackIndexes.length-1;i++){
			if(numberOfStacksCounted%numberOfStacks==0){
			}
			else{
				int nextStackIndex = i;
				stackIndexes[i] = 1;
				System.out.println("calculate cost of both poles");
				//again make it zero
				stackIndexes[i] = 0;
			}
			numberOfStacksCounted++;
		}
	}

	private static int getCostOfRearranging(int currentStack, int[] altitudeOfPoles, int[] weightOfPoles,int numberOfStacks, int depth) {
		// TODO Auto-generated method stub
		
		return 0;
	}
}
