
package com.xml.team18.sluzbenik.model.obavestenje;

import com.xml.team18.sluzbenik.model.docs.Organ;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Dostavljeno complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Dostavljeno">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primalac" type="{}Organ" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dostavljeno", propOrder = {
        "primalac"
})
public class Dostavljeno {

    @XmlElement(required = true)
    protected List<String> primalac;

    /**
     * Gets the value of the primalac property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the primalac property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrimalac().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Organ }
     */
    public List<String> getPrimalac() {
        if (primalac == null) {
            primalac = new ArrayList<String>();
        }
        return this.primalac;
    }

}
