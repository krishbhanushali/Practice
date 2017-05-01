import java.util.*;
//Next lexicographic permutation
public class BiggerIsGreater {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n>0){
            String s = scan.next();
            int[] arr = new int[s.length()];
            for(int i = 0 ; i < s.length(); i++){
            	arr[i] = s.charAt(i);
            }
            int pivot = findLongestNonIncreasingSuffix(arr);
            int closest = findClosest(arr, arr[pivot], pivot);
            if(closest!=-1)
            	arr = swap(arr, pivot, closest);
            Arrays.sort(arr, pivot+1, arr.length);
            String built = "";
            for(int i=0;i<arr.length;i++){
            	built+=""+(char)arr[i];
            }
            if(built.equals(s)){
            	System.out.println("no answer");
            }
            else{
            	System.out.println(built);
            }
            n--;
        }
        scan.close();
    }
    private static int[] swap(int[]arr,int first,int second){
    	int temp = arr[first];
    	arr[first] = arr[second];
    	arr[second] = temp;
    	return arr;
    }
    private static int findLongestNonIncreasingSuffix(int[] arr) {
		// TODO Auto-generated method stub
    	int i = arr.length-2;
    	while(i>0 && arr[i]>=arr[i+1])
    		i--;
		if(i-1<0){
			return i;
		}
		return i;
	}
	private static int findClosest(int[] arr, int first,int pivot) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = pivot+1 ; i < arr.length;i++){
			if(arr[i]<min && arr[i]>first){
				min = arr[i];
				minIndex = i;
			}
		}
		if(min==Integer.MAX_VALUE)
			return -1;
		else
			return minIndex;
	}
}