package com.agile_development.tdd_activity.user.infra.persistence;

import com.agile_development.tdd_activity.user.domain.entity.User;
import com.agile_development.tdd_activity.user.domain.repository.UserRepository;
import com.agile_development.tdd_activity.user.domain.valueobject.Email;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository {
    private final SpringDataUserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findById(UserId id) {
        return repository.findById(id);
    }


    @Override
    public Optional<User> findByEmail(Email email) {
        return repository.findByEmail(email);
    }

    @Override
    public boolean existsById(UserId userId) {

        return repository.existsById(userId);
    }


    @Override
    public boolean existsByEmail(Email email) {
        return repository.existsByEmail(email);
    }

    @Override
    public void deleteUser(User user) {
        repository.delete(user);
    }
}
