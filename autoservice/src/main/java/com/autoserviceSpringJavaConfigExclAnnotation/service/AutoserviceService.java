package com.autoserviceSpringJavaConfigExclAnnotation.service;

import com.autoserviceSpringJavaConfigExclAnnotation.models.TypeOfService;
import com.autoserviceSpringJavaConfigExclAnnotation.repository.AutoserviceDAO;

import java.util.List;

public interface AutoserviceService {
    List<TypeOfService> getAvailableTypeOfService();
    void addTypeOfService(TypeOfService typeOfService);
    void printListOfServices();
}
