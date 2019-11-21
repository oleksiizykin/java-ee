package spring_di_test.dao;


import org.springframework.stereotype.Repository;
import spring_di_test.model.User;

import java.util.Arrays;
import java.util.List;

@Repository("personDAO")
public class PersonServiceDAO implements UserServiceDAOInterface {
    private List<User> userList = Arrays.asList(new User("xxx", 12),
            new User("yyy", 13));

    public List<User> getAllUsers() {
        return userList;
    }
}
