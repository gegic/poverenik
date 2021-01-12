
package com.xml.team18.poverenik.model.zahtev;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for BiranjeZahteva complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BiranjeZahteva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="izbor" type="{}IzborZahteva" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BiranjeZahteva", propOrder = {
    "izbor"
})
public class BiranjeZahteva {

    @XmlElement(required = true)
    protected List<IzborZahteva> izbor;

    /**
     * Gets the value of the izbor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the izbor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIzbor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IzborZahteva }
     * 
     * 
     */
    public List<IzborZahteva> getIzbor() {
        if (izbor == null) {
            izbor = new ArrayList<IzborZahteva>();
        }
        return this.izbor;
    }

}
