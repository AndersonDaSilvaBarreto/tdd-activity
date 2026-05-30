package com.agile_development.tdd_activity.user.application.usecase;

import com.agile_development.tdd_activity.user.domain.entity.User;
import com.agile_development.tdd_activity.user.domain.repository.UserRepository;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;
import com.agile_development.tdd_activity.user.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class GetUserByIdUseCase {
    private final UserRepository userRepository;

    public UserResponse execute(UUID id) {

        UserId userId = UserId.of(id);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found Exception")
                );

        return UserResponse.of(user);
    }


}
