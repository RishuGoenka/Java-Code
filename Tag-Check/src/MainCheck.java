
//Code Not passed the test

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MainCheck {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int totalLine;
		String inputString;
		StringBuilder sb = new StringBuilder();
		TagCheck check = new TagCheck();
		Stack<String> tagStack = TagCheck.getStack();
		Stack<String> printStack = TagCheck.getPrint();

		System.out.println("Enter number of Lines range 1:100");
		totalLine = Integer.parseInt(read.readLine());
		// Line Check
		while (!(totalLine >= 1 && totalLine <= 100)) {
			System.out.println("No valid Input Enter number between Range");
			totalLine = Integer.parseInt(read.readLine());
		}

		// String Input
		for (int i = 0; i < totalLine; i++) {
			System.out.println("Enter String");
			inputString = read.readLine();
			// String Check
			while (inputString.length() > 10000) {
				System.out.println("Enter String Char within Input Range");
				inputString = read.readLine();
			}
			sb.append(inputString);
		}

		sb = check.tagStart(sb);
		String header = tagStack.peek();
		sb = check.tagEnd(header, sb);
		for (int i = 0; i < printStack.size(); i++)
			System.out.println(printStack.get(i));
	}
}