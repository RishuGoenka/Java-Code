package basic;

public class Comparision {

	public static void main(String[] args) {
		int i;
		for (i = 1; i == 1; i++)
			System.out.println("Inside 1st loop : " + i);
		System.out.println("Outside 1st loop : " + i);

		for (i = 1; i < 1; i++)
			System.out.println("Inside 2nd loop : " + i);
		System.out.println("Outside 2nd loop : " + i);

		for (i = 1; i < 2; i++)
			System.out.println("Inside 3rd loop : " + i);
		System.out.println("Outside 3rd loop : " + i);

		for (i = 1; i <= 2; i++)
			System.out.println("Inside 4th loop : " + i);
		System.out.println("Outside 4th loop : " + i);
	}

}