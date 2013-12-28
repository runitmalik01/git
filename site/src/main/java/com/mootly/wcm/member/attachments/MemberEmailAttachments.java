
/**
 * This Class is used to read attachments
 * Added on 02/08/2013 by Dhananjay
 * */

package com.mootly.wcm.member.attachments;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.BaseComponent;

public class MemberEmailAttachments extends BaseComponent {

	private static final Logger log = LoggerFactory.getLogger(MemberEmailAttachments.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

	}

	@Override
	public void doAction(HstRequest request, HstResponse response){

		// SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
		// SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
		String host = "webmail.wealth4india.com";
		String user = "documents@wealth4india.com";
		String password = "mootly007";

		// Create properties, get Session
		Properties props = new Properties();

		// If using static Transport.send(),
		// need to specify which host to send it to
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.user",user);
		props.put("mail.smtp.password",password);
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		// To see what is going on behind the scene
		props.put("mail.debug", "true");
		Session session = Session.getDefaultInstance(props,null);
		try {
			if(session!=null){
				Folder folder = null;
				Store store=session.getStore("imaps");
				store.connect(host, user, password);
				System.out.println(store);
				folder =  store.getFolder("inbox");
				log.info("Folder -------------------------------------------"+folder);
				folder.open(Folder.READ_WRITE); // Folder.READ_ONLY
				int messageCount = folder.getMessageCount();
				System.out.println("Total Messages" + messageCount);

				Message message[] = folder.getMessages();

				// here i can put my logic to sort mails on the basic of date or unread mails or whatever
				int i;
				for(i = 0; i<5; i++){
					System.out.println(i + ": " + message[i].getFrom()[0]+ "\t" + message[i].getSubject());

					Object content = message[i].getContent();
					if (content instanceof Multipart) {
						handleMultipart((Multipart)content);
					}
					else {
						handlePart(message[i]);
					}
				}
				folder.close(false);
				store.close();
			}else
				System.out.println("Session Is Nullllllllllllllllllllllllllllllllll");
		}
		catch (MessagingException mex) {
			// Prints all nested (chained) exceptions as well
			mex.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void handleMultipart(Multipart multipart) throws MessagingException, IOException {
		for (int i=0; i<multipart.getCount(); i++){
			handlePart(multipart.getBodyPart(i));
		}
	}


	public static void handlePart(Part part)  throws MessagingException, IOException {
		String dposition = part.getDisposition();
		String cType = part.getContentType();
		if (dposition == null) {
			System.out.println("Null: "  + cType);
			if ((cType.length() >= 10) && (cType.toLowerCase().substring(0, 10).equals("text/plain"))) {
				part.writeTo(System.out);
			}
			else {
				System.out.println("Other body: " + cType);
				part.writeTo(System.out);
			}
		}
		else if (dposition.equalsIgnoreCase(Part.ATTACHMENT)) {
			System.out.println("Attachment: " + part.getFileName() + " : " + cType);
			saveFile(part.getFileName(), part.getInputStream());
		}
		else if (dposition.equalsIgnoreCase(Part.INLINE)) {
			System.out.println("Inline: " + part.getFileName() +  " : " + cType);
			saveFile(part.getFileName(), part.getInputStream());
		}
		else {
			System.out.println("Other: " + dposition);
		}
	}

	public static void saveFile(String filename,InputStream input) throws IOException {
		if (filename == null) {
			filename = File.createTempFile("MailAttacheFile", ".out").getName();
		}
		System.out.println("downloading attachment...");
		File file = new File(filename);
		for (int i=0; file.exists(); i++) {
			file = new File(filename+i);
		}
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		BufferedInputStream bis = new BufferedInputStream(input);
		int fByte;
		while ((fByte = bis.read()) != -1) {
			bos.write(fByte);
		}
		bos.flush();
		bos.close();
		bis.close();
		System.out.println("done attachment...");
	}
}
