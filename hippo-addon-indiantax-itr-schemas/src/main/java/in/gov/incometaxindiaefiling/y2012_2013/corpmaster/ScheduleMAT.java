//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.04 at 11:43:52 AM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013.corpmaster;

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
 *         &lt;element name="PLAcntPrepSchedVICompAct">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;pattern value="\d"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PLAcntPrepAsperAGM">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;pattern value="\d"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ProfBeforeTaxPLAcnt">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Additions">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ITPaidNoFBT">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ResvrNo33AC">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ProvUncertainLiab">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ProvLossOfSubsComp">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DividendPaidOrProposed">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ExpendExempIncUs10s">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DepreciatAttribToRevalAsset">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Others">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TotAdditions">
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
 *         &lt;element name="Deducts">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AmtWithdrawFromResvrIfCredPL">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="IncExempIncUs10s">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AmtWithdrawFromResvrIfCredPLNoAttrib">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="UnAbsorbedDepreciat">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ProSickIndustryOrExcedAccumLos">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Others">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TotDeducts">
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
 *         &lt;element name="BookProfUs115JB">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxPayableUs115JB">
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
    "plAcntPrepSchedVICompAct",
    "plAcntPrepAsperAGM",
    "profBeforeTaxPLAcnt",
    "additions",
    "deducts",
    "bookProfUs115JB",
    "taxPayableUs115JB"
})
@XmlRootElement(name = "ScheduleMAT")
public class ScheduleMAT {

    @XmlElement(name = "PLAcntPrepSchedVICompAct", required = true, defaultValue = "1")
    protected String plAcntPrepSchedVICompAct;
    @XmlElement(name = "PLAcntPrepAsperAGM", required = true, defaultValue = "1")
    protected String plAcntPrepAsperAGM;
    @XmlElement(name = "ProfBeforeTaxPLAcnt", defaultValue = "0")
    protected long profBeforeTaxPLAcnt;
    @XmlElement(name = "Additions", required = true)
    protected ScheduleMAT.Additions additions;
    @XmlElement(name = "Deducts", required = true)
    protected ScheduleMAT.Deducts deducts;
    @XmlElement(name = "BookProfUs115JB", defaultValue = "0")
    protected long bookProfUs115JB;
    @XmlElement(name = "TaxPayableUs115JB", required = true, defaultValue = "0")
    protected BigInteger taxPayableUs115JB;

    /**
     * Gets the value of the plAcntPrepSchedVICompAct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLAcntPrepSchedVICompAct() {
        return plAcntPrepSchedVICompAct;
    }

    /**
     * Sets the value of the plAcntPrepSchedVICompAct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLAcntPrepSchedVICompAct(String value) {
        this.plAcntPrepSchedVICompAct = value;
    }

    /**
     * Gets the value of the plAcntPrepAsperAGM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLAcntPrepAsperAGM() {
        return plAcntPrepAsperAGM;
    }

    /**
     * Sets the value of the plAcntPrepAsperAGM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLAcntPrepAsperAGM(String value) {
        this.plAcntPrepAsperAGM = value;
    }

    /**
     * Gets the value of the profBeforeTaxPLAcnt property.
     * 
     */
    public long getProfBeforeTaxPLAcnt() {
        return profBeforeTaxPLAcnt;
    }

    /**
     * Sets the value of the profBeforeTaxPLAcnt property.
     * 
     */
    public void setProfBeforeTaxPLAcnt(long value) {
        this.profBeforeTaxPLAcnt = value;
    }

    /**
     * Gets the value of the additions property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleMAT.Additions }
     *     
     */
    public ScheduleMAT.Additions getAdditions() {
        return additions;
    }

    /**
     * Sets the value of the additions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleMAT.Additions }
     *     
     */
    public void setAdditions(ScheduleMAT.Additions value) {
        this.additions = value;
    }

    /**
     * Gets the value of the deducts property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleMAT.Deducts }
     *     
     */
    public ScheduleMAT.Deducts getDeducts() {
        return deducts;
    }

    /**
     * Sets the value of the deducts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleMAT.Deducts }
     *     
     */
    public void setDeducts(ScheduleMAT.Deducts value) {
        this.deducts = value;
    }

    /**
     * Gets the value of the bookProfUs115JB property.
     * 
     */
    public long getBookProfUs115JB() {
        return bookProfUs115JB;
    }

    /**
     * Sets the value of the bookProfUs115JB property.
     * 
     */
    public void setBookProfUs115JB(long value) {
        this.bookProfUs115JB = value;
    }

