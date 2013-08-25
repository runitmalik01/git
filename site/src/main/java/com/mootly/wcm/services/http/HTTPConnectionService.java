package com.mootly.wcm.services.http;

import java.net.HttpURLConnection;
import java.util.Map;

/**
 * 
 * @author admin
 *
 */
public interface HTTPConnectionService {
	String doGet(Map<String, String> headers,String body,HttpURLConnection httpURLConnection) throws HTTPConnectionException;
	String doPost(Map<String, String> headers,String body,HttpURLConnection httpURLConnection) throws HTTPConnectionException;
}
