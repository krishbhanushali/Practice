package ServiceTitan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Zombies {
	public static void main(String[] args)
	{
		String[] zombies = {"1100","1110","0110","0001"};
		char[][] zombieCluster = new char[zombies.length][zombies.length];
	    for(int i = 0; i<zombieCluster.length;i++){
	        for(int j=0;j<zombieCluster.length;j++){
	            zombieCluster[i][j] = zombies[i].charAt(j);
	        }
	    }
	    int count = 0;
	    int[] zombiesTrans = new int[zombies.length];
	    HashMap<Integer,Collection<Integer>> clusters = new HashMap<Integer,Collection<Integer>>();
	    for(int i = 0; i<zombieCluster.length;i++){
	        
	        for(int j=0;j<zombieCluster.length;j++){
	            Collection<Integer> transitiveZombies = new ArrayList<Integer>();
	            System.out.println(zombieCluster[i][j]);
	            if(zombieCluster[i][j]=='1' && i==j){
	                clusters.put(i,null);
	            }
	            else if(i!=j && zombieCluster[i][j]=='1'){
	                if(!clusters.containsKey(i)){
	                    transitiveZombies.add(j);
	                    clusters.put(i,transitiveZombies);
	                }
	                else{
	                	Collection<Integer> alreadyZombies = clusters.get(i);
	                	alreadyZombies.add(j);
	                }
	            }
	        }
	    }
	    for(Map.Entry<Integer, Collection<Integer>> entry:clusters.entrySet()){
	    	if(entry.getValue().size()==1 || entry.getValue()==null )
	    		clusters.remove(entry);
	    }
	    
	    System.out.println(clusters.size());
	}
}
