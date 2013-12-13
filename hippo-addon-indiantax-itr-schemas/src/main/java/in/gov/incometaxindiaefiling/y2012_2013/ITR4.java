
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
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Form_ITR4"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PartA_GEN1"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PartA_GEN2"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PARTA_BS"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PARTA_PL"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PARTA_OI" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PARTA_QD" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PartB-TI"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}PartB_TTI"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Verification"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}TaxReturnPreparer" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleS" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleHP" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ITR4ScheduleBP"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleDPM" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleDOA" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleDEP" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleDCG" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleESR" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleCGFor4" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleOS" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleCYLA"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleBFLA"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleCFL" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ITR4ScheduleUD" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule10A" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule10AA" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule10B" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule10BA" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule80G" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule80_IA" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule80_IB" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule80_IC" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleVIA" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ITRScheduleAMT" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ITRScheduleAMTC" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleSTTR" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleSPI" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleSI" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleIF" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleEI" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleIT" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleTDS1" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleTDS2" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleTCS" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ITRScheduleFSI" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleTR1" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleFA" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}Schedule5A" minOccurs="0"/>
 *         &lt;element ref="{http://incometaxindiaefiling.gov.in/master}ScheduleAL" minOccurs="0"/>
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
    "formITR4",
    "partAGEN1",
    "partAGEN2",
    "partabs",
    "partapl",
    "partaoi",
    "partaqd",
    "partBTI",
    "partBTTI",
    "verification",
    "taxReturnPreparer",
    "scheduleS",
    "scheduleHP",
    "itr4ScheduleBP",
    "scheduleDPM",
    "scheduleDOA",
    "scheduleDEP",
    "scheduleDCG",
    "scheduleESR",
    "scheduleCGFor4",
    "scheduleOS",
    "scheduleCYLA",
    "scheduleBFLA",
    "scheduleCFL",
    "itr4ScheduleUD",
    "schedule10A",
    "schedule10AA",
    "schedule10B",
    "schedule10BA",
    "schedule80G",
    "schedule80IA",
    "schedule80IB",
    "schedule80IC",
    "scheduleVIA",
    "itrScheduleAMT",
    "itrScheduleAMTC",
    "scheduleSTTR",
    "scheduleSPI",
    "scheduleSI",
    "scheduleIF",
    "scheduleEI",
    "scheduleIT",
    "scheduleTDS1",
    "scheduleTDS2",
    "scheduleTCS",
    "itrScheduleFSI",
    "scheduleTR1",
    "scheduleFA",
    "schedule5A",
    "scheduleAL"
})
@XmlRootElement(name = "ITR4", namespace = "http://incometaxindiaefiling.gov.in/ITR4")
public class ITR4 {

