package com.service;

import com.domain.User;

public class UserService implements UserServiceInterface {
    private User originalUser = new User();
    private User clonedUser;

    public void closeUser() throws CloneNotSupportedException {
        clonedUser = (User) originalUser.clone();
    }

    public String printCloneUser() {
        return clonedUser == null ? "Clone is absent" : clonedUser.toString();
    }


}
