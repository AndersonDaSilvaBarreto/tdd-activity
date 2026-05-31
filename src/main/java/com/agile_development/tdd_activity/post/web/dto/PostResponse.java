package com.agile_development.tdd_activity.post.web.dto;

import com.agile_development.tdd_activity.post.domain.entity.Post;

import java.time.Instant;
import java.util.UUID;

public record PostResponse(
        UUID id,
        String content,
        UUID authorId,
        Instant createdAt
) {
    public static PostResponse of (Post post) {
        return new PostResponse(
                post.getId().getValue(),
                post.getContent().getValue(),
                post.getAuthorId(),
                post.getCreateAt()
        );
    }
}
