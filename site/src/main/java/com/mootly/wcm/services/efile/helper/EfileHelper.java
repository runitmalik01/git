package com.mootly.wcm.services.efile.helper;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EfileHelper {
	/**
	 * 
	 * @param xml
	 * @return
	 * @throws IOException 
	 */
	public static ZipOutputStream createZipEntry(String xml) throws IOException {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		BufferedOutputStream bfo = new BufferedOutputStream(bo);
		ZipOutputStream zo = new ZipOutputStream(bfo);
		
		ZipEntry ze = new ZipEntry("itr");
		zo.putNextEntry(ze);
		zo.write(xml.getBytes("UTF-8"));
		zo.closeEntry();		
		zo.close();
		
		return zo;
		
	}
}
