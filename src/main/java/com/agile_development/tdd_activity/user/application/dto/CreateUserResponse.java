package com.agile_development.tdd_activity.user.application.dto;

import com.agile_development.tdd_activity.user.domain.entity.User;

import java.time.Instant;
import java.util.UUID;

public record CreateUserResponse(
        UUID id,
        String name,
        String email,
        Instant createdAt
) {
    public CreateUserResponse(User user) {
        this(user.getId().getValue(),
                user.getName().getValue(),
                user.getEmail().getValue(),
                user.getCreatedAt());
    }
}