    @XmlElement(name = "CreationInfo", required = true)
    protected CreationInfo creationInfo;
    @XmlElement(name = "Form_ITR4", required = true)
    protected FormITR4 formITR4;
    @XmlElement(name = "PartA_GEN1", required = true)
    protected PartAGEN1 partAGEN1;
    @XmlElement(name = "PartA_GEN2", required = true)
    protected PartAGEN2 partAGEN2;
    @XmlElement(name = "PARTA_BS", required = true)
    protected PARTABS partabs;
    @XmlElement(name = "PARTA_PL", required = true)
    protected PARTAPL partapl;
    @XmlElement(name = "PARTA_OI")
    protected PARTAOI partaoi;
    @XmlElement(name = "PARTA_QD")
    protected PARTAQD partaqd;
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
    @XmlElement(name = "ITR4ScheduleBP", required = true)
    protected ITR4ScheduleBP itr4ScheduleBP;
    @XmlElement(name = "ScheduleDPM")
    protected ScheduleDPM scheduleDPM;
    @XmlElement(name = "ScheduleDOA")
    protected ScheduleDOA scheduleDOA;
    @XmlElement(name = "ScheduleDEP")
    protected ScheduleDEP scheduleDEP;
    @XmlElement(name = "ScheduleDCG")
    protected ScheduleDCG scheduleDCG;
    @XmlElement(name = "ScheduleESR")
    protected ScheduleESR scheduleESR;
    @XmlElement(name = "ScheduleCGFor4")
    protected ScheduleCGFor4 scheduleCGFor4;
    @XmlElement(name = "ScheduleOS")
    protected ScheduleOS scheduleOS;
    @XmlElement(name = "ScheduleCYLA", required = true)
    protected ScheduleCYLA scheduleCYLA;
    @XmlElement(name = "ScheduleBFLA", required = true)
    protected ScheduleBFLA scheduleBFLA;
    @XmlElement(name = "ScheduleCFL")
    protected ScheduleCFL scheduleCFL;
    @XmlElement(name = "ITR4ScheduleUD")
    protected ITR4ScheduleUD itr4ScheduleUD;
    @XmlElement(name = "Schedule10A")
    protected Schedule10A schedule10A;
    @XmlElement(name = "Schedule10AA")
    protected Schedule10AA schedule10AA;
    @XmlElement(name = "Schedule10B")
    protected Schedule10B schedule10B;
    @XmlElement(name = "Schedule10BA")
    protected Schedule10BA schedule10BA;
    @XmlElement(name = "Schedule80G")
    protected Schedule80G schedule80G;
    @XmlElement(name = "Schedule80_IA")
    protected Schedule80IA schedule80IA;
    @XmlElement(name = "Schedule80_IB")
    protected Schedule80IB schedule80IB;
    @XmlElement(name = "Schedule80_IC")
    protected Schedule80IC schedule80IC;
    @XmlElement(name = "ScheduleVIA")
    protected ScheduleVIA scheduleVIA;
    @XmlElement(name = "ITRScheduleAMT")
    protected ITRScheduleAMT itrScheduleAMT;
    @XmlElement(name = "ITRScheduleAMTC")
    protected ITRScheduleAMTC itrScheduleAMTC;
    @XmlElement(name = "ScheduleSTTR")
    protected ScheduleSTTR scheduleSTTR;
    @XmlElement(name = "ScheduleSPI")
    protected ScheduleSPI scheduleSPI;
    @XmlElement(name = "ScheduleSI")
    protected ScheduleSI scheduleSI;
    @XmlElement(name = "ScheduleIF")
    protected ScheduleIF scheduleIF;
    @XmlElement(name = "ScheduleEI")
    protected ScheduleEI scheduleEI;
    @XmlElement(name = "ScheduleIT")
    protected ScheduleIT scheduleIT;
    @XmlElement(name = "ScheduleTDS1")
    protected ScheduleTDS1 scheduleTDS1;
    @XmlElement(name = "ScheduleTDS2")
    protected ScheduleTDS2 scheduleTDS2;
    @XmlElement(name = "ScheduleTCS")
    protected ScheduleTCS scheduleTCS;
    @XmlElement(name = "ITRScheduleFSI")
    protected ITRScheduleFSI itrScheduleFSI;
    @XmlElement(name = "ScheduleTR1")
    protected ScheduleTR1 scheduleTR1;
    @XmlElement(name = "ScheduleFA")
    protected ScheduleFA scheduleFA;
    @XmlElement(name = "Schedule5A")
    protected Schedule5A schedule5A;
    @XmlElement(name = "ScheduleAL")
    protected ScheduleAL scheduleAL;

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
     * Gets the value of the formITR4 property.
     * 
     * @return
     *     possible object is
     *     {@link FormITR4 }
     *     
     */
    public FormITR4 getFormITR4() {
        return formITR4;
    }

