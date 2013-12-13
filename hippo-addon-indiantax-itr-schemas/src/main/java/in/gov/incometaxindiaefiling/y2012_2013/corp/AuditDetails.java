
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
 *         &lt;element name="AuditedSection">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateOfAudit">
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
    "auditedSection",
    "dateOfAudit"
})
@XmlRootElement(name = "AuditDetails")
public class AuditDetails {

    @XmlElement(name = "AuditedSection", required = true)
    protected String auditedSection;
    @XmlElement(name = "DateOfAudit", required = true)
    protected XMLGregorianCalendar dateOfAudit;

    /**
     * Gets the value of the auditedSection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditedSection() {
        return auditedSection;
    }

    /**
     * Sets the value of the auditedSection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditedSection(String value) {
        this.auditedSection = value;
    }

    /**
     * Gets the value of the dateOfAudit property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfAudit() {
        return dateOfAudit;
    }

    /**
     * Sets the value of the dateOfAudit property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfAudit(XMLGregorianCalendar value) {
        this.dateOfAudit = value;
    }

}
