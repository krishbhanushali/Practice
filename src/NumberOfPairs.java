import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberOfPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ; i ++) {
			a[i] = scanner.nextInt();
		}
		long k = scanner.nextLong();
		System.out.println(numberOfPairs(a,k));
		scanner.close();

	}

	private static int numberOfPairs(int[] a, long k) {
		// TODO Auto-generated method stub
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Pair> pairs = new HashSet<Pair>(); 
        for(int i=0; i < a.length; i++) {
        	if(map.containsKey((int)k - a[i])) {
        		if(!pairs.contains(new Pair(a[i],(int)k-a[i]))) {
        			pairs.add(new Pair(a[i],(int)k-a[i]));
        		}
        	}else {
        		map.put(a[i], i);
        	}
        }
        return pairs.size();
	}

}

class Pair {
	int first;
	int second;
	
	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + first;
		result = prime * result + second;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (first != other.first)
			return false;
		if (second != other.second)
			return false;
		return true;
	}
	
	
}
