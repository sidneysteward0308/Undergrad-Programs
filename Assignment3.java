import java.util.*;
public class Assignment3 {

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
		
		//prints out the original root
		System.out.println("Original root: " + tree.root.data);
		//calls the remove root method
		tree.removeRoot(tree.root, tree.root.data);
		//prints out the new root
		System.out.println("New root: " + tree.root.data);
		
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
		
		//removes the root
		//can remove any following root by adjusting the key, but for the
		//assignment instance the key is the same as the root
		public Node removeRoot(Node root, int key) {
			//if the root is null, returns null
			if (root == null) {
				return null;
			}
			
			//if the root is the key, performs some checks and returns 
			//right or left node if the rest of the nodes are null/empty
			if (root.data == key) {
				if (root.right == null && root.left == null) {
					return null;
				}
				
				if (root.left == null && root.right != null) {
					return root.right;
				}
				
				if (root.right == null && root.left != null) {
					return root.left;
				}
				//calls the search lowest method with a temporary node
				Node temp = searchLowest(root.right, root);
				root.data = temp.data;
			
			//recursively calls remove root
			} else if (root.data < key) {
				root.right = removeRoot(root.right, key);
				
			} else {
				root.left = removeRoot(root.left, key);
			}
			
			//returns root if nothing else is hit
			return root;
		}
		
		Node searchLowest(Node current, Node previous) {
			//while the left node still is not empty, navigate left
			while (current.left != null) {
				previous = current;
				current = current.left;
			}
			//remove the leftmost node
			removeRoot(previous, current.data);
			return current;
		}
		
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
