package com.agile_development.tdd_activity.post.infra.persistense;

import com.agile_development.tdd_activity.post.domain.entity.Post;
import com.agile_development.tdd_activity.post.domain.repository.PostRepository;
import com.agile_development.tdd_activity.post.domain.valueobject.PostId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaPostRepository implements PostRepository {
    private final SpringDataPostRepository repository;


    @Override
    public Post save(@NonNull Post post) {
        return repository.save(post);
    }

    @Override
    public Optional<Post> findById(@NonNull PostId postId) {
        return repository.findById(postId);
    }

    @Override
    public List<Post> findPostsByAuthorId(@NonNull UUID authorId) {
        return repository.findPostsByAuthorId(authorId);
    }

    @Override
    public void deleteAllByAuthorId(@NonNull UUID authorId) {
        repository.deleteAllByAuthorId(authorId);
    }
}
