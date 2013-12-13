
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
 *         &lt;element name="FundSrc">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PartnerOrMemberFund">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PartnerOrMemberCap">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ResrNSurp">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="RevResr">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="CapResr">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="StatResr">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="OthResr">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="CreditBalOfPLAccount">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotResrNSurp">
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
 *                             &lt;element name="TotPartnerOrMemberFund">
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
 *                   &lt;element name="LoanFunds">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SecrLoan">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="ForeignCurrLoan">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="RupeeLoan">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="FrmBank">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="FrmOthrs">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="TotRupeeLoan">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotSecrLoan">
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
 *                             &lt;element name="UnsecrLoan">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="ForeignCurrencyLoans">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="RupeeLoan">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="FrmBank">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="FrmPersonSpcfdUs40A2b">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="FrmOthrs">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="TotRupeeLoan">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotUnSecrLoan">
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
 *                             &lt;element name="TotLoanFund">
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
 *                   &lt;element name="DeferredTax">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Advances">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="FrmPersonSpcfdUs40A2b">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="FrmOthers">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="TotalAdvances">
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
 *                   &lt;element name="TotFundSrc">
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
 *         &lt;element name="FundApply">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FixedAsset">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="GrossBlock">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Depreciation">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="NetBlock">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="CapWrkProg">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="TotFixedAsset">
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
 *                   &lt;element name="Investments">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="LongTermInv">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="InvInProperty">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="EquityInstruments">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="ListedEquities">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="UnListedEquities">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Total">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="PreferenceShares">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="GovtOrTrustSecurities">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="DebenturesOrBonds">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="MutualFunds">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="Others">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotLongTermInv">
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
 *                             &lt;element name="ShortTermInv">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="EquityInstruments">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="ListedEquities">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="UnListedEquities">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Total">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="PreferenceShares">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="GovtOrTrustSecurities">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="DebenturesOrBonds">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="MutualFunds">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="Others">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotShortTermInv">
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
 *                             &lt;element name="TotInvestments">
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
 *                   &lt;element name="CurrAssetLoanAdv">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CurrAsset">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Inventories">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="RawMatl">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="WorkInProgress">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="FinOrTradGood">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="StkInTrade">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="StoresConsumables">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="LooseTools">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Others">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="TotInventries">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="SundryDebtorDtls">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="OutstandindMorethanOneYr">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Others">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="TotalSundryDebtors">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="CashOrBankBal">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="CashinHand">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="BankBal">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Others">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="TotCashOrBankBal">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="OthCurrAsset">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotCurrAsset">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="LoanAdv">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="AdvRecoverable">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="Deposits">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="BalWithRevAuth">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotLoanAdv">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="LoanAdvIncluded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="PurposeOFBusOrProf">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="NotForPurposeOFBusOrProf">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="TotCurrAssetLoanAdv">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="CurrLiabilitiesProv">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="CurrLiabilities">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="SundryCreditorDtls">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="OutstandindMorethanOneYr">
 *                                                             &lt;simpleType>
 *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                                 &lt;totalDigits value="14"/>
 *                                                               &lt;/restriction>
 *                                                             &lt;/simpleType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="Others">
 *                                                             &lt;simpleType>
 *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                                 &lt;totalDigits value="14"/>
 *                                                               &lt;/restriction>
 *                                                             &lt;/simpleType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="TotalSundryCreditors">
 *                                                             &lt;simpleType>
 *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                                 &lt;totalDigits value="14"/>
 *                                                               &lt;/restriction>
 *                                                             &lt;/simpleType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="LiabForLeasedAsset">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="AccrIntonLeasedAsset">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="AccrIntNotDue">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="IncRecvdInAdv">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="OtherPayables">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="TotCurrLiabilities">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Provisions">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="ITProvision">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="FBTProvision">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="WTProvision">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="ELSuperAnnGratProvision">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="OthProvision">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="TotProvisions">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotCurrLiabilitiesProvision">
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
 *                             &lt;element name="NetCurrAsset">
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
 *                   &lt;element name="MiscAdjust">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="MiscExpndr">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="DefTaxAsset">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="AccumultedLosses">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="TotMiscAdjust">
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
 *                   &lt;element name="TotFundApply">
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
 *         &lt;element name="NoBooksOfAccBS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TotSundryDbtAmt">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TotSundryCrdAmt">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TotStkInTradAmt">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CashBalAmt">
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
    "fundSrc",
    "fundApply",
    "noBooksOfAccBS"
})
@XmlRootElement(name = "PARTA_BS")
public class PARTABS {

    @XmlElement(name = "FundSrc", required = true)
    protected PARTABS.FundSrc fundSrc;
    @XmlElement(name = "FundApply", required = true)
    protected PARTABS.FundApply fundApply;
    @XmlElement(name = "NoBooksOfAccBS")
    protected PARTABS.NoBooksOfAccBS noBooksOfAccBS;

    /**
     * Gets the value of the fundSrc property.
     * 
     * @return
     *     possible object is
     *     {@link PARTABS.FundSrc }
     *     
     */
    public PARTABS.FundSrc getFundSrc() {
        return fundSrc;
    }

    /**
     * Sets the value of the fundSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTABS.FundSrc }
     *     
     */
    public void setFundSrc(PARTABS.FundSrc value) {
        this.fundSrc = value;
    }

    /**
     * Gets the value of the fundApply property.
     * 
     * @return
     *     possible object is
     *     {@link PARTABS.FundApply }
     *     
     */
    public PARTABS.FundApply getFundApply() {
        return fundApply;
    }

    /**
     * Sets the value of the fundApply property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTABS.FundApply }
     *     
     */
    public void setFundApply(PARTABS.FundApply value) {
        this.fundApply = value;
    }

    /**
     * Gets the value of the noBooksOfAccBS property.
     * 
     * @return
     *     possible object is
     *     {@link PARTABS.NoBooksOfAccBS }
     *     
     */
    public PARTABS.NoBooksOfAccBS getNoBooksOfAccBS() {
        return noBooksOfAccBS;
    }

