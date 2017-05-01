import java.util.Scanner;

public class StringCompression {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int[] count = new int[128];
		String built = "";
		int pointer = 0;
		for(int i = 0 ; i < s.length()-1;i=pointer){
			int character = s.charAt(i);
			if(count[character]==0)
				count[character]=1;
			if(s.charAt(i)==s.charAt(i+1)){
				count[character]+=1;
				pointer+=2;
			}
			else{
				count[character]=0;
				pointer++;
			}

			built+=s.charAt(i)+""+count[character];
		}
		System.out.println(built);
		scan.close();
	}
}
