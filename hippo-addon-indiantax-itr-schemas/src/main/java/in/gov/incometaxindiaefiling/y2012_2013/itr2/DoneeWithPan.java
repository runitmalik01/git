//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.11 at 12:34:28 PM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013.itr2;

import java.math.BigInteger;
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
 *         &lt;element name="DoneeWithPanName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DoneePAN">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="10"/>
 *               &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}AddressDetail"/>
 *         &lt;element name="DonationAmt">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EligibleDonationAmt">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
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
    "doneeWithPanName",
    "doneePAN",
    "addressDetail",
    "donationAmt",
    "eligibleDonationAmt"
})
@XmlRootElement(name = "DoneeWithPan")
public class DoneeWithPan {

    @XmlElement(name = "DoneeWithPanName", required = true)
    protected String doneeWithPanName;
    @XmlElement(name = "DoneePAN", required = true)
    protected String doneePAN;
    @XmlElement(name = "AddressDetail", required = true)
    protected AddressDetail addressDetail;
    @XmlElement(name = "DonationAmt", required = true, defaultValue = "0")
    protected BigInteger donationAmt;
    @XmlElement(name = "EligibleDonationAmt", required = true, defaultValue = "0")
    protected BigInteger eligibleDonationAmt;

    /**
     * Gets the value of the doneeWithPanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoneeWithPanName() {
        return doneeWithPanName;
    }

    /**
     * Sets the value of the doneeWithPanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoneeWithPanName(String value) {
        this.doneeWithPanName = value;
    }

    /**
     * Gets the value of the doneePAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoneePAN() {
        return doneePAN;
    }

    /**
     * Sets the value of the doneePAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoneePAN(String value) {
        this.doneePAN = value;
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
     * Gets the value of the donationAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDonationAmt() {
        return donationAmt;
    }

    /**
     * Sets the value of the donationAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDonationAmt(BigInteger value) {
        this.donationAmt = value;
    }

    /**
     * Gets the value of the eligibleDonationAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEligibleDonationAmt() {
        return eligibleDonationAmt;
    }

    /**
     * Sets the value of the eligibleDonationAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEligibleDonationAmt(BigInteger value) {
        this.eligibleDonationAmt = value;
    }

}
