import java.util.*;

public class Lab11 {

	public static void main(String[] args) {
		//creates the binary tree
		BinaryTree tree = new BinaryTree();

		//adds items to the binary tree
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		//test case not BST
		//tree.root.left.left = new Node(9);
		//test case null
		//tree.root.left.left = new Node(null);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(7);
		
		//checks if it is a BST or not. prints out true or false
		if (tree.isInOrder(tree.root) == 1) {
			System.out.println("True. Is a search tree.");
		} else {
			System.out.println("False. Not a search tree.");
		}

	}
	
	//creates the node class
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int item) {
			data = item;
			left = null;
			right = null;
		}
	}
	
	//creates the binary tree class
	static class BinaryTree {
		Node root;
		
		//checks if the tree is a bst, returns 1 for true, 0 for false
		static int isInOrder(Node node) {
			//if node is null return true
			if (node == null) {
				return 1;
			}
			
			//if left node is greater than root node return false
			if (node.left != null && node.data < isMax(node.left)) {
				return 0;
			}
			
			//if right node is less than root node return false
			if (node.right != null && node.data > isMin(node.right)) {
				return 0;
			}
			
			//recursive checks the left and right nodes
			if (isInOrder(node.left) != 1 && isInOrder(node.right) != 1) {
				return 0;
			}
			
			//if everything else is passed, return true
			return 1;
		}
		
		//checks the max value of the tree recursively
		static int isMax(Node node) {
			//if node is null return a small value so that it returns true
			if (node == null) {
				return Integer.MIN_VALUE;
			}
			
			//finds the max value and returns it
			int midValue = node.data;
			int leftValue = isMax(node.left);
			int rightValue = isMax(node.right);
			
			return Math.max(midValue, Math.max(leftValue, rightValue));
		}
		
		//checks the min value of the tree recursively
		static int isMin(Node node) {
			//if node is null return a large value so that it returns true
			if (node == null) {
				return Integer.MAX_VALUE;
			}
			
			//finds the min value and returns it
			int midValue = node.data;
			int leftValue = isMin(node.left);
			int rightValue = isMin(node.right);
			
			return Math.min(midValue, Math.min(leftValue, rightValue));
		}
	}

}
