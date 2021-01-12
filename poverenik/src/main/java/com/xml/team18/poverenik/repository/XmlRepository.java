package com.xml.team18.poverenik.repository;

import com.xml.team18.poverenik.model.resenje.Resenje;
import com.xml.team18.poverenik.model.zahtev.Zahtev;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public interface XmlRepository<T> {
    T save(T object);

    T findById(UUID uuid) throws Exception;

    List<T> getAll() throws Exception;

}
