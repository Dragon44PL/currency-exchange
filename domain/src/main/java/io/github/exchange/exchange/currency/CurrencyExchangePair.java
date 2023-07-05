package io.github.exchange.exchange.currency;

import io.github.exchange.exchange.currency.exception.CurrencyExchangeException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Currency;
import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrencyExchangePair {

    private final Currency from;
    private final Currency to;

    public static CurrencyExchangePair of(Currency from, Currency to) {
        validateInputParameters(from, to);
        return new CurrencyExchangePair(from, to);
    }

    private static void validateInputParameters(Currency from, Currency to) {
        Objects.requireNonNull(from, "Source currency must not be null");
        Objects.requireNonNull(to, "Target currency must not be null");
        validateNotEquals(from, to);
    }

    private static void validateNotEquals(Currency from, Currency to) {
        if(from.equals(to)) {
            throw new CurrencyExchangeException("Currencies must not be the same");
        }
    }

    @Override
    public String toString() {
        return "Pair [source = " + from + " , target = " + to + "]";
    }
}
