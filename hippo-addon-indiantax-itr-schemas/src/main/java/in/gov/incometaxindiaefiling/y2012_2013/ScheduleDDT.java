//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.12 at 12:44:53 AM PST 
//


package in.gov.incometaxindiaefiling.y2012_2013;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="DDT" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DateOfDeclareDividProfDomesComp">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *                         &lt;minInclusive value="2012-04-01"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RateDividPrevYrType">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="7"/>
 *                         &lt;enumeration value="INTERIM"/>
 *                         &lt;enumeration value="FINAL"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RateDividPrevYr">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                         &lt;minInclusive value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AmtAnyDividDeclarOrPaid">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TaxPayOnDividDeclarOrPaid">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AddLITPayUs115_O">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Surcharge">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="EducationCess">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="TotDDTPayable">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="IntPayUs115P">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AddLITPlusIntrestPayable">
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
 *         &lt;element name="TaxAndInterestPaid">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NetDDTPayableOrRefund">
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
    "ddt",
    "taxAndInterestPaid",
    "netDDTPayableOrRefund"
})
@XmlRootElement(name = "ScheduleDDT")
public class ScheduleDDT {

    @XmlElement(name = "DDT")
    protected List<ScheduleDDT.DDT> ddt;
    @XmlElement(name = "TaxAndInterestPaid", required = true, defaultValue = "0")
    protected BigInteger taxAndInterestPaid;
    @XmlElement(name = "NetDDTPayableOrRefund", defaultValue = "0")
    protected long netDDTPayableOrRefund;

    /**
     * Gets the value of the ddt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ddt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDDT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScheduleDDT.DDT }
     * 
     * 
     */
    public List<ScheduleDDT.DDT> getDDT() {
        if (ddt == null) {
            ddt = new ArrayList<ScheduleDDT.DDT>();
        }
        return this.ddt;
    }

    /**
     * Gets the value of the taxAndInterestPaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxAndInterestPaid() {
        return taxAndInterestPaid;
    }

    /**
     * Sets the value of the taxAndInterestPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxAndInterestPaid(BigInteger value) {
        this.taxAndInterestPaid = value;
    }

    /**
     * Gets the value of the netDDTPayableOrRefund property.
     * 
     */
    public long getNetDDTPayableOrRefund() {
        return netDDTPayableOrRefund;
    }

