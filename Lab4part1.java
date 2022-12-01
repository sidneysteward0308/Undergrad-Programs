
public class Lab4part1 {

	public static void main(String[] args) {
		//creating the required array
		int [] nums = { 50, 11, 33, 21, 40, 50, 40, 40, 21 };
		
		//test cases
		//int [] nums = {};
		//int [] nums = { 1 };
		
		//checking if the array length is null, exits the program if so.
		if (nums.length == 0) {
			System.out.print("Null input case. No output");
			System.exit(0);
		//checking if the array length is only 1, exits the program if so.
		} else if (nums.length == 1) {
			System.out.print("Singular input case. Already sorted.");
			System.exit(0);
		}
		
		//creates a placeholder integer to use in the next for loop
		int placeholder;
		
		//bubble sorts the array
		//goes through the array and checks if an int is greater than the next int, and swaps them if so.
		//the placeholder is used to hold an int while swapping
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					placeholder = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = placeholder;
				}
			}
		}
		
		//sets the placeholder back to zero to reuse in the next for loop
		placeholder = 0;
		
		//de-duplicates the array
		//goes through the array and compares integers to see if they are different, adds to the "uniqueness counter" (aka placeholder)
		//if so. pushes those duplicate ints to the end of the array.
		for (int k = 0; k < nums.length - 1; k++) {
			if (nums[k] != nums[k + 1]) {
				nums[placeholder++] = nums[k];
			}
		}
		nums[placeholder++] = nums[nums.length - 1];
		
		//prints out the final array. it gets rid of the duplicate numbers by removing the end of the array where they have been
		//pushed to, utilizing the counter in placeholder to do so. prints out the rest.
		for (int i = 0; i < nums.length - (placeholder-1); i++) {
			System.out.print(nums[i] + "  ");
		}

	}

}
