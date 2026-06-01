package com.agile_development.tdd_activity.user.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Name {
    @Column(name = "name", nullable = false)
    @EqualsAndHashCode.Include
    private String value;

    private Name(@NonNull String value) {
        validate(value.trim());
        this.value = value;
    }
    public static Name of(@NonNull String value) {
        return new Name(value);
    }


    private void validate(@NonNull String value) {
        if (value.isBlank()) {
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
