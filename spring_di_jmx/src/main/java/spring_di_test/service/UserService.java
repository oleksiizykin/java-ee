package spring_di_test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring_di_test.dao.UserServiceDAOInterface;
import spring_di_test.model.User;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserService implements UserServiceInterface {

//    @Autowired
//    @Qualifier("userDAO")
//    private UserServiceDAOInterface userServiceDAO; /*=
//            new UserServiceDAO();*/

    @Resource
    @Qualifier("userDAO")
    private UserServiceDAOInterface userServiceDAO;

    public UserService() {
    }

    public UserService(UserServiceDAOInterface userServiceDAO) {
        this.userServiceDAO = userServiceDAO;
    }

    public void setUserServiceDAO(UserServiceDAOInterface userServiceDAO) {
        this.userServiceDAO = userServiceDAO;
    }

    public List<User> getAllUsers() {
        return userServiceDAO.getAllUsers();
    }
}
