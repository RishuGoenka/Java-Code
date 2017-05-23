import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSize {

	public static void main(String[] args) {
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		System.out.println("Screen Width : " + scr.getWidth());
		System.out.println("Screen Height : " + scr.getHeight());
	}

}
