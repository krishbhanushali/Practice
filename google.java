import java.util.ArrayList;
import java.util.List;

public class google {
	public static void main(String[] args){
		String s = "123456789";
		List<Integer> allNumbers = new ArrayList<Integer>(); 
		for(int i =0;i<s.length()-1;i++){
			int firstNumber = Integer.parseInt(""+s.charAt(i));
			int secondNumber = Integer.parseInt(""+s.charAt(i+1));
			double d=(firstNumber+secondNumber)/2.0;
			int average = (int)Math.round(d);
			String temp = s;
			String firstPart = "";
			if(i>0)
				firstPart= temp.substring(0,i);
			String secondPart = temp.substring(i+2);
			int eachNumberGenerated = Integer.parseInt(firstPart+""+average+""+secondPart);
			allNumbers.add(eachNumberGenerated);
		}
		int max = allNumbers.get(0);
		for(Integer no:allNumbers){
			System.out.println(no);
			if(no>max){
				max = no;
			}
		}
		System.out.println(max);
	}
}
