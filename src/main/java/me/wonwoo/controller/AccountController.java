package me.wonwoo.controller;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import me.wonwoo.domain.Account;
import me.wonwoo.dto.AccountDto;
import me.wonwoo.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by wonwoo on 2016. 6. 29..
 */

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountRepository accountRepository;

  private final ModelMapper modelMapper;

  @GetMapping("/accounts")
  public Page<AccountDto.Response> accounts(@QuerydslPredicate(root = Account.class) Predicate predicate,
                                Pageable pageable){
    Page<Account> all = accountRepository.findAll(predicate, pageable);
    List<AccountDto.Response> collect = all.getContent()
      .stream()
      .map(i -> modelMapper.map(i, AccountDto.Response.class)).collect(toList());

    return new PageImpl<>(collect, pageable, all.getTotalElements());
  }
}
