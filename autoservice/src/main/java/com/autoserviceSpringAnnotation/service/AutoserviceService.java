package com.autoserviceSpringAnnotation.service;

import com.autoserviceSpringAnnotation.models.TypeOfService;

import java.util.List;

public interface AutoserviceService {
    List<TypeOfService> getAvailableTypeOfService();
    void addTypeOfService(TypeOfService typeOfService);
    void printListOfServices();
}
