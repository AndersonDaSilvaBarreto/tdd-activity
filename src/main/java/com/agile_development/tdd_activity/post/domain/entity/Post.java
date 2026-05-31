package com.agile_development.tdd_activity.post.domain.entity;

import com.agile_development.tdd_activity.post.domain.valueobject.Content;
import com.agile_development.tdd_activity.post.domain.valueobject.PostId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_post")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private PostId id;

    @Embedded
    private Content content;

    @Column(name = "author_id")
    private UUID authorId;

    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;

    private Post(Content content, UUID authorId) {
        validate(content, authorId);
        this.id = PostId.generate();
        this.content = content;
        this.authorId = authorId;
        this.createAt = Instant.now();
    }

    public static Post create(Content content, UUID authorId) {
        return new Post(content, authorId);
    }

    private void validate(Content content, UUID authorId) {
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null");
        }
        if (authorId == null) {
            throw new IllegalArgumentException("AuthorId cannot be null");
        }
    }

    public void changeContent(Content content) {
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null");
        }
        this.content = content;
    }


}
