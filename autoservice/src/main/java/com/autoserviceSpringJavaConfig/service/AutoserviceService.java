package com.autoserviceSpringJavaConfig.service;

import com.autoserviceSpringJavaConfig.models.TypeOfService;

import java.util.List;

public interface AutoserviceService {
    List<TypeOfService> getAvailableTypeOfService();
    void addTypeOfService(TypeOfService typeOfService);
    void printListOfServices();
}
