package com.agile_development.tdd_activity.post.infra.persistense;

import com.agile_development.tdd_activity.post.domain.entity.Post;
import com.agile_development.tdd_activity.post.domain.valueobject.PostId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, PostId> {
}
