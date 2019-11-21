package spring_di_test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_di_test.dao.UserServiceDAOInterface;
import spring_di_test.service.UserServiceInterface;

public class UserServiceSpringTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-context.xml");
//        UserServiceInterface userService = applicationContext.getBean("userService1", UserServiceInterface.class);
//        assert userService != null : "userService is null";
//        UserServiceDAOInterface userDAO = applicationContext.getBean("userDao", UserServiceDAOInterface.class);
//        assert userDAO != null : "userDAO is null";
//
//        System.out.println(userService.getAllUsers());

        UserServiceInterface userService2 = applicationContext.getBean("userService2", UserServiceInterface.class);

        System.out.println(userService2.getAllUsers());
    }
}
