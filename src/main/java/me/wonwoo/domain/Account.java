package me.wonwoo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wonwoo on 2016. 6. 12..
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
  private List<Order> orders;
//
//  public Account(String email, String name, String password) {
//    this.email = email;
//    this.name = name;
//    this.password = password;
//  }
}
