package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringReverse {

	public static void main(String[] args) {
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder string = new StringBuilder();
			System.out.println(string.append(read.readLine().toString()).reverse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}