package com.mootly.wcm.citruspay;


import com.mootly.wcm.services.SequenceGenerator;

public class MockSequenceGenerator implements SequenceGenerator{
	@Override
	public Long getNextId(String sequenceName) {
		// TODO Auto-generated method stub
		return System.currentTimeMillis();
	}
}
