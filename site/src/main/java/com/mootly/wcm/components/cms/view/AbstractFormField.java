/**
 * 
 */
package com.mootly.wcm.components.cms.view;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AutoCreateFormField;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.beans.compound.ValueListDocumentDetail;

/**
 * @author BEN-10
 *
 */
public class AbstractFormField {
	public enum FORM_FILED_TYPE {TEXT,TEXT_ARERA,DROPDOWN};
	public static final Logger log =  LoggerFactory.getLogger(AbstractFormField.class);

	AbstractFormFieldData data = new AbstractFormFieldData();
	private FORM_FILED_TYPE type;
	private String html;
	private ValueListDocument valueListDocument;
	private Object propertyValue;

	public AbstractFormField(AutoCreateFormField autoCreateFormField,ValueListDocument valueListDocument, Object propertyValue) {
		// TODO Auto-generated constructor stub
		setType(autoCreateFormField.fieldType());
		data.setId(autoCreateFormField.name());
		data.setName(autoCreateFormField.name());
		data.setLabel(autoCreateFormField.label());
		data.setPlaceHolder(autoCreateFormField.placeHolder());
		data.setTitle(autoCreateFormField.title());
		data.setIsMultiple(autoCreateFormField.isMultiple());
		setValueListDocument(valueListDocument);
		setPropertyValue(propertyValue);
		//Call always last
		setHtml(BuildFieldHTML());
	}

	public AbstractFormFieldData getData() {
		return data;
	}
	public void setData(AbstractFormFieldData data) {
		this.data = data;
	}
	public String getHtml() {
		return html;
	}
	public FORM_FILED_TYPE getType() {
		return type;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public void setType(FORM_FILED_TYPE type) {
		this.type = type;
	}
	public ValueListDocument getValueListDocument() {
		return valueListDocument;
	}
	public void setValueListDocument(ValueListDocument valueListDocument) {
		this.valueListDocument = valueListDocument;
	}
	public Object getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(Object propertyValue) {
		this.propertyValue = propertyValue;
	}
	public String BuildFieldHTML(){
		StringBuilder htmlStringBuilder = new StringBuilder();
		htmlStringBuilder.append("<label for='").append(data.getId()).append("'>").append(data.getLabel()).append("</label>");
		switch(getType()){
		case TEXT:
			htmlStringBuilder.append("<input type='text' ").append("name='").append(data.getName()).append("' id='").append(data.getId()).append("' ");
			if(StringUtils.isNotBlank(data.getTitle())){
				htmlStringBuilder.append("title='").append(data.getTitle()).append("' ");
			}
			if(StringUtils.isNotBlank(data.getPlaceHolder())){
				htmlStringBuilder.append("placeholder='").append(data.getPlaceHolder()).append("' ");	
			}
			htmlStringBuilder.append("class='form-control' ");
			if(getPropertyValue() != null){
				htmlStringBuilder.append("value='").append(getPropertyValue().toString()).append("' ");
			}
			htmlStringBuilder.append("/>");
			html = htmlStringBuilder.toString();
			break;
		case DROPDOWN:
			htmlStringBuilder.append("<select ").append("name='").append(data.getName()).append("' id='").append(data.getId()).append("' ");
			if(StringUtils.isNotBlank(data.getTitle())){
				htmlStringBuilder.append("title='").append(data.getTitle()).append("' ");
			}
			if(StringUtils.isNotBlank(data.getPlaceHolder())){
				htmlStringBuilder.append("placeholder='").append(data.getPlaceHolder()).append("' ");	
			}
			if(data.getIsMultiple()){
				htmlStringBuilder.append("multiple='multiple'");
			}
			htmlStringBuilder.append("class='form-control'>");
			htmlStringBuilder.append("<option value=''>-SELECT-</option>");
			if(getValueListDocument()!=null){
				for(ValueListDocumentDetail li:getValueListDocument().getValueListDocumentDetailList()){
					htmlStringBuilder.append("<option value='").append(li.getKey()).append("' ");
					if(getPropertyValue() != null){
						if(getPropertyValue() instanceof String){
							if(getPropertyValue().toString().equalsIgnoreCase(li.getKey())){
								htmlStringBuilder.append("selected");
							}
						} else if(getPropertyValue() instanceof String[]){
							for(String value:(String[])getPropertyValue()){
								if(value.equalsIgnoreCase(li.getKey())){
									htmlStringBuilder.append("selected");
								}
							}
						}
					}
					htmlStringBuilder.append(">");
					htmlStringBuilder.append(li.getLabel()).append("</option>");
				}
			}
			htmlStringBuilder.append("</select>");
			html = htmlStringBuilder.toString();
			break;
		case TEXT_ARERA:
			htmlStringBuilder.append("<textarea ").append("name='").append(data.getName()).append("' id='").append(data.getId()).append("' ");
			if(StringUtils.isNotBlank(data.getTitle())){
				htmlStringBuilder.append("title='").append(data.getTitle()).append("' ");
			}
			if(StringUtils.isNotBlank(data.getPlaceHolder())){
				htmlStringBuilder.append("placeholder='").append(data.getPlaceHolder()).append("' ");	
			}
			htmlStringBuilder.append("rows='7'").append("' class='form-control'>");
			if(getPropertyValue() != null){
				if(getPropertyValue() instanceof String){
					htmlStringBuilder.append(getPropertyValue().toString());
				}else if(getPropertyValue() instanceof HippoHtml){
					HippoHtml hippoHtml = (HippoHtml) getPropertyValue();
					htmlStringBuilder.append(hippoHtml.getContent());
				}
			}
			htmlStringBuilder.append("</textarea>");
			html = htmlStringBuilder.toString();
			break;
		default:
			break;
		}
		if(log.isInfoEnabled()){
			log.info("lets see html of field::::"+htmlStringBuilder.toString());
		}
		return htmlStringBuilder.toString();
	}
}
