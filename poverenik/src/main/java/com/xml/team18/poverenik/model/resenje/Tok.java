package com.xml.team18.poverenik.model.resenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for Tok complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tok">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="izjava-zalbe" type="{}IzjavaZalbe"/>
 *         &lt;element name="uput-poverenika" type="{}UputPoverenika"/>
 *         &lt;element name="donosenje-odluke" type="{}DonosenjeOdluke"/>
 *         &lt;element name="drugi-dogadjaj" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Tok",
        propOrder = {"izjavaZalbe", "uputPoverenika", "donosenjeOdluke", "drugiDogadjaj"})
public class Tok {

    @XmlElement(name = "izjava-zalbe", required = true)
    protected IzjavaZalbe izjavaZalbe;

    @XmlElement(name = "uput-poverenika", required = true)
    protected UputPoverenika uputPoverenika;

    @XmlElement(name = "donosenje-odluke", required = true)
    protected DonosenjeOdluke donosenjeOdluke;

    @XmlElement(name = "drugi-dogadjaj", required = true)
    protected List<String> drugiDogadjaj;

    /**
     * Gets the value of the izjavaZalbe property.
     *
     * @return possible object is {@link IzjavaZalbe }
     */
    public IzjavaZalbe getIzjavaZalbe() {
        return izjavaZalbe;
    }

    /**
     * Sets the value of the izjavaZalbe property.
     *
     * @param value allowed object is {@link IzjavaZalbe }
     */
    public void setIzjavaZalbe(IzjavaZalbe value) {
        this.izjavaZalbe = value;
    }

    /**
     * Gets the value of the uputPoverenika property.
     *
     * @return possible object is {@link UputPoverenika }
     */
    public UputPoverenika getUputPoverenika() {
        return uputPoverenika;
    }

    /**
     * Sets the value of the uputPoverenika property.
     *
     * @param value allowed object is {@link UputPoverenika }
     */
    public void setUputPoverenika(UputPoverenika value) {
        this.uputPoverenika = value;
    }

    /**
     * Gets the value of the donosenjeOdluke property.
     *
     * @return possible object is {@link DonosenjeOdluke }
     */
    public DonosenjeOdluke getDonosenjeOdluke() {
        return donosenjeOdluke;
    }

    /**
     * Sets the value of the donosenjeOdluke property.
     *
     * @param value allowed object is {@link DonosenjeOdluke }
     */
    public void setDonosenjeOdluke(DonosenjeOdluke value) {
        this.donosenjeOdluke = value;
    }

    /**
     * Gets the value of the drugiDogadjaj property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is why
     * there is not a <CODE>set</CODE> method for the drugiDogadjaj property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getDrugiDogadjaj().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link String }
     */
    public List<String> getDrugiDogadjaj() {
        if (drugiDogadjaj == null) {
            drugiDogadjaj = new ArrayList<String>();
        }
        return this.drugiDogadjaj;
    }
}
