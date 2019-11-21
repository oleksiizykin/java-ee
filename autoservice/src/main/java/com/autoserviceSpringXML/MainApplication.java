package com.autoserviceSpringXML;

import com.autoserviceSpringXML.models.TypeOfService;
import com.autoserviceSpringXML.service.AutoserviceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");

        AutoserviceService service = applicationContext.getBean("autoserviceService", AutoserviceService.class);
        service.addTypeOfService(new TypeOfService("Oil and Oil Filter Service"));
        service.addTypeOfService(new TypeOfService("Cooling System Service"));
        service.addTypeOfService(new TypeOfService("Air Conditioning Service"));
        service.addTypeOfService(new TypeOfService("Driveline Service"));
        service.addTypeOfService(new TypeOfService("Fuel/Air Induction Cleanup"));
        service.addTypeOfService(new TypeOfService("Power Steering Flush"));
        service.addTypeOfService(new TypeOfService("Transmission Service"));

        service.printListOfServices();


    }
}
