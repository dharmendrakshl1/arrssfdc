//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.27 at 03:28:40 PM IST 
//


package com.arris.sfdc.pojo;

import javax.xml.bind.JAXBElement;
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
 *         &lt;element name="ID_Header_QueryBillTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Header_QueryShipTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Header_QueryTrialIR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Header_QueryTrialwIR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Header_QueryOffer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Header_QueryQuotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Header_QueryQuotes_Opportunity__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Header_QueryOpportunity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Line_QueryShipTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Line_QueryBillTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Line_QueryShipment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Line_PartNumber2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_HD_SFDCHeader" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Attachment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_Note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_LD_SFDCLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "idHeaderQueryBillTo",
    "idHeaderQueryShipTo",
    "idHeaderQueryTrialIR",
    "idHeaderQueryTrialwIR",
    "idHeaderQueryOffer",
    "idHeaderQueryQuotes",
    "idHeaderQueryQuotesOpportunityC",
    "idHeaderQueryOpportunity",
    "idLineQueryShipTo",
    "idLineQueryBillTo",
    "idLineQueryShipment",
    "idLinePartNumber2",
    "idhdsfdcHeader",
    "idAttachment",
    "idNote",
    "idldsfdcLine",
    "errorMessage"
})
@XmlRootElement(name = "OutputElement")
public class OutputElement {

    @XmlElement(name = "ID_Header_QueryBillTo", required = false)
    protected String idHeaderQueryBillTo;
    @XmlElement(name = "ID_Header_QueryShipTo", required = false)
    protected String idHeaderQueryShipTo;
    @XmlElement(name = "ID_Header_QueryTrialIR", required = false)
    protected String idHeaderQueryTrialIR;
    @XmlElement(name = "ID_Header_QueryTrialwIR", required = false)
    protected String idHeaderQueryTrialwIR;
    @XmlElement(name = "ID_Header_QueryOffer", required = false)
    protected String idHeaderQueryOffer;
    @XmlElement(name = "ID_Header_QueryQuotes", required = false)
    protected String idHeaderQueryQuotes;
    @XmlElement(name = "ID_Header_QueryQuotes_Opportunity__c", required = false)
    protected String idHeaderQueryQuotesOpportunityC;
    @XmlElement(name = "ID_Header_QueryOpportunity", required = false)
    protected String idHeaderQueryOpportunity;
    @XmlElement(name = "ID_Line_QueryShipTo", required = false)
    protected String idLineQueryShipTo;
    @XmlElement(name = "ID_Line_QueryBillTo", required = false)
    protected String idLineQueryBillTo;
    @XmlElement(name = "ID_Line_QueryShipment", required = false)
    protected String idLineQueryShipment;
    @XmlElement(name = "ID_Line_PartNumber2", required = false)
    protected String idLinePartNumber2;
    @XmlElement(name = "ID_HD_SFDCHeader", required = false)
    protected String idhdsfdcHeader;
    @XmlElement(name = "ID_Attachment", required = false)
    protected String idAttachment;
    @XmlElement(name = "ID_Note", required = false)
    protected String idNote;
    @XmlElement(name = "ID_LD_SFDCLine", required = false)
    protected String idldsfdcLine;
    @XmlElement(name = "ErrorMessage", required = false)
    protected String errorMessage;

