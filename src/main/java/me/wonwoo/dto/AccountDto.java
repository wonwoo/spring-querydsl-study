package me.wonwoo.dto;

import lombok.Data;

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

  }
}
