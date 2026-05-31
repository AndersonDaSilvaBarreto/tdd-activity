package com.agile_development.tdd_activity.post.application.usecase;

import com.agile_development.tdd_activity.post.domain.entity.Post;
import com.agile_development.tdd_activity.post.domain.repository.PostRepository;
import com.agile_development.tdd_activity.post.domain.valueobject.Content;
import com.agile_development.tdd_activity.post.web.dto.CreatePostRequest;
import com.agile_development.tdd_activity.post.web.dto.PostResponse;
import com.agile_development.tdd_activity.user.api.UserApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class CreatePostUseCase {
    private final PostRepository repository;
    private final UserApi userApi;
    public PostResponse create(
            @RequestBody @Valid CreatePostRequest request
            ) {
        Content content = Content.of(request.content());
        boolean userExists = userApi.existsById(request.authorId());
        if(!userExists) {
            throw new RuntimeException("User not found");
        }
        Post newPost = Post.create(
                content,
                request.authorId()
        );
        Post savedPost = repository.save(newPost);
        return PostResponse.of(savedPost);

    }
}
