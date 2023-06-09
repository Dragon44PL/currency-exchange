package io.github.exchange.account;

import io.github.exchange.account.command.AccountCreateCommand;
import io.github.exchange.account.command.BalanceUpdateCommand;
import io.github.exchange.account.vo.AccountId;
import io.github.exchange.account.vo.Balance;
import io.github.exchange.finance.Money;
import io.github.exchange.user.UserId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Currency;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class Account {

    private AccountId accountId;
    private UserId userId;
    private Currency currency;
    private Balance balance;

    public static Account create(final AccountCreateCommand accountCreateCommand) {
        return new Account(accountCreateCommand.accountId(), accountCreateCommand.userId(), accountCreateCommand.currency(), Balance.zero(accountCreateCommand.currency()));
    }

    public void updateBalance(final BalanceUpdateCommand balanceUpdateCommand) {
        final Money requestedBalance = balanceUpdateCommand.money();
        this.balance = balance.change(requestedBalance);
    }

    public boolean currencyMatch(final Currency currency) {
        return this.currency.equals(currency);
    }

    public boolean containsRequiredAmount(final Money value) {
        return !value.isNegative() && balance.containsAmount(value);
    }
}
