
package in.gov.incometaxindiaefiling.y2012_2013.corp;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReturnFileSec">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IncomeTaxSec">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *                         &lt;totalDigits value="2"/>
 *                         &lt;enumeration value="11"/>
 *                         &lt;enumeration value="12"/>
 *                         &lt;enumeration value="13"/>
 *                         &lt;enumeration value="14"/>
 *                         &lt;enumeration value="15"/>
 *                         &lt;enumeration value="16"/>
 *                         &lt;enumeration value="17"/>
 *                         &lt;enumeration value="18"/>
 *                         &lt;enumeration value="19"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AckNoOriginalReturn" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="NoticeNo" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="23"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="NoticeDate" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *                         &lt;minInclusive value="2013-04-01"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DesigTaxOfficeInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DesigOfficerWardorCircle">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="75"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ReturnType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *               &lt;enumeration value="O"/>
 *               &lt;enumeration value="R"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReceiptNo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OrigRetFiledDate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="2013-04-01"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ResidentialStatus">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *               &lt;enumeration value="RES"/>
 *               &lt;enumeration value="NRI"/>
 *               &lt;enumeration value="NOR"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ClaimUS9090A91Flg" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="YES"/>
 *               &lt;enumeration value="NO"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NRI_PE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AsseseeRepFlg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="Y"/>
 *               &lt;enumeration value="N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}AssesseeRep" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "returnFileSec",
    "desigTaxOfficeInfo",
    "returnType",
    "receiptNo",
    "origRetFiledDate",
    "residentialStatus",
    "claimUS9090A91Flg",
    "nripe",
    "asseseeRepFlg",
    "assesseeRep"
})
@XmlRootElement(name = "FilingStatus")
public class FilingStatus {

    @XmlElement(name = "ReturnFileSec", required = true)
    protected FilingStatus.ReturnFileSec returnFileSec;
    @XmlElement(name = "DesigTaxOfficeInfo", required = true)
    protected FilingStatus.DesigTaxOfficeInfo desigTaxOfficeInfo;
    @XmlElement(name = "ReturnType", required = true, defaultValue = "O")
    protected String returnType;
    @XmlElement(name = "ReceiptNo")
    protected BigInteger receiptNo;
    @XmlElement(name = "OrigRetFiledDate")
    protected XMLGregorianCalendar origRetFiledDate;
    @XmlElement(name = "ResidentialStatus", required = true, defaultValue = "RES")
    protected String residentialStatus;
    @XmlElement(name = "ClaimUS9090A91Flg")
    protected String claimUS9090A91Flg;
    @XmlElement(name = "NRI_PE")
    protected String nripe;
    @XmlElement(name = "AsseseeRepFlg", required = true, defaultValue = "N")
    protected String asseseeRepFlg;
    @XmlElement(name = "AssesseeRep")
    protected AssesseeRep assesseeRep;

    /**
     * Gets the value of the returnFileSec property.
     * 
     * @return
     *     possible object is
     *     {@link FilingStatus.ReturnFileSec }
     *     
     */
    public FilingStatus.ReturnFileSec getReturnFileSec() {
        return returnFileSec;
    }

    /**
     * Sets the value of the returnFileSec property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingStatus.ReturnFileSec }
     *     
     */
    public void setReturnFileSec(FilingStatus.ReturnFileSec value) {
        this.returnFileSec = value;
    }

    /**
     * Gets the value of the desigTaxOfficeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FilingStatus.DesigTaxOfficeInfo }
     *     
     */
    public FilingStatus.DesigTaxOfficeInfo getDesigTaxOfficeInfo() {
        return desigTaxOfficeInfo;
    }

    /**
     * Sets the value of the desigTaxOfficeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingStatus.DesigTaxOfficeInfo }
     *     
     */
    public void setDesigTaxOfficeInfo(FilingStatus.DesigTaxOfficeInfo value) {
        this.desigTaxOfficeInfo = value;
    }

