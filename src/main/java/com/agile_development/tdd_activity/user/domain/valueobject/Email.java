package com.agile_development.tdd_activity.user.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Email {
    @Column(name = "email",nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private String value;

    protected Email() {}

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Email cannot be null or blank"
            );
        }
        if (!value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toLowerCase();
    }
}
