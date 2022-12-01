import java.util.*;

public class Array1 {

	public static void main(String[] args) {
		//making the given array and printint it to show
		int[] nums = {0, 1, 1, 0, 1, 2, 1, 2, 1, 0, 0, 0, 1};
		System.out.println(Arrays.toString(nums));
		
		//initializing variables such as the length of the array,
		//the current place it's on, and a counter
		int length = nums.length;
		int current = 0;
		int j = 0;
		
		//first loop, goes through the array
		for (int i = 0; i < length; i++) {
			current = nums[i];
			j = i - 1;
			
			//second loop, compares integers next to eachother and
			//swaps them accordingly
			while (j >= 0 && current < nums[j]) {
				nums[j + 1] = nums[j];
				j--;
			}
			//updates the current place
			nums[j+1] = current;
		}
		//prints the final array
		System.out.println(Arrays.toString(nums));

	}

}
