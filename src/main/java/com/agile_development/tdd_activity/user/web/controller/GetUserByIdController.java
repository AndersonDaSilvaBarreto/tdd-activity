package com.agile_development.tdd_activity.user.web.controller;

import com.agile_development.tdd_activity.user.application.usecase.GetUserByIdUseCase;
import com.agile_development.tdd_activity.user.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class GetUserByIdController {
    private final GetUserByIdUseCase useCase;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(
            @PathVariable UUID id
            ) {
        UserResponse response = useCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
