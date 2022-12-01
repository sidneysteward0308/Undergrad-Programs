import java.util.Scanner;

public class GuessMyNumber {

	public static void main(String[] args) {
		
		//gets number from user
		Scanner input = new Scanner(System.in);
		int n;
		
		System.out.print("Enter n: ");
		
		//checks if number is positive and > 0
		while (true) {
			n = input.nextInt();
			if (n <= 0) {
				System.out.print("Enter a positive integer for n: ");
			} else {
				break;
			}
		}
		
		//initializing the min, max, and middle
		int max = n;
		int min = 0;
		int middle = ((int) Math.ceil(max/2));
		char response;
		
		//starts guessing the number by binary search method
		System.out.println("Welcome to Guess My Number!");
		System.out.println("Please think of a number between 0 and " + (max-1) + ".");
		
		System.out.println("Is your number: " + middle + "?");
		System.out.println("Please enter C for correct, H for too high, or L for too low.");
		System.out.print("Enter your response (H/L/C) : ");
		response = input.next().charAt(0);
		
		//makes sure the user is giving correct inputs and acts accordingly
		while (true) {
			
			if(response == 'C') {
				System.out.println("Thank you for playing Guess My Number!");
				break;
				
			} else if(response == 'H') {
				max = middle;
				middle = ((int) Math.ceil(middle/2));
				System.out.println("Is your number: " + middle + "?");
				System.out.println("Please enter C for correct, H for too high, or L for too low.");
				System.out.print("Enter your response (H/L/C) : ");
				response = input.next().charAt(0);
				
			} else if (response == 'L') {
				min = middle;
				middle = ((int) Math.ceil((max + middle)/2));
				System.out.println("Is your number: " + middle + "?");
				System.out.println("Please enter C for correct, H for too high, or L for too low.");
				System.out.print("Enter your response (H/L/C) : ");
				response = input.next().charAt(0);
				
			} else {
				System.out.print("Enter your response (H/L/C) : ");
				response = input.next().charAt(0);
			}
		}
	}

}
