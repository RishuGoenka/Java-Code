import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			int arr[];
			int arrLength;
			System.out.println("Enter array length");
			arrLength = Integer.parseInt(read.readLine());
			arr = new int[arrLength];
			for (int i = 0; i < arrLength; i++)
				arr[i] = Integer.parseInt(read.readLine());
			for (int i = 0; i < arrLength; i++)
				for (int j = arrLength - 1; j > i; j--)
					if (arr[j] < arr[j - 1]) {
						arr[j] = arr[j] + arr[j - 1];
						arr[j - 1] = arr[j] - arr[j - 1];
						arr[j] = arr[j] - arr[j - 1];
					}
			for (int i : arr) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
