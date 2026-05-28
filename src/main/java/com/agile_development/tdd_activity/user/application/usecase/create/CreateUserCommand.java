package com.agile_development.tdd_activity.user.application.usecase.create;

public record CreateUserCommand(
        String name,
        String email
) {
}
