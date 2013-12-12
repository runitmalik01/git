
package in.gov.incometaxindiaefiling.y2012_2013.corp;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="HPSNo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}AddressDetail"/>
 *         &lt;element name="PropCoOwnedFlg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="YES"/>
 *               &lt;enumeration value="NO"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AssessePercentShareProp" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}CoOwners" maxOccurs="5" minOccurs="0"/>
 *         &lt;element name="ifLetOut">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *               &lt;enumeration value="Y"/>
 *               &lt;enumeration value="N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NameofTenant" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="75"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PANofTenant" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *               &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}Rentdetails"/>
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
    "hpsNo",
    "addressDetail",
    "propCoOwnedFlg",
    "assessePercentShareProp",
    "coOwners",
    "ifLetOut",
    "nameofTenant",
    "paNofTenant",
    "rentdetails"
})
@XmlRootElement(name = "PropertyDetails")
public class PropertyDetails {

    @XmlElement(name = "HPSNo")
    protected int hpsNo;
    @XmlElement(name = "AddressDetail", required = true)
    protected AddressDetail addressDetail;
    @XmlElement(name = "PropCoOwnedFlg", required = true)
    protected String propCoOwnedFlg;
    @XmlElement(name = "AssessePercentShareProp", defaultValue = "0")
    protected Double assessePercentShareProp;
    @XmlElement(name = "CoOwners")
    protected List<CoOwners> coOwners;
    @XmlElement(required = true, defaultValue = "Y")
    protected String ifLetOut;
    @XmlElement(name = "NameofTenant")
    protected String nameofTenant;
    @XmlElement(name = "PANofTenant")
    protected String paNofTenant;
    @XmlElement(name = "Rentdetails", required = true)
    protected Rentdetails rentdetails;

    /**
     * Gets the value of the hpsNo property.
     * 
     */
    public int getHPSNo() {
        return hpsNo;
    }

    /**
     * Sets the value of the hpsNo property.
     * 
     */
    public void setHPSNo(int value) {
        this.hpsNo = value;
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
     * Gets the value of the propCoOwnedFlg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropCoOwnedFlg() {
        return propCoOwnedFlg;
    }

    /**
     * Sets the value of the propCoOwnedFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropCoOwnedFlg(String value) {
        this.propCoOwnedFlg = value;
    }

    /**
     * Gets the value of the assessePercentShareProp property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAssessePercentShareProp() {
        return assessePercentShareProp;
    }

    /**
     * Sets the value of the assessePercentShareProp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAssessePercentShareProp(Double value) {
        this.assessePercentShareProp = value;
    }

    /**
     * Gets the value of the coOwners property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coOwners property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoOwners().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoOwners }
     * 
     * 
     */
    public List<CoOwners> getCoOwners() {
        if (coOwners == null) {
            coOwners = new ArrayList<CoOwners>();
        }
        return this.coOwners;
    }

    /**
     * Gets the value of the ifLetOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfLetOut() {
        return ifLetOut;
    }

    /**
     * Sets the value of the ifLetOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfLetOut(String value) {
        this.ifLetOut = value;
    }

    /**
     * Gets the value of the nameofTenant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameofTenant() {
        return nameofTenant;
    }

    /**
     * Sets the value of the nameofTenant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameofTenant(String value) {
        this.nameofTenant = value;
    }

    /**
     * Gets the value of the paNofTenant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPANofTenant() {
        return paNofTenant;
    }

    /**
     * Sets the value of the paNofTenant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPANofTenant(String value) {
        this.paNofTenant = value;
    }

    /**
     * Gets the value of the rentdetails property.
     * 
     * @return
     *     possible object is
     *     {@link Rentdetails }
     *     
     */
    public Rentdetails getRentdetails() {
        return rentdetails;
    }

    /**
     * Sets the value of the rentdetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rentdetails }
     *     
     */
    public void setRentdetails(Rentdetails value) {
        this.rentdetails = value;
    }

}
