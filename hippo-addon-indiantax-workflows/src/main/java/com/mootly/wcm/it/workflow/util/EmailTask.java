/**
 * $RCSfile$
 * $Revision: 15143 $
 * $Date: 2005-04-14 09:35:52 -0700 (Thu, 14 Apr 2005) $
 *
 * Copyright (C) 1999-2004 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */

package com.mootly.wcm.it.workflow.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * A task to send email.<p>
 *
 * This class will hold a list of messages and will send them all at once when
 * the <code>run</code> method is called.<p>
 *
 * This class has a few factory methods you can use to return message objects
 * or to add messages into a queue to be sent. Using these methods, you can
 * send emails in the following few of ways:<p>
 * <pre>
 *   // Send a text/plain email
 *   TaskEngine taskEngine = new TaskEngine();
 *   EmailTask emailTask = new EmailTask();
 *   emailTask.addMessage(
 *     "Joe Bloe", "jbloe@place.org",
 *     "Jane Doe", "jane@doe.com",
 *     "Hello...",
 *     "This is the body of the email...",
 *     null
 *   );
 *   taskEngine.addTask(emailTask, Thread.NORM_PRIORITY);
 * </pre>
 * or
 * <pre>
 *   // Send a text/html email
 *   TaskEngine taskEngine = new TaskEngine();
 *   EmailTask emailTask = new EmailTask();
 *   emailTask.addMessage(
 *     "Joe Bloe", "jbloe@place.org",
 *     "Jane Doe", "jane@doe.com",
 *     "Hello...",
 *     null,
 *     "&lt;html&gt;&lt;body&gt;This is the body of the email...&lt;/body&gt;&lt;/html&gt;"
 *   );
 *   taskEngine.addTask(emailTask, Thread.NORM_PRIORITY);
 * </pre>
 * or
 * <pre>
 *   // Send an email with both text/plain and text/html parts
 *   TaskEngine taskEngine = new TaskEngine();
 *   EmailTask emailTask = new EmailTask();
 *   emailTask.addMessage(
 *     "Joe Bloe", "jbloe@place.org",
 *     "Jane Doe", "jane@doe.com",
 *     "Hello...",
 *     "This is the body of the email...",
 *     "&lt;html&gt;&lt;body&gt;This is the body of the email...&lt;/body&gt;&lt;/html&gt;"
 *   );
 *   taskEngine.addTask(emailTask, Thread.NORM_PRIORITY);
 * </pre>
 * or
 * <pre>
 *   TaskEngine taskEngine = new TaskEngine();
 *   EmailTask emailTask = new EmailTask();
 *   Message message = emailTask.createMessage();
 *   // call setters on the message object
 *   // .
 *   // .
 *   // .
 *   taskEngine.addTask(emailTask, Thread.NORM_PRIORITY);
 * </pre><p>
 *
 * This class is configured with a set of KNOVA properties:<ul>
 *      <li><tt>mail.smtp.host</tt> -- the host name of your mail server, i.e.
 *          mail.yourhost.com
 *      <li><tt>mail.smtp.port</tt> -- an optional property to change the smtp
 *          port used from the default of 25.
 *      <li><tt>mail.smtp.username</tt> -- an optional property to change the
 *          username used to connect to the smtp server. Default is no username.
 *      <li><tt>mail.smtp.password</tt> -- an optional property to change the
 *          password used to connect to the smtp server. Default is no password.
 *      <li><tt>mail.smtp.ssl</tt> -- an optional property to set whether to use
 *          SSL to connect to the smtp server or not. Default is false.
 * </ul>
 *
 * @see TaskEngine
 */
public class EmailTask implements Runnable {

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    // Class that will send the messages for us.
    private SmtpProxy smtpProxy;

//    private String host     = SymbolGlobals.getSymbolProperty("mail.smtp.host");
//    private String port     = SymbolGlobals.getSymbolProperty("mail.smtp.port");
//    private String username = SymbolGlobals.getSymbolProperty("mail.smtp.username");
//    private String password = SymbolGlobals.getSymbolProperty("mail.smtp.password");
//    private String ssl      = SymbolGlobals.getSymbolProperty("mail.smtp.ssl");
//    private String debug    = SymbolGlobals.getSymbolProperty("mail.debug");
    
    private String host     = "smtp.gmail.com";
    private String port     = "587";
    private String username = "info@mootly.com";
    private String password = "mootly007";
    private String ssl      = "false";
    private String debug    = "true";

    // The total number of simultaneous connections allowed to the SMTP server
    private static final long MAX_SMTP_CONNECTIONS = 5;

    private static final Semaphore smtpSemaphore = new Semaphore(MAX_SMTP_CONNECTIONS);

    // List of messages
    private List messages = null;

    /**
     * Creates a new EmailTask.
     */
    public EmailTask() {
        messages  = Collections.synchronizedList(new ArrayList());
        smtpProxy = new SmtpProxy();
        smtpProxy.setHost(host);
        if (port != null) {
            try {
                smtpProxy.setPort(Integer.parseInt(port));
            } catch (Exception ignored) {}
        }
        smtpProxy.setUsername(username);
        smtpProxy.setPassword(password);
        smtpProxy.setSSLEnabled(Boolean.valueOf(ssl).booleanValue());
        smtpProxy.setDebugEnabled(Boolean.valueOf(debug).booleanValue());
    }

