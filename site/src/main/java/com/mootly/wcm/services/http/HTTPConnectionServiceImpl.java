package com.mootly.wcm.services.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTTPConnectionServiceImpl implements HTTPConnectionService{
	private static final Logger logger = LoggerFactory.getLogger(HTTPConnectionServiceImpl.class);
	HttpURLConnection httpURLConnection;
		
	@Override 
	public String doGet(Map<String, String> headers, String body,HttpURLConnection httpURLConnection) throws HTTPConnectionException {
		// TODO Auto-generated method stub
		doCommonGetPost(headers, body, httpURLConnection);
		String theFinalValue = doCommonGetResponse(headers, body, httpURLConnection);
		return theFinalValue;
	}
	
	@Override
	public String doPost(Map<String, String> headers, String body,HttpURLConnection httpURLConnection) throws HTTPConnectionException {
		DataOutputStream dataoutputstream;
		try {
			doCommonGetPost(headers, body, httpURLConnection);
			dataoutputstream = new DataOutputStream( httpURLConnection.getOutputStream() );
			dataoutputstream.writeBytes(body);
			dataoutputstream.flush();
			dataoutputstream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw getException(e, httpURLConnection);
		}
		String theFinalValue = doCommonGetResponse(headers, body, httpURLConnection);
		return theFinalValue;
	}
	
	
	protected void doCommonGetPost(Map<String, String> headers, String body,HttpURLConnection httpURLConnection) throws HTTPConnectionException {
		if (headers != null && headers.size() > 0 ) {
			for (String aHeader:headers.keySet()) {
				httpURLConnection.setRequestProperty(aHeader, headers.get(aHeader));
			}
		}		
	}
	
	protected HTTPConnectionException getException(Exception ex,HttpURLConnection httpURLConnection) {
		// TODO Auto-generated catch block
		StringBuffer finalOutput = new StringBuffer();
		HTTPConnectionException theExceptionToThrow = new HTTPConnectionException(ex);
		if ( httpURLConnection != null) {
			try {				
				theExceptionToThrow.setResponseCode( httpURLConnection.getResponseCode() );
				theExceptionToThrow.setResponseMessage( httpURLConnection.getResponseMessage() );
				if (httpURLConnection.getErrorStream() != null) {
					BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(httpURLConnection.getErrorStream())); 
					String okresponse = null;
					do {
						okresponse = bufferedReader.readLine();
						if (okresponse != null) {
							finalOutput.append(okresponse);
						}
					} while (okresponse != null);
					if (finalOutput != null) theExceptionToThrow.setTheCompleteMessage(finalOutput.toString());
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				logger.error("Error parsing the response",e1);
			}
		}
		logger.error("Error getting response back from the server",ex);
		return theExceptionToThrow;
	}
	
	protected String doCommonGetResponse(Map<String, String> headers, String body,HttpURLConnection httpURLConnection) throws HTTPConnectionException {
		DataOutputStream dataoutputstream;
		StringBuffer finalOutput = new StringBuffer();
		try {
			//dataoutputstream = new DataOutputStream( httpURLConnection.getOutputStream() );
			//dataoutputstream.writeBytes(body);
			//dataoutputstream.flush();
			//dataoutputstream.close();
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			
			String okresponse = null;
			do {
				//process response
				okresponse = bufferedReader.readLine();
				if (okresponse != null) {
					finalOutput.append(okresponse);
				}
			} while (okresponse != null);
		} catch (Exception e) {
			//getexception
			throw getException(e,httpURLConnection);
		}
		//	post the request
		return (finalOutput == null ? null : finalOutput.toString());	
	}
	
}
