package com;

import java.io.IOException;

import static com.Role.*;

public class UserTest {
    public static void main(String[] args) throws IOException {
        User one = new User("Joe", "Dou", 25, ADMIN);
        User two = new User("Jane", "Dou", 24, ADMIN);
        User three = new User("Jake", "Dou", 8, SUPERUSER);
        User four = new User("Julia", "Dou", 8, USER);
        UserBase base = new UserBase();
        base.getUserList().add(one);
        base.getUserList().add(two);
        base.getUserList().add(three);
        base.getUserList().add(four);
//        getUserRoles();
        one.getRole().access();
        two.getRole().access();
        three.getRole().access();
//        System.out.println();
//        System.out.println(one.getRole());
//        System.out.println();
//        System.out.println(getUserRoleByType("admin1"));
        base.printUserByRole("admin");

    }
}
