
package com.xml.team18.sluzbenik.model.izvestaj;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="odbijeni-zahtevi" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="prihvaceni-zahtevi" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="zalbe-cutanje" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="zalbe-na-odluku" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="godina" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "godisnja-statistika")
public class GodisnjaStatistika {

    @XmlAttribute(name = "odbijeni-zahtevi")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger odbijeniZahtevi;
    @XmlAttribute(name = "prihvaceni-zahtevi")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger prihvaceniZahtevi;
    @XmlAttribute(name = "zalbe-cutanje")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger zalbeCutanje;
    @XmlAttribute(name = "zalbe-na-odluku")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger zalbeNaOdluku;
    @XmlAttribute(name = "godina")
    protected Integer godina;

    /**
     * Gets the value of the odbijeniZahtevi property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOdbijeniZahtevi() {
        return odbijeniZahtevi;
    }

    /**
     * Sets the value of the odbijeniZahtevi property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOdbijeniZahtevi(BigInteger value) {
        this.odbijeniZahtevi = value;
    }

    /**
     * Gets the value of the prihvaceniZahtevi property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPrihvaceniZahtevi() {
        return prihvaceniZahtevi;
    }

    /**
     * Sets the value of the prihvaceniZahtevi property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPrihvaceniZahtevi(BigInteger value) {
        this.prihvaceniZahtevi = value;
    }

    /**
     * Gets the value of the zalbeCutanje property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getZalbeCutanje() {
        return zalbeCutanje;
    }

    /**
     * Sets the value of the zalbeCutanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setZalbeCutanje(BigInteger value) {
        this.zalbeCutanje = value;
    }

    /**
     * Gets the value of the zalbeNaOdluku property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getZalbeNaOdluku() {
        return zalbeNaOdluku;
    }

    /**
     * Sets the value of the zalbeNaOdluku property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setZalbeNaOdluku(BigInteger value) {
        this.zalbeNaOdluku = value;
    }

    /**
     * Gets the value of the godina property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGodina() {
        return godina;
    }

    /**
     * Sets the value of the godina property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGodina(Integer value) {
        this.godina = value;
    }

}
