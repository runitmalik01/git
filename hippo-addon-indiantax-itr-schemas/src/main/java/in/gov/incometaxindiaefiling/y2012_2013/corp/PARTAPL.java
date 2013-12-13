
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
 *         &lt;element name="CreditsToPL">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SaleOfGoods">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="SaleOfServices">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OtherOperatingRevenueDtls" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="OperatingRevenueName">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="50"/>
 *                                   &lt;minLength value="1"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="OperatingRevenueAmt">
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
 *                   &lt;element name="OperatingRevenueTotAmt">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="IntrstIncaseOfForeignComp" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OtherFinanceServices" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="BusinessReceipts">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}ExciseCustomsVAT"/>
 *                   &lt;element name="TotRevenueFrmOperations">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OthIncome">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="RentInc">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Comissions">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Dividends">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="InterestInc">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ProfitOnSaleFixedAsset">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ProfitOnInvChrSTT">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ProfitOnOthInv">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ProfitOnCurrFluct">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ProfitOnAgriIncome">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="OtherIncDtls" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="NatureOfIncome">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;maxLength value="50"/>
 *                                             &lt;minLength value="1"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="Amount">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="MiscOthIncome">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="TotOthIncome">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ClosingStockDtls">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="RawMaterial">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="WorkInProgress">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="FinishedGoods">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ClosingStock">
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
 *                   &lt;element name="TotCreditsToPL">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}DebitsToPL"/>
 *         &lt;element name="NoBooksOfAccPL" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="GrossReceipt" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="GrossProfit" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Expenses" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="NetProfit" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
    "creditsToPL",
    "debitsToPL",
    "noBooksOfAccPL"
})
@XmlRootElement(name = "PARTA_PL")
public class PARTAPL {

    @XmlElement(name = "CreditsToPL", required = true)
    protected PARTAPL.CreditsToPL creditsToPL;
    @XmlElement(name = "DebitsToPL", required = true)
    protected DebitsToPL debitsToPL;
    @XmlElement(name = "NoBooksOfAccPL")
    protected PARTAPL.NoBooksOfAccPL noBooksOfAccPL;

    /**
     * Gets the value of the creditsToPL property.
     * 
     * @return
     *     possible object is
     *     {@link PARTAPL.CreditsToPL }
     *     
     */
    public PARTAPL.CreditsToPL getCreditsToPL() {
        return creditsToPL;
    }

    /**
     * Sets the value of the creditsToPL property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTAPL.CreditsToPL }
     *     
     */
    public void setCreditsToPL(PARTAPL.CreditsToPL value) {
        this.creditsToPL = value;
    }

    /**
     * Gets the value of the debitsToPL property.
     * 
     * @return
     *     possible object is
     *     {@link DebitsToPL }
     *     
     */
    public DebitsToPL getDebitsToPL() {
        return debitsToPL;
    }

    /**
     * Sets the value of the debitsToPL property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitsToPL }
     *     
     */
    public void setDebitsToPL(DebitsToPL value) {
        this.debitsToPL = value;
    }

    /**
     * Gets the value of the noBooksOfAccPL property.
     * 
     * @return
     *     possible object is
     *     {@link PARTAPL.NoBooksOfAccPL }
     *     
     */
    public PARTAPL.NoBooksOfAccPL getNoBooksOfAccPL() {
        return noBooksOfAccPL;
    }

