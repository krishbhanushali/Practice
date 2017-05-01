package WeekOfCode31;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ZeroOneGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int[] sequence = new int[n];
            for(int sequence_i=0; sequence_i < n; sequence_i++){
                sequence[sequence_i] = in.nextInt();
            }
            while(sequence.length>2){
            	sequence = getBestMove(2,sequence,"Alice");
            	sequence = getBestMove(2,sequence,"Bob");
            }
            // If Alice wins, print 'Alice' on a new line; otherwise, print 'Bob'
        }
    }

	private static int[] getBestMove(int i, int[] sequence, String string) {
		// TODO Auto-generated method stub
		
		return null;
	}
}
