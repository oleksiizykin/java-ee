package com.autoserviceSpringXML.repository;

import com.autoserviceSpringXML.models.TypeOfService;

import java.util.List;

public interface AutoserviceDAO {
    List<TypeOfService> getTypeOfService();
    void addTypeOfService(TypeOfService typeOfService);
}
