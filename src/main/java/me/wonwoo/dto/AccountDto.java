package me.wonwoo.dto;

import lombok.Data;

import java.time.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wonwoo on 2016. 6. 29..
 */
public class AccountDto {

  @Data
  public static class Response{

    private Long id;

    private String name;

    private String password;

    private String email;

    private LocalDateTime localDateTime;

    private ZonedDateTime zonedDateTime;

    private LocalDate localDate;

    private LocalTime localTime;

    private OffsetDateTime offsetDateTime;
    //n+1
    private List<Order> orders;
  }

  @Data
  public static class Order{

    private Long id;

    private Date orderDate;

//    private List<OrderItem> orderItems;
  }

  @Data
  public static class OrderItem{
    private Long id;
    private Integer orderPrice;
  }
}
