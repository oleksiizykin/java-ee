package com.autoserviceSpringJavaConfig.repository;

import com.autoserviceSpringJavaConfig.models.TypeOfService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("autoserviceDAO")
public class AutoserviceDAOImpl implements AutoserviceDAO {

    private List<TypeOfService> typeOfService = new ArrayList<TypeOfService>();

    public List<TypeOfService> getTypeOfService() {
        return typeOfService;
    }

    public void addTypeOfService(TypeOfService typeOfService) {
        this.typeOfService.add(typeOfService);
    }
}
