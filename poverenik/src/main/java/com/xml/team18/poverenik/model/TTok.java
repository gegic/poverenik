
package com.xml.team18.poverenik.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TTok complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TTok">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="izjava-zalbe" type="{}TIzjavaZalbe"/>
 *         &lt;element name="uput-poverenika" type="{}TUputPoverenika"/>
 *         &lt;element name="donosenje-odluke" type="{}TDonosenjeOdluke"/>
 *         &lt;element name="drugi-dogadjaj" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TTok", propOrder = {
    "izjavaZalbe",
    "uputPoverenika",
    "donosenjeOdluke",
    "drugiDogadjaj"
})
public class TTok {

    @XmlElement(name = "izjava-zalbe", required = true)
    protected TIzjavaZalbe izjavaZalbe;
    @XmlElement(name = "uput-poverenika", required = true)
    protected TUputPoverenika uputPoverenika;
    @XmlElement(name = "donosenje-odluke", required = true)
    protected TDonosenjeOdluke donosenjeOdluke;
    @XmlElement(name = "drugi-dogadjaj", required = true)
    protected List<String> drugiDogadjaj;

    /**
     * Gets the value of the izjavaZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link TIzjavaZalbe }
     *     
     */
    public TIzjavaZalbe getIzjavaZalbe() {
        return izjavaZalbe;
    }

    /**
     * Sets the value of the izjavaZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link TIzjavaZalbe }
     *     
     */
    public void setIzjavaZalbe(TIzjavaZalbe value) {
        this.izjavaZalbe = value;
    }

    /**
     * Gets the value of the uputPoverenika property.
     * 
     * @return
     *     possible object is
     *     {@link TUputPoverenika }
     *     
     */
    public TUputPoverenika getUputPoverenika() {
        return uputPoverenika;
    }

    /**
     * Sets the value of the uputPoverenika property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUputPoverenika }
     *     
     */
    public void setUputPoverenika(TUputPoverenika value) {
        this.uputPoverenika = value;
    }

    /**
     * Gets the value of the donosenjeOdluke property.
     * 
     * @return
     *     possible object is
     *     {@link TDonosenjeOdluke }
     *     
     */
    public TDonosenjeOdluke getDonosenjeOdluke() {
        return donosenjeOdluke;
    }

    /**
     * Sets the value of the donosenjeOdluke property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDonosenjeOdluke }
     *     
     */
    public void setDonosenjeOdluke(TDonosenjeOdluke value) {
        this.donosenjeOdluke = value;
    }

    /**
     * Gets the value of the drugiDogadjaj property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the drugiDogadjaj property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDrugiDogadjaj().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDrugiDogadjaj() {
        if (drugiDogadjaj == null) {
            drugiDogadjaj = new ArrayList<String>();
        }
        return this.drugiDogadjaj;
    }

}
