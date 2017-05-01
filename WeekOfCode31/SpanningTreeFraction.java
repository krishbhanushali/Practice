package WeekOfCode31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


public class SpanningTreeFraction {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		AdjacencyList adjacencyList = new AdjacencyList();
		for(int i = 0 ; i < n ; i ++){
			adjacencyList.addNode(new Node(i));
		}
		for(int i = 0 ; i < m; i++){
			Node from = new Node(scanner.nextInt());
			Node to = new Node(scanner.nextInt());
			int a  = scanner.nextInt();
			int b = scanner.nextInt();
			adjacencyList.addEdge(new Edge(from,to,a,b));
		}
		for(Map.Entry<Node, Collection<Edge>> entry:adjacencyList.adjacencyList.entrySet()){
			for(Map.Entry<Node, Collection<Edge>> skippingEdge:adjacencyList.adjacencyList.entrySet()){
				
			}
		}
		scanner.close();
	}
}

class Node{
	int data;
	
	public Node(int data) {
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
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
	}
	
}

class Edge{
	Node from;
	Node to;
	int a,b;
	public Edge(Node from, Node to, int a, int b) {
		super();
		this.from = from;
		this.to = to;
		this.a = a;
		this.b = b;
	}
	public Node getFrom() {
		return from;
	}
	public void setFrom(Node from) {
		this.from = from;
	}
	public Node getTo() {
		return to;
	}
	public void setTo(Node to) {
		this.to = to;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
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
		if (a != other.a)
			return false;
		if (b != other.b)
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

class AdjacencyList {

    public Map<Node, Collection<Edge>> adjacencyList = new HashMap<Node,Collection<Edge>>();
    Node fromNode;
	Node toNode;
	Edge fromEdge;
	Edge toEdge;
    
    public AdjacencyList() {
    	adjacencyList = new HashMap<Node,Collection<Edge>>();
    }
    

    
    public boolean adjacent(Node x, Node y) {
    	Iterator entries = adjacencyList.entrySet().iterator();
    	while(entries.hasNext())
    	{
    		Entry thisEntry = (Entry)entries.next();
    		Object key = thisEntry.getKey();
    		Object value = thisEntry.getValue();
    		Collection<Edge> edge = (Collection<Edge>)value;
    		Node currentNode = (Node)key;
    		for(Edge e:edge)
    		{
    			if((x.equals(e.getFrom()) && y.equals(e.getTo())) ||
    					(x.equals(e.getTo()) && y.equals(e.getFrom())))
    			{
    			 	return true;
    			}
    		}
    	}
        return false;
    }

    
    public List<Node> neighbors(Node x) {
    	Collection<Edge> edges = adjacencyList.get(x);
    	List<Node> nodes = new ArrayList<Node>();
    	if(edges!=null)
    	{
	    	for(Edge edge:edges)
	     	{
	    		nodes.add(edge.getTo());
	    	}
    	}
        return nodes;
    }

    
    public boolean addNode(Node x) {
    	if(adjacencyList.get(x)==null)
    	{
    		adjacencyList.put(x, null);
    		return true;
    	}
        return false;
    }

    
    public boolean removeNode(Node x) {
    	boolean nodeFound = false;
    	boolean edgeFound = false;
    	Iterator entries = adjacencyList.entrySet().iterator();
    	while(entries.hasNext())
    	{
    		Entry thisEntry = (Entry)entries.next();
    		Object key = thisEntry.getKey();
    		Object value = thisEntry.getValue();
    		Collection<Edge> edge = (Collection<Edge>)value;
    		Node currentNode = (Node)key;
    		Iterator<Edge> iterate = edge.iterator();
        	while(iterate.hasNext())
        	{
        		Edge e = iterate.next();
        	
        		if(e.getFrom().equals(x) || e.getTo().equals(x))
        		{
        			iterate.remove();
        			edgeFound = true;
        		}
        	}
    	}
    	if(adjacencyList.containsKey(x))
    	{
    		adjacencyList.remove(x);
    		nodeFound = true;
    	}
    	if(nodeFound && edgeFound)
    		return true;
    	else
    		return false;
    	
    }

    public boolean addEdge(Edge x) {
    	Node from = x.getFrom();
    	Node to = x.getTo();
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


   
    public boolean removeEdge(Edge x) {
    	Node from = x.getFrom();
    	Collection<Edge> edges = adjacencyList.get(from);
    	for(Edge edge:edges)
    	{
    		if(edge.equals(x))
    		{
    			edges.remove(edge);
    			adjacencyList.put(from, edges);
    			return true;
    		}
    	}
    	return false;
    }    
}
