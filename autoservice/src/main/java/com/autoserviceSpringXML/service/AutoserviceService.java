package com.autoserviceSpringXML.service;

import com.autoserviceSpringXML.models.TypeOfService;

import java.util.List;

public interface AutoserviceService {
    List<TypeOfService> getAvailableTypeOfService();
    void addTypeOfService(TypeOfService typeOfService);
    void printListOfServices();
}
