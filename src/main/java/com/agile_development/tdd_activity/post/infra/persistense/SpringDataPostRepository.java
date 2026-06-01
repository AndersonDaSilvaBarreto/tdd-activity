package com.agile_development.tdd_activity.post.infra.persistense;

import com.agile_development.tdd_activity.post.domain.entity.Post;
import com.agile_development.tdd_activity.post.domain.valueobject.PostId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SpringDataPostRepository extends JpaRepository<Post, PostId> {
    List<Post> findPostsByAuthorId(UUID authorId);
    @Modifying
    @Query("""
       delete from Post p
       where p.authorId = :authorId
""")
    void deleteAllByAuthorId(UUID authorId);
}
