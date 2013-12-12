
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
 *         &lt;element name="OpeningStockDtls">
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
 *                   &lt;element name="OpeningStock">
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
 *         &lt;element name="Purchases">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DutyTaxPay">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}ExciseCustomsVAT"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Freight">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ConsumptionOfStores">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PowerFuel">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RentExpdr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RepairsBldg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RepairMach">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EmployeeComp">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SalsWages">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Bonus">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="MedExpReimb">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LeaveEncash">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LeaveTravelBenft">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ContToSuperAnnFund">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ContToPF">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ContToGratFund">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ContToOthFund">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OthEmpBenftExpdr">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TotEmployeeComp">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AnyCompPaidToNonRes">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="Y|N"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AmtPaidToNonRes" minOccurs="0">
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
 *         &lt;element name="Insurances">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MedInsur">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LifeInsur">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="KeyManInsur">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OthInsur">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TotInsurances">
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
 *         &lt;element name="StaffWelfareExp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Entertainment">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Hospitality">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Conference">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SalePromoExp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Advertisement">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CommissionExpdrDtls">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NonResOtherCompany">
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
 *         &lt;element name="RoyalityDtls">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NonResOtherCompany">
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
 *         &lt;element name="ProfessionalConstDtls">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NonResOtherCompany">
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
 *         &lt;element name="HotelBoardLodge">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TravelExp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ForeignTravelExp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ConveyanceExp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TelephoneExp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GuestHouseExp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ClubExp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FestivalCelebExp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Scholarship">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Gift">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Donation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RatesTaxesPays">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}ExciseCustomsVAT"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AuditFee">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OtherExpensesDtls" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ExpenseNature">
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
 *         &lt;element name="OtherExpenses">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BadDebtDtls">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BadDebtAmtDtls" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PAN">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
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
 *                   &lt;element name="OthersWherePANNotAvlble">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OthersAmtLt1Lakh">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *                         &lt;totalDigits value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="BadDebt">
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
 *         &lt;element name="ProvForBadDoubtDebt">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OthProvisionsExpdr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PBIDTA">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InterestExpdrtDtls">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NonResOtherCompany">
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
 *                   &lt;element name="InterestExpdr">
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
 *         &lt;element name="DepreciationAmort">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PBT">
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
    "openingStockDtls",
    "purchases",
    "dutyTaxPay",
    "freight",
    "consumptionOfStores",
    "powerFuel",
    "rentExpdr",
    "repairsBldg",
    "repairMach",
    "employeeComp",
    "insurances",
    "staffWelfareExp",
    "entertainment",
    "hospitality",
    "conference",
    "salePromoExp",
    "advertisement",
    "commissionExpdrDtls",
    "royalityDtls",
    "professionalConstDtls",
    "hotelBoardLodge",
    "travelExp",
    "foreignTravelExp",
    "conveyanceExp",
    "telephoneExp",
    "guestHouseExp",
    "clubExp",
    "festivalCelebExp",
    "scholarship",
    "gift",
    "donation",
    "ratesTaxesPays",
    "auditFee",
    "otherExpensesDtls",
    "otherExpenses",
    "badDebtDtls",
    "provForBadDoubtDebt",
    "othProvisionsExpdr",
    "pbidta",
    "interestExpdrtDtls",
    "depreciationAmort",
    "pbt"
})
@XmlRootElement(name = "DebitPlAcnt")
public class DebitPlAcnt {

