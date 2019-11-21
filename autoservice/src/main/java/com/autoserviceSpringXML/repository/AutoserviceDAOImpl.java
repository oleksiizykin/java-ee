package com.autoserviceSpringXML.repository;

import com.autoserviceSpringXML.models.TypeOfService;

import java.util.ArrayList;
import java.util.List;

public class AutoserviceDAOImpl implements AutoserviceDAO {

    private List<TypeOfService> typeOfService = new ArrayList<TypeOfService>();

    public List<TypeOfService> getTypeOfService() {
        return typeOfService;
    }

    public void addTypeOfService(TypeOfService typeOfService) {
        this.typeOfService.add(typeOfService);
    }
}
