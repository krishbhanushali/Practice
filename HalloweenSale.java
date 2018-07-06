import java.io.*;
import java.util.*;
public class HalloweenSale {

    // Complete the howManyGames function below.
	
	//p -> price of each video game
	//d -> value decreasing
	//m -> limit
	//s -> total amount in wallet
	
	// p = 30
	// d = 1
	// m = 26
	// s = 100
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int numberOfGames = 0;
        if (s < p) {
            return 0;
        }
        while ((s-p) >= 0) {
        	s -= p;
        	if (p <= m || (p-d) <= m) {
        		p = m;
        	}else {
        		p -=d;
        	}
            numberOfGames++;
        }
        return numberOfGames;
    }

    public static void main(String[] args) throws IOException {
        
    	Scanner scanner = new Scanner(System.in);
        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        System.out.println(answer);

        scanner.close();
    }
}
