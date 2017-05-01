import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JourneyToTheMoon {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		AdjacencyList1 a = new AdjacencyList1();
		for(int i = 0 ; i < n ; i ++){
			a.addNode1(new Node1(i));
		}
		
		for(int i = 0; i < e;i++){
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			a.addEdge(new Edge(new Node1(from),new Node1(to),1));
		}
		for(Map.Entry<Node1, Collection<Edge>> entries:a.adjacencyList.entrySet()){
			
		}
		scanner.close();
	}
}


class Node1{
	int data;

	
	public Node1(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node1 other = (Node1) obj;
		if (data != other.data)
			return false;
		return true;
	}
	
}

class Edge{
	Node1 from;
	Node1 to;
	int distance;
	
	public Edge(Node1 from, Node1 to, int distance) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
	public Node1 getFrom() {
		return from;
	}
	public void setFrom(Node1 from) {
		this.from = from;
	}
	public Node1 getTo() {
		return to;
	}
	public void setTo(Node1 to) {
		this.to = to;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distance;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (distance != other.distance)
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}
	
	
}

class AdjacencyList1{
	HashMap<Node1,Collection<Edge>> adjacencyList; 
	AdjacencyList1(){
		adjacencyList = new HashMap<Node1,Collection<Edge>>();
	}
	
	public boolean addNode1(Node1 node){
		if(!adjacencyList.containsKey(node)){
			adjacencyList.put(node,null);
			return true;
		}
		return false;
	}
	public boolean addEdge(Edge x){
		Node1 from = x.getFrom();
    	Node1 to = x.getTo();
    	boolean present = false;
    	Collection<Edge> edges = new ArrayList<Edge>();
    	if(adjacencyList.containsKey(from)){
    		if(adjacencyList.get(from)!=null){
    			edges = adjacencyList.get(from);
    		}
    		if(edges != null){
		    	for(Edge edge : edges)
		    	{
		    		if(edge.getFrom().equals(from) && edge.getTo().equals(to))
		    			present = true;
		    	}
    		}
    	}
    	if(present)
    		return false;
    	else
    	{
    		edges.add(x);
    		adjacencyList.put(x.getFrom(), edges);
    		return true;
    	}
	}
	public List<Node1> neighbors(Node1 node){
		List<Node1> allNeighbors = new ArrayList<Node1>();
		if(adjacencyList.containsKey(node)){
			Collection<Edge> edges = adjacencyList.get(node);
			if(edges!=null){
				for(Edge e:edges){
					allNeighbors.add(e.getTo());
				}
			}
		}
		return allNeighbors;
	}
}