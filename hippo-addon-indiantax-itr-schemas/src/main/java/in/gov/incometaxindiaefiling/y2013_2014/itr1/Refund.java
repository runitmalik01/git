
package in.gov.incometaxindiaefiling.y2013_2014.itr1;

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
 *         &lt;element name="RefundDue">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BankAccountNumber">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://incometaxindiaefiling.gov.in/master}nonEmptyString">
 *               &lt;minLength value="9"/>
 *               &lt;maxLength value="17"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DepositToBankAccount">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IFSCCode">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://incometaxindiaefiling.gov.in/master}nonEmptyString">
 *                         &lt;pattern value="[A-Za-z]{4}[0][A-Za-z0-9]{6}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="BankAccountType">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://incometaxindiaefiling.gov.in/master}nonEmptyString">
 *                         &lt;length value="3"/>
 *                         &lt;enumeration value="SAV"/>
 *                         &lt;enumeration value="CUR"/>
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
    "refundDue",
    "bankAccountNumber",
    "depositToBankAccount"
})
@XmlRootElement(name = "Refund")
public class Refund {

    @XmlElement(name = "RefundDue", required = true, defaultValue = "0")
    protected BigInteger refundDue;
    @XmlElement(name = "BankAccountNumber", required = true)
    protected String bankAccountNumber;
    @XmlElement(name = "DepositToBankAccount", required = true)
    protected Refund.DepositToBankAccount depositToBankAccount;

    /**
     * Gets the value of the refundDue property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRefundDue() {
        return refundDue;
    }

    /**
     * Sets the value of the refundDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRefundDue(BigInteger value) {
        this.refundDue = value;
    }

    /**
     * Gets the value of the bankAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * Sets the value of the bankAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountNumber(String value) {
        this.bankAccountNumber = value;
    }

    /**
     * Gets the value of the depositToBankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Refund.DepositToBankAccount }
     *     
     */
    public Refund.DepositToBankAccount getDepositToBankAccount() {
        return depositToBankAccount;
    }

    /**
     * Sets the value of the depositToBankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Refund.DepositToBankAccount }
     *     
     */
    public void setDepositToBankAccount(Refund.DepositToBankAccount value) {
        this.depositToBankAccount = value;
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
     *         &lt;element name="IFSCCode">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://incometaxindiaefiling.gov.in/master}nonEmptyString">
     *               &lt;pattern value="[A-Za-z]{4}[0][A-Za-z0-9]{6}"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="BankAccountType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://incometaxindiaefiling.gov.in/master}nonEmptyString">
     *               &lt;length value="3"/>
     *               &lt;enumeration value="SAV"/>
     *               &lt;enumeration value="CUR"/>
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
        "ifscCode",
        "bankAccountType"
    })
    public static class DepositToBankAccount {

        @XmlElement(name = "IFSCCode", required = true)
        protected String ifscCode;
        @XmlElement(name = "BankAccountType", required = true)
        protected String bankAccountType;

        /**
         * Gets the value of the ifscCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIFSCCode() {
            return ifscCode;
        }

        /**
         * Sets the value of the ifscCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIFSCCode(String value) {
            this.ifscCode = value;
        }

        /**
         * Gets the value of the bankAccountType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBankAccountType() {
            return bankAccountType;
        }

        /**
         * Sets the value of the bankAccountType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBankAccountType(String value) {
            this.bankAccountType = value;
        }

    }

}
