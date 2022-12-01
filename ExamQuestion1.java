import java.util.Arrays;

public class ExamQuestion1 {
	//creates a main statement to call the quicksort algorithm
	public static void main(String[] args) {
		//makes the array
		int[] array = {50, 11, 33, 21, 40, 50, 40, 40, 21};
		//calls quicksort method
		quickSort(array, 0, array.length-1);
		//prints the sorted array
		System.out.println(Arrays.toString(array));

	}
	//the quicksort method, uses the array, and the first and last index passed
	public static void quickSort(int[] array, int lowIndex, int highIndex) {
		//if the indexes meet, no need to keep sorting, just return
		if(lowIndex >= highIndex) {
			return;
		}
		//making the pivot and pointers, setting the pivot at the last index
		int pivot = array[highIndex];
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		//while the pointers have yet to meet, keep increasing the pointers until
		//a value less than and greater than the pivot is found, and then swap them
		while (leftPointer < rightPointer) {
			while (array[leftPointer] <= pivot  && leftPointer < rightPointer) {
				leftPointer++;
			}
			
			while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			swap(array, leftPointer, rightPointer);
		}
		//the recursive part that keeps calling quicksort for the rest of the array
		swap(array, leftPointer, highIndex);
		quickSort(array, lowIndex, leftPointer - 1);
		quickSort(array, leftPointer + 1, highIndex);
}
	//the swapping done in a separate method for organization sake
	private static void swap(int[] array, int firstIndex, int lastIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[lastIndex];
		array[lastIndex] = temp;
	}

}
