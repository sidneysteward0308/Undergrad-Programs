public class Lab7 {
	//main method that populates the list, calls the other methods, and prints
	public static void main(String[] args) {
		//creates a new linked list object
		Lab7 list = new Lab7();
		
		//populates the list
		list = insert(list, 50);
		list = insert(list, 11);
		list = insert(list, 33);
		list = insert(list, 21);
		list = insert(list, 40);
		list = insert(list, 71);
		
		//test case for if another element is added to the list
		//list = insert(list, 22);
		
		//prints out the initial list
		System.out.println("Before deletion: ");
		print(list);
		
		//deletes the Nth node and prints out the resulting list
		list.deleteNth(list);
		System.out.println("\nAfter deletion: ");
		print(list);
	}
	
	//creates the node's head
	Node head;
	
	//the node class to implement new nodes and point them to the next node
	static class Node {
		int data;
		Node next;
		
		Node(int input) {
			data = input;
			//sets the end of the list to null;
			next = null;
		}
	}
	
	//inserts a new node to the list
	public static Lab7 insert(Lab7 list, int data) {
		Node new_node = new Node(data);
		
		//if there is no head yet
		if (list.head == null) {
			//make a new one
			list.head = new_node;
		//else puts in a new node after the lastmost node but before null
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new_node;
		}
		//returns the list
		return list;
	}
	
	//prints out the list
	public static void print(Lab7 list) {
		Node currentNode = list.head;
		
		//while not at the end of the list, print out the current node
		while(currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
	}
	
	//makes a dummy node and sets the next pointer to head
	public void Dummy(int data) {
		Node dummy = new Node(data);
		dummy.next = head;
		dummy = head;
	}
	
	//method to delete the Nth node
	void deleteNth(Lab7 list) {
		//makes a fast and slow pointer, setting the fast pointer ahead by one
		Node slowPointer = head;
		Node fastPointer = head.next;
		//while the fast pointer is not at the end
		while (fastPointer.next != null) {
			//increment both pointers, but the fast pointer by two
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		//otherwise delete the nextmost node to the slow pointer
		slowPointer.next.next = slowPointer.next.next.next;
	}
}
