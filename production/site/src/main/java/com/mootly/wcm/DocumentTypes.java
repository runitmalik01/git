package com.mootly.wcm;


/**
 * Contains constants for all names of node types and properties.
 */
public class DocumentTypes {

    private DocumentTypes() {
        // prevent instantiation
    }

    public static final String IMAGE_SET = "mootlywcmgallery:imageset";

    public static final class ImageSet {
        public static final String ALT = "mootlywcmgallery:alt";
        public static final String COPYRIGHT = "mootlywcmgallery:copyright";
        public static final String EXTRA_LARGE_THUMBNAIL = "mootlywcmgallery:extralargethumbnail";
        public static final String LARGE_THUMBNAIL = "mootlywcmgallery:largethumbnail";
        public static final String MOBILE_LOGO = "mootlywcmgallery:mobilelogo";
        public static final String MOBILE_THUMBNAIL = "mootlywcmgallery:mobilethumbnail";
        public static final String SMALL_THUMBNAIL = "mootlywcmgallery:smallthumbnail";
    }

}
