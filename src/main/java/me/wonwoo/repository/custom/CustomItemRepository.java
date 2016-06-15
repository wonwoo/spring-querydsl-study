package me.wonwoo.repository.custom;

import me.wonwoo.domain.Item;
import me.wonwoo.dto.ItemDto;

import java.util.List;

/**
 * Created by wonwoo on 2016. 6. 15..
 */
public interface CustomItemRepository {

  Item findByMax();

  List<Item> findBySubFrom();


  List<Item> findByTuple();

  List<ItemDto.NamePrice> findByProjections();
}
