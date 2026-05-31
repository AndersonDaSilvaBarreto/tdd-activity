package com.agile_development.tdd_activity.user.infra.persistence;

import com.agile_development.tdd_activity.user.domain.entity.User;
import com.agile_development.tdd_activity.user.domain.valueobject.Email;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, UserId> {
    Optional<User> findByEmail(Email email);
    boolean existsByEmail(Email email);
}
