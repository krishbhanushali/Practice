import java.util.*;

public class SherlockAndValidString {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        HashMap<Character,Integer> count = new HashMap<Character,Integer>();
        for(int i = 0 ; i < str.length();i++){
            if(!count.containsKey(str.charAt(i))){
                count.put(str.charAt(i),1);
            }
            else{
                count.put(str.charAt(i),count.get(str.charAt(i))+1);
            }
        }
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> entries:count.entrySet()){
            if(entries.getValue()<min)
                min = entries.getValue();
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> entries:count.entrySet()){
            if(entries.getValue()>max)
                max = entries.getValue();
        }
        int numberOfDeletions = 0;
        boolean exceeded = false;
        int frequencyOfMin = getFrequency(count, min);
        int frequencyOfMax = getFrequency(count, max);
        int greaterFreq = Math.max(frequencyOfMin, frequencyOfMax);
        if(greaterFreq==frequencyOfMin){
            for(Map.Entry<Character,Integer> entries:count.entrySet()){
            	numberOfDeletions += entries.getValue()-min;
            	if(numberOfDeletions>1){
            		exceeded=true;
            		break;
            	}
            }
        }
        else{
        	for(Map.Entry<Character,Integer> entries:count.entrySet()){
        		if(entries.getValue()!=max){
        			numberOfDeletions += entries.getValue();
        		}
            	if(numberOfDeletions>1){
            		exceeded=true;
            		break;
            	}
            }
        }
        
        if(exceeded)
            System.out.println("NO");
        else
            System.out.println("YES");
        scanner.close();
    }
    
    public static int getFrequency(HashMap<Character, Integer> count,int number){
    	int frequency=0;
    	for(Map.Entry<Character, Integer> entry:count.entrySet()){
    		if(entry.getValue()==number)
    			frequency+=1;
    	}
    	return frequency;
    }
}