    /**
     * Gets the value of the idHeaderQueryBillTo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDHeaderQueryBillTo() {
        return idHeaderQueryBillTo;
    }

    /**
     * Sets the value of the idHeaderQueryBillTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDHeaderQueryBillTo(String value) {
        this.idHeaderQueryBillTo = value;
    }

    /**
     * Gets the value of the idHeaderQueryShipTo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDHeaderQueryShipTo() {
        return idHeaderQueryShipTo;
    }

    /**
     * Sets the value of the idHeaderQueryShipTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDHeaderQueryShipTo(String value) {
        this.idHeaderQueryShipTo = value;
    }

    /**
     * Gets the value of the idHeaderQueryTrialIR property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDHeaderQueryTrialIR() {
        return idHeaderQueryTrialIR;
    }

    /**
     * Sets the value of the idHeaderQueryTrialIR property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDHeaderQueryTrialIR(String value) {
        this.idHeaderQueryTrialIR = value;
    }

    /**
     * Gets the value of the idHeaderQueryTrialwIR property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDHeaderQueryTrialwIR() {
        return idHeaderQueryTrialwIR;
    }

    /**
     * Sets the value of the idHeaderQueryTrialwIR property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDHeaderQueryTrialwIR(String value) {
        this.idHeaderQueryTrialwIR = value;
    }

    /**
     * Gets the value of the idHeaderQueryOffer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDHeaderQueryOffer() {
        return idHeaderQueryOffer;
    }

    /**
     * Sets the value of the idHeaderQueryOffer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDHeaderQueryOffer(String value) {
        this.idHeaderQueryOffer = value;
    }

    /**
     * Gets the value of the idHeaderQueryQuotes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDHeaderQueryQuotes() {
        return idHeaderQueryQuotes;
    }

    /**
     * Sets the value of the idHeaderQueryQuotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDHeaderQueryQuotes(String value) {
        this.idHeaderQueryQuotes = value;
    }

    /**
     * Gets the value of the idHeaderQueryQuotesOpportunityC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDHeaderQueryQuotesOpportunityC() {
        return idHeaderQueryQuotesOpportunityC;
    }

    /**
     * Sets the value of the idHeaderQueryQuotesOpportunityC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDHeaderQueryQuotesOpportunityC(String value) {
        this.idHeaderQueryQuotesOpportunityC = value;
    }

    /**
     * Gets the value of the idHeaderQueryOpportunity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDHeaderQueryOpportunity() {
        return idHeaderQueryOpportunity;
    }

    /**
     * Sets the value of the idHeaderQueryOpportunity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDHeaderQueryOpportunity(String value) {
        this.idHeaderQueryOpportunity = value;
    }

    /**
     * Gets the value of the idLineQueryShipTo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDLineQueryShipTo() {
        return idLineQueryShipTo;
    }

    /**
     * Sets the value of the idLineQueryShipTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDLineQueryShipTo(String value) {
        this.idLineQueryShipTo = value;
    }

    /**
     * Gets the value of the idLineQueryBillTo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDLineQueryBillTo() {
        return idLineQueryBillTo;
    }

    /**
     * Sets the value of the idLineQueryBillTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDLineQueryBillTo(String value) {
        this.idLineQueryBillTo = value;
    }

    /**
     * Gets the value of the idLineQueryShipment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDLineQueryShipment() {
        return idLineQueryShipment;
    }

    /**
     * Sets the value of the idLineQueryShipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDLineQueryShipment(String value) {
        this.idLineQueryShipment = value;
    }

    /**
     * Gets the value of the idLinePartNumber2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDLinePartNumber2() {
        return idLinePartNumber2;
    }

    /**
     * Sets the value of the idLinePartNumber2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDLinePartNumber2(String value) {
        this.idLinePartNumber2 = value;
    }

    /**
     * Gets the value of the idhdsfdcHeader property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDHDSFDCHeader() {
        return idhdsfdcHeader;
    }

    /**
     * Sets the value of the idhdsfdcHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDHDSFDCHeader(String value) {
        this.idhdsfdcHeader = value;
    }

    /**
     * Gets the value of the idAttachment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDAttachment() {
        return idAttachment;
    }

    /**
     * Sets the value of the idAttachment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDAttachment(String value) {
        this.idAttachment = value;
    }

    /**
     * Gets the value of the idNote property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDNote() {
        return idNote;
    }

    /**
     * Sets the value of the idNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDNote(String value) {
        this.idNote = value;
    }

    /**
     * Gets the value of the idldsfdcLine property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getIDLDSFDCLine() {
        return idldsfdcLine;
    }

    /**
     * Sets the value of the idldsfdcLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDLDSFDCLine(String value) {
        this.idldsfdcLine = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

}
