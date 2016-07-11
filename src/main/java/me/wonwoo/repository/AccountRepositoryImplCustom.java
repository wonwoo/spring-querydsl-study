package me.wonwoo.repository;

import me.wonwoo.domain.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by wonwoo on 2016. 7. 11..
 */
@Repository("accountRepositoryImplCustom")
public class AccountRepositoryImplCustom {

  @PersistenceContext
  private EntityManager entityManager;

  public List<Account> findByname(String name){
    return entityManager.createNamedQuery("Account.findByusername", Account.class)
      .setParameter("name", name)
      .getResultList();
  }
}