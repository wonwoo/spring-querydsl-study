package me.wonwoo.repository.custom;

import me.wonwoo.domain.Order;

import java.util.List;

/**
 * Created by wonwoo on 2016. 6. 14..
 */
public interface CustomOrderRepository {

  List<Order> orders();

  List<Order> orders(Long id);
}
