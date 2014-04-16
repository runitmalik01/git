package com.mootly.wcm.components.admin.loadtest.jobs;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.jcr.ImportUUIDBehavior;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jdo.identity.IntIdentity;
import javax.servlet.ServletContext;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.GoGreenUtil;

@SuppressWarnings("all")
public class LoadItrsFromFileSystem extends BaseComponent {
	Logger log = LoggerFactory.getLogger(LoadItrsFromFileSystem.class);
	public static final String REMINDERSENT = "reminder_Sent";
	
	String pathToXMLs = null;
	
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		pathToXMLs = servletContext.getRealPath("/WEB-INF/classes/loadtestxmls");
	}
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		String pathToItr1Xml = pathToXMLs + "/itr1.xml";
		String pathToTestUserXml =  pathToXMLs + "/testuser-at-gmail.com.xml";
		Session session  = null;
		
		String loadToBasePath = request.getRequestContext().getResolvedSiteMapItem().getParameter("loadToBasePath");
		if (loadToBasePath == null) loadToBasePath = "/content/documents/mootlywcm/resellers/w4india/members";
		
		String nsURI ="http://www.jcp.org/jcr/sv/1.0";
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			dbFactory.setNamespaceAware(true);
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			//DEAL with USER FIRST
			FileInputStream theItr1Xml = new FileInputStream(pathToTestUserXml);
			Document document = dBuilder.parse(pathToTestUserXml);
			
			String newUserName = UUID.randomUUID().toString();
			
			String name = document.getDocumentElement().getAttributeNS(nsURI, "name");
			
			document.getDocumentElement().setAttributeNS (nsURI, "name", newUserName +"-at-mootly.com");
			//<sv:property sv:name="hippo:related___pathreference" sv:type="String">
	        //<sv:value>bharadwajamit-at-gmail.com/membersignupdocument</sv:value>
	       // </sv:property>
			changePropertyValue("hippo:related___pathreference", newUserName +"/membersignupdocument", document.getDocumentElement());
			changePropertyValue("mootlywcm:email", newUserName +"@mootly.com", document.getDocumentElement());
			changePropertyValue("mootlywcm:userName", newUserName +"@mootly.com", document.getDocumentElement());
			
			 
			// display nice nice
			StringWriter writer = new StringWriter();
			DOMSource domSource = new DOMSource(document);
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			
			String xml = writer.toString();
			
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
			session  = getPersistableSession(request);
			session.importXML( loadToBasePath + "/", byteArrayInputStream, ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
			
			session.save();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("Error loading File",e);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error loading File",e);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error loading File",e);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try { session.logout(); } catch (Exception e) {}
		}
	}

	@Override
	public void doAction(HstRequest request, HstResponse response) {
		

	}
	
	protected void changePropertyValue(String propertyName,String value,Element rootElement) throws  XPathExpressionException {
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		xpath.setNamespaceContext(new HardcodedNamespaceResolver());
		String theXPath = "//sv:property[@sv:name='" + propertyName + "']//sv:value";
		XPathExpression expr = xpath.compile(theXPath);
		Element elXPath = (Element) xpath.evaluate(theXPath, rootElement.getOwnerDocument(), XPathConstants.NODE);
		if (elXPath != null) {
			//NodeList nl = elXPath.getElementsByTagNameNS("http://www.jcp.org/jcr/sv/1.0", "sv:value");
			
			//nl.item(0).setTextContent(value);
			elXPath.setTextContent(value);
		}
		
	}
	
	class HardcodedNamespaceResolver implements NamespaceContext {

	    /**
	     * This method returns the uri for all prefixes needed. Wherever possible
	     * it uses XMLConstants.
	     * 
	     * @param prefix
	     * @return uri
	     */
	    public String getNamespaceURI(String prefix) {
	    	return "http://www.jcp.org/jcr/sv/1.0";
	      
	    }

	    public String getPrefix(String namespaceURI) {
	        // Not needed in this context.
	    	if (namespaceURI != null && namespaceURI.equals("http://www.jcp.org/jcr/sv/1.0")) {
	    		return "sv";
	    	}
	    	else {
	    		return null;
	    	}
	    }

	    public Iterator getPrefixes(String namespaceURI) {
	        // Not needed in this context.
	        return null;
	    }

	}
}
