package com.agile_development.tdd_activity.user.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Email {
    @Column(name = "email",nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private String value;

    private Email(@NonNull String value) {
        var normalizedEmail = value.trim().toLowerCase();
        this.validate(normalizedEmail);
        this.value = normalizedEmail;
    }

    public static Email of(@NonNull String value) {
        return new Email(value);
    }
    private void validate(@NonNull String email) {
        if (email.isBlank()) {
            throw new IllegalArgumentException(
                    "Email cannot be null or blank"
            );
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
