
public class ExamQuestion2 {

	public static void main(String[] args) {
		//making the array and setting the number we are searching for to 21
		int[] array = {11, 21, 33, 40, 50};
		int number = 21;	
		
		//makes some variables to use to count the indexes we go through
		int i = 0;
		int j = 0;
		
		//the binary search. while i is less than the length of the array it checks
		//the numbers to see if they are equal, less than, or greater than the number
		//we are searching for, decreasing the problem size if so or printing out the
		//target value
		while (i < array.length) {
			if (array[i] < number) {
				i++;
			} else if (number < array[i]) {
				j++;
			} else {
				System.out.println(array[i]);
				System.exit(1);
			}
		}
		
	}

}
