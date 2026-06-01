package com.agile_development.tdd_activity.post.domain.repository;

import com.agile_development.tdd_activity.post.domain.entity.Post;
import com.agile_development.tdd_activity.post.domain.valueobject.PostId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository {
    Post save (Post post);
    Optional<Post> findById(PostId postId);
    List<Post> findPostsByAuthorId(UUID authorId);
    void deleteAllByAuthorId(UUID authorId);
}
