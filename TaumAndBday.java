import java.util.*;

public class TaumAndBday {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();
            
            long sumOfBlackGifts = (y+z<x)?b*(y+z):b*x;
            long sumOfWhiteGifts = (x+z<y)?w*(x+z):w*y;
            System.out.println(sumOfBlackGifts+sumOfWhiteGifts);
        }
    }
}
