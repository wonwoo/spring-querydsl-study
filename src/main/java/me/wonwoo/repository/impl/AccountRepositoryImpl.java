package me.wonwoo.repository.impl;

import com.querydsl.core.QueryResults;
import me.wonwoo.domain.*;
import me.wonwoo.repository.custom.CustomAccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

import static jdk.nashorn.internal.objects.NativeArray.join;

/**
 * Created by wonwoo on 2016. 6. 13..
 */
public class AccountRepositoryImpl extends QueryDslRepositorySupport implements CustomAccountRepository {

  public AccountRepositoryImpl() {
    super(Account.class);
  }

  @Override
  public List<Account> findByname(String name) {
    QAccount account = QAccount.account;
    return from(account)
      .where(account.name.eq(name))
      .fetch();
  }

  @Override
  public Account findByemail(String email) {
    QAccount account = QAccount.account;
    return from(account)
      .where(account.email.eq(email))
      .fetchOne();
  }

  @Override
  public Account findByPasswordFirst(String password) {
    QAccount account = QAccount.account;
    return from(account)
      .where(account.password.like("%" + password + "%"))
      .fetchFirst();
  }

  @Override
  public Page<Account> findByPassword(String password, Pageable pageable) {
    QAccount account = QAccount.account;
    QueryResults<Account> accountSearchResults =
      from(account)
        .where(account.password.like("%" + password + "%"))
        .limit(pageable.getPageSize())
        .offset(pageable.getOffset())
        .fetchResults();
    return new PageImpl<>(accountSearchResults.getResults(), pageable, accountSearchResults.getTotal());
  }

  @Override
  public long findByAccount() {
    QAccount account = QAccount.account;
    return from(account)
      .fetchCount();
  }

  @Override
  public List<Account> findByInnerJoinOrders() {
    QAccount account = QAccount.account;
    QOrder order = QOrder.order;
    return from(account)
//  .innerJoin(account.orders, order)
      .join(account.orders, order)
      .fetch();
  }

  //select account0_.account_id as account_1_0_, account0_.email as email2_0_, account0_.name as name3_0_, account0_.password as password4_0_ from account account0_ inner join orders orders1_ on account0_.account_id=orders1_.account_id
  //select account0_.account_id as account_1_0_, account0_.email as email2_0_, account0_.name as name3_0_, account0_.password as password4_0_ from account account0_ inner join orders orders1_ on account0_.account_id=orders1_.account_id
  @Override
  public List<Account> findByleftJoinOrders() {
    QAccount account = QAccount.account;
    QOrder order = QOrder.order;
    return from(account)
      .leftJoin(account.orders, order)
      .fetch();
  }

  @Override
  public List<Account> findByRightJoinOrders() {
    QAccount account = QAccount.account;
    QOrder order = QOrder.order;
    return from(account)
      .rightJoin(account.orders, order)
      .fetch();
  }
}