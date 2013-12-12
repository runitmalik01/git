
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
 *         &lt;element name="EquityAndLiablities">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ShareHolderFund">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ShareCapital">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Authorised">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="IssuedSubsPaidUp">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="SubscribedNotFullyPaid">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotShareCapital">
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
 *                             &lt;element name="ResrNSurp">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="CapResr">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="CapRedempResr">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="SecurPremResr">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="DebunRedResr">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="RevResr">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="ShareOptOSAmount">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="OtherResrvDtls" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Nature">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                       &lt;maxLength value="50"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Amount">
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
 *                                       &lt;element name="OtherResrvTotal">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="PLAccount">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotResrNSurp">
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
 *                             &lt;element name="MoneyRecvdAgainstShares">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="TotShareHolderFund">
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
 *                   &lt;element name="ShareAppMoneyAllot">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PendingLtOneYr">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="PendingMtOneYr">
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
 *                   &lt;element name="NonCurrLiabilities">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="LongTermBorrowings">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BondsDebentures">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="ForeignCurrency">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Rupee">
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
 *                                       &lt;element name="TermLoans">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="ForeignCurrency">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="RupeeLoans">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="FromBanks">
 *                                                             &lt;simpleType>
 *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                                 &lt;totalDigits value="14"/>
 *                                                               &lt;/restriction>
 *                                                             &lt;/simpleType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="FromOthers">
 *                                                             &lt;simpleType>
 *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                                 &lt;totalDigits value="14"/>
 *                                                               &lt;/restriction>
 *                                                             &lt;/simpleType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="Total">
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
 *                                                 &lt;element name="TotalTermLoans">
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
 *                                       &lt;element name="DeferredPymtLiabilities">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="DepositsFrmRelatedParties">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="OtherDeposits">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="LoansAndAdv">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="OthersLoanAdv">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="LongTermMaturities">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotalLTBorrowings">
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
 *                             &lt;element name="NetDefferedTaxLiability">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="OthLongTermLiablities">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="TradePayables">
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
 *                                       &lt;element name="TotalOthLtLiabilities">
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
 *                             &lt;element name="LongTermProvisions">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="ProvEmpBenefits">
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
 *                             &lt;element name="TotalNonCurrLiabilites">
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
 *                   &lt;element name="CurrentLiabilities">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ShortTrmBorrowings">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="LoansRepaybleOnDemand">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="FromBanks">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="FrmNonBanking">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="OthFinanceInst">
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
 *                                                 &lt;element name="TotLoansRepaybleOnDemand">
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
 *                                       &lt;element name="DepositsFrmRelatedParties">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="LoansAndAdv">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="OthLoansAndAdv">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="OthDeposits">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotShortTrmBorrowings">
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
 *                             &lt;element name="TradePayables">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="OSMoreThanOneYr">
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
 *                                       &lt;element name="TotalTradePayables">
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
 *                             &lt;element name="OthCurrLiabilities">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="CurrMatOnLTDebt">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="CurrMatFinanceOblg">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="AccrInterest">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="AccrInterestNotDue">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="IncRecvdAdvance">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="UnpaidDividend">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="AppMonyRecvdAllotSecurities">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="UnpaidMatDeposits">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="UnpaidMatureDebenture">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="OthPayables">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotOthCurrLiabilities">
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
 *                             &lt;element name="ShortTermProv">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="EmpBenefitProv">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="ITProvision">
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
 *                                       &lt;element name="ProposedDividend">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TaxOnDividend">
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
 *                                       &lt;element name="TotShortTermProvisions">
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
 *                   &lt;element name="TotEquityAndLiabilities">
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
 *         &lt;element name="Assets">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NonCurrAssets">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="FixedAsset">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Tangible">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="GrossBlock">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Depreciation">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="ImpairmentLosses">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="NetBlock">
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
 *                                       &lt;element name="InTangible">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="GrossBlock">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Amortization">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="ImpairmentLosses">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="NetBlock">
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
 *                                       &lt;element name="CapWrkProg">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="IntangibleAssetUnDev">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotFixedAsset">
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
 *                             &lt;element name="NonCurrInvstmnts">
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
 *                                       &lt;element name="InvstmntInPrtnrShipFirm">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="OtherInvstmnts">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotNonCurrInvstmnts">
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
 *                             &lt;element name="NetDeferredTaxAssets">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="LongTrmLoanAdv">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="CapitalAdv">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="SecurityDeposits">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="LoanAdvRelatedParties">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="OthLoanAdv">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotLTLoanAdv">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="LTLoanAdvDtls">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="BusOrProf">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="NotForBusOrProf">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="ShareHolderUs2_22">
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
 *                             &lt;element name="OthNonCurrAssets">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="LTTradeReceivables">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Secured">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Unsecured">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Doubtful">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="TotOthNonCurrAssets">
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
 *                                       &lt;element name="Others">
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
 *                                       &lt;element name="NonCurrAssetUs2_22">
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
 *                             &lt;element name="TotNonCurrAssets">
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
 *                   &lt;element name="CurrentAssets">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CurrInvstmnts">
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
 *                                       &lt;element name="InvstmntInPrtnrShipFirm">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="OtherInvstmnts">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="TotCurrInvstmnts">
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
 *                             &lt;element name="TradeReceivables">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="OSMoreThanSixMonths">
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
 *                                       &lt;element name="TotalTradeReceivables">
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
 *                             &lt;element name="CashNCashEquivalents">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BalWithBanks">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="ChequesDrafts">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="CashInHand">
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
 *                                       &lt;element name="TotCashNCashEquivalents">
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
 *                             &lt;element name="TotShortTermLoanAdv">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="LoanAdv">
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
 *                                       &lt;element name="TotShrtTermLoans">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                             &lt;totalDigits value="14"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="STLoanAdvDtls">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="BusOrProf">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="NotForBusOrProf">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                                       &lt;totalDigits value="14"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="ShareHolderUs2_22">
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
 *                             &lt;element name="OtherCurrAssets">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="TotCurrAssets">
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
 *         &lt;element name="TotalAssets">
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
    "equityAndLiablities",
    "assets",
    "totalAssets"
})
@XmlRootElement(name = "PARTA_BSFor6FrmAY13")
public class PARTABSFor6FrmAY13 {

    @XmlElement(name = "EquityAndLiablities", required = true)
    protected PARTABSFor6FrmAY13 .EquityAndLiablities equityAndLiablities;
    @XmlElement(name = "Assets", required = true)
    protected PARTABSFor6FrmAY13 .Assets assets;
    @XmlElement(name = "TotalAssets", required = true, defaultValue = "0")
    protected BigInteger totalAssets;

    /**
     * Gets the value of the equityAndLiablities property.
     * 
     * @return
     *     possible object is
     *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities }
     *     
     */
    public PARTABSFor6FrmAY13 .EquityAndLiablities getEquityAndLiablities() {
        return equityAndLiablities;
    }

    /**
     * Sets the value of the equityAndLiablities property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities }
     *     
     */
    public void setEquityAndLiablities(PARTABSFor6FrmAY13 .EquityAndLiablities value) {
        this.equityAndLiablities = value;
    }

    /**
     * Gets the value of the assets property.
     * 
     * @return
     *     possible object is
     *     {@link PARTABSFor6FrmAY13 .Assets }
     *     
     */
    public PARTABSFor6FrmAY13 .Assets getAssets() {
        return assets;
    }

    /**
     * Sets the value of the assets property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTABSFor6FrmAY13 .Assets }
     *     
     */
    public void setAssets(PARTABSFor6FrmAY13 .Assets value) {
        this.assets = value;
    }

    /**
     * Gets the value of the totalAssets property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalAssets() {
        return totalAssets;
    }

    /**
     * Sets the value of the totalAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalAssets(BigInteger value) {
        this.totalAssets = value;
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
     *         &lt;element name="NonCurrAssets">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="FixedAsset">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Tangible">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="GrossBlock">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="Depreciation">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="ImpairmentLosses">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="NetBlock">
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
     *                             &lt;element name="InTangible">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="GrossBlock">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="Amortization">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="ImpairmentLosses">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="NetBlock">
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
     *                             &lt;element name="CapWrkProg">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="IntangibleAssetUnDev">
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
     *                   &lt;element name="NonCurrInvstmnts">
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
     *                             &lt;element name="InvstmntInPrtnrShipFirm">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="OtherInvstmnts">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotNonCurrInvstmnts">
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
     *                   &lt;element name="NetDeferredTaxAssets">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="LongTrmLoanAdv">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="CapitalAdv">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="SecurityDeposits">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="LoanAdvRelatedParties">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="OthLoanAdv">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotLTLoanAdv">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="LTLoanAdvDtls">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="BusOrProf">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="NotForBusOrProf">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="ShareHolderUs2_22">
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
     *                   &lt;element name="OthNonCurrAssets">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="LTTradeReceivables">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Secured">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="Unsecured">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="Doubtful">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="TotOthNonCurrAssets">
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
     *                             &lt;element name="Others">
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
     *                             &lt;element name="NonCurrAssetUs2_22">
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
     *                   &lt;element name="TotNonCurrAssets">
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
     *         &lt;element name="CurrentAssets">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CurrInvstmnts">
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
     *                             &lt;element name="InvstmntInPrtnrShipFirm">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="OtherInvstmnts">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotCurrInvstmnts">
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
     *                   &lt;element name="TradeReceivables">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="OSMoreThanSixMonths">
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
     *                             &lt;element name="TotalTradeReceivables">
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
     *                   &lt;element name="CashNCashEquivalents">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="BalWithBanks">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="ChequesDrafts">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="CashInHand">
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
     *                             &lt;element name="TotCashNCashEquivalents">
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
     *                   &lt;element name="TotShortTermLoanAdv">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="LoanAdv">
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
     *                             &lt;element name="TotShrtTermLoans">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="STLoanAdvDtls">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="BusOrProf">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="NotForBusOrProf">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="ShareHolderUs2_22">
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
     *                   &lt;element name="OtherCurrAssets">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="TotCurrAssets">
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
        "nonCurrAssets",
        "currentAssets"
    })
    public static class Assets {

        @XmlElement(name = "NonCurrAssets", required = true)
        protected PARTABSFor6FrmAY13 .Assets.NonCurrAssets nonCurrAssets;
        @XmlElement(name = "CurrentAssets", required = true)
        protected PARTABSFor6FrmAY13 .Assets.CurrentAssets currentAssets;

        /**
         * Gets the value of the nonCurrAssets property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets }
         *     
         */
        public PARTABSFor6FrmAY13 .Assets.NonCurrAssets getNonCurrAssets() {
            return nonCurrAssets;
        }

        /**
         * Sets the value of the nonCurrAssets property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets }
         *     
         */
        public void setNonCurrAssets(PARTABSFor6FrmAY13 .Assets.NonCurrAssets value) {
            this.nonCurrAssets = value;
        }

        /**
         * Gets the value of the currentAssets property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets }
         *     
         */
        public PARTABSFor6FrmAY13 .Assets.CurrentAssets getCurrentAssets() {
            return currentAssets;
        }

