package com;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@Repository("userDao")
public class UserDao {

    private EntityManager entityManager = Persistence.
            createEntityManagerFactory("NewPersistenceUnit").
            createEntityManager();
    private List<User> userList = Arrays.asList(new User(1, "xxx", "xxx"),
            new User(2, "yyy", "yyy"));

    public List getAllUsers() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("select u from UsersEntity u");
        List resultList = query.getResultList();
        transaction.commit();
        return userList;
    }
}
