//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.16 at 03:28:02 PM IST 
//


package com.arris.sfdc.pojo;

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
 *         &lt;element name="Inputs" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="External_ID__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Available_Quantity__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Onhand_Quantity__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "inputs"
})
@XmlRootElement(name = "LineDetails")
public class LineDetails {

    @XmlElement(name = "Inputs", required = true)
    protected List<LineDetails.Inputs> inputs;

    /**
     * Gets the value of the inputs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineDetails.Inputs }
     * 
     * 
     */
    public List<LineDetails.Inputs> getInputs() {
        if (inputs == null) {
            inputs = new ArrayList<LineDetails.Inputs>();
        }
        return this.inputs;
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
     *         &lt;element name="Operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="External_ID__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Available_Quantity__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Onhand_Quantity__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "operation",
        "externalIDC",
        "availableQuantityC",
        "id",
        "onhandQuantityC"
    })
    public static class Inputs {

        @XmlElement(name = "Operation")
        protected String operation;
        @XmlElement(name = "External_ID__c")
        protected String externalIDC;
        @XmlElement(name = "Available_Quantity__c")
        protected String availableQuantityC;
        @XmlElement(name = "Id")
        protected String id;
        @XmlElement(name = "Onhand_Quantity__c")
        protected String onhandQuantityC;

        /**
         * Gets the value of the operation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOperation() {
            return operation;
        }

        /**
         * Sets the value of the operation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOperation(String value) {
            this.operation = value;
        }

        /**
         * Gets the value of the externalIDC property.
         * 
         * @return
         *     possible object is
         *     {@link String }
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
         *     {@link String }
         *     
         */
        public void setExternalIDC(String value) {
            this.externalIDC = value;
        }

        /**
         * Gets the value of the availableQuantityC property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAvailableQuantityC() {
            return availableQuantityC;
        }

        /**
         * Sets the value of the availableQuantityC property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAvailableQuantityC(String value) {
            this.availableQuantityC = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Gets the value of the onhandQuantityC property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOnhandQuantityC() {
            return onhandQuantityC;
        }

        /**
         * Sets the value of the onhandQuantityC property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOnhandQuantityC(String value) {
            this.onhandQuantityC = value;
        }

    }

}
