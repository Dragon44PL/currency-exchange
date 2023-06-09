package io.github.exchange.account.vo;

import io.github.exchange.finance.Money;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;
import java.util.Objects;

public record Balance(Money balance, Instant createdOn, Instant updatedOn) {

    public Balance(final Money value) {
        this(value, Instant.now(), Instant.now());
    }

    public static Balance zero(final Currency currency) {
        return new Balance(Money.zero(currency));
    }

    public Balance change(final Money money) {
        Objects.requireNonNull(money);
        return !money.isNegative() ? plus(money) : minus(money);
    }

    public Balance plus(final Money money) {
        Objects.requireNonNull(money);
        return new Balance(balance.add(money), createdOn, Instant.now());
    }

    public Balance minus(final Money money) {
        Objects.requireNonNull(money);
        return new Balance(balance.subtract(money), createdOn, Instant.now());
    }

    public boolean containsAmount(final Money money) {
        return !change(money).balance().isNegative();
    }

    public boolean isUnmodified() {
        return BigDecimal.ZERO.equals(balance.value()) && createdOn.equals(updatedOn);
    }
}
