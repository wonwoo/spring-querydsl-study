package me.wonwoo.repository;

import me.wonwoo.domain.Item;
import me.wonwoo.dto.ItemDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.*;

/**
 * Created by wonwoo on 2016. 6. 15..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {

  @Autowired
  private ItemRepository itemRepository;

  @Test
  public void findByMaxTest(){
    Item max = itemRepository.findByMax();
    System.out.println(max);
  }

  @Test
  public void findBySubFromTest(){
    List<Item> bySubFrom = itemRepository.findBySubFrom();
    System.out.println(bySubFrom);
  }

  @Test
  public void findByTupleTest(){
    itemRepository.findByTuple();
  }

  @Test
  public void findByProjectionsTest(){
    List<ItemDto.NamePrice> namePrices = itemRepository.findByProjections();
    System.out.println(
      namePrices.stream()
      .map(String::valueOf)
      .collect(joining("\n"))
    );
  }
}