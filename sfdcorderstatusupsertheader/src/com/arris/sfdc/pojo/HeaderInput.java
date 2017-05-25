//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.28 at 04:47:47 PM IST 
//


package com.arris.sfdc.pojo;

import java.text.ParseException;
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
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrencyIsoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Oracle_Order_Number__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Order_Created_Date__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Order_Entered_Date__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Organization_Code__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PO_Date__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PO_Number__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payment_Terms__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Price_List_Name__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Region__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sales_Rep__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ultimate_Ship_To_Address__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Opportunity__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PO_Received_Date__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Oracle_Order_Status__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ora_SFDC_Opportunity_Number__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Has_Line_Level_Holds__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Has_Order_Holds__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Order_Type__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Shipment_Terms__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CM_Prime__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Request_date__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Service_Rep__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Freight_Forwarder__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last_Update_Date__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Named_Place__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product_Family__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SOA_Email__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SOA_Name__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sales_Rep_Name__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Source__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Staged_Amount__c" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Trial_and_IR__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Offer__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VMI_PO_Header__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Request_Date_Type__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quote__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Number_HnM__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bill_To_Address__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ship_To_Address__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "name",
    "currencyIsoCode",
    "oracleOrderNumberC",
    "orderCreatedDateC",
    "orderEnteredDateC",
    "organizationCodeC",
    "poDateC",
    "poNumberC",
    "paymentTermsC",
    "priceListNameC",
    "regionC",
    "salesRepC",
    "ultimateShipToAddressC",
    "opportunityC",
    "poReceivedDateC",
    "oracleOrderStatusC",
    "oraSFDCOpportunityNumberC",
    "hasLineLevelHoldsC",
    "hasOrderHoldsC",
    "orderTypeC",
    "shipmentTermsC",
    "cmPrimeC",
    "customerRequestDateC",
    "customerServiceRepC",
    "freightForwarderC",
    "lastUpdateDateC",
    "namedPlaceC",
    "productFamilyC",
    "soaEmailC",
    "soaNameC",
    "salesRepNameC",
    "sourceC",
    "stagedAmountC",
    "trialAndIRC",
    "offerC",
    "vmipoHeaderC",
    "requestDateTypeC",
    "quoteC",
    "customerNumberHnMC",
    "billToAddressC",
    "shipToAddressC",
    "psaProjectC",
    "psaProjectC"
})
@XmlRootElement(name = "HeaderInput")
public class HeaderInput {

