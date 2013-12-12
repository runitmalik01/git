
package in.gov.incometaxindiaefiling.y2012_2013.corp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}DedFromUndertaking" maxOccurs="unbounded"/>
 *         &lt;element name="TotalDedUs10Sub">
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
    "dedFromUndertaking",
    "totalDedUs10Sub"
})
@XmlRootElement(name = "DedUs10Detail")
public class DedUs10Detail {

    @XmlElement(name = "DedFromUndertaking", required = true, defaultValue = "0")
    protected List<BigInteger> dedFromUndertaking;
    @XmlElement(name = "TotalDedUs10Sub", required = true, defaultValue = "0")
    protected BigInteger totalDedUs10Sub;

    /**
     * Gets the value of the dedFromUndertaking property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dedFromUndertaking property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDedFromUndertaking().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getDedFromUndertaking() {
        if (dedFromUndertaking == null) {
            dedFromUndertaking = new ArrayList<BigInteger>();
        }
        return this.dedFromUndertaking;
    }

    /**
     * Gets the value of the totalDedUs10Sub property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalDedUs10Sub() {
        return totalDedUs10Sub;
    }

    /**
     * Sets the value of the totalDedUs10Sub property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalDedUs10Sub(BigInteger value) {
        this.totalDedUs10Sub = value;
    }

}
