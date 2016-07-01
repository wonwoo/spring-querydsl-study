package me.wonwoo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.*;

import static com.sun.tools.doclint.Entity.or;

/**
 * Created by wonwoo on 2016. 6. 14..
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS")
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"orderItems"})
public class Order {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "ACCOUNT_ID")
  private Account account;

  @OneToMany(mappedBy = "order")
  private List<OrderItem> orderItems;

  @Temporal(TemporalType.TIMESTAMP)
  private Date orderDate;
}
