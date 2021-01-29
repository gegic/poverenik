package com.xml.team18.poverenik.service;

import com.xml.team18.poverenik.exceptions.ResourceNotFoundException;

import javax.xml.bind.JAXBException;

public interface PoverenikService<T> {
    String save(String rawXml) throws JAXBException;

    String getById(String id) throws ResourceNotFoundException, JAXBException;
}
