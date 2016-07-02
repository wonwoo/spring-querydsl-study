package me.wonwoo.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by wonwoo on 2016. 7. 2..
 */
public class OrderDto {

  @Data
  public static class Response {
    private Long id;
    private Date orderDate;
    private Account account;
  }

  @Data
  public static class Account {
    private Long id;
    private String name;
    private String email;
  }
}
