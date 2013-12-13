
package in.gov.incometaxindiaefiling.y2012_2013;

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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}CreationInfo"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Form_ITR2"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PartA_GEN1"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PartB-TI"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PartB_TTI"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Verification"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TaxReturnPreparer" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleS" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleHP" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleCGFor23" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleOS" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleCYLA"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleBFLA"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleCFL" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleVIA" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule80G" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleSPI" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleSI" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleEI" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleIT" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleTDS1" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleTDS2" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ITRScheduleFSI" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleTR1" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleFA" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule5A" minOccurs="0"/>
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
    "creationInfo",
    "formITR2",
    "partAGEN1",
    "partBTI",
    "partBTTI",
    "verification",
    "taxReturnPreparer",
    "scheduleS",
    "scheduleHP",
    "scheduleCGFor23",
    "scheduleOS",
    "scheduleCYLA",
    "scheduleBFLA",
    "scheduleCFL",
    "scheduleVIA",
    "schedule80G",
    "scheduleSPI",
    "scheduleSI",
    "scheduleEI",
    "scheduleIT",
    "scheduleTDS1",
    "scheduleTDS2",
    "itrScheduleFSI",
    "scheduleTR1",
    "scheduleFA",
    "schedule5A"
})
@XmlRootElement(name = "ITR2", namespace = "http://incometaxindiaefiling.gov.in/ITR2")
public class ITR2 {

    @XmlElement(name = "CreationInfo", required = true)
    protected CreationInfo creationInfo;
    @XmlElement(name = "Form_ITR2", required = true)
    protected FormITR2 formITR2;
    @XmlElement(name = "PartA_GEN1", required = true)
    protected PartAGEN1 partAGEN1;
    @XmlElement(name = "PartB-TI", required = true)
    protected PartBTI partBTI;
    @XmlElement(name = "PartB_TTI", required = true)
    protected PartBTTI partBTTI;
    @XmlElement(name = "Verification", required = true)
    protected Verification verification;
    @XmlElement(name = "TaxReturnPreparer")
    protected TaxReturnPreparer taxReturnPreparer;
    @XmlElement(name = "ScheduleS")
    protected ScheduleS scheduleS;
    @XmlElement(name = "ScheduleHP")
    protected ScheduleHP scheduleHP;
    @XmlElement(name = "ScheduleCGFor23")
    protected ScheduleCGFor23 scheduleCGFor23;
    @XmlElement(name = "ScheduleOS")
    protected ScheduleOS scheduleOS;
    @XmlElement(name = "ScheduleCYLA", required = true)
    protected ScheduleCYLA scheduleCYLA;
    @XmlElement(name = "ScheduleBFLA", required = true)
    protected ScheduleBFLA scheduleBFLA;
    @XmlElement(name = "ScheduleCFL")
    protected ScheduleCFL scheduleCFL;
    @XmlElement(name = "ScheduleVIA")
    protected ScheduleVIA scheduleVIA;
    @XmlElement(name = "Schedule80G")
    protected Schedule80G schedule80G;
    @XmlElement(name = "ScheduleSPI")
    protected ScheduleSPI scheduleSPI;
    @XmlElement(name = "ScheduleSI")
    protected ScheduleSI scheduleSI;
    @XmlElement(name = "ScheduleEI")
    protected ScheduleEI scheduleEI;
    @XmlElement(name = "ScheduleIT")
    protected ScheduleIT scheduleIT;
    @XmlElement(name = "ScheduleTDS1")
    protected ScheduleTDS1 scheduleTDS1;
    @XmlElement(name = "ScheduleTDS2")
    protected ScheduleTDS2 scheduleTDS2;
    @XmlElement(name = "ITRScheduleFSI")
    protected ITRScheduleFSI itrScheduleFSI;
    @XmlElement(name = "ScheduleTR1")
    protected ScheduleTR1 scheduleTR1;
    @XmlElement(name = "ScheduleFA")
    protected ScheduleFA scheduleFA;
    @XmlElement(name = "Schedule5A")
    protected Schedule5A schedule5A;

    /**
     * Gets the value of the creationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CreationInfo }
     *     
     */
    public CreationInfo getCreationInfo() {
        return creationInfo;
    }

    /**
     * Sets the value of the creationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreationInfo }
     *     
     */
    public void setCreationInfo(CreationInfo value) {
        this.creationInfo = value;
    }

    /**
     * Gets the value of the formITR2 property.
     * 
     * @return
     *     possible object is
     *     {@link FormITR2 }
     *     
     */
    public FormITR2 getFormITR2() {
        return formITR2;
    }

