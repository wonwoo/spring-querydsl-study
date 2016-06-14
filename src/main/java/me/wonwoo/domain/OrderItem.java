package me.wonwoo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 6. 14..
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_ITEM")
@ToString(exclude = "item")
public class OrderItem {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ITEM_ID")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "ITEM_ID")
  private Item item;

  @ManyToOne
  @JoinColumn(name = "ORDER_ID")
  private Order order;

  private Integer orderPrice;

  private Integer count;
}