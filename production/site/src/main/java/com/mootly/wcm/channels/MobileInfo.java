/**
 * Copyright (C) 2011 Hippo B.V.
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
package com.mootly.wcm.channels;

import org.hippoecm.hst.configuration.channel.ChannelInfo;
import org.hippoecm.hst.core.parameters.FieldGroup;
import org.hippoecm.hst.core.parameters.FieldGroupList;
import org.hippoecm.hst.core.parameters.JcrPath;
import org.hippoecm.hst.core.parameters.Parameter;

import com.mootly.wcm.DocumentTypes;

/**
 * Retrieves the properties of the GoGreen channels.
 */
@FieldGroupList({
        @FieldGroup(
                titleKey = "fields.channel",
                value = { "logo", "pageTitlePrefix" }
        )
})
public interface MobileInfo extends ChannelInfo {

    @Parameter(name = "logo", displayName = "Logo")
    @JcrPath(
            pickerSelectableNodeTypes = { DocumentTypes.IMAGE_SET },
            pickerInitialPath = "/content/gallery/logos"
    )
    String getLogoPath();

    @Parameter(name = "pageTitlePrefix", displayName = "Page title prefix", defaultValue = "Mootly WCM")
    String getPageTitlePrefix();

}
