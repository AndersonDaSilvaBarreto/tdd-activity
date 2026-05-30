package com.agile_development.tdd_activity.user.web.controller;
import com.agile_development.tdd_activity.user.web.controller.CreateUserController;
import com.agile_development.tdd_activity.user.application.dto.CreateUserRequest;
import com.agile_development.tdd_activity.user.application.dto.CreateUserResponse;
import com.agile_development.tdd_activity.user.application.usecase.create.CreateUserUseCase;
import com.agile_development.tdd_activity.user.domain.entity.User;
import com.agile_development.tdd_activity.user.domain.valueobject.Email;
import com.agile_development.tdd_activity.user.domain.valueobject.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CreateUserController.class)
public class CreateUserControllerTest {
    @Autowired
    private  MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private CreateUserUseCase createUserUseCase;

    @Test
    void shouldCreateUserSuccessfully() throws Exception {

    var request = new CreateUserRequest(
            "Anderson",
            "anderson@gmail.com"
    );

    var newUser = User.create(
            Name.of("Anderson"),
            Email.of("anderson@gmail.com")
    );
    var response = new CreateUserResponse(newUser);

    when(createUserUseCase.execute(request))
            .thenReturn(response);

    mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("Anderson"))
            .andExpect(jsonPath("$.email").value("anderson@gmail.com"));

    }

}
