package com.autoserviceSpringJavaConfig.repository;

import com.autoserviceSpringJavaConfig.models.TypeOfService;

import java.util.List;

public interface AutoserviceDAO {
    List<TypeOfService> getTypeOfService();
    void addTypeOfService(TypeOfService typeOfService);
}