    @XmlElement(name = "OpeningStockDtls", required = true)
    protected DebitPlAcnt.OpeningStockDtls openingStockDtls;
    @XmlElement(name = "Purchases", required = true, defaultValue = "0")
    protected BigInteger purchases;
    @XmlElement(name = "DutyTaxPay", required = true)
    protected DebitPlAcnt.DutyTaxPay dutyTaxPay;
    @XmlElement(name = "Freight", required = true, defaultValue = "0")
    protected BigInteger freight;
    @XmlElement(name = "ConsumptionOfStores", required = true, defaultValue = "0")
    protected BigInteger consumptionOfStores;
    @XmlElement(name = "PowerFuel", required = true, defaultValue = "0")
    protected BigInteger powerFuel;
    @XmlElement(name = "RentExpdr", required = true, defaultValue = "0")
    protected BigInteger rentExpdr;
    @XmlElement(name = "RepairsBldg", required = true, defaultValue = "0")
    protected BigInteger repairsBldg;
    @XmlElement(name = "RepairMach", required = true, defaultValue = "0")
    protected BigInteger repairMach;
    @XmlElement(name = "EmployeeComp", required = true)
    protected DebitPlAcnt.EmployeeComp employeeComp;
    @XmlElement(name = "Insurances", required = true)
    protected DebitPlAcnt.Insurances insurances;
    @XmlElement(name = "StaffWelfareExp", required = true, defaultValue = "0")
    protected BigInteger staffWelfareExp;
    @XmlElement(name = "Entertainment", required = true, defaultValue = "0")
    protected BigInteger entertainment;
    @XmlElement(name = "Hospitality", required = true, defaultValue = "0")
    protected BigInteger hospitality;
    @XmlElement(name = "Conference", required = true, defaultValue = "0")
    protected BigInteger conference;
    @XmlElement(name = "SalePromoExp", required = true, defaultValue = "0")
    protected BigInteger salePromoExp;
    @XmlElement(name = "Advertisement", required = true, defaultValue = "0")
    protected BigInteger advertisement;
    @XmlElement(name = "CommissionExpdrDtls", required = true)
    protected DebitPlAcnt.CommissionExpdrDtls commissionExpdrDtls;
    @XmlElement(name = "RoyalityDtls", required = true)
    protected DebitPlAcnt.RoyalityDtls royalityDtls;
    @XmlElement(name = "ProfessionalConstDtls", required = true)
    protected DebitPlAcnt.ProfessionalConstDtls professionalConstDtls;
    @XmlElement(name = "HotelBoardLodge", required = true, defaultValue = "0")
    protected BigInteger hotelBoardLodge;
    @XmlElement(name = "TravelExp", required = true, defaultValue = "0")
    protected BigInteger travelExp;
    @XmlElement(name = "ForeignTravelExp", required = true, defaultValue = "0")
    protected BigInteger foreignTravelExp;
    @XmlElement(name = "ConveyanceExp", required = true, defaultValue = "0")
    protected BigInteger conveyanceExp;
    @XmlElement(name = "TelephoneExp", required = true, defaultValue = "0")
    protected BigInteger telephoneExp;
    @XmlElement(name = "GuestHouseExp", required = true, defaultValue = "0")
    protected BigInteger guestHouseExp;
    @XmlElement(name = "ClubExp", required = true, defaultValue = "0")
    protected BigInteger clubExp;
    @XmlElement(name = "FestivalCelebExp", required = true, defaultValue = "0")
    protected BigInteger festivalCelebExp;
    @XmlElement(name = "Scholarship", required = true, defaultValue = "0")
    protected BigInteger scholarship;
    @XmlElement(name = "Gift", required = true, defaultValue = "0")
    protected BigInteger gift;
    @XmlElement(name = "Donation", required = true, defaultValue = "0")
    protected BigInteger donation;
    @XmlElement(name = "RatesTaxesPays", required = true)
    protected DebitPlAcnt.RatesTaxesPays ratesTaxesPays;
    @XmlElement(name = "AuditFee", required = true, defaultValue = "0")
    protected BigInteger auditFee;
    @XmlElement(name = "OtherExpensesDtls")
    protected List<DebitPlAcnt.OtherExpensesDtls> otherExpensesDtls;
    @XmlElement(name = "OtherExpenses", required = true, defaultValue = "0")
    protected BigInteger otherExpenses;
    @XmlElement(name = "BadDebtDtls", required = true)
    protected DebitPlAcnt.BadDebtDtls badDebtDtls;
    @XmlElement(name = "ProvForBadDoubtDebt", defaultValue = "0")
    protected long provForBadDoubtDebt;
    @XmlElement(name = "OthProvisionsExpdr", defaultValue = "0")
    protected long othProvisionsExpdr;
    @XmlElement(name = "PBIDTA", defaultValue = "0")
    protected long pbidta;
    @XmlElement(name = "InterestExpdrtDtls", required = true)
    protected DebitPlAcnt.InterestExpdrtDtls interestExpdrtDtls;
    @XmlElement(name = "DepreciationAmort", required = true, defaultValue = "0")
    protected BigInteger depreciationAmort;
    @XmlElement(name = "PBT", defaultValue = "0")
    protected long pbt;

    /**
     * Gets the value of the openingStockDtls property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt.OpeningStockDtls }
     *     
     */
    public DebitPlAcnt.OpeningStockDtls getOpeningStockDtls() {
        return openingStockDtls;
    }

    /**
     * Sets the value of the openingStockDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt.OpeningStockDtls }
     *     
     */
    public void setOpeningStockDtls(DebitPlAcnt.OpeningStockDtls value) {
        this.openingStockDtls = value;
    }

    /**
     * Gets the value of the purchases property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPurchases() {
        return purchases;
    }

    /**
     * Sets the value of the purchases property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPurchases(BigInteger value) {
        this.purchases = value;
    }

    /**
     * Gets the value of the dutyTaxPay property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt.DutyTaxPay }
     *     
     */
    public DebitPlAcnt.DutyTaxPay getDutyTaxPay() {
        return dutyTaxPay;
    }

