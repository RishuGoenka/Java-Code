package basic;

public class PrePostFix {

	public static void main(String[] args) {
		int i = 100;
		int j = 100;
		int k = i++; // postfix
		int l = ++j; // prefix
		System.out.println("var for postfix : " + i);
		System.out.println("var for prefix : " + j);
		System.out.println("postfix : " + k);
		System.out.println("prefix : " + l);
	}

}