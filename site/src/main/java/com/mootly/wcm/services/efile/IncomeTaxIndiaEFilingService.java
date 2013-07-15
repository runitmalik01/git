package com.mootly.wcm.services.efile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.HttpUnitUtils;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.SubmitButton;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.cookies.CookieListener;
import com.meterware.httpunit.cookies.CookieProperties;
import com.mootly.wcm.model.FinancialYear;

public class IncomeTaxIndiaEFilingService implements EFileService{
	private static Logger log = LoggerFactory.getLogger(IncomeTaxIndiaEFilingService .class);
	WebConversation wc = null; //new WebConversation();
	public IncomeTaxIndiaEFilingService() {
		wc = new WebConversation();
		wc.getClientProperties().setAcceptCookies(true);
		wc.getClientProperties().setAcceptGzip(true);
		
		//CookieProperties cookieProperties = new CookieProperties();
		CookieProperties.setDomainMatchingStrict(false);
		CookieProperties.setPathMatchingStrict(false);
		CookieProperties.addCookieListener(new MyCookieListener());
		//HttpUnitOptions.
		
	}
	WebForm theLoginForm ;
	@Override
	public EFileResponse eFile(String userName, String password, String dob,String pan,
			FinancialYear financialYear, String filePath)
			throws ServerUnderMaintenanceException, SiteUnavailableException,
			AuthenticationException, InvalidReturnException, UnknownException {
		// TODO Auto-generated method stub
		try {
			String loginRequestId = getLoginRequestId();
			//now we need to bundle all and get to the main screen
			WebResponse eFileHomePage = getHomeScreenForUpload(userName,password,dob,pan,financialYear,filePath,loginRequestId);
			saveFile(eFileHomePage,"amit.html");
		}catch (Exception ex) {
			log.error("Error in uploading IT Return", ex);
			throw new UnknownException();
		}
		return null;
	}
	
	
	protected void connectToServer() throws Exception {
	
	}
	
	public WebResponse getHomeScreenForUpload(String userName, String password, String dob,String pan,
		FinancialYear financialYear, String filePath, String loginRequestId) throws Exception {
		
		//WebResponse wr = wc.getResponse("https://incometaxindiaefiling.gov.in/e-Filing/UserLogin/LoginHome.html?nextPage=efile");
		
		//System.out.println( wr.getURL() );
		
		//WebForm[] allForms = wr.getForms();
		//System.out.println( allForms[0].getID() );
		
		//theLoginForm = allForms[0]; //wr.getFormWithID("Login");
		
		//theFirstToCapture.es
		//PostMethodWebRequest postMethodRequest = new PostMethodWebRequest("https://incometaxindiaefiling.gov.in/e-Filing/UserLogin/Login.html",true);
		//theLoginForm.setParameter("requestId", loginRequestId);
		//postMethodRequest.setParameter("nextPage", "Login_nextPage");
		//WebResponse response1 = wc.getResource(postMethodRequest);
		//postMethodRequest = new PostMethodWebRequest("https://incometaxindiaefiling.gov.in/e-Filing/UserLogin/Login.html");
		//theLoginForm.setParameter("nextPage", "efile");
		theLoginForm.setParameter("userName", userName);
		theLoginForm.setParameter("password", password);
		theLoginForm.setParameter("dob", dob);
		//theLoginForm.setParameter("requestId", loginRequestId);
		boolean a = theLoginForm.handleEvent("submit");
		//SubmitButton[] submitButtons = theLoginForm.getSubmitButtons();
		
		WebResponse theFormResponse = theLoginForm.submit();
		saveFile(theFormResponse,"theFormResponse.html");
		WebResponse currentResponse = wc.getCurrentPage();
		//theFormResponse.getResponseCode()
		//postMethodRequest.setHeaderField("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116 Safari/537.36");
		//postMethodRequest.setHeaderField("Referer", "https://incometaxindiaefiling.gov.in/e-Filing/UserLogin/LoginHome.html");
		debug(wc);
		//WebResponse webResponse = wc.getResponse(postMethodRequest);

		//debug(wc);
		//int code = webResponse.getResponseCode();
		//String whereToRedirectNow = webResponse.getHeaderField("Location");
		
		return currentResponse;
	}
	
	public String getLoginRequestId() throws Exception {
		String loginRequestId = null;
		WebResponse wr = wc.getResponse("https://incometaxindiaefiling.gov.in/e-Filing/UserLogin/LoginHome.html?nextPage=efile");
		NodeList nodeList = wr.getDOM().getElementsByTagName("input");
		if (nodeList != null && nodeList.getLength() >0 ) {
			for (int i=0;i<nodeList.getLength();i++) {
				Node n = nodeList.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) n;
					if (e.hasAttribute("type") && e.getAttribute("type").equals("hidden") && e.hasAttribute("name") && e.getAttribute("name").equals("requestId") && e.hasAttribute("value")) {
						loginRequestId = e.getAttribute("value");
					}
				}
			}
		}
		theLoginForm = wr.getFormWithID("Login");
		
		//theLoginForm.setParameter("requestId", loginRequestId);
		return loginRequestId;
	}
	
	protected void saveFile(WebResponse wr,String fileName) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
	 
		try {
			// read this file into InputStream
	 
			// write the inputStream to a FileOutputStream
			outputStream = 
	                    new FileOutputStream(new File("c:\\temp\\aa\\" + fileName));
	 
			int read = 0;
			byte[] bytes = new byte[1024];
	 
			while ((read = wr.getInputStream().read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
	 
			System.out.println("Done!");
	 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	 
			}
		}
	}
	
	protected void debug(WebConversation wc) {
		String[] cookieNames = wc.getCookieNames();
		if (cookieNames != null) {
			for (String aCookieName:cookieNames) {
				System.out.println(aCookieName);
			}
		}
		WebResponse wr = wc.getCurrentPage();
		if (wr != null){
			System.out.println( wr.getURL() );
		}
	}
	public static void main(String[] args) {
		
		HttpUnitOptions.setExceptionsThrownOnScriptError(false);
		IncomeTaxIndiaEFilingService is = new IncomeTaxIndiaEFilingService();
		//dob-13/03/1989
		try {
			is.eFile("ATEPA7799P", "megha_13", "ATEPA7799P","13/03/1989", FinancialYear.TwentyTweleve, "c:\\");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}	
}

class MyCookieListener implements CookieListener {

	@Override
	public void cookieRejected(String cookieName, int reason, String attribute) {
		// TODO Auto-generated method stub
		System.out.println("ASADAS");
	}
	
}
