//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.04 at 11:43:52 AM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013.corpmaster;

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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}OrgFirmInfo"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}FilingStatus"/>
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
    "orgFirmInfo",
    "filingStatus"
})
@XmlRootElement(name = "PartA_GEN1")
public class PartAGEN1 {

    @XmlElement(name = "OrgFirmInfo", required = true)
    protected OrgFirmInfo orgFirmInfo;
    @XmlElement(name = "FilingStatus", required = true)
    protected FilingStatus filingStatus;

    /**
     * Gets the value of the orgFirmInfo property.
     * 
     * @return
     *     possible object is
     *     {@link OrgFirmInfo }
     *     
     */
    public OrgFirmInfo getOrgFirmInfo() {
        return orgFirmInfo;
    }

    /**
     * Sets the value of the orgFirmInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrgFirmInfo }
     *     
     */
    public void setOrgFirmInfo(OrgFirmInfo value) {
        this.orgFirmInfo = value;
    }

    /**
     * Gets the value of the filingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FilingStatus }
     *     
     */
    public FilingStatus getFilingStatus() {
        return filingStatus;
    }

    /**
     * Sets the value of the filingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingStatus }
     *     
     */
    public void setFilingStatus(FilingStatus value) {
        this.filingStatus = value;
    }

}
