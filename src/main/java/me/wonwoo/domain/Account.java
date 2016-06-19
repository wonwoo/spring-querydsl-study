package me.wonwoo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonwoo on 2016. 6. 12..
 */
@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "orders")
public class Account {

  @Id
  @GeneratedValue
  @Column(name = "ACCOUNT_ID")
  private Long id;

  private String name;

  private String password;

  private String email;

  @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
  private List<Order> orders = new ArrayList<>();
//
//  public Account(String email, String name, String password) {
//    this.email = email;
//    this.name = name;
//    this.password = password;
//  }
}
