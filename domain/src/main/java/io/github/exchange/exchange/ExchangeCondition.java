package io.github.exchange.exchange;

public interface ExchangeCondition<T> {
    boolean match(T t);
}