    /**
     * Gets the value of the taxPayableUs115JB property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxPayableUs115JB() {
        return taxPayableUs115JB;
    }

    /**
     * Sets the value of the taxPayableUs115JB property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxPayableUs115JB(BigInteger value) {
        this.taxPayableUs115JB = value;
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
     *         &lt;element name="ITPaidNoFBT">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ResvrNo33AC">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ProvUncertainLiab">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ProvLossOfSubsComp">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DividendPaidOrProposed">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ExpendExempIncUs10s">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DepreciatAttribToRevalAsset">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Others">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TotAdditions">
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
        "itPaidNoFBT",
        "resvrNo33AC",
        "provUncertainLiab",
        "provLossOfSubsComp",
        "dividendPaidOrProposed",
        "expendExempIncUs10S",
        "depreciatAttribToRevalAsset",
        "others",
        "totAdditions"
    })
    public static class Additions {

        @XmlElement(name = "ITPaidNoFBT", required = true, defaultValue = "0")
        protected BigInteger itPaidNoFBT;
        @XmlElement(name = "ResvrNo33AC", required = true, defaultValue = "0")
        protected BigInteger resvrNo33AC;
        @XmlElement(name = "ProvUncertainLiab", required = true, defaultValue = "0")
        protected BigInteger provUncertainLiab;
        @XmlElement(name = "ProvLossOfSubsComp", required = true, defaultValue = "0")
        protected BigInteger provLossOfSubsComp;
        @XmlElement(name = "DividendPaidOrProposed", required = true, defaultValue = "0")
        protected BigInteger dividendPaidOrProposed;
        @XmlElement(name = "ExpendExempIncUs10s", required = true, defaultValue = "0")
        protected BigInteger expendExempIncUs10S;
        @XmlElement(name = "DepreciatAttribToRevalAsset", required = true, defaultValue = "0")
        protected BigInteger depreciatAttribToRevalAsset;
        @XmlElement(name = "Others", required = true, defaultValue = "0")
        protected BigInteger others;
        @XmlElement(name = "TotAdditions", required = true, defaultValue = "0")
        protected BigInteger totAdditions;

        /**
         * Gets the value of the itPaidNoFBT property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getITPaidNoFBT() {
            return itPaidNoFBT;
        }

        /**
         * Sets the value of the itPaidNoFBT property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setITPaidNoFBT(BigInteger value) {
            this.itPaidNoFBT = value;
        }

        /**
         * Gets the value of the resvrNo33AC property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getResvrNo33AC() {
            return resvrNo33AC;
        }

        /**
         * Sets the value of the resvrNo33AC property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setResvrNo33AC(BigInteger value) {
            this.resvrNo33AC = value;
        }

        /**
         * Gets the value of the provUncertainLiab property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getProvUncertainLiab() {
            return provUncertainLiab;
        }

        /**
         * Sets the value of the provUncertainLiab property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setProvUncertainLiab(BigInteger value) {
            this.provUncertainLiab = value;
        }

        /**
         * Gets the value of the provLossOfSubsComp property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getProvLossOfSubsComp() {
            return provLossOfSubsComp;
        }

        /**
         * Sets the value of the provLossOfSubsComp property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setProvLossOfSubsComp(BigInteger value) {
            this.provLossOfSubsComp = value;
        }

        /**
         * Gets the value of the dividendPaidOrProposed property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getDividendPaidOrProposed() {
            return dividendPaidOrProposed;
        }

        /**
         * Sets the value of the dividendPaidOrProposed property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setDividendPaidOrProposed(BigInteger value) {
            this.dividendPaidOrProposed = value;
        }

        /**
         * Gets the value of the expendExempIncUs10S property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getExpendExempIncUs10S() {
            return expendExempIncUs10S;
        }

        /**
         * Sets the value of the expendExempIncUs10S property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setExpendExempIncUs10S(BigInteger value) {
            this.expendExempIncUs10S = value;
        }

        /**
         * Gets the value of the depreciatAttribToRevalAsset property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getDepreciatAttribToRevalAsset() {
            return depreciatAttribToRevalAsset;
        }

        /**
         * Sets the value of the depreciatAttribToRevalAsset property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setDepreciatAttribToRevalAsset(BigInteger value) {
            this.depreciatAttribToRevalAsset = value;
        }

        /**
         * Gets the value of the others property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOthers() {
            return others;
        }

        /**
         * Sets the value of the others property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOthers(BigInteger value) {
            this.others = value;
        }

        /**
         * Gets the value of the totAdditions property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotAdditions() {
            return totAdditions;
        }

        /**
         * Sets the value of the totAdditions property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotAdditions(BigInteger value) {
            this.totAdditions = value;
        }

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
     *         &lt;element name="AmtWithdrawFromResvrIfCredPL">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="IncExempIncUs10s">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AmtWithdrawFromResvrIfCredPLNoAttrib">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="UnAbsorbedDepreciat">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ProSickIndustryOrExcedAccumLos">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Others">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TotDeducts">
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
        "amtWithdrawFromResvrIfCredPL",
        "incExempIncUs10S",
        "amtWithdrawFromResvrIfCredPLNoAttrib",
        "unAbsorbedDepreciat",
        "proSickIndustryOrExcedAccumLos",
        "others",
        "totDeducts"
    })
    public static class Deducts {

        @XmlElement(name = "AmtWithdrawFromResvrIfCredPL", required = true, defaultValue = "0")
        protected BigInteger amtWithdrawFromResvrIfCredPL;
        @XmlElement(name = "IncExempIncUs10s", required = true, defaultValue = "0")
        protected BigInteger incExempIncUs10S;
        @XmlElement(name = "AmtWithdrawFromResvrIfCredPLNoAttrib", required = true, defaultValue = "0")
        protected BigInteger amtWithdrawFromResvrIfCredPLNoAttrib;
        @XmlElement(name = "UnAbsorbedDepreciat", required = true, defaultValue = "0")
        protected BigInteger unAbsorbedDepreciat;
        @XmlElement(name = "ProSickIndustryOrExcedAccumLos", required = true, defaultValue = "0")
        protected BigInteger proSickIndustryOrExcedAccumLos;
        @XmlElement(name = "Others", required = true, defaultValue = "0")
        protected BigInteger others;
        @XmlElement(name = "TotDeducts", required = true, defaultValue = "0")
        protected BigInteger totDeducts;

        /**
         * Gets the value of the amtWithdrawFromResvrIfCredPL property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAmtWithdrawFromResvrIfCredPL() {
            return amtWithdrawFromResvrIfCredPL;
        }

        /**
         * Sets the value of the amtWithdrawFromResvrIfCredPL property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAmtWithdrawFromResvrIfCredPL(BigInteger value) {
            this.amtWithdrawFromResvrIfCredPL = value;
        }

        /**
         * Gets the value of the incExempIncUs10S property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getIncExempIncUs10S() {
            return incExempIncUs10S;
        }

        /**
         * Sets the value of the incExempIncUs10S property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setIncExempIncUs10S(BigInteger value) {
            this.incExempIncUs10S = value;
        }

        /**
         * Gets the value of the amtWithdrawFromResvrIfCredPLNoAttrib property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAmtWithdrawFromResvrIfCredPLNoAttrib() {
            return amtWithdrawFromResvrIfCredPLNoAttrib;
        }

        /**
         * Sets the value of the amtWithdrawFromResvrIfCredPLNoAttrib property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAmtWithdrawFromResvrIfCredPLNoAttrib(BigInteger value) {
            this.amtWithdrawFromResvrIfCredPLNoAttrib = value;
        }

        /**
         * Gets the value of the unAbsorbedDepreciat property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getUnAbsorbedDepreciat() {
            return unAbsorbedDepreciat;
        }

        /**
         * Sets the value of the unAbsorbedDepreciat property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setUnAbsorbedDepreciat(BigInteger value) {
            this.unAbsorbedDepreciat = value;
        }

        /**
         * Gets the value of the proSickIndustryOrExcedAccumLos property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getProSickIndustryOrExcedAccumLos() {
            return proSickIndustryOrExcedAccumLos;
        }

        /**
         * Sets the value of the proSickIndustryOrExcedAccumLos property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setProSickIndustryOrExcedAccumLos(BigInteger value) {
            this.proSickIndustryOrExcedAccumLos = value;
        }

        /**
         * Gets the value of the others property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOthers() {
            return others;
        }

        /**
         * Sets the value of the others property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOthers(BigInteger value) {
            this.others = value;
        }

        /**
         * Gets the value of the totDeducts property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotDeducts() {
            return totDeducts;
        }

        /**
         * Sets the value of the totDeducts property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotDeducts(BigInteger value) {
            this.totDeducts = value;
        }

    }

}