    /**
     * Sets the value of the netDDTPayableOrRefund property.
     * 
     */
    public void setNetDDTPayableOrRefund(long value) {
        this.netDDTPayableOrRefund = value;
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
     *         &lt;element name="DateOfDeclareDividProfDomesComp">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
     *               &lt;minInclusive value="2012-04-01"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RateDividPrevYrType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="7"/>
     *               &lt;enumeration value="INTERIM"/>
     *               &lt;enumeration value="FINAL"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RateDividPrevYr">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *               &lt;minInclusive value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AmtAnyDividDeclarOrPaid">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TaxPayOnDividDeclarOrPaid">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AddLITPayUs115_O">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Surcharge">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="EducationCess">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="TotDDTPayable">
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
     *         &lt;element name="IntPayUs115P">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AddLITPlusIntrestPayable">
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
        "dateOfDeclareDividProfDomesComp",
        "rateDividPrevYrType",
        "rateDividPrevYr",
        "amtAnyDividDeclarOrPaid",
        "taxPayOnDividDeclarOrPaid",
        "intPayUs115P",
        "addLITPlusIntrestPayable"
    })
    public static class DDT {

        @XmlElement(name = "DateOfDeclareDividProfDomesComp", required = true)
        protected XMLGregorianCalendar dateOfDeclareDividProfDomesComp;
        @XmlElement(name = "RateDividPrevYrType", required = true, defaultValue = "FINAL")
        protected String rateDividPrevYrType;
        @XmlElement(name = "RateDividPrevYr", defaultValue = "0")
        protected double rateDividPrevYr;
        @XmlElement(name = "AmtAnyDividDeclarOrPaid", required = true, defaultValue = "0")
        protected BigInteger amtAnyDividDeclarOrPaid;
        @XmlElement(name = "TaxPayOnDividDeclarOrPaid", required = true)
        protected ScheduleDDT.DDT.TaxPayOnDividDeclarOrPaid taxPayOnDividDeclarOrPaid;
        @XmlElement(name = "IntPayUs115P", required = true, defaultValue = "0")
        protected BigInteger intPayUs115P;
        @XmlElement(name = "AddLITPlusIntrestPayable", required = true, defaultValue = "0")
        protected BigInteger addLITPlusIntrestPayable;

        /**
         * Gets the value of the dateOfDeclareDividProfDomesComp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateOfDeclareDividProfDomesComp() {
            return dateOfDeclareDividProfDomesComp;
        }

        /**
         * Sets the value of the dateOfDeclareDividProfDomesComp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateOfDeclareDividProfDomesComp(XMLGregorianCalendar value) {
            this.dateOfDeclareDividProfDomesComp = value;
        }

        /**
         * Gets the value of the rateDividPrevYrType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRateDividPrevYrType() {
            return rateDividPrevYrType;
        }

        /**
         * Sets the value of the rateDividPrevYrType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRateDividPrevYrType(String value) {
            this.rateDividPrevYrType = value;
        }

        /**
         * Gets the value of the rateDividPrevYr property.
         * 
         */
        public double getRateDividPrevYr() {
            return rateDividPrevYr;
        }

        /**
         * Sets the value of the rateDividPrevYr property.
         * 
         */
        public void setRateDividPrevYr(double value) {
            this.rateDividPrevYr = value;
        }

        /**
         * Gets the value of the amtAnyDividDeclarOrPaid property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAmtAnyDividDeclarOrPaid() {
            return amtAnyDividDeclarOrPaid;
        }

        /**
         * Sets the value of the amtAnyDividDeclarOrPaid property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAmtAnyDividDeclarOrPaid(BigInteger value) {
            this.amtAnyDividDeclarOrPaid = value;
        }

        /**
         * Gets the value of the taxPayOnDividDeclarOrPaid property.
         * 
         * @return
         *     possible object is
         *     {@link ScheduleDDT.DDT.TaxPayOnDividDeclarOrPaid }
         *     
         */
        public ScheduleDDT.DDT.TaxPayOnDividDeclarOrPaid getTaxPayOnDividDeclarOrPaid() {
            return taxPayOnDividDeclarOrPaid;
        }

        /**
         * Sets the value of the taxPayOnDividDeclarOrPaid property.
         * 
         * @param value
         *     allowed object is
         *     {@link ScheduleDDT.DDT.TaxPayOnDividDeclarOrPaid }
         *     
         */
        public void setTaxPayOnDividDeclarOrPaid(ScheduleDDT.DDT.TaxPayOnDividDeclarOrPaid value) {
            this.taxPayOnDividDeclarOrPaid = value;
        }

        /**
         * Gets the value of the intPayUs115P property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getIntPayUs115P() {
            return intPayUs115P;
        }

        /**
         * Sets the value of the intPayUs115P property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setIntPayUs115P(BigInteger value) {
            this.intPayUs115P = value;
        }

        /**
         * Gets the value of the addLITPlusIntrestPayable property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAddLITPlusIntrestPayable() {
            return addLITPlusIntrestPayable;
        }

        /**
         * Sets the value of the addLITPlusIntrestPayable property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAddLITPlusIntrestPayable(BigInteger value) {
            this.addLITPlusIntrestPayable = value;
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
         *         &lt;element name="AddLITPayUs115_O">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Surcharge">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="EducationCess">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="TotDDTPayable">
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
            "addLITPayUs115O",
            "surcharge",
            "educationCess",
            "totDDTPayable"
        })
        public static class TaxPayOnDividDeclarOrPaid {

            @XmlElement(name = "AddLITPayUs115_O", required = true, defaultValue = "0")
            protected BigInteger addLITPayUs115O;
            @XmlElement(name = "Surcharge", required = true, defaultValue = "0")
            protected BigInteger surcharge;
            @XmlElement(name = "EducationCess", required = true, defaultValue = "0")
            protected BigInteger educationCess;
            @XmlElement(name = "TotDDTPayable", required = true, defaultValue = "0")
            protected BigInteger totDDTPayable;

            /**
             * Gets the value of the addLITPayUs115O property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getAddLITPayUs115O() {
                return addLITPayUs115O;
            }

            /**
             * Sets the value of the addLITPayUs115O property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setAddLITPayUs115O(BigInteger value) {
                this.addLITPayUs115O = value;
            }

            /**
             * Gets the value of the surcharge property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getSurcharge() {
                return surcharge;
            }

            /**
             * Sets the value of the surcharge property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setSurcharge(BigInteger value) {
                this.surcharge = value;
            }

            /**
             * Gets the value of the educationCess property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getEducationCess() {
                return educationCess;
            }

            /**
             * Sets the value of the educationCess property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setEducationCess(BigInteger value) {
                this.educationCess = value;
            }

            /**
             * Gets the value of the totDDTPayable property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getTotDDTPayable() {
                return totDDTPayable;
            }

            /**
             * Sets the value of the totDDTPayable property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTotDDTPayable(BigInteger value) {
                this.totDDTPayable = value;
            }

        }

    }

}