        /**
         * Sets the value of the currentAssets property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets }
         *     
         */
        public void setCurrentAssets(PARTABSFor6FrmAY13 .Assets.CurrentAssets value) {
            this.currentAssets = value;
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
         *         &lt;element name="CurrInvstmnts">
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
         *                   &lt;element name="InvstmntInPrtnrShipFirm">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OtherInvstmnts">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotCurrInvstmnts">
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
         *         &lt;element name="TradeReceivables">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="OSMoreThanSixMonths">
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
         *                   &lt;element name="TotalTradeReceivables">
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
         *         &lt;element name="CashNCashEquivalents">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="BalWithBanks">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="ChequesDrafts">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="CashInHand">
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
         *                   &lt;element name="TotCashNCashEquivalents">
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
         *         &lt;element name="TotShortTermLoanAdv">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="LoanAdv">
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
         *                   &lt;element name="TotShrtTermLoans">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="STLoanAdvDtls">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="BusOrProf">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="NotForBusOrProf">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="ShareHolderUs2_22">
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
         *         &lt;element name="OtherCurrAssets">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="TotCurrAssets">
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
            "currInvstmnts",
            "inventories",
            "tradeReceivables",
            "cashNCashEquivalents",
            "totShortTermLoanAdv",
            "otherCurrAssets",
            "totCurrAssets"
        })
        public static class CurrentAssets {

            @XmlElement(name = "CurrInvstmnts", required = true)
            protected PARTABSFor6FrmAY13 .Assets.CurrentAssets.CurrInvstmnts currInvstmnts;
            @XmlElement(name = "Inventories", required = true)
            protected PARTABSFor6FrmAY13 .Assets.CurrentAssets.Inventories inventories;
            @XmlElement(name = "TradeReceivables", required = true)
            protected PARTABSFor6FrmAY13 .Assets.CurrentAssets.TradeReceivables tradeReceivables;
            @XmlElement(name = "CashNCashEquivalents", required = true)
            protected PARTABSFor6FrmAY13 .Assets.CurrentAssets.CashNCashEquivalents cashNCashEquivalents;
            @XmlElement(name = "TotShortTermLoanAdv", required = true)
            protected PARTABSFor6FrmAY13 .Assets.CurrentAssets.TotShortTermLoanAdv totShortTermLoanAdv;
            @XmlElement(name = "OtherCurrAssets", required = true, defaultValue = "0")
            protected BigInteger otherCurrAssets;
            @XmlElement(name = "TotCurrAssets", required = true, defaultValue = "0")
            protected BigInteger totCurrAssets;

            /**
             * Gets the value of the currInvstmnts property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.CurrInvstmnts }
             *     
             */
            public PARTABSFor6FrmAY13 .Assets.CurrentAssets.CurrInvstmnts getCurrInvstmnts() {
                return currInvstmnts;
            }

            /**
             * Sets the value of the currInvstmnts property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.CurrInvstmnts }
             *     
             */
            public void setCurrInvstmnts(PARTABSFor6FrmAY13 .Assets.CurrentAssets.CurrInvstmnts value) {
                this.currInvstmnts = value;
            }

            /**
             * Gets the value of the inventories property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.Inventories }
             *     
             */
            public PARTABSFor6FrmAY13 .Assets.CurrentAssets.Inventories getInventories() {
                return inventories;
            }

            /**
             * Sets the value of the inventories property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.Inventories }
             *     
             */
            public void setInventories(PARTABSFor6FrmAY13 .Assets.CurrentAssets.Inventories value) {
                this.inventories = value;
            }

            /**
             * Gets the value of the tradeReceivables property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.TradeReceivables }
             *     
             */
            public PARTABSFor6FrmAY13 .Assets.CurrentAssets.TradeReceivables getTradeReceivables() {
                return tradeReceivables;
            }

            /**
             * Sets the value of the tradeReceivables property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.TradeReceivables }
             *     
             */
            public void setTradeReceivables(PARTABSFor6FrmAY13 .Assets.CurrentAssets.TradeReceivables value) {
                this.tradeReceivables = value;
            }

            /**
             * Gets the value of the cashNCashEquivalents property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.CashNCashEquivalents }
             *     
             */
            public PARTABSFor6FrmAY13 .Assets.CurrentAssets.CashNCashEquivalents getCashNCashEquivalents() {
                return cashNCashEquivalents;
            }

            /**
             * Sets the value of the cashNCashEquivalents property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.CashNCashEquivalents }
             *     
             */
            public void setCashNCashEquivalents(PARTABSFor6FrmAY13 .Assets.CurrentAssets.CashNCashEquivalents value) {
                this.cashNCashEquivalents = value;
            }

            /**
             * Gets the value of the totShortTermLoanAdv property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.TotShortTermLoanAdv }
             *     
             */
            public PARTABSFor6FrmAY13 .Assets.CurrentAssets.TotShortTermLoanAdv getTotShortTermLoanAdv() {
                return totShortTermLoanAdv;
            }

            /**
             * Sets the value of the totShortTermLoanAdv property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.TotShortTermLoanAdv }
             *     
             */
            public void setTotShortTermLoanAdv(PARTABSFor6FrmAY13 .Assets.CurrentAssets.TotShortTermLoanAdv value) {
                this.totShortTermLoanAdv = value;
            }

            /**
             * Gets the value of the otherCurrAssets property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getOtherCurrAssets() {
                return otherCurrAssets;
            }

            /**
             * Sets the value of the otherCurrAssets property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setOtherCurrAssets(BigInteger value) {
                this.otherCurrAssets = value;
            }

            /**
             * Gets the value of the totCurrAssets property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getTotCurrAssets() {
                return totCurrAssets;
            }

            /**
             * Sets the value of the totCurrAssets property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTotCurrAssets(BigInteger value) {
                this.totCurrAssets = value;
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
             *         &lt;element name="BalWithBanks">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="ChequesDrafts">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="CashInHand">
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
             *         &lt;element name="TotCashNCashEquivalents">
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
                "balWithBanks",
                "chequesDrafts",
                "cashInHand",
                "others",
                "totCashNCashEquivalents"
            })
            public static class CashNCashEquivalents {

                @XmlElement(name = "BalWithBanks", required = true, defaultValue = "0")
                protected BigInteger balWithBanks;
                @XmlElement(name = "ChequesDrafts", required = true, defaultValue = "0")
                protected BigInteger chequesDrafts;
                @XmlElement(name = "CashInHand", required = true, defaultValue = "0")
                protected BigInteger cashInHand;
                @XmlElement(name = "Others", required = true, defaultValue = "0")
                protected BigInteger others;
                @XmlElement(name = "TotCashNCashEquivalents", required = true, defaultValue = "0")
                protected BigInteger totCashNCashEquivalents;

                /**
                 * Gets the value of the balWithBanks property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getBalWithBanks() {
                    return balWithBanks;
                }

                /**
                 * Sets the value of the balWithBanks property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setBalWithBanks(BigInteger value) {
                    this.balWithBanks = value;
                }

                /**
                 * Gets the value of the chequesDrafts property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getChequesDrafts() {
                    return chequesDrafts;
                }

                /**
                 * Sets the value of the chequesDrafts property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setChequesDrafts(BigInteger value) {
                    this.chequesDrafts = value;
                }

                /**
                 * Gets the value of the cashInHand property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getCashInHand() {
                    return cashInHand;
                }

                /**
                 * Sets the value of the cashInHand property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setCashInHand(BigInteger value) {
                    this.cashInHand = value;
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
                 * Gets the value of the totCashNCashEquivalents property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotCashNCashEquivalents() {
                    return totCashNCashEquivalents;
                }

                /**
                 * Sets the value of the totCashNCashEquivalents property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotCashNCashEquivalents(BigInteger value) {
                    this.totCashNCashEquivalents = value;
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
             *         &lt;element name="InvstmntInPrtnrShipFirm">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OtherInvstmnts">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotCurrInvstmnts">
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
                "invstmntInPrtnrShipFirm",
                "otherInvstmnts",
                "totCurrInvstmnts"
            })
            public static class CurrInvstmnts {

                @XmlElement(name = "EquityInstruments", required = true)
                protected PARTABSFor6FrmAY13 .Assets.CurrentAssets.CurrInvstmnts.EquityInstruments equityInstruments;
                @XmlElement(name = "PreferenceShares", required = true, defaultValue = "0")
                protected BigInteger preferenceShares;
                @XmlElement(name = "GovtOrTrustSecurities", required = true, defaultValue = "0")
                protected BigInteger govtOrTrustSecurities;
                @XmlElement(name = "DebenturesOrBonds", required = true, defaultValue = "0")
                protected BigInteger debenturesOrBonds;
                @XmlElement(name = "MutualFunds", required = true, defaultValue = "0")
                protected BigInteger mutualFunds;
                @XmlElement(name = "InvstmntInPrtnrShipFirm", required = true, defaultValue = "0")
                protected BigInteger invstmntInPrtnrShipFirm;
                @XmlElement(name = "OtherInvstmnts", required = true, defaultValue = "0")
                protected BigInteger otherInvstmnts;
                @XmlElement(name = "TotCurrInvstmnts", required = true, defaultValue = "0")
                protected BigInteger totCurrInvstmnts;

                /**
                 * Gets the value of the equityInstruments property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.CurrInvstmnts.EquityInstruments }
                 *     
                 */
                public PARTABSFor6FrmAY13 .Assets.CurrentAssets.CurrInvstmnts.EquityInstruments getEquityInstruments() {
                    return equityInstruments;
                }

                /**
                 * Sets the value of the equityInstruments property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.CurrInvstmnts.EquityInstruments }
                 *     
                 */
                public void setEquityInstruments(PARTABSFor6FrmAY13 .Assets.CurrentAssets.CurrInvstmnts.EquityInstruments value) {
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
                 * Gets the value of the invstmntInPrtnrShipFirm property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getInvstmntInPrtnrShipFirm() {
                    return invstmntInPrtnrShipFirm;
                }

                /**
                 * Sets the value of the invstmntInPrtnrShipFirm property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setInvstmntInPrtnrShipFirm(BigInteger value) {
                    this.invstmntInPrtnrShipFirm = value;
                }

                /**
                 * Gets the value of the otherInvstmnts property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOtherInvstmnts() {
                    return otherInvstmnts;
                }

                /**
                 * Sets the value of the otherInvstmnts property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOtherInvstmnts(BigInteger value) {
                    this.otherInvstmnts = value;
                }

                /**
                 * Gets the value of the totCurrInvstmnts property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotCurrInvstmnts() {
                    return totCurrInvstmnts;
                }

                /**
                 * Sets the value of the totCurrInvstmnts property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotCurrInvstmnts(BigInteger value) {
                    this.totCurrInvstmnts = value;
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
             *         &lt;element name="LoanAdv">
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
             *         &lt;element name="TotShrtTermLoans">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="STLoanAdvDtls">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="BusOrProf">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="NotForBusOrProf">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="ShareHolderUs2_22">
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
                "loanAdv",
                "others",
                "totShrtTermLoans",
                "stLoanAdvDtls"
            })
            public static class TotShortTermLoanAdv {

                @XmlElement(name = "LoanAdv", required = true, defaultValue = "0")
                protected BigInteger loanAdv;
                @XmlElement(name = "Others", required = true, defaultValue = "0")
                protected BigInteger others;
                @XmlElement(name = "TotShrtTermLoans", required = true, defaultValue = "0")
                protected BigInteger totShrtTermLoans;
                @XmlElement(name = "STLoanAdvDtls", required = true)
                protected PARTABSFor6FrmAY13 .Assets.CurrentAssets.TotShortTermLoanAdv.STLoanAdvDtls stLoanAdvDtls;

                /**
                 * Gets the value of the loanAdv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getLoanAdv() {
                    return loanAdv;
                }

                /**
                 * Sets the value of the loanAdv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setLoanAdv(BigInteger value) {
                    this.loanAdv = value;
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
                 * Gets the value of the totShrtTermLoans property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotShrtTermLoans() {
                    return totShrtTermLoans;
                }

                /**
                 * Sets the value of the totShrtTermLoans property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotShrtTermLoans(BigInteger value) {
                    this.totShrtTermLoans = value;
                }

                /**
                 * Gets the value of the stLoanAdvDtls property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.TotShortTermLoanAdv.STLoanAdvDtls }
                 *     
                 */
                public PARTABSFor6FrmAY13 .Assets.CurrentAssets.TotShortTermLoanAdv.STLoanAdvDtls getSTLoanAdvDtls() {
                    return stLoanAdvDtls;
                }

                /**
                 * Sets the value of the stLoanAdvDtls property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.CurrentAssets.TotShortTermLoanAdv.STLoanAdvDtls }
                 *     
                 */
                public void setSTLoanAdvDtls(PARTABSFor6FrmAY13 .Assets.CurrentAssets.TotShortTermLoanAdv.STLoanAdvDtls value) {
                    this.stLoanAdvDtls = value;
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
                 *         &lt;element name="BusOrProf">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="NotForBusOrProf">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="ShareHolderUs2_22">
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
                    "busOrProf",
                    "notForBusOrProf",
                    "shareHolderUs222"
                })
                public static class STLoanAdvDtls {

                    @XmlElement(name = "BusOrProf", required = true, defaultValue = "0")
                    protected BigInteger busOrProf;
                    @XmlElement(name = "NotForBusOrProf", required = true, defaultValue = "0")
                    protected BigInteger notForBusOrProf;
                    @XmlElement(name = "ShareHolderUs2_22", required = true, defaultValue = "0")
                    protected BigInteger shareHolderUs222;

                    /**
                     * Gets the value of the busOrProf property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getBusOrProf() {
                        return busOrProf;
                    }

                    /**
                     * Sets the value of the busOrProf property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setBusOrProf(BigInteger value) {
                        this.busOrProf = value;
                    }

                    /**
                     * Gets the value of the notForBusOrProf property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getNotForBusOrProf() {
                        return notForBusOrProf;
                    }

                    /**
                     * Sets the value of the notForBusOrProf property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setNotForBusOrProf(BigInteger value) {
                        this.notForBusOrProf = value;
                    }

                    /**
                     * Gets the value of the shareHolderUs222 property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getShareHolderUs222() {
                        return shareHolderUs222;
                    }

                    /**
                     * Sets the value of the shareHolderUs222 property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setShareHolderUs222(BigInteger value) {
                        this.shareHolderUs222 = value;
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
             *         &lt;element name="OSMoreThanSixMonths">
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
             *         &lt;element name="TotalTradeReceivables">
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
                "osMoreThanSixMonths",
                "others",
                "totalTradeReceivables"
            })
            public static class TradeReceivables {

                @XmlElement(name = "OSMoreThanSixMonths", required = true, defaultValue = "0")
                protected BigInteger osMoreThanSixMonths;
                @XmlElement(name = "Others", required = true, defaultValue = "0")
                protected BigInteger others;
                @XmlElement(name = "TotalTradeReceivables", required = true, defaultValue = "0")
                protected BigInteger totalTradeReceivables;

                /**
                 * Gets the value of the osMoreThanSixMonths property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOSMoreThanSixMonths() {
                    return osMoreThanSixMonths;
                }

                /**
                 * Sets the value of the osMoreThanSixMonths property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOSMoreThanSixMonths(BigInteger value) {
                    this.osMoreThanSixMonths = value;
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
                 * Gets the value of the totalTradeReceivables property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotalTradeReceivables() {
                    return totalTradeReceivables;
                }

                /**
                 * Sets the value of the totalTradeReceivables property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotalTradeReceivables(BigInteger value) {
                    this.totalTradeReceivables = value;
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
         *         &lt;element name="FixedAsset">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Tangible">
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
         *                             &lt;element name="ImpairmentLosses">
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
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="InTangible">
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
         *                             &lt;element name="Amortization">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="ImpairmentLosses">
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
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="CapWrkProg">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="IntangibleAssetUnDev">
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
         *         &lt;element name="NonCurrInvstmnts">
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
         *                   &lt;element name="InvstmntInPrtnrShipFirm">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OtherInvstmnts">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotNonCurrInvstmnts">
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
         *         &lt;element name="NetDeferredTaxAssets">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="LongTrmLoanAdv">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="CapitalAdv">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="SecurityDeposits">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="LoanAdvRelatedParties">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OthLoanAdv">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotLTLoanAdv">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="LTLoanAdvDtls">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="BusOrProf">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="NotForBusOrProf">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="ShareHolderUs2_22">
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
         *         &lt;element name="OthNonCurrAssets">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="LTTradeReceivables">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Secured">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="Unsecured">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="Doubtful">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="TotOthNonCurrAssets">
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
         *                   &lt;element name="Others">
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
         *                   &lt;element name="NonCurrAssetUs2_22">
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
         *         &lt;element name="TotNonCurrAssets">
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
            "fixedAsset",
            "nonCurrInvstmnts",
            "netDeferredTaxAssets",
            "longTrmLoanAdv",
            "othNonCurrAssets",
            "totNonCurrAssets"
        })
        public static class NonCurrAssets {

            @XmlElement(name = "FixedAsset", required = true)
            protected PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset fixedAsset;
            @XmlElement(name = "NonCurrInvstmnts", required = true)
            protected PARTABSFor6FrmAY13 .Assets.NonCurrAssets.NonCurrInvstmnts nonCurrInvstmnts;
            @XmlElement(name = "NetDeferredTaxAssets", required = true, defaultValue = "0")
            protected BigInteger netDeferredTaxAssets;
            @XmlElement(name = "LongTrmLoanAdv", required = true)
            protected PARTABSFor6FrmAY13 .Assets.NonCurrAssets.LongTrmLoanAdv longTrmLoanAdv;
            @XmlElement(name = "OthNonCurrAssets", required = true)
            protected PARTABSFor6FrmAY13 .Assets.NonCurrAssets.OthNonCurrAssets othNonCurrAssets;
            @XmlElement(name = "TotNonCurrAssets", required = true, defaultValue = "0")
            protected BigInteger totNonCurrAssets;

            /**
             * Gets the value of the fixedAsset property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset }
             *     
             */
            public PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset getFixedAsset() {
                return fixedAsset;
            }

            /**
             * Sets the value of the fixedAsset property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset }
             *     
             */
            public void setFixedAsset(PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset value) {
                this.fixedAsset = value;
            }

            /**
             * Gets the value of the nonCurrInvstmnts property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.NonCurrInvstmnts }
             *     
             */
            public PARTABSFor6FrmAY13 .Assets.NonCurrAssets.NonCurrInvstmnts getNonCurrInvstmnts() {
                return nonCurrInvstmnts;
            }

            /**
             * Sets the value of the nonCurrInvstmnts property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.NonCurrInvstmnts }
             *     
             */
            public void setNonCurrInvstmnts(PARTABSFor6FrmAY13 .Assets.NonCurrAssets.NonCurrInvstmnts value) {
                this.nonCurrInvstmnts = value;
            }

            /**
             * Gets the value of the netDeferredTaxAssets property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getNetDeferredTaxAssets() {
                return netDeferredTaxAssets;
            }

            /**
             * Sets the value of the netDeferredTaxAssets property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setNetDeferredTaxAssets(BigInteger value) {
                this.netDeferredTaxAssets = value;
            }

            /**
             * Gets the value of the longTrmLoanAdv property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.LongTrmLoanAdv }
             *     
             */
            public PARTABSFor6FrmAY13 .Assets.NonCurrAssets.LongTrmLoanAdv getLongTrmLoanAdv() {
                return longTrmLoanAdv;
            }

            /**
             * Sets the value of the longTrmLoanAdv property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.LongTrmLoanAdv }
             *     
             */
            public void setLongTrmLoanAdv(PARTABSFor6FrmAY13 .Assets.NonCurrAssets.LongTrmLoanAdv value) {
                this.longTrmLoanAdv = value;
            }

            /**
             * Gets the value of the othNonCurrAssets property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.OthNonCurrAssets }
             *     
             */
            public PARTABSFor6FrmAY13 .Assets.NonCurrAssets.OthNonCurrAssets getOthNonCurrAssets() {
                return othNonCurrAssets;
            }

            /**
             * Sets the value of the othNonCurrAssets property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.OthNonCurrAssets }
             *     
             */
            public void setOthNonCurrAssets(PARTABSFor6FrmAY13 .Assets.NonCurrAssets.OthNonCurrAssets value) {
                this.othNonCurrAssets = value;
            }

            /**
             * Gets the value of the totNonCurrAssets property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getTotNonCurrAssets() {
                return totNonCurrAssets;
            }

            /**
             * Sets the value of the totNonCurrAssets property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTotNonCurrAssets(BigInteger value) {
                this.totNonCurrAssets = value;
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
             *         &lt;element name="Tangible">
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
             *                   &lt;element name="ImpairmentLosses">
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
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="InTangible">
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
             *                   &lt;element name="Amortization">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="ImpairmentLosses">
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
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="CapWrkProg">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="IntangibleAssetUnDev">
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
                "tangible",
                "inTangible",
                "capWrkProg",
                "intangibleAssetUnDev",
                "totFixedAsset"
            })
            public static class FixedAsset {

                @XmlElement(name = "Tangible", required = true)
                protected PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset.Tangible tangible;
                @XmlElement(name = "InTangible", required = true)
                protected PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset.InTangible inTangible;
                @XmlElement(name = "CapWrkProg", required = true, defaultValue = "0")
                protected BigInteger capWrkProg;
                @XmlElement(name = "IntangibleAssetUnDev", required = true, defaultValue = "0")
                protected BigInteger intangibleAssetUnDev;
                @XmlElement(name = "TotFixedAsset", required = true, defaultValue = "0")
                protected BigInteger totFixedAsset;

                /**
                 * Gets the value of the tangible property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset.Tangible }
                 *     
                 */
                public PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset.Tangible getTangible() {
                    return tangible;
                }

                /**
                 * Sets the value of the tangible property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset.Tangible }
                 *     
                 */
                public void setTangible(PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset.Tangible value) {
                    this.tangible = value;
                }

                /**
                 * Gets the value of the inTangible property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset.InTangible }
                 *     
                 */
                public PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset.InTangible getInTangible() {
                    return inTangible;
                }

                /**
                 * Sets the value of the inTangible property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset.InTangible }
                 *     
                 */
                public void setInTangible(PARTABSFor6FrmAY13 .Assets.NonCurrAssets.FixedAsset.InTangible value) {
                    this.inTangible = value;
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
                 * Gets the value of the intangibleAssetUnDev property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getIntangibleAssetUnDev() {
                    return intangibleAssetUnDev;
                }

                /**
                 * Sets the value of the intangibleAssetUnDev property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setIntangibleAssetUnDev(BigInteger value) {
                    this.intangibleAssetUnDev = value;
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
                 *         &lt;element name="Amortization">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="ImpairmentLosses">
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
                    "amortization",
                    "impairmentLosses",
                    "netBlock"
                })
                public static class InTangible {

                    @XmlElement(name = "GrossBlock", required = true, defaultValue = "0")
                    protected BigInteger grossBlock;
                    @XmlElement(name = "Amortization", required = true, defaultValue = "0")
                    protected BigInteger amortization;
                    @XmlElement(name = "ImpairmentLosses", required = true, defaultValue = "0")
                    protected BigInteger impairmentLosses;
                    @XmlElement(name = "NetBlock", required = true, defaultValue = "0")
                    protected BigInteger netBlock;

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
                     * Gets the value of the amortization property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getAmortization() {
                        return amortization;
                    }

                    /**
                     * Sets the value of the amortization property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setAmortization(BigInteger value) {
                        this.amortization = value;
                    }

                    /**
                     * Gets the value of the impairmentLosses property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getImpairmentLosses() {
                        return impairmentLosses;
                    }

                    /**
                     * Sets the value of the impairmentLosses property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setImpairmentLosses(BigInteger value) {
                        this.impairmentLosses = value;
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
                 *         &lt;element name="ImpairmentLosses">
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
                    "impairmentLosses",
                    "netBlock"
                })
                public static class Tangible {

                    @XmlElement(name = "GrossBlock", required = true, defaultValue = "0")
                    protected BigInteger grossBlock;
                    @XmlElement(name = "Depreciation", required = true, defaultValue = "0")
                    protected BigInteger depreciation;
                    @XmlElement(name = "ImpairmentLosses", required = true, defaultValue = "0")
                    protected BigInteger impairmentLosses;
                    @XmlElement(name = "NetBlock", required = true, defaultValue = "0")
                    protected BigInteger netBlock;

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
                     * Gets the value of the impairmentLosses property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getImpairmentLosses() {
                        return impairmentLosses;
                    }

                    /**
                     * Sets the value of the impairmentLosses property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setImpairmentLosses(BigInteger value) {
                        this.impairmentLosses = value;
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
             *         &lt;element name="CapitalAdv">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="SecurityDeposits">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="LoanAdvRelatedParties">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OthLoanAdv">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotLTLoanAdv">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="LTLoanAdvDtls">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="BusOrProf">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="NotForBusOrProf">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="ShareHolderUs2_22">
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
                "capitalAdv",
                "securityDeposits",
                "loanAdvRelatedParties",
                "othLoanAdv",
                "totLTLoanAdv",
                "ltLoanAdvDtls"
            })
            public static class LongTrmLoanAdv {

                @XmlElement(name = "CapitalAdv", required = true, defaultValue = "0")
                protected BigInteger capitalAdv;
                @XmlElement(name = "SecurityDeposits", required = true, defaultValue = "0")
                protected BigInteger securityDeposits;
                @XmlElement(name = "LoanAdvRelatedParties", required = true, defaultValue = "0")
                protected BigInteger loanAdvRelatedParties;
                @XmlElement(name = "OthLoanAdv", required = true, defaultValue = "0")
                protected BigInteger othLoanAdv;
                @XmlElement(name = "TotLTLoanAdv", required = true, defaultValue = "0")
                protected BigInteger totLTLoanAdv;
                @XmlElement(name = "LTLoanAdvDtls", required = true)
                protected PARTABSFor6FrmAY13 .Assets.NonCurrAssets.LongTrmLoanAdv.LTLoanAdvDtls ltLoanAdvDtls;

                /**
                 * Gets the value of the capitalAdv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getCapitalAdv() {
                    return capitalAdv;
                }

                /**
                 * Sets the value of the capitalAdv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setCapitalAdv(BigInteger value) {
                    this.capitalAdv = value;
                }

                /**
                 * Gets the value of the securityDeposits property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getSecurityDeposits() {
                    return securityDeposits;
                }

                /**
                 * Sets the value of the securityDeposits property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setSecurityDeposits(BigInteger value) {
                    this.securityDeposits = value;
                }

                /**
                 * Gets the value of the loanAdvRelatedParties property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getLoanAdvRelatedParties() {
                    return loanAdvRelatedParties;
                }

                /**
                 * Sets the value of the loanAdvRelatedParties property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setLoanAdvRelatedParties(BigInteger value) {
                    this.loanAdvRelatedParties = value;
                }

                /**
                 * Gets the value of the othLoanAdv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOthLoanAdv() {
                    return othLoanAdv;
                }

                /**
                 * Sets the value of the othLoanAdv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOthLoanAdv(BigInteger value) {
                    this.othLoanAdv = value;
                }

                /**
                 * Gets the value of the totLTLoanAdv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotLTLoanAdv() {
                    return totLTLoanAdv;
                }

                /**
                 * Sets the value of the totLTLoanAdv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotLTLoanAdv(BigInteger value) {
                    this.totLTLoanAdv = value;
                }

                /**
                 * Gets the value of the ltLoanAdvDtls property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.LongTrmLoanAdv.LTLoanAdvDtls }
                 *     
                 */
                public PARTABSFor6FrmAY13 .Assets.NonCurrAssets.LongTrmLoanAdv.LTLoanAdvDtls getLTLoanAdvDtls() {
                    return ltLoanAdvDtls;
                }

                /**
                 * Sets the value of the ltLoanAdvDtls property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.LongTrmLoanAdv.LTLoanAdvDtls }
                 *     
                 */
                public void setLTLoanAdvDtls(PARTABSFor6FrmAY13 .Assets.NonCurrAssets.LongTrmLoanAdv.LTLoanAdvDtls value) {
                    this.ltLoanAdvDtls = value;
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
                 *         &lt;element name="BusOrProf">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="NotForBusOrProf">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="ShareHolderUs2_22">
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
                    "busOrProf",
                    "notForBusOrProf",
                    "shareHolderUs222"
                })
                public static class LTLoanAdvDtls {

                    @XmlElement(name = "BusOrProf", required = true, defaultValue = "0")
                    protected BigInteger busOrProf;
                    @XmlElement(name = "NotForBusOrProf", required = true, defaultValue = "0")
                    protected BigInteger notForBusOrProf;
                    @XmlElement(name = "ShareHolderUs2_22", required = true, defaultValue = "0")
                    protected BigInteger shareHolderUs222;

                    /**
                     * Gets the value of the busOrProf property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getBusOrProf() {
                        return busOrProf;
                    }

                    /**
                     * Sets the value of the busOrProf property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setBusOrProf(BigInteger value) {
                        this.busOrProf = value;
                    }

                    /**
                     * Gets the value of the notForBusOrProf property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getNotForBusOrProf() {
                        return notForBusOrProf;
                    }

                    /**
                     * Sets the value of the notForBusOrProf property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setNotForBusOrProf(BigInteger value) {
                        this.notForBusOrProf = value;
                    }

                    /**
                     * Gets the value of the shareHolderUs222 property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getShareHolderUs222() {
                        return shareHolderUs222;
                    }

                    /**
                     * Sets the value of the shareHolderUs222 property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setShareHolderUs222(BigInteger value) {
                        this.shareHolderUs222 = value;
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
             *         &lt;element name="InvstmntInPrtnrShipFirm">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OtherInvstmnts">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotNonCurrInvstmnts">
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
                "invstmntInPrtnrShipFirm",
                "otherInvstmnts",
                "totNonCurrInvstmnts"
            })
            public static class NonCurrInvstmnts {

                @XmlElement(name = "InvInProperty", required = true, defaultValue = "0")
                protected BigInteger invInProperty;
                @XmlElement(name = "EquityInstruments", required = true)
                protected PARTABSFor6FrmAY13 .Assets.NonCurrAssets.NonCurrInvstmnts.EquityInstruments equityInstruments;
                @XmlElement(name = "PreferenceShares", required = true, defaultValue = "0")
                protected BigInteger preferenceShares;
                @XmlElement(name = "GovtOrTrustSecurities", required = true, defaultValue = "0")
                protected BigInteger govtOrTrustSecurities;
                @XmlElement(name = "DebenturesOrBonds", required = true, defaultValue = "0")
                protected BigInteger debenturesOrBonds;
                @XmlElement(name = "MutualFunds", required = true, defaultValue = "0")
                protected BigInteger mutualFunds;
                @XmlElement(name = "InvstmntInPrtnrShipFirm", required = true, defaultValue = "0")
                protected BigInteger invstmntInPrtnrShipFirm;
                @XmlElement(name = "OtherInvstmnts", required = true, defaultValue = "0")
                protected BigInteger otherInvstmnts;
                @XmlElement(name = "TotNonCurrInvstmnts", required = true, defaultValue = "0")
                protected BigInteger totNonCurrInvstmnts;

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
                 *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.NonCurrInvstmnts.EquityInstruments }
                 *     
                 */
                public PARTABSFor6FrmAY13 .Assets.NonCurrAssets.NonCurrInvstmnts.EquityInstruments getEquityInstruments() {
                    return equityInstruments;
                }

                /**
                 * Sets the value of the equityInstruments property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.NonCurrInvstmnts.EquityInstruments }
                 *     
                 */
                public void setEquityInstruments(PARTABSFor6FrmAY13 .Assets.NonCurrAssets.NonCurrInvstmnts.EquityInstruments value) {
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
                 * Gets the value of the invstmntInPrtnrShipFirm property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getInvstmntInPrtnrShipFirm() {
                    return invstmntInPrtnrShipFirm;
                }

                /**
                 * Sets the value of the invstmntInPrtnrShipFirm property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setInvstmntInPrtnrShipFirm(BigInteger value) {
                    this.invstmntInPrtnrShipFirm = value;
                }

                /**
                 * Gets the value of the otherInvstmnts property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOtherInvstmnts() {
                    return otherInvstmnts;
                }

                /**
                 * Sets the value of the otherInvstmnts property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOtherInvstmnts(BigInteger value) {
                    this.otherInvstmnts = value;
                }

                /**
                 * Gets the value of the totNonCurrInvstmnts property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotNonCurrInvstmnts() {
                    return totNonCurrInvstmnts;
                }

                /**
                 * Sets the value of the totNonCurrInvstmnts property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotNonCurrInvstmnts(BigInteger value) {
                    this.totNonCurrInvstmnts = value;
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
             *         &lt;element name="LTTradeReceivables">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Secured">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="Unsecured">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="Doubtful">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="TotOthNonCurrAssets">
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
             *         &lt;element name="Others">
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
             *         &lt;element name="NonCurrAssetUs2_22">
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
                "ltTradeReceivables",
                "others",
                "total",
                "nonCurrAssetUs222"
            })
            public static class OthNonCurrAssets {

                @XmlElement(name = "LTTradeReceivables", required = true)
                protected PARTABSFor6FrmAY13 .Assets.NonCurrAssets.OthNonCurrAssets.LTTradeReceivables ltTradeReceivables;
                @XmlElement(name = "Others", required = true, defaultValue = "0")
                protected BigInteger others;
                @XmlElement(name = "Total", required = true, defaultValue = "0")
                protected BigInteger total;
                @XmlElement(name = "NonCurrAssetUs2_22", required = true, defaultValue = "0")
                protected BigInteger nonCurrAssetUs222;

                /**
                 * Gets the value of the ltTradeReceivables property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.OthNonCurrAssets.LTTradeReceivables }
                 *     
                 */
                public PARTABSFor6FrmAY13 .Assets.NonCurrAssets.OthNonCurrAssets.LTTradeReceivables getLTTradeReceivables() {
                    return ltTradeReceivables;
                }

                /**
                 * Sets the value of the ltTradeReceivables property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABSFor6FrmAY13 .Assets.NonCurrAssets.OthNonCurrAssets.LTTradeReceivables }
                 *     
                 */
                public void setLTTradeReceivables(PARTABSFor6FrmAY13 .Assets.NonCurrAssets.OthNonCurrAssets.LTTradeReceivables value) {
                    this.ltTradeReceivables = value;
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

                /**
                 * Gets the value of the nonCurrAssetUs222 property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getNonCurrAssetUs222() {
                    return nonCurrAssetUs222;
                }

                /**
                 * Sets the value of the nonCurrAssetUs222 property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setNonCurrAssetUs222(BigInteger value) {
                    this.nonCurrAssetUs222 = value;
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
                 *         &lt;element name="Secured">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="Unsecured">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="Doubtful">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="TotOthNonCurrAssets">
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
                    "secured",
                    "unsecured",
                    "doubtful",
                    "totOthNonCurrAssets"
                })
                public static class LTTradeReceivables {

                    @XmlElement(name = "Secured", required = true, defaultValue = "0")
                    protected BigInteger secured;
                    @XmlElement(name = "Unsecured", required = true, defaultValue = "0")
                    protected BigInteger unsecured;
                    @XmlElement(name = "Doubtful", required = true, defaultValue = "0")
                    protected BigInteger doubtful;
                    @XmlElement(name = "TotOthNonCurrAssets", required = true, defaultValue = "0")
                    protected BigInteger totOthNonCurrAssets;

                    /**
                     * Gets the value of the secured property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getSecured() {
                        return secured;
                    }

                    /**
                     * Sets the value of the secured property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setSecured(BigInteger value) {
                        this.secured = value;
                    }

                    /**
                     * Gets the value of the unsecured property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getUnsecured() {
                        return unsecured;
                    }

                    /**
                     * Sets the value of the unsecured property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setUnsecured(BigInteger value) {
                        this.unsecured = value;
                    }

                    /**
                     * Gets the value of the doubtful property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getDoubtful() {
                        return doubtful;
                    }

                    /**
                     * Sets the value of the doubtful property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setDoubtful(BigInteger value) {
                        this.doubtful = value;
                    }

                    /**
                     * Gets the value of the totOthNonCurrAssets property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotOthNonCurrAssets() {
                        return totOthNonCurrAssets;
                    }

                    /**
                     * Sets the value of the totOthNonCurrAssets property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotOthNonCurrAssets(BigInteger value) {
                        this.totOthNonCurrAssets = value;
                    }

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
     *         &lt;element name="ShareHolderFund">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ShareCapital">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Authorised">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="IssuedSubsPaidUp">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="SubscribedNotFullyPaid">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotShareCapital">
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
     *                   &lt;element name="ResrNSurp">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="CapResr">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="CapRedempResr">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="SecurPremResr">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="DebunRedResr">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="RevResr">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="ShareOptOSAmount">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="OtherResrvDtls" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Nature">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                             &lt;maxLength value="50"/>
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
     *                             &lt;element name="OtherResrvTotal">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="PLAccount">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotResrNSurp">
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
     *                   &lt;element name="MoneyRecvdAgainstShares">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="TotShareHolderFund">
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
     *         &lt;element name="ShareAppMoneyAllot">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PendingLtOneYr">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="PendingMtOneYr">
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
     *         &lt;element name="NonCurrLiabilities">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="LongTermBorrowings">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="BondsDebentures">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="ForeignCurrency">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="Rupee">
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
     *                             &lt;element name="TermLoans">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="ForeignCurrency">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="RupeeLoans">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="FromBanks">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                                       &lt;totalDigits value="14"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="FromOthers">
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
     *                                       &lt;element name="TotalTermLoans">
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
     *                             &lt;element name="DeferredPymtLiabilities">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="DepositsFrmRelatedParties">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="OtherDeposits">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="LoansAndAdv">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="OthersLoanAdv">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="LongTermMaturities">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotalLTBorrowings">
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
     *                   &lt;element name="NetDefferedTaxLiability">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="OthLongTermLiablities">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="TradePayables">
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
     *                             &lt;element name="TotalOthLtLiabilities">
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
     *                   &lt;element name="LongTermProvisions">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="ProvEmpBenefits">
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
     *                   &lt;element name="TotalNonCurrLiabilites">
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
     *         &lt;element name="CurrentLiabilities">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ShortTrmBorrowings">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="LoansRepaybleOnDemand">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="FromBanks">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="FrmNonBanking">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                             &lt;totalDigits value="14"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="OthFinanceInst">
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
     *                                       &lt;element name="TotLoansRepaybleOnDemand">
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
     *                             &lt;element name="DepositsFrmRelatedParties">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="LoansAndAdv">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="OthLoansAndAdv">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="OthDeposits">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotShortTrmBorrowings">
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
     *                   &lt;element name="TradePayables">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="OSMoreThanOneYr">
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
     *                             &lt;element name="TotalTradePayables">
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
     *                   &lt;element name="OthCurrLiabilities">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="CurrMatOnLTDebt">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="CurrMatFinanceOblg">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="AccrInterest">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="AccrInterestNotDue">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="IncRecvdAdvance">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="UnpaidDividend">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="AppMonyRecvdAllotSecurities">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="UnpaidMatDeposits">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="UnpaidMatureDebenture">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="OthPayables">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TotOthCurrLiabilities">
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
     *                   &lt;element name="ShortTermProv">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="EmpBenefitProv">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="ITProvision">
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
     *                             &lt;element name="ProposedDividend">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *                                   &lt;totalDigits value="14"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="TaxOnDividend">
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
     *                             &lt;element name="TotShortTermProvisions">
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
     *         &lt;element name="TotEquityAndLiabilities">
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
        "shareHolderFund",
        "shareAppMoneyAllot",
        "nonCurrLiabilities",
        "currentLiabilities",
        "totEquityAndLiabilities"
    })
    public static class EquityAndLiablities {

        @XmlElement(name = "ShareHolderFund", required = true)
        protected PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund shareHolderFund;
        @XmlElement(name = "ShareAppMoneyAllot", required = true)
        protected PARTABSFor6FrmAY13 .EquityAndLiablities.ShareAppMoneyAllot shareAppMoneyAllot;
        @XmlElement(name = "NonCurrLiabilities", required = true)
        protected PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities nonCurrLiabilities;
        @XmlElement(name = "CurrentLiabilities", required = true)
        protected PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities currentLiabilities;
        @XmlElement(name = "TotEquityAndLiabilities", required = true, defaultValue = "0")
        protected BigInteger totEquityAndLiabilities;

        /**
         * Gets the value of the shareHolderFund property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund }
         *     
         */
        public PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund getShareHolderFund() {
            return shareHolderFund;
        }

        /**
         * Sets the value of the shareHolderFund property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund }
         *     
         */
        public void setShareHolderFund(PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund value) {
            this.shareHolderFund = value;
        }

        /**
         * Gets the value of the shareAppMoneyAllot property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.ShareAppMoneyAllot }
         *     
         */
        public PARTABSFor6FrmAY13 .EquityAndLiablities.ShareAppMoneyAllot getShareAppMoneyAllot() {
            return shareAppMoneyAllot;
        }

        /**
         * Sets the value of the shareAppMoneyAllot property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.ShareAppMoneyAllot }
         *     
         */
        public void setShareAppMoneyAllot(PARTABSFor6FrmAY13 .EquityAndLiablities.ShareAppMoneyAllot value) {
            this.shareAppMoneyAllot = value;
        }

        /**
         * Gets the value of the nonCurrLiabilities property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities }
         *     
         */
        public PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities getNonCurrLiabilities() {
            return nonCurrLiabilities;
        }

        /**
         * Sets the value of the nonCurrLiabilities property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities }
         *     
         */
        public void setNonCurrLiabilities(PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities value) {
            this.nonCurrLiabilities = value;
        }

        /**
         * Gets the value of the currentLiabilities property.
         * 
         * @return
         *     possible object is
         *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities }
         *     
         */
        public PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities getCurrentLiabilities() {
            return currentLiabilities;
        }

        /**
         * Sets the value of the currentLiabilities property.
         * 
         * @param value
         *     allowed object is
         *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities }
         *     
         */
        public void setCurrentLiabilities(PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities value) {
            this.currentLiabilities = value;
        }

        /**
         * Gets the value of the totEquityAndLiabilities property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotEquityAndLiabilities() {
            return totEquityAndLiabilities;
        }

        /**
         * Sets the value of the totEquityAndLiabilities property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotEquityAndLiabilities(BigInteger value) {
            this.totEquityAndLiabilities = value;
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
         *         &lt;element name="ShortTrmBorrowings">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="LoansRepaybleOnDemand">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="FromBanks">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="FrmNonBanking">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="OthFinanceInst">
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
         *                             &lt;element name="TotLoansRepaybleOnDemand">
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
         *                   &lt;element name="DepositsFrmRelatedParties">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="LoansAndAdv">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OthLoansAndAdv">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OthDeposits">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotShortTrmBorrowings">
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
         *         &lt;element name="TradePayables">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="OSMoreThanOneYr">
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
         *                   &lt;element name="TotalTradePayables">
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
         *         &lt;element name="OthCurrLiabilities">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="CurrMatOnLTDebt">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="CurrMatFinanceOblg">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="AccrInterest">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="AccrInterestNotDue">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="IncRecvdAdvance">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="UnpaidDividend">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="AppMonyRecvdAllotSecurities">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="UnpaidMatDeposits">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="UnpaidMatureDebenture">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OthPayables">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotOthCurrLiabilities">
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
         *         &lt;element name="ShortTermProv">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="EmpBenefitProv">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="ITProvision">
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
         *                   &lt;element name="ProposedDividend">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TaxOnDividend">
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
         *                   &lt;element name="TotShortTermProvisions">
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
            "shortTrmBorrowings",
            "tradePayables",
            "othCurrLiabilities",
            "shortTermProv",
            "totCurrLiabilitiesProvision"
        })
        public static class CurrentLiabilities {

            @XmlElement(name = "ShortTrmBorrowings", required = true)
            protected PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTrmBorrowings shortTrmBorrowings;
            @XmlElement(name = "TradePayables", required = true)
            protected PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.TradePayables tradePayables;
            @XmlElement(name = "OthCurrLiabilities", required = true)
            protected PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.OthCurrLiabilities othCurrLiabilities;
            @XmlElement(name = "ShortTermProv", required = true)
            protected PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTermProv shortTermProv;
            @XmlElement(name = "TotCurrLiabilitiesProvision", required = true, defaultValue = "0")
            protected BigInteger totCurrLiabilitiesProvision;

            /**
             * Gets the value of the shortTrmBorrowings property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTrmBorrowings }
             *     
             */
            public PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTrmBorrowings getShortTrmBorrowings() {
                return shortTrmBorrowings;
            }

            /**
             * Sets the value of the shortTrmBorrowings property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTrmBorrowings }
             *     
             */
            public void setShortTrmBorrowings(PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTrmBorrowings value) {
                this.shortTrmBorrowings = value;
            }

            /**
             * Gets the value of the tradePayables property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.TradePayables }
             *     
             */
            public PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.TradePayables getTradePayables() {
                return tradePayables;
            }

            /**
             * Sets the value of the tradePayables property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.TradePayables }
             *     
             */
            public void setTradePayables(PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.TradePayables value) {
                this.tradePayables = value;
            }

            /**
             * Gets the value of the othCurrLiabilities property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.OthCurrLiabilities }
             *     
             */
            public PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.OthCurrLiabilities getOthCurrLiabilities() {
                return othCurrLiabilities;
            }

            /**
             * Sets the value of the othCurrLiabilities property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.OthCurrLiabilities }
             *     
             */
            public void setOthCurrLiabilities(PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.OthCurrLiabilities value) {
                this.othCurrLiabilities = value;
            }

            /**
             * Gets the value of the shortTermProv property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTermProv }
             *     
             */
            public PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTermProv getShortTermProv() {
                return shortTermProv;
            }

            /**
             * Sets the value of the shortTermProv property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTermProv }
             *     
             */
            public void setShortTermProv(PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTermProv value) {
                this.shortTermProv = value;
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
             *         &lt;element name="CurrMatOnLTDebt">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="CurrMatFinanceOblg">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="AccrInterest">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="AccrInterestNotDue">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="IncRecvdAdvance">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="UnpaidDividend">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="AppMonyRecvdAllotSecurities">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="UnpaidMatDeposits">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="UnpaidMatureDebenture">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OthPayables">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotOthCurrLiabilities">
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
                "currMatOnLTDebt",
                "currMatFinanceOblg",
                "accrInterest",
                "accrInterestNotDue",
                "incRecvdAdvance",
                "unpaidDividend",
                "appMonyRecvdAllotSecurities",
                "unpaidMatDeposits",
                "unpaidMatureDebenture",
                "othPayables",
                "totOthCurrLiabilities"
            })
            public static class OthCurrLiabilities {

                @XmlElement(name = "CurrMatOnLTDebt", required = true, defaultValue = "0")
                protected BigInteger currMatOnLTDebt;
                @XmlElement(name = "CurrMatFinanceOblg", required = true, defaultValue = "0")
                protected BigInteger currMatFinanceOblg;
                @XmlElement(name = "AccrInterest", required = true, defaultValue = "0")
                protected BigInteger accrInterest;
                @XmlElement(name = "AccrInterestNotDue", required = true, defaultValue = "0")
                protected BigInteger accrInterestNotDue;
                @XmlElement(name = "IncRecvdAdvance", required = true, defaultValue = "0")
                protected BigInteger incRecvdAdvance;
                @XmlElement(name = "UnpaidDividend", required = true, defaultValue = "0")
                protected BigInteger unpaidDividend;
                @XmlElement(name = "AppMonyRecvdAllotSecurities", required = true, defaultValue = "0")
                protected BigInteger appMonyRecvdAllotSecurities;
                @XmlElement(name = "UnpaidMatDeposits", required = true, defaultValue = "0")
                protected BigInteger unpaidMatDeposits;
                @XmlElement(name = "UnpaidMatureDebenture", required = true, defaultValue = "0")
                protected BigInteger unpaidMatureDebenture;
                @XmlElement(name = "OthPayables", required = true, defaultValue = "0")
                protected BigInteger othPayables;
                @XmlElement(name = "TotOthCurrLiabilities", required = true, defaultValue = "0")
                protected BigInteger totOthCurrLiabilities;

                /**
                 * Gets the value of the currMatOnLTDebt property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getCurrMatOnLTDebt() {
                    return currMatOnLTDebt;
                }

                /**
                 * Sets the value of the currMatOnLTDebt property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setCurrMatOnLTDebt(BigInteger value) {
                    this.currMatOnLTDebt = value;
                }

                /**
                 * Gets the value of the currMatFinanceOblg property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getCurrMatFinanceOblg() {
                    return currMatFinanceOblg;
                }

                /**
                 * Sets the value of the currMatFinanceOblg property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setCurrMatFinanceOblg(BigInteger value) {
                    this.currMatFinanceOblg = value;
                }

                /**
                 * Gets the value of the accrInterest property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getAccrInterest() {
                    return accrInterest;
                }

                /**
                 * Sets the value of the accrInterest property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setAccrInterest(BigInteger value) {
                    this.accrInterest = value;
                }

                /**
                 * Gets the value of the accrInterestNotDue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getAccrInterestNotDue() {
                    return accrInterestNotDue;
                }

                /**
                 * Sets the value of the accrInterestNotDue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setAccrInterestNotDue(BigInteger value) {
                    this.accrInterestNotDue = value;
                }

                /**
                 * Gets the value of the incRecvdAdvance property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getIncRecvdAdvance() {
                    return incRecvdAdvance;
                }

                /**
                 * Sets the value of the incRecvdAdvance property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setIncRecvdAdvance(BigInteger value) {
                    this.incRecvdAdvance = value;
                }

                /**
                 * Gets the value of the unpaidDividend property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getUnpaidDividend() {
                    return unpaidDividend;
                }

                /**
                 * Sets the value of the unpaidDividend property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setUnpaidDividend(BigInteger value) {
                    this.unpaidDividend = value;
                }

                /**
                 * Gets the value of the appMonyRecvdAllotSecurities property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getAppMonyRecvdAllotSecurities() {
                    return appMonyRecvdAllotSecurities;
                }

                /**
                 * Sets the value of the appMonyRecvdAllotSecurities property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setAppMonyRecvdAllotSecurities(BigInteger value) {
                    this.appMonyRecvdAllotSecurities = value;
                }

                /**
                 * Gets the value of the unpaidMatDeposits property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getUnpaidMatDeposits() {
                    return unpaidMatDeposits;
                }

                /**
                 * Sets the value of the unpaidMatDeposits property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setUnpaidMatDeposits(BigInteger value) {
                    this.unpaidMatDeposits = value;
                }

                /**
                 * Gets the value of the unpaidMatureDebenture property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getUnpaidMatureDebenture() {
                    return unpaidMatureDebenture;
                }

                /**
                 * Sets the value of the unpaidMatureDebenture property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setUnpaidMatureDebenture(BigInteger value) {
                    this.unpaidMatureDebenture = value;
                }

                /**
                 * Gets the value of the othPayables property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOthPayables() {
                    return othPayables;
                }

                /**
                 * Sets the value of the othPayables property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOthPayables(BigInteger value) {
                    this.othPayables = value;
                }

                /**
                 * Gets the value of the totOthCurrLiabilities property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotOthCurrLiabilities() {
                    return totOthCurrLiabilities;
                }

                /**
                 * Sets the value of the totOthCurrLiabilities property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotOthCurrLiabilities(BigInteger value) {
                    this.totOthCurrLiabilities = value;
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
             *         &lt;element name="EmpBenefitProv">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="ITProvision">
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
             *         &lt;element name="ProposedDividend">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TaxOnDividend">
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
             *         &lt;element name="TotShortTermProvisions">
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
                "empBenefitProv",
                "itProvision",
                "wtProvision",
                "proposedDividend",
                "taxOnDividend",
                "othProvision",
                "totShortTermProvisions"
            })
            public static class ShortTermProv {

                @XmlElement(name = "EmpBenefitProv", required = true, defaultValue = "0")
                protected BigInteger empBenefitProv;
                @XmlElement(name = "ITProvision", required = true, defaultValue = "0")
                protected BigInteger itProvision;
                @XmlElement(name = "WTProvision", required = true, defaultValue = "0")
                protected BigInteger wtProvision;
                @XmlElement(name = "ProposedDividend", required = true, defaultValue = "0")
                protected BigInteger proposedDividend;
                @XmlElement(name = "TaxOnDividend", required = true, defaultValue = "0")
                protected BigInteger taxOnDividend;
                @XmlElement(name = "OthProvision", required = true, defaultValue = "0")
                protected BigInteger othProvision;
                @XmlElement(name = "TotShortTermProvisions", required = true, defaultValue = "0")
                protected BigInteger totShortTermProvisions;

                /**
                 * Gets the value of the empBenefitProv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getEmpBenefitProv() {
                    return empBenefitProv;
                }

                /**
                 * Sets the value of the empBenefitProv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setEmpBenefitProv(BigInteger value) {
                    this.empBenefitProv = value;
                }

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
                 * Gets the value of the totShortTermProvisions property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotShortTermProvisions() {
                    return totShortTermProvisions;
                }

                /**
                 * Sets the value of the totShortTermProvisions property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotShortTermProvisions(BigInteger value) {
                    this.totShortTermProvisions = value;
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
             *         &lt;element name="LoansRepaybleOnDemand">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="FromBanks">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="FrmNonBanking">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="OthFinanceInst">
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
             *                   &lt;element name="TotLoansRepaybleOnDemand">
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
             *         &lt;element name="DepositsFrmRelatedParties">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="LoansAndAdv">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OthLoansAndAdv">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OthDeposits">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotShortTrmBorrowings">
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
                "loansRepaybleOnDemand",
                "depositsFrmRelatedParties",
                "loansAndAdv",
                "othLoansAndAdv",
                "othDeposits",
                "totShortTrmBorrowings"
            })
            public static class ShortTrmBorrowings {

                @XmlElement(name = "LoansRepaybleOnDemand", required = true)
                protected PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTrmBorrowings.LoansRepaybleOnDemand loansRepaybleOnDemand;
                @XmlElement(name = "DepositsFrmRelatedParties", required = true, defaultValue = "0")
                protected BigInteger depositsFrmRelatedParties;
                @XmlElement(name = "LoansAndAdv", required = true, defaultValue = "0")
                protected BigInteger loansAndAdv;
                @XmlElement(name = "OthLoansAndAdv", required = true, defaultValue = "0")
                protected BigInteger othLoansAndAdv;
                @XmlElement(name = "OthDeposits", required = true, defaultValue = "0")
                protected BigInteger othDeposits;
                @XmlElement(name = "TotShortTrmBorrowings", required = true, defaultValue = "0")
                protected BigInteger totShortTrmBorrowings;

                /**
                 * Gets the value of the loansRepaybleOnDemand property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTrmBorrowings.LoansRepaybleOnDemand }
                 *     
                 */
                public PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTrmBorrowings.LoansRepaybleOnDemand getLoansRepaybleOnDemand() {
                    return loansRepaybleOnDemand;
                }

                /**
                 * Sets the value of the loansRepaybleOnDemand property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTrmBorrowings.LoansRepaybleOnDemand }
                 *     
                 */
                public void setLoansRepaybleOnDemand(PARTABSFor6FrmAY13 .EquityAndLiablities.CurrentLiabilities.ShortTrmBorrowings.LoansRepaybleOnDemand value) {
                    this.loansRepaybleOnDemand = value;
                }

                /**
                 * Gets the value of the depositsFrmRelatedParties property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getDepositsFrmRelatedParties() {
                    return depositsFrmRelatedParties;
                }

                /**
                 * Sets the value of the depositsFrmRelatedParties property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setDepositsFrmRelatedParties(BigInteger value) {
                    this.depositsFrmRelatedParties = value;
                }

                /**
                 * Gets the value of the loansAndAdv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getLoansAndAdv() {
                    return loansAndAdv;
                }

                /**
                 * Sets the value of the loansAndAdv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setLoansAndAdv(BigInteger value) {
                    this.loansAndAdv = value;
                }

                /**
                 * Gets the value of the othLoansAndAdv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOthLoansAndAdv() {
                    return othLoansAndAdv;
                }

                /**
                 * Sets the value of the othLoansAndAdv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOthLoansAndAdv(BigInteger value) {
                    this.othLoansAndAdv = value;
                }

                /**
                 * Gets the value of the othDeposits property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOthDeposits() {
                    return othDeposits;
                }

                /**
                 * Sets the value of the othDeposits property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOthDeposits(BigInteger value) {
                    this.othDeposits = value;
                }

                /**
                 * Gets the value of the totShortTrmBorrowings property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotShortTrmBorrowings() {
                    return totShortTrmBorrowings;
                }

                /**
                 * Sets the value of the totShortTrmBorrowings property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotShortTrmBorrowings(BigInteger value) {
                    this.totShortTrmBorrowings = value;
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
                 *         &lt;element name="FromBanks">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="FrmNonBanking">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="OthFinanceInst">
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
                 *         &lt;element name="TotLoansRepaybleOnDemand">
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
                    "fromBanks",
                    "frmNonBanking",
                    "othFinanceInst",
                    "others",
                    "totLoansRepaybleOnDemand"
                })
                public static class LoansRepaybleOnDemand {

                    @XmlElement(name = "FromBanks", required = true, defaultValue = "0")
                    protected BigInteger fromBanks;
                    @XmlElement(name = "FrmNonBanking", required = true, defaultValue = "0")
                    protected BigInteger frmNonBanking;
                    @XmlElement(name = "OthFinanceInst", required = true, defaultValue = "0")
                    protected BigInteger othFinanceInst;
                    @XmlElement(name = "Others", required = true, defaultValue = "0")
                    protected BigInteger others;
                    @XmlElement(name = "TotLoansRepaybleOnDemand", required = true, defaultValue = "0")
                    protected BigInteger totLoansRepaybleOnDemand;

                    /**
                     * Gets the value of the fromBanks property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getFromBanks() {
                        return fromBanks;
                    }

                    /**
                     * Sets the value of the fromBanks property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setFromBanks(BigInteger value) {
                        this.fromBanks = value;
                    }

                    /**
                     * Gets the value of the frmNonBanking property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getFrmNonBanking() {
                        return frmNonBanking;
                    }

                    /**
                     * Sets the value of the frmNonBanking property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setFrmNonBanking(BigInteger value) {
                        this.frmNonBanking = value;
                    }

                    /**
                     * Gets the value of the othFinanceInst property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getOthFinanceInst() {
                        return othFinanceInst;
                    }

                    /**
                     * Sets the value of the othFinanceInst property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setOthFinanceInst(BigInteger value) {
                        this.othFinanceInst = value;
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
                     * Gets the value of the totLoansRepaybleOnDemand property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotLoansRepaybleOnDemand() {
                        return totLoansRepaybleOnDemand;
                    }

                    /**
                     * Sets the value of the totLoansRepaybleOnDemand property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotLoansRepaybleOnDemand(BigInteger value) {
                        this.totLoansRepaybleOnDemand = value;
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
             *         &lt;element name="OSMoreThanOneYr">
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
             *         &lt;element name="TotalTradePayables">
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
                "osMoreThanOneYr",
                "others",
                "totalTradePayables"
            })
            public static class TradePayables {

                @XmlElement(name = "OSMoreThanOneYr", required = true, defaultValue = "0")
                protected BigInteger osMoreThanOneYr;
                @XmlElement(name = "Others", required = true, defaultValue = "0")
                protected BigInteger others;
                @XmlElement(name = "TotalTradePayables", required = true, defaultValue = "0")
                protected BigInteger totalTradePayables;

                /**
                 * Gets the value of the osMoreThanOneYr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOSMoreThanOneYr() {
                    return osMoreThanOneYr;
                }

                /**
                 * Sets the value of the osMoreThanOneYr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOSMoreThanOneYr(BigInteger value) {
                    this.osMoreThanOneYr = value;
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
                 * Gets the value of the totalTradePayables property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotalTradePayables() {
                    return totalTradePayables;
                }

                /**
                 * Sets the value of the totalTradePayables property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotalTradePayables(BigInteger value) {
                    this.totalTradePayables = value;
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
         *         &lt;element name="LongTermBorrowings">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="BondsDebentures">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="ForeignCurrency">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="Rupee">
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
         *                   &lt;element name="TermLoans">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="ForeignCurrency">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                   &lt;totalDigits value="14"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="RupeeLoans">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="FromBanks">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                                             &lt;totalDigits value="14"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="FromOthers">
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
         *                             &lt;element name="TotalTermLoans">
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
         *                   &lt;element name="DeferredPymtLiabilities">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="DepositsFrmRelatedParties">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OtherDeposits">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="LoansAndAdv">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OthersLoanAdv">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="LongTermMaturities">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotalLTBorrowings">
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
         *         &lt;element name="NetDefferedTaxLiability">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="OthLongTermLiablities">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="TradePayables">
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
         *                   &lt;element name="TotalOthLtLiabilities">
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
         *         &lt;element name="LongTermProvisions">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="ProvEmpBenefits">
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
         *         &lt;element name="TotalNonCurrLiabilites">
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
            "longTermBorrowings",
            "netDefferedTaxLiability",
            "othLongTermLiablities",
            "longTermProvisions",
            "totalNonCurrLiabilites"
        })
        public static class NonCurrLiabilities {

            @XmlElement(name = "LongTermBorrowings", required = true)
            protected PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings longTermBorrowings;
            @XmlElement(name = "NetDefferedTaxLiability", required = true, defaultValue = "0")
            protected BigInteger netDefferedTaxLiability;
            @XmlElement(name = "OthLongTermLiablities", required = true)
            protected PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.OthLongTermLiablities othLongTermLiablities;
            @XmlElement(name = "LongTermProvisions", required = true)
            protected PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermProvisions longTermProvisions;
            @XmlElement(name = "TotalNonCurrLiabilites", required = true, defaultValue = "0")
            protected BigInteger totalNonCurrLiabilites;

            /**
             * Gets the value of the longTermBorrowings property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings }
             *     
             */
            public PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings getLongTermBorrowings() {
                return longTermBorrowings;
            }

            /**
             * Sets the value of the longTermBorrowings property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings }
             *     
             */
            public void setLongTermBorrowings(PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings value) {
                this.longTermBorrowings = value;
            }

            /**
             * Gets the value of the netDefferedTaxLiability property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getNetDefferedTaxLiability() {
                return netDefferedTaxLiability;
            }

            /**
             * Sets the value of the netDefferedTaxLiability property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setNetDefferedTaxLiability(BigInteger value) {
                this.netDefferedTaxLiability = value;
            }

            /**
             * Gets the value of the othLongTermLiablities property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.OthLongTermLiablities }
             *     
             */
            public PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.OthLongTermLiablities getOthLongTermLiablities() {
                return othLongTermLiablities;
            }

            /**
             * Sets the value of the othLongTermLiablities property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.OthLongTermLiablities }
             *     
             */
            public void setOthLongTermLiablities(PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.OthLongTermLiablities value) {
                this.othLongTermLiablities = value;
            }

            /**
             * Gets the value of the longTermProvisions property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermProvisions }
             *     
             */
            public PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermProvisions getLongTermProvisions() {
                return longTermProvisions;
            }

            /**
             * Sets the value of the longTermProvisions property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermProvisions }
             *     
             */
            public void setLongTermProvisions(PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermProvisions value) {
                this.longTermProvisions = value;
            }

            /**
             * Gets the value of the totalNonCurrLiabilites property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getTotalNonCurrLiabilites() {
                return totalNonCurrLiabilites;
            }

            /**
             * Sets the value of the totalNonCurrLiabilites property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTotalNonCurrLiabilites(BigInteger value) {
                this.totalNonCurrLiabilites = value;
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
             *         &lt;element name="BondsDebentures">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="ForeignCurrency">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="Rupee">
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
             *         &lt;element name="TermLoans">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="ForeignCurrency">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                         &lt;totalDigits value="14"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="RupeeLoans">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="FromBanks">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *                                   &lt;totalDigits value="14"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="FromOthers">
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
             *                   &lt;element name="TotalTermLoans">
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
             *         &lt;element name="DeferredPymtLiabilities">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="DepositsFrmRelatedParties">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OtherDeposits">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="LoansAndAdv">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OthersLoanAdv">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="LongTermMaturities">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotalLTBorrowings">
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
                "bondsDebentures",
                "termLoans",
                "deferredPymtLiabilities",
                "depositsFrmRelatedParties",
                "otherDeposits",
                "loansAndAdv",
                "othersLoanAdv",
                "longTermMaturities",
                "totalLTBorrowings"
            })
            public static class LongTermBorrowings {

                @XmlElement(name = "BondsDebentures", required = true)
                protected PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.BondsDebentures bondsDebentures;
                @XmlElement(name = "TermLoans", required = true)
                protected PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.TermLoans termLoans;
                @XmlElement(name = "DeferredPymtLiabilities", required = true, defaultValue = "0")
                protected BigInteger deferredPymtLiabilities;
                @XmlElement(name = "DepositsFrmRelatedParties", required = true, defaultValue = "0")
                protected BigInteger depositsFrmRelatedParties;
                @XmlElement(name = "OtherDeposits", required = true, defaultValue = "0")
                protected BigInteger otherDeposits;
                @XmlElement(name = "LoansAndAdv", required = true, defaultValue = "0")
                protected BigInteger loansAndAdv;
                @XmlElement(name = "OthersLoanAdv", required = true, defaultValue = "0")
                protected BigInteger othersLoanAdv;
                @XmlElement(name = "LongTermMaturities", required = true, defaultValue = "0")
                protected BigInteger longTermMaturities;
                @XmlElement(name = "TotalLTBorrowings", required = true, defaultValue = "0")
                protected BigInteger totalLTBorrowings;

                /**
                 * Gets the value of the bondsDebentures property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.BondsDebentures }
                 *     
                 */
                public PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.BondsDebentures getBondsDebentures() {
                    return bondsDebentures;
                }

                /**
                 * Sets the value of the bondsDebentures property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.BondsDebentures }
                 *     
                 */
                public void setBondsDebentures(PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.BondsDebentures value) {
                    this.bondsDebentures = value;
                }

                /**
                 * Gets the value of the termLoans property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.TermLoans }
                 *     
                 */
                public PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.TermLoans getTermLoans() {
                    return termLoans;
                }

                /**
                 * Sets the value of the termLoans property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.TermLoans }
                 *     
                 */
                public void setTermLoans(PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.TermLoans value) {
                    this.termLoans = value;
                }

                /**
                 * Gets the value of the deferredPymtLiabilities property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getDeferredPymtLiabilities() {
                    return deferredPymtLiabilities;
                }

                /**
                 * Sets the value of the deferredPymtLiabilities property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setDeferredPymtLiabilities(BigInteger value) {
                    this.deferredPymtLiabilities = value;
                }

                /**
                 * Gets the value of the depositsFrmRelatedParties property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getDepositsFrmRelatedParties() {
                    return depositsFrmRelatedParties;
                }

                /**
                 * Sets the value of the depositsFrmRelatedParties property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setDepositsFrmRelatedParties(BigInteger value) {
                    this.depositsFrmRelatedParties = value;
                }

                /**
                 * Gets the value of the otherDeposits property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOtherDeposits() {
                    return otherDeposits;
                }

                /**
                 * Sets the value of the otherDeposits property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOtherDeposits(BigInteger value) {
                    this.otherDeposits = value;
                }

                /**
                 * Gets the value of the loansAndAdv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getLoansAndAdv() {
                    return loansAndAdv;
                }

                /**
                 * Sets the value of the loansAndAdv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setLoansAndAdv(BigInteger value) {
                    this.loansAndAdv = value;
                }

                /**
                 * Gets the value of the othersLoanAdv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOthersLoanAdv() {
                    return othersLoanAdv;
                }

                /**
                 * Sets the value of the othersLoanAdv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOthersLoanAdv(BigInteger value) {
                    this.othersLoanAdv = value;
                }

                /**
                 * Gets the value of the longTermMaturities property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getLongTermMaturities() {
                    return longTermMaturities;
                }

                /**
                 * Sets the value of the longTermMaturities property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setLongTermMaturities(BigInteger value) {
                    this.longTermMaturities = value;
                }

                /**
                 * Gets the value of the totalLTBorrowings property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotalLTBorrowings() {
                    return totalLTBorrowings;
                }

                /**
                 * Sets the value of the totalLTBorrowings property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotalLTBorrowings(BigInteger value) {
                    this.totalLTBorrowings = value;
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
                 *         &lt;element name="ForeignCurrency">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="Rupee">
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
                    "foreignCurrency",
                    "rupee",
                    "total"
                })
                public static class BondsDebentures {

                    @XmlElement(name = "ForeignCurrency", required = true, defaultValue = "0")
                    protected BigInteger foreignCurrency;
                    @XmlElement(name = "Rupee", required = true, defaultValue = "0")
                    protected BigInteger rupee;
                    @XmlElement(name = "Total", required = true, defaultValue = "0")
                    protected BigInteger total;

                    /**
                     * Gets the value of the foreignCurrency property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getForeignCurrency() {
                        return foreignCurrency;
                    }

                    /**
                     * Sets the value of the foreignCurrency property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setForeignCurrency(BigInteger value) {
                        this.foreignCurrency = value;
                    }

                    /**
                     * Gets the value of the rupee property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getRupee() {
                        return rupee;
                    }

                    /**
                     * Sets the value of the rupee property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setRupee(BigInteger value) {
                        this.rupee = value;
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
                 *         &lt;element name="ForeignCurrency">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *               &lt;totalDigits value="14"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="RupeeLoans">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="FromBanks">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                 *                         &lt;totalDigits value="14"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="FromOthers">
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
                 *         &lt;element name="TotalTermLoans">
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
                    "foreignCurrency",
                    "rupeeLoans",
                    "totalTermLoans"
                })
                public static class TermLoans {

                    @XmlElement(name = "ForeignCurrency", required = true, defaultValue = "0")
                    protected BigInteger foreignCurrency;
                    @XmlElement(name = "RupeeLoans", required = true)
                    protected PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.TermLoans.RupeeLoans rupeeLoans;
                    @XmlElement(name = "TotalTermLoans", required = true, defaultValue = "0")
                    protected BigInteger totalTermLoans;

                    /**
                     * Gets the value of the foreignCurrency property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getForeignCurrency() {
                        return foreignCurrency;
                    }

                    /**
                     * Sets the value of the foreignCurrency property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setForeignCurrency(BigInteger value) {
                        this.foreignCurrency = value;
                    }

                    /**
                     * Gets the value of the rupeeLoans property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.TermLoans.RupeeLoans }
                     *     
                     */
                    public PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.TermLoans.RupeeLoans getRupeeLoans() {
                        return rupeeLoans;
                    }

                    /**
                     * Sets the value of the rupeeLoans property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.TermLoans.RupeeLoans }
                     *     
                     */
                    public void setRupeeLoans(PARTABSFor6FrmAY13 .EquityAndLiablities.NonCurrLiabilities.LongTermBorrowings.TermLoans.RupeeLoans value) {
                        this.rupeeLoans = value;
                    }

                    /**
                     * Gets the value of the totalTermLoans property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getTotalTermLoans() {
                        return totalTermLoans;
                    }

                    /**
                     * Sets the value of the totalTermLoans property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setTotalTermLoans(BigInteger value) {
                        this.totalTermLoans = value;
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
                     *         &lt;element name="FromBanks">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
                     *               &lt;totalDigits value="14"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="FromOthers">
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
                        "fromBanks",
                        "fromOthers",
                        "total"
                    })
                    public static class RupeeLoans {

                        @XmlElement(name = "FromBanks", required = true, defaultValue = "0")
                        protected BigInteger fromBanks;
                        @XmlElement(name = "FromOthers", required = true, defaultValue = "0")
                        protected BigInteger fromOthers;
                        @XmlElement(name = "Total", required = true, defaultValue = "0")
                        protected BigInteger total;

                        /**
                         * Gets the value of the fromBanks property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BigInteger }
                         *     
                         */
                        public BigInteger getFromBanks() {
                            return fromBanks;
                        }

                        /**
                         * Sets the value of the fromBanks property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BigInteger }
                         *     
                         */
                        public void setFromBanks(BigInteger value) {
                            this.fromBanks = value;
                        }

                        /**
                         * Gets the value of the fromOthers property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BigInteger }
                         *     
                         */
                        public BigInteger getFromOthers() {
                            return fromOthers;
                        }

                        /**
                         * Sets the value of the fromOthers property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BigInteger }
                         *     
                         */
                        public void setFromOthers(BigInteger value) {
                            this.fromOthers = value;
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
             *         &lt;element name="ProvEmpBenefits">
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
                "provEmpBenefits",
                "others",
                "total"
            })
            public static class LongTermProvisions {

                @XmlElement(name = "ProvEmpBenefits", required = true, defaultValue = "0")
                protected BigInteger provEmpBenefits;
                @XmlElement(name = "Others", required = true, defaultValue = "0")
                protected BigInteger others;
                @XmlElement(name = "Total", required = true, defaultValue = "0")
                protected BigInteger total;

                /**
                 * Gets the value of the provEmpBenefits property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getProvEmpBenefits() {
                    return provEmpBenefits;
                }

                /**
                 * Sets the value of the provEmpBenefits property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setProvEmpBenefits(BigInteger value) {
                    this.provEmpBenefits = value;
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
             *         &lt;element name="TradePayables">
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
             *         &lt;element name="TotalOthLtLiabilities">
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
                "tradePayables",
                "others",
                "totalOthLtLiabilities"
            })
            public static class OthLongTermLiablities {

                @XmlElement(name = "TradePayables", required = true, defaultValue = "0")
                protected BigInteger tradePayables;
                @XmlElement(name = "Others", required = true, defaultValue = "0")
                protected BigInteger others;
                @XmlElement(name = "TotalOthLtLiabilities", required = true, defaultValue = "0")
                protected BigInteger totalOthLtLiabilities;

                /**
                 * Gets the value of the tradePayables property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTradePayables() {
                    return tradePayables;
                }

                /**
                 * Sets the value of the tradePayables property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTradePayables(BigInteger value) {
                    this.tradePayables = value;
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
                 * Gets the value of the totalOthLtLiabilities property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotalOthLtLiabilities() {
                    return totalOthLtLiabilities;
                }

                /**
                 * Sets the value of the totalOthLtLiabilities property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotalOthLtLiabilities(BigInteger value) {
                    this.totalOthLtLiabilities = value;
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
         *         &lt;element name="PendingLtOneYr">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="PendingMtOneYr">
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
            "pendingLtOneYr",
            "pendingMtOneYr",
            "total"
        })
        public static class ShareAppMoneyAllot {

            @XmlElement(name = "PendingLtOneYr", required = true, defaultValue = "0")
            protected BigInteger pendingLtOneYr;
            @XmlElement(name = "PendingMtOneYr", required = true, defaultValue = "0")
            protected BigInteger pendingMtOneYr;
            @XmlElement(name = "Total", required = true, defaultValue = "0")
            protected BigInteger total;

            /**
             * Gets the value of the pendingLtOneYr property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getPendingLtOneYr() {
                return pendingLtOneYr;
            }

            /**
             * Sets the value of the pendingLtOneYr property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setPendingLtOneYr(BigInteger value) {
                this.pendingLtOneYr = value;
            }

            /**
             * Gets the value of the pendingMtOneYr property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getPendingMtOneYr() {
                return pendingMtOneYr;
            }

            /**
             * Sets the value of the pendingMtOneYr property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setPendingMtOneYr(BigInteger value) {
                this.pendingMtOneYr = value;
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
         *         &lt;element name="ShareCapital">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Authorised">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="IssuedSubsPaidUp">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="SubscribedNotFullyPaid">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotShareCapital">
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
         *         &lt;element name="ResrNSurp">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="CapResr">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="CapRedempResr">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="SecurPremResr">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="DebunRedResr">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="RevResr">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="ShareOptOSAmount">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OtherResrvDtls" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Nature">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                   &lt;maxLength value="50"/>
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
         *                   &lt;element name="OtherResrvTotal">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="PLAccount">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *                         &lt;totalDigits value="14"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="TotResrNSurp">
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
         *         &lt;element name="MoneyRecvdAgainstShares">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="TotShareHolderFund">
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
            "shareCapital",
            "resrNSurp",
            "moneyRecvdAgainstShares",
            "totShareHolderFund"
        })
        public static class ShareHolderFund {

            @XmlElement(name = "ShareCapital", required = true)
            protected PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ShareCapital shareCapital;
            @XmlElement(name = "ResrNSurp", required = true)
            protected PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ResrNSurp resrNSurp;
            @XmlElement(name = "MoneyRecvdAgainstShares", required = true, defaultValue = "0")
            protected BigInteger moneyRecvdAgainstShares;
            @XmlElement(name = "TotShareHolderFund", defaultValue = "0")
            protected long totShareHolderFund;

            /**
             * Gets the value of the shareCapital property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ShareCapital }
             *     
             */
            public PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ShareCapital getShareCapital() {
                return shareCapital;
            }

            /**
             * Sets the value of the shareCapital property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ShareCapital }
             *     
             */
            public void setShareCapital(PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ShareCapital value) {
                this.shareCapital = value;
            }

            /**
             * Gets the value of the resrNSurp property.
             * 
             * @return
             *     possible object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ResrNSurp }
             *     
             */
            public PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ResrNSurp getResrNSurp() {
                return resrNSurp;
            }

            /**
             * Sets the value of the resrNSurp property.
             * 
             * @param value
             *     allowed object is
             *     {@link PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ResrNSurp }
             *     
             */
            public void setResrNSurp(PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ResrNSurp value) {
                this.resrNSurp = value;
            }

            /**
             * Gets the value of the moneyRecvdAgainstShares property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMoneyRecvdAgainstShares() {
                return moneyRecvdAgainstShares;
            }

            /**
             * Sets the value of the moneyRecvdAgainstShares property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMoneyRecvdAgainstShares(BigInteger value) {
                this.moneyRecvdAgainstShares = value;
            }

            /**
             * Gets the value of the totShareHolderFund property.
             * 
             */
            public long getTotShareHolderFund() {
                return totShareHolderFund;
            }

            /**
             * Sets the value of the totShareHolderFund property.
             * 
             */
            public void setTotShareHolderFund(long value) {
                this.totShareHolderFund = value;
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
             *         &lt;element name="CapResr">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="CapRedempResr">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="SecurPremResr">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="DebunRedResr">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="RevResr">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="ShareOptOSAmount">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OtherResrvDtls" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Nature">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;maxLength value="50"/>
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
             *         &lt;element name="OtherResrvTotal">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="PLAccount">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotResrNSurp">
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
                "capResr",
                "capRedempResr",
                "securPremResr",
                "debunRedResr",
                "revResr",
                "shareOptOSAmount",
                "otherResrvDtls",
                "otherResrvTotal",
                "plAccount",
                "totResrNSurp"
            })
            public static class ResrNSurp {

                @XmlElement(name = "CapResr", required = true, defaultValue = "0")
                protected BigInteger capResr;
                @XmlElement(name = "CapRedempResr", required = true, defaultValue = "0")
                protected BigInteger capRedempResr;
                @XmlElement(name = "SecurPremResr", required = true, defaultValue = "0")
                protected BigInteger securPremResr;
                @XmlElement(name = "DebunRedResr", required = true, defaultValue = "0")
                protected BigInteger debunRedResr;
                @XmlElement(name = "RevResr", required = true, defaultValue = "0")
                protected BigInteger revResr;
                @XmlElement(name = "ShareOptOSAmount", required = true, defaultValue = "0")
                protected BigInteger shareOptOSAmount;
                @XmlElement(name = "OtherResrvDtls")
                protected List<PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ResrNSurp.OtherResrvDtls> otherResrvDtls;
                @XmlElement(name = "OtherResrvTotal", required = true, defaultValue = "0")
                protected BigInteger otherResrvTotal;
                @XmlElement(name = "PLAccount", defaultValue = "0")
                protected long plAccount;
                @XmlElement(name = "TotResrNSurp", defaultValue = "0")
                protected long totResrNSurp;

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
                 * Gets the value of the capRedempResr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getCapRedempResr() {
                    return capRedempResr;
                }

                /**
                 * Sets the value of the capRedempResr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setCapRedempResr(BigInteger value) {
                    this.capRedempResr = value;
                }

                /**
                 * Gets the value of the securPremResr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getSecurPremResr() {
                    return securPremResr;
                }

                /**
                 * Sets the value of the securPremResr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setSecurPremResr(BigInteger value) {
                    this.securPremResr = value;
                }

                /**
                 * Gets the value of the debunRedResr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getDebunRedResr() {
                    return debunRedResr;
                }

                /**
                 * Sets the value of the debunRedResr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setDebunRedResr(BigInteger value) {
                    this.debunRedResr = value;
                }

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
                 * Gets the value of the shareOptOSAmount property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getShareOptOSAmount() {
                    return shareOptOSAmount;
                }

                /**
                 * Sets the value of the shareOptOSAmount property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setShareOptOSAmount(BigInteger value) {
                    this.shareOptOSAmount = value;
                }

                /**
                 * Gets the value of the otherResrvDtls property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the otherResrvDtls property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getOtherResrvDtls().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ResrNSurp.OtherResrvDtls }
                 * 
                 * 
                 */
                public List<PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ResrNSurp.OtherResrvDtls> getOtherResrvDtls() {
                    if (otherResrvDtls == null) {
                        otherResrvDtls = new ArrayList<PARTABSFor6FrmAY13 .EquityAndLiablities.ShareHolderFund.ResrNSurp.OtherResrvDtls>();
                    }
                    return this.otherResrvDtls;
                }

                /**
                 * Gets the value of the otherResrvTotal property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOtherResrvTotal() {
                    return otherResrvTotal;
                }

                /**
                 * Sets the value of the otherResrvTotal property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOtherResrvTotal(BigInteger value) {
                    this.otherResrvTotal = value;
                }

                /**
                 * Gets the value of the plAccount property.
                 * 
                 */
                public long getPLAccount() {
                    return plAccount;
                }

                /**
                 * Sets the value of the plAccount property.
                 * 
                 */
                public void setPLAccount(long value) {
                    this.plAccount = value;
                }

                /**
                 * Gets the value of the totResrNSurp property.
                 * 
                 */
                public long getTotResrNSurp() {
                    return totResrNSurp;
                }

                /**
                 * Sets the value of the totResrNSurp property.
                 * 
                 */
                public void setTotResrNSurp(long value) {
                    this.totResrNSurp = value;
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
                 *         &lt;element name="Nature">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;maxLength value="50"/>
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
                    "nature",
                    "amount"
                })
                public static class OtherResrvDtls {

                    @XmlElement(name = "Nature", required = true, defaultValue = "0")
                    protected String nature;
                    @XmlElement(name = "Amount", required = true, defaultValue = "0")
                    protected BigInteger amount;

                    /**
                     * Gets the value of the nature property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNature() {
                        return nature;
                    }

                    /**
                     * Sets the value of the nature property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNature(String value) {
                        this.nature = value;
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
             *         &lt;element name="Authorised">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="IssuedSubsPaidUp">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="SubscribedNotFullyPaid">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
             *               &lt;totalDigits value="14"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="TotShareCapital">
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
                "authorised",
                "issuedSubsPaidUp",
                "subscribedNotFullyPaid",
                "totShareCapital"
            })
            public static class ShareCapital {

                @XmlElement(name = "Authorised", required = true, defaultValue = "0")
                protected BigInteger authorised;
                @XmlElement(name = "IssuedSubsPaidUp", required = true, defaultValue = "0")
                protected BigInteger issuedSubsPaidUp;
                @XmlElement(name = "SubscribedNotFullyPaid", required = true, defaultValue = "0")
                protected BigInteger subscribedNotFullyPaid;
                @XmlElement(name = "TotShareCapital", required = true, defaultValue = "0")
                protected BigInteger totShareCapital;

                /**
                 * Gets the value of the authorised property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getAuthorised() {
                    return authorised;
                }

                /**
                 * Sets the value of the authorised property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setAuthorised(BigInteger value) {
                    this.authorised = value;
                }

                /**
                 * Gets the value of the issuedSubsPaidUp property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getIssuedSubsPaidUp() {
                    return issuedSubsPaidUp;
                }

                /**
                 * Sets the value of the issuedSubsPaidUp property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setIssuedSubsPaidUp(BigInteger value) {
                    this.issuedSubsPaidUp = value;
                }

                /**
                 * Gets the value of the subscribedNotFullyPaid property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getSubscribedNotFullyPaid() {
                    return subscribedNotFullyPaid;
                }

                /**
                 * Sets the value of the subscribedNotFullyPaid property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setSubscribedNotFullyPaid(BigInteger value) {
                    this.subscribedNotFullyPaid = value;
                }

                /**
                 * Gets the value of the totShareCapital property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTotShareCapital() {
                    return totShareCapital;
                }

                /**
                 * Sets the value of the totShareCapital property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTotShareCapital(BigInteger value) {
                    this.totShareCapital = value;
                }

            }

        }

    }

}