    /**
     * Sets the value of the formITR2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormITR2 }
     *     
     */
    public void setFormITR2(FormITR2 value) {
        this.formITR2 = value;
    }

    /**
     * Gets the value of the partAGEN1 property.
     * 
     * @return
     *     possible object is
     *     {@link PartAGEN1 }
     *     
     */
    public PartAGEN1 getPartAGEN1() {
        return partAGEN1;
    }

    /**
     * Sets the value of the partAGEN1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartAGEN1 }
     *     
     */
    public void setPartAGEN1(PartAGEN1 value) {
        this.partAGEN1 = value;
    }

    /**
     * Gets the value of the partBTI property.
     * 
     * @return
     *     possible object is
     *     {@link PartBTI }
     *     
     */
    public PartBTI getPartBTI() {
        return partBTI;
    }

    /**
     * Sets the value of the partBTI property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartBTI }
     *     
     */
    public void setPartBTI(PartBTI value) {
        this.partBTI = value;
    }

    /**
     * Gets the value of the partBTTI property.
     * 
     * @return
     *     possible object is
     *     {@link PartBTTI }
     *     
     */
    public PartBTTI getPartBTTI() {
        return partBTTI;
    }

    /**
     * Sets the value of the partBTTI property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartBTTI }
     *     
     */
    public void setPartBTTI(PartBTTI value) {
        this.partBTTI = value;
    }

    /**
     * Gets the value of the verification property.
     * 
     * @return
     *     possible object is
     *     {@link Verification }
     *     
     */
    public Verification getVerification() {
        return verification;
    }

    /**
     * Sets the value of the verification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Verification }
     *     
     */
    public void setVerification(Verification value) {
        this.verification = value;
    }

    /**
     * Gets the value of the taxReturnPreparer property.
     * 
     * @return
     *     possible object is
     *     {@link TaxReturnPreparer }
     *     
     */
    public TaxReturnPreparer getTaxReturnPreparer() {
        return taxReturnPreparer;
    }

    /**
     * Sets the value of the taxReturnPreparer property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxReturnPreparer }
     *     
     */
    public void setTaxReturnPreparer(TaxReturnPreparer value) {
        this.taxReturnPreparer = value;
    }

    /**
     * Gets the value of the scheduleS property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleS }
     *     
     */
    public ScheduleS getScheduleS() {
        return scheduleS;
    }

    /**
     * Sets the value of the scheduleS property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleS }
     *     
     */
    public void setScheduleS(ScheduleS value) {
        this.scheduleS = value;
    }

    /**
     * Gets the value of the scheduleHP property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleHP }
     *     
     */
    public ScheduleHP getScheduleHP() {
        return scheduleHP;
    }

    /**
     * Sets the value of the scheduleHP property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleHP }
     *     
     */
    public void setScheduleHP(ScheduleHP value) {
        this.scheduleHP = value;
    }

    /**
     * Gets the value of the scheduleCGFor23 property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleCGFor23 }
     *     
     */
    public ScheduleCGFor23 getScheduleCGFor23() {
        return scheduleCGFor23;
    }

    /**
     * Sets the value of the scheduleCGFor23 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleCGFor23 }
     *     
     */
    public void setScheduleCGFor23(ScheduleCGFor23 value) {
        this.scheduleCGFor23 = value;
    }

    /**
     * Gets the value of the scheduleOS property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleOS }
     *     
     */
    public ScheduleOS getScheduleOS() {
        return scheduleOS;
    }

    /**
     * Sets the value of the scheduleOS property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleOS }
     *     
     */
    public void setScheduleOS(ScheduleOS value) {
        this.scheduleOS = value;
    }

    /**
     * Gets the value of the scheduleCYLA property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleCYLA }
     *     
     */
    public ScheduleCYLA getScheduleCYLA() {
        return scheduleCYLA;
    }

    /**
     * Sets the value of the scheduleCYLA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleCYLA }
     *     
     */
    public void setScheduleCYLA(ScheduleCYLA value) {
        this.scheduleCYLA = value;
    }

    /**
     * Gets the value of the scheduleBFLA property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleBFLA }
     *     
     */
    public ScheduleBFLA getScheduleBFLA() {
        return scheduleBFLA;
    }

    /**
     * Sets the value of the scheduleBFLA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleBFLA }
     *     
     */
    public void setScheduleBFLA(ScheduleBFLA value) {
        this.scheduleBFLA = value;
    }

    /**
     * Gets the value of the scheduleCFL property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleCFL }
     *     
     */
    public ScheduleCFL getScheduleCFL() {
        return scheduleCFL;
    }

