import java.util.*;


public class WeightedUniformString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        HashSet<Integer> hashMap = new HashSet<Integer>();
        int countOfChars = 1;
        char previousChar = '\0';
        for(int i = 0; i<s.length();i++){
            char currentChar = s.charAt(i);
            if(currentChar == previousChar){
                countOfChars++;
            }
            else{
                countOfChars = 1;
                previousChar = currentChar;
            }
            int value = (((int)currentChar+26)%123)+1;
            hashMap.add(value*countOfChars);
            
        }
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            if(hashMap.contains(x))
                System.out.println("Yes");
            else
                System.out.println("No");
            // your code goes here
        }
        in.close();
    }
}
