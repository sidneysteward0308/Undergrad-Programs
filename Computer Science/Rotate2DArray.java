import java.util.*;
public class Lab3part1 {

	public static void main(String[] args) {
		//initializing arrays
		int [] [] nums = { { 1, 2, 3, 4 },
						{ 5, 6, 7, 8 },
						{ 9, 10, 11, 12 }, 
						{ 13, 14, 15, 16 } };
		int [] [] nums2 = { { 1, 1, 1, 1 },
						{ 1, 1, 1, 1 },
						{ 1, 1, 1, 1 },
						{ 1, 1, 1, 1 } };
		
		//rotating the array/swapping the rows and columns
		for (int k = 0; k < nums.length; k++) {
			for (int l = 0; l < nums.length; l++) {
				nums2[k][l] = nums[l][k];
			}
		}
	
		//swapping the columns to flip the array over
		for (int m = 0; m <= nums.length-1; m++) {
			int temp;
			temp = nums2[m][0];
			nums2[m][0] = nums2[m][nums.length-1];
			nums2[m][nums.length-1] = temp;
			
			temp = nums2[m][1];
			nums2[m][1] = nums2[m][nums.length-2];
			nums2[m][nums.length-2] = temp;
				
			
		}
		
		//printing out the array
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				System.out.print(nums2[i][j] + "  ");
			}
			System.out.println();
		}
		

	}

}