    /**
     * Gets the value of the returnType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     * Sets the value of the returnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnType(String value) {
        this.returnType = value;
    }

    /**
     * Gets the value of the receiptNo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReceiptNo() {
        return receiptNo;
    }

    /**
     * Sets the value of the receiptNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReceiptNo(BigInteger value) {
        this.receiptNo = value;
    }

    /**
     * Gets the value of the origRetFiledDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrigRetFiledDate() {
        return origRetFiledDate;
    }

    /**
     * Sets the value of the origRetFiledDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrigRetFiledDate(XMLGregorianCalendar value) {
        this.origRetFiledDate = value;
    }

    /**
     * Gets the value of the residentialStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidentialStatus() {
        return residentialStatus;
    }

    /**
     * Sets the value of the residentialStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidentialStatus(String value) {
        this.residentialStatus = value;
    }

    /**
     * Gets the value of the claimUS9090A91Flg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimUS9090A91Flg() {
        return claimUS9090A91Flg;
    }

    /**
     * Sets the value of the claimUS9090A91Flg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimUS9090A91Flg(String value) {
        this.claimUS9090A91Flg = value;
    }

    /**
     * Gets the value of the nripe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRIPE() {
        return nripe;
    }

    /**
     * Sets the value of the nripe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRIPE(String value) {
        this.nripe = value;
    }

    /**
     * Gets the value of the asseseeRepFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsseseeRepFlg() {
        return asseseeRepFlg;
    }

    /**
     * Sets the value of the asseseeRepFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsseseeRepFlg(String value) {
        this.asseseeRepFlg = value;
    }

    /**
     * Gets the value of the assesseeRep property.
     * 
     * @return
     *     possible object is
     *     {@link AssesseeRep }
     *     
     */
    public AssesseeRep getAssesseeRep() {
        return assesseeRep;
    }

    /**
     * Sets the value of the assesseeRep property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssesseeRep }
     *     
     */
    public void setAssesseeRep(AssesseeRep value) {
        this.assesseeRep = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DesigOfficerWardorCircle">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="75"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "desigOfficerWardorCircle"
    })
    public static class DesigTaxOfficeInfo {

        @XmlElement(name = "DesigOfficerWardorCircle", required = true)
        protected String desigOfficerWardorCircle;

        /**
         * Gets the value of the desigOfficerWardorCircle property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDesigOfficerWardorCircle() {
            return desigOfficerWardorCircle;
        }

        /**
         * Sets the value of the desigOfficerWardorCircle property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDesigOfficerWardorCircle(String value) {
            this.desigOfficerWardorCircle = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="IncomeTaxSec">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
     *               &lt;totalDigits value="2"/>
     *               &lt;enumeration value="11"/>
     *               &lt;enumeration value="12"/>
     *               &lt;enumeration value="13"/>
     *               &lt;enumeration value="14"/>
     *               &lt;enumeration value="15"/>
     *               &lt;enumeration value="16"/>
     *               &lt;enumeration value="17"/>
     *               &lt;enumeration value="18"/>
     *               &lt;enumeration value="19"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AckNoOriginalReturn" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="15"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="NoticeNo" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="23"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="NoticeDate" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
     *               &lt;minInclusive value="2013-04-01"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "incomeTaxSec",
        "ackNoOriginalReturn",
        "noticeNo",
        "noticeDate"
    })
    public static class ReturnFileSec {

        @XmlElement(name = "IncomeTaxSec", defaultValue = "11")
        protected long incomeTaxSec;
        @XmlElement(name = "AckNoOriginalReturn")
        protected BigInteger ackNoOriginalReturn;
        @XmlElement(name = "NoticeNo")
        protected String noticeNo;
        @XmlElement(name = "NoticeDate")
        protected XMLGregorianCalendar noticeDate;

        /**
         * Gets the value of the incomeTaxSec property.
         * 
         */
        public long getIncomeTaxSec() {
            return incomeTaxSec;
        }

        /**
         * Sets the value of the incomeTaxSec property.
         * 
         */
        public void setIncomeTaxSec(long value) {
            this.incomeTaxSec = value;
        }

        /**
         * Gets the value of the ackNoOriginalReturn property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAckNoOriginalReturn() {
            return ackNoOriginalReturn;
        }

        /**
         * Sets the value of the ackNoOriginalReturn property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAckNoOriginalReturn(BigInteger value) {
            this.ackNoOriginalReturn = value;
        }

        /**
         * Gets the value of the noticeNo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNoticeNo() {
            return noticeNo;
        }

        /**
         * Sets the value of the noticeNo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNoticeNo(String value) {
            this.noticeNo = value;
        }

        /**
         * Gets the value of the noticeDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getNoticeDate() {
            return noticeDate;
        }

        /**
         * Sets the value of the noticeDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setNoticeDate(XMLGregorianCalendar value) {
            this.noticeDate = value;
        }

    }

}
