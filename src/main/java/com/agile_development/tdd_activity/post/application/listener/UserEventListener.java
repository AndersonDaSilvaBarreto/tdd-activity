package com.agile_development.tdd_activity.post.application.listener;

import com.agile_development.tdd_activity.post.domain.repository.PostRepository;
import com.agile_development.tdd_activity.user.api.event.UserDeletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEventListener {
    private final PostRepository repository;

    @ApplicationModuleListener
    public void on (UserDeletedEvent event) {
        System.out.println("EVENTO RECEBIDO: " + event.id());
        repository.deleteAllByAuthorId(event.id());
    }

}
