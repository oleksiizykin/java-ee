package spring_di_test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_di_test.dao.UserServiceDAOInterface;
import spring_di_test.service.UserServiceInterface;

public class UserServiceSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-context-annotation.xml");
        UserServiceInterface userService = applicationContext.getBean("userService", UserServiceInterface.class);
        assert userService != null : "userService is null";
        UserServiceDAOInterface userDAO = applicationContext.getBean("userDAO", UserServiceDAOInterface.class);
        assert userDAO != null : "userDAO is null";
        System.out.println(userService.getAllUsers());
    }
}
