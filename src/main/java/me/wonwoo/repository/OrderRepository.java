package me.wonwoo.repository;

import me.wonwoo.domain.Order;
import me.wonwoo.repository.custom.CustomOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wonwoo on 2016. 6. 14..
 */
public interface OrderRepository extends JpaRepository<Order, Long>, CustomOrderRepository {
}

