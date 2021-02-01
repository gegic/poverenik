
package com.xml.team18.poverenik.model.korisnik;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.xml.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "imePrezime",
        "email",
        "lozinka",
        "uloga"
})
@XmlRootElement(name = "korisnik")
public class Korisnik implements UserDetails {

    @XmlElement(name = "ime-prezime", required = true)
    protected String imePrezime;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String lozinka;
    @XmlElement(required = true)
    protected String uloga;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the imePrezime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getImePrezime() {
        return imePrezime;
    }

    /**
     * Sets the value of the imePrezime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setImePrezime(String value) {
        this.imePrezime = value;
    }

    /**
     * Gets the value of the email property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the lozinka property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * Sets the value of the lozinka property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLozinka(String value) {
        this.lozinka = value;
    }

    /**
     * Gets the value of the uloga property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUloga() {
        return uloga;
    }

    /**
     * Sets the value of the uloga property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUloga(String value) {
        this.uloga = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    // vraca listu autoriteta, medjutim, to je samo uloga korisnika
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(new Authority(uloga)).collect(Collectors.toList());
    }

    /**
     * Vraca lozinku
     */
    @Override
    public String getPassword() {
        return lozinka;
    }

    /**
     * Vraca email umesto kor. imena
     */
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
