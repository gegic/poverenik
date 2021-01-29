package com.xml.team18.sluzbenik.repository;

import java.util.List;

public interface XmlRepository<T> {
    T save(T object);

    T findById(String id) throws Exception;

    List<T> getAll() throws Exception;

}
