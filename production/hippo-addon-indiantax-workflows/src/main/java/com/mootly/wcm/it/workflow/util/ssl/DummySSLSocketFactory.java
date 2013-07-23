/**
 * $RCSfile$
 * $Revision: 14922 $
 * $Date: 2005-04-07 15:03:18 -0700 (Thu, 07 Apr 2005) $
 *
 * Copyright (C) 1999-2004 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software.
 * Use is subject to license terms.
 */

package com.mootly.wcm.it.workflow.util.ssl;


import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * SSLSocketFactory that accepts any certificate chain and also accepts expired
 * certificates.
 *
 * @author Matt Tucker
 */
public class DummySSLSocketFactory extends SSLSocketFactory {

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
    private SSLSocketFactory factory;

    public DummySSLSocketFactory() {

        try {
            javax.net.ssl.SSLContext sslcontent = javax.net.ssl.SSLContext.getInstance("TLS");
            sslcontent.init(null, // KeyManager not required
                            new javax.net.ssl.TrustManager[] { new DummyTrustManager() },
                            new java.security.SecureRandom());
            factory = sslcontent.getSocketFactory();
        }
        catch (NoSuchAlgorithmException e) {
            log.error("AlgorithmError",e);
        }
        catch (KeyManagementException e) {
            log.error("KeyManagementException",e);
        }
    }

    public static SocketFactory getDefault() {
        return new DummySSLSocketFactory();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
            throws IOException
    {
        return factory.createSocket(socket, s, i, flag);
    }

    public Socket createSocket(InetAddress inaddr, int i, InetAddress inaddr2, int j)
            throws IOException
    {
        return factory.createSocket(inaddr, i, inaddr2, j);
    }

    public Socket createSocket(InetAddress inaddr, int i)
            throws IOException
    {
        return factory.createSocket(inaddr, i);
    }

    public Socket createSocket(String s, int i, InetAddress inaddr, int j)
            throws IOException
    {
        return factory.createSocket(s, i, inaddr, j);
    }

    public Socket createSocket(String s, int i)
            throws IOException
    {
        return factory.createSocket(s, i);
    }

    public String[] getDefaultCipherSuites() {
        return factory.getSupportedCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return factory.getSupportedCipherSuites();
    }

    private static class DummyTrustManager implements javax.net.ssl.X509TrustManager {

        public boolean isClientTrusted(X509Certificate[] cert) {
            return true;
        }

        public boolean isServerTrusted(X509Certificate[] cert) {
            try {
                cert[0].checkValidity();
                return true;
            }
            catch (CertificateExpiredException e) {
                return false;
            }
            catch (CertificateNotYetValidException e) {
                return false;
            }
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates,
                String s) throws CertificateException
        {
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates,
                String s) throws CertificateException
        {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}
