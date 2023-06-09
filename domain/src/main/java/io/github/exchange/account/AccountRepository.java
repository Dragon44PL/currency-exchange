package io.github.exchange.account;

import io.github.exchange.account.vo.AccountId;

import java.util.Optional;

interface AccountRepository {
    Optional<Account> findById(AccountId id);
    void save(Account account);
}