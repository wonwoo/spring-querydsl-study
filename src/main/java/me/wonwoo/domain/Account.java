package me.wonwoo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 6. 12..
 */
@Entity
@Data
public class Account {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String email;
}
