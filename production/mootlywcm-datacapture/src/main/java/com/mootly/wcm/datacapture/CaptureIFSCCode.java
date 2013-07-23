package com.mootly.wcm.datacapture;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

public class CaptureIFSCCode {
	final static String BASE_URL = "http://www.rbi.org.in/Scripts/bs_viewcontent.aspx?Id=2009";
	final static String SAVE_PATH ="C:\\Users\\admin\\Downloads\\BankIFSCCode";
	public static void main(String[] args) {
		HttpUnitOptions.setScriptingEnabled(false);
		WebConversation wc = new WebConversation();
		InputStream inputStream = null;
		BufferedReader br = null;
		try {
			WebResponse response = wc.getResponse(BASE_URL);
			WebLink[] webLinks = response.getLinks();
			for (WebLink aWebLink:webLinks) {
				if (!aWebLink.getURLString().endsWith(".xls")) continue;
				String[] parts = aWebLink.getURLString().split("[/]");
				String fileName = parts[parts.length -1];
				String sourceFile = SAVE_PATH + "\\" + fileName ;
				String destFile = SAVE_PATH + "\\" + fileName.replaceAll("\\.xls", ".csv");
				WebResponse theExcel = aWebLink.click();
				inputStream = theExcel.getInputStream();
				OutputStream stream = new BufferedOutputStream(new FileOutputStream(sourceFile)); 
				int bufferSize = 1024;
				byte[] buffer = new byte[bufferSize];
				int len = 0;
				while ((len = inputStream.read(buffer)) != -1) {
				    stream.write(buffer, 0, len);
				}
				if(stream!=null)
				    stream.close();
				//lets make some change to excel before converting it into csv
				//Workbook wb = WorkbookFactory.create(new FileInputStream(sourceFile));
				//Sheet sheet = wb.getSheetAt(0);
				//sheet.getRow(0).getCell(1).setCellValue("BANK_CODE");
				try {
					System.out.println("@echo Processing " + fileName);
					ToCSV toCSV = new ToCSV(aWebLink.getText());
					toCSV.convertExcelToCSV(sourceFile, SAVE_PATH);
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
