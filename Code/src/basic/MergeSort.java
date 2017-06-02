// Logic yet to be implemented

package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MergeSort {

	public static void main(String[] args) {
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			int arrayLength;
			int arr[];
			System.out.println("Enter the array Length");
			arrayLength = Integer.parseInt(read.readLine());
			arr = new int[arrayLength];
			for (int i = 0; i < arrayLength; i++)
				arr[i] = Integer.parseInt(read.readLine());

			// Logic part
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}