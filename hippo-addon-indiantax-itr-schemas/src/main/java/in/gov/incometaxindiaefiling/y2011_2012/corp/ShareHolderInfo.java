//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.25 at 06:06:29 PM PDT 
//


package in.gov.incometaxindiaefiling.y2011_2012.corp;

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
 *         &lt;element name="ShareHolderInfoName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="75"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}AddressDetail"/>
 *         &lt;element name="PercentageOfShare">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;minInclusive value="10"/>
 *               &lt;maxInclusive value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ShareHolderPAN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="10"/>
 *               &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
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
    "shareHolderInfoName",
    "addressDetail",
    "percentageOfShare",
    "shareHolderPAN"
})
@XmlRootElement(name = "ShareHolderInfo")
public class ShareHolderInfo {

    @XmlElement(name = "ShareHolderInfoName", required = true)
    protected String shareHolderInfoName;
    @XmlElement(name = "AddressDetail", required = true)
    protected AddressDetail addressDetail;
    @XmlElement(name = "PercentageOfShare")
    protected double percentageOfShare;
    @XmlElement(name = "ShareHolderPAN")
    protected String shareHolderPAN;

    /**
     * Gets the value of the shareHolderInfoName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShareHolderInfoName() {
        return shareHolderInfoName;
    }

    /**
     * Sets the value of the shareHolderInfoName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareHolderInfoName(String value) {
        this.shareHolderInfoName = value;
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
     * Gets the value of the percentageOfShare property.
     * 
     */
    public double getPercentageOfShare() {
        return percentageOfShare;
    }

    /**
     * Sets the value of the percentageOfShare property.
     * 
     */
    public void setPercentageOfShare(double value) {
        this.percentageOfShare = value;
    }

    /**
     * Gets the value of the shareHolderPAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShareHolderPAN() {
        return shareHolderPAN;
    }

    /**
     * Sets the value of the shareHolderPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareHolderPAN(String value) {
        this.shareHolderPAN = value;
    }

}
