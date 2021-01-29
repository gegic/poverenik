package com.xml.team18.sluzbenik.exceptions;

public class ResourceExistsException extends Exception {
    public ResourceExistsException(String resourceName, String resourceId) {
        super(String.format("%s with id %s already exists.", resourceName, resourceId));
    }
}
