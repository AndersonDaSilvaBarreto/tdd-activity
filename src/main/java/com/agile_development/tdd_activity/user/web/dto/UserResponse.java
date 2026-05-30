package com.agile_development.tdd_activity.user.web.dto;

import com.agile_development.tdd_activity.user.domain.entity.User;

import java.time.Instant;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String email,
        Instant createdAt
) {
    public static UserResponse of(User user) {
       return new UserResponse(
               user.getId().getValue(),
               user.getName().getValue(),
               user.getEmail().getValue(),
               user.getCreatedAt()
       );
    }

}
