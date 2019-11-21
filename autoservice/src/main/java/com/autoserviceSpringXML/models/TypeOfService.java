package com.autoserviceSpringXML.models;

public class TypeOfService {
    private String description;

    public TypeOfService(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
