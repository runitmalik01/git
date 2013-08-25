package com.mootly.wcm.services.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTTPConnectionFactory {
	private static final Logger logger = LoggerFactory.getLogger(HTTPConnectionFactory.class);
	
	public HttpURLConnection getHTTPURLConnection(URL url) {
		HttpURLConnection retVal = null;
		try {
			retVal = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public HttpURLConnection getURLConnectionByPath(String spec) {
		HttpURLConnection retVal = null;
		try {
			URL url = new URL(spec);
			retVal = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
}
