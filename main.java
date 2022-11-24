package proofpointStringChecker;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get user input
		Scanner mySc = new Scanner(System.in);
		System.out.println("Enter a sentence to see if it is valid");
		String input = mySc.nextLine();

		// starts program
		start(input);

		// testing - expected output is first valid then all invalid after
		testValid();
		testCapital();
		testQuote();
		testEndchar();
		testPeriod();
		testNums();

		mySc.close();
	}

	// main method to call everything
	static void start(String str) {
		// call methods to check validity, if any are false then sentence is invalid
		boolean capital = capital(str);
		boolean quotes = quotes(str);
		boolean end = end(str);
		boolean period = period(str);
		boolean numbers = numbers(str);

		if (capital && quotes && end && period && numbers) {
			success(str);
		} else {
			failure(str);
		}
	}

	// method to check it starts with a capital letter
	static boolean capital(String str) {
		if (java.lang.Character.isUpperCase(str.charAt(0))) {
			return true;
		} else {
			return false;
		}
	}

	// method to check for even quote marks
	static boolean quotes(String str) {
		int count = 0; // declare counter, loop through string to count quote marks
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '"') {
				count++;
			}
		}

		// check if its even
		if (count % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}

	// method to check ending char
	static boolean end(String str) {
		if (str.charAt(str.length() - 1) == '.' || str.charAt(str.length() - 1) == '?'
				|| str.charAt(str.length() - 1) == '!') {
			return true;
		} else {
			return false;
		}
	}

	// method to check period
	static boolean period(String str) {
		int length = str.length() - 1; // checks every char bar last

		// loop through sentence, if at any point it a period return false, otherwise
		// return true after every char has been checked
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == '.') {
				return false;
			}
		}
		return true;
	}

	// method to check numbers
	static boolean numbers(String str) {
		// loop through 1-12, if string contains the number as a string instead of a
		// word return false
		for (int i = 1; i < 13; i++) {
			if (str.contains(String.valueOf(i))) {
				return false;
			}
		}
		return true;
	}

	// method to print success message
	static void success(String str) {
		System.out.println(str + " is a valid sentence!");
	}

	// method to print failure message
	static void failure(String str) {
		System.out.println(str + " is not a valid sentence!");
	}

	// unit test with a valid String
	static void testValid() {
		start("The quick brown fox said “hello Mr lazy dog”.");
	}

	// unit test with invalid strong because of capital letter
	static void testCapital() {
		start("the quick brown fox said “hello Mr lazy dog”.");
	}

	// unit test with invalid strong because of quote marks
	static void testQuote() {
		start("“The quick brown fox said “hello Mr lazy dog.”");
	}

	// unit test with invalid strong because of end char
	static void testEndchar() {
		start("There is no punctuation in this sentence");
	}

	// unit test with invalid strong because of period
	static void testPeriod() {
		start("The quick brown fox said hello Mr. lazy dog.");
	}

	// unit test with invalid strong because of numbers
	static void testNums() {
		start("Are there 11, 12, or 13 lazy dogs?");
	}

}
