package Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.DocFlavor.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class SendingEmail
{
	static String report_name;
	public SendingEmail(String report_name)
	{
		this.report_name = report_name;
	}
	
	public static void sentEmail()
	{
		  Reporting report = new Reporting();
	  	  System.out.println("=================Sending attachment===============");
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("G:\\Reports\\"+report_name+".html");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Picture of shivani");
		  attachment.setName("Shivani.html");
	
		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		  email.setSmtpPort(587);
		  email.setAuthenticator(new DefaultAuthenticator("25shivanigaur1993@gmail.com", "Umeshivani@1289"));
		  email.setSSLOnConnect(true);
		  
		  DateFormat df = new SimpleDateFormat("dd-MM-yyy");
		  Date date = new Date();
		  String present__date = df.format(date);
		  
		  
		  try
		  {
		  email.addTo("25shivanigaur1993@gmail.com");
		  email.setFrom("25shivanigaur1993@gmail.com", "Shivani Sharma");
		  email.setSubject("Report-"+present__date);
		  email.setMsg("Hello User,\n\nFind the attachment of the report for today's test suite\n\nThanks,\nTeam QA");
	
		  // add the attachment
		  email.attach(attachment);
	
		  // send the email
		  email.send();
		  System.out.println("================Attachment sent successfully=============");
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception caught "+e);
		  }
		  
		/*
		System.out.println("======Sending simple email=========");
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("25shivanigaur1993@gmail.com", "Umeshivani@1289"));
		email.setSSLOnConnect(true);
		try
		{
		email.setFrom("25shivanigaur1993@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("25shivanigaur1993@gmail.com");
		email.send();
		System.out.println("======Email Sent=========");
		}
		
		catch(Exception e)
		{
			System.out.println("caught an exception");
		}
		*/
	}
	
}
