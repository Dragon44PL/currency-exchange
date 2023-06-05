package io.github.exchange.finance;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public record Money(BigDecimal value, Currency currency) {

    public static Money zero(Currency currency) {
        return new Money(BigDecimal.ZERO, currency);
    }

    public Money add(Money money) {
        validateInputParameter(money);
        return new Money(value.add(money.value), currency);
    }

    public Money subtract(Money money) {
        validateInputParameter(money);
        return new Money(value.subtract(money.value), currency);
    }

    public Money multiply(Money money) {
        return new Money(value.multiply(money.value), currency);
    }

    public boolean isNegative() {
        return value.compareTo(BigDecimal.ZERO) < 0;
    }

    private void validateInputParameter(Money money) {
        Objects.requireNonNull(money, "Money must not be null");
        currenciesMustEquals(money.currency);
    }

    private void currenciesMustEquals(Currency currency) {
        if (!this.currency.equals(currency)) {
            throw new IllegalArgumentException("Currencies must be the same!");
        }
    }
}