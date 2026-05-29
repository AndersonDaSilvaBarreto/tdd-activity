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
        boolean userExits = repository.existsByEmail(new Email(request.email()));
        if(userExits) {
            throw new IllegalArgumentException("User already exists");
        }
        var user = new User(
                new Name(request.name()),
                new Email(request.email())
        );
        repository.save(user);
        return new CreateUserResponse(
                user.getId(),
                user.getName().getValue(),
                user.getEmail().getValue(),
                user.getCreatedAt()
        );
    }
}
