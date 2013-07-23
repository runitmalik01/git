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

import static com.mootly.wcm.utils.Constants.PROP_DESCRIPTION;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFacetSelect;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.beans.compound.ImageSet;


/**
 * [mootlywcm:product] > mootlywcm:document, relateddocs:relatabledocs
 * - mootlywcm:price (double)
 * - mootlywcm:rating (double)
 * - mootlywcm:votes (long)
 * - mootlywcm:categories (string) multiple
 * + mootlywcm:images (hippogallerypicker:imagelink) multiple
 */
@Node(jcrType = "mootlywcm:product")
public class Product extends Document {

    private List<ImageSet> images;
    private Double price;

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Double getPrice() {
        if (price == null) {
            price = getProperty("mootlywcm:price");
        }
        return price;
    }
    
    public Double getResellerPrice() {
        return getPrice() * 0.9;
    }

    public Double getRating() {
        return getProperty("mootlywcm:rating");
    }

    public Long getVotes() {
        return getProperty("mootlywcm:votes");
    }

    public String[] getCategories() {
        return getProperty("mootlywcm:categories");
    }

    public List<ImageSet> getImages() {
        if (images == null) {
            loadImages();
        }
        return images;
    }

    public ImageSet getMainImage() {
        if (images == null) {
            loadImages();
        }
        return images.size() == 0 ? null : images.get(0);
    }

    private void loadImages() {
        images = new ArrayList<ImageSet>();
        List<HippoMirror> mirrors = getChildBeansByName("mootlywcm:image");
        for (HippoBean mirror : mirrors) {
            if (mirror instanceof HippoFacetSelect) {
                HippoFacetSelect facetSelect = (HippoFacetSelect) mirror;
                HippoBean referenced = facetSelect.getReferencedBean();
                if (referenced instanceof ImageSet) {
                    ImageSet image = (ImageSet) referenced;
                    images.add(image);

                }
            }
        }
    }

    @Override
    public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
        super.bind(content, node);

        Product bean = (Product) content;
        
        try {
            node.setProperty("mootlywcm:title", bean.getTitle());
            node.setProperty("mootlywcm:summary", bean.getSummary());
            node.setProperty("mootlywcm:price", bean.getPrice());
            
            if (getDescriptionContent() != null) {
                if (node.hasNode(PROP_DESCRIPTION)) {
                    javax.jcr.Node htmlNode = node.getNode(PROP_DESCRIPTION);
                    if (!htmlNode.isNodeType("hippostd:html")) {
                        throw new ContentNodeBindingException("Expected html node of type 'hippostd:html' but was '" + htmlNode.getPrimaryNodeType().getName() + "'");
                    }
                    htmlNode.setProperty("hippostd:content", getDescriptionContent());
                } else {
                    javax.jcr.Node html = node.addNode(PROP_DESCRIPTION, "hippostd:html");
                    html.setProperty("hippostd:content", html);
                }
            }
        } catch (RepositoryException e) {
            throw new ContentNodeBindingException(e);
        }

        return true;
    }

}