    /**
     * Sets the value of the dutyTaxPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt.DutyTaxPay }
     *     
     */
    public void setDutyTaxPay(DebitPlAcnt.DutyTaxPay value) {
        this.dutyTaxPay = value;
    }

    /**
     * Gets the value of the freight property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFreight() {
        return freight;
    }

    /**
     * Sets the value of the freight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFreight(BigInteger value) {
        this.freight = value;
    }

    /**
     * Gets the value of the consumptionOfStores property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getConsumptionOfStores() {
        return consumptionOfStores;
    }

    /**
     * Sets the value of the consumptionOfStores property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setConsumptionOfStores(BigInteger value) {
        this.consumptionOfStores = value;
    }

    /**
     * Gets the value of the powerFuel property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPowerFuel() {
        return powerFuel;
    }

    /**
     * Sets the value of the powerFuel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPowerFuel(BigInteger value) {
        this.powerFuel = value;
    }

    /**
     * Gets the value of the rentExpdr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRentExpdr() {
        return rentExpdr;
    }

    /**
     * Sets the value of the rentExpdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRentExpdr(BigInteger value) {
        this.rentExpdr = value;
    }

    /**
     * Gets the value of the repairsBldg property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRepairsBldg() {
        return repairsBldg;
    }

    /**
     * Sets the value of the repairsBldg property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRepairsBldg(BigInteger value) {
        this.repairsBldg = value;
    }

    /**
     * Gets the value of the repairMach property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRepairMach() {
        return repairMach;
    }

    /**
     * Sets the value of the repairMach property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRepairMach(BigInteger value) {
        this.repairMach = value;
    }

    /**
     * Gets the value of the employeeComp property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt.EmployeeComp }
     *     
     */
    public DebitPlAcnt.EmployeeComp getEmployeeComp() {
        return employeeComp;
    }

    /**
     * Sets the value of the employeeComp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt.EmployeeComp }
     *     
     */
    public void setEmployeeComp(DebitPlAcnt.EmployeeComp value) {
        this.employeeComp = value;
    }

    /**
     * Gets the value of the insurances property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt.Insurances }
     *     
     */
    public DebitPlAcnt.Insurances getInsurances() {
        return insurances;
    }

    /**
     * Sets the value of the insurances property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt.Insurances }
     *     
     */
    public void setInsurances(DebitPlAcnt.Insurances value) {
        this.insurances = value;
    }

    /**
     * Gets the value of the staffWelfareExp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStaffWelfareExp() {
        return staffWelfareExp;
    }

    /**
     * Sets the value of the staffWelfareExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStaffWelfareExp(BigInteger value) {
        this.staffWelfareExp = value;
    }

    /**
     * Gets the value of the entertainment property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEntertainment() {
        return entertainment;
    }

    /**
     * Sets the value of the entertainment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEntertainment(BigInteger value) {
        this.entertainment = value;
    }

    /**
     * Gets the value of the hospitality property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHospitality() {
        return hospitality;
    }

    /**
     * Sets the value of the hospitality property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHospitality(BigInteger value) {
        this.hospitality = value;
    }

    /**
     * Gets the value of the conference property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getConference() {
        return conference;
    }

    /**
     * Sets the value of the conference property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setConference(BigInteger value) {
        this.conference = value;
    }

    /**
     * Gets the value of the salePromoExp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSalePromoExp() {
        return salePromoExp;
    }

    /**
     * Sets the value of the salePromoExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSalePromoExp(BigInteger value) {
        this.salePromoExp = value;
    }

    /**
     * Gets the value of the advertisement property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAdvertisement() {
        return advertisement;
    }

    /**
     * Sets the value of the advertisement property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAdvertisement(BigInteger value) {
        this.advertisement = value;
    }

    /**
     * Gets the value of the commissionExpdrDtls property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt.CommissionExpdrDtls }
     *     
     */
    public DebitPlAcnt.CommissionExpdrDtls getCommissionExpdrDtls() {
        return commissionExpdrDtls;
    }

    /**
     * Sets the value of the commissionExpdrDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt.CommissionExpdrDtls }
     *     
     */
    public void setCommissionExpdrDtls(DebitPlAcnt.CommissionExpdrDtls value) {
        this.commissionExpdrDtls = value;
    }

    /**
     * Gets the value of the royalityDtls property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt.RoyalityDtls }
     *     
     */
    public DebitPlAcnt.RoyalityDtls getRoyalityDtls() {
        return royalityDtls;
    }

    /**
     * Sets the value of the royalityDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt.RoyalityDtls }
     *     
     */
    public void setRoyalityDtls(DebitPlAcnt.RoyalityDtls value) {
        this.royalityDtls = value;
    }

