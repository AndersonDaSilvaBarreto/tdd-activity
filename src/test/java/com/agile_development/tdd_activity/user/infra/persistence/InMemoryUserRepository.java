package com.agile_development.tdd_activity.user.infra.persistence;

import com.agile_development.tdd_activity.user.domain.entity.User;
import com.agile_development.tdd_activity.user.domain.repository.UserRepository;
import com.agile_development.tdd_activity.user.domain.valueobject.Email;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(UserId id) {
        return users.stream()
                .filter(user ->
                        user.getId().equals(id))
                .findFirst();
    }


    @Override
    public Optional<User> findByEmail(Email email) {

        return users.stream()
                .filter(user ->
                        user.getEmail().equals(email)
                )
                .findFirst();
    }

    @Override
    public boolean existsById(UserId userId) {
        return users.stream()
                .anyMatch(user -> user.getId().equals(userId));
    }

    @Override
    public boolean existsByEmail(Email email) {

        return users.stream()
                .anyMatch(user ->
                        user.getEmail().equals(email)
                );
    }
}
