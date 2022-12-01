import java.util.*;
public class Lab9 {

	public static void main(String[] args) {
		Deque<Integer> mainqueue = new ArrayDeque<Integer>();
		Deque<Integer> maxqueue = new ArrayDeque<Integer>();
		
		mainqueue.add(1);
		mainqueue.add(4);
		mainqueue.add(2);
		mainqueue.add(3);
		
		for (Integer element : mainqueue) {
			if (maxqueue.peekFirst() == null) {
				maxqueue.add(element);
			} else if (element > maxqueue.peekFirst()) {
				maxqueue.pollFirst();
				maxqueue.add(element);
			} else if (element > maxqueue.peekLast()) {
				maxqueue.pollLast();
				maxqueue.add(element);
			}
		}
		
		for (Integer element : maxqueue) {
			System.out.println(element + " ");
		}
		

	}

}
