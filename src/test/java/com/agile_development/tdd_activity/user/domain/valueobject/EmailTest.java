package com.agile_development.tdd_activity.user.domain.valueobject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EmailTest {
    @Test
    void shouldCreateValidEmail() {
        var email = Email.of("test@gmail.com");
        assertEquals(
                "test@gmail.com",
                email.getValue()
        );
    }
    @Test
    void shouldThrowExceptionWhenEmailIsBlank() {

        assertThrows(IllegalArgumentException.class,
                () -> Email.of(""));
    }
    @Test
    void shouldThrowExceptionWhenEmailIsNull() {

        assertThrows(
                IllegalArgumentException.class,
                () -> Email.of(null)
        );
    }
    @Test
    void shouldThrowExceptionWhenEmailDoesNotContainAt() {

        assertThrows(
                IllegalArgumentException.class,
                () -> Email.of("invalid email")
        );
    }
}
