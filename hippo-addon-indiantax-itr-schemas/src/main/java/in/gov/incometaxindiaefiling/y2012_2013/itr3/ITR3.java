//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.04 at 11:42:11 AM PDT 
//


package in.gov.incometaxindiaefiling.y2012_2013.itr3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import in.gov.incometaxindiaefiling.y2012_2013.master.CreationInfo;
import in.gov.incometaxindiaefiling.y2012_2013.master.FormITR3;
import in.gov.incometaxindiaefiling.y2012_2013.master.PartAGEN1;
import in.gov.incometaxindiaefiling.y2012_2013.master.PartBTI;
import in.gov.incometaxindiaefiling.y2012_2013.master.PartBTTI;
import in.gov.incometaxindiaefiling.y2012_2013.master.Schedule80G;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleBPA;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleCFL;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleCGFor23;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleCYLA;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleEI;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleFA;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleHP;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleIF;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleIT;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleOS;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleS;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleSI;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleSPI;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleTDS1;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleTDS2;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleTR1;
import in.gov.incometaxindiaefiling.y2012_2013.master.ScheduleVIA;
import in.gov.incometaxindiaefiling.y2012_2013.master.TaxReturnPreparer;
import in.gov.incometaxindiaefiling.y2012_2013.master.Verification;


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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Form_ITR3"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PartA_GEN1"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PartB-TI"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PartB_TTI"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Verification"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TaxReturnPreparer" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleS" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleHP" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleIF"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleBPA"/>
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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleTR1" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleFA" minOccurs="0"/>
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
    "formITR3",
    "partAGEN1",
    "partBTI",
    "partBTTI",
    "verification",
    "taxReturnPreparer",
    "scheduleS",
    "scheduleHP",
    "scheduleIF",
    "scheduleBPA",
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
    "scheduleTR1",
    "scheduleFA"
})
@XmlRootElement(name = "ITR3")
public class ITR3 {

    @XmlElement(name = "CreationInfo", namespace = "http://incometaxindiaefiling.gov.in/master", required = true)
    protected CreationInfo creationInfo;
    @XmlElement(name = "Form_ITR3", namespace = "http://incometaxindiaefiling.gov.in/master", required = true)
    protected FormITR3 formITR3;
    @XmlElement(name = "PartA_GEN1", namespace = "http://incometaxindiaefiling.gov.in/master", required = true)
    protected PartAGEN1 partAGEN1;
    @XmlElement(name = "PartB-TI", namespace = "http://incometaxindiaefiling.gov.in/master", required = true)
    protected PartBTI partBTI;
    @XmlElement(name = "PartB_TTI", namespace = "http://incometaxindiaefiling.gov.in/master", required = true)
    protected PartBTTI partBTTI;
    @XmlElement(name = "Verification", namespace = "http://incometaxindiaefiling.gov.in/master", required = true)
    protected Verification verification;
    @XmlElement(name = "TaxReturnPreparer", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected TaxReturnPreparer taxReturnPreparer;
    @XmlElement(name = "ScheduleS", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleS scheduleS;
    @XmlElement(name = "ScheduleHP", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleHP scheduleHP;
    @XmlElement(name = "ScheduleIF", namespace = "http://incometaxindiaefiling.gov.in/master", required = true)
    protected ScheduleIF scheduleIF;
    @XmlElement(name = "ScheduleBPA", namespace = "http://incometaxindiaefiling.gov.in/master", required = true)
    protected ScheduleBPA scheduleBPA;
    @XmlElement(name = "ScheduleCGFor23", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleCGFor23 scheduleCGFor23;
    @XmlElement(name = "ScheduleOS", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleOS scheduleOS;
    @XmlElement(name = "ScheduleCYLA", namespace = "http://incometaxindiaefiling.gov.in/master", required = true)
    protected ScheduleCYLA scheduleCYLA;
    @XmlElement(name = "ScheduleBFLA", namespace = "http://incometaxindiaefiling.gov.in/master", required = true)
    protected ScheduleBFLA scheduleBFLA;
    @XmlElement(name = "ScheduleCFL", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleCFL scheduleCFL;
    @XmlElement(name = "ScheduleVIA", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleVIA scheduleVIA;
    @XmlElement(name = "Schedule80G", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected Schedule80G schedule80G;
    @XmlElement(name = "ScheduleSPI", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleSPI scheduleSPI;
    @XmlElement(name = "ScheduleSI", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleSI scheduleSI;
    @XmlElement(name = "ScheduleEI", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleEI scheduleEI;
    @XmlElement(name = "ScheduleIT", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleIT scheduleIT;
    @XmlElement(name = "ScheduleTDS1", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleTDS1 scheduleTDS1;
    @XmlElement(name = "ScheduleTDS2", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleTDS2 scheduleTDS2;
    @XmlElement(name = "ScheduleTR1", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleTR1 scheduleTR1;
    @XmlElement(name = "ScheduleFA", namespace = "http://incometaxindiaefiling.gov.in/master")
    protected ScheduleFA scheduleFA;

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
     * Gets the value of the formITR3 property.
     * 
     * @return
     *     possible object is
     *     {@link FormITR3 }
     *     
     */
    public FormITR3 getFormITR3() {
        return formITR3;
    }

    /**
     * Sets the value of the formITR3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormITR3 }
     *     
     */
    public void setFormITR3(FormITR3 value) {
        this.formITR3 = value;
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
     * Gets the value of the scheduleIF property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleIF }
     *     
     */
    public ScheduleIF getScheduleIF() {
        return scheduleIF;
    }

    /**
     * Sets the value of the scheduleIF property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleIF }
     *     
     */
    public void setScheduleIF(ScheduleIF value) {
        this.scheduleIF = value;
    }

    /**
     * Gets the value of the scheduleBPA property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleBPA }
     *     
     */
    public ScheduleBPA getScheduleBPA() {
        return scheduleBPA;
    }

    /**
     * Sets the value of the scheduleBPA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleBPA }
     *     
     */
    public void setScheduleBPA(ScheduleBPA value) {
        this.scheduleBPA = value;
    }

    /**
     * Capital Gains
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
     * Income from other sources
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
     * Details of Income after Set of of current years losses.
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

}
