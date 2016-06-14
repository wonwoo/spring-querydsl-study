package me.wonwoo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 6. 14..
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

  @Id
  @GeneratedValue
  @Column(name = "ITEM_ID")
  private Long id;

  private String name;

  private Integer price;

  private Integer stockQuantity;
}