package com.agile_development.tdd_activity.user.application.usecase;


import com.agile_development.tdd_activity.user.web.dto.CreateUserRequest;
import com.agile_development.tdd_activity.user.web.dto.UserResponse;
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
    private final UserRepository userRepository;

    @Transactional
    public UserResponse execute(
            CreateUserRequest request
    ) {
        var newUser = User.create(
                Name.of(request.name()),
                Email.of(request.email())
        );
        boolean userExists = userRepository.existsByEmail(newUser.getEmail());
        if (userExists) {
            throw new IllegalArgumentException("User already exists");
        }

        var savedUser = userRepository.save(newUser);
        return UserResponse.of(savedUser);
    }
}
