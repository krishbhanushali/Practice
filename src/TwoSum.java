import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = scanner.nextInt();
		}
		int target = scanner.nextInt();
		int[] indices = twoSum(nums, target);
		System.out.println(indices[0]+" "+indices[1]);
		scanner.close();
	}
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
	    for(int i=0; i < nums.length; i++) {
	        if(numbers.containsKey(target-nums[i])) {
	        	return new int[] {numbers.get(target-nums[i]),i};
	        }else {
	        	numbers.put(nums[i], i);
	        }
	    }
	    return new int[2]; 
	}
}
