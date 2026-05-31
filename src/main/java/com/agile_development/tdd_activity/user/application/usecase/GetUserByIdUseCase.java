package com.agile_development.tdd_activity.user.application.usecase;

import com.agile_development.tdd_activity.user.domain.entity.User;
import com.agile_development.tdd_activity.user.domain.repository.UserRepository;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;
import com.agile_development.tdd_activity.user.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUserByIdUseCase {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponse execute(UUID id) {

        UserId userId = UserId.of(id);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found Exception")
                );

        return UserResponse.of(user);
    }


}
