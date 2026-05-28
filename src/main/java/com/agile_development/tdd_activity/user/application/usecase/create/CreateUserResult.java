package com.agile_development.tdd_activity.user.application.usecase.create;

import java.time.Instant;
import java.util.UUID;

public record CreateUserResult(
        UUID id,
        String name,
        String email,
        Instant createdAt
) {
}
