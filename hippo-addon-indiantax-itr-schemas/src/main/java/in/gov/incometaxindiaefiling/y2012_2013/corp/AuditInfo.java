
package in.gov.incometaxindiaefiling.y2012_2013.corp;

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
 *         &lt;element name="AuditReportFurnishDate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;minInclusive value="2013-04-01"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AuditorName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="125"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AuditorMemNo">
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
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AudFrmPAN">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="10"/>
 *               &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AuditDate">
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
    "auditReportFurnishDate",
    "auditorName",
    "auditorMemNo",
    "audFrmName",
    "audFrmPAN",
    "auditDate"
})
@XmlRootElement(name = "AuditInfo")
public class AuditInfo {

    @XmlElement(name = "AuditReportFurnishDate")
    protected XMLGregorianCalendar auditReportFurnishDate;
    @XmlElement(name = "AuditorName", required = true)
    protected String auditorName;
    @XmlElement(name = "AuditorMemNo", required = true)
    protected String auditorMemNo;
    @XmlElement(name = "AudFrmName")
    protected String audFrmName;
    @XmlElement(name = "AudFrmPAN", required = true)
    protected String audFrmPAN;
    @XmlElement(name = "AuditDate", required = true)
    protected XMLGregorianCalendar auditDate;

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

}
