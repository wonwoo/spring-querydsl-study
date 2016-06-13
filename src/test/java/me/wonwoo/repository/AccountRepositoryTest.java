package me.wonwoo.repository;

import me.wonwoo.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.stream.Collectors.*;
import static me.wonwoo.domain.QAccount.account;
import static org.junit.Assert.assertEquals;

/**
 * Created by wonwoo on 2016. 6. 13..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

  @Autowired
  private AccountRepository accountRepository;

  @Test
  public void findBynameTest() {
    List<Account> accounts = accountRepository.findByname("wonwoo");
    System.out.println(
      accounts.stream()
        .map(String::valueOf)
        .collect(joining("\n"))
    );
  }

  @Test
  public void findByEmailTest(){
    Account account = accountRepository.findByemail("wonwoo@test.com");
    System.out.println(account);
    assertEquals(account.getName(),"wonwoo");
    assertEquals(account.getEmail(),"wonwoo@test.com");
  }

  @Test
  public void findByPasswordFirstTest(){
    Account account = accountRepository.findByPasswordFirst("PassWord1111");
    System.out.println(account);
//    assertEquals(account.getName(),"wonwoo");
//    assertEquals(account.getEmail(),"wonwoo@test.com");
  }

  @Test
  public void findByPasswordLikeTest(){
    Pageable pageable = new PageRequest(0, 2);
    Page<Account> accounts = accountRepository.findByPassword("PassWord", pageable);
    System.out.println(
      accounts.getContent().stream()
        .map(String::valueOf)
        .collect(joining("\n"))
    );

    Pageable pageable1 = new PageRequest(1, 2);
    Page<Account> accounts1 = accountRepository.findByPassword("PassWord", pageable1);
    System.out.println(
      accounts1.getContent().stream()
        .map(String::valueOf)
        .collect(joining("\n"))
    );
  }

  @Test
  public void findByAccountCountTest(){
    long count = accountRepository.findByAccount();
    System.out.println(count);
  }
}