package com.agile_development.tdd_activity.user.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserId {

    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    private UUID value;

    protected UserId() {}

    private UserId(UUID value) {
        this.value = value;
    }

    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }
    public static UserId of(UUID value) {
        return new UserId(value);
    }
}
