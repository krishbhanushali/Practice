package ServiceTitan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Voting {
	public static void main(String[] args){
		String[] votes = {"Alex", "Michael", "Harry","Dave", "Michael","Victor","Harry","Alex","Mary","Mary"};
		Arrays.sort(votes);
        HashMap<String,Integer> countOfVotesForACandidate = new HashMap<String,Integer>();
		for(int i = 0 ; i < votes.length ; i ++){
			String candidate = votes[i];
			if(!countOfVotesForACandidate.containsKey(candidate)){
				countOfVotesForACandidate.put(candidate, 1);
			}
			else{
				countOfVotesForACandidate.put(candidate,countOfVotesForACandidate.get(candidate)+1);
			}
		}
        int max = Integer.MIN_VALUE;
        String winner = votes[0];
        Map<String,Integer> treeMap = new TreeMap<String,Integer>(countOfVotesForACandidate);
        for(Map.Entry<String,Integer> entry:treeMap.entrySet()){
            if(entry.getValue()>=max){
                max = entry.getValue();
            	winner = entry.getKey();
            }
        }
        Collection<Integer> sad = new ArrayList<Integer>();
        System.out.println(winner);
	}
}
