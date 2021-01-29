
package com.xml.team18.poverenik.model.resenje;

import com.xml.team18.poverenik.model.docs.Organ;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Obavestiti complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Obavestiti">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primalac" type="{}Organ" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="rok" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Obavestiti", propOrder = {
        "primalac"
})
public class Obavestiti {

    @XmlElement(required = true)
    protected List<Organ> primalac;
    @XmlAttribute(name = "rok", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger rok;

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
    public List<Organ> getPrimalac() {
        if (primalac == null) {
            primalac = new ArrayList<Organ>();
        }
        return this.primalac;
    }

    /**
     * Gets the value of the rok property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getRok() {
        return rok;
    }

    /**
     * Sets the value of the rok property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setRok(BigInteger value) {
        this.rok = value;
    }

}
