
package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.docs.Akt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Osnov complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Osnov">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zakon" type="{}Akt" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Osnov", propOrder = {
        "zakon"
})
public class Osnov {

    @XmlElement(required = true)
    protected List<Akt> zakon;

    /**
     * Gets the value of the zakon property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zakon property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZakon().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Akt }
     */
    public List<Akt> getZakon() {
        if (zakon == null) {
            zakon = new ArrayList<Akt>();
        }
        return this.zakon;
    }

}
