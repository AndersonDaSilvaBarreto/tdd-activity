package com.agile_development.tdd_activity.user.application.usecase;

import com.agile_development.tdd_activity.user.domain.entity.User;
import com.agile_development.tdd_activity.user.api.event.UserDeletedEvent;
import com.agile_development.tdd_activity.user.domain.repository.UserRepository;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCase {
    private final UserRepository repository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void execute(@NonNull UUID id) {
        UserId userId = UserId.of(id);
        User user = repository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        repository.deleteUser(user);
        eventPublisher.publishEvent(
                new UserDeletedEvent(userId.getValue())
        );
    }

}
