package com.agile_development.tdd_activity.user.application.usecase;

import com.agile_development.tdd_activity.user.web.dto.CreateUserRequest;
import com.agile_development.tdd_activity.user.infra.persistence.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class GetUserByIdUseCaseTest {
    @Test
    void shouldGetUser() {
        var repository = new InMemoryUserRepository();
        var useCaseCreate = new CreateUserUseCase(repository);
        var useCase = new GetUserByIdUseCase(repository);
        var request = new CreateUserRequest(
                "Anderson",
                "anderson@gmail.com"
        );
        var userCreated = useCaseCreate.execute(request);
        var result = useCase.execute(userCreated.id());
        assertEquals(userCreated.id(),result.id());
        assertEquals(userCreated.name(),result.name());
        assertEquals(userCreated.email(),result.email());
        assertEquals(userCreated.createdAt(),result.createdAt());

    }
    @Test
    void shouldThrowExceptionWhenUserDoesNotExist() {
        var repository = new InMemoryUserRepository();
        var useCase = new GetUserByIdUseCase(repository);
        assertThrows(
                IllegalArgumentException.class,
                () -> useCase.execute(UUID.randomUUID())
        );
    }
}
