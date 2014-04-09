package com.mootly.wcm.components.admin.maintenance.jobs;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Session;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoBeanIterator;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.ComponentConfiguration;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.itreturns.AbstractITReturnHomePage;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITReturnHomePageView;
import com.mootly.wcm.services.XmlGeneratorService;
import com.mootly.wcm.services.sync.mongodb.SyncToMongoDb;

/**
 * 
 * @author Amit
 *
 */
public class SyncDataToExternalDB extends AbstractITReturnHomePage{

	private static final Logger log = LoggerFactory.getLogger(SyncDataToExternalDB.class);
	
	private SyncToMongoDb syncToMongoDb = null;
	@Override
	public void init(ServletContext servletContext,
			ComponentConfiguration componentConfig)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.init(servletContext, componentConfig);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		syncToMongoDb = context.getBean(SyncToMongoDb.class);
	}
	
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		//super.doBeforeRender(request, response);
		try {
			exporMemberSignupDocument(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			exportITRs(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	protected void exporMemberSignupDocument(HstRequest request) throws Exception {
		try {
			String basePath = getSiteContentBaseBeanForReseller(request).getPath();
			String basePathCanonical = getSiteContentBaseBeanForReseller(request).getCanonicalPath();
			HstQuery hstQuery = createGenericPageHstQuery(request,null,null,null,null,null,MemberSignupDocument.class); ///getITRInitData(request).loadAllBeansUnderTheFolder(request, "members", null, null, MemberSignupDocument.class);
			HstQueryResult hstQueryResult = hstQuery.execute();
			HippoBeanIterator hippoBeanIterator = hstQueryResult.getHippoBeans();
			List<MemberSignupDocument> memberSignupDocuments = new ArrayList<MemberSignupDocument>();
			if (hippoBeanIterator !=null) {
				for (;hippoBeanIterator.hasNext();) {
					HippoBean theBean =  hippoBeanIterator.nextHippoBean();
					if (theBean != null && theBean instanceof MemberSignupDocument) {
						memberSignupDocuments.add((MemberSignupDocument) theBean);
					}
				}
			}
			String resellerId = getITRInitData(request).getResellerId();
			DBCollection dbCollection = syncToMongoDb.getDBCollectionForITR(resellerId + "_membersignups"); //db.getCollection("test");
			if (memberSignupDocuments != null && memberSignupDocuments.size() > 0 ) {
				for (MemberSignupDocument memberSignupDocument:memberSignupDocuments) {
					String generatedJSON = getJSON(request, null, memberSignupDocument.getCanonicalPath(), "membersignupdocument");
					DBObject dbObject = (DBObject) JSON.parse(generatedJSON);
					///content/documents/mootlywcm/resellers/w4india/members/prateek11052012-at-gmail.com/pans/ctupk6577p/2012-2013/ctupk6577p_f_420/memberpersonalinformation/memberpersonalinformation
					HippoFolder theUserNameFolder = (HippoFolder) memberSignupDocument.getParentBean();
					if (theUserNameFolder != null) {
						String theMemberFolderUUID = theUserNameFolder.getCanonicalUUID();
						String theMemberFolderPath = theUserNameFolder.getCanonicalPath();
						if (theMemberFolderUUID != null) dbObject.put("theMemberFolderUUID",theMemberFolderUUID); 
						if (theMemberFolderPath != null) dbObject.put("theMemberFolderPath",theMemberFolderPath); 
					}
					dbCollection.insert(dbObject);
				}
			}
		}catch (Exception e){
			log.error("Error",e);
		}
	}
	
	protected void exportITRs(HstRequest request) throws Exception {
		try {
			String basePath = getSiteContentBaseBeanForReseller(request).getPath();
			String basePathCanonical = getSiteContentBaseBeanForReseller(request).getCanonicalPath();
			List<ITReturnHomePageView> listOfITReturnHomePageViews = null;
			HstQuery hstQuery = createMemberHomePageHstQuery(request,null,null,null,null, null );// itReturnInitData.loadAllBeansUnderTheFolder(request, baseRelPathToReturnDocuments, null, null, MemberPersonalInformation.class);
			HstQueryResult hstQueryResult = hstQuery.execute();
			HippoBeanIterator hippoBeanIterator = hstQueryResult.getHippoBeans();
			List<MemberPersonalInformation> listOfMemberPersonalInfo = new ArrayList<MemberPersonalInformation>();
			for (;hippoBeanIterator.hasNext();) {
				HippoBean theBean = hippoBeanIterator.next();
				if (theBean instanceof MemberPersonalInformation) {
					listOfMemberPersonalInfo.add( (MemberPersonalInformation) theBean);
				}
			}
			
			if ( listOfMemberPersonalInfo != null && listOfMemberPersonalInfo.size() > 0 ){
				listOfITReturnHomePageViews = new ArrayList<ITReturnHomePageView>(listOfMemberPersonalInfo.size());
				for (MemberPersonalInformation memberPersonalInformation:listOfMemberPersonalInfo) {
					try {
						if (memberPersonalInformation.getFilingSection() != null) {
							ITReturnHomePageView itReturnHomePageView = initHomePageView(request, memberPersonalInformation,true);
							listOfITReturnHomePageViews.add(itReturnHomePageView);
						}
					}catch (Exception e) {
						log.error("Error in Member Personal Information",e);
					}
				}
			}
			String resellerId = getITRInitData(request).getResellerId();
			DBCollection dbCollection = syncToMongoDb.getDBCollectionForITR(resellerId + "_itrs"); //db.getCollection("test");
			if (dbCollection !=null && listOfITReturnHomePageViews != null) {
				for (ITReturnHomePageView itReturnHomePageView:listOfITReturnHomePageViews) {
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
							generatedJSON = getJSON(request, generatedXml, pathITRToExport, nameOfFolderToExport);
							DBObject dbObject = (DBObject) JSON.parse(generatedJSON);
							dbObject.put("invoiceAmountDue", itReturnHomePageView.getAmountDue());
							dbObject.put("totalInvoiceAmount", itReturnHomePageView.getTotalInvoiceAmount());
							if ( itReturnHomePageView.getFinancialYear() != null) {
								dbObject.put("financialYear",itReturnHomePageView.getFinancialYear().name());
							}
							///content/documents/mootlywcm/resellers/w4india/members/prateek11052012-at-gmail.com/pans/ctupk6577p/2012-2013/ctupk6577p_f_420/memberpersonalinformation/memberpersonalinformation
							HippoFolder theUserNameFolder = (HippoFolder) memberPersonalInformation.getParentBean().getParentBean().getParentBean().getParentBean().getParentBean();//.getParentBean();
							if (theUserNameFolder != null) {
								String theMemberFolderUUID = theUserNameFolder.getCanonicalUUID();
								String theMemberFolderPath = theUserNameFolder.getCanonicalPath();
								if (theMemberFolderUUID != null) dbObject.put("theMemberFolderUUID",theMemberFolderUUID); 
								if (theMemberFolderPath != null) dbObject.put("theMemberFolderPath",theMemberFolderPath); 
							}
							dbCollection.insert(dbObject);
						}
						catch (Exception e) {
							log.error("Error in generating XML",e);
						}
					}
				}
			}
		}catch (Exception e){
			log.error("Error",e);
		}
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
	
	@Override
	public HippoBean getScope(HstRequest request) {
		// TODO Auto-generated method stub
		return getSiteContentBaseBeanForReseller(request);
	}
	
	public String getJSON(HstRequest request,String generatedXml,String pathITRToExport,String nameOfFolderToExport) throws Exception {
		String jSONString = null;
		//String temporaryPathToXML = tmpDir + "/" + uuid + "/" + xmlFile;
		Session session = request.getRequestContext().getSession();
		String thePathToExport = pathITRToExport; // getITRInitData(request).getMemberPersonalInformation().getParentBean().getCanonicalPath();
		String jsonRootElement = nameOfFolderToExport.toLowerCase(); // getITRInitData(request).getMemberPersonalInformation().getParentBean().getName().toLowerCase();
		final ByteArrayOutputStream theStream = new ByteArrayOutputStream();
		//final OutputStream os = new FileOutputStream(temporaryPathToXML);
		session.exportDocumentView(thePathToExport, theStream, true, false);
		String theXML = new String(theStream.toByteArray());
		
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(theXML));
		org.w3c.dom.Document aDom = db.parse(is);
		
		//we need to merge the GENERATED XML WITH the EXISTING XML for a COMPLETE PICTURE
		DOMSource theFinalDomSource = null;
		if (generatedXml != null) {
			//SECOND DOM for other XML
			DocumentBuilder db2 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is2 = new InputSource(new StringReader(generatedXml));
			org.w3c.dom.Document aDom2 = db2.parse(is2);
			
			Node theNewNode = aDom.importNode( aDom2.getDocumentElement(),true) ;
			aDom.getDocumentElement().appendChild(theNewNode);
			theFinalDomSource = new DOMSource(aDom.getDocumentElement());
		}
		else {
			theFinalDomSource = new DOMSource(aDom.getDocumentElement());
		}
		
		TransformerFactory tFactory =TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();
		StringWriter finalXMLWriter = new StringWriter();
		StreamResult result = new StreamResult(finalXMLWriter);
		transformer.transform(theFinalDomSource, result); 
		String finalMergedXML = finalXMLWriter.toString();
		try {
			JSONObject jsonObject = XML.toJSONObject( finalMergedXML );
			JSONObject jsonObject2 = jsonObject.getJSONObject(jsonRootElement);
			jSONString = jsonObject2.toString();
			if (log.isInfoEnabled()) {
				log.info("JSONFinalString:" + jSONString);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jSONString;
	}

}
