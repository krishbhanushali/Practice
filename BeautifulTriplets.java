
import java.util.*;

public class BeautifulTriplets {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        
        int count=0;
        for(int j = 1;j < n-1;j++){
            int i = j-1;
            int k = j+1;
            while(i>=0){
                if(arr[j]-arr[i]==d){
                    while(k!=n){
                        if(arr[k]-arr[j]==d){
                        	//System.out.println("("+arr[i]+","+arr[j]+","+arr[k]+")");
                            count++;
                        }
                        k++;
                    }
                }
                i--;
            }
        }
        System.out.println(count);
        scan.close();
    }
}