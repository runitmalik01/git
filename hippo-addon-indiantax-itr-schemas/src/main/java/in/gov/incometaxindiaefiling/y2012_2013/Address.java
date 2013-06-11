//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.11 at 12:39:59 PM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013;

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
 *         &lt;element name="ResidenceNo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ResidenceName" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RoadOrStreet" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LocalityOrArea">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CityOrTownOrDistrict">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="StateCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="0[1-9]{1}|1[0-9]{1}|2[0-9]{1}|3[0-5]{1}|99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}CountryCode"/>
 *         &lt;element name="PinCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="6"/>
 *               &lt;pattern value="\d\d\d\d\d\d"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Phone" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="STDcode">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="5"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PhoneNo">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="10"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MobileNo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="10"/>
 *               &lt;pattern value="[1-9]{1}[0-9]{9}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MobileNoSec" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="10"/>
 *               &lt;pattern value="[1-9]{1}[0-9]{9}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EmailAddress">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *               &lt;pattern value="([\.a-zA-Z0-9_\-])+@([a-zA-Z0-9_\-])+(([a-zA-Z0-9_\-])*\.([a-zA-Z0-9_\-])+)+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EmailAddressSec" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *               &lt;pattern value="([\.a-zA-Z0-9_\-])+@([a-zA-Z0-9_\-])+(([a-zA-Z0-9_\-])*\.([a-zA-Z0-9_\-])+)+"/>
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
    "residenceNo",
    "residenceName",
    "roadOrStreet",
    "localityOrArea",
    "cityOrTownOrDistrict",
    "stateCode",
    "countryCode",
    "pinCode",
    "phone",
    "mobileNo",
    "mobileNoSec",
    "emailAddress",
    "emailAddressSec"
})
@XmlRootElement(name = "Address")
public class Address {

    @XmlElement(name = "ResidenceNo", required = true)
    protected String residenceNo;
    @XmlElement(name = "ResidenceName")
    protected String residenceName;
    @XmlElement(name = "RoadOrStreet")
    protected String roadOrStreet;
    @XmlElement(name = "LocalityOrArea", required = true)
    protected String localityOrArea;
    @XmlElement(name = "CityOrTownOrDistrict", required = true)
    protected String cityOrTownOrDistrict;
    @XmlElement(name = "StateCode", required = true)
    protected String stateCode;
    @XmlElement(name = "CountryCode", required = true)
    protected String countryCode;
    @XmlElement(name = "PinCode", required = true)
    protected BigInteger pinCode;
    @XmlElement(name = "Phone")
    protected Address.Phone phone;
    @XmlElement(name = "MobileNo", required = true)
    protected BigInteger mobileNo;
    @XmlElement(name = "MobileNoSec")
    protected BigInteger mobileNoSec;
    @XmlElement(name = "EmailAddress", required = true)
    protected String emailAddress;
    @XmlElement(name = "EmailAddressSec")
    protected String emailAddressSec;

    /**
     * Gets the value of the residenceNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidenceNo() {
        return residenceNo;
    }

    /**
     * Sets the value of the residenceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidenceNo(String value) {
        this.residenceNo = value;
    }

    /**
     * Gets the value of the residenceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidenceName() {
        return residenceName;
    }

    /**
     * Sets the value of the residenceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidenceName(String value) {
        this.residenceName = value;
    }

    /**
     * Gets the value of the roadOrStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoadOrStreet() {
        return roadOrStreet;
    }

    /**
     * Sets the value of the roadOrStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoadOrStreet(String value) {
        this.roadOrStreet = value;
    }

    /**
     * Gets the value of the localityOrArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalityOrArea() {
        return localityOrArea;
    }

    /**
     * Sets the value of the localityOrArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalityOrArea(String value) {
        this.localityOrArea = value;
    }

    /**
     * Gets the value of the cityOrTownOrDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityOrTownOrDistrict() {
        return cityOrTownOrDistrict;
    }

    /**
     * Sets the value of the cityOrTownOrDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityOrTownOrDistrict(String value) {
        this.cityOrTownOrDistrict = value;
    }

    /**
     * Gets the value of the stateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Sets the value of the stateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateCode(String value) {
        this.stateCode = value;
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
     * Gets the value of the pinCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPinCode() {
        return pinCode;
    }

    /**
     * Sets the value of the pinCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPinCode(BigInteger value) {
        this.pinCode = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link Address.Phone }
     *     
     */
    public Address.Phone getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address.Phone }
     *     
     */
    public void setPhone(Address.Phone value) {
        this.phone = value;
    }

    /**
     * Gets the value of the mobileNo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the value of the mobileNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMobileNo(BigInteger value) {
        this.mobileNo = value;
    }

    /**
     * Gets the value of the mobileNoSec property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMobileNoSec() {
        return mobileNoSec;
    }

    /**
     * Sets the value of the mobileNoSec property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMobileNoSec(BigInteger value) {
        this.mobileNoSec = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the emailAddressSec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddressSec() {
        return emailAddressSec;
    }

    /**
     * Sets the value of the emailAddressSec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddressSec(String value) {
        this.emailAddressSec = value;
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
     *         &lt;element name="STDcode">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="5"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PhoneNo">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="10"/>
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
        "stDcode",
        "phoneNo"
    })
    public static class Phone {

        @XmlElement(name = "STDcode", required = true, defaultValue = "0")
        protected BigInteger stDcode;
        @XmlElement(name = "PhoneNo", required = true, defaultValue = "0")
        protected BigInteger phoneNo;

        /**
         * Gets the value of the stDcode property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSTDcode() {
            return stDcode;
        }

        /**
         * Sets the value of the stDcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSTDcode(BigInteger value) {
            this.stDcode = value;
        }

        /**
         * Gets the value of the phoneNo property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPhoneNo() {
            return phoneNo;
        }

        /**
         * Sets the value of the phoneNo property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPhoneNo(BigInteger value) {
            this.phoneNo = value;
        }

    }

}