    /**
     * Gets the value of the professionalConstDtls property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt.ProfessionalConstDtls }
     *     
     */
    public DebitPlAcnt.ProfessionalConstDtls getProfessionalConstDtls() {
        return professionalConstDtls;
    }

    /**
     * Sets the value of the professionalConstDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt.ProfessionalConstDtls }
     *     
     */
    public void setProfessionalConstDtls(DebitPlAcnt.ProfessionalConstDtls value) {
        this.professionalConstDtls = value;
    }

    /**
     * Gets the value of the hotelBoardLodge property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHotelBoardLodge() {
        return hotelBoardLodge;
    }

    /**
     * Sets the value of the hotelBoardLodge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHotelBoardLodge(BigInteger value) {
        this.hotelBoardLodge = value;
    }

    /**
     * Gets the value of the travelExp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTravelExp() {
        return travelExp;
    }

    /**
     * Sets the value of the travelExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTravelExp(BigInteger value) {
        this.travelExp = value;
    }

    /**
     * Gets the value of the foreignTravelExp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getForeignTravelExp() {
        return foreignTravelExp;
    }

    /**
     * Sets the value of the foreignTravelExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setForeignTravelExp(BigInteger value) {
        this.foreignTravelExp = value;
    }

    /**
     * Gets the value of the conveyanceExp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getConveyanceExp() {
        return conveyanceExp;
    }

    /**
     * Sets the value of the conveyanceExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setConveyanceExp(BigInteger value) {
        this.conveyanceExp = value;
    }

    /**
     * Gets the value of the telephoneExp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTelephoneExp() {
        return telephoneExp;
    }

    /**
     * Sets the value of the telephoneExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTelephoneExp(BigInteger value) {
        this.telephoneExp = value;
    }

    /**
     * Gets the value of the guestHouseExp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGuestHouseExp() {
        return guestHouseExp;
    }

    /**
     * Sets the value of the guestHouseExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGuestHouseExp(BigInteger value) {
        this.guestHouseExp = value;
    }

    /**
     * Gets the value of the clubExp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getClubExp() {
        return clubExp;
    }

    /**
     * Sets the value of the clubExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setClubExp(BigInteger value) {
        this.clubExp = value;
    }

    /**
     * Gets the value of the festivalCelebExp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFestivalCelebExp() {
        return festivalCelebExp;
    }

    /**
     * Sets the value of the festivalCelebExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFestivalCelebExp(BigInteger value) {
        this.festivalCelebExp = value;
    }

    /**
     * Gets the value of the scholarship property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getScholarship() {
        return scholarship;
    }

    /**
     * Sets the value of the scholarship property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setScholarship(BigInteger value) {
        this.scholarship = value;
    }

    /**
     * Gets the value of the gift property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGift() {
        return gift;
    }

    /**
     * Sets the value of the gift property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGift(BigInteger value) {
        this.gift = value;
    }

    /**
     * Gets the value of the donation property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDonation() {
        return donation;
    }

    /**
     * Sets the value of the donation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDonation(BigInteger value) {
        this.donation = value;
    }

    /**
     * Gets the value of the ratesTaxesPays property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt.RatesTaxesPays }
     *     
     */
    public DebitPlAcnt.RatesTaxesPays getRatesTaxesPays() {
        return ratesTaxesPays;
    }

    /**
     * Sets the value of the ratesTaxesPays property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt.RatesTaxesPays }
     *     
     */
    public void setRatesTaxesPays(DebitPlAcnt.RatesTaxesPays value) {
        this.ratesTaxesPays = value;
    }

    /**
     * Gets the value of the auditFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAuditFee() {
        return auditFee;
    }

    /**
     * Sets the value of the auditFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAuditFee(BigInteger value) {
        this.auditFee = value;
    }

    /**
     * Gets the value of the otherExpensesDtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherExpensesDtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherExpensesDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DebitPlAcnt.OtherExpensesDtls }
     * 
     * 
     */
    public List<DebitPlAcnt.OtherExpensesDtls> getOtherExpensesDtls() {
        if (otherExpensesDtls == null) {
            otherExpensesDtls = new ArrayList<DebitPlAcnt.OtherExpensesDtls>();
        }
        return this.otherExpensesDtls;
    }

    /**
     * Gets the value of the otherExpenses property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOtherExpenses() {
        return otherExpenses;
    }

    /**
     * Sets the value of the otherExpenses property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOtherExpenses(BigInteger value) {
        this.otherExpenses = value;
    }

    /**
     * Gets the value of the badDebtDtls property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt.BadDebtDtls }
     *     
     */
    public DebitPlAcnt.BadDebtDtls getBadDebtDtls() {
        return badDebtDtls;
    }

