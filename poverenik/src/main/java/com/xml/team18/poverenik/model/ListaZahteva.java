
package com.xml.team18.poverenik.model;

import com.xml.team18.poverenik.model.zahtev.Zahtev;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}zahtev" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zahtev"
})
@XmlRootElement(name = "lista-zahteva")
public class ListaZahteva {

    @XmlElement(required = true)
    protected List<Zahtev> zahtev;

    /**
     * Gets the value of the zahtev property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zahtev property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZahtev().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Zahtev }
     * 
     * 
     */
    public List<Zahtev> getZahtev() {
        if (zahtev == null) {
            zahtev = new ArrayList<Zahtev>();
        }
        return this.zahtev;
    }

}
