package com.agile_development.tdd_activity.user.application.usecase.create;


import com.agile_development.tdd_activity.user.domain.entity.User;
import com.agile_development.tdd_activity.user.domain.repository.UserRepository;
import com.agile_development.tdd_activity.user.domain.valueobject.Email;
import com.agile_development.tdd_activity.user.domain.valueobject.Name;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepository repository;

    @Transactional
    public CreateUserResult execute(
            CreateUserCommand command
    ) {
        var user = new User(
                new Name(command.name()),
                new Email(command.email())
        );
        repository.save(user);
        return new CreateUserResult(
                user.getId(),
                user.getName().getValue(),
                user.getEmail().getValue(),
                user.getCreatedAt()
        );
    }
}