    @XmlElement(name = "Name", required = false)
    protected String name;
    @XmlElement(name = "CurrencyIsoCode", required = false)
    protected String currencyIsoCode;
    @XmlElement(name = "Oracle_Order_Number__c", required = false)
    protected String oracleOrderNumberC;
    @XmlElement(name = "Order_Created_Date__c", required = false)
    protected String orderCreatedDateC;
    @XmlElement(name = "Order_Entered_Date__c", required = false)
    protected String orderEnteredDateC;
    @XmlElement(name = "Organization_Code__c", required = false)
    protected String organizationCodeC;
    @XmlElement(name = "PO_Date__c", required = false)
    protected String poDateC;
    @XmlElement(name = "PO_Number__c", required = false)
    protected String poNumberC;
    @XmlElement(name = "Payment_Terms__c", required = false)
    protected String paymentTermsC;
    @XmlElement(name = "Price_List_Name__c", required = false)
    protected String priceListNameC;
    @XmlElement(name = "Region__c", required = false)
    protected String regionC;
    @XmlElement(name = "Sales_Rep__c", required = false)
    protected String salesRepC;
    @XmlElement(name = "Ultimate_Ship_To_Address__c", required = false)
    protected String ultimateShipToAddressC;
    @XmlElement(name = "Opportunity__c", required = false)
    protected String opportunityC;
    @XmlElement(name = "PO_Received_Date__c", required = false)
    protected String poReceivedDateC;
    @XmlElement(name = "Oracle_Order_Status__c", required = false)
    protected String oracleOrderStatusC;
    @XmlElement(name = "Ora_SFDC_Opportunity_Number__c", required = false)
    protected String oraSFDCOpportunityNumberC;
    @XmlElement(name = "Has_Line_Level_Holds__c", required = false)
    protected Boolean hasLineLevelHoldsC;
    @XmlElement(name = "Has_Order_Holds__c", required = false)
    protected Boolean hasOrderHoldsC;
    @XmlElement(name = "Order_Type__c", required = false)
    protected String orderTypeC;
    @XmlElement(name = "Shipment_Terms__c", required = false)
    protected String shipmentTermsC;
    @XmlElement(name = "CM_Prime__c", required = false)
    protected String cmPrimeC;
    @XmlElement(name = "Customer_Request_date__c", required = false)
    protected String customerRequestDateC;
    @XmlElement(name = "Customer_Service_Rep__c", required = false)
    protected String customerServiceRepC;
    @XmlElement(name = "Freight_Forwarder__c", required = false)
    protected String freightForwarderC;
    @XmlElement(name = "Last_Update_Date__c", required = false)
    protected String lastUpdateDateC;
    @XmlElement(name = "Named_Place__c", required = false)
    protected String namedPlaceC;
    @XmlElement(name = "Product_Family__c", required = false)
    protected String productFamilyC;
    @XmlElement(name = "SOA_Email__c", required = false)
    protected String soaEmailC;
    @XmlElement(name = "SOA_Name__c", required = false)
    protected String soaNameC;
    @XmlElement(name = "Sales_Rep_Name__c", required = false)
    protected String salesRepNameC;
    @XmlElement(name = "Source__c", required = false)
    protected String sourceC;
    @XmlElement(name = "Staged_Amount__c", required = false)
    protected String stagedAmountC;
    @XmlElement(name = "Trial_and_IR__c", required = false)
    protected String trialAndIRC;
    @XmlElement(name = "Offer__c", required = false)
    protected String offerC;
    @XmlElement(name = "VMI_PO_Header__c", required = false)
    protected String vmipoHeaderC;
    @XmlElement(name = "Request_Date_Type__c", required = false)
    protected String requestDateTypeC;
    @XmlElement(name = "Quote__c", required = false)
    protected String quoteC;
    @XmlElement(name = "Customer_Number_HnM__c", required = false)
    protected String customerNumberHnMC;
    @XmlElement(name = "Bill_To_Address__c", required = false)
    protected String billToAddressC;
    @XmlElement(name = "Ship_To_Address__c", required = false)
    protected String shipToAddressC;
    @XmlElement(name = "PSA_Project__c",  required = false)
    protected String psaProjectC;
    @XmlElement(name = "Corporate_Contract__c",  required = false)
    protected String corporateContractC;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the currencyIsoCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    /**
     * Sets the value of the currencyIsoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrencyIsoCode(String value) {
        this.currencyIsoCode = value;
    }

    /**
     * Gets the value of the oracleOrderNumberC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getOracleOrderNumberC() {
        return oracleOrderNumberC;
    }

    /**
     * Sets the value of the oracleOrderNumberC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOracleOrderNumberC(String value) {
        this.oracleOrderNumberC = value;
    }

    /**
     * Gets the value of the orderCreatedDateC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getOrderCreatedDateC() {
        return orderCreatedDateC;
    }

    /**
     * Sets the value of the orderCreatedDateC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     * @throws ParseException 
     *     
     */
    public void setOrderCreatedDateC(String value){
    	
    		this.orderCreatedDateC = value;
    	
    }

    /**
     * Gets the value of the orderEnteredDateC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getOrderEnteredDateC() {
        return orderEnteredDateC;
    }

    /**
     * Sets the value of the orderEnteredDateC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     * @throws ParseException 
     *     
     */
    public void setOrderEnteredDateC(String value) throws ParseException {
    	
    		this.orderEnteredDateC = value;
    	
    }

    /**
     * Gets the value of the organizationCodeC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getOrganizationCodeC() {
        return organizationCodeC;
    }

    /**
     * Sets the value of the organizationCodeC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrganizationCodeC(String value) {
        this.organizationCodeC = value;
    }

    /**
     * Gets the value of the poDateC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getPODateC() {
        return poDateC;
    }

    /**
     * Sets the value of the poDateC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     * @throws ParseException 
     *     
     */
    public void setPODateC(String value) throws ParseException {
    	
        this.orderCreatedDateC = value;
    }

