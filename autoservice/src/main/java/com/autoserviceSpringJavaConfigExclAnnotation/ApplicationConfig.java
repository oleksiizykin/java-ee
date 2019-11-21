package com.autoserviceSpringJavaConfigExclAnnotation;

import com.autoserviceSpringJavaConfigExclAnnotation.repository.AutoserviceDAO;
import com.autoserviceSpringJavaConfigExclAnnotation.repository.AutoserviceDAOImpl;
import com.autoserviceSpringJavaConfigExclAnnotation.service.AutoserviceService;
import com.autoserviceSpringJavaConfigExclAnnotation.service.AutoserviceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.autoserviceSpringJavaConfig")
public class ApplicationConfig {

    @Bean
    public AutoserviceDAO autoserviceDAO(){
        return new AutoserviceDAOImpl();
    }

    @Bean
    public AutoserviceService autoserviceService(){
        return new AutoserviceServiceImpl(autoserviceDAO());
    }
}
