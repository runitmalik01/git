//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.11 at 12:34:33 PM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013.itr3;

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
 *         &lt;element name="DeductSEZ" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://incometaxindiaefiling.gov.in/master}DedUs10Detail"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TotalDedUs10A">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
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
    "deductSEZ",
    "totalDedUs10A"
})
@XmlRootElement(name = "Schedule10A")
public class Schedule10A {

    @XmlElement(name = "DeductSEZ")
    protected Schedule10A.DeductSEZ deductSEZ;
    @XmlElement(name = "TotalDedUs10A", required = true, defaultValue = "0")
    protected BigInteger totalDedUs10A;

    /**
     * Gets the value of the deductSEZ property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule10A.DeductSEZ }
     *     
     */
    public Schedule10A.DeductSEZ getDeductSEZ() {
        return deductSEZ;
    }

    /**
     * Sets the value of the deductSEZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule10A.DeductSEZ }
     *     
     */
    public void setDeductSEZ(Schedule10A.DeductSEZ value) {
        this.deductSEZ = value;
    }

    /**
     * Gets the value of the totalDedUs10A property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalDedUs10A() {
        return totalDedUs10A;
    }

    /**
     * Sets the value of the totalDedUs10A property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalDedUs10A(BigInteger value) {
        this.totalDedUs10A = value;
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
     *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}DedUs10Detail"/>
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
        "dedUs10Detail"
    })
    public static class DeductSEZ {

        @XmlElement(name = "DedUs10Detail", required = true)
        protected DedUs10Detail dedUs10Detail;

        /**
         * Gets the value of the dedUs10Detail property.
         * 
         * @return
         *     possible object is
         *     {@link DedUs10Detail }
         *     
         */
        public DedUs10Detail getDedUs10Detail() {
            return dedUs10Detail;
        }

        /**
         * Sets the value of the dedUs10Detail property.
         * 
         * @param value
         *     allowed object is
         *     {@link DedUs10Detail }
         *     
         */
        public void setDedUs10Detail(DedUs10Detail value) {
            this.dedUs10Detail = value;
        }

    }

}
