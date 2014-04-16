/*
 * In this class we are creating a document for storing value of salary income details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */

package com.mootly.wcm.components.vendor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.UUID;

import javax.jcr.Session;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.IOUtils;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.itreturns.AbstractITReturnHomePage;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITReturnHomePageView;
import com.mootly.wcm.services.XmlGeneratorService;
import com.mootly.wcm.utils.ValueListService;
import com.mootly.wcm.utils.ValueListServiceImpl;

public class ITReturnHomePage extends AbstractITReturnHomePage {

	private static final Logger log = LoggerFactory.getLogger(ITReturnHomePage.class);

	@SuppressWarnings("unchecked")
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		super.doBeforeRender(request, response);			
		//request.setAttribute("listOfITReturnHomePageView", listOfITReturnHomePageView);	
		String basePath = getSiteContentBaseBeanForReseller(request).getPath();
		String basePathCanonical = getSiteContentBaseBeanForReseller(request).getCanonicalPath();
		List<ITReturnHomePageView> listOfITReturnHomePageView = (List<ITReturnHomePageView>) request.getAttribute("listOfITReturnHomePageView");
		MongoClient mongoClient = null;
		DB db = null; 
		DBCollection dbCollection = null; //db.getCollection("test");
		try {
			mongoClient = new MongoClient( "wealth4india.com" , 27017);
			db = mongoClient.getDB( "test" );
			db.authenticate("w4indiaprod", "mootly007".toCharArray());
			dbCollection = db.getCollection("test");
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (mongoClient !=null && listOfITReturnHomePageView != null) {
			for (ITReturnHomePageView itReturnHomePageView:listOfITReturnHomePageView) {
				String relPath = itReturnHomePageView.getPathToItr().substring(basePath.length() + 1) + "/pans/" +  itReturnHomePageView.getPan().toLowerCase() +  "/" + itReturnHomePageView.getFinancialYear() + "/" +  itReturnHomePageView.getTheParentFolder() ;
				String pathITRToExport = basePathCanonical + "/" +  relPath;// + "/pans/" +  itReturnHomePageView.getPan().toLowerCase() +  "/" + itReturnHomePageView.getFinancialYear() + "/" +  itReturnHomePageView.getTheParentFolder() ;
				String nameOfFolderToExport = itReturnHomePageView.getTheParentFolder() ;
				MemberPersonalInformation memberPersonalInformation = null;
				List<HippoDocumentBean> allDocuments = getITRInitData(request).loadAllBeansUnderTheFolder(request, relPath, null, null);
				Map<String, HippoBean> mapOfBeans = new HashMap<String,HippoBean>();
				if (allDocuments != null) {
					for (HippoDocumentBean theBean:allDocuments) {
						if (theBean instanceof MemberPersonalInformation) {
							memberPersonalInformation = (MemberPersonalInformation) theBean;
						}
						mapOfBeans.put(theBean.getClass().getSimpleName().toLowerCase(), theBean);
					}
				}
				String generatedXml = null;
				String generatedJSON = null;
				XmlGeneratorService xmlGeneratorService = getItrXmlGeneratorServiceFactory().getInstance(itReturnHomePageView.getFinancialYear());
				if (xmlGeneratorService != null) {
					try {
						Map<String,Object> returnObject = xmlGeneratorService.generateXml(itReturnHomePageView.getFinancialYear(),mapOfBeans);
						if (returnObject != null && returnObject.containsKey("xml")) {
							generatedXml = (String) returnObject.get("xml");
						}
						generatedJSON = getJSON(request, generatedXml, pathITRToExport, nameOfFolderToExport, memberPersonalInformation, itReturnHomePageView.getFinancialYear());
						DBObject dbObject = (DBObject) JSON.parse(generatedJSON);
						dbCollection.insert(dbObject);
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						log.error("Error in generating XML",e);
					}
				}
				//System.out.println( itReturnHomePageView.getPathToItr() );
			}
		}
		
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		//super.doAction(request, response);
	}

	@Override
	public boolean beforeSave(HstRequest request) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Vendor need to search all over
	 */
	@Override
	public HippoBean getScope(HstRequest request) {
		// TODO Auto-generated method stub
		return getSiteContentBaseBeanForReseller(request);
	}
	
