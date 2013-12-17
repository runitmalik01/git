package com.mootly.wcm.beans;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.BeanClone;
import com.mootly.wcm.annotations.FormField;
import com.mootly.wcm.annotations.NodeBinder;
import com.mootly.wcm.beans.compound.HelpDeskTicketNote;
import com.mootly.wcm.beans.compound.InvoiceDocumentDetail;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.utils.CalculatedFieldHelper;
import com.mootly.wcm.utils.NodeBinderHelper;


@Node(jcrType = "mootlywcm:HelpDeskTicket")
public class HelpDeskTicketDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	private static final Logger log = LoggerFactory.getLogger(HelpDeskTicketDocument.class);
	private static final String PROP_IDENTIFIER = "mootlywcm:identifier";
	private static final String PROP_TITLE = "mootlywcm:title";
	private static final String PROP_DESCRIPTION = "mootlywcm:description";
	private static final String PROP_PROBLEM_CATEGORY = "mootlywcm:problemCategory";
	private static final String PROP_ASSESSMENT_YEAR = "mootlywcm:assessmentYear";
	
	private static final String PROP_NOTES = "mootlywcm:HelpDeskTicketNote";
	
	String identifier;
	String title;
	String problemCategory;
	String assessmentYear; 
	String description;
	List<HelpDeskTicketNote> notes = null;
	
	private boolean markedForDeletion;
	
	@FormField(name="identifier")
	@NodeBinder(nodePropertyName=PROP_IDENTIFIER,propertyName="identifier")
	public final String getIdentifier() {
		if (identifier == null) identifier = getProperty(PROP_IDENTIFIER);
		return identifier;
	}
	
	@FormField(name="title")
	@NodeBinder(nodePropertyName=PROP_TITLE,propertyName="title")
	public final String getTitle() {
		if (title == null) title = getProperty(PROP_TITLE);
		return title;
	}
	
	@FormField(name="problemCategory")
	@NodeBinder(nodePropertyName=PROP_PROBLEM_CATEGORY,propertyName="problemCategory")
	public final String getProblemCategory() {
		if (problemCategory == null) problemCategory = getProperty(PROP_PROBLEM_CATEGORY);
		return problemCategory;
	}

	@FormField(name="assessmentYear")
	@NodeBinder(nodePropertyName=PROP_ASSESSMENT_YEAR,propertyName="assessmentYear")
	public final String getAssessmentYear() {
		if (assessmentYear == null) assessmentYear = getProperty(PROP_ASSESSMENT_YEAR);
		return assessmentYear;
	}

	@FormField(name="description")
	@NodeBinder(nodePropertyName=PROP_DESCRIPTION,propertyName="description")
	public final String getDescription() {
		if (description == null) description = getProperty(PROP_DESCRIPTION);
		return description;
	}
	
	public final List<HelpDeskTicketNote> getNotes() {
		if (notes == null) notes= getChildBeans(PROP_NOTES);
		return notes;
	}

	public final void setNotes(List<HelpDeskTicketNote> notes) {
		this.notes = notes;
	}

	public final void addNote(HelpDeskTicketNote note) {
		getNotes();
		if (notes == null) notes = new ArrayList<HelpDeskTicketNote>();
		notes.add(note);
	}
	

	@BeanClone
	public final void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	@BeanClone
	public final void setTitle(String title) {
		this.title = title;
	}
	
	@BeanClone
	public final void setProblemCategory(String problemCategory) {
		this.problemCategory = problemCategory;
	}

	@BeanClone
	public final void setAssessmentYear(String assessmentYear) {
		this.assessmentYear = assessmentYear;
	}

	@BeanClone
	public final void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
		NodeBinderHelper nodeBinderHelper = new NodeBinderHelper();
		nodeBinderHelper.bindObjectToNode(node, this);
		
		HelpDeskTicketDocument helpDeskTicketDocument = (HelpDeskTicketDocument) content;
		try {
			NodeIterator nodeIterator = node.getNodes(PROP_NOTES);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			if (helpDeskTicketDocument != null & helpDeskTicketDocument.getNotes() != null) {
				for (HelpDeskTicketNote helpDeskTicketNote:helpDeskTicketDocument.getNotes()) {
					//if (!helpDeskTicketNote.isMarkedForDeletion()) {
						javax.jcr.Node html = node.addNode(PROP_NOTES, PROP_NOTES);
						helpDeskTicketNote.bindToNode(html); 
					//}
				}
			}	
		}catch (RepositoryException e) {
			log.error("Repository Exception ",e);
		}
			
		return true;
	}
	
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		super.fill(formMap);
		FormMapHelper formMapHelper = new FormMapHelper();
		formMapHelper.fillFromFormMap(this, formMap);
		CalculatedFieldHelper calculatedFieldHelper = new CalculatedFieldHelper();
		calculatedFieldHelper.processCalculatedFields(this);
	}

	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(HippoBean child) {
		// TODO Auto-generated method stub
		if (child instanceof HelpDeskTicketNote) {
			HelpDeskTicketNote source =(HelpDeskTicketNote) child;
			addNote(source);
		}
	}
	
}
