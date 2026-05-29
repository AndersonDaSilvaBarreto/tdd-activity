package com.agile_development.tdd_activity.user.application.usecase.create;


import com.agile_development.tdd_activity.user.application.dto.CreateUserRequest;
import com.agile_development.tdd_activity.user.application.dto.CreateUserResponse;
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
    public CreateUserResponse execute(
            CreateUserRequest request
    ) {
        var newUser = new User(
                Name.of(request.name()),
                Email.of(request.email())
        );
        boolean userExists = repository.existsByEmail(newUser.getEmail());
        if (userExists) {
            throw new IllegalArgumentException("User already exists");
        }

        var savedUser = repository.save(newUser);
        return new CreateUserResponse(
                savedUser.getId().getValue(),
                savedUser.getName().getValue(),
                savedUser.getEmail().getValue(),
                savedUser.getCreatedAt()
        );
    }
}
