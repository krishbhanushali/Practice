package WorldCodeSpring10;

import java.util.Scanner;
public class PermutationHappiness {
	static int count = 0;
	static int query(int n, int k){
        // Complete this function
		int[] arr = new int[n];
		for(int i = 1; i <=n; i++){
			arr[i-1] = i;
		}
		permute(arr, 0, n-1,k);
		return ((int)(count%(Math.pow(10, 9)+7)));
    }
	static void permute(int[] arr,int l, int r,int k){
		if(l==r){
			int numberOfPeopleHappy = 0;
			//System.out.println(Arrays.toString(arr));
			for(int i = 0 ; i < arr.length;i++){
				if(arr[i]!=r+1 && numberOfPeopleHappy<=k){				
					if(i==0){
						if(arr[i+1]>arr[i]){
							numberOfPeopleHappy+=1;
						}
					}
					else if(i==arr.length-1){
						if(arr[i-1]>arr[i]){
							numberOfPeopleHappy+=1;						
						}
					}
					else if(arr[i+1] > arr[i] || arr[i-1]>arr[i]){
						numberOfPeopleHappy+=1;
					}
				}
				if(numberOfPeopleHappy==k){
					count+=1;
					break;
				}
			}
		}
		else{
			for(int i=l;i<=r;i++){
				arr = swap(arr, l, i);
				permute(arr,l+1,r,k);
				arr = swap(arr,l,i);
			}
		}		
	}
    private static int[] swap(int[] arr, int l, int i) {
    	int temp = arr[i];
    	arr[i] = arr[l];
    	arr[l] = temp;
		return arr;
	}
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            count = 0;
            // Find the number of ways to arrange 'n' people such that at least 'k' of them will be happy
            // The return value must be modulo 10^9 + 7
            int result = query(n, k);
            System.out.println(result);
        }
    }
}
