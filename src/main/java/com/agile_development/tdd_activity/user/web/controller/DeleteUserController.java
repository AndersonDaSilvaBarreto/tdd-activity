package com.agile_development.tdd_activity.user.web.controller;

import com.agile_development.tdd_activity.user.application.usecase.DeleteUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class DeleteUserController {
    private final DeleteUserUseCase useCase;
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id
            ) {
         useCase.execute(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
