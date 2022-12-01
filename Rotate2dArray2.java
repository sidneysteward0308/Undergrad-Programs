import java.util.*;
public class Lab3part2 {

	public static void main(String[] args) {
		//initializing the array
		int [] [] nums = { { 1, 2, 3, 4 },
						{ 5, 6, 7, 8 },
						{ 9, 10, 11, 12 },
						{ 13, 14, 15, 16} };
		//making a temporary variable for later use
		int temp;
		
		//rotating the elements around/changing rows and
		//columns, this time using a temp variable rather
		//than a placeholder array
		for (int k = 0; k < nums.length; k++) {
			for (int l = 0; l < k; l++) {
				temp = nums[k][l];
				nums[k][l] = nums[l][k];
				nums[l][k] = temp;
				
			}
		}
	
		//swapping the columns to flip the array over
		for (int m = 0; m <= nums.length-1; m++) {
			temp = nums[m][0];
			nums[m][0] = nums[m][nums.length-1];
			nums[m][nums.length-1] = temp;
			
			temp = nums[m][1];
			nums[m][1] = nums[m][nums.length-2];
			nums[m][nums.length-2] = temp;
				
			
		}
		
		//printing out the array
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				System.out.print(nums[i][j] + "  ");
			}
			System.out.println();
		}
		

	}

}
