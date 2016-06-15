package me.wonwoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by wonwoo on 2016. 6. 15..
 */
public class ItemDto {

  @Data
  @AllArgsConstructor
  public static class NamePrice{
    private String name;
    private int price;
  }
}
