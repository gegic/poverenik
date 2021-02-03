
package com.xml.team18.poverenik.model;


import com.xml.team18.poverenik.model.zalba.na.odluku.ZalbaNaOdluku;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element ref="{}zalba-na-odluku" maxOccurs="unbounded"/>
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
    "zalbaNaOdluku"
})
@XmlRootElement(name = "lista-zalbi-na-odluku")
public class ListaZalbiNaOdluku {

    @XmlElement(name = "zalba-na-odluku", required = true)
    protected List<ZalbaNaOdluku> zalbaNaOdluku;

    /**
     * Gets the value of the zalbaNaOdluku property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zalbaNaOdluku property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZalbaNaOdluku().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZalbaNaOdluku }
     * 
     * 
     */
    public List<ZalbaNaOdluku> getZalbaNaOdluku() {
        if (zalbaNaOdluku == null) {
            zalbaNaOdluku = new ArrayList<ZalbaNaOdluku>();
        }
        return this.zalbaNaOdluku;
    }

}