    /**
     * Gets the value of the poNumberC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getPONumberC() {
        return poNumberC;
    }

    /**
     * Sets the value of the poNumberC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPONumberC(String value) {
        this.poNumberC = value;
    }

    /**
     * Gets the value of the paymentTermsC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getPaymentTermsC() {
        return paymentTermsC;
    }

    /**
     * Sets the value of the paymentTermsC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentTermsC(String value) {
        this.paymentTermsC = value;
    }

    /**
     * Gets the value of the priceListNameC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getPriceListNameC() {
        return priceListNameC;
    }

    /**
     * Sets the value of the priceListNameC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPriceListNameC(String value) {
        this.priceListNameC = value;
    }

    /**
     * Gets the value of the regionC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getRegionC() {
        return regionC;
    }

    /**
     * Sets the value of the regionC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRegionC(String value) {
        this.regionC = value;
    }

    /**
     * Gets the value of the salesRepC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getSalesRepC() {
        return salesRepC;
    }

    /**
     * Sets the value of the salesRepC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesRepC(String value) {
        this.salesRepC = value;
    }

    /**
     * Gets the value of the ultimateShipToAddressC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getUltimateShipToAddressC() {
        return ultimateShipToAddressC;
    }

    /**
     * Sets the value of the ultimateShipToAddressC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUltimateShipToAddressC(String value) {
        this.ultimateShipToAddressC = value;
    }

    /**
     * Gets the value of the opportunityC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getOpportunityC() {
        return opportunityC;
    }

    /**
     * Sets the value of the opportunityC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOpportunityC(String value) {
        this.opportunityC = value;
    }

    /**
     * Gets the value of the poReceivedDateC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getPOReceivedDateC() {
        return poReceivedDateC;
    }

    /**
     * Sets the value of the poReceivedDateC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPOReceivedDateC(String value) {
        this.poReceivedDateC = value;
    }

    /**
     * Gets the value of the oracleOrderStatusC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getOracleOrderStatusC() {
        return oracleOrderStatusC;
    }

    /**
     * Sets the value of the oracleOrderStatusC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOracleOrderStatusC(String value) {
        this.oracleOrderStatusC = value;
    }

    /**
     * Gets the value of the oraSFDCOpportunityNumberC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getOraSFDCOpportunityNumberC() {
        return oraSFDCOpportunityNumberC;
    }

    /**
     * Sets the value of the oraSFDCOpportunityNumberC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOraSFDCOpportunityNumberC(String value) {
        this.oraSFDCOpportunityNumberC = value;
    }

    /**
     * Gets the value of the hasLineLevelHoldsC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public Boolean getHasLineLevelHoldsC() {
        return hasLineLevelHoldsC;
    }

    /**
     * Sets the value of the hasLineLevelHoldsC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHasLineLevelHoldsC(String value) {
    	boolean valueBoolean = Boolean.parseBoolean(value);
        this.hasLineLevelHoldsC = valueBoolean;
    }

    /**
     * Gets the value of the hasOrderHoldsC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public Boolean getHasOrderHoldsC() {
        return hasOrderHoldsC;
    }

    /**
     * Sets the value of the hasOrderHoldsC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHasOrderHoldsC(String value) {
    	boolean valueBoolean = Boolean.parseBoolean(value);
        this.hasLineLevelHoldsC = valueBoolean;
    }

    /**
     * Gets the value of the orderTypeC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getOrderTypeC() {
        return orderTypeC;
    }

    /**
     * Sets the value of the orderTypeC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderTypeC(String value) {
        this.orderTypeC = value;
    }

    /**
     * Gets the value of the shipmentTermsC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getShipmentTermsC() {
        return shipmentTermsC;
    }

    /**
     * Sets the value of the shipmentTermsC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipmentTermsC(String value) {
        this.shipmentTermsC = value;
    }

    /**
     * Gets the value of the cmPrimeC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getCMPrimeC() {
        return cmPrimeC;
    }

    /**
     * Sets the value of the cmPrimeC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCMPrimeC(String value) {
        this.cmPrimeC = value;
    }

    /**
     * Gets the value of the customerRequestDateC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getCustomerRequestDateC() {
        return customerRequestDateC;
    }

    /**
     * Sets the value of the customerRequestDateC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerRequestDateC(String value) {
        this.customerRequestDateC = value;
    }

    /**
     * Gets the value of the customerServiceRepC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getCustomerServiceRepC() {
        return customerServiceRepC;
    }

    /**
     * Sets the value of the customerServiceRepC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerServiceRepC(String value) {
        this.customerServiceRepC = value;
    }

    /**
     * Gets the value of the freightForwarderC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getFreightForwarderC() {
        return freightForwarderC;
    }

    /**
     * Sets the value of the freightForwarderC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFreightForwarderC(String value) {
        this.freightForwarderC = value;
    }

    /**
     * Gets the value of the lastUpdateDateC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getLastUpdateDateC() {
        return lastUpdateDateC;
    }

    /**
     * Sets the value of the lastUpdateDateC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     * @throws ParseException 
     *     
     */
    public void setLastUpdateDateC(String value) throws ParseException {
    	
        this.orderCreatedDateC = value;
    }

