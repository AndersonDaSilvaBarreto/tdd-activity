package com.agile_development.tdd_activity.user.api.dto;

import com.agile_development.tdd_activity.user.domain.entity.User;

import java.time.Instant;
import java.util.UUID;

public record UserSummaryDto(
        UUID id,
        String name,
        String email,
        Instant createdAt
) {
    public static UserSummaryDto of(User user) {
        return new UserSummaryDto(
                user.getId().getValue(),
                user.getName().getValue(),
                user.getEmail().getValue(),
                user.getCreatedAt()
        );
    }
}
