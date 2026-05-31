package com.agile_development.tdd_activity.post.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public record CreatePostRequest(
        @NotNull(message = "Content cannot be null")
        @NotBlank(message = "Content cannot be blank")
        @Length(min = 15, max = 1024, message = "Content must be between 15 and 1024 characters")
        String content,
        @NotNull(message = "AuthorId cannot be null")
        UUID authorId
) {
}
