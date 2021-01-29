package com.xml.team18.sluzbenik.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String resourceName, String resourceId) {
        super(String.format("%s with id %s not found.", resourceName, resourceId));
    }
}
