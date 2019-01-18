import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SubdomainVisitCount {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] cpdomains = new String[n];
		scanner.nextLine();
		for(int i = 0 ; i < n ; i++) {
			cpdomains[i] = scanner.nextLine();
		}
		List<String> visits = subdomainVisits(cpdomains);
		for (String eachVisit: visits) {
			System.out.println(eachVisit);
		}
		scanner.close();
	}
	
    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for(String eachcpDomain: cpdomains) {
            String[] hitsAndDomain = eachcpDomain.split(" ");
            int hits = Integer.parseInt(hitsAndDomain[0]);
            String domain = hitsAndDomain[1];
            String[] domainLevels = domain.split("\\.");
            String lowestLevel = hitsAndDomain[1];
            if (count.containsKey(lowestLevel)) {
                count.put(lowestLevel, count.get(lowestLevel) + hits);
            }else {
                count.put(lowestLevel, hits);
            }
            if(domainLevels.length==3) {
                String secondLevel = domainLevels[1]+"."+domainLevels[2];
                if (count.containsKey(secondLevel)) {
                    count.put(secondLevel, count.get(secondLevel) + hits);
                }else {
                    count.put(secondLevel, hits);
                }
                String thirdLevel = domainLevels[2];
                if (count.containsKey(thirdLevel)) {
                    count.put(thirdLevel, count.get(thirdLevel) + hits);
                }else {
                    count.put(thirdLevel, hits);
                }
            }else if(domainLevels.length==2) {
                String thirdLevel = domainLevels[1];
                if (count.containsKey(thirdLevel)) {
                    count.put(thirdLevel, count.get(thirdLevel) + hits);
                }else {
                    count.put(thirdLevel, hits);
                }
            }
        }
        List<String> total = new ArrayList<String>();
        for(Map.Entry<String,Integer> eachEntry: count.entrySet()) {
            String key = (String)eachEntry.getKey();
            String value = ""+eachEntry.getValue();
            total.add(value+" "+key);
        }
        return total;
    }
	
}
