//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.26 at 10:23:30 PM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013.corp;

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
 *         &lt;element name="LongTermIndexation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LongTermWOIndexation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotalLongTerm">
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
    "longTermIndexation",
    "longTermWOIndexation",
    "totalLongTerm"
})
@XmlRootElement(name = "LongTerm")
public class LongTerm {

    @XmlElement(name = "LongTermIndexation", defaultValue = "0")
    protected long longTermIndexation;
    @XmlElement(name = "LongTermWOIndexation", defaultValue = "0")
    protected long longTermWOIndexation;
    @XmlElement(name = "TotalLongTerm", required = true, defaultValue = "0")
    protected BigInteger totalLongTerm;

    /**
     * Gets the value of the longTermIndexation property.
     * 
     */
    public long getLongTermIndexation() {
        return longTermIndexation;
    }

    /**
     * Sets the value of the longTermIndexation property.
     * 
     */
    public void setLongTermIndexation(long value) {
        this.longTermIndexation = value;
    }

    /**
     * Gets the value of the longTermWOIndexation property.
     * 
     */
    public long getLongTermWOIndexation() {
        return longTermWOIndexation;
    }

    /**
     * Sets the value of the longTermWOIndexation property.
     * 
     */
    public void setLongTermWOIndexation(long value) {
        this.longTermWOIndexation = value;
    }

    /**
     * Gets the value of the totalLongTerm property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalLongTerm() {
        return totalLongTerm;
    }

    /**
     * Sets the value of the totalLongTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalLongTerm(BigInteger value) {
        this.totalLongTerm = value;
    }

}