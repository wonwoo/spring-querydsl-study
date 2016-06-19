package me.wonwoo.repository.custom;

import me.wonwoo.domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by wonwoo on 2016. 6. 13..
 */
public interface CustomAccountRepository {

  List<Account> findByname(String name);

  Account findByemail(String email);

  Account findByPasswordFirst(String password);

  Page<Account> findByPassword(String password, Pageable pageable);

  long findByAccount();

  List<Account> findByInnerJoinOrders();

  List<Account> findByleftJoinOrders();

  List<Account> findByRightJoinOrders();
}
