package me.wonwoo.controller;

import lombok.RequiredArgsConstructor;
import me.wonwoo.domain.Order;
import me.wonwoo.dto.OrderDto;
import me.wonwoo.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by wonwoo on 2016. 7. 2..
 */
@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderRepository orderRepository;

  private final ModelMapper modelMapper;

  @GetMapping("order")
  public List<OrderDto.Response> orders(){
    List<Order> orders = orderRepository.orders();
    return orders.stream().map(i -> modelMapper.map(i, OrderDto.Response.class)).collect(toList());
  }
}
