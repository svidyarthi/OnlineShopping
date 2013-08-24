package webServices;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.UUID;

public class PasswordResetMailService {

	public PasswordResetMailService(){
		
	}
	
	 public String[] getPropValues() throws IOException {
		 
	        Properties prop = new Properties();
	        String propFileName = "config.properties";
	 
	        URL url = getClass().getResource(propFileName);
	        InputStream inputStream = url.openStream();
	        prop.load(inputStream);
	        if (inputStream == null) {
	            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
	        }
	        String host = prop.getProperty("mailhost");
	        String email = prop.getProperty("email");
	        String password = prop.getProperty("password");
	        String serverHostUrl = prop.getProperty("hosturl");
	        String[] arr = new String[4];
	        arr[0] = email;
	        arr[1] = password;
	        arr[2] = host;
	        arr[3] = serverHostUrl;
	        return arr;
	    }
	
	
	public String sendMail(String email) throws IOException {
	
    String temp="";
    
    String[] gmailProps = getPropValues();
    String from = gmailProps[0];
    String pass = gmailProps[1];
    String host = gmailProps[2];
    String serverHostUrl = gmailProps[3];
    Properties props = System.getProperties();
    
    props.put("mail.smtp.starttls.enable", "true"); 
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");

    String[] to = {email}; 

    Session session = Session.getDefaultInstance(props, null);
    MimeMessage message = new MimeMessage(session);
    try {
		message.setFrom(new InternetAddress(from));
	} catch (AddressException e) {
		e.printStackTrace();
	} catch (MessagingException e) {
		e.printStackTrace();
	}
    try {
    InternetAddress[] toAddress = new InternetAddress[to.length];

    // To get the array of addresses
    for( int i=0; i < to.length; i++ ) { 
        toAddress[i] = new InternetAddress(to[i]);
    }
    temp = UUID.randomUUID().toString().substring(0, 6);
    
    for( int i=0; i < toAddress.length; i++) { 
			message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			message.setSubject("Reset Password Link");
			message.setText("Thanks for using Kukus Corner. Your new temporary password is "+temp+" \n Login again with this password on "+serverHostUrl+"/LoginForm.html");		
		} 
   
    	 Transport transport = session.getTransport("smtp");
		 transport.connect(host, from, pass);
		 transport.sendMessage(message, message.getAllRecipients());
		 transport.close();
		 
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   return temp;
	}	
}	

