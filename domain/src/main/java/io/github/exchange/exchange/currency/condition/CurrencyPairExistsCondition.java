package io.github.exchange.exchange.currency.condition;

import io.github.exchange.exchange.ExchangeCondition;
import io.github.exchange.exchange.currency.CurrencyExchangePair;
import io.github.exchange.exchange.currency.CurrencyExchangeRates;

public record CurrencyPairExistsCondition(CurrencyExchangeRates rates) implements ExchangeCondition<CurrencyExchangePair> {

    @Override
    public boolean match(CurrencyExchangePair pair) {
        return rates.fetchCurrencyExchange().stream()
                .anyMatch(currencyExchange -> currencyExchange.equals(pair));
    }
}
