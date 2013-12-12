
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
 *         &lt;element name="ProvForCurrTax">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ProvDefTax">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ProfitAfterTax">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BalBFPrevYr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmtAvlAppr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Appropriations">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TrfToReserves">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ProposedDividend" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TaxOnDividend" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AnyOtherAppr" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TotAppropriations" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PartnerAccBalTrf">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
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
    "provForCurrTax",
    "provDefTax",
    "profitAfterTax",
    "balBFPrevYr",
    "amtAvlAppr",
    "appropriations",
    "partnerAccBalTrf"
})
@XmlRootElement(name = "TaxProvAppr")
public class TaxProvAppr {

    @XmlElement(name = "ProvForCurrTax", defaultValue = "0")
    protected long provForCurrTax;
    @XmlElement(name = "ProvDefTax", defaultValue = "0")
    protected long provDefTax;
    @XmlElement(name = "ProfitAfterTax", defaultValue = "0")
    protected long profitAfterTax;
    @XmlElement(name = "BalBFPrevYr", defaultValue = "0")
    protected long balBFPrevYr;
    @XmlElement(name = "AmtAvlAppr", defaultValue = "0")
    protected long amtAvlAppr;
    @XmlElement(name = "Appropriations", required = true)
    protected TaxProvAppr.Appropriations appropriations;
    @XmlElement(name = "PartnerAccBalTrf", defaultValue = "0")
    protected long partnerAccBalTrf;

    /**
     * Gets the value of the provForCurrTax property.
     * 
     */
    public long getProvForCurrTax() {
        return provForCurrTax;
    }

    /**
     * Sets the value of the provForCurrTax property.
     * 
     */
    public void setProvForCurrTax(long value) {
        this.provForCurrTax = value;
    }

    /**
     * Gets the value of the provDefTax property.
     * 
     */
    public long getProvDefTax() {
        return provDefTax;
    }

    /**
     * Sets the value of the provDefTax property.
     * 
     */
    public void setProvDefTax(long value) {
        this.provDefTax = value;
    }

    /**
     * Gets the value of the profitAfterTax property.
     * 
     */
    public long getProfitAfterTax() {
        return profitAfterTax;
    }

    /**
     * Sets the value of the profitAfterTax property.
     * 
     */
    public void setProfitAfterTax(long value) {
        this.profitAfterTax = value;
    }

    /**
     * Gets the value of the balBFPrevYr property.
     * 
     */
    public long getBalBFPrevYr() {
        return balBFPrevYr;
    }

    /**
     * Sets the value of the balBFPrevYr property.
     * 
     */
    public void setBalBFPrevYr(long value) {
        this.balBFPrevYr = value;
    }

    /**
     * Gets the value of the amtAvlAppr property.
     * 
     */
    public long getAmtAvlAppr() {
        return amtAvlAppr;
    }

    /**
     * Sets the value of the amtAvlAppr property.
     * 
     */
    public void setAmtAvlAppr(long value) {
        this.amtAvlAppr = value;
    }

    /**
     * Gets the value of the appropriations property.
     * 
     * @return
     *     possible object is
     *     {@link TaxProvAppr.Appropriations }
     *     
     */
    public TaxProvAppr.Appropriations getAppropriations() {
        return appropriations;
    }

    /**
     * Sets the value of the appropriations property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxProvAppr.Appropriations }
     *     
     */
    public void setAppropriations(TaxProvAppr.Appropriations value) {
        this.appropriations = value;
    }

    /**
     * Gets the value of the partnerAccBalTrf property.
     * 
     */
    public long getPartnerAccBalTrf() {
        return partnerAccBalTrf;
    }

    /**
     * Sets the value of the partnerAccBalTrf property.
     * 
     */
    public void setPartnerAccBalTrf(long value) {
        this.partnerAccBalTrf = value;
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
     *         &lt;element name="TrfToReserves">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ProposedDividend" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TaxOnDividend" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AnyOtherAppr" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TotAppropriations" minOccurs="0">
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
        "trfToReserves",
        "proposedDividend",
        "taxOnDividend",
        "anyOtherAppr",
        "totAppropriations"
    })
    public static class Appropriations {

        @XmlElement(name = "TrfToReserves", required = true, defaultValue = "0")
        protected BigInteger trfToReserves;
        @XmlElement(name = "ProposedDividend", defaultValue = "0")
        protected BigInteger proposedDividend;
        @XmlElement(name = "TaxOnDividend", defaultValue = "0")
        protected BigInteger taxOnDividend;
        @XmlElement(name = "AnyOtherAppr", defaultValue = "0")
        protected BigInteger anyOtherAppr;
        @XmlElement(name = "TotAppropriations", defaultValue = "0")
        protected BigInteger totAppropriations;

        /**
         * Gets the value of the trfToReserves property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTrfToReserves() {
            return trfToReserves;
        }

        /**
         * Sets the value of the trfToReserves property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTrfToReserves(BigInteger value) {
            this.trfToReserves = value;
        }

        /**
         * Gets the value of the proposedDividend property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getProposedDividend() {
            return proposedDividend;
        }

        /**
         * Sets the value of the proposedDividend property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setProposedDividend(BigInteger value) {
            this.proposedDividend = value;
        }

        /**
         * Gets the value of the taxOnDividend property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTaxOnDividend() {
            return taxOnDividend;
        }

        /**
         * Sets the value of the taxOnDividend property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTaxOnDividend(BigInteger value) {
            this.taxOnDividend = value;
        }

        /**
         * Gets the value of the anyOtherAppr property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAnyOtherAppr() {
            return anyOtherAppr;
        }

        /**
         * Sets the value of the anyOtherAppr property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAnyOtherAppr(BigInteger value) {
            this.anyOtherAppr = value;
        }

        /**
         * Gets the value of the totAppropriations property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotAppropriations() {
            return totAppropriations;
        }

        /**
         * Sets the value of the totAppropriations property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotAppropriations(BigInteger value) {
            this.totAppropriations = value;
        }

    }

}
