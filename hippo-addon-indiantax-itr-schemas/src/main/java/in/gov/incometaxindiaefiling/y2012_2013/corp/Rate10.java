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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}DepreciationDetail"/>
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
    "depreciationDetail"
})
@XmlRootElement(name = "Rate10")
public class Rate10 {

    @XmlElement(name = "DepreciationDetail", required = true)
    protected DepreciationDetail depreciationDetail;

    /**
     * Gets the value of the depreciationDetail property.
     * 
     * @return
     *     possible object is
     *     {@link DepreciationDetail }
     *     
     */
    public DepreciationDetail getDepreciationDetail() {
        return depreciationDetail;
    }

    /**
     * Sets the value of the depreciationDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepreciationDetail }
     *     
     */
    public void setDepreciationDetail(DepreciationDetail value) {
        this.depreciationDetail = value;
    }

}
