package io.github.exchange.account.command;

import io.github.exchange.account.vo.AccountId;
import io.github.exchange.finance.Money;
import lombok.NonNull;

public record BalanceUpdateCommand(@NonNull AccountId accountId, @NonNull Money money) { }
