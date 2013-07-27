/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.jcr.RepositoryException;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoDocument;
import org.hippoecm.repository.api.HippoNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Node(jcrType="mootlywcm:basedocument")
public class BaseDocument extends HippoDocument {

    public static final Logger log = LoggerFactory.getLogger(BaseDocument.class);

    private String localizedName = null;
    
    public String getLocalizedName() {
        if(localizedName == null) {
            try {
                javax.jcr.Node canonical = ((HippoNode)this.getNode()).getCanonicalNode();
                if(canonical == null) {
                    // for a virtual only node, the local name is just the node name itself
                    localizedName = this.getName();
                } else {
                    localizedName = ((HippoNode)canonical).getLocalizedName();
                }
            } catch (RepositoryException e) {
               log.warn("RepositoryException for localized name", e);
            }  
        }
        return localizedName;
    }
    
    public String getLastModifiedBy(){
        return getProperty("hippostdpubwf:lastModifiedBy");
    }
    public String getCreatedBy(){
        return getProperty("hippostdpubwf:createdBy");
    }
    public Calendar getLastModificationDate(){
        return getProperty("hippostdpubwf:lastModificationDate");
    }
    public Calendar getCreationDate(){
        return getProperty("hippostdpubwf:creationDate");
    }
    public Calendar getPublicationDate(){
        return getProperty("hippostdpubwf:publicationDate");
    }
    
    public static final SimpleDateFormat getIndianDateFormatter() {
    	return new SimpleDateFormat("dd/MM/yyyy");
    }
    
    public GregorianCalendar ConvDateStringToCalendar(String strDate){
		Date date = null ;
		DateFormat formatter = getIndianDateFormatter();
		GregorianCalendar cal=null;
		if(StringUtils.isNotEmpty(strDate)){
			cal=(GregorianCalendar) GregorianCalendar.getInstance();
			try{ 
				date = (Date)formatter.parse(strDate);
				cal.setTime(date);
			}
			catch(Exception e){
				log.error("calendar error"+e);
			}
			return cal;
		}else return null;
		
	}
    
    public String ConvCalendarToDateString(Calendar theDate){
		DateFormat formatter = getIndianDateFormatter();
		if (theDate == null) return null;
		try {
			return formatter.format(theDate.getTime());
		}catch (Exception ex) {
			return null;
		}
		
	}
    
    
    public Double ConvStringToDouble(String strDouble){
		if (strDouble != null) {
			try {
				return Double.valueOf(strDouble);
			}catch (Exception ex) {
				return 0.0D;
			}
		}
		else {
			return 0.0D;
		}
		
	}
    
}
