package com.agile_development.tdd_activity.post.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.UUID;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostId {
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private UUID value;

    private PostId(@NonNull UUID value) {
        this.value = value;
    }
    public static PostId generate() {
        return new PostId(UUID.randomUUID());
    }
    public static PostId of(@NonNull UUID value) {
        return new PostId(value);
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }
}
