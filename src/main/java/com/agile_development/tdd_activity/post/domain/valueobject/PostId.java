package com.agile_development.tdd_activity.post.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostId {
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private UUID value;

    private PostId(UUID value) {
        validate(value);
        this.value = value;
    }
    public static PostId generate() {
        return new PostId(UUID.randomUUID());
    }
    public static PostId of(UUID value) {
        return new PostId(value);
    }
    private void validate(UUID value) {
        if(value == null) {
            throw new IllegalArgumentException("PostId cannot be null");
        }
    }
    @Override
    public String toString() {
        return this.getValue().toString();
    }
}
