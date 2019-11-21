package com.autoserviceSpringJavaConfigExclAnnotation.repository;

import com.autoserviceSpringJavaConfigExclAnnotation.models.TypeOfService;

import java.util.List;

public interface AutoserviceDAO {
    List<TypeOfService> getTypeOfService();
    void addTypeOfService(TypeOfService typeOfService);
}
