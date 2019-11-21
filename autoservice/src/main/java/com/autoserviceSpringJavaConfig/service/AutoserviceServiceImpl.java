package com.autoserviceSpringJavaConfig.service;

import com.autoserviceSpringJavaConfig.models.TypeOfService;
import com.autoserviceSpringJavaConfig.repository.AutoserviceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("autoserviceService")
public class AutoserviceServiceImpl implements AutoserviceService {
    AutoserviceDAO autoserviceDAO;

    @Autowired
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
