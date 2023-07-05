package io.github.exchange.exchange.currency;

import java.util.Set;

public interface CurrencyExchangeRates {
    Set<CurrencyExchangePair> fetchCurrencyExchange();
}
