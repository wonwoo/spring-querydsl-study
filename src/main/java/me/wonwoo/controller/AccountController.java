package me.wonwoo.controller;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import me.wonwoo.domain.Account;
import me.wonwoo.dto.AccountDto;
import me.wonwoo.repository.AccountRepository;
import me.wonwoo.repository.AccountRepositoryImplCustom;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by wonwoo on 2016. 6. 29..
 */

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountRepository accountRepository;

  private final AccountRepositoryImplCustom accountRepositoryImplCustom;
  private final ModelMapper modelMapper;

  @GetMapping("/post")
  public void save(){
    Account account = new Account();
    account.setName("tt");
    account.setEmail("123");
    account.setPassword("111");
    account.setLocalDateTime(LocalDateTime.now());
    account.setLocalTime(LocalTime.now());
    account.setLocalDate(LocalDate.now());
    account.setZonedDateTime(ZonedDateTime.now());
    account.setOffsetDateTime(OffsetDateTime.now());
    accountRepository.save(account);
  }

  @GetMapping("/accounts")
  public Page<AccountDto.Response> accounts(@QuerydslPredicate(root = Account.class) Predicate predicate,
                                Pageable pageable){
    Page<Account> all = accountRepository.findAll(predicate, pageable);
    List<AccountDto.Response> collect = all.getContent()
      .stream()
      .map(i -> modelMapper.map(i, AccountDto.Response.class)).collect(toList());

    return new PageImpl<>(collect, pageable, all.getTotalElements());
  }

  @GetMapping("/accounts/password")
  public Page<AccountDto.Response> accounts(Pageable pageable){
    Page<Account> all = accountRepository.findByPassword("PassWord", pageable);
    List<AccountDto.Response> collect = all
              .getContent()
              .stream()
              .map(i -> modelMapper.map(i, AccountDto.Response.class)).collect(toList());

    return new PageImpl<>(collect, pageable, all.getTotalElements());
  }

  @GetMapping("/accounts/join")
  public List<AccountDto.Response> accounts(){
    List<Account> all = accountRepository.findByleftJoinOrders();
    List<AccountDto.Response> collect = all
      .stream()
      .map(i -> modelMapper.map(i, AccountDto.Response.class)).collect(toList());
    return collect;
  }

  @GetMapping("/accounts/findByname")
  public List<AccountDto.Response> findByname(@RequestParam String name){
    List<Account> all = accountRepositoryImplCustom.findByname(name);
    List<AccountDto.Response> collect = all
      .stream()
      .map(i -> modelMapper.map(i, AccountDto.Response.class)).collect(toList());
    return collect;
  }

  @GetMapping("/accounts/findByusernames")
  public List<AccountDto.Response> findByusernames(@RequestParam String name){
    List<Account> all = accountRepository.findByusernames(name);
    List<AccountDto.Response> collect = all
      .stream()
      .map(i -> modelMapper.map(i, AccountDto.Response.class)).collect(toList());
    return collect;
  }

  @GetMapping("/accounts/findByusername")
  public List<AccountDto.Response> findByusername(@RequestParam String name){
    List<Account> all = accountRepository.findByusername(name);
    List<AccountDto.Response> collect = all
      .stream()
      .map(i -> modelMapper.map(i, AccountDto.Response.class)).collect(toList());
    return collect;
  }

  @GetMapping("/accounts/findByusernamesQueryNative")
  public List<AccountDto.Response> findByusernamesQueryNative(@RequestParam String name){
    List<Account> all = accountRepository.findByusernamesQueryNative(name);
    List<AccountDto.Response> collect = all
      .stream()
      .map(i -> modelMapper.map(i, AccountDto.Response.class)).collect(toList());
    return collect;
  }
  @GetMapping("/accounts/findByusernamesNamedQueryNative")
  public List<AccountDto.Response> findByusernamesNamedQueryNative(@RequestParam String name){
    List<Account> all = accountRepository.findByusernamesNamedQueryNative(name);
    List<AccountDto.Response> collect = all
      .stream()
      .map(i -> modelMapper.map(i, AccountDto.Response.class)).collect(toList());
    return collect;
  }

}
