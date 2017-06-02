package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertionSort {

	public static void main(String[] args) {
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			int arrayLength;
			System.out.println("Enter the Array Length");
			arrayLength = Integer.parseInt(read.readLine());
			int arr[] = new int[arrayLength];
			for (int i = 0; i < arrayLength; i++)
				arr[i] = Integer.parseInt(read.readLine());
			int key, i;
			for (int j = 1; j < arrayLength; j++) {
				key = arr[j];
				i = j - 1;
				while (i >= 0 && arr[i] > key) {
					arr[i + 1] = arr[i];
					i--;
				}
				arr[i + 1] = key;
			}
			for (int a : arr) {
				System.out.println(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}