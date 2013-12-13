
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
 *         &lt;element name="CountryName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="55"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}CountryCode"/>
 *         &lt;element name="NameOfTrust">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AddressOfTrust">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NameOfOtherTrustees">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AddressOfOtherTrustees">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NameOfSettlor">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AddressOfSettlor">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NameOfBeneficiaries">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AddressOfBeneficiaries">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
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
    "countryName",
    "countryCode",
    "nameOfTrust",
    "addressOfTrust",
    "nameOfOtherTrustees",
    "addressOfOtherTrustees",
    "nameOfSettlor",
    "addressOfSettlor",
    "nameOfBeneficiaries",
    "addressOfBeneficiaries"
})
@XmlRootElement(name = "DetailsOfTrustOutIndiaTrustee")
public class DetailsOfTrustOutIndiaTrustee {

    @XmlElement(name = "CountryName", required = true)
    protected String countryName;
    @XmlElement(name = "CountryCode", required = true)
    protected String countryCode;
    @XmlElement(name = "NameOfTrust", required = true)
    protected String nameOfTrust;
    @XmlElement(name = "AddressOfTrust", required = true)
    protected String addressOfTrust;
    @XmlElement(name = "NameOfOtherTrustees", required = true)
    protected String nameOfOtherTrustees;
    @XmlElement(name = "AddressOfOtherTrustees", required = true)
    protected String addressOfOtherTrustees;
    @XmlElement(name = "NameOfSettlor", required = true)
    protected String nameOfSettlor;
    @XmlElement(name = "AddressOfSettlor", required = true)
    protected String addressOfSettlor;
    @XmlElement(name = "NameOfBeneficiaries", required = true)
    protected String nameOfBeneficiaries;
    @XmlElement(name = "AddressOfBeneficiaries", required = true)
    protected String addressOfBeneficiaries;

    /**
     * Gets the value of the countryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the nameOfTrust property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfTrust() {
        return nameOfTrust;
    }

    /**
     * Sets the value of the nameOfTrust property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfTrust(String value) {
        this.nameOfTrust = value;
    }

    /**
     * Gets the value of the addressOfTrust property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressOfTrust() {
        return addressOfTrust;
    }

    /**
     * Sets the value of the addressOfTrust property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressOfTrust(String value) {
        this.addressOfTrust = value;
    }

    /**
     * Gets the value of the nameOfOtherTrustees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfOtherTrustees() {
        return nameOfOtherTrustees;
    }

    /**
     * Sets the value of the nameOfOtherTrustees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfOtherTrustees(String value) {
        this.nameOfOtherTrustees = value;
    }

    /**
     * Gets the value of the addressOfOtherTrustees property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressOfOtherTrustees() {
        return addressOfOtherTrustees;
    }

    /**
     * Sets the value of the addressOfOtherTrustees property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressOfOtherTrustees(String value) {
        this.addressOfOtherTrustees = value;
    }

    /**
     * Gets the value of the nameOfSettlor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfSettlor() {
        return nameOfSettlor;
    }

    /**
     * Sets the value of the nameOfSettlor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfSettlor(String value) {
        this.nameOfSettlor = value;
    }

    /**
     * Gets the value of the addressOfSettlor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressOfSettlor() {
        return addressOfSettlor;
    }

    /**
     * Sets the value of the addressOfSettlor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressOfSettlor(String value) {
        this.addressOfSettlor = value;
    }

    /**
     * Gets the value of the nameOfBeneficiaries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfBeneficiaries() {
        return nameOfBeneficiaries;
    }

    /**
     * Sets the value of the nameOfBeneficiaries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfBeneficiaries(String value) {
        this.nameOfBeneficiaries = value;
    }

    /**
     * Gets the value of the addressOfBeneficiaries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressOfBeneficiaries() {
        return addressOfBeneficiaries;
    }

    /**
     * Sets the value of the addressOfBeneficiaries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressOfBeneficiaries(String value) {
        this.addressOfBeneficiaries = value;
    }

}
