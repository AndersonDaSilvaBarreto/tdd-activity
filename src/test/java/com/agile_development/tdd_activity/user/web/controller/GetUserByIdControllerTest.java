package com.agile_development.tdd_activity.user.web.controller;

import com.agile_development.tdd_activity.user.application.usecase.GetUserByIdUseCase;
import com.agile_development.tdd_activity.user.web.dto.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import java.time.Instant;
import java.util.UUID;

import static org.mockito.Mockito.when;


@WebMvcTest(GetUserByIdController.class)
public class GetUserByIdControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetUserByIdUseCase useCase;

    @Test
    void shouldReturnUser() throws Exception {

        UUID id = UUID.randomUUID();
        Instant createAt = Instant.now();

        var response = new UserResponse(
                id,
                "Anderson",
                "anderson@gmail.com",
                createAt
        );

        when(useCase.execute(id))
                .thenReturn(response);

        mockMvc.perform(get("/users/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("Anderson"))
                .andExpect(jsonPath("$.email").value("anderson@gmail.com"))
                .andExpect(jsonPath("$.createdAt").value(response.createdAt().toString()));
    }
}
