package com.xml.team18.sluzbenik.service;


import com.xml.team18.sluzbenik.exceptions.ResourceNotFoundException;

import javax.xml.bind.JAXBException;

public interface SluzbenikService<T> {
    String save(String rawXml) throws JAXBException;

    String getById(String id) throws ResourceNotFoundException, JAXBException;
}
