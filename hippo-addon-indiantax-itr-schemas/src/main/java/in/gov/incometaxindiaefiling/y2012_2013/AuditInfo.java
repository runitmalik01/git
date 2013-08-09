//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.05 at 01:02:46 AM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013;

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
 *         &lt;element name="LiableSec44AAflg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;pattern value="N|Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LiableSec44ABflg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;pattern value="N|Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AuditReportFurnishDate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="2013-04-01"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AuditorName" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AuditorMemNo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="6"/>
 *               &lt;pattern value="\d\d\d\d\d\d"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AudFrmName" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AudFrmPAN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="10"/>
 *               &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AuditDate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="2012-04-01"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RepSec92EFlag">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Y"/>
 *               &lt;enumeration value="N"/>
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
    "liableSec44AAflg",
    "liableSec44ABflg",
    "auditReportFurnishDate",
    "auditorName",
    "auditorMemNo",
    "audFrmName",
    "audFrmPAN",
    "auditDate",
    "repSec92EFlag"
})
@XmlRootElement(name = "AuditInfo")
public class AuditInfo {

    @XmlElement(name = "LiableSec44AAflg", required = true, defaultValue = "N")
    protected String liableSec44AAflg;
    @XmlElement(name = "LiableSec44ABflg", required = true, defaultValue = "N")
    protected String liableSec44ABflg;
    @XmlElement(name = "AuditReportFurnishDate")
    protected XMLGregorianCalendar auditReportFurnishDate;
    @XmlElement(name = "AuditorName")
    protected String auditorName;
    @XmlElement(name = "AuditorMemNo")
    protected String auditorMemNo;
    @XmlElement(name = "AudFrmName")
    protected String audFrmName;
    @XmlElement(name = "AudFrmPAN")
    protected String audFrmPAN;
    @XmlElement(name = "AuditDate")
    protected XMLGregorianCalendar auditDate;
    @XmlElement(name = "RepSec92EFlag", required = true)
    protected String repSec92EFlag;

    /**
     * Gets the value of the liableSec44AAflg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiableSec44AAflg() {
        return liableSec44AAflg;
    }

    /**
     * Sets the value of the liableSec44AAflg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiableSec44AAflg(String value) {
        this.liableSec44AAflg = value;
    }

    /**
     * Gets the value of the liableSec44ABflg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiableSec44ABflg() {
        return liableSec44ABflg;
    }

    /**
     * Sets the value of the liableSec44ABflg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiableSec44ABflg(String value) {
        this.liableSec44ABflg = value;
    }

    /**
     * Gets the value of the auditReportFurnishDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAuditReportFurnishDate() {
        return auditReportFurnishDate;
    }

    /**
     * Sets the value of the auditReportFurnishDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuditReportFurnishDate(XMLGregorianCalendar value) {
        this.auditReportFurnishDate = value;
    }

    /**
     * Gets the value of the auditorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditorName() {
        return auditorName;
    }

    /**
     * Sets the value of the auditorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditorName(String value) {
        this.auditorName = value;
    }

    /**
     * Gets the value of the auditorMemNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditorMemNo() {
        return auditorMemNo;
    }

    /**
     * Sets the value of the auditorMemNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditorMemNo(String value) {
        this.auditorMemNo = value;
    }

    /**
     * Gets the value of the audFrmName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudFrmName() {
        return audFrmName;
    }

    /**
     * Sets the value of the audFrmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudFrmName(String value) {
        this.audFrmName = value;
    }

    /**
     * Gets the value of the audFrmPAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudFrmPAN() {
        return audFrmPAN;
    }

    /**
     * Sets the value of the audFrmPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudFrmPAN(String value) {
        this.audFrmPAN = value;
    }

    /**
     * Gets the value of the auditDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAuditDate() {
        return auditDate;
    }

    /**
     * Sets the value of the auditDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuditDate(XMLGregorianCalendar value) {
        this.auditDate = value;
    }

    /**
     * Gets the value of the repSec92EFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepSec92EFlag() {
        return repSec92EFlag;
    }

    /**
     * Sets the value of the repSec92EFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepSec92EFlag(String value) {
        this.repSec92EFlag = value;
    }

}
