package com.mootly.wcm.datacapture;

import java.io.IOException;
import java.text.MessageFormat;

import org.xml.sax.SAXException;

import com.meterware.httpunit.HTMLElement;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.TableRow;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;

public class CaptureZipCode {
	final static String BASE_URL = "http://www.mapsofindia.com/std/";
	public static void main(String[] args) {
		HttpUnitOptions.setScriptingEnabled(false);
		WebConversation wc = new WebConversation();
		 try {
			WebResponse response = wc.getResponse(BASE_URL);
			WebLink[] webLinks = response.getLinks();
			for (WebLink aWebLink:webLinks) {
				if (aWebLink.getURLString().contains(BASE_URL)) {
					WebResponse theStateResponse = aWebLink.click();
					WebLink[] allCities = theStateResponse.getLinks();
					for (WebLink aCityLink:allCities) {
						if (aCityLink.getURLString().startsWith("../../../../std/india/")) {
							//../../../../std/india/andamannicobar/anndmanisland.html
							String anotherBaseURL = aCityLink.getURLString().substring("../../../../std/india/".length());
							WebResponse theCityInStateResponse = wc.getResponse("http://www.mapsofindia.com/std/india/" + anotherBaseURL);
							getCitiesAndStdCode(theCityInStateResponse);
						}
					}
				}
			}
			response.getLinkWith(BASE_URL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getCitiesAndStdCode(WebResponse theCityInStateResponse) {
		 try {
			HTMLElement[] elements = theCityInStateResponse.getElementsWithAttribute("class", "extrtable");
			WebTable[] allTables = theCityInStateResponse.getTables();
			for (WebTable aTable:allTables) {
				if  ( aTable.getAttribute("class") == null ||  !aTable.getAttribute("class").equals("extrtable")) {
					continue;
				}
				int rowCount = aTable.getRowCount();
				int colCount = aTable.getColumnCount();
				for (int rowCtr =1;rowCtr<rowCount;rowCtr++) {
					String city = aTable.getCellAsText(rowCtr, 0);
					String stdCode = aTable.getCellAsText(rowCtr, 1);
					String state = aTable.getCellAsText(rowCtr, 2);
					System.out.println(MessageFormat.format("{0}\t{1}\t{2}", city,stdCode,state));
				}
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
