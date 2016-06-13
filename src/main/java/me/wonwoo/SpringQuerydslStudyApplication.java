package me.wonwoo;

import me.wonwoo.domain.Account;
import me.wonwoo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringQuerydslStudyApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringQuerydslStudyApplication.class, args);
  }


  @Autowired
  private AccountRepository accountRepository;

  @Bean
  public CommandLineRunner commandLineRunner() {
    return args ->
      Arrays.asList(
        new Account("wonwoo@test.com", "wonwoo", "1PassWord"),
        new Account("123@test.com", "wonwoo", "2PassWord11"),
        new Account("aaa@test.com", "kevin", "3PassWord2"),
        new Account("bbb@test.com", "ggg", "PassWord33"),
        new Account("ccc@test.com", "ggg", "PassWord44"),
        new Account("ddd@test.com", "keven", "PassWord5"),
        new Account("ggg@test.com", "qqqq", "PassWord6")
      ).forEach(accountRepository::save);
  }
}
