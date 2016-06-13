package me.wonwoo.repository;

import me.wonwoo.domain.Account;
import me.wonwoo.repository.custom.CustomAccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wonwoo on 2016. 6. 13..
 */
public interface AccountRepository extends JpaRepository<Account, Long>, CustomAccountRepository {
}
