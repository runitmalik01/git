
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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}DebitPlAcnt"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}TaxProvAppr"/>
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
    "debitPlAcnt",
    "taxProvAppr"
})
@XmlRootElement(name = "DebitsToPL")
public class DebitsToPL {

    @XmlElement(name = "DebitPlAcnt", required = true)
    protected DebitPlAcnt debitPlAcnt;
    @XmlElement(name = "TaxProvAppr", required = true)
    protected TaxProvAppr taxProvAppr;

    /**
     * Gets the value of the debitPlAcnt property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt }
     *     
     */
    public DebitPlAcnt getDebitPlAcnt() {
        return debitPlAcnt;
    }

    /**
     * Sets the value of the debitPlAcnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt }
     *     
     */
    public void setDebitPlAcnt(DebitPlAcnt value) {
        this.debitPlAcnt = value;
    }

    /**
     * Gets the value of the taxProvAppr property.
     * 
     * @return
     *     possible object is
     *     {@link TaxProvAppr }
     *     
     */
    public TaxProvAppr getTaxProvAppr() {
        return taxProvAppr;
    }

    /**
     * Sets the value of the taxProvAppr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxProvAppr }
     *     
     */
    public void setTaxProvAppr(TaxProvAppr value) {
        this.taxProvAppr = value;
    }

}
