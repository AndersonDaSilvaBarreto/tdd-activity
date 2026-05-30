package com.agile_development.tdd_activity.user.application.usecase;

import com.agile_development.tdd_activity.user.web.dto.CreateUserRequest;
import com.agile_development.tdd_activity.user.infra.persistence.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserUseCaseTest {
    @Test
    void shouldCreateUser() {
        var repository = new InMemoryUserRepository();
        var useCase = new CreateUserUseCase(repository);
        var request = new CreateUserRequest(
                "Anderson",
                "anderson@gmail.com"
        );

        var result = useCase.execute(request);
        assertNotNull(result.id());
        assertEquals(
                "Anderson",
                result.name()
        );

        assertEquals("anderson@gmail.com",
                result.email());

    }
}
