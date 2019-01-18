import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class KeysAndRooms {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfRooms = scanner.nextInt();
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		for(int i = 0; i < numberOfRooms; i++) {
			int numberOfKeys = scanner.nextInt();
			List<Integer> keys = new ArrayList<Integer>();
			for(int j=0; j < numberOfKeys;j ++) {
				keys.add(scanner.nextInt());
			}
			
			rooms.add(i,keys);
		}
		System.out.println(canVisitAllRooms(rooms));
		scanner.close();
	}
	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        for(Integer eachKey: rooms.get(0)) {
        	queue.add(eachKey);
        }
        visited[0] = 1;
        while (!queue.isEmpty()) {
        	Integer key = queue.poll();
        	if (visited[key] == 0) {
        		for(Integer eachKey: rooms.get(key)) {
        			queue.add(eachKey);
        		}
        		visited[key] = 1;
        	}
        }
        for(int i=0; i < visited.length; i++) {
        	if(visited[i] == 0)
        		return false;
        }
        return true;
    }
}
