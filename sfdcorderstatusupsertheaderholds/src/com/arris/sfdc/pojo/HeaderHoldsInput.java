//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.01 at 02:12:15 PM IST 
//


package com.arris.sfdc.pojo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="HeaderHolds" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CurrencyIsoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Order_Header__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Activity_Name__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="External_ID__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Hold_Comment__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Hold_Created_By_Details__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Hold_Created_By__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Hold_Creation_Date__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Hold_Description__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Release_Comment__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Release_Reason_Code__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Released_By_Details__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Released_By__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Released_Date__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Released_Flag__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "headerHolds"
})
@XmlRootElement(name = "HeaderHoldsInput")
public class HeaderHoldsInput {

    @XmlElement(name = "HeaderHolds", required = true)
    protected List<HeaderHoldsInput.HeaderHolds> headerHolds;

    /**
     * Gets the value of the headerHolds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the headerHolds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHeaderHolds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HeaderHoldsInput.HeaderHolds }
     * 
     * 
     */
    public List<HeaderHoldsInput.HeaderHolds> getHeaderHolds() {
        if (headerHolds == null) {
            headerHolds = new ArrayList<HeaderHoldsInput.HeaderHolds>();
        }
        return this.headerHolds;
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
     *         &lt;element name="CurrencyIsoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Order_Header__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Activity_Name__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="External_ID__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Hold_Comment__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Hold_Created_By_Details__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Hold_Created_By__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Hold_Creation_Date__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Hold_Description__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Release_Comment__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Release_Reason_Code__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Released_By_Details__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Released_By__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Released_Date__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Released_Flag__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "currencyIsoCode",
        "orderHeaderC",
        "activityNameC",
        "externalIDC",
        "holdCommentC",
        "holdCreatedByDetailsC",
        "holdCreatedByC",
        "holdCreationDateC",
        "holdDescriptionC",
        "releaseCommentC",
        "releaseReasonCodeC",
        "releasedByDetailsC",
        "releasedByC",
        "releasedDateC",
        "releasedFlagC",
        "name"
    })
    public static class HeaderHolds {

        @XmlElement(name = "CurrencyIsoCode", required = false)
        protected String currencyIsoCode;
        @XmlElement(name = "Order_Header__c", required = false)
        protected String orderHeaderC;
        @XmlElement(name = "Activity_Name__c", required = false)
        protected String activityNameC;
        @XmlElement(name = "External_ID__c", required = false)
        protected String externalIDC;
        @XmlElement(name = "Hold_Comment__c", required = false)
        protected String holdCommentC;
        @XmlElement(name = "Hold_Created_By_Details__c", required = false)
        protected String holdCreatedByDetailsC;
        @XmlElement(name = "Hold_Created_By__c", required = false)
        protected String holdCreatedByC;
        @XmlElement(name = "Hold_Creation_Date__c", required = false)
        protected String holdCreationDateC;
        @XmlElement(name = "Hold_Description__c", required = false)
        protected String holdDescriptionC;
        @XmlElement(name = "Release_Comment__c", required = false)
        protected String releaseCommentC;
        @XmlElement(name = "Release_Reason_Code__c", required = false)
        protected String releaseReasonCodeC;
        @XmlElement(name = "Released_By_Details__c", required = false)
        protected String releasedByDetailsC;
        @XmlElement(name = "Released_By__c", required = false)
        protected String releasedByC;
        @XmlElement(name = "Released_Date__c", required = false)
        protected String releasedDateC;
        @XmlElement(name = "Released_Flag__c", required = false)
        protected String releasedFlagC;
        @XmlElement(name = "Name", required = false)
        protected String name;

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
         * Gets the value of the orderHeaderC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getOrderHeaderC() {
            return orderHeaderC;
        }

        /**
         * Sets the value of the orderHeaderC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setOrderHeaderC(String value) {
            this.orderHeaderC = value;
        }

        /**
         * Gets the value of the activityNameC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getActivityNameC() {
            return activityNameC;
        }

        /**
         * Sets the value of the activityNameC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setActivityNameC(String value) {
            this.activityNameC = value;
        }

        /**
         * Gets the value of the externalIDC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getExternalIDC() {
            return externalIDC;
        }

        /**
         * Sets the value of the externalIDC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setExternalIDC(String value) {
        	
        	
            this.externalIDC = value;
        }

        /**
         * Gets the value of the holdCommentC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getHoldCommentC() {
            return holdCommentC;
        }

        /**
         * Sets the value of the holdCommentC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setHoldCommentC(String value) {
            this.holdCommentC = value;
        }

        /**
         * Gets the value of the holdCreatedByDetailsC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getHoldCreatedByDetailsC() {
            return holdCreatedByDetailsC;
        }

        /**
         * Sets the value of the holdCreatedByDetailsC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setHoldCreatedByDetailsC(String value) {
            this.holdCreatedByDetailsC = value;
        }

        /**
         * Gets the value of the holdCreatedByC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getHoldCreatedByC() {
            return holdCreatedByC;
        }

        /**
         * Sets the value of the holdCreatedByC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setHoldCreatedByC(String value) {
            this.holdCreatedByC = value;
        }

        /**
         * Gets the value of the holdCreationDateC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getHoldCreationDateC() {
            return holdCreationDateC;
        }

        /**
         * Sets the value of the holdCreationDateC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         * @throws ParseException 
         *     
         */
        public void setHoldCreationDateC(String value) throws ParseException {
        	
            this.holdCreationDateC = value;
        }

        /**
         * Gets the value of the holdDescriptionC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getHoldDescriptionC() {
            return holdDescriptionC;
        }

        /**
         * Sets the value of the holdDescriptionC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setHoldDescriptionC(String value) {
            this.holdDescriptionC = value;
        }

        /**
         * Gets the value of the releaseCommentC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getReleaseCommentC() {
            return releaseCommentC;
        }

        /**
         * Sets the value of the releaseCommentC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setReleaseCommentC(String value) {
            this.releaseCommentC = value;
        }

        /**
         * Gets the value of the releaseReasonCodeC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getReleaseReasonCodeC() {
            return releaseReasonCodeC;
        }

        /**
         * Sets the value of the releaseReasonCodeC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setReleaseReasonCodeC(String value) {
            this.releaseReasonCodeC = value;
        }

        /**
         * Gets the value of the releasedByDetailsC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getReleasedByDetailsC() {
            return releasedByDetailsC;
        }

        /**
         * Sets the value of the releasedByDetailsC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setReleasedByDetailsC(String value) {
            this.releasedByDetailsC = value;
        }

        /**
         * Gets the value of the releasedByC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getReleasedByC() {
            return releasedByC;
        }

        /**
         * Sets the value of the releasedByC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setReleasedByC(String value) {
            this.releasedByC = value;
        }

        /**
         * Gets the value of the releasedDateC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getReleasedDateC() {
            return releasedDateC;
        }

        /**
         * Sets the value of the releasedDateC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         * @throws ParseException 
         *     
         */
        public void setReleasedDateC(String value) throws ParseException {
        	
            this.releasedDateC = value;
        }

        /**
         * Gets the value of the releasedFlagC property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public String getReleasedFlagC() {
            return releasedFlagC;
        }

        /**
         * Sets the value of the releasedFlagC property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setReleasedFlagC(String value) {
            this.releasedFlagC = value;
        }

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

    }

}