	public String getJSON(HstRequest request,String generatedXml,String pathITRToExport,String nameOfFolderToExport,MemberPersonalInformation memberPersonalInformation,FinancialYear financialYear) throws Exception {
		String jSONString = null;
		
		String tmpDir = System.getProperty("java.io.tmpdir");
		String uuid = UUID.randomUUID().toString();
		new File(tmpDir + "/" + uuid).mkdir();
		String finalMergedXMLAsString = null;
		String xmlFile  = "documentView.xml";
		String xmlFileMerged  = "documentView.merged.xml";
		String jsonMergedData = "documentView.merged.json";
		String pdfFileName = "ITR-" + getITRInitData(request).getPAN() +"-AY-" + financialYear.getDisplayAssessmentYear() + ".pdf";
		String temporaryPathToXML = tmpDir + "/" + uuid + "/" + xmlFile;
		String temporaryPathToMergedXML = tmpDir + "/" + uuid + "/" + xmlFileMerged;
		String temporaryPathToPDF = tmpDir + "/" + uuid + "/" + pdfFileName;
		String temporaryPathToJSON = tmpDir + "/" + uuid + "/" + jsonMergedData;
		Session session = request.getRequestContext().getSession();
		String thePathToExport = pathITRToExport; // getITRInitData(request).getMemberPersonalInformation().getParentBean().getCanonicalPath();
		String jsonRootElement = nameOfFolderToExport.toLowerCase(); // getITRInitData(request).getMemberPersonalInformation().getParentBean().getName().toLowerCase();
		//ByteArrayOutputStream theStream = new ByteArrayOutputStream();
		final OutputStream os = new FileOutputStream(temporaryPathToXML);
		session.exportDocumentView(thePathToExport, os, true, false);
		//String theXML = new String(theStream.toByteArray());
		//log.info(theXML);
		
		//DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//InputSource is = new InputSource(new StringReader(theXML));
		//org.w3c.dom.Document aDom = db.parse(is);
		
		//we need to merge the GENERATED XML WITH the EXISTING XML for a COMPLETE PICTURE
		DOMSource theFinalDomSource = null;
		if (generatedXml != null) {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource(new FileInputStream(temporaryPathToXML));
			org.w3c.dom.Document aDom = db.parse(is);
			
			//SECOND DOM for other XML
			
			DocumentBuilder db2 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is2 = new InputSource(new StringReader(generatedXml));
			org.w3c.dom.Document aDom2 = db2.parse(is2);
			
			Node theNewNode = aDom.importNode( aDom2.getDocumentElement(),true) ;
			aDom.getDocumentElement().appendChild(theNewNode);
			
			theFinalDomSource = new DOMSource(aDom.getDocumentElement());
			
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StreamResult result = new StreamResult(new File(temporaryPathToMergedXML));
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
			transformer.transform(theFinalDomSource, result);
			try { result.getWriter().close(); } catch (Exception e) {}
		}
		
		Source xmlSource = new StreamSource(new InputStreamReader(new FileInputStream(temporaryPathToMergedXML), "UTF8"));
		//Source xmlSource = new StreamSource(theFinalDomSource);
		Source xsltSource = new StreamSource(new InputStreamReader(new FileInputStream(getXsltITRPath()), "UTF8"));
		//FileInputStream fi = new FileInputStream(xsltPath);
		//StreamSource stylesource = new StreamSource(fi);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		if ( getWebInfXsltURIResolver() != null) transformerFactory.setURIResolver(getWebInfXsltURIResolver());
		Transformer transformer  = transformerFactory.newTransformer(xsltSource);
		//if ( webInfXsltURIResolver != null) transformer.setURIResolver(webInfXsltURIResolver); //we want to do xsl include to make code more modular
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		if (memberPersonalInformation != null) {
				ValueListService objValueListService = ValueListServiceImpl.getInstance();
				SortedSet<Map.Entry<String,String>> objHashMapcountry = objValueListService.getCountry();
				SortedSet<Map.Entry<String,String>> objHashMapstates = objValueListService.getStates();
				String countryCode = memberPersonalInformation.getCountry();
				String stateCode = memberPersonalInformation.getState();
				if (countryCode != null && "91".equals(countryCode)) {
					transformer.setParameter("COUNTRY", "INDIA");
				}
				else if (countryCode != null && objHashMapcountry != null) {
					for (Iterator<Entry<String, String>> it = objHashMapcountry.iterator();it.hasNext();) {
						Entry<String,String> anEntry =	it.next();
						if (anEntry.getKey() != null && countryCode.equalsIgnoreCase(anEntry.getKey())) {
							transformer.setParameter("COUNTRY", anEntry.getValue().toUpperCase());
							break;
						}
					}
				}
				if (stateCode != null) {
					for (Iterator<Entry<String, String>> it = objHashMapstates.iterator();it.hasNext();) {
						Entry<String,String> anEntry =	it.next();
						if (anEntry.getKey() != null && stateCode.equalsIgnoreCase(anEntry.getKey())) {
							transformer.setParameter("STATE", anEntry.getValue().toUpperCase());
							break;
						}
					}
				}
				transformer.setParameter("displayAssessmentYear",financialYear.getDisplayAssessmentYear());
		}
		StringWriter sw = new StringWriter();
		//StreamSource sSource = new StreamSource(new StringReader(theXML));
		StreamResult sResult = new StreamResult(sw);
		transformer.transform(xmlSource,sResult);
		//fi.close();
		String theHTML = sw.toString();
		if (log.isInfoEnabled()) {
			log.info(theHTML);
		}
		//String pathToPDF = generatePDF(theHTML,temporaryPathToPDF);
		//if (log.isInfoEnabled()) {
		//	log.info(pathToPDF);
		//}
		FileInputStream fi = null;
		fi = new FileInputStream(temporaryPathToMergedXML);
		String finalMergedXML = IOUtils.toString(fi, "UTF-8");
		try {
			JSONObject jsonObject = XML.toJSONObject(finalMergedXML);
			JSONObject jsonObject2 = jsonObject.getJSONObject(jsonRootElement);
			jSONString = jsonObject2.toString();
			if (log.isInfoEnabled()) {
				log.info("JSONFinalString:" + jSONString);
			}
			//FileWriterWithEncoding fwriter = new FileWriterWithEncoding(temporaryPathToJSON, "UTF-8");
			//IOUtils.write(jSONString, fwriter);
			//fwriter.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jSONString;
	}
}
