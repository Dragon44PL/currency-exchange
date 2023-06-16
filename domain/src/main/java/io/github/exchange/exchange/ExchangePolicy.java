package io.github.exchange.exchange;

public interface ExchangePolicy {
    default <T> boolean matches(ExchangeCondition<T> condition, T t) {
        return condition.match(t);
    };
}
