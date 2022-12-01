import java.util.*;
public class Calculator {

	public static void main(String[] args) {
		// a simple calculator
		
		// create an object of scanner class
		Scanner input = new Scanner(System.in);
		
		// ask users to enter operator
		System.out.println("Choose an operator: +, -, *, or /");
		char operator = input.next().charAt(0);
		
		// ask users to enter  numbers
		System.out.println("Enter first number:");
		double num1 = input.nextDouble();
		
		// throws error
		if(!(input.hasNextDouble())) {
		    throw new IllegalArgumentException("Input Invalid"); 
		}
		
		System.out.println("Enter second number:");
		double num2 = input.nextDouble();
		double total;
		
		// throws error
		if(!(input.hasNextDouble())) {
		    throw new IllegalArgumentException("Input Invalid");
		}
		
		switch (operator) {
			// performs addition
			case '+':
				total = num1 + num2;
				System.out.println(num1 + " + " + num2 + " = " + total);
				break;
				
			// performs subtraction
			case '-':
				total = num1 - num2;
				System.out.println(num1 + " - " + num2 + " = " + total);
				break;
			
			// performs multiplication
			case '*':
				total = num1 * num2;
				System.out.println(num1 + " * " + num2 + " = " + total);
				break;
			
			// performs division
			case '/':
				total = num1 / num2;
				System.out.println(num1 + " / " + num2 + " = " + total);
				break;
			
			// default case / error handling
			default:
				System.out.println("Please enter a valid input");
				break;
		}

	}

}