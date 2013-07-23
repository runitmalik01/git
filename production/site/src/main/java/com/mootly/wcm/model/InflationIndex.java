package com.mootly.wcm.model;
 public enum InflationIndex{
	
	valueList_1981("100","01/04/1981-31/03/1982"),
	valueList_1982("109","01/04/1982-31/03/1983"),
	valueList_1983("116","01/04/1983-31/03/1984"),
	valueList_1984("125","01/04/1984-31/03/1985"),
	valueList_1985("133","01/04/1985-31/03/1986"),
	valueList_1986("140","01/04/1986-31/03/1987"),
	valueList_1987("150","01/04/1987-31/03/1988"),
	valueList_1988("161","01/04/1988-31/03/1989"),
	valueList_1989("172","01/04/1989-31/03/1990"),
	valueList_1990("182","01/04/1990-31/03/1991"),
	valueList_1991("199","01/04/1991-31/03/1992"),
	valueList_1992("233","01/04/1992-31/03/1993"),
	valueList_1993("244","01/04/1993-31/03/1994"),
	valueList_1994("259","01/04/1994-31/03/1995"),
	valueList_1995("281","01/04/1995-31/03/1996"),
	valueList_1996("305","01/04/1996-31/03/1997"),
	valueList_1997("331","01/04/1997-31/03/1998"),
	valueList_1998("351","01/04/1998-31/03/1999"),
	valueList_1999("389","01/04/1999-31/03/2000"),
	valueList_2000("406","01/04/2000-31/03/2001"),
	valueList_2001("426","01/04/2001-31/03/2002"),
	valueList_2002("447","01/04/2002-31/03/2003"),
	valueList_2003("463","01/04/2003-31/03/2004"),
	valueList_2004("480","01/04/2004-31/03/2005"),
	valueList_2005("497","01/04/2005-31/03/2006"),
	valueList_2006("519","01/04/2006-31/03/2007"),
	valueList_2007("551","01/04/2007-31/03/2008"),
	valueList_2008("582","01/04/2008-31/03/2009"),
	valueList_2009("632","01/04/2009-31/03/2010"),
	valueList_2010("711","01/04/2010-31/03/2011"),
	valueList_2011("785","01/04/2011-31/03/2012"),
	valueList_2012("852","01/04/2012-31/03/2013"),
	UNKNOWN;
	
	String xmlCode;
	String desc;
	
	private InflationIndex() {
	}
	
	private InflationIndex(String xmlCode) {
		this.xmlCode = xmlCode;
	}
	
	private InflationIndex(String xmlCode,String desc) {
		this.xmlCode = xmlCode;
		this.desc = desc;
	}
	public String getdisplayString() {
		if (desc == null) {
			return toString();
		}
		else {
			return this.desc;
		}
	}
	public String getXmlCode(){
		return xmlCode;
	}
}
