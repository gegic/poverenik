package com.xml.team18.sluzbenik.dto;

import com.xml.team18.sluzbenik.model.izjasnjenje.Izjasnjenje;
import com.xml.team18.sluzbenik.model.izvestaj.GodisnjaStatistika;
import com.xml.team18.sluzbenik.model.izvestaj.Izvestaj;
import com.xml.team18.sluzbenik.model.obavestenje.Obavestenje;
import com.xml.team18.sluzbenik.model.zahtev.Zahtev;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({Zahtev.class, Obavestenje.class, Izjasnjenje.class, Izvestaj.class, GodisnjaStatistika.class})
public class EntityList<T> {

    private List<T> listOfEntityObjects;

    public EntityList() {
        listOfEntityObjects = new ArrayList<T>();
    }

    public EntityList(List<T> listOfEntityObjects) {
        this.listOfEntityObjects = listOfEntityObjects;
    }

    @XmlAnyElement
    public List<T> getItems() {
        return listOfEntityObjects;
    }
}