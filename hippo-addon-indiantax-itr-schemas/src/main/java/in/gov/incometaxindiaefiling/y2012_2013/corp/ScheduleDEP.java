//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.26 at 10:23:30 PM PDT 
//


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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}SummaryFromDeprSch"/>
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
    "summaryFromDeprSch"
})
@XmlRootElement(name = "ScheduleDEP")
public class ScheduleDEP {

    @XmlElement(name = "SummaryFromDeprSch", required = true)
    protected SummaryFromDeprSch summaryFromDeprSch;

    /**
     * Gets the value of the summaryFromDeprSch property.
     * 
     * @return
     *     possible object is
     *     {@link SummaryFromDeprSch }
     *     
     */
    public SummaryFromDeprSch getSummaryFromDeprSch() {
        return summaryFromDeprSch;
    }

    /**
     * Sets the value of the summaryFromDeprSch property.
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryFromDeprSch }
     *     
     */
    public void setSummaryFromDeprSch(SummaryFromDeprSch value) {
        this.summaryFromDeprSch = value;
    }

}