package com.agile_development.tdd_activity.user.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Name {
    @Column(name = "name", nullable = false)
    @EqualsAndHashCode.Include
    private String value;

    protected Name() {}

    private Name(String value) {
        value = normalize(value);
        validate(value);
        this.value = value;

    }
    public static Name of(String value) {
        return new Name(value);

    }

    private String normalize(String value) {
        return value == null ? null : value.trim();
    }

    private void validate(String value) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Name cannot be blank"
            );
        }

        if (value.length() < 2 || value.length() > 255) {
            throw new IllegalArgumentException(
                    "Name must contain between 2 and 255 characters"
            );
        }
    }
    @Override
    public String toString() {
        return value;
    }
}