    /**
     * Runs the task, which sends all email messages that have been queued.
     */
    public void run() {
        // get one of the available smtp connections
        try {
            smtpSemaphore.acquire();
        }
        catch (InterruptedException e) {
            log.error("Error",e);
        }

        try {
            smtpProxy.send(messages);
            messages.clear();
        }
        catch (MessagingException e) {
            // notify listener
            log.error("Error",e);
        }

        smtpSemaphore.release();
    }

    /**
     * Factory method to add a JavaMail message object to the internal list
     * of messages.
     *
     * @param message a message to send.
     */
    public void addMessage(Message message) {
        if (message != null) {
            messages.add(message);
        }
        else {
            log.error("Cannot add null email message to queue.");
        }
    }

    /**
     * Factory method to add a message by specifying its fields.<p>
     *
     * To use more advanced message features, use the
     * <code>addMessage(Message message)</code> method.<p>
     *
     * Both a plain text and html body can be specified. If one of the values is null,
     * only the other body type is sent. If both body values are set, a multi-part
     * message will be sent. If parts of the message are invalid (ie, the toEmail is null)
     * the message won't be sent.
     *
     * @param toName the name of the recipient of this email.
     * @param toEmail the email address of the recipient of this email.
     * @param fromName the name of the sender of this email.
     * @param fromEmail the email address of the sender of this email.
     * @param subject the subject of the email.
     * @param textBody plain text body of the email, which can be <tt>null</tt> if the
     *      html body is not null.
     * @param htmlBody html body of the email, which can be <tt>null</tt> if the text body
     *      is not null.
     */
    public void addMessage(String toName, String toEmail, String fromName,
            String fromEmail, String subject, String textBody, String htmlBody)
    {
        // Check for errors in the given fields:
        if (toEmail==null || fromEmail==null || subject==null ||
                (textBody==null && htmlBody == null))
        {
            log.error("Error sending email in EmailTask.java: Invalid fields: "
                    + ((toEmail == null) ? "toEmail " : "")
                    + ((fromEmail == null) ? "fromEmail " : "")
                    + ((subject == null) ? "subject " : "")
                    + ((textBody == null && htmlBody == null) ? "textBody or htmlBody " : "")
            );
        }
        else {
            try {
                // Use the global Jive encoding for the emails.
                String encoding = MimeUtility.mimeCharset(SymbolGlobals.getCharacterEncoding());
                MimeMessage message = createMessage();
                Address to   = null;
                Address from = null;

                if (toName != null) {
                    to = new InternetAddress(toEmail, toName, encoding);
                }
                else {
                    to = new InternetAddress(toEmail, "", encoding);
                }

                if (fromName != null) {
                    from = new InternetAddress(fromEmail, fromName, encoding);
                }
                else {
                    from = new InternetAddress(fromEmail, "", encoding);
                }

                // set the date on exported message to be the current date
                SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", java.util.Locale.US);
                format.setTimeZone(SymbolGlobals.getTimeZone());
                message.setHeader("Date", format.format(new Date()));
                message.setHeader("Content-Transfer-Encoding", "8bit");
                message.setRecipient(Message.RecipientType.TO, to);
                message.setFrom(from);
                message.setSubject(StringUtils.replace(subject, "\n", ""), encoding);
                // Create HTML, plain-text, or combination messagel
                if (textBody != null && htmlBody != null) {
                    MimeMultipart content = new MimeMultipart("alternative");
                    // Plain-text
                    MimeBodyPart text = new MimeBodyPart();
                    text.setText(textBody, encoding);
                    text.setDisposition(Part.INLINE);
                    content.addBodyPart(text);
                    // HTML
                    MimeBodyPart html = new MimeBodyPart();
                    html.setContent(htmlBody, "text/html");
                    html.setDisposition(Part.INLINE);
                    content.addBodyPart(html);
                    // Add multipart to message.
                    message.setContent(content);
                    message.setDisposition(Part.INLINE);
                    addMessage(message);
                }
                else if (textBody != null) {
                    MimeBodyPart bPart = new MimeBodyPart();
                    bPart.setText(textBody, encoding);
                    bPart.setDisposition(Part.INLINE);
                    MimeMultipart mPart = new MimeMultipart();
                    mPart.addBodyPart(bPart);
                    message.setContent(mPart);
                    message.setDisposition(Part.INLINE);
                    // Add the message to the send list
                    addMessage(message);
                }
                else if (htmlBody != null) {
                    MimeBodyPart bPart = new MimeBodyPart();
                    bPart.setContent(htmlBody, "text/html");
                    bPart.setDisposition(Part.INLINE);
                    MimeMultipart mPart = new MimeMultipart();
                    mPart.addBodyPart(bPart);
                    message.setContent(mPart);
                    message.setDisposition(Part.INLINE);
                    // Add the message to the send list
                    addMessage(message);
                }
            }
            catch (Exception e) {
                log.error("Error",e);
            }
        }
    }

    /**
     * Factory method to return a blank JavaMail message. You should use the
     * object returned and set desired message properties. When done, pass the
     * object to the addMessage(Message) method.
     *
     * @return A new JavaMail message.
     */
    public MimeMessage createMessage() {
        return smtpProxy.createMessage();
    }
    
    public static void main(String[] args) {
		EmailTask emailTask = new EmailTask();
		emailTask.addMessage("Amit Patkar", "amitpatkar@gmail.com", "amit@mootly.com", "amit@mootly.com", "test", "test", "test");
		emailTask.run();
	}
}