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
 *         &lt;element name="SurNameOrOrgName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OrgOldName" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *               &lt;minLength value="1"/>
 *               &lt;whiteSpace value="collapse"/>
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
    "surNameOrOrgName",
    "orgOldName"
})
@XmlRootElement(name = "AssesseeName")
public class AssesseeName {

    @XmlElement(name = "SurNameOrOrgName", required = true)
    protected String surNameOrOrgName;
    @XmlElement(name = "OrgOldName")
    protected String orgOldName;

    /**
     * Gets the value of the surNameOrOrgName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurNameOrOrgName() {
        return surNameOrOrgName;
    }

    /**
     * Sets the value of the surNameOrOrgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurNameOrOrgName(String value) {
        this.surNameOrOrgName = value;
    }

    /**
     * Gets the value of the orgOldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgOldName() {
        return orgOldName;
    }

    /**
     * Sets the value of the orgOldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgOldName(String value) {
        this.orgOldName = value;
    }

}
