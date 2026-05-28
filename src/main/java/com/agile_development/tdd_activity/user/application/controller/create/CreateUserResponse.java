package com.agile_development.tdd_activity.user.application.controller.create;

import java.time.Instant;
import java.util.UUID;

public record CreateUserResponse(
        UUID id,
        String name,
        String email,
        Instant createdAt
) {
}
