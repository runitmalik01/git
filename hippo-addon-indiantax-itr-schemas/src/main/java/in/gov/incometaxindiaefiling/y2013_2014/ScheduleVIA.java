//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.05 at 01:02:46 AM PDT 
//


package in.gov.incometaxindiaefiling.y2013_2014;

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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}UsrDeductUndChapVIA"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}DeductUndChapVIA"/>
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
    "usrDeductUndChapVIA",
    "deductUndChapVIA"
})
@XmlRootElement(name = "ScheduleVIA")
public class ScheduleVIA {

    @XmlElement(name = "UsrDeductUndChapVIA", required = true)
    protected UsrDeductUndChapVIA usrDeductUndChapVIA;
    @XmlElement(name = "DeductUndChapVIA", required = true)
    protected DeductUndChapVIA deductUndChapVIA;

    /**
     * Deductions from income
     * 
     * @return
     *     possible object is
     *     {@link UsrDeductUndChapVIA }
     *     
     */
    public UsrDeductUndChapVIA getUsrDeductUndChapVIA() {
        return usrDeductUndChapVIA;
    }

    /**
     * Sets the value of the usrDeductUndChapVIA property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsrDeductUndChapVIA }
     *     
     */
    public void setUsrDeductUndChapVIA(UsrDeductUndChapVIA value) {
        this.usrDeductUndChapVIA = value;
    }

    /**
     * Gets the value of the deductUndChapVIA property.
     * 
     * @return
     *     possible object is
     *     {@link DeductUndChapVIA }
     *     
     */
    public DeductUndChapVIA getDeductUndChapVIA() {
        return deductUndChapVIA;
    }

    /**
     * Sets the value of the deductUndChapVIA property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeductUndChapVIA }
     *     
     */
    public void setDeductUndChapVIA(DeductUndChapVIA value) {
        this.deductUndChapVIA = value;
    }

}
