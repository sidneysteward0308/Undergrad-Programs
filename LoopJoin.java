import java.util.*;
public class Assignment1Part1 {

	public static void main(String[] args) {
		//creating the required arrays and an arraylist for storage
		int [] array1 = { 1, 5, 6, 6, 9, 9, 9, 11, 11, 21 };
		int [] array2 = { 6, 6, 9, 11, 21, 21, 21 };
		ArrayList<Integer> matches = new ArrayList<Integer>();
		
		//test cases
		//int [] array1 = {};
		//int [] array1 = { 1 };
		
		//checking if the array length is null, exits the program if so.
		if (array1.length == 0 || array2.length == 0) {
			System.out.print("Null input case. No output");
			System.exit(0);
			
		//checking if the array length is only 1, exits the program if so.
		} else if (array1.length == 1) {
			System.out.print("Singular input case. Please enter a full array.");
			System.exit(0);
		}
		
		//goes through the elements of the array and compares them, moving matches
		//to a separate arraylist
		for(int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					matches.add(array1[i]);
				}
			}
		}
		
		//rather than using a bulky de-duplication method like lab 4 I simply
		//convert the arraylist to a hash set here, which doesn't allow
		//duplicates, and print it out. I believe this counts as storage and
		//not a library function, and since there's no space complexity for 
		//this program it should be fine.
		Set<Integer> nodupes = new LinkedHashSet<Integer>(matches);
		System.out.println(nodupes);
	}
}