    /**
     * Sets the value of the badDebtDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt.BadDebtDtls }
     *     
     */
    public void setBadDebtDtls(DebitPlAcnt.BadDebtDtls value) {
        this.badDebtDtls = value;
    }

    /**
     * Gets the value of the provForBadDoubtDebt property.
     * 
     */
    public long getProvForBadDoubtDebt() {
        return provForBadDoubtDebt;
    }

    /**
     * Sets the value of the provForBadDoubtDebt property.
     * 
     */
    public void setProvForBadDoubtDebt(long value) {
        this.provForBadDoubtDebt = value;
    }

    /**
     * Gets the value of the othProvisionsExpdr property.
     * 
     */
    public long getOthProvisionsExpdr() {
        return othProvisionsExpdr;
    }

    /**
     * Sets the value of the othProvisionsExpdr property.
     * 
     */
    public void setOthProvisionsExpdr(long value) {
        this.othProvisionsExpdr = value;
    }

    /**
     * Gets the value of the pbidta property.
     * 
     */
    public long getPBIDTA() {
        return pbidta;
    }

    /**
     * Sets the value of the pbidta property.
     * 
     */
    public void setPBIDTA(long value) {
        this.pbidta = value;
    }

    /**
     * Gets the value of the interestExpdrtDtls property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPlAcnt.InterestExpdrtDtls }
     *     
     */
    public DebitPlAcnt.InterestExpdrtDtls getInterestExpdrtDtls() {
        return interestExpdrtDtls;
    }

    /**
     * Sets the value of the interestExpdrtDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPlAcnt.InterestExpdrtDtls }
     *     
     */
    public void setInterestExpdrtDtls(DebitPlAcnt.InterestExpdrtDtls value) {
        this.interestExpdrtDtls = value;
    }

    /**
     * Gets the value of the depreciationAmort property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDepreciationAmort() {
        return depreciationAmort;
    }

    /**
     * Sets the value of the depreciationAmort property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDepreciationAmort(BigInteger value) {
        this.depreciationAmort = value;
    }

    /**
     * Gets the value of the pbt property.
     * 
     */
    public long getPBT() {
        return pbt;
    }

