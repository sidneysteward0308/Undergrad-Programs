import java.util.*;
public class Assignment1Part2 {

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
		
		//goes through the elements of the array and compares them using
		//binary search method, where it treats the two arrays as two
		//halves of a binary search. a while loop is used rather than a for
		//loop for the sake of being easier to visualize the comparison
		//of elements as it moves through.
		int i = 0;
		int j = 0;
		while (i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				i++;
			}else if (array2[j] < array1[i]) {
				j++;
			} else {
				matches.add(array2[j++]);
				i++;
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

//Answer to part 3:
//Since the arrays are already sorted it would be very easy to just merge both
//arrays together and get rid of all the values that do not show up more than
//once, and then clearing all the duplicate values. In this case getting rid of
//the singular values would remove 1 and 5, which are the values that do not match,
//and then remove all the duplicate values.
