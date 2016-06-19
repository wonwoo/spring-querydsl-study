package me.wonwoo.repository.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import me.wonwoo.domain.Item;
import me.wonwoo.domain.QItem;
import me.wonwoo.dto.ItemDto;
import me.wonwoo.repository.custom.CustomItemRepository;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Created by wonwoo on 2016. 6. 15..
 */
public class ItemRepositoryImpl extends QueryDslRepositorySupport implements CustomItemRepository {

  public ItemRepositoryImpl() {
    super(Item.class);
  }

  @Override
  public Item findByMax() {
    QItem item = QItem.item;
    QItem itemSub = QItem.item;
    return from(item)
      .where(item.price.eq(
        JPAExpressions.select(itemSub.price.max()).from(itemSub)
      )).fetchOne();
  }


  //TODO
  public List<Item> findBySubFrom() {
    QItem item = QItem.item;
    QItem itemSub = QItem.item;
    JPQLQuery<Item> where = JPAExpressions.select(item)
      .from(itemSub)
      .where(itemSub.price.gt(1000).as("sub"));
    EntityPathBase<Item> path = new EntityPathBase<>(Item.class,"c");
    return from(path).where(item.id.goe(3)).fetch();
  }


  //  SELECT
//  *
//  FROM
//    (
//      SELECT
//        ITEM_ID, NAME
//        FROM
//      ITEM
//        WHERE PRICE < 1000) as a
//  WHERE a.ITEM_ID <=3;
  @Override
  public List<Item> findByTuple() {
    QItem item = QItem.item;
    List<Tuple> fetch = from(item).select(item.name, item.price).fetch();
    fetch.stream().forEach(i -> {
      System.out.println(i.get(item.name));
      System.out.println(i.get(item.price));
    });

    return null;
  }

  @Override
  public List<ItemDto.NamePrice> findByProjections() {
    QItem item = QItem.item;
    ConstructorExpression<ItemDto.NamePrice> constructor =
      Projections.constructor(ItemDto.NamePrice.class, item.name, item.price);
    return from(item).select(constructor).fetch();
  }
}
