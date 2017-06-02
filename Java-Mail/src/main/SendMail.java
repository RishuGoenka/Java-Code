package main;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;

public class SendMail {

	static Logger log = Logger.getLogger(SendMail.class.getName());

	static final String CCMAIL = "mail@mail.com";
	static final String FROM = "no.reply@mail.com";
	
	public SendMail() {
		super();
	}


	public static boolean mailReport(String sendTO, String filePath) {

		// Recipient's email ID needs to be mentioned.
		String to = sendTO;

		// Sender's email ID needs to be mentioned
		String from = FROM;

		// SMTP Local Host ADDRESS
		String host = "inmail.xyz.net";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.addRecipient(RecipientType.CC, new InternetAddress(CCMAIL));

			// "No attachemant"
			if (1<2) {
				// Set Subject: header field
				message.setSubject("Subject Message");

				// message body if no other thing to attach
				message.setContent("Body text", "text/html");
			} else {
				// Set Subject: header field
				message.setSubject("Subject Message");

				// Create the message part
				BodyPart messageBodyPart = new MimeBodyPart();

				// Now set the actual message
	     			message.setContent("Body text", "text/html");

				// Create a multipart message
				Multipart multipart = new MimeMultipart();

				// Part one is text message
				multipart.addBodyPart(messageBodyPart);

				// Part two is attachment
				messageBodyPart = new MimeBodyPart();
				String filename = filePath;
				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);

				// Send the complete message parts
				message.setContent(multipart);
			}
			// Send message
			Transport.send(message);
			return true;

		} catch (Exception e) {
			log.info("Error while sending mail", e);
			return false;
		}
	}
}