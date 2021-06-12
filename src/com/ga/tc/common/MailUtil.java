package com.ga.tc.common;

import java.util.Properties;
import java.util.ResourceBundle;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	private static  String host;
	private static  String port;
	public  static  String admin_mail;
	public  static  String admin_password;
	private static  String emailMsgTxt;
    private static  String emailSubjectTxt;
    private static  String emailFromAddress;
    private static  String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static  String[] sendTo;
	
    
    static {
		    ResourceBundle bundle = ResourceBundle.getBundle("com.ga.tc.common.settings");
	        host = bundle.getString("MAIL_SERVER");
	        port = bundle.getString("PORT");
	        emailFromAddress = bundle.getString("FROM_MAIL");
	        admin_mail = bundle.getString("ADMIN_EMAIL");
	        admin_password = bundle.getString("ADMIN_PASSWORD");

	}
	public MailUtil(String to,String subject,String body){
		System.out.println("TO:"+to+"  BODY:"+body);
		sendTo = new String[1];
		sendTo[0] = to;
		emailMsgTxt = body;
		emailSubjectTxt = subject;
	}
	private void sendMessage() throws MessagingException {
	       boolean debug = false;

	       Properties props = new Properties();
	       props.put("mail.smtp.host", host);
	       props.put("mail.smtp.auth", "true");
	       props.put("mail.debug", "false");
	       props.put("mail.smtp.port", port);
	       props.put("mail.smtp.socketFactory.port", port);
	       props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
	       props.put("mail.smtp.socketFactory.fallback", "false");

	       Session session = Session.getDefaultInstance(props,
	               new javax.mail.Authenticator() {
	                   protected PasswordAuthentication getPasswordAuthentication() {
	                       return new PasswordAuthentication(admin_mail, admin_password);
	                   }
	               });

	       session.setDebug(debug);

	       Message msg = new MimeMessage(session);
	       InternetAddress addressFrom = new InternetAddress(emailFromAddress);
	       msg.setFrom(addressFrom);

	       InternetAddress[] addressTo = new InternetAddress[sendTo.length];
	       for (int i = 0; i < sendTo.length; i++) {
	           addressTo[i] = new InternetAddress(sendTo[i]);
	       }
	       msg.setRecipients(Message.RecipientType.TO, addressTo);

	       // Setting the Subject and Content Type
	       msg.setSubject(emailSubjectTxt);
	       msg.setContent(emailMsgTxt, "text/html; charset=utf-8");
	       Transport.send(msg);
	   }
	   public static void sendNewAccountNotificationEmail(final String to,final String subject,final String systempass, final String full_name){
		   new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						String message = Constants.FORGOT_PASSWORD_MAIL_BODY.replace("#full_name#", full_name);
						message = message.replace("#password#", systempass);
						
						new MailUtil(to , subject , message).sendMessage();
					} catch (MessagingException e) {
						e.printStackTrace();
						
					}
					
				}
			}).start();
	   }
	   
	   public static void main(String []args) {
		   sendNewAccountNotificationEmail("eng.sayed.taha@gmail.com ", "TC password","@1234","Sayed Taha" //Full name
				   );
	   }
}