    /**
     * Sets the value of the formITR4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormITR4 }
     *     
     */
    public void setFormITR4(FormITR4 value) {
        this.formITR4 = value;
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
     * Gets the value of the partAGEN2 property.
     * 
     * @return
     *     possible object is
     *     {@link PartAGEN2 }
     *     
     */
    public PartAGEN2 getPartAGEN2() {
        return partAGEN2;
    }

    /**
     * Sets the value of the partAGEN2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartAGEN2 }
     *     
     */
    public void setPartAGEN2(PartAGEN2 value) {
        this.partAGEN2 = value;
    }

    /**
     * Gets the value of the partabs property.
     * 
     * @return
     *     possible object is
     *     {@link PARTABS }
     *     
     */
    public PARTABS getPARTABS() {
        return partabs;
    }

    /**
     * Sets the value of the partabs property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTABS }
     *     
     */
    public void setPARTABS(PARTABS value) {
        this.partabs = value;
    }

    /**
     * Gets the value of the partapl property.
     * 
     * @return
     *     possible object is
     *     {@link PARTAPL }
     *     
     */
    public PARTAPL getPARTAPL() {
        return partapl;
    }

    /**
     * Sets the value of the partapl property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTAPL }
     *     
     */
    public void setPARTAPL(PARTAPL value) {
        this.partapl = value;
    }

    /**
     * Gets the value of the partaoi property.
     * 
     * @return
     *     possible object is
     *     {@link PARTAOI }
     *     
     */
    public PARTAOI getPARTAOI() {
        return partaoi;
    }

    /**
     * Sets the value of the partaoi property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTAOI }
     *     
     */
    public void setPARTAOI(PARTAOI value) {
        this.partaoi = value;
    }

    /**
     * Gets the value of the partaqd property.
     * 
     * @return
     *     possible object is
     *     {@link PARTAQD }
     *     
     */
    public PARTAQD getPARTAQD() {
        return partaqd;
    }

    /**
     * Sets the value of the partaqd property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTAQD }
     *     
     */
    public void setPARTAQD(PARTAQD value) {
        this.partaqd = value;
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
     * Gets the value of the itr4ScheduleBP property.
     * 
     * @return
     *     possible object is
     *     {@link ITR4ScheduleBP }
     *     
     */
    public ITR4ScheduleBP getITR4ScheduleBP() {
        return itr4ScheduleBP;
    }

    /**
     * Sets the value of the itr4ScheduleBP property.
     * 
     * @param value
     *     allowed object is
     *     {@link ITR4ScheduleBP }
     *     
     */
    public void setITR4ScheduleBP(ITR4ScheduleBP value) {
        this.itr4ScheduleBP = value;
    }

    /**
     * Gets the value of the scheduleDPM property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleDPM }
     *     
     */
    public ScheduleDPM getScheduleDPM() {
        return scheduleDPM;
    }

    /**
     * Sets the value of the scheduleDPM property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleDPM }
     *     
     */
    public void setScheduleDPM(ScheduleDPM value) {
        this.scheduleDPM = value;
    }

    /**
     * Gets the value of the scheduleDOA property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleDOA }
     *     
     */
    public ScheduleDOA getScheduleDOA() {
        return scheduleDOA;
    }

    /**
     * Sets the value of the scheduleDOA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleDOA }
     *     
     */
    public void setScheduleDOA(ScheduleDOA value) {
        this.scheduleDOA = value;
    }

    /**
     * Gets the value of the scheduleDEP property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleDEP }
     *     
     */
    public ScheduleDEP getScheduleDEP() {
        return scheduleDEP;
    }

    /**
     * Sets the value of the scheduleDEP property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleDEP }
     *     
     */
    public void setScheduleDEP(ScheduleDEP value) {
        this.scheduleDEP = value;
    }

    /**
     * Gets the value of the scheduleDCG property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleDCG }
     *     
     */
    public ScheduleDCG getScheduleDCG() {
        return scheduleDCG;
    }

    /**
     * Sets the value of the scheduleDCG property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleDCG }
     *     
     */
    public void setScheduleDCG(ScheduleDCG value) {
        this.scheduleDCG = value;
    }

    /**
     * Gets the value of the scheduleESR property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleESR }
     *     
     */
    public ScheduleESR getScheduleESR() {
        return scheduleESR;
    }

    /**
     * Sets the value of the scheduleESR property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleESR }
     *     
     */
    public void setScheduleESR(ScheduleESR value) {
        this.scheduleESR = value;
    }

    /**
     * Gets the value of the scheduleCGFor4 property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleCGFor4 }
     *     
     */
    public ScheduleCGFor4 getScheduleCGFor4() {
        return scheduleCGFor4;
    }

    /**
     * Sets the value of the scheduleCGFor4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleCGFor4 }
     *     
     */
    public void setScheduleCGFor4(ScheduleCGFor4 value) {
        this.scheduleCGFor4 = value;
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
     * Gets the value of the itr4ScheduleUD property.
     * 
     * @return
     *     possible object is
     *     {@link ITR4ScheduleUD }
     *     
     */
    public ITR4ScheduleUD getITR4ScheduleUD() {
        return itr4ScheduleUD;
    }

    /**
     * Sets the value of the itr4ScheduleUD property.
     * 
     * @param value
     *     allowed object is
     *     {@link ITR4ScheduleUD }
     *     
     */
    public void setITR4ScheduleUD(ITR4ScheduleUD value) {
        this.itr4ScheduleUD = value;
    }

    /**
     * Gets the value of the schedule10A property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule10A }
     *     
     */
    public Schedule10A getSchedule10A() {
        return schedule10A;
    }

    /**
     * Sets the value of the schedule10A property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule10A }
     *     
     */
    public void setSchedule10A(Schedule10A value) {
        this.schedule10A = value;
    }

    /**
     * Gets the value of the schedule10AA property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule10AA }
     *     
     */
    public Schedule10AA getSchedule10AA() {
        return schedule10AA;
    }

    /**
     * Sets the value of the schedule10AA property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule10AA }
     *     
     */
    public void setSchedule10AA(Schedule10AA value) {
        this.schedule10AA = value;
    }

    /**
     * Gets the value of the schedule10B property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule10B }
     *     
     */
    public Schedule10B getSchedule10B() {
        return schedule10B;
    }

    /**
     * Sets the value of the schedule10B property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule10B }
     *     
     */
    public void setSchedule10B(Schedule10B value) {
        this.schedule10B = value;
    }

    /**
     * Gets the value of the schedule10BA property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule10BA }
     *     
     */
    public Schedule10BA getSchedule10BA() {
        return schedule10BA;
    }

    /**
     * Sets the value of the schedule10BA property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule10BA }
     *     
     */
    public void setSchedule10BA(Schedule10BA value) {
        this.schedule10BA = value;
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
     * Gets the value of the schedule80IA property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule80IA }
     *     
     */
    public Schedule80IA getSchedule80IA() {
        return schedule80IA;
    }

    /**
     * Sets the value of the schedule80IA property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule80IA }
     *     
     */
    public void setSchedule80IA(Schedule80IA value) {
        this.schedule80IA = value;
    }

    /**
     * Gets the value of the schedule80IB property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule80IB }
     *     
     */
    public Schedule80IB getSchedule80IB() {
        return schedule80IB;
    }

    /**
     * Sets the value of the schedule80IB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule80IB }
     *     
     */
    public void setSchedule80IB(Schedule80IB value) {
        this.schedule80IB = value;
    }

    /**
     * Gets the value of the schedule80IC property.
     * 
     * @return
     *     possible object is
     *     {@link Schedule80IC }
     *     
     */
    public Schedule80IC getSchedule80IC() {
        return schedule80IC;
    }

    /**
     * Sets the value of the schedule80IC property.
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule80IC }
     *     
     */
    public void setSchedule80IC(Schedule80IC value) {
        this.schedule80IC = value;
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
     * Gets the value of the itrScheduleAMT property.
     * 
     * @return
     *     possible object is
     *     {@link ITRScheduleAMT }
     *     
     */
    public ITRScheduleAMT getITRScheduleAMT() {
        return itrScheduleAMT;
    }

    /**
     * Sets the value of the itrScheduleAMT property.
     * 
     * @param value
     *     allowed object is
     *     {@link ITRScheduleAMT }
     *     
     */
    public void setITRScheduleAMT(ITRScheduleAMT value) {
        this.itrScheduleAMT = value;
    }

    /**
     * Gets the value of the itrScheduleAMTC property.
     * 
     * @return
     *     possible object is
     *     {@link ITRScheduleAMTC }
     *     
     */
    public ITRScheduleAMTC getITRScheduleAMTC() {
        return itrScheduleAMTC;
    }

    /**
     * Sets the value of the itrScheduleAMTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link ITRScheduleAMTC }
     *     
     */
    public void setITRScheduleAMTC(ITRScheduleAMTC value) {
        this.itrScheduleAMTC = value;
    }

    /**
     * Gets the value of the scheduleSTTR property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleSTTR }
     *     
     */
    public ScheduleSTTR getScheduleSTTR() {
        return scheduleSTTR;
    }

    /**
     * Sets the value of the scheduleSTTR property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleSTTR }
     *     
     */
    public void setScheduleSTTR(ScheduleSTTR value) {
        this.scheduleSTTR = value;
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
     * Gets the value of the scheduleTCS property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleTCS }
     *     
     */
    public ScheduleTCS getScheduleTCS() {
        return scheduleTCS;
    }

    /**
     * Sets the value of the scheduleTCS property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleTCS }
     *     
     */
    public void setScheduleTCS(ScheduleTCS value) {
        this.scheduleTCS = value;
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

    /**
     * Gets the value of the scheduleAL property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleAL }
     *     
     */
    public ScheduleAL getScheduleAL() {
        return scheduleAL;
    }

    /**
     * Sets the value of the scheduleAL property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleAL }
     *     
     */
    public void setScheduleAL(ScheduleAL value) {
        this.scheduleAL = value;
    }

}
