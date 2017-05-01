import java.util.*;
class DecimalToBinary{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int decimal = scanner.nextInt();
		String original = "";
		while(decimal>0){
			original = decimal%2+""+original;
			decimal = decimal/2;
		}
		System.out.println(original);
	}
}