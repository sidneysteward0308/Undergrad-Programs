import java.util.*;
public class Array2 {

	public static void main(String[] args) {
		//setting up array and printing it for show
		int nums[] = {1, 9, 8, 9};
		System.out.println(Arrays.toString(nums));
		
		//initializing a string container
		String nums2 = "";
		
		//adding the array to the string to make it one number
		for (int i = 0; i < nums.length; i++) {
			nums2 += nums[i];
		}
		
		//converting the string to an int
		int nums3 = Integer.parseInt(nums2);
		
		//adding one to the int
		nums3++;
		
		//printing
		System.out.println(nums3);
	}

}
