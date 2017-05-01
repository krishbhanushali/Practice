import java.util.*;
import java.util.LinkedList;
import java.util.Map.Entry;

public class BFSShortestReach {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scanner = new Scanner(System.in);
    	int q = scanner.nextInt();
    	for(int i = 0 ; i < q; i++){
    		int n = scanner.nextInt();
    		int m = scanner.nextInt();
    		AdjacencyList adjacencyList = new AdjacencyList(n);
    		for(int j=1;j<=n;j++){
    			adjacencyList.addNode(new NodeT(j));
    		}
    		for(int j=0;j<m;j++){
    			NodeT from = new NodeT(scanner.nextInt());
    			NodeT to = new NodeT(scanner.nextInt());
    			adjacencyList.addEdge(new EdgeT(from, to, 6));
    			adjacencyList.addEdge(new EdgeT(to, from, 6));
    		}
    		NodeT root = new NodeT(scanner.nextInt());
    		Queue<NodeT> queue = new LinkedList<NodeT>();
    		HashMap<NodeT,Boolean> visited = new HashMap<NodeT,Boolean>();
    		HashMap<NodeT,Integer> parent = new HashMap<NodeT,Integer>();
    		queue.add(root);
    		visited.put(root, true);
    		parent.put(root, 0);
    		while(!queue.isEmpty()){
    			NodeT currentNode = queue.poll();
    			List<NodeT> neighbors = adjacencyList.neighbors(currentNode);
    			if(neighbors!=null){
    				for(NodeT eachNeighbor:neighbors){
    					if(!visited.containsKey(eachNeighbor)){
    						queue.add(eachNeighbor);
    						visited.put(eachNeighbor, true);
    						if(parent.containsKey(currentNode)){
    							parent.put(eachNeighbor, parent.get(currentNode)+6);
    						}
    						
    					}
    				}
    			}
    		}
    		for(int j = 1; j <=n ; j++){
    			NodeT currentNode = new NodeT(j);
    			if(!currentNode.equals(root)){
    				if(parent.containsKey(currentNode)){
    					System.out.print(parent.get(currentNode)+" ");
    				}
    				else{
    					System.out.print("-1 ");
    				}
    			}
    			
    		}
    		System.out.println();
    	}
    	scanner.close();
    }
}


class NodeT{
	int data;
	
	public NodeT(int data) {
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
		NodeT other = (NodeT) obj;
		if (data != other.data)
			return false;
		return true;
	}
	
}

class EdgeT{
	NodeT from;
	NodeT to;
	int distance;
	public EdgeT(NodeT from, NodeT to, int distance) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
	public NodeT getFrom() {
		return from;
	}
	public void setFrom(NodeT from) {
		this.from = from;
	}
	public NodeT getTo() {
		return to;
	}
	public void setTo(NodeT to) {
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
		EdgeT other = (EdgeT) obj;
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

class AdjacencyList{
	Map<NodeT,Collection<EdgeT>> adjacencyList = null;
	
	public AdjacencyList(int n) {
		super();
		this.adjacencyList = new HashMap<NodeT,Collection<EdgeT>>(n);
	}
	public boolean addNode(NodeT node){
		if(!adjacencyList.containsKey(node)){
			adjacencyList.put(node,null);
			return true;
		}
		return false;
	}
	public boolean addEdge(EdgeT x){
		NodeT from = x.getFrom();
    	NodeT to = x.getTo();
    	boolean present = false;
    	Collection<EdgeT> edges = new ArrayList<EdgeT>();
    	if(adjacencyList.containsKey(from)){
    		if(adjacencyList.get(from)!=null){
    			edges = adjacencyList.get(from);
    		}
    		if(edges != null){
		    	for(EdgeT edge : edges)
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
	public List<NodeT> neighbors(NodeT node){
		List<NodeT> allNeighbors = new ArrayList<NodeT>();
		if(adjacencyList.containsKey(node)){
			Collection<EdgeT> edges = adjacencyList.get(node);
			if(edges!=null){
				for(EdgeT e:edges){
					allNeighbors.add(e.getTo());
				}
			}
		}
		return allNeighbors;
	}
}