package io.github.exchange.account.vo;

import lombok.EqualsAndHashCode;

import java.util.Objects;
import java.util.UUID;

@EqualsAndHashCode
public final class AccountId {

    private final String id;

    public AccountId() {
        this.id = UUID.randomUUID().toString();
    }

    AccountId(final String id) {
        Objects.requireNonNull(id, "Id must not be null");
        this.id = UUID.fromString(id).toString();
    }
}
