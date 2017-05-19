import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SampleMail {

	public static void main(String[] args) {
		try {
			// Recipient's email ID needs to be mentioned.
			String to = sendTO;

			// Sender's email ID needs to be mentioned
			String from = FROM;

			// SMTP Local Host ADDRESS
			String host = "inmail.zycus.net";

			// Get system properties
			Properties properties = System.getProperties();

			// Setup mail server
			properties.setProperty("mail.smtp.host", host);

			// Get the default Session object.
			Session session = Session.getDefaultInstance(properties);

			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.addRecipient(Message.RecipientType.CC, new InternetAddress(to));

			message.setSubject("This is the Subject Line!");
			message.setText("This is actual message");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
