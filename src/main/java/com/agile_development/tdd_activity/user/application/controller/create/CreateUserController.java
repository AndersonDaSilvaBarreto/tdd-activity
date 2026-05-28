package com.agile_development.tdd_activity.user.application.controller.create;

import com.agile_development.tdd_activity.user.application.usecase.create.CreateUserCommand;
import com.agile_development.tdd_activity.user.application.usecase.create.CreateUserUseCase;
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
    public ResponseEntity<CreateUserResponse> create(
            @RequestBody @Valid CreateUserRequest request
            ) {
        var command = new CreateUserCommand(
                request.name(),
                request.email()
        );
        var result = useCase.execute(command);
        var response = new CreateUserResponse(
                result.id(),
                result.name(),
                result.email(),
                result.createdAt()
        );
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
