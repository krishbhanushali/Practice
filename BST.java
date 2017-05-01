
class BSTNode<T>{
	T data;
	BSTNode<T> left;
	BSTNode<T> right;
	
	public BSTNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BSTNode<T> getLeft() {
		return left;
	}
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	public BSTNode<T> getRight() {
		return right;
	}
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
}

class BSTTree<T>{
	BSTNode<Integer> root;
	public void insert(BSTNode<Integer> root,BSTNode<Integer> node){
		if(root==null){
			root = node;
		}
		else{
			if(node.data<=root.data){
				if(root.left!=null){
					insert(root.left,node);
				}
				else{
					root.left = node;
				}
			}
			else{
				if(root.right!=null){
					insert(root.right,node);
				}
				else{
					root.right = node;
				}
			}
		}
	}
	
	public BSTNode<Integer> search(BSTNode<Integer> root,BSTNode<Integer> node){
		BSTNode<Integer> nodeFound = null;
		if(root.data == node.data){
			nodeFound = root;
		}
		else{
			if(node.data<=root.data){
				if(root.left!=null){
					nodeFound = search(root.left,node);
				}
			}
			else{
				if(root.right!=null){
					nodeFound = search(root.right,node);
				}
			}
		}
		return nodeFound;
	}
}
public class BST {
	public static void main(String[] args){
		BSTTree<Integer> bstTree = new BSTTree<Integer>();
		bstTree.root = new BSTNode<Integer>(3);
		bstTree.insert(bstTree.root,new BSTNode<Integer>(1));
		bstTree.insert(bstTree.root,new BSTNode<Integer>(2));
		bstTree.insert(bstTree.root,new BSTNode<Integer>(4));
		if(bstTree.search(bstTree.root,new BSTNode<Integer>(2))!=null){
			System.out.println("Found");
		}
		else{
			System.out.println("Not Found");
		}
	}
}
