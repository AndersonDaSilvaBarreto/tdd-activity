package com.agile_development.tdd_activity.post.application.listener;

import com.agile_development.tdd_activity.post.domain.repository.PostRepository;
import com.agile_development.tdd_activity.user.api.event.UserDeletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEventListener {
    private final PostRepository repository;

    @Async
    @ApplicationModuleListener
    public void on (UserDeletedEvent event) {
        repository.deleteAllByAuthorId(event.id());
    }

}
