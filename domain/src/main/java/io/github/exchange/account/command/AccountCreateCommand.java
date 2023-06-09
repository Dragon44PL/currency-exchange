package io.github.exchange.account.command;

import io.github.exchange.account.vo.AccountId;
import io.github.exchange.user.UserId;
import lombok.NonNull;

import java.util.Currency;

public record AccountCreateCommand(@NonNull AccountId accountId, @NonNull UserId userId, @NonNull Currency currency) { }
