package com.agile_development.tdd_activity.post.infra.persistense;

import com.agile_development.tdd_activity.post.domain.entity.Post;
import com.agile_development.tdd_activity.post.domain.repository.PostRepository;
import com.agile_development.tdd_activity.post.domain.valueobject.PostId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaPostRepository implements PostRepository {
    private final JpaPostRepository repository;


    @Override
    public Post save(Post post) {
        return repository.save(post);
    }

    @Override
    public Optional<Post> findById(PostId postId) {
        return repository.findById(postId);
    }

    @Override
    public List<Post> findPostsByAuthorId(UUID authorId) {
        return repository.findPostsByAuthorId(authorId);
    }
}
