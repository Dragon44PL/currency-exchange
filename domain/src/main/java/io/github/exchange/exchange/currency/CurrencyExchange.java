package io.github.exchange.exchange.currency;

import io.github.exchange.exchange.Exchange;
import io.github.exchange.exchange.ExchangeType;
import io.github.exchange.finance.Money;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class CurrencyExchange implements Exchange {

    private final CurrencyExchangePair currencyPair;
    private final Money value;

    @Override
    public ExchangeType type() {
        return ExchangeType.CURRENCY;
    }

    @Override
    public String toString() {
        return "Exchange [source = " + currencyPair.getFrom() + " , target = " + currencyPair.getTo() + " , value = " + value + "]";
    }
}
