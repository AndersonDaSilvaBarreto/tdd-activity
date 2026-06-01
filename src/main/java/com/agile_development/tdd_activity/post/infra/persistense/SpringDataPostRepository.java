package com.agile_development.tdd_activity.post.infra.persistense;

import com.agile_development.tdd_activity.post.domain.entity.Post;
import com.agile_development.tdd_activity.post.domain.valueobject.PostId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataPostRepository extends JpaRepository<Post, PostId> {
    List<Post> findPostsByAuthorId(UUID authorId);
    void deleteAllByAuthorId(UUID authorId);
}