    /**
     * Sets the value of the noBooksOfAccBS property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTABS.NoBooksOfAccBS }
     *     
     */
    public void setNoBooksOfAccBS(PARTABS.NoBooksOfAccBS value) {
        this.noBooksOfAccBS = value;
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
     *         &lt;element name="FixedAsset">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="GrossBlock">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Depreciation">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="NetBlock">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="CapWrkProg">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="TotFixedAsset">
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
     *         &lt;element name="Investments">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="LongTermInv">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="InvInProperty">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="EquityInstruments">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="ListedEquities">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="UnListedEquities">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="Total">
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
     *                             &lt;element name="PreferenceShares">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="GovtOrTrustSecurities">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="DebenturesOrBonds">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="MutualFunds">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="Others">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotLongTermInv">
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
     *                   &lt;element name="ShortTermInv">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="EquityInstruments">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="ListedEquities">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="UnListedEquities">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="Total">
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
     *                             &lt;element name="PreferenceShares">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="GovtOrTrustSecurities">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="DebenturesOrBonds">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="MutualFunds">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="Others">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotShortTermInv">
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
     *                   &lt;element name="TotInvestments">
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
     *         &lt;element name="CurrAssetLoanAdv">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CurrAsset">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Inventories">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="RawMatl">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="WorkInProgress">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="FinOrTradGood">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="StkInTrade">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="StoresConsumables">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="LooseTools">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="Others">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="TotInventries">
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
     *                             &lt;element name="SundryDebtorDtls">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="OutstandindMorethanOneYr">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="Others">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="TotalSundryDebtors">
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
     *                             &lt;element name="CashOrBankBal">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="CashinHand">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="BankBal">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="Others">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="TotCashOrBankBal">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="OthCurrAsset">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotCurrAsset">
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
     *                   &lt;element name="LoanAdv">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="AdvRecoverable">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="Deposits">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="BalWithRevAuth">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotLoanAdv">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="LoanAdvIncluded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="PurposeOFBusOrProf">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="NotForPurposeOFBusOrProf">
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
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="TotCurrAssetLoanAdv">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="CurrLiabilitiesProv">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="CurrLiabilities">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="SundryCreditorDtls">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="OutstandindMorethanOneYr">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                                       &lt;totalDigits value="14"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="Others">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                                       &lt;totalDigits value="14"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="TotalSundryCreditors">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                                       &lt;totalDigits value="14"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="LiabForLeasedAsset">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="AccrIntonLeasedAsset">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="AccrIntNotDue">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="IncRecvdInAdv">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="OtherPayables">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="TotCurrLiabilities">
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
     *                             &lt;element name="Provisions">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="ITProvision">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="FBTProvision">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="WTProvision">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="ELSuperAnnGratProvision">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="OthProvision">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="TotProvisions">
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
     *                             &lt;element name="TotCurrLiabilitiesProvision">
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
     *                   &lt;element name="NetCurrAsset">
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
     *         &lt;element name="MiscAdjust">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="MiscExpndr">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="DefTaxAsset">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="AccumultedLosses">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="TotMiscAdjust">
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
     *         &lt;element name="TotFundApply">
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
        "fixedAsset",
        "investments",
        "currAssetLoanAdv",
        "miscAdjust",
        "totFundApply"
    })
    public static class FundApply {

        @XmlElement(name = "FixedAsset", required = true)
        protected PARTABS.FundApply.FixedAsset fixedAsset;
        @XmlElement(name = "Investments", required = true)
        protected PARTABS.FundApply.Investments investments;
        @XmlElement(name = "CurrAssetLoanAdv", required = true)
        protected PARTABS.FundApply.CurrAssetLoanAdv currAssetLoanAdv;
        @XmlElement(name = "MiscAdjust", required = true)
        protected PARTABS.FundApply.MiscAdjust miscAdjust;
        @XmlElement(name = "TotFundApply", defaultValue = "0")
        protected long totFundApply;

        /**
         * Gets the value of the fixedAsset property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABS.FundApply.FixedAsset }
         *     
         */
        public PARTABS.FundApply.FixedAsset getFixedAsset() {
            return fixedAsset;
        }

        /**
         * Sets the value of the fixedAsset property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABS.FundApply.FixedAsset }
         *     
         */
        public void setFixedAsset(PARTABS.FundApply.FixedAsset value) {
            this.fixedAsset = value;
        }

        /**
         * Gets the value of the investments property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABS.FundApply.Investments }
         *     
         */
        public PARTABS.FundApply.Investments getInvestments() {
            return investments;
        }

        /**
         * Sets the value of the investments property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABS.FundApply.Investments }
         *     
         */
        public void setInvestments(PARTABS.FundApply.Investments value) {
            this.investments = value;
        }

        /**
         * Gets the value of the currAssetLoanAdv property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABS.FundApply.CurrAssetLoanAdv }
         *     
         */
        public PARTABS.FundApply.CurrAssetLoanAdv getCurrAssetLoanAdv() {
            return currAssetLoanAdv;
        }

        /**
         * Sets the value of the currAssetLoanAdv property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABS.FundApply.CurrAssetLoanAdv }
         *     
         */
        public void setCurrAssetLoanAdv(PARTABS.FundApply.CurrAssetLoanAdv value) {
            this.currAssetLoanAdv = value;
        }

        /**
         * Gets the value of the miscAdjust property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABS.FundApply.MiscAdjust }
         *     
         */
        public PARTABS.FundApply.MiscAdjust getMiscAdjust() {
            return miscAdjust;
        }

        /**
         * Sets the value of the miscAdjust property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABS.FundApply.MiscAdjust }
         *     
         */
        public void setMiscAdjust(PARTABS.FundApply.MiscAdjust value) {
            this.miscAdjust = value;
        }

        /**
         * Gets the value of the totFundApply property.
         * 
         */
        public long getTotFundApply() {
            return totFundApply;
        }

        /**
         * Sets the value of the totFundApply property.
         * 
         */
        public void setTotFundApply(long value) {
            this.totFundApply = value;
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
         *         &lt;element name="CurrAsset">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Inventories">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="RawMatl">
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
         *                             &lt;element name="FinOrTradGood">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="StkInTrade">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="StoresConsumables">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="LooseTools">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="Others">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="TotInventries">
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
         *                   &lt;element name="SundryDebtorDtls">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="OutstandindMorethanOneYr">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="Others">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="TotalSundryDebtors">
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
         *                   &lt;element name="CashOrBankBal">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="CashinHand">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="BankBal">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="Others">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="TotCashOrBankBal">
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
         *                   &lt;element name="OthCurrAsset">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotCurrAsset">
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
         *         &lt;element name="LoanAdv">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="AdvRecoverable">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="Deposits">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="BalWithRevAuth">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotLoanAdv">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="LoanAdvIncluded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="PurposeOFBusOrProf">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="NotForPurposeOFBusOrProf">
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
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="TotCurrAssetLoanAdv">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="CurrLiabilitiesProv">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="CurrLiabilities">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="SundryCreditorDtls">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="OutstandindMorethanOneYr">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                             &lt;totalDigits value="14"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="Others">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                             &lt;totalDigits value="14"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="TotalSundryCreditors">
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
         *                             &lt;element name="LiabForLeasedAsset">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="AccrIntonLeasedAsset">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="AccrIntNotDue">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="IncRecvdInAdv">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="OtherPayables">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="TotCurrLiabilities">
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
         *                   &lt;element name="Provisions">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="ITProvision">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="FBTProvision">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="WTProvision">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="ELSuperAnnGratProvision">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="OthProvision">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="TotProvisions">
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
         *                   &lt;element name="TotCurrLiabilitiesProvision">
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
         *         &lt;element name="NetCurrAsset">
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
            "currAsset",
            "loanAdv",
            "totCurrAssetLoanAdv",
            "currLiabilitiesProv",
            "netCurrAsset"
        })
        public static class CurrAssetLoanAdv {

            @XmlElement(name = "CurrAsset", required = true)
            protected PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset currAsset;
            @XmlElement(name = "LoanAdv", required = true)
            protected PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv loanAdv;
            @XmlElement(name = "TotCurrAssetLoanAdv", defaultValue = "0")
            protected long totCurrAssetLoanAdv;
            @XmlElement(name = "CurrLiabilitiesProv", required = true)
            protected PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv currLiabilitiesProv;
            @XmlElement(name = "NetCurrAsset", defaultValue = "0")
            protected long netCurrAsset;

            /**
             * Gets the value of the currAsset property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset }
             *     
             */
            public PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset getCurrAsset() {
                return currAsset;
            }

            /**
             * Sets the value of the currAsset property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset }
             *     
             */
            public void setCurrAsset(PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset value) {
                this.currAsset = value;
            }

            /**
             * Gets the value of the loanAdv property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv }
             *     
             */
            public PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv getLoanAdv() {
                return loanAdv;
            }

            /**
             * Sets the value of the loanAdv property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv }
             *     
             */
            public void setLoanAdv(PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv value) {
                this.loanAdv = value;
            }

            /**
             * Gets the value of the totCurrAssetLoanAdv property.
             * 
             */
            public long getTotCurrAssetLoanAdv() {
                return totCurrAssetLoanAdv;
            }

            /**
             * Sets the value of the totCurrAssetLoanAdv property.
             * 
             */
            public void setTotCurrAssetLoanAdv(long value) {
                this.totCurrAssetLoanAdv = value;
            }

            /**
             * Gets the value of the currLiabilitiesProv property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv }
             *     
             */
            public PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv getCurrLiabilitiesProv() {
                return currLiabilitiesProv;
            }

            /**
             * Sets the value of the currLiabilitiesProv property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv }
             *     
             */
            public void setCurrLiabilitiesProv(PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv value) {
                this.currLiabilitiesProv = value;
            }

            /**
             * Gets the value of the netCurrAsset property.
             * 
             */
            public long getNetCurrAsset() {
                return netCurrAsset;
            }

            /**
             * Sets the value of the netCurrAsset property.
             * 
             */
            public void setNetCurrAsset(long value) {
                this.netCurrAsset = value;
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
             *         &lt;element name="Inventories">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="RawMatl">
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
             *                   &lt;element name="FinOrTradGood">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="StkInTrade">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="StoresConsumables">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="LooseTools">
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
             *                   &lt;element name="TotInventries">
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
             *         &lt;element name="SundryDebtorDtls">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="OutstandindMorethanOneYr">
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
             *                   &lt;element name="TotalSundryDebtors">
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
             *         &lt;element name="CashOrBankBal">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="CashinHand">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="BankBal">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="Others">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="TotCashOrBankBal">
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
             *         &lt;element name="OthCurrAsset">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotCurrAsset">
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
                "inventories",
                "sundryDebtorDtls",
                "cashOrBankBal",
                "othCurrAsset",
                "totCurrAsset"
            })
            public static class CurrAsset {

                @XmlElement(name = "Inventories", required = true)
                protected PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.Inventories inventories;
                @XmlElement(name = "SundryDebtorDtls", required = true)
                protected PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.SundryDebtorDtls sundryDebtorDtls;
                @XmlElement(name = "CashOrBankBal", required = true)
                protected PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.CashOrBankBal cashOrBankBal;
                @XmlElement(name = "OthCurrAsset", defaultValue = "0")
                protected long othCurrAsset;
                @XmlElement(name = "TotCurrAsset", defaultValue = "0")
                protected long totCurrAsset;

                /**
                 * Gets the value of the inventories property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.Inventories }
                 *     
                 */
                public PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.Inventories getInventories() {
                    return inventories;
                }

                /**
                 * Sets the value of the inventories property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.Inventories }
                 *     
                 */
                public void setInventories(PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.Inventories value) {
                    this.inventories = value;
                }

                /**
                 * Gets the value of the sundryDebtorDtls property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.SundryDebtorDtls }
                 *     
                 */
                public PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.SundryDebtorDtls getSundryDebtorDtls() {
                    return sundryDebtorDtls;
                }

                /**
                 * Sets the value of the sundryDebtorDtls property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.SundryDebtorDtls }
                 *     
                 */
                public void setSundryDebtorDtls(PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.SundryDebtorDtls value) {
                    this.sundryDebtorDtls = value;
                }

                /**
                 * Gets the value of the cashOrBankBal property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.CashOrBankBal }
                 *     
                 */
                public PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.CashOrBankBal getCashOrBankBal() {
                    return cashOrBankBal;
                }

                /**
                 * Sets the value of the cashOrBankBal property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.CashOrBankBal }
                 *     
                 */
                public void setCashOrBankBal(PARTABS.FundApply.CurrAssetLoanAdv.CurrAsset.CashOrBankBal value) {
                    this.cashOrBankBal = value;
                }

                /**
                 * Gets the value of the othCurrAsset property.
                 * 
                 */
                public long getOthCurrAsset() {
                    return othCurrAsset;
                }

                /**
                 * Sets the value of the othCurrAsset property.
                 * 
                 */
                public void setOthCurrAsset(long value) {
                    this.othCurrAsset = value;
                }

                /**
                 * Gets the value of the totCurrAsset property.
                 * 
                 */
                public long getTotCurrAsset() {
                    return totCurrAsset;
                }

                /**
                 * Sets the value of the totCurrAsset property.
                 * 
                 */
                public void setTotCurrAsset(long value) {
                    this.totCurrAsset = value;
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
                 *         &lt;element name="CashinHand">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="BankBal">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="Others">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="TotCashOrBankBal">
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
                    "cashinHand",
                    "bankBal",
                    "others",
                    "totCashOrBankBal"
                })
                public static class CashOrBankBal {

                    @XmlElement(name = "CashinHand", required = true, defaultValue = "0")
                    protected BigInteger cashinHand;
                    @XmlElement(name = "BankBal", defaultValue = "0")
                    protected long bankBal;
                    @XmlElement(name = "Others", defaultValue = "0")
                    protected long others;
                    @XmlElement(name = "TotCashOrBankBal", defaultValue = "0")
                    protected long totCashOrBankBal;

                    /**
                     * Gets the value of the cashinHand property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getCashinHand() {
                        return cashinHand;
                    }

                    /**
                     * Sets the value of the cashinHand property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setCashinHand(BigInteger value) {
                        this.cashinHand = value;
                    }

                    /**
                     * Gets the value of the bankBal property.
                     * 
                     */
                    public long getBankBal() {
                        return bankBal;
                    }

                    /**
                     * Sets the value of the bankBal property.
                     * 
                     */
                    public void setBankBal(long value) {
                        this.bankBal = value;
                    }

                    /**
                     * Gets the value of the others property.
                     * 
                     */
                    public long getOthers() {
                        return others;
                    }

                    /**
                     * Sets the value of the others property.
                     * 
                     */
                    public void setOthers(long value) {
                        this.others = value;
                    }

                    /**
                     * Gets the value of the totCashOrBankBal property.
                     * 
                     */
                    public long getTotCashOrBankBal() {
                        return totCashOrBankBal;
                    }

                    /**
                     * Sets the value of the totCashOrBankBal property.
                     * 
                     */
                    public void setTotCashOrBankBal(long value) {
                        this.totCashOrBankBal = value;
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
                 *         &lt;element name="RawMatl">
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
                 *         &lt;element name="FinOrTradGood">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="StkInTrade">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="StoresConsumables">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="LooseTools">
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
                 *         &lt;element name="TotInventries">
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
                    "rawMatl",
                    "workInProgress",
                    "finOrTradGood",
                    "stkInTrade",
                    "storesConsumables",
                    "looseTools",
                    "others",
                    "totInventries"
                })
                public static class Inventories {

                    @XmlElement(name = "RawMatl", required = true, defaultValue = "0")
                    protected BigInteger rawMatl;
                    @XmlElement(name = "WorkInProgress", required = true, defaultValue = "0")
                    protected BigInteger workInProgress;
                    @XmlElement(name = "FinOrTradGood", required = true, defaultValue = "0")
                    protected BigInteger finOrTradGood;
                    @XmlElement(name = "StkInTrade", required = true, defaultValue = "0")
                    protected BigInteger stkInTrade;
                    @XmlElement(name = "StoresConsumables", required = true, defaultValue = "0")
                    protected BigInteger storesConsumables;
                    @XmlElement(name = "LooseTools", required = true, defaultValue = "0")
                    protected BigInteger looseTools;
                    @XmlElement(name = "Others", required = true, defaultValue = "0")
                    protected BigInteger others;
                    @XmlElement(name = "TotInventries", required = true, defaultValue = "0")
                    protected BigInteger totInventries;

                    /**
                     * Gets the value of the rawMatl property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getRawMatl() {
                        return rawMatl;
                    }

                    /**
                     * Sets the value of the rawMatl property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setRawMatl(BigInteger value) {
                        this.rawMatl = value;
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
                     * Gets the value of the finOrTradGood property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getFinOrTradGood() {
                        return finOrTradGood;
                    }

                    /**
                     * Sets the value of the finOrTradGood property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setFinOrTradGood(BigInteger value) {
                        this.finOrTradGood = value;
                    }

                    /**
                     * Gets the value of the stkInTrade property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getStkInTrade() {
                        return stkInTrade;
                    }

                    /**
                     * Sets the value of the stkInTrade property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setStkInTrade(BigInteger value) {
                        this.stkInTrade = value;
                    }

                    /**
                     * Gets the value of the storesConsumables property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getStoresConsumables() {
                        return storesConsumables;
                    }

                    /**
                     * Sets the value of the storesConsumables property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setStoresConsumables(BigInteger value) {
                        this.storesConsumables = value;
                    }

                    /**
                     * Gets the value of the looseTools property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getLooseTools() {
                        return looseTools;
                    }

                    /**
                     * Sets the value of the looseTools property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setLooseTools(BigInteger value) {
                        this.looseTools = value;
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
                     * Gets the value of the totInventries property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotInventries() {
                        return totInventries;
                    }

                    /**
                     * Sets the value of the totInventries property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotInventries(BigInteger value) {
                        this.totInventries = value;
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
                 *         &lt;element name="OutstandindMorethanOneYr">
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
                 *         &lt;element name="TotalSundryDebtors">
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
                    "outstandindMorethanOneYr",
                    "others",
                    "totalSundryDebtors"
                })
                public static class SundryDebtorDtls {

                    @XmlElement(name = "OutstandindMorethanOneYr", required = true, defaultValue = "0")
                    protected BigInteger outstandindMorethanOneYr;
                    @XmlElement(name = "Others", required = true, defaultValue = "0")
                    protected BigInteger others;
                    @XmlElement(name = "TotalSundryDebtors", required = true, defaultValue = "0")
                    protected BigInteger totalSundryDebtors;

                    /**
                     * Gets the value of the outstandindMorethanOneYr property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getOutstandindMorethanOneYr() {
                        return outstandindMorethanOneYr;
                    }

                    /**
                     * Sets the value of the outstandindMorethanOneYr property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setOutstandindMorethanOneYr(BigInteger value) {
                        this.outstandindMorethanOneYr = value;
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
                     * Gets the value of the totalSundryDebtors property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotalSundryDebtors() {
                        return totalSundryDebtors;
                    }

                    /**
                     * Sets the value of the totalSundryDebtors property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotalSundryDebtors(BigInteger value) {
                        this.totalSundryDebtors = value;
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
             *         &lt;element name="CurrLiabilities">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="SundryCreditorDtls">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="OutstandindMorethanOneYr">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                                   &lt;totalDigits value="14"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="Others">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                                   &lt;totalDigits value="14"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="TotalSundryCreditors">
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
             *                   &lt;element name="LiabForLeasedAsset">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="AccrIntonLeasedAsset">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="AccrIntNotDue">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="IncRecvdInAdv">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="OtherPayables">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="TotCurrLiabilities">
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
             *         &lt;element name="Provisions">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="ITProvision">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="FBTProvision">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="WTProvision">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="ELSuperAnnGratProvision">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="OthProvision">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="TotProvisions">
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
             *         &lt;element name="TotCurrLiabilitiesProvision">
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
                "currLiabilities",
                "provisions",
                "totCurrLiabilitiesProvision"
            })
            public static class CurrLiabilitiesProv {

                @XmlElement(name = "CurrLiabilities", required = true)
                protected PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities currLiabilities;
                @XmlElement(name = "Provisions", required = true)
                protected PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.Provisions provisions;
                @XmlElement(name = "TotCurrLiabilitiesProvision", required = true, defaultValue = "0")
                protected BigInteger totCurrLiabilitiesProvision;

                /**
                 * Gets the value of the currLiabilities property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities }
                 *     
                 */
                public PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities getCurrLiabilities() {
                    return currLiabilities;
                }

                /**
                 * Sets the value of the currLiabilities property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities }
                 *     
                 */
                public void setCurrLiabilities(PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities value) {
                    this.currLiabilities = value;
                }

                /**
                 * Gets the value of the provisions property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.Provisions }
                 *     
                 */
                public PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.Provisions getProvisions() {
                    return provisions;
                }

                /**
                 * Sets the value of the provisions property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.Provisions }
                 *     
                 */
                public void setProvisions(PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.Provisions value) {
                    this.provisions = value;
                }

                /**
                 * Gets the value of the totCurrLiabilitiesProvision property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotCurrLiabilitiesProvision() {
                    return totCurrLiabilitiesProvision;
                }

                /**
                 * Sets the value of the totCurrLiabilitiesProvision property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotCurrLiabilitiesProvision(BigInteger value) {
                    this.totCurrLiabilitiesProvision = value;
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
                 *         &lt;element name="SundryCreditorDtls">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="OutstandindMorethanOneYr">
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
                 *                   &lt;element name="TotalSundryCreditors">
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
                 *         &lt;element name="LiabForLeasedAsset">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="AccrIntonLeasedAsset">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="AccrIntNotDue">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="IncRecvdInAdv">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="OtherPayables">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="TotCurrLiabilities">
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
                    "sundryCreditorDtls",
                    "liabForLeasedAsset",
                    "accrIntonLeasedAsset",
                    "accrIntNotDue",
                    "incRecvdInAdv",
                    "otherPayables",
                    "totCurrLiabilities"
                })
                public static class CurrLiabilities {

                    @XmlElement(name = "SundryCreditorDtls", required = true)
                    protected PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities.SundryCreditorDtls sundryCreditorDtls;
                    @XmlElement(name = "LiabForLeasedAsset", required = true, defaultValue = "0")
                    protected BigInteger liabForLeasedAsset;
                    @XmlElement(name = "AccrIntonLeasedAsset", required = true, defaultValue = "0")
                    protected BigInteger accrIntonLeasedAsset;
                    @XmlElement(name = "AccrIntNotDue", required = true, defaultValue = "0")
                    protected BigInteger accrIntNotDue;
                    @XmlElement(name = "IncRecvdInAdv", required = true, defaultValue = "0")
                    protected BigInteger incRecvdInAdv;
                    @XmlElement(name = "OtherPayables", required = true, defaultValue = "0")
                    protected BigInteger otherPayables;
                    @XmlElement(name = "TotCurrLiabilities", required = true, defaultValue = "0")
                    protected BigInteger totCurrLiabilities;

                    /**
                     * Gets the value of the sundryCreditorDtls property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities.SundryCreditorDtls }
                     *     
                     */
                    public PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities.SundryCreditorDtls getSundryCreditorDtls() {
                        return sundryCreditorDtls;
                    }

                    /**
                     * Sets the value of the sundryCreditorDtls property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities.SundryCreditorDtls }
                     *     
                     */
                    public void setSundryCreditorDtls(PARTABS.FundApply.CurrAssetLoanAdv.CurrLiabilitiesProv.CurrLiabilities.SundryCreditorDtls value) {
                        this.sundryCreditorDtls = value;
                    }

                    /**
                     * Gets the value of the liabForLeasedAsset property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getLiabForLeasedAsset() {
                        return liabForLeasedAsset;
                    }

                    /**
                     * Sets the value of the liabForLeasedAsset property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setLiabForLeasedAsset(BigInteger value) {
                        this.liabForLeasedAsset = value;
                    }

                    /**
                     * Gets the value of the accrIntonLeasedAsset property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getAccrIntonLeasedAsset() {
                        return accrIntonLeasedAsset;
                    }

                    /**
                     * Sets the value of the accrIntonLeasedAsset property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setAccrIntonLeasedAsset(BigInteger value) {
                        this.accrIntonLeasedAsset = value;
                    }

                    /**
                     * Gets the value of the accrIntNotDue property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getAccrIntNotDue() {
                        return accrIntNotDue;
                    }

                    /**
                     * Sets the value of the accrIntNotDue property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setAccrIntNotDue(BigInteger value) {
                        this.accrIntNotDue = value;
                    }

                    /**
                     * Gets the value of the incRecvdInAdv property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getIncRecvdInAdv() {
                        return incRecvdInAdv;
                    }

                    /**
                     * Sets the value of the incRecvdInAdv property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setIncRecvdInAdv(BigInteger value) {
                        this.incRecvdInAdv = value;
                    }

                    /**
                     * Gets the value of the otherPayables property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getOtherPayables() {
                        return otherPayables;
                    }

                    /**
                     * Sets the value of the otherPayables property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setOtherPayables(BigInteger value) {
                        this.otherPayables = value;
                    }

                    /**
                     * Gets the value of the totCurrLiabilities property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotCurrLiabilities() {
                        return totCurrLiabilities;
                    }

                    /**
                     * Sets the value of the totCurrLiabilities property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotCurrLiabilities(BigInteger value) {
                        this.totCurrLiabilities = value;
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
                     *         &lt;element name="OutstandindMorethanOneYr">
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
                     *         &lt;element name="TotalSundryCreditors">
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
                        "outstandindMorethanOneYr",
                        "others",
                        "totalSundryCreditors"
                    })
                    public static class SundryCreditorDtls {

                        @XmlElement(name = "OutstandindMorethanOneYr", required = true, defaultValue = "0")
                        protected BigInteger outstandindMorethanOneYr;
                        @XmlElement(name = "Others", required = true, defaultValue = "0")
                        protected BigInteger others;
                        @XmlElement(name = "TotalSundryCreditors", required = true, defaultValue = "0")
                        protected BigInteger totalSundryCreditors;

                        /**
                         * Gets the value of the outstandindMorethanOneYr property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BigInteger }
                         *     
                         */
                        public BigInteger getOutstandindMorethanOneYr() {
                            return outstandindMorethanOneYr;
                        }

                        /**
                         * Sets the value of the outstandindMorethanOneYr property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BigInteger }
                         *     
                         */
                        public void setOutstandindMorethanOneYr(BigInteger value) {
                            this.outstandindMorethanOneYr = value;
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
                         * Gets the value of the totalSundryCreditors property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BigInteger }
                         *     
                         */
                        public BigInteger getTotalSundryCreditors() {
                            return totalSundryCreditors;
                        }

                        /**
                         * Sets the value of the totalSundryCreditors property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BigInteger }
                         *     
                         */
                        public void setTotalSundryCreditors(BigInteger value) {
                            this.totalSundryCreditors = value;
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
                 *         &lt;element name="ITProvision">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="FBTProvision">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="WTProvision">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="ELSuperAnnGratProvision">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="OthProvision">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="TotProvisions">
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
                    "itProvision",
                    "fbtProvision",
                    "wtProvision",
                    "elSuperAnnGratProvision",
                    "othProvision",
                    "totProvisions"
                })
                public static class Provisions {

                    @XmlElement(name = "ITProvision", required = true, defaultValue = "0")
                    protected BigInteger itProvision;
                    @XmlElement(name = "FBTProvision", required = true, defaultValue = "0")
                    protected BigInteger fbtProvision;
                    @XmlElement(name = "WTProvision", required = true, defaultValue = "0")
                    protected BigInteger wtProvision;
                    @XmlElement(name = "ELSuperAnnGratProvision", required = true, defaultValue = "0")
                    protected BigInteger elSuperAnnGratProvision;
                    @XmlElement(name = "OthProvision", required = true, defaultValue = "0")
                    protected BigInteger othProvision;
                    @XmlElement(name = "TotProvisions", required = true, defaultValue = "0")
                    protected BigInteger totProvisions;

                    /**
                     * Gets the value of the itProvision property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getITProvision() {
                        return itProvision;
                    }

                    /**
                     * Sets the value of the itProvision property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setITProvision(BigInteger value) {
                        this.itProvision = value;
                    }

                    /**
                     * Gets the value of the fbtProvision property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getFBTProvision() {
                        return fbtProvision;
                    }

                    /**
                     * Sets the value of the fbtProvision property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setFBTProvision(BigInteger value) {
                        this.fbtProvision = value;
                    }

                    /**
                     * Gets the value of the wtProvision property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getWTProvision() {
                        return wtProvision;
                    }

                    /**
                     * Sets the value of the wtProvision property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setWTProvision(BigInteger value) {
                        this.wtProvision = value;
                    }

                    /**
                     * Gets the value of the elSuperAnnGratProvision property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getELSuperAnnGratProvision() {
                        return elSuperAnnGratProvision;
                    }

                    /**
                     * Sets the value of the elSuperAnnGratProvision property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setELSuperAnnGratProvision(BigInteger value) {
                        this.elSuperAnnGratProvision = value;
                    }

                    /**
                     * Gets the value of the othProvision property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getOthProvision() {
                        return othProvision;
                    }

                    /**
                     * Sets the value of the othProvision property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setOthProvision(BigInteger value) {
                        this.othProvision = value;
                    }

                    /**
                     * Gets the value of the totProvisions property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotProvisions() {
                        return totProvisions;
                    }

                    /**
                     * Sets the value of the totProvisions property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotProvisions(BigInteger value) {
                        this.totProvisions = value;
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
             *         &lt;element name="AdvRecoverable">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="Deposits">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="BalWithRevAuth">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotLoanAdv">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="LoanAdvIncluded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="PurposeOFBusOrProf">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="NotForPurposeOFBusOrProf">
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
                "advRecoverable",
                "deposits",
                "balWithRevAuth",
                "totLoanAdv",
                "loanAdvIncluded"
            })
            public static class LoanAdv {

                @XmlElement(name = "AdvRecoverable", required = true, defaultValue = "0")
                protected BigInteger advRecoverable;
                @XmlElement(name = "Deposits", required = true, defaultValue = "0")
                protected BigInteger deposits;
                @XmlElement(name = "BalWithRevAuth", required = true, defaultValue = "0")
                protected BigInteger balWithRevAuth;
                @XmlElement(name = "TotLoanAdv", required = true, defaultValue = "0")
                protected BigInteger totLoanAdv;
                @XmlElement(name = "LoanAdvIncluded", required = true)
                protected PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv.LoanAdvIncluded loanAdvIncluded;

                /**
                 * Gets the value of the advRecoverable property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getAdvRecoverable() {
                    return advRecoverable;
                }

                /**
                 * Sets the value of the advRecoverable property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setAdvRecoverable(BigInteger value) {
                    this.advRecoverable = value;
                }

                /**
                 * Gets the value of the deposits property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getDeposits() {
                    return deposits;
                }

                /**
                 * Sets the value of the deposits property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setDeposits(BigInteger value) {
                    this.deposits = value;
                }

                /**
                 * Gets the value of the balWithRevAuth property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getBalWithRevAuth() {
                    return balWithRevAuth;
                }

                /**
                 * Sets the value of the balWithRevAuth property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setBalWithRevAuth(BigInteger value) {
                    this.balWithRevAuth = value;
                }

                /**
                 * Gets the value of the totLoanAdv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotLoanAdv() {
                    return totLoanAdv;
                }

                /**
                 * Sets the value of the totLoanAdv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotLoanAdv(BigInteger value) {
                    this.totLoanAdv = value;
                }

                /**
                 * Gets the value of the loanAdvIncluded property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv.LoanAdvIncluded }
                 *     
                 */
                public PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv.LoanAdvIncluded getLoanAdvIncluded() {
                    return loanAdvIncluded;
                }

                /**
                 * Sets the value of the loanAdvIncluded property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv.LoanAdvIncluded }
                 *     
                 */
                public void setLoanAdvIncluded(PARTABS.FundApply.CurrAssetLoanAdv.LoanAdv.LoanAdvIncluded value) {
                    this.loanAdvIncluded = value;
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
                 *         &lt;element name="PurposeOFBusOrProf">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="NotForPurposeOFBusOrProf">
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
                    "purposeOFBusOrProf",
                    "notForPurposeOFBusOrProf"
                })
                public static class LoanAdvIncluded {

                    @XmlElement(name = "PurposeOFBusOrProf", required = true, defaultValue = "0")
                    protected BigInteger purposeOFBusOrProf;
                    @XmlElement(name = "NotForPurposeOFBusOrProf", required = true, defaultValue = "0")
                    protected BigInteger notForPurposeOFBusOrProf;

                    /**
                     * Gets the value of the purposeOFBusOrProf property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getPurposeOFBusOrProf() {
                        return purposeOFBusOrProf;
                    }

                    /**
                     * Sets the value of the purposeOFBusOrProf property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setPurposeOFBusOrProf(BigInteger value) {
                        this.purposeOFBusOrProf = value;
                    }

                    /**
                     * Gets the value of the notForPurposeOFBusOrProf property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getNotForPurposeOFBusOrProf() {
                        return notForPurposeOFBusOrProf;
                    }

                    /**
                     * Sets the value of the notForPurposeOFBusOrProf property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setNotForPurposeOFBusOrProf(BigInteger value) {
                        this.notForPurposeOFBusOrProf = value;
                    }

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
         *         &lt;element name="GrossBlock">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Depreciation">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="NetBlock">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="CapWrkProg">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="TotFixedAsset">
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
            "grossBlock",
            "depreciation",
            "netBlock",
            "capWrkProg",
            "totFixedAsset"
        })
        public static class FixedAsset {

            @XmlElement(name = "GrossBlock", required = true, defaultValue = "0")
            protected BigInteger grossBlock;
            @XmlElement(name = "Depreciation", required = true, defaultValue = "0")
            protected BigInteger depreciation;
            @XmlElement(name = "NetBlock", required = true, defaultValue = "0")
            protected BigInteger netBlock;
            @XmlElement(name = "CapWrkProg", required = true, defaultValue = "0")
            protected BigInteger capWrkProg;
            @XmlElement(name = "TotFixedAsset", required = true, defaultValue = "0")
            protected BigInteger totFixedAsset;

            /**
             * Gets the value of the grossBlock property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getGrossBlock() {
                return grossBlock;
            }

            /**
             * Sets the value of the grossBlock property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setGrossBlock(BigInteger value) {
                this.grossBlock = value;
            }

            /**
             * Gets the value of the depreciation property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getDepreciation() {
                return depreciation;
            }

            /**
             * Sets the value of the depreciation property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setDepreciation(BigInteger value) {
                this.depreciation = value;
            }

            /**
             * Gets the value of the netBlock property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getNetBlock() {
                return netBlock;
            }

            /**
             * Sets the value of the netBlock property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setNetBlock(BigInteger value) {
                this.netBlock = value;
            }

            /**
             * Gets the value of the capWrkProg property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getCapWrkProg() {
                return capWrkProg;
            }

            /**
             * Sets the value of the capWrkProg property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setCapWrkProg(BigInteger value) {
                this.capWrkProg = value;
            }

            /**
             * Gets the value of the totFixedAsset property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getTotFixedAsset() {
                return totFixedAsset;
            }

            /**
             * Sets the value of the totFixedAsset property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTotFixedAsset(BigInteger value) {
                this.totFixedAsset = value;
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
         *         &lt;element name="LongTermInv">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="InvInProperty">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="EquityInstruments">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="ListedEquities">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="UnListedEquities">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="Total">
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
         *                   &lt;element name="PreferenceShares">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="GovtOrTrustSecurities">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="DebenturesOrBonds">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="MutualFunds">
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
         *                   &lt;element name="TotLongTermInv">
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
         *         &lt;element name="ShortTermInv">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="EquityInstruments">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="ListedEquities">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="UnListedEquities">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="Total">
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
         *                   &lt;element name="PreferenceShares">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="GovtOrTrustSecurities">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="DebenturesOrBonds">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="MutualFunds">
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
         *                   &lt;element name="TotShortTermInv">
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
         *         &lt;element name="TotInvestments">
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
            "longTermInv",
            "shortTermInv",
            "totInvestments"
        })
        public static class Investments {

            @XmlElement(name = "LongTermInv", required = true)
            protected PARTABS.FundApply.Investments.LongTermInv longTermInv;
            @XmlElement(name = "ShortTermInv", required = true)
            protected PARTABS.FundApply.Investments.ShortTermInv shortTermInv;
            @XmlElement(name = "TotInvestments", required = true, defaultValue = "0")
            protected BigInteger totInvestments;

            /**
             * Gets the value of the longTermInv property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABS.FundApply.Investments.LongTermInv }
             *     
             */
            public PARTABS.FundApply.Investments.LongTermInv getLongTermInv() {
                return longTermInv;
            }

            /**
             * Sets the value of the longTermInv property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABS.FundApply.Investments.LongTermInv }
             *     
             */
            public void setLongTermInv(PARTABS.FundApply.Investments.LongTermInv value) {
                this.longTermInv = value;
            }

            /**
             * Gets the value of the shortTermInv property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABS.FundApply.Investments.ShortTermInv }
             *     
             */
            public PARTABS.FundApply.Investments.ShortTermInv getShortTermInv() {
                return shortTermInv;
            }

            /**
             * Sets the value of the shortTermInv property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABS.FundApply.Investments.ShortTermInv }
             *     
             */
            public void setShortTermInv(PARTABS.FundApply.Investments.ShortTermInv value) {
                this.shortTermInv = value;
            }

            /**
             * Gets the value of the totInvestments property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getTotInvestments() {
                return totInvestments;
            }

            /**
             * Sets the value of the totInvestments property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTotInvestments(BigInteger value) {
                this.totInvestments = value;
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
             *         &lt;element name="InvInProperty">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="EquityInstruments">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="ListedEquities">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="UnListedEquities">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="Total">
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
             *         &lt;element name="PreferenceShares">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="GovtOrTrustSecurities">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="DebenturesOrBonds">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="MutualFunds">
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
             *         &lt;element name="TotLongTermInv">
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
                "invInProperty",
                "equityInstruments",
                "preferenceShares",
                "govtOrTrustSecurities",
                "debenturesOrBonds",
                "mutualFunds",
                "others",
                "totLongTermInv"
            })
            public static class LongTermInv {

                @XmlElement(name = "InvInProperty", required = true, defaultValue = "0")
                protected BigInteger invInProperty;
                @XmlElement(name = "EquityInstruments", required = true)
                protected PARTABS.FundApply.Investments.LongTermInv.EquityInstruments equityInstruments;
                @XmlElement(name = "PreferenceShares", required = true, defaultValue = "0")
                protected BigInteger preferenceShares;
                @XmlElement(name = "GovtOrTrustSecurities", required = true, defaultValue = "0")
                protected BigInteger govtOrTrustSecurities;
                @XmlElement(name = "DebenturesOrBonds", required = true, defaultValue = "0")
                protected BigInteger debenturesOrBonds;
                @XmlElement(name = "MutualFunds", required = true, defaultValue = "0")
                protected BigInteger mutualFunds;
                @XmlElement(name = "Others", required = true, defaultValue = "0")
                protected BigInteger others;
                @XmlElement(name = "TotLongTermInv", required = true, defaultValue = "0")
                protected BigInteger totLongTermInv;

                /**
                 * Gets the value of the invInProperty property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getInvInProperty() {
                    return invInProperty;
                }

                /**
                 * Sets the value of the invInProperty property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setInvInProperty(BigInteger value) {
                    this.invInProperty = value;
                }

                /**
                 * Gets the value of the equityInstruments property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABS.FundApply.Investments.LongTermInv.EquityInstruments }
                 *     
                 */
                public PARTABS.FundApply.Investments.LongTermInv.EquityInstruments getEquityInstruments() {
                    return equityInstruments;
                }

                /**
                 * Sets the value of the equityInstruments property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABS.FundApply.Investments.LongTermInv.EquityInstruments }
                 *     
                 */
                public void setEquityInstruments(PARTABS.FundApply.Investments.LongTermInv.EquityInstruments value) {
                    this.equityInstruments = value;
                }

                /**
                 * Gets the value of the preferenceShares property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getPreferenceShares() {
                    return preferenceShares;
                }

                /**
                 * Sets the value of the preferenceShares property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setPreferenceShares(BigInteger value) {
                    this.preferenceShares = value;
                }

                /**
                 * Gets the value of the govtOrTrustSecurities property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getGovtOrTrustSecurities() {
                    return govtOrTrustSecurities;
                }

                /**
                 * Sets the value of the govtOrTrustSecurities property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setGovtOrTrustSecurities(BigInteger value) {
                    this.govtOrTrustSecurities = value;
                }

                /**
                 * Gets the value of the debenturesOrBonds property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getDebenturesOrBonds() {
                    return debenturesOrBonds;
                }

                /**
                 * Sets the value of the debenturesOrBonds property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setDebenturesOrBonds(BigInteger value) {
                    this.debenturesOrBonds = value;
                }

                /**
                 * Gets the value of the mutualFunds property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getMutualFunds() {
                    return mutualFunds;
                }

                /**
                 * Sets the value of the mutualFunds property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setMutualFunds(BigInteger value) {
                    this.mutualFunds = value;
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
                 * Gets the value of the totLongTermInv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotLongTermInv() {
                    return totLongTermInv;
                }

                /**
                 * Sets the value of the totLongTermInv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotLongTermInv(BigInteger value) {
                    this.totLongTermInv = value;
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
                 *         &lt;element name="ListedEquities">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="UnListedEquities">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="Total">
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
                    "listedEquities",
                    "unListedEquities",
                    "total"
                })
                public static class EquityInstruments {

                    @XmlElement(name = "ListedEquities", required = true, defaultValue = "0")
                    protected BigInteger listedEquities;
                    @XmlElement(name = "UnListedEquities", required = true, defaultValue = "0")
                    protected BigInteger unListedEquities;
                    @XmlElement(name = "Total", required = true, defaultValue = "0")
                    protected BigInteger total;

                    /**
                     * Gets the value of the listedEquities property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getListedEquities() {
                        return listedEquities;
                    }

                    /**
                     * Sets the value of the listedEquities property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setListedEquities(BigInteger value) {
                        this.listedEquities = value;
                    }

                    /**
                     * Gets the value of the unListedEquities property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getUnListedEquities() {
                        return unListedEquities;
                    }

                    /**
                     * Sets the value of the unListedEquities property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setUnListedEquities(BigInteger value) {
                        this.unListedEquities = value;
                    }

                    /**
                     * Gets the value of the total property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotal() {
                        return total;
                    }

                    /**
                     * Sets the value of the total property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotal(BigInteger value) {
                        this.total = value;
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
             *         &lt;element name="EquityInstruments">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="ListedEquities">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="UnListedEquities">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="Total">
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
             *         &lt;element name="PreferenceShares">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="GovtOrTrustSecurities">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="DebenturesOrBonds">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="MutualFunds">
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
             *         &lt;element name="TotShortTermInv">
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
                "equityInstruments",
                "preferenceShares",
                "govtOrTrustSecurities",
                "debenturesOrBonds",
                "mutualFunds",
                "others",
                "totShortTermInv"
            })
            public static class ShortTermInv {

                @XmlElement(name = "EquityInstruments", required = true)
                protected PARTABS.FundApply.Investments.ShortTermInv.EquityInstruments equityInstruments;
                @XmlElement(name = "PreferenceShares", required = true, defaultValue = "0")
                protected BigInteger preferenceShares;
                @XmlElement(name = "GovtOrTrustSecurities", required = true, defaultValue = "0")
                protected BigInteger govtOrTrustSecurities;
                @XmlElement(name = "DebenturesOrBonds", required = true, defaultValue = "0")
                protected BigInteger debenturesOrBonds;
                @XmlElement(name = "MutualFunds", required = true, defaultValue = "0")
                protected BigInteger mutualFunds;
                @XmlElement(name = "Others", required = true, defaultValue = "0")
                protected BigInteger others;
                @XmlElement(name = "TotShortTermInv", required = true, defaultValue = "0")
                protected BigInteger totShortTermInv;

                /**
                 * Gets the value of the equityInstruments property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABS.FundApply.Investments.ShortTermInv.EquityInstruments }
                 *     
                 */
                public PARTABS.FundApply.Investments.ShortTermInv.EquityInstruments getEquityInstruments() {
                    return equityInstruments;
                }

                /**
                 * Sets the value of the equityInstruments property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABS.FundApply.Investments.ShortTermInv.EquityInstruments }
                 *     
                 */
                public void setEquityInstruments(PARTABS.FundApply.Investments.ShortTermInv.EquityInstruments value) {
                    this.equityInstruments = value;
                }

                /**
                 * Gets the value of the preferenceShares property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getPreferenceShares() {
                    return preferenceShares;
                }

                /**
                 * Sets the value of the preferenceShares property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setPreferenceShares(BigInteger value) {
                    this.preferenceShares = value;
                }

                /**
                 * Gets the value of the govtOrTrustSecurities property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getGovtOrTrustSecurities() {
                    return govtOrTrustSecurities;
                }

                /**
                 * Sets the value of the govtOrTrustSecurities property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setGovtOrTrustSecurities(BigInteger value) {
                    this.govtOrTrustSecurities = value;
                }

                /**
                 * Gets the value of the debenturesOrBonds property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getDebenturesOrBonds() {
                    return debenturesOrBonds;
                }

                /**
                 * Sets the value of the debenturesOrBonds property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setDebenturesOrBonds(BigInteger value) {
                    this.debenturesOrBonds = value;
                }

                /**
                 * Gets the value of the mutualFunds property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getMutualFunds() {
                    return mutualFunds;
                }

                /**
                 * Sets the value of the mutualFunds property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setMutualFunds(BigInteger value) {
                    this.mutualFunds = value;
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
                 * Gets the value of the totShortTermInv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotShortTermInv() {
                    return totShortTermInv;
                }

                /**
                 * Sets the value of the totShortTermInv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotShortTermInv(BigInteger value) {
                    this.totShortTermInv = value;
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
                 *         &lt;element name="ListedEquities">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="UnListedEquities">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="Total">
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
                    "listedEquities",
                    "unListedEquities",
                    "total"
                })
                public static class EquityInstruments {

                    @XmlElement(name = "ListedEquities", required = true, defaultValue = "0")
                    protected BigInteger listedEquities;
                    @XmlElement(name = "UnListedEquities", required = true, defaultValue = "0")
                    protected BigInteger unListedEquities;
                    @XmlElement(name = "Total", required = true, defaultValue = "0")
                    protected BigInteger total;

                    /**
                     * Gets the value of the listedEquities property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getListedEquities() {
                        return listedEquities;
                    }

                    /**
                     * Sets the value of the listedEquities property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setListedEquities(BigInteger value) {
                        this.listedEquities = value;
                    }

                    /**
                     * Gets the value of the unListedEquities property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getUnListedEquities() {
                        return unListedEquities;
                    }

                    /**
                     * Sets the value of the unListedEquities property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setUnListedEquities(BigInteger value) {
                        this.unListedEquities = value;
                    }

                    /**
                     * Gets the value of the total property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotal() {
                        return total;
                    }

                    /**
                     * Sets the value of the total property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotal(BigInteger value) {
                        this.total = value;
                    }

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
         *         &lt;element name="MiscExpndr">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="DefTaxAsset">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="AccumultedLosses">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="TotMiscAdjust">
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
            "miscExpndr",
            "defTaxAsset",
            "accumultedLosses",
            "totMiscAdjust"
        })
        public static class MiscAdjust {

            @XmlElement(name = "MiscExpndr", required = true, defaultValue = "0")
            protected BigInteger miscExpndr;
            @XmlElement(name = "DefTaxAsset", required = true, defaultValue = "0")
            protected BigInteger defTaxAsset;
            @XmlElement(name = "AccumultedLosses", required = true, defaultValue = "0")
            protected BigInteger accumultedLosses;
            @XmlElement(name = "TotMiscAdjust", required = true, defaultValue = "0")
            protected BigInteger totMiscAdjust;

            /**
             * Gets the value of the miscExpndr property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMiscExpndr() {
                return miscExpndr;
            }

            /**
             * Sets the value of the miscExpndr property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMiscExpndr(BigInteger value) {
                this.miscExpndr = value;
            }

            /**
             * Gets the value of the defTaxAsset property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getDefTaxAsset() {
                return defTaxAsset;
            }

            /**
             * Sets the value of the defTaxAsset property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setDefTaxAsset(BigInteger value) {
                this.defTaxAsset = value;
            }

            /**
             * Gets the value of the accumultedLosses property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getAccumultedLosses() {
                return accumultedLosses;
            }

            /**
             * Sets the value of the accumultedLosses property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setAccumultedLosses(BigInteger value) {
                this.accumultedLosses = value;
            }

            /**
             * Gets the value of the totMiscAdjust property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getTotMiscAdjust() {
                return totMiscAdjust;
            }

            /**
             * Sets the value of the totMiscAdjust property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTotMiscAdjust(BigInteger value) {
                this.totMiscAdjust = value;
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
     *         &lt;element name="PartnerOrMemberFund">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PartnerOrMemberCap">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ResrNSurp">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="RevResr">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="CapResr">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="StatResr">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="OthResr">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="CreditBalOfPLAccount">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotResrNSurp">
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
     *                   &lt;element name="TotPartnerOrMemberFund">
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
     *         &lt;element name="LoanFunds">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SecrLoan">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="ForeignCurrLoan">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="RupeeLoan">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="FrmBank">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="FrmOthrs">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="TotRupeeLoan">
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
     *                             &lt;element name="TotSecrLoan">
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
     *                   &lt;element name="UnsecrLoan">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="ForeignCurrencyLoans">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="RupeeLoan">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="FrmBank">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="FrmPersonSpcfdUs40A2b">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="FrmOthrs">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="TotRupeeLoan">
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
     *                             &lt;element name="TotUnSecrLoan">
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
     *                   &lt;element name="TotLoanFund">
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
     *         &lt;element name="DeferredTax">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Advances">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="FrmPersonSpcfdUs40A2b">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="FrmOthers">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="TotalAdvances">
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
     *         &lt;element name="TotFundSrc">
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
        "partnerOrMemberFund",
        "loanFunds",
        "deferredTax",
        "advances",
        "totFundSrc"
    })
    public static class FundSrc {

        @XmlElement(name = "PartnerOrMemberFund", required = true)
        protected PARTABS.FundSrc.PartnerOrMemberFund partnerOrMemberFund;
        @XmlElement(name = "LoanFunds", required = true)
        protected PARTABS.FundSrc.LoanFunds loanFunds;
        @XmlElement(name = "DeferredTax", required = true, defaultValue = "0")
        protected BigInteger deferredTax;
        @XmlElement(name = "Advances", required = true)
        protected PARTABS.FundSrc.Advances advances;
        @XmlElement(name = "TotFundSrc", defaultValue = "0")
        protected long totFundSrc;

        /**
         * Gets the value of the partnerOrMemberFund property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABS.FundSrc.PartnerOrMemberFund }
         *     
         */
        public PARTABS.FundSrc.PartnerOrMemberFund getPartnerOrMemberFund() {
            return partnerOrMemberFund;
        }

        /**
         * Sets the value of the partnerOrMemberFund property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABS.FundSrc.PartnerOrMemberFund }
         *     
         */
        public void setPartnerOrMemberFund(PARTABS.FundSrc.PartnerOrMemberFund value) {
            this.partnerOrMemberFund = value;
        }

        /**
         * Gets the value of the loanFunds property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABS.FundSrc.LoanFunds }
         *     
         */
        public PARTABS.FundSrc.LoanFunds getLoanFunds() {
            return loanFunds;
        }

        /**
         * Sets the value of the loanFunds property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABS.FundSrc.LoanFunds }
         *     
         */
        public void setLoanFunds(PARTABS.FundSrc.LoanFunds value) {
            this.loanFunds = value;
        }

        /**
         * Gets the value of the deferredTax property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getDeferredTax() {
            return deferredTax;
        }

        /**
         * Sets the value of the deferredTax property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setDeferredTax(BigInteger value) {
            this.deferredTax = value;
        }

        /**
         * Gets the value of the advances property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABS.FundSrc.Advances }
         *     
         */
        public PARTABS.FundSrc.Advances getAdvances() {
            return advances;
        }

        /**
         * Sets the value of the advances property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABS.FundSrc.Advances }
         *     
         */
        public void setAdvances(PARTABS.FundSrc.Advances value) {
            this.advances = value;
        }

        /**
         * Gets the value of the totFundSrc property.
         * 
         */
        public long getTotFundSrc() {
            return totFundSrc;
        }

        /**
         * Sets the value of the totFundSrc property.
         * 
         */
        public void setTotFundSrc(long value) {
            this.totFundSrc = value;
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
         *         &lt;element name="FrmPersonSpcfdUs40A2b">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="FrmOthers">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="TotalAdvances">
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
            "frmPersonSpcfdUs40A2B",
            "frmOthers",
            "totalAdvances"
        })
        public static class Advances {

            @XmlElement(name = "FrmPersonSpcfdUs40A2b", required = true)
            protected BigInteger frmPersonSpcfdUs40A2B;
            @XmlElement(name = "FrmOthers", required = true)
            protected BigInteger frmOthers;
            @XmlElement(name = "TotalAdvances", required = true)
            protected BigInteger totalAdvances;

            /**
             * Gets the value of the frmPersonSpcfdUs40A2B property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getFrmPersonSpcfdUs40A2B() {
                return frmPersonSpcfdUs40A2B;
            }

            /**
             * Sets the value of the frmPersonSpcfdUs40A2B property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setFrmPersonSpcfdUs40A2B(BigInteger value) {
                this.frmPersonSpcfdUs40A2B = value;
            }

            /**
             * Gets the value of the frmOthers property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getFrmOthers() {
                return frmOthers;
            }

            /**
             * Sets the value of the frmOthers property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setFrmOthers(BigInteger value) {
                this.frmOthers = value;
            }

            /**
             * Gets the value of the totalAdvances property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getTotalAdvances() {
                return totalAdvances;
            }

            /**
             * Sets the value of the totalAdvances property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTotalAdvances(BigInteger value) {
                this.totalAdvances = value;
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
         *         &lt;element name="SecrLoan">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="ForeignCurrLoan">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="RupeeLoan">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="FrmBank">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="FrmOthrs">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="TotRupeeLoan">
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
         *                   &lt;element name="TotSecrLoan">
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
         *         &lt;element name="UnsecrLoan">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="ForeignCurrencyLoans">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="RupeeLoan">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="FrmBank">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="FrmPersonSpcfdUs40A2b">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="FrmOthrs">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="TotRupeeLoan">
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
         *                   &lt;element name="TotUnSecrLoan">
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
         *         &lt;element name="TotLoanFund">
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
            "secrLoan",
            "unsecrLoan",
            "totLoanFund"
        })
        public static class LoanFunds {

            @XmlElement(name = "SecrLoan", required = true)
            protected PARTABS.FundSrc.LoanFunds.SecrLoan secrLoan;
            @XmlElement(name = "UnsecrLoan", required = true)
            protected PARTABS.FundSrc.LoanFunds.UnsecrLoan unsecrLoan;
            @XmlElement(name = "TotLoanFund", required = true, defaultValue = "0")
            protected BigInteger totLoanFund;

            /**
             * Gets the value of the secrLoan property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABS.FundSrc.LoanFunds.SecrLoan }
             *     
             */
            public PARTABS.FundSrc.LoanFunds.SecrLoan getSecrLoan() {
                return secrLoan;
            }

            /**
             * Sets the value of the secrLoan property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABS.FundSrc.LoanFunds.SecrLoan }
             *     
             */
            public void setSecrLoan(PARTABS.FundSrc.LoanFunds.SecrLoan value) {
                this.secrLoan = value;
            }

            /**
             * Gets the value of the unsecrLoan property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABS.FundSrc.LoanFunds.UnsecrLoan }
             *     
             */
            public PARTABS.FundSrc.LoanFunds.UnsecrLoan getUnsecrLoan() {
                return unsecrLoan;
            }

            /**
             * Sets the value of the unsecrLoan property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABS.FundSrc.LoanFunds.UnsecrLoan }
             *     
             */
            public void setUnsecrLoan(PARTABS.FundSrc.LoanFunds.UnsecrLoan value) {
                this.unsecrLoan = value;
            }

            /**
             * Gets the value of the totLoanFund property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getTotLoanFund() {
                return totLoanFund;
            }

            /**
             * Sets the value of the totLoanFund property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTotLoanFund(BigInteger value) {
                this.totLoanFund = value;
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
             *         &lt;element name="ForeignCurrLoan">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="RupeeLoan">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="FrmBank">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="FrmOthrs">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="TotRupeeLoan">
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
             *         &lt;element name="TotSecrLoan">
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
                "foreignCurrLoan",
                "rupeeLoan",
                "totSecrLoan"
            })
            public static class SecrLoan {

                @XmlElement(name = "ForeignCurrLoan", required = true, defaultValue = "0")
                protected BigInteger foreignCurrLoan;
                @XmlElement(name = "RupeeLoan", required = true)
                protected PARTABS.FundSrc.LoanFunds.SecrLoan.RupeeLoan rupeeLoan;
                @XmlElement(name = "TotSecrLoan", required = true, defaultValue = "0")
                protected BigInteger totSecrLoan;

                /**
                 * Gets the value of the foreignCurrLoan property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getForeignCurrLoan() {
                    return foreignCurrLoan;
                }

                /**
                 * Sets the value of the foreignCurrLoan property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setForeignCurrLoan(BigInteger value) {
                    this.foreignCurrLoan = value;
                }

                /**
                 * Gets the value of the rupeeLoan property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABS.FundSrc.LoanFunds.SecrLoan.RupeeLoan }
                 *     
                 */
                public PARTABS.FundSrc.LoanFunds.SecrLoan.RupeeLoan getRupeeLoan() {
                    return rupeeLoan;
                }

                /**
                 * Sets the value of the rupeeLoan property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABS.FundSrc.LoanFunds.SecrLoan.RupeeLoan }
                 *     
                 */
                public void setRupeeLoan(PARTABS.FundSrc.LoanFunds.SecrLoan.RupeeLoan value) {
                    this.rupeeLoan = value;
                }

                /**
                 * Gets the value of the totSecrLoan property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotSecrLoan() {
                    return totSecrLoan;
                }

                /**
                 * Sets the value of the totSecrLoan property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotSecrLoan(BigInteger value) {
                    this.totSecrLoan = value;
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
                 *         &lt;element name="FrmBank">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="FrmOthrs">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="TotRupeeLoan">
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
                    "frmBank",
                    "frmOthrs",
                    "totRupeeLoan"
                })
                public static class RupeeLoan {

                    @XmlElement(name = "FrmBank", required = true, defaultValue = "0")
                    protected BigInteger frmBank;
                    @XmlElement(name = "FrmOthrs", required = true, defaultValue = "0")
                    protected BigInteger frmOthrs;
                    @XmlElement(name = "TotRupeeLoan", required = true, defaultValue = "0")
                    protected BigInteger totRupeeLoan;

                    /**
                     * Gets the value of the frmBank property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getFrmBank() {
                        return frmBank;
                    }

                    /**
                     * Sets the value of the frmBank property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setFrmBank(BigInteger value) {
                        this.frmBank = value;
                    }

                    /**
                     * Gets the value of the frmOthrs property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getFrmOthrs() {
                        return frmOthrs;
                    }

                    /**
                     * Sets the value of the frmOthrs property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setFrmOthrs(BigInteger value) {
                        this.frmOthrs = value;
                    }

                    /**
                     * Gets the value of the totRupeeLoan property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotRupeeLoan() {
                        return totRupeeLoan;
                    }

                    /**
                     * Sets the value of the totRupeeLoan property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotRupeeLoan(BigInteger value) {
                        this.totRupeeLoan = value;
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
             *         &lt;element name="ForeignCurrencyLoans">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="RupeeLoan">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="FrmBank">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="FrmPersonSpcfdUs40A2b">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="FrmOthrs">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="TotRupeeLoan">
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
             *         &lt;element name="TotUnSecrLoan">
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
                "foreignCurrencyLoans",
                "rupeeLoan",
                "totUnSecrLoan"
            })
            public static class UnsecrLoan {

                @XmlElement(name = "ForeignCurrencyLoans", required = true, defaultValue = "0")
                protected BigInteger foreignCurrencyLoans;
                @XmlElement(name = "RupeeLoan", required = true)
                protected PARTABS.FundSrc.LoanFunds.UnsecrLoan.RupeeLoan rupeeLoan;
                @XmlElement(name = "TotUnSecrLoan", required = true, defaultValue = "0")
                protected BigInteger totUnSecrLoan;

                /**
                 * Gets the value of the foreignCurrencyLoans property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getForeignCurrencyLoans() {
                    return foreignCurrencyLoans;
                }

                /**
                 * Sets the value of the foreignCurrencyLoans property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setForeignCurrencyLoans(BigInteger value) {
                    this.foreignCurrencyLoans = value;
                }

                /**
                 * Gets the value of the rupeeLoan property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABS.FundSrc.LoanFunds.UnsecrLoan.RupeeLoan }
                 *     
                 */
                public PARTABS.FundSrc.LoanFunds.UnsecrLoan.RupeeLoan getRupeeLoan() {
                    return rupeeLoan;
                }

                /**
                 * Sets the value of the rupeeLoan property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABS.FundSrc.LoanFunds.UnsecrLoan.RupeeLoan }
                 *     
                 */
                public void setRupeeLoan(PARTABS.FundSrc.LoanFunds.UnsecrLoan.RupeeLoan value) {
                    this.rupeeLoan = value;
                }

                /**
                 * Gets the value of the totUnSecrLoan property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotUnSecrLoan() {
                    return totUnSecrLoan;
                }

                /**
                 * Sets the value of the totUnSecrLoan property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotUnSecrLoan(BigInteger value) {
                    this.totUnSecrLoan = value;
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
                 *         &lt;element name="FrmBank">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="FrmPersonSpcfdUs40A2b">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="FrmOthrs">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="TotRupeeLoan">
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
                    "frmBank",
                    "frmPersonSpcfdUs40A2B",
                    "frmOthrs",
                    "totRupeeLoan"
                })
                public static class RupeeLoan {

                    @XmlElement(name = "FrmBank", required = true, defaultValue = "0")
                    protected BigInteger frmBank;
                    @XmlElement(name = "FrmPersonSpcfdUs40A2b", required = true, defaultValue = "0")
                    protected BigInteger frmPersonSpcfdUs40A2B;
                    @XmlElement(name = "FrmOthrs", required = true, defaultValue = "0")
                    protected BigInteger frmOthrs;
                    @XmlElement(name = "TotRupeeLoan", required = true, defaultValue = "0")
                    protected BigInteger totRupeeLoan;

                    /**
                     * Gets the value of the frmBank property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getFrmBank() {
                        return frmBank;
                    }

                    /**
                     * Sets the value of the frmBank property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setFrmBank(BigInteger value) {
                        this.frmBank = value;
                    }

                    /**
                     * Gets the value of the frmPersonSpcfdUs40A2B property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getFrmPersonSpcfdUs40A2B() {
                        return frmPersonSpcfdUs40A2B;
                    }

                    /**
                     * Sets the value of the frmPersonSpcfdUs40A2B property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setFrmPersonSpcfdUs40A2B(BigInteger value) {
                        this.frmPersonSpcfdUs40A2B = value;
                    }

                    /**
                     * Gets the value of the frmOthrs property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getFrmOthrs() {
                        return frmOthrs;
                    }

                    /**
                     * Sets the value of the frmOthrs property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setFrmOthrs(BigInteger value) {
                        this.frmOthrs = value;
                    }

                    /**
                     * Gets the value of the totRupeeLoan property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotRupeeLoan() {
                        return totRupeeLoan;
                    }

                    /**
                     * Sets the value of the totRupeeLoan property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotRupeeLoan(BigInteger value) {
                        this.totRupeeLoan = value;
                    }

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
         *         &lt;element name="PartnerOrMemberCap">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ResrNSurp">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="RevResr">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="CapResr">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="StatResr">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OthResr">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="CreditBalOfPLAccount">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotResrNSurp">
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
         *         &lt;element name="TotPartnerOrMemberFund">
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
            "partnerOrMemberCap",
            "resrNSurp",
            "totPartnerOrMemberFund"
        })
        public static class PartnerOrMemberFund {

            @XmlElement(name = "PartnerOrMemberCap", defaultValue = "0")
            protected long partnerOrMemberCap;
            @XmlElement(name = "ResrNSurp", required = true)
            protected PARTABS.FundSrc.PartnerOrMemberFund.ResrNSurp resrNSurp;
            @XmlElement(name = "TotPartnerOrMemberFund", defaultValue = "0")
            protected long totPartnerOrMemberFund;

            /**
             * Gets the value of the partnerOrMemberCap property.
             * 
             */
            public long getPartnerOrMemberCap() {
                return partnerOrMemberCap;
            }

            /**
             * Sets the value of the partnerOrMemberCap property.
             * 
             */
            public void setPartnerOrMemberCap(long value) {
                this.partnerOrMemberCap = value;
            }

            /**
             * Gets the value of the resrNSurp property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABS.FundSrc.PartnerOrMemberFund.ResrNSurp }
             *     
             */
            public PARTABS.FundSrc.PartnerOrMemberFund.ResrNSurp getResrNSurp() {
                return resrNSurp;
            }

            /**
             * Sets the value of the resrNSurp property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABS.FundSrc.PartnerOrMemberFund.ResrNSurp }
             *     
             */
            public void setResrNSurp(PARTABS.FundSrc.PartnerOrMemberFund.ResrNSurp value) {
                this.resrNSurp = value;
            }

            /**
             * Gets the value of the totPartnerOrMemberFund property.
             * 
             */
            public long getTotPartnerOrMemberFund() {
                return totPartnerOrMemberFund;
            }

            /**
             * Sets the value of the totPartnerOrMemberFund property.
             * 
             */
            public void setTotPartnerOrMemberFund(long value) {
                this.totPartnerOrMemberFund = value;
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
             *         &lt;element name="RevResr">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="CapResr">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="StatResr">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OthResr">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="CreditBalOfPLAccount">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotResrNSurp">
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
                "revResr",
                "capResr",
                "statResr",
                "othResr",
                "creditBalOfPLAccount",
                "totResrNSurp"
            })
            public static class ResrNSurp {

                @XmlElement(name = "RevResr", required = true, defaultValue = "0")
                protected BigInteger revResr;
                @XmlElement(name = "CapResr", required = true, defaultValue = "0")
                protected BigInteger capResr;
                @XmlElement(name = "StatResr", required = true, defaultValue = "0")
                protected BigInteger statResr;
                @XmlElement(name = "OthResr", required = true, defaultValue = "0")
                protected BigInteger othResr;
                @XmlElement(name = "CreditBalOfPLAccount", required = true, defaultValue = "0")
                protected BigInteger creditBalOfPLAccount;
                @XmlElement(name = "TotResrNSurp", required = true, defaultValue = "0")
                protected BigInteger totResrNSurp;

                /**
                 * Gets the value of the revResr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getRevResr() {
                    return revResr;
                }

                /**
                 * Sets the value of the revResr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setRevResr(BigInteger value) {
                    this.revResr = value;
                }

                /**
                 * Gets the value of the capResr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getCapResr() {
                    return capResr;
                }

                /**
                 * Sets the value of the capResr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setCapResr(BigInteger value) {
                    this.capResr = value;
                }

                /**
                 * Gets the value of the statResr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getStatResr() {
                    return statResr;
                }

                /**
                 * Sets the value of the statResr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setStatResr(BigInteger value) {
                    this.statResr = value;
                }

                /**
                 * Gets the value of the othResr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOthResr() {
                    return othResr;
                }

                /**
                 * Sets the value of the othResr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOthResr(BigInteger value) {
                    this.othResr = value;
                }

                /**
                 * Gets the value of the creditBalOfPLAccount property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getCreditBalOfPLAccount() {
                    return creditBalOfPLAccount;
                }

                /**
                 * Sets the value of the creditBalOfPLAccount property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setCreditBalOfPLAccount(BigInteger value) {
                    this.creditBalOfPLAccount = value;
                }

                /**
                 * Gets the value of the totResrNSurp property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotResrNSurp() {
                    return totResrNSurp;
                }

                /**
                 * Sets the value of the totResrNSurp property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotResrNSurp(BigInteger value) {
                    this.totResrNSurp = value;
                }

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
     *         &lt;element name="TotSundryDbtAmt">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TotSundryCrdAmt">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TotStkInTradAmt">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CashBalAmt">
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
        "totSundryDbtAmt",
        "totSundryCrdAmt",
        "totStkInTradAmt",
        "cashBalAmt"
    })
    public static class NoBooksOfAccBS {

        @XmlElement(name = "TotSundryDbtAmt", required = true, defaultValue = "0")
        protected BigInteger totSundryDbtAmt;
        @XmlElement(name = "TotSundryCrdAmt", required = true, defaultValue = "0")
        protected BigInteger totSundryCrdAmt;
        @XmlElement(name = "TotStkInTradAmt", required = true, defaultValue = "0")
        protected BigInteger totStkInTradAmt;
        @XmlElement(name = "CashBalAmt", required = true, defaultValue = "0")
        protected BigInteger cashBalAmt;

        /**
         * Gets the value of the totSundryDbtAmt property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotSundryDbtAmt() {
            return totSundryDbtAmt;
        }

        /**
         * Sets the value of the totSundryDbtAmt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotSundryDbtAmt(BigInteger value) {
            this.totSundryDbtAmt = value;
        }

        /**
         * Gets the value of the totSundryCrdAmt property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotSundryCrdAmt() {
            return totSundryCrdAmt;
        }

        /**
         * Sets the value of the totSundryCrdAmt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotSundryCrdAmt(BigInteger value) {
            this.totSundryCrdAmt = value;
        }

        /**
         * Gets the value of the totStkInTradAmt property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotStkInTradAmt() {
            return totStkInTradAmt;
        }

        /**
         * Sets the value of the totStkInTradAmt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotStkInTradAmt(BigInteger value) {
            this.totStkInTradAmt = value;
        }

        /**
         * Gets the value of the cashBalAmt property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getCashBalAmt() {
            return cashBalAmt;
        }

        /**
         * Sets the value of the cashBalAmt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setCashBalAmt(BigInteger value) {
            this.cashBalAmt = value;
        }

    }

}
