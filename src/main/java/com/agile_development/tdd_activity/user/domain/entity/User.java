package com.agile_development.tdd_activity.user.domain.entity;

import com.agile_development.tdd_activity.user.domain.valueobject.Email;
import com.agile_development.tdd_activity.user.domain.valueobject.Name;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    @Embedded
    private Name name;

    @Embedded
    private Email email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    protected User() {}
    public User(Name name, Email email) {
        if(name == null) {
            throw new IllegalArgumentException(
                    "Name cannot be null"
            );
        }
        if (email == null) {
            throw new IllegalArgumentException(
                    "Email cannot be null"
            );
        }
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.createdAt = Instant.now();
    }
    public void changeName(Name newName) {
        if(newName == null) {
            throw new IllegalArgumentException(
                    "Name cannot be null"
            );
        }
        this.name = newName;
    }
    public void changeEmail(Email newEmail) {
        if(newEmail == null) {
            throw new IllegalArgumentException(
                    "Email cannot be null"
            );
        }
    }

}
