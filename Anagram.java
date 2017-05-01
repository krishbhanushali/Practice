
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class Anagram {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String first = scanner.nextLine();
		String second = scanner.nextLine();
		HashMap<Character,Integer> countFirst = new HashMap<Character,Integer>();
		HashMap<Character,Integer> countSecond = new HashMap<Character,Integer>();
		for(int i = 0 ; i < first.length();i++){
			if(!countFirst.containsKey(first.charAt(i))){
				countFirst.put(first.charAt(i), 1);
			}
			else{
				countFirst.put(first.charAt(i),countFirst.get(first.charAt(i))+1);
			}
		} 
		for(int i = 0 ; i < second.length();i++){
			if(!countSecond.containsKey(second.charAt(i))){
				countSecond.put(second.charAt(i), 1);
			}
			else{
				countSecond.put(second.charAt(i),countSecond.get(second.charAt(i))+1);
			}
		}
		int diff = 0;
		for(Map.Entry<Character,Integer> entry:countFirst.entrySet()){
			if(countSecond.containsKey(entry.getKey())){
				if(countSecond.get(entry.getKey())!=entry.getValue()){
					diff = diff + Math.abs(countSecond.get(entry.getKey())-entry.getValue());
				}
			}
			else{
				diff = diff + entry.getValue();
			}
		}
		for(Map.Entry<Character,Integer> entry:countSecond.entrySet()){
			if(!countFirst.containsKey(entry.getKey())){
				diff = diff + entry.getValue();
			}
		}
		System.out.println(diff);
		scanner.close();
	}
}
