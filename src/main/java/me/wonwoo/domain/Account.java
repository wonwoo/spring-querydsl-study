package me.wonwoo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 6. 12..
 */
@Entity
@Data
@NoArgsConstructor
public class Account {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String password;

  private String email;

  public Account(String email, String name, String password) {
    this.email = email;
    this.name = name;
    this.password = password;
  }
}
