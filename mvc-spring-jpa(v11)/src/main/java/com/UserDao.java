package com;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository("userDao")
public class UserDao {

  @PersistenceContext
  private EntityManager entityManager;
//      = Persistence.createEntityManagerFactory("NewPersistenceUnit")
//      .createEntityManager();
  private List<User> userList = Arrays.asList(new User(1, "xxx", "yyy"),
      new User(2, "yyy", "ttt"));

  @Transactional
  public List getAllUser() {
//    EntityTransaction transaction = entityManager.getTransaction();
//    transaction.begin();
    Query query = entityManager.createQuery("select u from UsersEntity u");
    List userList = query.getResultList();
//    transaction.commit();
    return userList;
  }
}
