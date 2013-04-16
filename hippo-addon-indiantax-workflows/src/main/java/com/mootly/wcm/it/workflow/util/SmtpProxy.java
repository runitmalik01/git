/**
 * $RCSfile$
 * $Revision: 16405 $
 * $Date: 2005-06-13 10:08:54 -0700 (Mon, 13 Jun 2005) $
 *
 * Copyright (C) 1999-2003 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */

package com.mootly.wcm.it.workflow.util;

import java.security.Security;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * A simple class that handles the work of connecting to an SMTP server to send an email message.
 */
public class SmtpProxy {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
    private Session session = null;
    private String host     = null;
    private int    port     = 25;
    private String username = null;
    private String password = null;

    private boolean SSLEnabled = true;
    private boolean debugEnabled = true;
    /**
     * Specify the factory that javamail should use for SSL connections
     * to the server.
     */
    private static final String SSL_FACTORY =
        "com.symbol.docsubscription.util.ssl.DummySSLSocketFactory";

    /**
     * Create a new instance.
     */
    public SmtpProxy() {}


    /**
     * Sets the SMTP host (eg mail.example.com). The host is null by
     * default, but must be set before gateway exports can execute.
     *
     * @param host The SMTP host.
     */
    public void setHost(String host) {
        this.host = host;
        // JavaMail Session no longer valid so set to null; it will get
        // recreated as needed.
        session = null;
    }

    /**
     * Sets the port number that will be used when connecting to the SMTP
     * server. The default is 25, the standard SMTP port number.
     *
     * @param port The SMTP port number.
     */
    public void setPort(int port) {
        this.port = port;
        // JavaMail Session no longer valid so set to null; it will get
        // recreated as needed.
        session = null;
    }

    /**
     * Sets the username that will be used when connecting to the SMTP
     * server. The default is null, or no username.
     *
     * @param username The SMTP username.
     */
    public void setUsername(String username) {
        this.username = username;
        // JavaMail Session no longer valid so set to null; it will get
        // recreated as needed.
        session = null;
    }

    /**
     * Sets the username that will be used when connecting to the SMTP
     * server. The default is null, or no username.
     *
     * @param password The SMTP password.
     */
    public void setPassword(String password) {
        this.password = password;
        // JavaMail Session no longer valid so set to null; it will get
        // recreated as needed.
        session = null;
    }

    /**
     * Toggles SMTP transport layer debugging on or off. Debug information is
     * written to <tt>System.out</tt> by the underlying JavaMail provider.
     *
     * @param debugEnabled True if SMTP debugging should be enabled.
     */
    public void setDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
        // JavaMail SMTP Session no longer valid so set to null; it will get
        // recreated as needed.
        session = null;
    }

    /**
     * Sets whether this gateway is configured for SSL connections
     * to the SMTP server or not.
     *
     * @param SSLEnabled True if ssl should be enabled, false otherwise.
     */
    public void setSSLEnabled(boolean SSLEnabled) {
        this.SSLEnabled = SSLEnabled;

        // JavaMail Session no longer valid so set to null; it will get
        // recreated as needed.
        session = null;
    }

    /**
     * Create a new MimeMessage.
     *
     * @return MimeMessage A new message object.
     */
    public MimeMessage createMessage() {
        retrieveSession();
        return new MimeMessage(session);
    }

    /**
     * Send messages.
     *
     * @param messages The mail objects to send.
     * @throws javax.mail.MessagingException If a connection was unable to be established.
     */
    public void send(List messages) throws MessagingException {
        // If there are no messages, do nothing.
        if (messages.size() == 0) {
            return;
        }
        retrieveSession();
        Transport transport = null;

        try {
            //transport = connectToSmtpServer();
            MimeMessage message;

            Iterator iter = messages.iterator();
            while (iter.hasNext()) {
                message = (MimeMessage)iter.next();
                // Attempt to send message, but catch exceptions caused by invalid
                // addresses so that other messages can continue to be sent.
                try {
                    Transport.send(message,
                        message.getAllRecipients());
                }
                catch (AddressException ae) {
                    log.error("ERROR",ae);
                }
                catch (SendFailedException sfe) {
                    log.error("ERROR",sfe);
                }
            }
        }
        finally {
            if (transport != null) {
                try {
                    disconnectFromSmtpServer(transport);
                }
                catch (MessagingException e) { /* ignore */ }
            }
            session = null;
        }
    }

    private void retrieveSession() {
        // enabled SSL
        if (SSLEnabled) {
            Security.setProperty("ssl.SocketFactory.provider", SSL_FACTORY);
        }

        // Create the mail session if necessary.
        if (session == null) {
            Properties mailProps = new Properties();
            mailProps.setProperty("mail.smtp.host", host);
            mailProps.setProperty("mail.smtp.port",String.valueOf(port));
            mailProps.setProperty("mail.debug", String.valueOf(debugEnabled));
            mailProps.put("mail.smtp.starttls.enable", "true");
            mailProps.put("mail.smtp.auth", "true");

            // Methology from an article on www.javaworld.com (Java Tip 115)
            // We will attempt to failback to an insecure connection
            // if the secure one cannot be made
            if (SSLEnabled) {
                mailProps.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
                mailProps.setProperty("mail.smtp.socketFactory.fallback", "true");
            }
            // If a username is defined, use SMTP authentication.
            if (username != null) {
                mailProps.put("mail.smtp.auth", "true");
            }
            Authenticator auth = new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };
            session = Session.getInstance(mailProps, auth);
        }
    }

    private Transport connectToSmtpServer() throws MessagingException {
        URLName url = new URLName("smtp", host, port, "", username, password);
        Transport trans = new com.sun.mail.smtp.SMTPTransport(session, url);
        trans.connect(host, port, username, password);
        return trans;
    }

    private void disconnectFromSmtpServer(Transport transport) throws MessagingException {
        transport.close();
    }
}
