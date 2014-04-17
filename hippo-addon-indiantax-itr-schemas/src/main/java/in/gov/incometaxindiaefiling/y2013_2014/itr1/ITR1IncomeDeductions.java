
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
 *         &lt;element name="IncomeFromSal" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TypeOfHP" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://incometaxindiaefiling.gov.in/master}nonEmptyString">
 *               &lt;maxLength value="1"/>
 *               &lt;pattern value="|S|L"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotalIncomeOfHP">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IncomeOthSrc">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedLong">
 *               &lt;totalDigits value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GrossTotIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}UsrDeductUndChapVIA"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}DeductUndChapVIA"/>
 *         &lt;element name="TotalIncome" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "incomeFromSal",
    "typeOfHP",
    "totalIncomeOfHP",
    "incomeOthSrc",
    "grossTotIncome",
    "usrDeductUndChapVIA",
    "deductUndChapVIA",
    "totalIncome"
})
@XmlRootElement(name = "ITR1_IncomeDeductions")
public class ITR1IncomeDeductions {

    @XmlElement(name = "IncomeFromSal", defaultValue = "0")
    protected BigInteger incomeFromSal;
    @XmlElement(name = "TypeOfHP")
    protected String typeOfHP;
    @XmlElement(name = "TotalIncomeOfHP", defaultValue = "0")
    protected long totalIncomeOfHP;
    @XmlElement(name = "IncomeOthSrc", required = true, defaultValue = "0")
    protected BigInteger incomeOthSrc;
    @XmlElement(name = "GrossTotIncome", defaultValue = "0")
    protected long grossTotIncome;
    @XmlElement(name = "UsrDeductUndChapVIA", required = true)
    protected UsrDeductUndChapVIA usrDeductUndChapVIA;
    @XmlElement(name = "DeductUndChapVIA", required = true)
    protected DeductUndChapVIA deductUndChapVIA;
    @XmlElement(name = "TotalIncome", defaultValue = "0")
    protected long totalIncome;

    /**
     * Gets the value of the incomeFromSal property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIncomeFromSal() {
        return incomeFromSal;
    }

    /**
     * Sets the value of the incomeFromSal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIncomeFromSal(BigInteger value) {
        this.incomeFromSal = value;
    }

    /**
     * Gets the value of the typeOfHP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfHP() {
        return typeOfHP;
    }

    /**
     * Sets the value of the typeOfHP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfHP(String value) {
        this.typeOfHP = value;
    }

    /**
     * Gets the value of the totalIncomeOfHP property.
     * 
     */
    public long getTotalIncomeOfHP() {
        return totalIncomeOfHP;
    }

    /**
     * Sets the value of the totalIncomeOfHP property.
     * 
     */
    public void setTotalIncomeOfHP(long value) {
        this.totalIncomeOfHP = value;
    }

    /**
     * Gets the value of the incomeOthSrc property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIncomeOthSrc() {
        return incomeOthSrc;
    }

    /**
     * Sets the value of the incomeOthSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIncomeOthSrc(BigInteger value) {
        this.incomeOthSrc = value;
    }

    /**
     * Gets the value of the grossTotIncome property.
     * 
     */
    public long getGrossTotIncome() {
        return grossTotIncome;
    }

    /**
     * Sets the value of the grossTotIncome property.
     * 
     */
    public void setGrossTotIncome(long value) {
        this.grossTotIncome = value;
    }

    /**
     * Deductions from income
     * 
     * @return
     *     possible object is
     *     {@link UsrDeductUndChapVIA }
     *     
     */
    public UsrDeductUndChapVIA getUsrDeductUndChapVIA() {
        return usrDeductUndChapVIA;
    }

    /**
     * Sets the value of the usrDeductUndChapVIA property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsrDeductUndChapVIA }
     *     
     */
    public void setUsrDeductUndChapVIA(UsrDeductUndChapVIA value) {
        this.usrDeductUndChapVIA = value;
    }

    /**
     * Deductions from income
     * 
     * @return
     *     possible object is
     *     {@link DeductUndChapVIA }
     *     
     */
    public DeductUndChapVIA getDeductUndChapVIA() {
        return deductUndChapVIA;
    }

    /**
     * Sets the value of the deductUndChapVIA property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeductUndChapVIA }
     *     
     */
    public void setDeductUndChapVIA(DeductUndChapVIA value) {
        this.deductUndChapVIA = value;
    }

    /**
     * Gets the value of the totalIncome property.
     * 
     */
    public long getTotalIncome() {
        return totalIncome;
    }

    /**
     * Sets the value of the totalIncome property.
     * 
     */
    public void setTotalIncome(long value) {
        this.totalIncome = value;
    }

}