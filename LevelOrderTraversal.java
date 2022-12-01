import java.util.*;

public class Lab10 {

	public static void main(String[] args) {
		
		//creates the binary tree
		BinaryTree tree = new BinaryTree();
		
		//adds in the correct binary tree nodes
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(7);
		
		//prints out the binary tree level order traversal
		System.out.print("Level order traversal: ");
		tree.printOrder();
		
		//test case handling
		//if there is only head node
		if (tree.root.left == null && tree.root.right == null) {
			System.out.println("Only One Node");
		}
		//if the head is null
		if (tree.root == null) {
			System.out.println("Empty tree");
		}

	}
	
	//creates the node class
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node (int item) {
			data = item;
			left = null;
			right = null;
		}
	}
	
	//the binary tree class
	static class BinaryTree {
		Node root;

		//prints out the level order traversal
		void printOrder() {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			//while the queue is not empty
			while (!queue.isEmpty()) {
				//get a temp node and print it out
				Node temp = queue.poll();
				System.out.print(temp.data + " ");
				
				//if there is no left node, add one to the queue
				if (temp.left != null) {
					queue.add(temp.left);
				}
				
				//if there is no right node, add one to the queue
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
		}
	}

}
