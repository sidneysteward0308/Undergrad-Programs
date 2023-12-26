import java.util.*;

public class PersonalizedHelloWorld {

	public static void main(String[] args) {
		
		//asks for input
		Scanner input = new Scanner(System.in);
		String name;
		
		System.out.print("What is your name? ");
		name = input.nextLine();
		int length = name.length();
		
		//checks to see if input is an actual name and reprompts if not
		while (true) {
			if(length == 0) {
				System.out.print("What is your name? ");
				name = input.nextLine();
				length = name.length();
			} else {
				break;
			}
		}
		
		//returns name
		System.out.println("Hello, " + name + "!");

	}

}
