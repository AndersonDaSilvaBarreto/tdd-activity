package com.agile_development.tdd_activity.user.application.usecase.create;

import com.agile_development.tdd_activity.user.infra.persistence.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserUseCaseTest {
    @Test
    void shouldCreateUser() {
        var repository = new InMemoryUserRepository();
        var useCase = new CreateUserUseCase(repository);
        var command = new CreateUserCommand(
                "Anderson",
                "anderson@gmail.com"
        );

        var result = useCase.execute(command);
        assertNotNull(result.id());
        assertEquals(
                "Anderson",
                result.name()
        );

        assertEquals("anderson@gmail.com",
                result.email());

    }
}
