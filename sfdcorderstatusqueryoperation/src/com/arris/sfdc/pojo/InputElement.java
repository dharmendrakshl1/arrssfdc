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
 *         &lt;element name="Header_SITE_INV_USE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Header_SITE_SHIP_USE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Header_Query_Replace_Opportunity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Header_Opportunity_Offer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line_SHIP_USE_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line_Bill_USE_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line_SHIP_VIA_CD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Line_ParNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HD_OrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="D_Attachment_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="D_Attachment_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="D_Note_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="D_Note_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LD_OrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Operation_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "headerSITEINVUSE",
    "headerSITESHIPUSE",
    "headerQueryReplaceOpportunity",
    "headerOpportunityOffer",
    "lineSHIPUSEID",
    "lineBillUSEID",
    "lineSHIPVIACD",
    "lineParNumber",
    "hdOrderNumber",
    "dAttachmentId",
    "dAttachmentName",
    "dNoteId",
    "dNoteName",
    "ldOrderNumber",
    "operationName"
})
@XmlRootElement(name = "InputElement")
public class InputElement {

    @XmlElement(name = "Header_SITE_INV_USE",required = false)
    protected String headerSITEINVUSE;
    @XmlElement(name = "Header_SITE_SHIP_USE",required = false)
    protected String headerSITESHIPUSE;
    @XmlElement(name = "Header_Query_Replace_Opportunity",required = false)
    protected String headerQueryReplaceOpportunity;
    @XmlElement(name = "Header_Opportunity_Offer",required = false)
    protected String headerOpportunityOffer;
    @XmlElement(name = "Line_SHIP_USE_ID",required = false)
    protected String lineSHIPUSEID;
    @XmlElement(name = "Line_Bill_USE_ID",required = false)
    protected String lineBillUSEID;
    @XmlElement(name = "Line_SHIP_VIA_CD",required = false)
    protected String lineSHIPVIACD;
    @XmlElement(name = "Line_ParNumber",required = false)
    protected String lineParNumber;
    @XmlElement(name = "HD_OrderNumber",required = false)
    protected String hdOrderNumber;
    @XmlElement(name = "D_Attachment_Id",required = false)
    protected String dAttachmentId;
    @XmlElement(name = "D_Attachment_Name",required = false)
    protected String dAttachmentName;
    @XmlElement(name = "D_Note_Id",required = false)
    protected String dNoteId;
    @XmlElement(name = "D_Note_Name",required = false)
    protected String dNoteName;
    @XmlElement(name = "LD_OrderNumber",required = false)
    protected String ldOrderNumber;
    @XmlElement(name = "Operation_Name", required = true)
    protected String operationName;

    /**
     * Gets the value of the headerSITEINVUSE property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getHeaderSITEINVUSE() {
        return headerSITEINVUSE;
    }

    /**
     * Sets the value of the headerSITEINVUSE property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHeaderSITEINVUSE(String value) {
        this.headerSITEINVUSE = value;
    }

    /**
     * Gets the value of the headerSITESHIPUSE property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getHeaderSITESHIPUSE() {
        return headerSITESHIPUSE;
    }

    /**
     * Sets the value of the headerSITESHIPUSE property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHeaderSITESHIPUSE(String value) {
        this.headerSITESHIPUSE = value;
    }

    /**
     * Gets the value of the headerQueryReplaceOpportunity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getHeaderQueryReplaceOpportunity() {
        return headerQueryReplaceOpportunity;
    }

    /**
     * Sets the value of the headerQueryReplaceOpportunity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHeaderQueryReplaceOpportunity(String value) {
        this.headerQueryReplaceOpportunity = value;
    }

    /**
     * Gets the value of the headerOpportunityOffer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getHeaderOpportunityOffer() {
        return headerOpportunityOffer;
    }

    /**
     * Sets the value of the headerOpportunityOffer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHeaderOpportunityOffer(String value) {
        this.headerOpportunityOffer = value;
    }

    /**
     * Gets the value of the lineSHIPUSEID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getLineSHIPUSEID() {
        return lineSHIPUSEID;
    }

    /**
     * Sets the value of the lineSHIPUSEID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLineSHIPUSEID(String value) {
        this.lineSHIPUSEID = value;
    }

    /**
     * Gets the value of the lineBillUSEID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getLineBillUSEID() {
        return lineBillUSEID;
    }

    /**
     * Sets the value of the lineBillUSEID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLineBillUSEID(String value) {
        this.lineBillUSEID = value;
    }

    /**
     * Gets the value of the lineSHIPVIACD property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getLineSHIPVIACD() {
        return lineSHIPVIACD;
    }

    /**
     * Sets the value of the lineSHIPVIACD property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLineSHIPVIACD(String value) {
        this.lineSHIPVIACD = value;
    }

    /**
     * Gets the value of the lineParNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getLineParNumber() {
        return lineParNumber;
    }

    /**
     * Sets the value of the lineParNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLineParNumber(String value) {
        this.lineParNumber = value;
    }

    /**
     * Gets the value of the hdOrderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getHDOrderNumber() {
        return hdOrderNumber;
    }

    /**
     * Sets the value of the hdOrderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHDOrderNumber(String value) {
        this.hdOrderNumber = value;
    }

    /**
     * Gets the value of the dAttachmentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getDAttachmentId() {
        return dAttachmentId;
    }

    /**
     * Sets the value of the dAttachmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDAttachmentId(String value) {
        this.dAttachmentId = value;
    }

    /**
     * Gets the value of the dAttachmentName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getDAttachmentName() {
        return dAttachmentName;
    }

    /**
     * Sets the value of the dAttachmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDAttachmentName(String value) {
        this.dAttachmentName = value;
    }

    /**
     * Gets the value of the dNoteId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getDNoteId() {
        return dNoteId;
    }

    /**
     * Sets the value of the dNoteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDNoteId(String value) {
        this.dNoteId = value;
    }

    /**
     * Gets the value of the dNoteName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getDNoteName() {
        return dNoteName;
    }

    /**
     * Sets the value of the dNoteName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDNoteName(String value) {
        this.dNoteName = value;
    }

    /**
     * Gets the value of the ldOrderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getLDOrderNumber() {
        return ldOrderNumber;
    }

    /**
     * Sets the value of the ldOrderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLDOrderNumber(String value) {
        this.ldOrderNumber = value;
    }

   
    public String getOperationName() {
        return operationName;
    }

    
    public void setOperationName(String value) {
        this.operationName = value;
    }

}
