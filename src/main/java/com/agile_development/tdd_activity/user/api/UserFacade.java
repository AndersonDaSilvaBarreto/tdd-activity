package com.agile_development.tdd_activity.user.api;

import com.agile_development.tdd_activity.user.api.dto.UserSummaryDto;
import com.agile_development.tdd_activity.user.domain.repository.UserRepository;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserFacade implements UserApi {
    private final UserRepository repository;


    @Override
    public UserSummaryDto findById(UUID id) {
        var user = repository.findById(UserId.of(id)).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return UserSummaryDto.of(user);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(UserId.of(id));
    }
}
