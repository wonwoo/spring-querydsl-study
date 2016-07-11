package me.wonwoo.repository;

import com.querydsl.core.types.dsl.StringPath;
import me.wonwoo.domain.Account;
import me.wonwoo.domain.QAccount;
import me.wonwoo.repository.custom.CustomAccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wonwoo on 2016. 6. 13..
 */
public interface AccountRepository extends QueryDslPredicateExecutor<Account>,
  QuerydslBinderCustomizer<QAccount>, JpaRepository<Account, Long>, CustomAccountRepository {

  @Override
  default void customize(QuerydslBindings bindings, QAccount user) {
    bindings.bind(user.name).first((path, value) -> path.eq(value));
    bindings.bind(String.class)
      .first((StringPath path, String value) -> path.containsIgnoreCase(value));
    bindings.excluding(user.password);
  }

  List<Account> findByusername(@Param("name") String name);

  @Query("select a from Account a where a.name = ?1")
  List<Account> findByusernames(String name);

  @Query(value = "select * from Account where name = ?1", nativeQuery = true)
  List<Account> findByusernamesQueryNative(String name);

  @Query(value = "select a from Account a where a.name = :name")
  List<Account> findByusernamesNamedQueryNative(@Param("name") String name);
}
