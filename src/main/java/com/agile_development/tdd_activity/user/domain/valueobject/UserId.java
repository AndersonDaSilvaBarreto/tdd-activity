package com.agile_development.tdd_activity.user.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.UUID;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserId {

    @EqualsAndHashCode.Include
    @Column(name = "id")
    private UUID value;


    private UserId(@NonNull UUID value) {
        this.value = value;
    }

    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }
    public static UserId of(@NonNull UUID value) {
        return new UserId(value);
    }


    @Override
    public String toString() {
        return this.getValue().toString();
    }
}
