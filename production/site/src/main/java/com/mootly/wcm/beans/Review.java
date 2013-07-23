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

import static com.mootly.wcm.utils.Constants.NT_PRODUCTLINK;
import static com.mootly.wcm.utils.Constants.PROP_COMMENT;
import static com.mootly.wcm.utils.Constants.PROP_DATE;
import static com.mootly.wcm.utils.Constants.PROP_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_NAME;
import static com.mootly.wcm.utils.Constants.PROP_RATING;

import java.util.Calendar;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.utils.Constants;


/**
 * [mootlywcm:review] > mootlywcm:basedocument
 * - mootlywcm:name (string)
 * - mootlywcm:email (string)
 * - mootlywcm:rating (long)
 * - mootlywcm:comment (string)
 * + mootlywcm:productlink (hippo:mirror)
 */

@Node(jcrType = Constants.NT_REVIEW)
public class Review extends BaseDocument implements ContentNodeBinder ,FormMapFiller {

    private static final Logger log = LoggerFactory.getLogger(Review.class);

    private String name;
    private String email;
    private Long rating;
    private String comment;
    private String productUuid;
    private Calendar date;

    public Calendar getDate() {
        return (date == null) ? (Calendar) getProperty(PROP_DATE) : date;
    }

    public String getName() {
        return (name == null) ? (String) getProperty(PROP_NAME) : name;
    }

    public String getEmail() {
        return (email == null) ? (String) getProperty(PROP_EMAIL) : email;
    }

    public Long getRating() {
        return (rating == null) ? (Long) getProperty(PROP_RATING) : rating;
    }

    public String getComment() {
        return (comment == null) ? (String) getProperty(PROP_COMMENT) : comment;
    }

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String uuid) {
        this.productUuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
        if (content instanceof Review) {
            try {
                Review review = (Review) content;
                node.setProperty(PROP_NAME, review.getName());
                node.setProperty(PROP_EMAIL, review.getEmail());
                node.setProperty(PROP_COMMENT, review.getComment());
                node.setProperty(PROP_RATING, review.getRating());
                node.setProperty(PROP_DATE, Calendar.getInstance());

            } catch (Exception e) {
                log.error("Unable to bind the content to the JCR Node" + e.getMessage(), e);
                throw new ContentNodeBindingException(e);
            }

        }
        return true;
    }
    
    @Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");			
		}
		if (formMap == null) return;
		if ( formMap.getField("name") != null) {
			String name=formMap.getField("name").getValue();
			setName(name);
		}
		if ( formMap.getField("email") != null) {
			String email=formMap.getField("email").getValue();
			setEmail(email);
		}
		if ( formMap.getField("comment") != null) {
			String comment=formMap.getField("comment").getValue();
			setComment(comment);
		}
		if ( formMap.getField("rating") != null) {
			String rating=formMap.getField("rating").getValue();
			Long longrating=Long.parseLong(rating);
			setRating(longrating);
		}
		
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}
    
}
