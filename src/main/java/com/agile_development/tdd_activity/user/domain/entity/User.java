package com.agile_development.tdd_activity.user.domain.entity;

import com.agile_development.tdd_activity.user.domain.valueobject.Email;
import com.agile_development.tdd_activity.user.domain.valueobject.Name;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Entity
@Table(name = "tb_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private UserId id;

    @Embedded
    private Name name;

    @Embedded
    private Email email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
    private User(Name name, Email email) {
        validate(name,email);
        this.id = UserId.generate();
        this.name = name;
        this.email = email;
        this.createdAt = Instant.now();
    }
    public static User create(Name name, Email email) {
        return new User(name, email);
    }
    public void changeName(Name newName) {
        if(newName == null) {
            throw new IllegalArgumentException(
                    "Name cannot be null"
            );
        }
        this.name = newName;
    }
    private void validate(Name name, Email email) {
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
    }
    public void changeEmail(Email newEmail) {
        if(newEmail == null) {
            throw new IllegalArgumentException(
                    "Email cannot be null"
            );
        }
    }

}
