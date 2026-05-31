package com.agile_development.tdd_activity.post.web.controller;

import com.agile_development.tdd_activity.post.application.usecase.CreatePostUseCase;
import com.agile_development.tdd_activity.post.web.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class CreatePostController {
    private final CreatePostUseCase useCase;
    public ResponseEntity<PostResponse> create(

    )
}
