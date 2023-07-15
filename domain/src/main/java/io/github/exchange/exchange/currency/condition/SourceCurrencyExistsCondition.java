package io.github.exchange.exchange.currency.condition;

import io.github.exchange.exchange.ExchangeCondition;
import io.github.exchange.exchange.currency.CurrencyExchangeRates;

import java.util.Currency;

public record SourceCurrencyExistsCondition(CurrencyExchangeRates rates) implements ExchangeCondition<Currency> {

    @Override
    public boolean match(Currency currency) {
        return rates.fetchCurrencyExchange().stream()
                .anyMatch(currencyExchange -> currencyExchange.getFrom().equals(currency));
    }
}
