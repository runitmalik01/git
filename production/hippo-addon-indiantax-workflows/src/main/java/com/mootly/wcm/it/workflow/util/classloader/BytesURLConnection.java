package com.mootly.wcm.it.workflow.util.classloader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Hani Suleiman (hani@formicary.net)
 *         Date: Oct 20, 2003
 *         Time: 12:46:01 AM
 */
public class BytesURLConnection extends URLConnection {
    protected byte[] content;
    protected int offset;
    protected int length;

    public BytesURLConnection(URL url, byte[] content) {
        super(url);
        this.content = content;
    }

    public void connect() {
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(content);
    }
}