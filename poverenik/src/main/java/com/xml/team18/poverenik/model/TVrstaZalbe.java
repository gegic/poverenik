
package com.xml.team18.poverenik.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TVrstaZalbe.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TVrstaZalbe">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="osnovana"/>
 *     &lt;enumeration value="neosnovana-zalba"/>
 *     &lt;enumeration value="neosnovan-zahtev"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TVrstaZalbe")
@XmlEnum
public enum TVrstaZalbe {

    @XmlEnumValue("osnovana")
    OSNOVANA("osnovana"),
    @XmlEnumValue("neosnovana-zalba")
    NEOSNOVANA_ZALBA("neosnovana-zalba"),
    @XmlEnumValue("neosnovan-zahtev")
    NEOSNOVAN_ZAHTEV("neosnovan-zahtev");
    private final String value;

    TVrstaZalbe(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TVrstaZalbe fromValue(String v) {
        for (TVrstaZalbe c: TVrstaZalbe.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
