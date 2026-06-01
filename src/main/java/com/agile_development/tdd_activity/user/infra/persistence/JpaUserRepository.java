package com.agile_development.tdd_activity.user.infra.persistence;

import com.agile_development.tdd_activity.user.domain.entity.User;
import com.agile_development.tdd_activity.user.domain.repository.UserRepository;
import com.agile_development.tdd_activity.user.domain.valueobject.Email;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository {
    private final SpringDataUserRepository repository;

    @Override
    public User save(@NonNull User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findById(@NonNull UserId id) {
        return repository.findById(id);
    }


    @Override
    public Optional<User> findByEmail(@NonNull Email email) {
        return repository.findByEmail(email);
    }

    @Override
    public boolean existsById(@NonNull UserId userId) {

        return repository.existsById(userId);
    }


    @Override
    public boolean existsByEmail(@NonNull Email email) {
        return repository.existsByEmail(email);
    }

    @Override
    public void deleteUser(@NonNull User user) {
        repository.delete(user);
    }
}
