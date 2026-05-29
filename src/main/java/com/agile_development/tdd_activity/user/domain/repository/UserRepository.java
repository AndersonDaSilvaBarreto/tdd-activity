package com.agile_development.tdd_activity.user.domain.repository;

import com.agile_development.tdd_activity.user.domain.entity.User;
import com.agile_development.tdd_activity.user.domain.valueobject.Email;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UserId id);
    Optional<User> findByEmail(Email email);
    boolean existsByEmail(Email email);
}
