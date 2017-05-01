import java.util.*;
class NonConsecutiveSum{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = scanner.nextInt();
		}
		int max = arr[0];
		for(int i = 1 ; i < n ; i ++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		int secondMax = arr[0];
		for(int i = 1; i < n ; i ++){
			if(arr[i]<max && arr[i]>secondMax && !isConsecutive(arr[i],max)){
				secondMax = arr[i];
			}
		}
		System.out.println(max+secondMax);
		scanner.close();
	}

	private static boolean isConsecutive(int num1,int num2) {
		// TODO Auto-generated method stub
		if(num1-1 == num2 || num1+1==num2)
			return true;
		return false;
	}
}

/*
 
6
1
2
1
7
9
8
 
 
 */
