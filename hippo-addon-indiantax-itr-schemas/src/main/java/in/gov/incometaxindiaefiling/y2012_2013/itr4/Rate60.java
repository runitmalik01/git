//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.11 at 12:34:37 PM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013.itr4;

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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}DepreciationDetail"/>
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
@XmlRootElement(name = "Rate60")
public class Rate60 {

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
