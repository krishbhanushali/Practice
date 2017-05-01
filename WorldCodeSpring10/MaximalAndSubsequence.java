package WorldCodeSpring10;
import java.util.*;

public class MaximalAndSubsequence {
	static List<Long> andOutputs = new ArrayList<Long>();
    static long[] solve(int n, int k, long[] a){
        // Complete this function
    	
    	long[] result = new long[n];
    	long[] data = new long[k];
    	quicksort(0,n-1,a);
    	System.out.println(Arrays.toString(a));
    	permute(a,data,0,n-1,0,k);
    	
    	Collections.sort(andOutputs,Collections.reverseOrder());
    	long max = andOutputs.get(0);
    	int count = 0;
    	for(long out:andOutputs){
    		if(out==max){
    			count++;
    		}
    		else
    			break;
    	}
    	System.out.println(max);
    	System.out.println((int)(count%((Math.pow(10, 9))+7)));
    	return result;
    }
    private static void quicksort(int p, int r, long[] a) {
		// TODO Auto-generated method stub
    	if(p<r){
    		int q = partition(a,p,r);
    		quicksort(p,q-1,a);
    		quicksort(q+1,r,a);
    	}	
    	return;
	}
	private static int partition(long[] a, int p, int r) {
		// TODO Auto-generated method stub
		long x = a[r];
		int i = p-1;
		for(int j = p ; j<=r-1;j++){
			if(a[j]>=x){
				i+=1;
				long temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		long temp = a[i+1];
		a[i+1] = a[r];
		a[r] = temp;
		return i+1;
	}
	static void permute(long[] arr,long[] data, long start, long end,long index,long r){
		long max = Integer.MIN_VALUE;
		if(!andOutputs.isEmpty())
			max = andOutputs.get(0);
    	if (index == r)
        {
    		long andOutput = data[0];
            for (int j=1; j<r; j++){
            	andOutput&=data[j];
            }
            if(andOutput<max){
            	return;
            }
            andOutputs.add(andOutput);
            return;
        }
 
        for (long i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[(int) index] = arr[(int) i];
            permute(arr, data, i+1, end, index+1, r);
        }
	}
    
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] a = new long[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long[] result = solve(n, k, a);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime -startTime;
        System.out.println(totalTime+" ms");
    }
}

