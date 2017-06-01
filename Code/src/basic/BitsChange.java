// Problem Satament :
// Write a method that will return the number of bits that need to be changed in order to convert an integer, X, into another integer, 
// Y and vice versa. The method should accept two different integers as input.
// Input format: The first line of input contains a single integer, X (the source integer).
//                 The second line of your input contains a single integer, Y (the target integer). 
// Output format: The output will be the no of bits that need to change to convert X to Y.
// For example, if your method is passed the integers 12 and 16 then your method should return a 3.
// Sample Input:
// 12
// 16
//Sample Output: 3

package basic;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BitsChange {

	public static void main(String[] args) {
		int x = 0, y = 0;
		Scanner scn = new Scanner(System.in);
		try {
			System.out.println("Enter Number X :");
			x = scn.nextInt(); // First No. Input is taken
			System.out.println("Enter Number Y :");
			y = scn.nextInt(); // Second No. Input is taken
		} catch (InputMismatchException | IllegalArgumentException ex) {
			System.out.println("Invalid Input Enter Integer");
		}
		scn.close();
		System.out.println("Bits Change : " + change(x, y)); // Method Call
	}

	// Method Returning Number of Bits Need to Change
	// It takes two Argument
	public static int change(int x, int y) {
		if (Pattern.matches("\\d+", Integer.toString(x)) && Pattern.matches("\\d+", Integer.toString(y)))
			return Integer.bitCount(x ^ y); // The XOR Operation
		else
			return 0;
	}

}
