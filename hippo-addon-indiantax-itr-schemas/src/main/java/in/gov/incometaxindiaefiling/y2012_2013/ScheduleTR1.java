
package in.gov.incometaxindiaefiling.y2012_2013;

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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleTR" maxOccurs="unbounded"/>
 *         &lt;element name="TotalTaxPaidOutsideIndia">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxPaidOutsideIndiaDTAA">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxPaidOutsideIndiaNotDTAA">
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
    "scheduleTR",
    "totalTaxPaidOutsideIndia",
    "taxPaidOutsideIndiaDTAA",
    "taxPaidOutsideIndiaNotDTAA"
})
@XmlRootElement(name = "ScheduleTR1")
public class ScheduleTR1 {

    @XmlElement(name = "ScheduleTR", required = true)
    protected List<ScheduleTR> scheduleTR;
    @XmlElement(name = "TotalTaxPaidOutsideIndia", required = true)
    protected BigInteger totalTaxPaidOutsideIndia;
    @XmlElement(name = "TaxPaidOutsideIndiaDTAA", required = true)
    protected BigInteger taxPaidOutsideIndiaDTAA;
    @XmlElement(name = "TaxPaidOutsideIndiaNotDTAA", required = true)
    protected BigInteger taxPaidOutsideIndiaNotDTAA;

    /**
     * Gets the value of the scheduleTR property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scheduleTR property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScheduleTR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScheduleTR }
     * 
     * 
     */
    public List<ScheduleTR> getScheduleTR() {
        if (scheduleTR == null) {
            scheduleTR = new ArrayList<ScheduleTR>();
        }
        return this.scheduleTR;
    }

    /**
     * Gets the value of the totalTaxPaidOutsideIndia property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalTaxPaidOutsideIndia() {
        return totalTaxPaidOutsideIndia;
    }

    /**
     * Sets the value of the totalTaxPaidOutsideIndia property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalTaxPaidOutsideIndia(BigInteger value) {
        this.totalTaxPaidOutsideIndia = value;
    }

    /**
     * Gets the value of the taxPaidOutsideIndiaDTAA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxPaidOutsideIndiaDTAA() {
        return taxPaidOutsideIndiaDTAA;
    }

    /**
     * Sets the value of the taxPaidOutsideIndiaDTAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxPaidOutsideIndiaDTAA(BigInteger value) {
        this.taxPaidOutsideIndiaDTAA = value;
    }

    /**
     * Gets the value of the taxPaidOutsideIndiaNotDTAA property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxPaidOutsideIndiaNotDTAA() {
        return taxPaidOutsideIndiaNotDTAA;
    }

    /**
     * Sets the value of the taxPaidOutsideIndiaNotDTAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxPaidOutsideIndiaNotDTAA(BigInteger value) {
        this.taxPaidOutsideIndiaNotDTAA = value;
    }

}
