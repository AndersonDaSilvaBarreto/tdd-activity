package com.agile_development.tdd_activity.user.application.controller.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CreateUserRequest(
        @NotNull(message = "Name cannot be null!")
        @NotBlank(message = "Name cannot be blank!")
        @Length(min = 2, max = 255, message = "Name must be between 2 and 255 characters!")
        String name,
        @NotNull(message = "Email cannot be null!")
        @Email(message = "Email must be valid!")
        String email
) {
}
