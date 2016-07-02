package me.wonwoo.repository.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.FilteredClause;
import com.querydsl.jpa.JPQLQuery;
import me.wonwoo.domain.Order;
import me.wonwoo.domain.QAccount;
import me.wonwoo.domain.QOrder;
import me.wonwoo.repository.custom.CustomOrderRepository;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Created by wonwoo on 2016. 6. 14..
 */
public class OrderRepositoryImpl extends QueryDslRepositorySupport implements CustomOrderRepository {

  public OrderRepositoryImpl() {
    super(Order.class);
  }

  @Override
  public List<Order> orders() {
    QOrder order = QOrder.order;
    QAccount account = QAccount.account;
    return from(order)
      .leftJoin(order.account, account)//.fetchJoin()
      .fetch();
  }

  //@Override
//public List<Order> orders(Long id){
//  QOrder order = QOrder.order;
//  QAccount account = QAccount.account;
//  JPQLQuery query = from(order)
//    .leftJoin(order.account, account);
//
//  if(id != null){
//    query.where(account.id.goe(id));
//  }
//  return query
//    .fetchJoin().fetch();
//}
  @Override
  public List<Order> orders(Long id) {
    QOrder order = QOrder.order;
    QAccount account = QAccount.account;
    JPQLQuery query = from(order)
      .leftJoin(order.account, account).fetchJoin();

    BooleanBuilder booleanBuilder = new BooleanBuilder();

    if (id != null) {
      booleanBuilder.and(account.id.goe(id));
    }
    query.where(booleanBuilder);
    return query.fetch();
  }
}
