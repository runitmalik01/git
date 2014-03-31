package com.mootly.wcm.components;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

public class XsltURIResolver implements URIResolver {
	final String basePath;
	final String fileSeparator = System.getProperty("file.separator");
	
	public XsltURIResolver(String basePath) {
		this.basePath = basePath;
	}
	
	@Override
	public Source resolve(String href,String base) {
		StringBuffer path = new StringBuffer(this.basePath);
		path.append(fileSeparator).append(href);
		File file = new File(path.toString());
		if(file.exists()) return new StreamSource(file);
		return null;
	}
}
