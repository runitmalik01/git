package com.mootly.wcm.components.cms;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.freemarker.MootlyRepositoryTemplateLoader;
import org.hippoecm.hst.freemarker.RepositoryTemplateLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.cms.BlockDocument;
import com.mootly.wcm.beans.cms.PageDocument;
import com.mootly.wcm.beans.cms.compound.PageRowDetail;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.cms.view.PageDisplayColumn;
import com.mootly.wcm.components.cms.view.PageDisplayRow;
import com.mootly.wcm.components.cms.view.PageDisplayView;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public final class PageDisplay extends BaseComponent {
	static final Logger log = LoggerFactory.getLogger(PageDisplay.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		boolean isReseller = isReseller();
		String resellerId = getResellerId();
		
		String pathInfo = request.getRequestContext().getResolvedSiteMapItem().getPathInfo();
		
		String pageId = request.getRequestContext().getResolvedSiteMapItem().getParameter("pageId");
		if (pageId == null) {
			pageId = "home";
		}
		//find the page first
		HippoBean theBaseBean = getSiteContentBaseBeanForReseller(request);
		//the path to the requested page.
		String relPathToTheRequestedPage = "cms/pages/" + pageId ;
		if (log.isInfoEnabled()) {
			log.info(theBaseBean.getPath());
		}
		PageDocument pageDocument = theBaseBean.getBean(relPathToTheRequestedPage,PageDocument.class);
		if (pageDocument == null) {
			if (log.isInfoEnabled()) {
				log.info("Unable to find the freemarker resource at " + relPathToTheRequestedPage);
				log.info("Will not try at the documentBase Bean");
			}		
			HippoBean scopeBaseBean = getSiteContentBaseBean(request);
			pageDocument = scopeBaseBean.getBean("common/" + relPathToTheRequestedPage,PageDocument.class);
		}
		if (pageDocument != null) {
			if (log.isInfoEnabled()) {
				log.info("Title:" + pageDocument.getTitle());
			}
			PageDisplayView pageDisplayView = new PageDisplayView();
			pageDisplayView.setTitle(pageDocument.getTitle());
			
			List<PageRowDetail> pageRowDetails = pageDocument.getPageRowDetails();
			if (pageRowDetails != null && pageRowDetails.size() > 0) {
				for (PageRowDetail pageRowDetail:pageRowDetails) {							
					List<BlockDocument> blockDocuments = pageRowDetail.getBlockDocuments();
					if (blockDocuments != null && blockDocuments.size() > 0) {
						PageDisplayRow pageDisplayRow = new PageDisplayRow();		
						pageDisplayRow.setNotContainer(pageRowDetail.getNotContainer());
						pageDisplayRow.setNotRow(pageRowDetail.getNotRow());
						pageDisplayRow.setNotColumn(pageRowDetail.getNotColumn());
						for (BlockDocument blockDocument:blockDocuments) {
							PageDisplayColumn pageDisplayColumn = new PageDisplayColumn();
							pageDisplayColumn.setParsedHTML(blockDocument.getScript());
							
							/*
							MootlyRepositoryTemplateLoader repositoryTemplateLoader = new MootlyRepositoryTemplateLoader();
							try {
								String thePathToNode = "jcr:" + blockDocument.getPath();
								if (log.isInfoEnabled()) {
									log.info("thePathToNode:" + thePathToNode);
								}
								Object templateSource = repositoryTemplateLoader.findTemplateSource(thePathToNode);
								if (templateSource != null) {
									Reader templateReader = repositoryTemplateLoader.getReader(templateSource, "UTF-8");
									Template template = new Template(pageId, templateReader, new Configuration());
									Map<String, Object> rootMap = new HashMap<String, Object>();
									StringWriter sw = new StringWriter();
									template.process(rootMap, sw);
									String parsedHTML = sw.toString();
									pageDisplayColumn.setParsedHTML(parsedHTML);
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (TemplateException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							*/
							//if (log.isInfoEnabled()) {
							//	//log.info(blockDocument.getScript());
							//}
							pageDisplayRow.addColumn(pageDisplayColumn);
						}
						pageDisplayView.addRow(pageDisplayRow);
					}
				}
			}
			request.setAttribute("pageDisplayView", pageDisplayView);			
			request.setAttribute("pageDocument", pageDocument);
		}
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
	  
}
