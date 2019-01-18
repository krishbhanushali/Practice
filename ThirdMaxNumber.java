import java.util.Scanner;

public class ThirdMaxNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i ++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println(thirdMax(arr));
		scanner.close();
	}

	private static int thirdMax(int[] nums) {
		long firstMax = Long.MIN_VALUE;
        long secondMax = Integer.MIN_VALUE;
        long thirdMax= Long.MIN_VALUE;
        
        for(int i = 0 ; i < nums.length;i++) {
            if(nums[i] > firstMax) {
                firstMax = nums[i];
            }
        }
        //secondMax = firstMax;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < firstMax && nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if(secondMax == Long.MIN_VALUE) {
            return (int)firstMax;
        }
        //thirdMax = secondMax;
        
        for(int i =0 ; i < nums.length; i++) {
            if(nums[i] < secondMax && nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
        }
        if(thirdMax == Long.MIN_VALUE) {
            return (int)firstMax;
        }
        return (int)thirdMax;
	}
}
