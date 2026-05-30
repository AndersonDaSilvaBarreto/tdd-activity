package com.agile_development.tdd_activity.user.application.usecase.create;

import com.agile_development.tdd_activity.user.application.dto.CreateUserRequest;
import com.agile_development.tdd_activity.user.infra.persistence.InMemoryUserRepository;
import static org.junit.jupiter.api.Assertions.*;


public class GetUserUseCaseTest {
    void shouldGetUser() {
        var repository = new InMemoryUserRepository();
        var useCaseCreate = new CreateUserUseCase(repository);
        var useCase = new GetUserUseCase();
        var request = new CreateUserRequest(
                "Anderson",
                "anderson@gmail.com"
        );
        var create = useCaseCreate.execute(request);
        var result = useCase.execute(create.id());

        assertEquals(create.id(),result.id);

    }
}
