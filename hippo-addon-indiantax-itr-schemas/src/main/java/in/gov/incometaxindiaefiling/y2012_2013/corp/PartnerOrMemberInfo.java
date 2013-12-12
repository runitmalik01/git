
package in.gov.incometaxindiaefiling.y2012_2013.corp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="PartnerForeignCompFlg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="YES"/>
 *               &lt;enumeration value="NO"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PercentageOfShareForeignComp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotIncFrmMemberOfAop" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="Y|N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PartnerOrMemberName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="75"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}AddressDetail"/>
 *         &lt;element name="PAN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="10"/>
 *               &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SharePercentage">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;maxInclusive value="100"/>
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
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
    "partnerForeignCompFlg",
    "percentageOfShareForeignComp",
    "totIncFrmMemberOfAop",
    "partnerOrMemberName",
    "addressDetail",
    "pan",
    "sharePercentage",
    "status"
})
@XmlRootElement(name = "PartnerOrMemberInfo")
public class PartnerOrMemberInfo {

    @XmlElement(name = "PartnerForeignCompFlg", required = true)
    protected String partnerForeignCompFlg;
    @XmlElement(name = "PercentageOfShareForeignComp")
    protected double percentageOfShareForeignComp;
    @XmlElement(name = "TotIncFrmMemberOfAop")
    protected String totIncFrmMemberOfAop;
    @XmlElement(name = "PartnerOrMemberName", required = true)
    protected String partnerOrMemberName;
    @XmlElement(name = "AddressDetail", required = true)
    protected AddressDetail addressDetail;
    @XmlElement(name = "PAN")
    protected String pan;
    @XmlElement(name = "SharePercentage")
    protected double sharePercentage;
    @XmlElement(name = "Status", required = true)
    protected String status;

    /**
     * Gets the value of the partnerForeignCompFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerForeignCompFlg() {
        return partnerForeignCompFlg;
    }

    /**
     * Sets the value of the partnerForeignCompFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerForeignCompFlg(String value) {
        this.partnerForeignCompFlg = value;
    }

    /**
     * Gets the value of the percentageOfShareForeignComp property.
     * 
     */
    public double getPercentageOfShareForeignComp() {
        return percentageOfShareForeignComp;
    }

    /**
     * Sets the value of the percentageOfShareForeignComp property.
     * 
     */
    public void setPercentageOfShareForeignComp(double value) {
        this.percentageOfShareForeignComp = value;
    }

    /**
     * Gets the value of the totIncFrmMemberOfAop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotIncFrmMemberOfAop() {
        return totIncFrmMemberOfAop;
    }

    /**
     * Sets the value of the totIncFrmMemberOfAop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotIncFrmMemberOfAop(String value) {
        this.totIncFrmMemberOfAop = value;
    }

    /**
     * Gets the value of the partnerOrMemberName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerOrMemberName() {
        return partnerOrMemberName;
    }

    /**
     * Sets the value of the partnerOrMemberName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerOrMemberName(String value) {
        this.partnerOrMemberName = value;
    }

    /**
     * Gets the value of the addressDetail property.
     * 
     * @return
     *     possible object is
     *     {@link AddressDetail }
     *     
     */
    public AddressDetail getAddressDetail() {
        return addressDetail;
    }

    /**
     * Sets the value of the addressDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressDetail }
     *     
     */
    public void setAddressDetail(AddressDetail value) {
        this.addressDetail = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the sharePercentage property.
     * 
     */
    public double getSharePercentage() {
        return sharePercentage;
    }

    /**
     * Sets the value of the sharePercentage property.
     * 
     */
    public void setSharePercentage(double value) {
        this.sharePercentage = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
