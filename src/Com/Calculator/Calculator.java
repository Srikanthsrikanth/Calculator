package Com.Calculator;

import java.util.Scanner;

/**
 * @author srikanth
 *This program can perform arithmetic operations on expressions that contain 
 *only *, /, + and - operands.
 */
public class Calculator {
	public static void main(String[] args) {

		// Example inputs through command line '1 + 1 - 4 * 4 + 5 / 5 - 3 * 2 - 2 - 3 + 4 + 6' and '- 1 * 3 / 3 + 2 - 6 / 2 - 3' (Entire expression must be in '')
		String[] numbers = args[0].split(" ");
		String[] operands = { "*", "/", "+", "-" };
		int result;
		int sumResult = 0;
		int subResult = 0;

		if (numbers[0].equalsIgnoreCase("*") || numbers[0].equalsIgnoreCase("/"))
			System.out.println("Invalid Expression");
		else {
			if (!numbers[0].equalsIgnoreCase("+") && !numbers[0].equalsIgnoreCase("-")
					&& !numbers[1].equalsIgnoreCase("*") && !numbers[1].equalsIgnoreCase("/"))
				sumResult += (Integer.parseInt(numbers[0]));

			for (int i = 0; i < operands.length; i++) {
				result = 0;
				for (int j = 0; j < numbers.length; j++) {
					if (operands[i].equalsIgnoreCase(numbers[j])) {
						if (operands[i].equalsIgnoreCase("*")) {
							result = Integer.parseInt(numbers[j - 1]) * Integer.parseInt(numbers[j + 1]);
							if (j >= 2) {
								if (numbers[j - 2].equalsIgnoreCase("+")) {
									sumResult += result;
									numbers[j - 2] = "A";
								}
								if (numbers[j - 2].equalsIgnoreCase("-")) {
									subResult += result;
									numbers[j - 2] = "S";
								}
								/*if (numbers[j - 2].equalsIgnoreCase("+"))
									numbers[j - 2] = "A";
								if (numbers[j - 2].equalsIgnoreCase("-"))
									numbers[j - 2] = "S";*/
							} else {
								sumResult += result;
							}
						}

						if (operands[i].equalsIgnoreCase("/")) {
							if (numbers[j - 2].equalsIgnoreCase("*"))
								result = (Integer.parseInt(numbers[j - 3]) * Integer.parseInt(numbers[j - 1]))
										/ Integer.parseInt(numbers[j + 1]);
							else
								result = Integer.parseInt(numbers[j - 1]) / Integer.parseInt(numbers[j + 1]);

							if (numbers[j - 4].equalsIgnoreCase("A")) {
								sumResult -= (Integer.parseInt(numbers[j - 3]) * Integer.parseInt(numbers[j - 1]));
							}

							if (numbers[j - 4].equalsIgnoreCase("S")) {
								subResult -= (Integer.parseInt(numbers[j - 3]) * Integer.parseInt(numbers[j - 1]));
							}
							if (j >= 2) {
								if (numbers[j - 2].equalsIgnoreCase("+") || numbers[j - 4].equalsIgnoreCase("A")) {
									sumResult += result;

								}
								if (numbers[j - 2].equalsIgnoreCase("-") || numbers[j - 4].equalsIgnoreCase("S")) {
									subResult += result;
								}
								if (numbers[j - 2].equalsIgnoreCase("+") || numbers[j - 2].equalsIgnoreCase("-"))
									numbers[j - 2] = "0";
							} else {
								sumResult += result;
							}
						}

						if (operands[i].equalsIgnoreCase("+")) {
							sumResult += Integer.parseInt(numbers[j + 1]);
						}

						if (operands[i].equalsIgnoreCase("-")) {
							subResult += Integer.parseInt(numbers[j + 1]);
						}
					}
				}
			}

			System.out.println("Result : " + (sumResult - subResult));
		}
	}
}