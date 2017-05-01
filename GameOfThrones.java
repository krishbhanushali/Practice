import java.util.Scanner;

public class GameOfThrones {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		int[] count = new int[128]; 
		for(int i = 0 ; i < str.length(); i++){
			count[str.charAt(i)]+=1;
		}
		int countForOdd = 0;
		boolean isHavingKey = true;
		for(int i = 0 ; i < count.length;i++){
			if(count[i]%2!=0){
				countForOdd +=1;
			}
			if(countForOdd>1){
				isHavingKey = false;
				break;
			}
		}
		if(isHavingKey) System.out.println("YES");
		else System.out.println("NO");
		scanner.close();
	}
}
