package me.wonwoo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sun.tools.doclint.Entity.or;

/**
 * Created by wonwoo on 2016. 6. 14..
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS")
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
  private List<OrderItem> orderItems = new ArrayList<>();

  @Temporal(TemporalType.TIMESTAMP)
  private Date orderDate;
}
