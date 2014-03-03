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
import org.hippoecm.hst.content.beans.standard.HippoDocument;


/**
 * [mootlywcm:banner] > mootlywcm:basedocument
 * - mootlywcm:title (string)
 * + mootlywcm:image (hippogallerypicker:imagelink)
 * + mootlywcm:doclink (hippo:mirror)
 */
/*
 * [hippolog:item] > nt:base
  - hippolog:eventUser (string) mandatory
  - hippolog:eventClass (string) mandatory
  - hippolog:eventReturnValue (string)
  - hippolog:eventReturnType (string)
  - hippolog:eventDocument (string)
  - hippolog:eventArguments (string) multiple
  - hippolog:eventMethod (string) mandatory
  - hippolog:timestamp (long) mandatory
 */
@Node(jcrType = "hippolog:item")
public class HippoLogItem extends HippoDocument {

	String eventUser;
	String eventClass;
	public String getEventUser() {
		return eventUser;
	}
	public void setEventUser(String eventUser) {
		this.eventUser = eventUser;
	}
	public String getEventClass() {
		return eventClass;
	}
	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
	}
}
