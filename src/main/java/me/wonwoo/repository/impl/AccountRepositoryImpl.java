package me.wonwoo.repository.impl;

import com.querydsl.core.QueryResults;
import me.wonwoo.domain.*;
import me.wonwoo.repository.custom.CustomAccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.Arrays;
import java.util.List;

import static com.querydsl.core.QueryModifiers.limit;
import static jdk.nashorn.internal.objects.NativeArray.join;
import static org.apache.coyote.http11.Constants.a;

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
    QOrder order = QOrder.order;
    QOrderItem orderItem = QOrderItem.orderItem;
//    long l = from(account)
//      .join(account.orders, order).fetchCount();

    QueryResults<Account> accountSearchResults =
      from(account)
        .distinct()
//        .where(account.id.eq(1L))
        .innerJoin(account.orders, order).fetchJoin()
//        .join(order.orderItems,orderItem).fetchJoin()
//        .where(account.password.like("%" + password + "%"))
//        .offset(2)
//        .limit(2)
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
      .innerJoin(account.orders, order).fetchJoin()
      .fetch();
  }

  //  Hibernate: select account0_.account_id as account_1_0_, account0_.email as email2_0_, account0_.name as name3_0_, account0_.password as password4_0_ from account account0_ inner join orders orders1_ on account0_.account_id=orders1_.account_id
//  Hibernate: select account0_.account_id as account_1_0_0_, orders1_.order_id as order_id1_3_1_, account0_.email as email2_0_0_, account0_.name as name3_0_0_, account0_.password as password4_0_0_, orders1_.account_id as account_3_3_1_, orders1_.order_date as order_da2_3_1_, orders1_.account_id as account_3_3_0__, orders1_.order_id as order_id1_3_0__ from account account0_ inner join orders orders1_ on account0_.account_id=orders1_.account_id
//  Account(id=1, name=wonwoo, password=1PassWord, email=wonwoo@test.com)
//  Account(id=2, name=wonwoo, password=2PassWord11, email=123@test.com)
//  Account(id=1, name=wonwoo, password=1PassWord, email=wonwoo@test.com)
//  Account(id=3, name=kevin, password=3PassWord2, email=aaa@test.com)
  //select account0_.account_id as account_1_0_, account0_.email as email2_0_, account0_.name as name3_0_, account0_.password as password4_0_ from account account0_ inner join orders orders1_ on account0_.account_id=orders1_.account_id
  //select account0_.account_id as account_1_0_, account0_.email as email2_0_, account0_.name as name3_0_, account0_.password as password4_0_ from account account0_ inner join orders orders1_ on account0_.account_id=orders1_.account_id
  @Override
  public List<Account> findByleftJoinOrders() {
    QAccount account = QAccount.account;
    QOrder order = QOrder.order;
    return from(account)
      .distinct()
      .leftJoin(account.orders, order).fetchJoin()
      .orderBy(account.id.asc(), order.id.asc())
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