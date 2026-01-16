package utils;

import javax.mail.BodyPart;

import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class EmailSend {

	public static void sendEmail(String report_file) {
		// instance of Properties class
		Properties p = new Properties();
		// configure host server
		p.put("mail.smtp.host", "smtp.gmail.com");
		// configure socket port p.put("mail.smtp.socketFactory.port", "529");
		// configure socket factory
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// configure true authentication p.put("mail.smtp.auth", "true");
		// configure smtp port
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.auth", true);
		p.put("mail.smtp.user", "subhamdummy1122@gmail.com");
		// authentication with Session class
		Session s = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("subhamdummy1122@gmail.com", "ehieskczblqqflvs");
			}
		});
		try {
			// instance of MimeMessage
			Message m = new MimeMessage(s);
			// address of Form
			m.setFrom(new InternetAddress("subhamdummy1122@gmail.com"));
			// address of recipient
			m.setRecipients(Message.RecipientType.TO, InternetAddress.parse("subhampati5673@gmail.com"));
			// email subject text
			m.setSubject("Email Report");
			// configure multi-media email
			BodyPart b = new MimeBodyPart();
			// email body text
			b.setText("Overall Selenium Test Report");
			// configure multi-media email for another text
			BodyPart b1 = new MimeBodyPart();
			// name of file to be attached to email
			String filepath = "./reports/" + report_file;
			// pass filename
			DataSource sr = new FileDataSource(filepath);
			// set the handler
			b1.setDataHandler(new DataHandler(sr));
			// configure file
			b1.setFileName(report_file);
			// instance of class MimeMultipart
			Multipart mm = new MimeMultipart();
			// adding body texts
			mm.addBodyPart(b1);
			mm.addBodyPart(b);
			// add email content
			m.setContent(mm);
			// email sending
			Transport.send(m);
			System.out.println("MAIL TRIGGERED");
		} catch (MessagingException ex) {
			throw new RuntimeException(ex);
		}
	}
}
