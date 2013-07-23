package com.mootly.wcm.beans;

import org.hippoecm.hst.content.beans.standard.HippoBean;

public interface CompoundChildUpdate {
	void update(HippoBean child);
	void delete(HippoBean child);
	void add(HippoBean child);
}
