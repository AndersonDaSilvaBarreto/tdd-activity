package com.agile_development.tdd_activity.post.domain.entity;

import com.agile_development.tdd_activity.post.domain.valueobject.Content;
import com.agile_development.tdd_activity.post.domain.valueobject.PostId;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "author_id", nullable = false)
    private UUID authorId;

    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;

    private Post(@NonNull Content content,@NonNull UUID authorId) {
        this.id = PostId.generate();
        this.content = content;
        this.authorId = authorId;
        this.createAt = Instant.now();
    }

    public static Post create(@NonNull Content content,@NonNull UUID authorId) {
        return new Post(content, authorId);
    }

    public void changeContent(@NonNull Content newContent) {
        this.content = newContent;
    }


}
