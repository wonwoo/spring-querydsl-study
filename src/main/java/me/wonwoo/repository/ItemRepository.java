package me.wonwoo.repository;

import me.wonwoo.domain.Item;
import me.wonwoo.repository.custom.CustomItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wonwoo on 2016. 6. 15..
 */
public interface ItemRepository extends JpaRepository<Item, Long> , CustomItemRepository{
}
