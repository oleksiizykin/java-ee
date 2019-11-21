package com;

import java.util.ArrayList;
import java.util.List;

public class UserBase {
    private List<User> userList = new ArrayList<User>();

    public List<User> getUserList() {
        return userList;
    }

    public void printUserByRole(String role) {
        int count = 0;
        for (User user : userList) {
            if (user.getRole().getType().equals(role)) {
                System.out.println(user.getName());
                count++;
            } else if (count == 0) {
                System.out.println("this role isn't exist");
            }
        }
    }
}
