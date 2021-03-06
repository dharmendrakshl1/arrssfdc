//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.12 at 12:35:46 AM IST 
//


package com.arris.sfdc.pojo;

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
 *         &lt;element name="CurrencyDetails" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ConversionRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
@XmlType(name = "", propOrder = {"currencyDetails"})
@XmlRootElement(name = "InputElement")
public class InputElement {

    @XmlElement(name = "CurrencyDetails", required = true)
    protected List<InputElement.CurrencyDetails> currencyDetails;

    /**
     * Gets the value of the currencyDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currencyDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrencyDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputElement.CurrencyDetails }
     * 
     * 
     */
    public List<InputElement.CurrencyDetails> getCurrencyDetails() {
        if (currencyDetails == null) {
            currencyDetails = new ArrayList<InputElement.CurrencyDetails>();
        }
        return this.currencyDetails;
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
     *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ConversionRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        "id",
        "conversionRate"
    })
    public static class CurrencyDetails {

    	@XmlElement(name = "Id", required = false)
        protected String id;
        
    	@XmlElement(name = "ConversionRate", required = false)
        protected Double conversionRate;

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
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
         *     {@link JAXBElement }{@code <}{@link String }{@code >}
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Gets the value of the conversionRate property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link Double }{@code >}
         *     
         */
        public Double getConversionRate() {
            return conversionRate;
        }

        /**
         * Sets the value of the conversionRate property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link Double }{@code >}
         *     
         */
        public void setConversionRate(Double value) {
            this.conversionRate = value;
        }

		@Override
		public String toString() {
			return "CurrencyDetails [id=" + id + ", conversionRate="
					+ conversionRate + "]";
		}
    }

}
