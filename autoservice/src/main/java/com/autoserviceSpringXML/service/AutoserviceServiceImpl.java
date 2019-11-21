package com.autoserviceSpringXML.service;

import com.autoserviceSpringXML.models.TypeOfService;
import com.autoserviceSpringXML.repository.AutoserviceDAO;

import java.util.List;

public class AutoserviceServiceImpl implements AutoserviceService {
    AutoserviceDAO autoserviceDAO;


    public void setAutoserviceDAO(AutoserviceDAO autoserviceDAO) {
        this.autoserviceDAO = autoserviceDAO;
    }

    public List<TypeOfService> getAvailableTypeOfService() {
        return autoserviceDAO.getTypeOfService();
    }

    public void addTypeOfService(TypeOfService typeOfService) {
        autoserviceDAO.addTypeOfService(typeOfService);
    }

    public void printListOfServices() {
        System.out.println("List of services: " + "\n");
        for (TypeOfService typeOfService : autoserviceDAO.getTypeOfService()) {
            System.out.println(typeOfService);
        }
    }
}