    /**
     * Gets the value of the namedPlaceC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getNamedPlaceC() {
        return namedPlaceC;
    }

    /**
     * Sets the value of the namedPlaceC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNamedPlaceC(String value) {
        this.namedPlaceC = value;
    }

    /**
     * Gets the value of the productFamilyC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getProductFamilyC() {
        return productFamilyC;
    }

    /**
     * Sets the value of the productFamilyC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductFamilyC(String value) {
        this.productFamilyC = value;
    }

    /**
     * Gets the value of the soaEmailC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getSOAEmailC() {
        return soaEmailC;
    }

    /**
     * Sets the value of the soaEmailC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSOAEmailC(String value) {
        this.soaEmailC = value;
    }

    /**
     * Gets the value of the soaNameC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getSOANameC() {
        return soaNameC;
    }

    /**
     * Sets the value of the soaNameC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSOANameC(String value) {
        this.soaNameC = value;
    }

    /**
     * Gets the value of the salesRepNameC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getSalesRepNameC() {
        return salesRepNameC;
    }

    /**
     * Sets the value of the salesRepNameC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSalesRepNameC(String value) {
        this.salesRepNameC = value;
    }

    /**
     * Gets the value of the sourceC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getSourceC() {
        return sourceC;
    }

    /**
     * Sets the value of the sourceC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceC(String value) {
        this.sourceC = value;
    }

    /**
     * Gets the value of the stagedAmountC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public String getStagedAmountC() {
        return stagedAmountC;
    }

    /**
     * Sets the value of the stagedAmountC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setStagedAmountC(String value) {
        this.stagedAmountC = value;
    }

    /**
     * Gets the value of the trialAndIRC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getTrialAndIRC() {
        return trialAndIRC;
    }

    /**
     * Sets the value of the trialAndIRC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrialAndIRC(String value) {
        this.trialAndIRC = value;
    }

    /**
     * Gets the value of the offerC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getOfferC() {
        return offerC;
    }

    /**
     * Sets the value of the offerC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOfferC(String value) {
        this.offerC = value;
    }

    /**
     * Gets the value of the vmipoHeaderC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getVMIPOHeaderC() {
        return vmipoHeaderC;
    }

    /**
     * Sets the value of the vmipoHeaderC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVMIPOHeaderC(String value) {
        this.vmipoHeaderC = value;
    }

    /**
     * Gets the value of the requestDateTypeC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getRequestDateTypeC() {
        return requestDateTypeC;
    }

    /**
     * Sets the value of the requestDateTypeC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRequestDateTypeC(String value) {
        this.requestDateTypeC = value;
    }

    /**
     * Gets the value of the quoteC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getQuoteC() {
        return quoteC;
    }

    /**
     * Sets the value of the quoteC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQuoteC(String value) {
        this.quoteC = value;
    }

    /**
     * Gets the value of the customerNumberHnMC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getCustomerNumberHnMC() {
        return customerNumberHnMC;
    }

    /**
     * Sets the value of the customerNumberHnMC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerNumberHnMC(String value) {

    	
    	this.customerNumberHnMC = value;
    }

    /**
     * Gets the value of the billToAddressC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getBillToAddressC() {
        return billToAddressC;
    }

    /**
     * Sets the value of the billToAddressC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillToAddressC(String value) {
        this.billToAddressC = value;
    }

    /**
     * Gets the value of the shipToAddressC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getShipToAddressC() {
        return shipToAddressC;
    }

    /**
     * Sets the value of the shipToAddressC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipToAddressC(String value) {
        this.shipToAddressC = value;
    }
    
    /**
     * Gets the value of the psaProjectC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getPSAProjectC() {
        return psaProjectC;
    }

    /**
     * Sets the value of the psaProjectC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPSAProjectC(String value) {
        this.psaProjectC = value;
    }

    /**
     * Gets the value of the corporateContractC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public String getCorporateContractC() {
        return corporateContractC;
    }

    /**
     * Sets the value of the corporateContractC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCorporateContractC(String value) {
        this.corporateContractC = value;
    }

}
