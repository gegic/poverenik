package com.xml.team18.poverenik.model.resenje;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for VrstaZalbe.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="VrstaZalbe">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="osnovana"/>
 *     &lt;enumeration value="neosnovana-zalba"/>
 *     &lt;enumeration value="neosnovan-zahtev"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "VrstaZalbe")
@XmlEnum
public enum VrstaZalbe {
  @XmlEnumValue("osnovana")
  OSNOVANA("osnovana"),
  @XmlEnumValue("neosnovana-zalba")
  NEOSNOVANA_ZALBA("neosnovana-zalba"),
  @XmlEnumValue("neosnovan-zahtev")
  NEOSNOVAN_ZAHTEV("neosnovan-zahtev");
  private final String value;

  VrstaZalbe(String v) {
    value = v;
  }

  public static VrstaZalbe fromValue(String v) {
    for (VrstaZalbe c : VrstaZalbe.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

  public String value() {
    return value;
  }
}
