package com.agile_development.tdd_activity.user.infra.persistence;

import com.agile_development.tdd_activity.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID> {
}