    /**
     * Sets the value of the scheduleCFL property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleCFL }
     *     
     */
    public void setScheduleCFL(ScheduleCFL value) {
        this.scheduleCFL = value;
    }

    /**
     * Gets the value of the scheduleVIA property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleVIA }
     *     
     */
    public ScheduleVIA getScheduleVIA() {
        return scheduleVIA;
    }

    /**
     * Sets the value of the scheduleVIA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleVIA }
     *     
     */
    public void setScheduleVIA(ScheduleVIA value) {
        this.scheduleVIA = value;
    }

    /**
     * Gets the value of the schedule80G property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule80G }
     *     
     */
    public Schedule80G getSchedule80G() {
        return schedule80G;
    }

    /**
     * Sets the value of the schedule80G property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule80G }
     *     
     */
    public void setSchedule80G(Schedule80G value) {
        this.schedule80G = value;
    }

    /**
     * Gets the value of the scheduleSPI property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleSPI }
     *     
     */
    public ScheduleSPI getScheduleSPI() {
        return scheduleSPI;
    }

    /**
     * Sets the value of the scheduleSPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleSPI }
     *     
     */
    public void setScheduleSPI(ScheduleSPI value) {
        this.scheduleSPI = value;
    }

    /**
     * Gets the value of the scheduleSI property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleSI }
     *     
     */
    public ScheduleSI getScheduleSI() {
        return scheduleSI;
    }

    /**
     * Sets the value of the scheduleSI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleSI }
     *     
     */
    public void setScheduleSI(ScheduleSI value) {
        this.scheduleSI = value;
    }

    /**
     * Gets the value of the scheduleEI property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleEI }
     *     
     */
    public ScheduleEI getScheduleEI() {
        return scheduleEI;
    }

    /**
     * Sets the value of the scheduleEI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleEI }
     *     
     */
    public void setScheduleEI(ScheduleEI value) {
        this.scheduleEI = value;
    }

    /**
     * Gets the value of the scheduleIT property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleIT }
     *     
     */
    public ScheduleIT getScheduleIT() {
        return scheduleIT;
    }

    /**
     * Sets the value of the scheduleIT property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleIT }
     *     
     */
    public void setScheduleIT(ScheduleIT value) {
        this.scheduleIT = value;
    }

    /**
     * Gets the value of the scheduleTDS1 property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleTDS1 }
     *     
     */
    public ScheduleTDS1 getScheduleTDS1() {
        return scheduleTDS1;
    }

    /**
     * Sets the value of the scheduleTDS1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleTDS1 }
     *     
     */
    public void setScheduleTDS1(ScheduleTDS1 value) {
        this.scheduleTDS1 = value;
    }

    /**
     * Gets the value of the scheduleTDS2 property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleTDS2 }
     *     
     */
    public ScheduleTDS2 getScheduleTDS2() {
        return scheduleTDS2;
    }

    /**
     * Sets the value of the scheduleTDS2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleTDS2 }
     *     
     */
    public void setScheduleTDS2(ScheduleTDS2 value) {
        this.scheduleTDS2 = value;
    }

    /**
     * Gets the value of the itrScheduleFSI property.
     * 
     * @return
     *     possible object is
     *     {@link ITRScheduleFSI }
     *     
     */
    public ITRScheduleFSI getITRScheduleFSI() {
        return itrScheduleFSI;
    }

    /**
     * Sets the value of the itrScheduleFSI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ITRScheduleFSI }
     *     
     */
    public void setITRScheduleFSI(ITRScheduleFSI value) {
        this.itrScheduleFSI = value;
    }

    /**
     * Gets the value of the scheduleTR1 property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleTR1 }
     *     
     */
    public ScheduleTR1 getScheduleTR1() {
        return scheduleTR1;
    }

    /**
     * Sets the value of the scheduleTR1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleTR1 }
     *     
     */
    public void setScheduleTR1(ScheduleTR1 value) {
        this.scheduleTR1 = value;
    }

    /**
     * Gets the value of the scheduleFA property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleFA }
     *     
     */
    public ScheduleFA getScheduleFA() {
        return scheduleFA;
    }

    /**
     * Sets the value of the scheduleFA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleFA }
     *     
     */
    public void setScheduleFA(ScheduleFA value) {
        this.scheduleFA = value;
    }

    /**
     * Gets the value of the schedule5A property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule5A }
     *     
     */
    public Schedule5A getSchedule5A() {
        return schedule5A;
    }

    /**
     * Sets the value of the schedule5A property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule5A }
     *     
     */
    public void setSchedule5A(Schedule5A value) {
        this.schedule5A = value;
    }

}
