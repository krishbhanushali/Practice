import java.util.*;
class Node<T>{
	public T data;
	public Node<T> next;
	public Node(T data){
		this.data = data;
		this.next = null;
	}
	
	T getData(){
		return data;
	}
	
	void setData(T data){
		data = this.data;
	}
	
	Node<T> getNode(){
		return next;
	}
	
	void setNext(Node<T> next){
		next = this.next;
	}
}
class LinkedList<T>{
	Node<T> head = null;
	void insert(Node<T> data){
		Node<T> newNode = data;
		if(head == null){
			head = newNode;
		}
		Node<T> currentNode = head;
		while(currentNode.next!=null){
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		newNode.next = null;
	}
	
	void print(){
		if(head==null){
			System.out.println("Linked List is empty");
		}
		else{
			Node<T> currentNode = head;
			while(currentNode!=null){
				System.out.print(currentNode.getData()+" ");
				currentNode = currentNode.next;
			}
		}
	}
}
class ReverseLinkedList{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for(int i = 0 ; i < n ; i++){
			Integer data = scan.nextInt();
			Node<Integer> node = new Node<Integer>(data);
			linkedList.insert(node);
		}
		linkedList.print();
		scan.close();
	}	
}