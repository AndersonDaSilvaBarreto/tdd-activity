package com.agile_development.tdd_activity.post.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Content {
    @Column(name = "content", nullable = false,length = 1024)
    @EqualsAndHashCode.Include
    private String value;

    private Content(@NonNull String value) {
        validate(value.trim());
        this.value = value;
    }

    public static Content of(@NonNull String value) {
        return new Content(value);
    }

    private void validate(@NonNull String value) {
        if(value.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or blank");
        }
        if(value.length() < 15 || value.length() > 1024) {
            throw new IllegalArgumentException("Content must contain between 15 and 1024 characters");
        }
    }

}
