
package com.xml.team18.sluzbenik.model;


import com.xml.team18.sluzbenik.model.zalba.cutanje.ZalbaCutanje;

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
 *         &lt;element ref="{}zalba-cutanje" maxOccurs="unbounded"/>
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
    "zalbaCutanje"
})
@XmlRootElement(name = "lista-zalbi-cutanje")
public class ListaZalbiCutanje {

    @XmlElement(name = "zalba-cutanje", required = true)
    protected List<ZalbaCutanje> zalbaCutanje;

    /**
     * Gets the value of the zalbaCutanje property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zalbaCutanje property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZalbaCutanje().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZalbaCutanje }
     * 
     * 
     */
    public List<ZalbaCutanje> getZalbaCutanje() {
        if (zalbaCutanje == null) {
            zalbaCutanje = new ArrayList<ZalbaCutanje>();
        }
        return this.zalbaCutanje;
    }

}
