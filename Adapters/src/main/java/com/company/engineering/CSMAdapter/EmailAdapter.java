package com.company.engineering.CSMAdapter;

/**
 * @author:B0096708
 */
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


public class EmailAdapter {

	Logger logger = LoggerFactory.getLogger(EmailAdapter.class);

	@Value("${ipForEmail}")
	private String ip;

	/**. 
	 * @param username user name/Olm id that sends email.
	 * @param password  : password for the above email id
	 * @param to : email has to be sent to this id
	 * @param from : email id that sends email
	 * @param subject :subject of email
	 * @param body :body of email
	 */


	@Value("${emailId}")
	private String from;
	@Value("${emailPassword}")
	private String password;
	@Value("${username}")
	private String username;

	public String sendEmail(String to,String subject,String body) {
		Properties props = System.getProperties();
		props.setProperty("mail.transport.protocol","smtp");

		props.setProperty("mail.smtp.host","10.56.131.8");
		props.put("mail.smtp.auth",true);
		props.put("mail.smtp.port",25);
		props.put("mail.user", username);
		props.put("mail.password", password);

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		session.setDebug(true);
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject(subject);
			message.setText(body);
			message.setSentDate(new java.util.Date());
			//to add different mime tyoe data
			MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
			mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
			mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
			mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
			mc.addMailcap("message/rfc822;; "
					+ "x-java-content- handler=com.sun.mail.handlers.message_rfc822");
			logger.info(subject+"is   subject"+from+"is from "+to+"is to "+body+" is body");
			Transport.send(message);
			logger.debug("Done sent email from:" + from + "*****to***" + to);
			return "Done";
		} catch (MessagingException e) {
			logger.error(e.getStackTrace().toString());
			return e.getMessage();
		}
	}
}