    /**
     * Sets the value of the pbt property.
     * 
     */
    public void setPBT(long value) {
        this.pbt = value;
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
     *         &lt;element name="BadDebtAmtDtls" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PAN">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
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
     *         &lt;element name="OthersWherePANNotAvlble">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OthersAmtLt1Lakh">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="BadDebt">
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
        "badDebtAmtDtls",
        "othersWherePANNotAvlble",
        "othersAmtLt1Lakh",
        "badDebt"
    })
    public static class BadDebtDtls {

        @XmlElement(name = "BadDebtAmtDtls")
        protected List<DebitPlAcnt.BadDebtDtls.BadDebtAmtDtls> badDebtAmtDtls;
        @XmlElement(name = "OthersWherePANNotAvlble", required = true)
        protected BigInteger othersWherePANNotAvlble;
        @XmlElement(name = "OthersAmtLt1Lakh", required = true)
        protected BigInteger othersAmtLt1Lakh;
        @XmlElement(name = "BadDebt", required = true, defaultValue = "0")
        protected BigInteger badDebt;

        /**
         * Gets the value of the badDebtAmtDtls property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the badDebtAmtDtls property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBadDebtAmtDtls().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DebitPlAcnt.BadDebtDtls.BadDebtAmtDtls }
         * 
         * 
         */
        public List<DebitPlAcnt.BadDebtDtls.BadDebtAmtDtls> getBadDebtAmtDtls() {
            if (badDebtAmtDtls == null) {
                badDebtAmtDtls = new ArrayList<DebitPlAcnt.BadDebtDtls.BadDebtAmtDtls>();
            }
            return this.badDebtAmtDtls;
        }

        /**
         * Gets the value of the othersWherePANNotAvlble property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOthersWherePANNotAvlble() {
            return othersWherePANNotAvlble;
        }

        /**
         * Sets the value of the othersWherePANNotAvlble property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOthersWherePANNotAvlble(BigInteger value) {
            this.othersWherePANNotAvlble = value;
        }

        /**
         * Gets the value of the othersAmtLt1Lakh property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOthersAmtLt1Lakh() {
            return othersAmtLt1Lakh;
        }

        /**
         * Sets the value of the othersAmtLt1Lakh property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOthersAmtLt1Lakh(BigInteger value) {
            this.othersAmtLt1Lakh = value;
        }

        /**
         * Gets the value of the badDebt property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBadDebt() {
            return badDebt;
        }

        /**
         * Sets the value of the badDebt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBadDebt(BigInteger value) {
            this.badDebt = value;
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
         *         &lt;element name="PAN">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="[A-Z][A-Z][A-Z][A-Z][A-Z]\d\d\d\d[A-Z]"/>
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
            "pan",
            "amount"
        })
        public static class BadDebtAmtDtls {

            @XmlElement(name = "PAN", required = true)
            protected String pan;
            @XmlElement(name = "Amount", required = true, defaultValue = "0")
            protected BigInteger amount;

            /**
             * Gets the value of the pan property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPAN() {
                return pan;
            }

            /**
             * Sets the value of the pan property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPAN(String value) {
                this.pan = value;
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
     *         &lt;element name="NonResOtherCompany">
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
        "nonResOtherCompany",
        "others",
        "total"
    })
    public static class CommissionExpdrDtls {

        @XmlElement(name = "NonResOtherCompany", required = true, defaultValue = "0")
        protected BigInteger nonResOtherCompany;
        @XmlElement(name = "Others", required = true, defaultValue = "0")
        protected BigInteger others;
        @XmlElement(name = "Total", required = true, defaultValue = "0")
        protected BigInteger total;

        /**
         * Gets the value of the nonResOtherCompany property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNonResOtherCompany() {
            return nonResOtherCompany;
        }

        /**
         * Sets the value of the nonResOtherCompany property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNonResOtherCompany(BigInteger value) {
            this.nonResOtherCompany = value;
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
     *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}ExciseCustomsVAT"/>
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
        "exciseCustomsVAT"
    })
    public static class DutyTaxPay {

        @XmlElement(name = "ExciseCustomsVAT", required = true)
        protected ExciseCustomsVAT exciseCustomsVAT;

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
     *         &lt;element name="SalsWages">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Bonus">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="MedExpReimb">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LeaveEncash">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LeaveTravelBenft">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ContToSuperAnnFund">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ContToPF">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ContToGratFund">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ContToOthFund">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OthEmpBenftExpdr">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TotEmployeeComp">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AnyCompPaidToNonRes">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="Y|N"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AmtPaidToNonRes" minOccurs="0">
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
        "salsWages",
        "bonus",
        "medExpReimb",
        "leaveEncash",
        "leaveTravelBenft",
        "contToSuperAnnFund",
        "contToPF",
        "contToGratFund",
        "contToOthFund",
        "othEmpBenftExpdr",
        "totEmployeeComp",
        "anyCompPaidToNonRes",
        "amtPaidToNonRes"
    })
    public static class EmployeeComp {

        @XmlElement(name = "SalsWages", required = true, defaultValue = "0")
        protected BigInteger salsWages;
        @XmlElement(name = "Bonus", required = true, defaultValue = "0")
        protected BigInteger bonus;
        @XmlElement(name = "MedExpReimb", required = true, defaultValue = "0")
        protected BigInteger medExpReimb;
        @XmlElement(name = "LeaveEncash", required = true, defaultValue = "0")
        protected BigInteger leaveEncash;
        @XmlElement(name = "LeaveTravelBenft", required = true, defaultValue = "0")
        protected BigInteger leaveTravelBenft;
        @XmlElement(name = "ContToSuperAnnFund", required = true, defaultValue = "0")
        protected BigInteger contToSuperAnnFund;
        @XmlElement(name = "ContToPF", required = true, defaultValue = "0")
        protected BigInteger contToPF;
        @XmlElement(name = "ContToGratFund", required = true, defaultValue = "0")
        protected BigInteger contToGratFund;
        @XmlElement(name = "ContToOthFund", required = true, defaultValue = "0")
        protected BigInteger contToOthFund;
        @XmlElement(name = "OthEmpBenftExpdr", required = true, defaultValue = "0")
        protected BigInteger othEmpBenftExpdr;
        @XmlElement(name = "TotEmployeeComp", required = true, defaultValue = "0")
        protected BigInteger totEmployeeComp;
        @XmlElement(name = "AnyCompPaidToNonRes", required = true)
        protected String anyCompPaidToNonRes;
        @XmlElement(name = "AmtPaidToNonRes", defaultValue = "0")
        protected BigInteger amtPaidToNonRes;

        /**
         * Gets the value of the salsWages property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSalsWages() {
            return salsWages;
        }

        /**
         * Sets the value of the salsWages property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSalsWages(BigInteger value) {
            this.salsWages = value;
        }

        /**
         * Gets the value of the bonus property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBonus() {
            return bonus;
        }

        /**
         * Sets the value of the bonus property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBonus(BigInteger value) {
            this.bonus = value;
        }

        /**
         * Gets the value of the medExpReimb property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMedExpReimb() {
            return medExpReimb;
        }

        /**
         * Sets the value of the medExpReimb property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMedExpReimb(BigInteger value) {
            this.medExpReimb = value;
        }

        /**
         * Gets the value of the leaveEncash property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getLeaveEncash() {
            return leaveEncash;
        }

        /**
         * Sets the value of the leaveEncash property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setLeaveEncash(BigInteger value) {
            this.leaveEncash = value;
        }

        /**
         * Gets the value of the leaveTravelBenft property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getLeaveTravelBenft() {
            return leaveTravelBenft;
        }

        /**
         * Sets the value of the leaveTravelBenft property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setLeaveTravelBenft(BigInteger value) {
            this.leaveTravelBenft = value;
        }

        /**
         * Gets the value of the contToSuperAnnFund property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getContToSuperAnnFund() {
            return contToSuperAnnFund;
        }

        /**
         * Sets the value of the contToSuperAnnFund property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setContToSuperAnnFund(BigInteger value) {
            this.contToSuperAnnFund = value;
        }

        /**
         * Gets the value of the contToPF property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getContToPF() {
            return contToPF;
        }

        /**
         * Sets the value of the contToPF property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setContToPF(BigInteger value) {
            this.contToPF = value;
        }

        /**
         * Gets the value of the contToGratFund property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getContToGratFund() {
            return contToGratFund;
        }

        /**
         * Sets the value of the contToGratFund property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setContToGratFund(BigInteger value) {
            this.contToGratFund = value;
        }

        /**
         * Gets the value of the contToOthFund property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getContToOthFund() {
            return contToOthFund;
        }

        /**
         * Sets the value of the contToOthFund property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setContToOthFund(BigInteger value) {
            this.contToOthFund = value;
        }

        /**
         * Gets the value of the othEmpBenftExpdr property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOthEmpBenftExpdr() {
            return othEmpBenftExpdr;
        }

        /**
         * Sets the value of the othEmpBenftExpdr property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOthEmpBenftExpdr(BigInteger value) {
            this.othEmpBenftExpdr = value;
        }

        /**
         * Gets the value of the totEmployeeComp property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotEmployeeComp() {
            return totEmployeeComp;
        }

        /**
         * Sets the value of the totEmployeeComp property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotEmployeeComp(BigInteger value) {
            this.totEmployeeComp = value;
        }

        /**
         * Gets the value of the anyCompPaidToNonRes property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAnyCompPaidToNonRes() {
            return anyCompPaidToNonRes;
        }

        /**
         * Sets the value of the anyCompPaidToNonRes property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAnyCompPaidToNonRes(String value) {
            this.anyCompPaidToNonRes = value;
        }

        /**
         * Gets the value of the amtPaidToNonRes property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAmtPaidToNonRes() {
            return amtPaidToNonRes;
        }

        /**
         * Sets the value of the amtPaidToNonRes property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAmtPaidToNonRes(BigInteger value) {
            this.amtPaidToNonRes = value;
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
     *         &lt;element name="MedInsur">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LifeInsur">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="KeyManInsur">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OthInsur">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TotInsurances">
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
        "medInsur",
        "lifeInsur",
        "keyManInsur",
        "othInsur",
        "totInsurances"
    })
    public static class Insurances {

        @XmlElement(name = "MedInsur", required = true, defaultValue = "0")
        protected BigInteger medInsur;
        @XmlElement(name = "LifeInsur", required = true, defaultValue = "0")
        protected BigInteger lifeInsur;
        @XmlElement(name = "KeyManInsur", required = true, defaultValue = "0")
        protected BigInteger keyManInsur;
        @XmlElement(name = "OthInsur", required = true, defaultValue = "0")
        protected BigInteger othInsur;
        @XmlElement(name = "TotInsurances", required = true, defaultValue = "0")
        protected BigInteger totInsurances;

        /**
         * Gets the value of the medInsur property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMedInsur() {
            return medInsur;
        }

        /**
         * Sets the value of the medInsur property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMedInsur(BigInteger value) {
            this.medInsur = value;
        }

        /**
         * Gets the value of the lifeInsur property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getLifeInsur() {
            return lifeInsur;
        }

        /**
         * Sets the value of the lifeInsur property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setLifeInsur(BigInteger value) {
            this.lifeInsur = value;
        }

        /**
         * Gets the value of the keyManInsur property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getKeyManInsur() {
            return keyManInsur;
        }

        /**
         * Sets the value of the keyManInsur property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setKeyManInsur(BigInteger value) {
            this.keyManInsur = value;
        }

        /**
         * Gets the value of the othInsur property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOthInsur() {
            return othInsur;
        }

        /**
         * Sets the value of the othInsur property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOthInsur(BigInteger value) {
            this.othInsur = value;
        }

        /**
         * Gets the value of the totInsurances property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotInsurances() {
            return totInsurances;
        }

        /**
         * Sets the value of the totInsurances property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotInsurances(BigInteger value) {
            this.totInsurances = value;
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
     *         &lt;element name="NonResOtherCompany">
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
     *         &lt;element name="InterestExpdr">
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
        "nonResOtherCompany",
        "others",
        "interestExpdr"
    })
    public static class InterestExpdrtDtls {

        @XmlElement(name = "NonResOtherCompany", required = true, defaultValue = "0")
        protected BigInteger nonResOtherCompany;
        @XmlElement(name = "Others", required = true, defaultValue = "0")
        protected BigInteger others;
        @XmlElement(name = "InterestExpdr", required = true, defaultValue = "0")
        protected BigInteger interestExpdr;

        /**
         * Gets the value of the nonResOtherCompany property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNonResOtherCompany() {
            return nonResOtherCompany;
        }

        /**
         * Sets the value of the nonResOtherCompany property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNonResOtherCompany(BigInteger value) {
            this.nonResOtherCompany = value;
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
         * Gets the value of the interestExpdr property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getInterestExpdr() {
            return interestExpdr;
        }

        /**
         * Sets the value of the interestExpdr property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setInterestExpdr(BigInteger value) {
            this.interestExpdr = value;
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
     *         &lt;element name="OpeningStock">
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
        "openingStock"
    })
    public static class OpeningStockDtls {

        @XmlElement(name = "RawMaterial", required = true, defaultValue = "0")
        protected BigInteger rawMaterial;
        @XmlElement(name = "WorkInProgress", required = true, defaultValue = "0")
        protected BigInteger workInProgress;
        @XmlElement(name = "FinishedGoods", required = true, defaultValue = "0")
        protected BigInteger finishedGoods;
        @XmlElement(name = "OpeningStock", required = true, defaultValue = "0")
        protected BigInteger openingStock;

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
         * Gets the value of the openingStock property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOpeningStock() {
            return openingStock;
        }

        /**
         * Sets the value of the openingStock property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOpeningStock(BigInteger value) {
            this.openingStock = value;
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
     *         &lt;element name="ExpenseNature">
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
        "expenseNature",
        "amount"
    })
    public static class OtherExpensesDtls {

        @XmlElement(name = "ExpenseNature", required = true)
        protected String expenseNature;
        @XmlElement(name = "Amount", required = true, defaultValue = "0")
        protected BigInteger amount;

        /**
         * Gets the value of the expenseNature property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExpenseNature() {
            return expenseNature;
        }

        /**
         * Sets the value of the expenseNature property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExpenseNature(String value) {
            this.expenseNature = value;
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
     *         &lt;element name="NonResOtherCompany">
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
        "nonResOtherCompany",
        "others",
        "total"
    })
    public static class ProfessionalConstDtls {

        @XmlElement(name = "NonResOtherCompany", required = true, defaultValue = "0")
        protected BigInteger nonResOtherCompany;
        @XmlElement(name = "Others", required = true, defaultValue = "0")
        protected BigInteger others;
        @XmlElement(name = "Total", required = true, defaultValue = "0")
        protected BigInteger total;

        /**
         * Gets the value of the nonResOtherCompany property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNonResOtherCompany() {
            return nonResOtherCompany;
        }

        /**
         * Sets the value of the nonResOtherCompany property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNonResOtherCompany(BigInteger value) {
            this.nonResOtherCompany = value;
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
     *         &lt;element ref="{http://incometaxindiaefiling.gov.in/Corpmaster}ExciseCustomsVAT"/>
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
        "exciseCustomsVAT"
    })
    public static class RatesTaxesPays {

        @XmlElement(name = "ExciseCustomsVAT", required = true)
        protected ExciseCustomsVAT exciseCustomsVAT;

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
     *         &lt;element name="NonResOtherCompany">
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
        "nonResOtherCompany",
        "others",
        "total"
    })
    public static class RoyalityDtls {

        @XmlElement(name = "NonResOtherCompany", required = true, defaultValue = "0")
        protected BigInteger nonResOtherCompany;
        @XmlElement(name = "Others", required = true, defaultValue = "0")
        protected BigInteger others;
        @XmlElement(name = "Total", required = true, defaultValue = "0")
        protected BigInteger total;

        /**
         * Gets the value of the nonResOtherCompany property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNonResOtherCompany() {
            return nonResOtherCompany;
        }

        /**
         * Sets the value of the nonResOtherCompany property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNonResOtherCompany(BigInteger value) {
            this.nonResOtherCompany = value;
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

}
