package me.wonwoo.repository;

import me.wonwoo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.*;

/**
 * Created by wonwoo on 2016. 6. 14..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderRepositoryTest {

  @Autowired
  private OrderRepository orderRepository;

  @Test
  public void ordersTest(){
    List<Order> orders = orderRepository.orders();
    System.out.println(
      orders.stream()
      .map(String::valueOf)
      .collect(joining("\n"))
    );
  }
  @Test
  public void ordersIdTest(){
    List<Order> orders = orderRepository.orders(2L);
    System.out.println(
      orders.stream()
        .map(String::valueOf)
        .collect(joining("\n"))
    );
  }
}