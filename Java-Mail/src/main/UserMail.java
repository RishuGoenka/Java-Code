package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;
import org.apache.log4j.Logger;

public class UserMail {

	static Logger log = Logger.getLogger(UserMail.class.getName());

	static final String senderName1 = "mail@mail.com";

	public static void main(String[] args) {
		try {
			SendMail mail = new SendMail();
			String FilePath = "path";
			String deliverable = "deliverable";

			// Destination Mail ID
			UserMail usermail = new UserMail();
			String senderName = args[0];
			String mailto = "mail@mail.com";

			// Mail Id Check using Reflection
			Field[] fields = UserMail.class.getDeclaredFields();
			for (Field field : fields) {
				if (field.getName().equals(senderName)) {
					Object object = field.get(deliverable);
					mailto = object.toString();
				}
			}

			String logFilePath = args[1];
			mail.mailReport(mailto, FilePath);

		} catch (Exception e) {
			log.info("Main method Error : ", e);
		}
	}
}