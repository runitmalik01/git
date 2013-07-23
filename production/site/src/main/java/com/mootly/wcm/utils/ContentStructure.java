/**
 * Get the Member Folder
 * @param request
 * @return
 */

package com.mootly.wcm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.core.component.HstRequest;

public final class ContentStructure {

	final static String MEMBER_FOLDER_NAME = "members";
	final static String EMAILTEMPLATES_FOLDER_NAME = "emailtemplates";
	final static String VENDOR_FOLDER_NAME = "vendors";

	// it specify the path for the document in repository.
	public static String getMemberTdsFolder(HstRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_FOLDER_NAME).append("/filingYear").append("/ITR1");
		return builder.toString();
	}
	/** Create the path to Save memberasset Document in the Repository
	 */
	public static String getMemberAsset(HstRequest request) {

		StringBuilder builder = new StringBuilder();
		Date date = new Date();
		SimpleDateFormat simpleDateformat=new SimpleDateFormat("yyyy");
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_FOLDER_NAME).append("/").append("PANS").append("/").append("pan");
		builder.append("/").append(simpleDateformat.format(date)).append("/").append("Original");
		return builder.toString();
	}

	public static String getMemberSecurityDocPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/securities/securities");
		return builder.toString();
	}

	
	 
	 public static String getMemberAssetDocPath(String pan,String filing_year,String username) {
		  StringBuilder builder = new StringBuilder();
		  builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		  builder.append('/').append(pan.toLowerCase());
		  builder.append("/"+filing_year+"/original/capitalasset/capitalasset");
		  return builder.toString();
	 }
	 public static String getRebateSec90DocPath(String pan,String filing_year,String username) {
		  StringBuilder builder = new StringBuilder();
		  builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		  builder.append('/').append(pan.toLowerCase());
		  builder.append("/"+filing_year+"/original/rebatedocumentninety/rebatedocumentninety");
		  return builder.toString();
	 }
	 public static String getAdvanceAndSelfAssesmentDocPath(String pan,String filing_year,String username) {
		  StringBuilder builder = new StringBuilder();
		  builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		  builder.append('/').append(pan.toLowerCase());
		  builder.append("/"+filing_year+"/original/listadvanceandselfassesment/listadvanceandselfassesment");
		  return builder.toString();
	 }
	
	 public static String getTdsOthersDocPath(String pan,String filing_year,String username) {
		  StringBuilder builder = new StringBuilder();
		  builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		  builder.append('/').append(pan.toLowerCase());
		  builder.append("/"+filing_year+"/original/listtdsfromothers/listtdsfromothers");
		  return builder.toString();
	 }


	public static String getMemberSourceIncomePath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.replaceAll("@", "-at-").toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/sourceofincomedocument/sourceofincomedocument");
		return builder.toString();
	}

	public static String getAdvanceTaxDocPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/advancetaxinformation/advancetaxinformation");
		return builder.toString();
	}
	public static String getMembertdsotherDocPath(HstRequest request) {

		String path="/content/documents/mootlywcm/members/pans/pan/2013/original/tdsfromothersinfo/tdsfromothersinfo";

		return path;
	}


	public static String getMemberFolder(HstRequest request, String userName) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_FOLDER_NAME).append("/").append(userName);
		return builder.toString();
	} 
	
	public static String getVendorFolder(HstRequest request, String userName) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(VENDOR_FOLDER_NAME).append("/").append(userName);
		return builder.toString();
	} 


	/**
	 * here we are setting a path for storing salary income of employer in original/salaryincome/tan# 
	 * 
	 * @param HstRequest
	 * @return String returns path of repository where document is saved
	 * @throws 
	 * @author Abhishek
	 */
	public static String getMembersalarypathCreate(HstRequest request,String sTAN, String susername) {
		//StringBuilder builder = new StringBuilder();
		//get pan number from session
		String sPAN = (String)request.getSession().getAttribute("pan");
		if(null == sPAN){
			sPAN = "KKKKK1234A";
		}

		//get filling year from session
		String sFillingYear = (String)request.getSession().getAttribute("filling_year");
		if(null == sFillingYear){
			sFillingYear ="2012-2013";
		}

		String sOriginalPath = getMemberOriginalPath(request, sPAN,sFillingYear,susername);
		StringBuilder sbSalaryIncome = new StringBuilder(sOriginalPath);
		StringBuffer str = new StringBuffer (sOriginalPath );
		str.append("/salaryincome/").append(sTAN.toLowerCase());
		return str.toString();
	}

	/**
	 * here we are setting a path for fetching salary income of employer from original/salaryincome/ 
	 * 
	 * @param HstRequest
	 * @param String
	 * @return String returns path of repository from where document is to be fetched
	 * @throws 
	 * @author Abhishek
	 */

	public static String getMemberSalaryPathFetch(HstRequest request,String sUserName) {
		// StringBuilder builder = new StringBuilder();
		//get pan number from session
		String sPAN = (String)request.getSession().getAttribute("pan");
		if(null == sPAN){
			sPAN = "abcdb1234a";
		}
		//get filling year from session
		String sFillingYear = (String)request.getSession().getAttribute("filling_year");
		if(null == sFillingYear){
			sFillingYear ="2012-2013";
		}

		String sOriginalPath = getMemberOriginalPath(request, sPAN,sFillingYear,sUserName);

		// StringBuilder sbSalaryIncome = new StringBuilder(sOriginalPath);

		StringBuffer strnew = new StringBuffer (sOriginalPath );
		strnew.append("/salaryincomedocument/salaryincomedocument");
		return strnew.toString();
	}
	
	public static String getMemberSalaryPathFetchInterest(HstRequest request,String sUserName,String sPAN,String sFillingYear) {
		// StringBuilder builder = new StringBuilder();
	
		String sOriginalPath = getMemberOriginalPath(request, sPAN,sFillingYear,sUserName);

		// StringBuilder sbSalaryIncome = new StringBuilder(sOriginalPath);

		StringBuffer strnew = new StringBuffer (sOriginalPath );
		strnew.append("/salaryincomedocument/salaryincomedocument");
		return strnew.toString();
	}
	public static String getTdsSalaryDocPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/tdsfromsalaryinformation/tdsfromsalaryinformation");
		return builder.toString();
	}
	public static String getTcsDocPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/tcsdocument/tcsdocument");
		return builder.toString();
	}
	
	public static String getAdvanceTaxcPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/advancetaxdocument/advancetaxdocument");
		return builder.toString();
	}


	/**
	 * here we are setting a path for updating salary income of employer in original/salaryincome/tan# 
	 * 
	 * @param HstRequest
	 * @param String
	 * @param String
	 * @return String returns path of repository where document is to be updated
	 * @throws 
	 * @author Abhishek
	 */

	public static String getMemberSalaryPathUpdate(HstRequest request,String sTAN,String sUserName) {
		// StringBuilder builder = new StringBuilder();
		//get pan number from session
		String sPAN = (String)request.getSession().getAttribute("pan");
		if(null == sPAN){
			sPAN = "KKKKK1234A";
		}
		//get filling year from session
		String sFillingYear = (String)request.getSession().getAttribute("filling_year");
		if(null == sFillingYear){
			sFillingYear ="2012-2013";
		}
		System.out.println("in update structure:-"+sTAN);

		String sOriginalPath = getMemberOriginalPath(request, sPAN,sFillingYear,sUserName);

		System.out.println("in update structure:-"+sOriginalPath);


		// StringBuilder sbSalaryIncome = new StringBuilder(sOriginalPath);

		StringBuffer strnew = new StringBuffer (sOriginalPath );
		strnew.append("/salaryincome/").append(sTAN.toLowerCase()).append("/salaryincomedocument/salaryincomedocument");
		return strnew.toString();
	}

	// path for other income documents
	/**
	 * here we are setting a path for creating other income of employer in original/otherincome/
	 * 
	 * @param HstRequest
	 * @param String
	 * @param String
	 * @return String returns path of repository where document is to be updated
	 * @throws 
	 * @author Abhishek
	 */
	public static String getMemberotherincomepath(HstRequest request,String username) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		String pan = (String)request.getSession().getAttribute("pan");
		if(null == pan){
			pan = "KKKKK1234A";
		}
		String sFillingYear = (String)request.getSession().getAttribute("filling_year");
		if(null == sFillingYear){
			sFillingYear ="2012-2013";
		}
		System.out.println(pan+"i m in otherincome path:-----------"+sFillingYear);
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.replaceAll("@", "-at-")+"/pans");
		builder.append('/').append(pan.toLowerCase()).append('/').append(sFillingYear);
		builder.append("/original/otherincome");
		System.out.println("i m in otherincome path:-----------"+builder.toString());
		return builder.toString();

	}
	/**
	 * here we are setting a path for fetching other income of employer in original/otherincome/
	 * 
	 * @param HstRequest
	 * @param String
	 * @param String
	 * @return String returns path of repository where document is to be updated
	 * @throws 
	 * @author Abhishek
	 */
	public static String getotherincomePathFetch(HstRequest request,String username) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		String pan = (String)request.getSession().getAttribute("pan");
		if(null == pan){
			pan = "KKKKK1234A";
		}
		String sFillingYear = (String)request.getSession().getAttribute("filling_year");
		if(null == sFillingYear)
		{
			sFillingYear ="2012-2013";
		}
		String sOriginalPath = getMemberOriginalPath(request, pan,sFillingYear,username);
		// StringBuilder sbSalaryIncome = new StringBuilder(sOriginalPath);
		StringBuffer strnew = new StringBuffer (sOriginalPath );
		strnew.append("/otherincome");
		return strnew.toString();
	}


	/**
	 * here we are setting a path for updating salary income of employer in original/salaryincome/tan# 
	 * 
	 * @param HstRequest
	 * @param String
	 * @param String
	 * @return String returns path of repository where document is to be updated
	 * @throws 
	 * @author Abhishek
	 */

	public static String getOtherIncomePathUpdate(HstRequest request,String sUserName,String pan, String filing_year) {
		// StringBuilder builder = new StringBuilder();
		//get pan number from session
		String sOriginalPath = getMemberOriginalPath(request, pan,filing_year,sUserName);
		System.out.println("in update structure:-"+sOriginalPath);
		// StringBuilder sbSalaryIncome = new StringBuilder(sOriginalPath);
		StringBuffer strnew = new StringBuffer (sOriginalPath );
		strnew.append("/othersourcesdocument/othersourcesdocument");
		return strnew.toString();
	}

	public static String getOtherIncomePathUpdateInterest(HstRequest request,String sUserName,String sPAN,String sFillingYear) {
		// StringBuilder builder = new StringBuilder();
	
		String sOriginalPath = getMemberOriginalPath(request, sPAN,sFillingYear,sUserName);
		System.out.println("in update structure:-"+sOriginalPath);
		// StringBuilder sbSalaryIncome = new StringBuilder(sOriginalPath);
		StringBuffer strnew = new StringBuffer (sOriginalPath );
		strnew.append("/othersourceincome/othersourceincome");
		return strnew.toString();
	}


	// Path for source of income for fetching data
	public static String getMembersourceincomeDocPath() {
		String path="/content/documents/mootlywcm/members/sourceincome/sourceofincomedocument/sourceofincomedocument";
		return path;
	}

	public static String getSignUpDocumentPath(String userName) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members");
		builder.append('/').append(userName);
		builder.append("/membersignupdocument/membersignupdocument");
		return builder.toString();
	}

	public static String getMemberForgotpass(HstRequest request,String username) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		//builder.append(MEMBER_FOLDER_NAME);
		builder.append(MEMBER_FOLDER_NAME).append('/').append(username.replaceAll("@", "-at-")).append("/forgotpass");
		return builder.toString();
	}

	public static String getMemberActivationCode(HstRequest request) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_FOLDER_NAME);
		return builder.toString();
	}
	public static String getPersonalDocumentPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/memberpersonalinformation/memberpersonalinformation");
		return builder.toString();
	}
	public static String getSchedule80GGDocumentPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/memberdeductionschedulegg/memberdeductionschedulegg");
		return builder.toString();
	}
	public static String getSchedule80CDocumentPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/memberdeductionschedulec/memberdeductionschedulec");
		return builder.toString();
	}
	public static String getScheduleVIADocumentPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/memberdeductionschedulevia/memberdeductionschedulevia");
		return builder.toString();
	}
	public static String getSchedule80IADocumentPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/memberdeductionscheduleia/memberdeductionscheduleia");
		return builder.toString();
	}
	public static String getRebateSection89(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/memberrebatesectioneightynine/memberrebatesectioneightynine");
		return builder.toString();
	}
	public static String getSchedule80IBDocumentPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/memberdeductionscheduleib/memberdeductionscheduleib");
		return builder.toString();
	}
	public static String getSchedule80ICDocumentPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/memberdeductionscheduleic/memberdeductionscheduleic");
		return builder.toString();
	}
	public static String getSchedule80GDocumentPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/memberdeductionscheduleg/memberdeductionscheduleg");
		return builder.toString();
	}
	public static String getContactDocumentPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/contactinformation/contactinformation");
		return builder.toString();
	}
	public static String getBankDetailDocumentPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/memberbankdetail/memberbankdetail");
		return builder.toString();
	}
	public static String getChangePasswordRequest(HstRequest request,String username) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_FOLDER_NAME).append('/').append(username.replaceAll("@", "-at-")).append("/changeprofile");
		return builder.toString();
	}


	public static String getMemberContactUs(HstRequest request) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_FOLDER_NAME);
		return builder.toString();
	}

	/**
	 * Get the Member Folder
	 * @param request
	 * @return
	 */
	public static String getMemberPersonalFolder(HstRequest request, String pan,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_FOLDER_NAME).append("/").append(username.toLowerCase()).append("/").append("PANS").append("/").append(pan.toLowerCase());
		return builder.toString();
	}

	//path for houseincome

	public static String getHousePropertyDocPath(String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase()+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/houseincome/houseincome");
		return builder.toString();
	}

	/**
	 * here we are setting a path for fetching original path for salaryincome and otherincome
	 * 
	 * @param HstRequest
	 * @param String
	 * @param String
	 * @return String returns path of repository where document is to be updated
	 * @throws 
	 * @author Abhishek
	 */
	public static String getMemberOriginalPath(HstRequest request, String pan,String filing_year,String username) {

		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_FOLDER_NAME).append("/").append(username.replaceAll("@", "-at-")).append("/").append("pans").append("/").append(pan.toLowerCase());
		builder.append("/").append(filing_year).append("/").append("original");
		return builder.toString();
	}

	public static String getMemberOriginalFilingPath(HstRequest request, String pan,String filing_year,String username) {
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_FOLDER_NAME).append("/").append(username.replaceAll("@", "-at-")).append("/").append("pans").append("/").append(pan);
		builder.append("/").append(filing_year).append("/").append("original");
		return builder.toString();
	}



	// To define path for ContactUs Formn details of registered user.
	public static String getContactUsFolder(HstRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(MEMBER_FOLDER_NAME).append("/").append("Contactus");
		return builder.toString();
	}
	//To define path for ContactUs Formn details of non-registered user.
	public static String getContactUsFolderNonReg(HstRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append("Contactus");
		return builder.toString();
	}

	/**
	 * here we are setting a path for creating interest document in original
	 * @param String filing_year
	 * @param String pan
	 * @param String user name 
	 * @author Dhananjay
	 */
	public static String getinterestdocumentpath(String pan,String filing_year,String username) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase().replaceAll("@","-at-")+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original");
		return builder.toString();
	}


	/**
	 * here we are setting a path for fetching interest document in original
	 * @param String filing_year
	 * @param String pan
	 * @param String user name 
	 * @author Dhananjay
	 */
	public static String getinterestdocumentfetch(String pan,String filing_year,String username) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase().replaceAll("@","-at-")+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/interestdocument/interestdocument");
		return builder.toString();
	}
	
	/**
	 * here we are setting a path for creating adjustment of losses document in original
	 * @param String filing_year
	 * @param String pan
	 * @param String user name 
	 * @param String sAssessmentYear 
	 * @param String sNameOfHead
	 * @author Dhananjay
	 */
	public static String getMemberadjustmentlossescreate(String pan,String filing_year,String username,String sAssessmentYear,String sNameOfHead) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase().replaceAll("@","-at-")+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/losses/"+sAssessmentYear.toLowerCase().replaceAll(" ", "-")+sNameOfHead.toLowerCase().replaceAll(" ", "-"));
		return builder.toString();
	}
	/**
	 * here we are setting a path for updating adjustment of losses document in original
	 * @param String filing_year
	 * @param String pan
	 * @param String user name 
	 * @param String sAssessmentYear 
	 * @param String sNameOfHead
	 * @author Dhananjay
	 */
	
	public static String getMemberadjustmentlossesupdate(String pan,String filing_year,String username,String sAssessmentYear,String sNameOfHead) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase().replaceAll("@","-at-")+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/losses/"+sAssessmentYear.toLowerCase().replaceAll(" ", "-")+sNameOfHead.toLowerCase().replaceAll(" ", "-")+"/adjustmentoflosses/adjustmentoflosses");
		return builder.toString();
	}
	/**
	 * here we are setting a path for checking no. of nodes inside losses
	 * @param String filing_year
	 * @param String pan
	 * @param String user name 
	 * @author Dhananjay
	 */
	public static String getMemberadjustmentlossesnodepath(String pan,String filing_year,String username) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase().replaceAll("@","-at-")+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/losses");
		return builder.toString();
	}

	/**
	 * here we are setting a path for fetching adjustment of losses document in original
	 * @param String filing_year
	 * @param String pan
	 * @param String user name 
	 * @param String snode
	 * @author Dhananjay
	 */
	public static String getMemberadjustmentlossesfetch(String pan,String filing_year,String username,String snode) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append("/content/documents/mootlywcm/members/"+username.toLowerCase().replaceAll("@","-at-")+"/pans");
		builder.append('/').append(pan.toLowerCase());
		builder.append("/"+filing_year+"/original/losses/"+snode+"/adjustmentoflosses/adjustmentoflosses");
		return builder.toString();
	}

	public static String getEmailTemplatesPath(HstRequest request) {
		//String md5UserName = org.apache.commons.codec.digest.DigestUtils.md5He(angry) userName );
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append('/');
		builder.append(EMAILTEMPLATES_FOLDER_NAME);
		return builder.toString();
	}


	public static Node getEmailServiceConfigurationNode(HstRequest request,Session session) throws RepositoryException {
		StringBuilder builder = new StringBuilder();
		builder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
		builder.append("/serviceconfigurations/emailserviceconfiguration");
		Node aNode = session.getNode(builder.toString());
		return aNode;
	}
}

