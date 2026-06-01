package com.agile_development.tdd_activity.user.domain.entity;

import com.agile_development.tdd_activity.user.domain.valueobject.Email;
import com.agile_development.tdd_activity.user.domain.valueobject.Name;
import com.agile_development.tdd_activity.user.domain.valueobject.UserId;
import jakarta.persistence.*;
import lombok.*;

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
    private User(@NonNull Name name,@NonNull Email email) {
        this.id = UserId.generate();
        this.name = name;
        this.email = email;
        this.createdAt = Instant.now();
    }
    public static User create(@NonNull Name name,@NonNull Email email) {
        return new User(name, email);
    }
    public void changeName(@NonNull Name newName) {
        this.name = newName;
    }
    public void changeEmail(@NonNull Email newEmail) {
        this.email = newEmail;
    }

}
