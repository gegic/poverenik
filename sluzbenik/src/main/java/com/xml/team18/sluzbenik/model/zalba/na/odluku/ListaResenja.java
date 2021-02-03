
package com.xml.team18.sluzbenik.model.zalba.na.odluku;

import com.xml.team18.sluzbenik.model.resenje.Resenje;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resenje"
})
@XmlRootElement(name = "lista-resenjea")
public class ListaResenja {

    @XmlElement(required = true)
    protected List<Resenje> resenje;

    /**
     * Gets the value of the resenje property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resenje property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResenje().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Resenje }
     * 
     * 
     */
    public List<Resenje> getResenje() {
        if (resenje == null) {
            resenje = new ArrayList<Resenje>();
        }
        return this.resenje;
    }

}