    /**
     * Sets the value of the noBooksOfAccPL property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTAPL.NoBooksOfAccPL }
     *     
     */
    public void setNoBooksOfAccPL(PARTAPL.NoBooksOfAccPL value) {
        this.noBooksOfAccPL = value;
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
     *         &lt;element name="SaleOfGoods">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="SaleOfServices">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OtherOperatingRevenueDtls" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="OperatingRevenueName">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="50"/>
     *                         &lt;minLength value="1"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="OperatingRevenueAmt">
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
     *         &lt;element name="OperatingRevenueTotAmt">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="IntrstIncaseOfForeignComp" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OtherFinanceServices" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="BusinessReceipts">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}ExciseCustomsVAT"/>
     *         &lt;element name="TotRevenueFrmOperations">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OthIncome">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="RentInc">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Comissions">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Dividends">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="InterestInc">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ProfitOnSaleFixedAsset">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ProfitOnInvChrSTT">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ProfitOnOthInv">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ProfitOnCurrFluct">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ProfitOnAgriIncome">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="OtherIncDtls" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="NatureOfIncome">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;maxLength value="50"/>
     *                                   &lt;minLength value="1"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="Amount">
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
     *                   &lt;element name="MiscOthIncome">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="TotOthIncome">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ClosingStockDtls">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="RawMaterial">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="WorkInProgress">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="FinishedGoods">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ClosingStock">
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
     *         &lt;element name="TotCreditsToPL">
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
        "saleOfGoods",
        "saleOfServices",
        "otherOperatingRevenueDtls",
        "operatingRevenueTotAmt",
        "intrstIncaseOfForeignComp",
        "otherFinanceServices",
        "businessReceipts",
        "exciseCustomsVAT",
        "totRevenueFrmOperations",
        "othIncome",
        "closingStockDtls",
        "totCreditsToPL"
    })
    public static class CreditsToPL {

        @XmlElement(name = "SaleOfGoods", required = true, defaultValue = "0")
        protected BigInteger saleOfGoods;
        @XmlElement(name = "SaleOfServices", required = true, defaultValue = "0")
        protected BigInteger saleOfServices;
        @XmlElement(name = "OtherOperatingRevenueDtls")
        protected List<PARTAPL.CreditsToPL.OtherOperatingRevenueDtls> otherOperatingRevenueDtls;
        @XmlElement(name = "OperatingRevenueTotAmt", required = true, defaultValue = "0")
        protected BigInteger operatingRevenueTotAmt;
        @XmlElement(name = "IntrstIncaseOfForeignComp", defaultValue = "0")
        protected BigInteger intrstIncaseOfForeignComp;
        @XmlElement(name = "OtherFinanceServices", defaultValue = "0")
        protected BigInteger otherFinanceServices;
        @XmlElement(name = "BusinessReceipts", required = true, defaultValue = "0")
        protected BigInteger businessReceipts;
        @XmlElement(name = "ExciseCustomsVAT", required = true)
        protected ExciseCustomsVAT exciseCustomsVAT;
        @XmlElement(name = "TotRevenueFrmOperations", required = true, defaultValue = "0")
        protected BigInteger totRevenueFrmOperations;
        @XmlElement(name = "OthIncome", required = true)
        protected PARTAPL.CreditsToPL.OthIncome othIncome;
        @XmlElement(name = "ClosingStockDtls", required = true)
        protected PARTAPL.CreditsToPL.ClosingStockDtls closingStockDtls;
        @XmlElement(name = "TotCreditsToPL", defaultValue = "0")
        protected long totCreditsToPL;

        /**
         * Gets the value of the saleOfGoods property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSaleOfGoods() {
            return saleOfGoods;
        }

        /**
         * Sets the value of the saleOfGoods property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSaleOfGoods(BigInteger value) {
            this.saleOfGoods = value;
        }

        /**
         * Gets the value of the saleOfServices property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSaleOfServices() {
            return saleOfServices;
        }

        /**
         * Sets the value of the saleOfServices property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSaleOfServices(BigInteger value) {
            this.saleOfServices = value;
        }

        /**
         * Gets the value of the otherOperatingRevenueDtls property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the otherOperatingRevenueDtls property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOtherOperatingRevenueDtls().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PARTAPL.CreditsToPL.OtherOperatingRevenueDtls }
         * 
         * 
         */
        public List<PARTAPL.CreditsToPL.OtherOperatingRevenueDtls> getOtherOperatingRevenueDtls() {
            if (otherOperatingRevenueDtls == null) {
                otherOperatingRevenueDtls = new ArrayList<PARTAPL.CreditsToPL.OtherOperatingRevenueDtls>();
            }
            return this.otherOperatingRevenueDtls;
        }

        /**
         * Gets the value of the operatingRevenueTotAmt property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOperatingRevenueTotAmt() {
            return operatingRevenueTotAmt;
        }

        /**
         * Sets the value of the operatingRevenueTotAmt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOperatingRevenueTotAmt(BigInteger value) {
            this.operatingRevenueTotAmt = value;
        }

        /**
         * Gets the value of the intrstIncaseOfForeignComp property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getIntrstIncaseOfForeignComp() {
            return intrstIncaseOfForeignComp;
        }

        /**
         * Sets the value of the intrstIncaseOfForeignComp property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setIntrstIncaseOfForeignComp(BigInteger value) {
            this.intrstIncaseOfForeignComp = value;
        }

        /**
         * Gets the value of the otherFinanceServices property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOtherFinanceServices() {
            return otherFinanceServices;
        }

        /**
         * Sets the value of the otherFinanceServices property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOtherFinanceServices(BigInteger value) {
            this.otherFinanceServices = value;
        }

        /**
         * Gets the value of the businessReceipts property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBusinessReceipts() {
            return businessReceipts;
        }

        /**
         * Sets the value of the businessReceipts property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBusinessReceipts(BigInteger value) {
            this.businessReceipts = value;
        }

        /**
         * Gets the value of the exciseCustomsVAT property.
         * 
         * @return
         *     possible object is
         *     {@link ExciseCustomsVAT }
         *     
         */
        public ExciseCustomsVAT getExciseCustomsVAT() {
            return exciseCustomsVAT;
        }

        /**
         * Sets the value of the exciseCustomsVAT property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExciseCustomsVAT }
         *     
         */
        public void setExciseCustomsVAT(ExciseCustomsVAT value) {
            this.exciseCustomsVAT = value;
        }

        /**
         * Gets the value of the totRevenueFrmOperations property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotRevenueFrmOperations() {
            return totRevenueFrmOperations;
        }

        /**
         * Sets the value of the totRevenueFrmOperations property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotRevenueFrmOperations(BigInteger value) {
            this.totRevenueFrmOperations = value;
        }

        /**
         * Gets the value of the othIncome property.
         * 
         * @return
         *     possible object is
         *     {@link PARTAPL.CreditsToPL.OthIncome }
         *     
         */
        public PARTAPL.CreditsToPL.OthIncome getOthIncome() {
            return othIncome;
        }

        /**
         * Sets the value of the othIncome property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTAPL.CreditsToPL.OthIncome }
         *     
         */
        public void setOthIncome(PARTAPL.CreditsToPL.OthIncome value) {
            this.othIncome = value;
        }

        /**
         * Gets the value of the closingStockDtls property.
         * 
         * @return
         *     possible object is
         *     {@link PARTAPL.CreditsToPL.ClosingStockDtls }
         *     
         */
        public PARTAPL.CreditsToPL.ClosingStockDtls getClosingStockDtls() {
            return closingStockDtls;
        }

        /**
         * Sets the value of the closingStockDtls property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTAPL.CreditsToPL.ClosingStockDtls }
         *     
         */
        public void setClosingStockDtls(PARTAPL.CreditsToPL.ClosingStockDtls value) {
            this.closingStockDtls = value;
        }

        /**
         * Gets the value of the totCreditsToPL property.
         * 
         */
        public long getTotCreditsToPL() {
            return totCreditsToPL;
        }

        /**
         * Sets the value of the totCreditsToPL property.
         * 
         */
        public void setTotCreditsToPL(long value) {
            this.totCreditsToPL = value;
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
         *         &lt;element name="RawMaterial">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="WorkInProgress">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="FinishedGoods">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ClosingStock">
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
            "rawMaterial",
            "workInProgress",
            "finishedGoods",
            "closingStock"
        })
        public static class ClosingStockDtls {

            @XmlElement(name = "RawMaterial", required = true, defaultValue = "0")
            protected BigInteger rawMaterial;
            @XmlElement(name = "WorkInProgress", required = true, defaultValue = "0")
            protected BigInteger workInProgress;
            @XmlElement(name = "FinishedGoods", required = true, defaultValue = "0")
            protected BigInteger finishedGoods;
            @XmlElement(name = "ClosingStock", required = true, defaultValue = "0")
            protected BigInteger closingStock;

            /**
             * Gets the value of the rawMaterial property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getRawMaterial() {
                return rawMaterial;
            }

            /**
             * Sets the value of the rawMaterial property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setRawMaterial(BigInteger value) {
                this.rawMaterial = value;
            }

            /**
             * Gets the value of the workInProgress property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getWorkInProgress() {
                return workInProgress;
            }

            /**
             * Sets the value of the workInProgress property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setWorkInProgress(BigInteger value) {
                this.workInProgress = value;
            }

            /**
             * Gets the value of the finishedGoods property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getFinishedGoods() {
                return finishedGoods;
            }

            /**
             * Sets the value of the finishedGoods property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setFinishedGoods(BigInteger value) {
                this.finishedGoods = value;
            }

            /**
             * Gets the value of the closingStock property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getClosingStock() {
                return closingStock;
            }

            /**
             * Sets the value of the closingStock property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setClosingStock(BigInteger value) {
                this.closingStock = value;
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
         *         &lt;element name="RentInc">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Comissions">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Dividends">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="InterestInc">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ProfitOnSaleFixedAsset">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ProfitOnInvChrSTT">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ProfitOnOthInv">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ProfitOnCurrFluct">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ProfitOnAgriIncome">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="OtherIncDtls" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="NatureOfIncome">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;maxLength value="50"/>
         *                         &lt;minLength value="1"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="Amount">
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
         *         &lt;element name="MiscOthIncome">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="TotOthIncome">
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
            "rentInc",
            "comissions",
            "dividends",
            "interestInc",
            "profitOnSaleFixedAsset",
            "profitOnInvChrSTT",
            "profitOnOthInv",
            "profitOnCurrFluct",
            "profitOnAgriIncome",
            "otherIncDtls",
            "miscOthIncome",
            "totOthIncome"
        })
        public static class OthIncome {

            @XmlElement(name = "RentInc", required = true, defaultValue = "0")
            protected BigInteger rentInc;
            @XmlElement(name = "Comissions", required = true, defaultValue = "0")
            protected BigInteger comissions;
            @XmlElement(name = "Dividends", required = true, defaultValue = "0")
            protected BigInteger dividends;
            @XmlElement(name = "InterestInc", required = true, defaultValue = "0")
            protected BigInteger interestInc;
            @XmlElement(name = "ProfitOnSaleFixedAsset", defaultValue = "0")
            protected long profitOnSaleFixedAsset;
            @XmlElement(name = "ProfitOnInvChrSTT", defaultValue = "0")
            protected long profitOnInvChrSTT;
            @XmlElement(name = "ProfitOnOthInv", defaultValue = "0")
            protected long profitOnOthInv;
            @XmlElement(name = "ProfitOnCurrFluct", defaultValue = "0")
            protected long profitOnCurrFluct;
            @XmlElement(name = "ProfitOnAgriIncome", defaultValue = "0")
            protected long profitOnAgriIncome;
            @XmlElement(name = "OtherIncDtls")
            protected List<PARTAPL.CreditsToPL.OthIncome.OtherIncDtls> otherIncDtls;
            @XmlElement(name = "MiscOthIncome", defaultValue = "0")
            protected long miscOthIncome;
            @XmlElement(name = "TotOthIncome", defaultValue = "0")
            protected long totOthIncome;

            /**
             * Gets the value of the rentInc property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getRentInc() {
                return rentInc;
            }

            /**
             * Sets the value of the rentInc property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setRentInc(BigInteger value) {
                this.rentInc = value;
            }

            /**
             * Gets the value of the comissions property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getComissions() {
                return comissions;
            }

            /**
             * Sets the value of the comissions property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setComissions(BigInteger value) {
                this.comissions = value;
            }

            /**
             * Gets the value of the dividends property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getDividends() {
                return dividends;
            }

            /**
             * Sets the value of the dividends property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setDividends(BigInteger value) {
                this.dividends = value;
            }

            /**
             * Gets the value of the interestInc property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getInterestInc() {
                return interestInc;
            }

            /**
             * Sets the value of the interestInc property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setInterestInc(BigInteger value) {
                this.interestInc = value;
            }

            /**
             * Gets the value of the profitOnSaleFixedAsset property.
             * 
             */
            public long getProfitOnSaleFixedAsset() {
                return profitOnSaleFixedAsset;
            }

            /**
             * Sets the value of the profitOnSaleFixedAsset property.
             * 
             */
            public void setProfitOnSaleFixedAsset(long value) {
                this.profitOnSaleFixedAsset = value;
            }

            /**
             * Gets the value of the profitOnInvChrSTT property.
             * 
             */
            public long getProfitOnInvChrSTT() {
                return profitOnInvChrSTT;
            }

            /**
             * Sets the value of the profitOnInvChrSTT property.
             * 
             */
            public void setProfitOnInvChrSTT(long value) {
                this.profitOnInvChrSTT = value;
            }

            /**
             * Gets the value of the profitOnOthInv property.
             * 
             */
            public long getProfitOnOthInv() {
                return profitOnOthInv;
            }

            /**
             * Sets the value of the profitOnOthInv property.
             * 
             */
            public void setProfitOnOthInv(long value) {
                this.profitOnOthInv = value;
            }

            /**
             * Gets the value of the profitOnCurrFluct property.
             * 
             */
            public long getProfitOnCurrFluct() {
                return profitOnCurrFluct;
            }

            /**
             * Sets the value of the profitOnCurrFluct property.
             * 
             */
            public void setProfitOnCurrFluct(long value) {
                this.profitOnCurrFluct = value;
            }

            /**
             * Gets the value of the profitOnAgriIncome property.
             * 
             */
            public long getProfitOnAgriIncome() {
                return profitOnAgriIncome;
            }

            /**
             * Sets the value of the profitOnAgriIncome property.
             * 
             */
            public void setProfitOnAgriIncome(long value) {
                this.profitOnAgriIncome = value;
            }

            /**
             * Gets the value of the otherIncDtls property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the otherIncDtls property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOtherIncDtls().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PARTAPL.CreditsToPL.OthIncome.OtherIncDtls }
             * 
             * 
             */
            public List<PARTAPL.CreditsToPL.OthIncome.OtherIncDtls> getOtherIncDtls() {
                if (otherIncDtls == null) {
                    otherIncDtls = new ArrayList<PARTAPL.CreditsToPL.OthIncome.OtherIncDtls>();
                }
                return this.otherIncDtls;
            }

            /**
             * Gets the value of the miscOthIncome property.
             * 
             */
            public long getMiscOthIncome() {
                return miscOthIncome;
            }

            /**
             * Sets the value of the miscOthIncome property.
             * 
             */
            public void setMiscOthIncome(long value) {
                this.miscOthIncome = value;
            }

            /**
             * Gets the value of the totOthIncome property.
             * 
             */
            public long getTotOthIncome() {
                return totOthIncome;
            }

            /**
             * Sets the value of the totOthIncome property.
             * 
             */
            public void setTotOthIncome(long value) {
                this.totOthIncome = value;
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
             *         &lt;element name="NatureOfIncome">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;maxLength value="50"/>
             *               &lt;minLength value="1"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="Amount">
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
                "natureOfIncome",
                "amount"
            })
            public static class OtherIncDtls {

                @XmlElement(name = "NatureOfIncome", required = true)
                protected String natureOfIncome;
                @XmlElement(name = "Amount", required = true, defaultValue = "0")
                protected BigInteger amount;

                /**
                 * Gets the value of the natureOfIncome property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNatureOfIncome() {
                    return natureOfIncome;
                }

                /**
                 * Sets the value of the natureOfIncome property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNatureOfIncome(String value) {
                    this.natureOfIncome = value;
                }

                /**
                 * Gets the value of the amount property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getAmount() {
                    return amount;
                }

                /**
                 * Sets the value of the amount property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setAmount(BigInteger value) {
                    this.amount = value;
                }

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
         *         &lt;element name="OperatingRevenueName">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="50"/>
         *               &lt;minLength value="1"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="OperatingRevenueAmt">
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
            "operatingRevenueName",
            "operatingRevenueAmt"
        })
        public static class OtherOperatingRevenueDtls {

            @XmlElement(name = "OperatingRevenueName", required = true)
            protected String operatingRevenueName;
            @XmlElement(name = "OperatingRevenueAmt", required = true, defaultValue = "0")
            protected BigInteger operatingRevenueAmt;

            /**
             * Gets the value of the operatingRevenueName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOperatingRevenueName() {
                return operatingRevenueName;
            }

            /**
             * Sets the value of the operatingRevenueName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOperatingRevenueName(String value) {
                this.operatingRevenueName = value;
            }

            /**
             * Gets the value of the operatingRevenueAmt property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getOperatingRevenueAmt() {
                return operatingRevenueAmt;
            }

            /**
             * Sets the value of the operatingRevenueAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setOperatingRevenueAmt(BigInteger value) {
                this.operatingRevenueAmt = value;
            }

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
     *         &lt;element name="GrossReceipt" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="GrossProfit" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Expenses" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="NetProfit" minOccurs="0">
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
        "grossReceipt",
        "grossProfit",
        "expenses",
        "netProfit"
    })
    public static class NoBooksOfAccPL {

        @XmlElement(name = "GrossReceipt", defaultValue = "0")
        protected BigInteger grossReceipt;
        @XmlElement(name = "GrossProfit", defaultValue = "0")
        protected Long grossProfit;
        @XmlElement(name = "Expenses", defaultValue = "0")
        protected BigInteger expenses;
        @XmlElement(name = "NetProfit", defaultValue = "0")
        protected Long netProfit;

        /**
         * Gets the value of the grossReceipt property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getGrossReceipt() {
            return grossReceipt;
        }

        /**
         * Sets the value of the grossReceipt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setGrossReceipt(BigInteger value) {
            this.grossReceipt = value;
        }

        /**
         * Gets the value of the grossProfit property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getGrossProfit() {
            return grossProfit;
        }

        /**
         * Sets the value of the grossProfit property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setGrossProfit(Long value) {
            this.grossProfit = value;
        }

        /**
         * Gets the value of the expenses property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getExpenses() {
            return expenses;
        }

        /**
         * Sets the value of the expenses property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setExpenses(BigInteger value) {
            this.expenses = value;
        }

        /**
         * Gets the value of the netProfit property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getNetProfit() {
            return netProfit;
        }

        /**
         * Sets the value of the netProfit property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setNetProfit(Long value) {
            this.netProfit = value;
        }

    }

}
