package com.bank.controller;

//Java program to send email 

/**
* SOURCE: https://howtodoinjava.com/for-fun-only/how-to-send-email-in-java-using-gmail-smtp-server/
**/

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bank.entities.Customer;
 
public class SendMail
{
    Session mailSession;
 
    public SendMail(Customer c, String transaction_type, Integer valueOf) throws AddressException, MessagingException {
    	setMailServerProperties();
    	String sub="Notification for "+transaction_type;
    	String Body="";

    	if(transaction_type=="Money Deposit") {
    		Body="Dear "+c.getName()+",\n\nThis is to Notify you that Rs."+valueOf+" have been deposited in your Bank Account, Customer ID : "+c.getCustomerID()+". \nIf you feel this is a false information, kindly inform us at the earliest. \n\nRegards,\n\n Swift Bank";
    	}
    	if(transaction_type=="OTP") {
    		Body="Dear "+c.getName()+",\n\nThis is the OTP for a transfer to your Account  :  "+valueOf+" \nKindly let the sender know the OTP for further Transation of Money. \nIf you feel this is a false information, kindly inform us at the earliest. \n\nRegards,\n\n Swift Bank";
    	}
    	sendEmail(c,sub,Body);
	}

//	public static void main(String args[]) throws AddressException, MessagingException
//    {
//    	SendMail javaEmail = new SendMail();
//        javaEmail.setMailServerProperties();
//        javaEmail.draftEmailMessage("ravdeepsidhu1971@gmail.com"," Test email subject"," This is an email sent by eclipse.");
//     javaEmail.sendEmail();
    
 
    private void setMailServerProperties()
    {
        Properties emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", "587");  // we use 587 because STARTTLS is enabled on port 587 of the gmail server (smtp secure )
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        mailSession = Session.getDefaultInstance(emailProperties, null);
    }
 
    private MimeMessage draftEmailMessage(String reciever,String Subject,String Body) throws AddressException, MessagingException
    {
//        String[] toEmails = { "reciever@gmail.com" };
    	String toEmails = reciever;
        String emailSubject = Subject;
        String emailBody = Body;
        MimeMessage emailMessage = new MimeMessage(mailSession); //Set the mail recipients
//        for (int i = 0; i < toEmails.length; i++)
//        {
//            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
//        }
        emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails));
        emailMessage.setSubject(emailSubject);//If sending HTML mail
        emailMessage.setContent(emailBody, "text/html");//          If sending only text mail
        emailMessage.setText(emailBody);// for a text email
        return emailMessage;
    }
 
    private void sendEmail(Customer c,String Subject,String Body) throws AddressException, MessagingException
    {
        /**
         * Sender's credentials
         * */
        String fromUser = "sender@gmail.com";//turn off less secure apps access
        String fromUserEmailPassword = "**";//enter password
 
        String emailHost = "smtp.gmail.com";
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserEmailPassword);//          Draft the message
        
        MimeMessage emailMessage = draftEmailMessage(c.getE_mail(),Subject,Body);//         Send the mail

        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }
}