import java.util.*;
public class Lab8 {
//creates the stack
static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) {
		//input
		String input = "3 5 + 1 -";
		
		//test cases
		//String input = "35 3 + 2 -";
		//String input = "* 4 5 - 1 +";
		
		//runs the calculation method
		process(input);
		
		//prints out the stack
		String output = Arrays.toString(stack.toArray());
		System.out.println("Result: " + output);

	}
	//calculation method
	public static void process(String input) {
		//removes the spaces and turns the string into an array
		String[] values = input.split(" ");
		
		//checks if the input starts with an operator
		String firstValue = values[0];
		char firstCharValue = firstValue.charAt(0);
		if (isOperator(firstCharValue) == true) {
			System.out.println("First value must be a number.");
			System.exit(0);
		}
		
		//runs through the array
		for (int i = 0; i < values.length; i++) {
			String nextValue = values[i];
			char character = nextValue.charAt(0);
			//if its a number, add it to the stack
			if (character >= '0' && character <= '9') {
				int value = Integer.parseInt(nextValue);
				stack.push(value);
			//else if its an operator, do the operation
			} else if (isOperator(character) == true) {
				String output = Arrays.toString(stack.toArray());
				operate(character);
			}
		}
	}
	
	//checks if a value is an operator
	private static boolean isOperator(char symbol) {
		if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
			return true;
		} else {
			return false;
		}
	}
	
	//does the operation
	private static void operate(char operator) {
		//makes variables to use in calculation
		int a = 0;
		int b = 0;
		int c = 0;
		
		//gets two numbers from the stack
		if (stack.empty()) {
			System.out.println("Stack is empty.");
			System.exit(operator);
		} else {
			b = stack.peek();
			stack.pop();
		}
		if (stack.empty()) {
			System.out.println("Stack is empty");
			System.exit(operator);
		} else {
			a = stack.peek();
			stack.pop();
		}
		
		//does the operation based on what operator was given
		switch(operator) {
			case '+':
				c = a + b;
				break;
			case '-':
				c = a - b;
				break;
			case '*':
				c = a * b;
				break;
			case '/':
				c = a / b;
				break;
			//catches in case there is no proper operator
			default:
				System.out.println("Operation Invalid.");
		}
		//puts the result back in the stack
		stack.push(c);
	}
}
//time complexity: O(n)
//space complexity: O(n)
