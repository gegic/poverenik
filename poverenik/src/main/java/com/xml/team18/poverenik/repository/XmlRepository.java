package com.xml.team18.poverenik.repository;

import java.util.List;
import java.util.UUID;

public interface XmlRepository<T> {
    T save(T object);

    T findById(UUID uuid) throws Exception;

    List<T> getAll() throws Exception;

}
