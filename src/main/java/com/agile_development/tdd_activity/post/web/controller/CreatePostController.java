package com.agile_development.tdd_activity.post.web.controller;

import com.agile_development.tdd_activity.post.application.usecase.CreatePostUseCase;
import com.agile_development.tdd_activity.post.web.dto.CreatePostRequest;
import com.agile_development.tdd_activity.post.web.dto.PostResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class CreatePostController {
    private final CreatePostUseCase useCase;

    @PostMapping
    public ResponseEntity<PostResponse> create(
            @RequestBody @Valid CreatePostRequest request
    ) {
        PostResponse response = useCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
