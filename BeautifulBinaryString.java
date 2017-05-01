import java.util.Scanner;

public class BeautifulBinaryString {

		static int minSteps(int n, String B){
	        // Complete this function
	        int steps = 0;
	        for(int i = 1 ; i < n-1; i++){
	            if(B.charAt(i-1)=='0' && B.charAt(i+1)=='0' && B.charAt(i)=='1'){
	                steps++;
	                //System.out.println(B.substring(0,i+1)+'1'+B.substring(i+2)); 
	                B = B.substring(0,i+1)+'1'+B.substring(i+2);
	                System.out.println(B);
	            }
	        }
	        return steps;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String B = in.next();
	        int result = minSteps(n, B);
	        System.out.println(result);
	        in.close();
	    }
	
}
