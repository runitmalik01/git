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

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;

/*

[mootlywcm:restapi] > mootlywcm:basedocument
- mootlywcm:type (string)
- mootlywcm:summary (string)
+ mootlywcm:documentation (hippostd:html)
- mootlywcm:url (string)
- mootlywcm:response (string)
- mootlywcm:path (string)

*/
@Node(jcrType = "mootlywcm:restapi")
public class RestApi extends BaseDocument {

    private String path;

    private String type;
    private String summary;
    private HippoHtml documentation;
    private String url;
    private String response;


    public String getApiPath() {
        return (path == null) ? (String) getProperty("mootlywcm:path") : path;
    }

    public String getType() {
        return (type == null) ? (String) getProperty("mootlywcm:type") : type;
    }

    public String getSummary() {
        return (summary == null) ? (String) getProperty("mootlywcm:summary") : summary;
    }

    public HippoHtml getDocumentation() {
        if (documentation ==null){
            documentation  =  getBean("mootlywcm:documentation");
        }
        return documentation ;
    }

    public String getUrl() {
        return (url == null) ? (String) getProperty("mootlywcm:url") : url;
    }

    public String getResponse() {
        return (response == null) ? (String) getProperty("mootlywcm:response") : response;
    }

}
