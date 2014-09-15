import java.util.*;

public class BinaryTree{
	Node root;
	public static void main (String[] args) {
		
		BinaryTree theTree = new BinaryTree();
		 theTree.addNode(50, "Boss");
		 theTree.addNode(25, "Vice President");
		 theTree.addNode(15, "Office Manager");
		 theTree.addNode(30, "Secretary");
		 theTree.addNode(75, "Sales Manager");
		 theTree.addNode(85, "Salesman 1");
//		 System.out.println(theTree.root.toString());
//		 theTree.inOrderTraverseTree(theTree.root);
//		 theTree.postOrderTraverseTree(theTree.root);
		 theTree.preOrderTraverseTree(theTree.root);
//		 theTree.findNode(30);
	}
	public void addNode(int key, String name){
		Node newNode = new Node(key, name);
		if (root == null){
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key < focusNode.key){
					focusNode = focusNode.leftChild;
					if (focusNode == null){
						parent.leftChild = newNode;
						return;
					} 
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					} 
				}
			}
		}
	}
	
//	public void inOrderTraverseTree(Node focusNode) {
//		if (focusNode != null){
//			System.out.println(focusNode.toString());
//			inOrderTraverseTree(focusNode.leftChild);
//			
//			inOrderTraverseTree(focusNode.rightChild);
//		}
//	}
	
	public ArrayList<Integer> inOrderTraverseTree(Node root) {
		ArrayList<Integer> leftTrav = new ArrayList<>();
		
		if (root == null){
			return leftTrav;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		Node prev = null;
		while (!stack.isEmpty()){
			Node curr = stack.peek();
			//prev == null as initial condition, 
			if(prev == null || prev.leftChild == curr || prev.rightChild == curr){
				if (curr.leftChild != null) {
					stack.push(curr.leftChild);
				} else if (curr.rightChild != null){
					stack.push(curr.rightChild);
				} else {
					stack.pop();
					leftTrav.add(curr.key);
					System.out.println(curr.toString());
				}
			} else if (curr == prev){
				if (curr.rightChild != null){
					stack.push(curr.rightChild);
				} else {
					stack.pop();
					leftTrav.add(curr.key);
					System.out.println(curr.toString());
				}
			} else if (curr.rightChild == prev) {
				stack.pop();
				leftTrav.add(curr.key);
				System.out.println(curr.toString());
			}
			
			prev = curr;
		}		 
		return leftTrav;		
	}
	public ArrayList<Integer> preOrderTraverseTree(Node root) {
		ArrayList<Integer> leftTrav = new ArrayList<>();
		
		if (root == null){
			return leftTrav;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		Node prev = null;
		while (!stack.isEmpty()){
			Node curr = stack.peek();
			//prev == null as initial condition, 
			if(prev == null || prev.leftChild == curr || prev.rightChild == curr){
				if (curr.leftChild != null) {
					stack.push(curr.leftChild);
					leftTrav.add(curr.key);
					System.out.println(curr.toString());
				} else if (curr.rightChild != null){
					stack.push(curr.rightChild);
					leftTrav.add(curr.key);
					System.out.println(curr.toString());
				} else {
					stack.pop();
				}
			} else if (curr == prev){
				if (curr.rightChild != null){
					stack.push(curr.rightChild);
					leftTrav.add(curr.key);
					System.out.println(curr.toString());
				} else {
					stack.pop();
				}
			} else if (curr.rightChild == prev) {
				stack.pop();
			}
			
			prev = curr;
		}		 
		return leftTrav;		
	}

	public Node findNode(int key){
		Node focusNode = root;
		while (key != focusNode.key){
			if(key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
		}
		System.out.println(focusNode.name);
		return focusNode;
	}
}
	class Node {
		int key;
		String name;
		Node  leftChild;
		Node rightChild;
		
		Node(int key, String name) {
			this.key = key;
			this.name = name;
		}
		
		public String toString(){
			return "Node " + key +" has a name " + name;
		}
	}

