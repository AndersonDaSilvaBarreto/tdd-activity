package com.agile_development.tdd_activity.user.web.controller;

import com.agile_development.tdd_activity.user.web.dto.CreateUserRequest;
import com.agile_development.tdd_activity.user.web.dto.UserResponse;
import com.agile_development.tdd_activity.user.application.usecase.CreateUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class CreateUserController {
    private final CreateUserUseCase useCase;

    @PostMapping
    public ResponseEntity<UserResponse> create(
            @RequestBody @Valid CreateUserRequest request
            ) {

        UserResponse response = useCase.execute(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
