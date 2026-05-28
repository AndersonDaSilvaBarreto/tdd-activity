package com.agile_development.tdd_activity.user.domain.valueobject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EmailTest {
    @Test
    void shouldCreateValidEmail() {
        var email = new Email("test@gmail.com");
        assertEquals(
                "test@gmail.com",
                email.getValue()
        );
    }
    @Test
    void shouldThrowExceptionWhenEmailIsBlank() {

        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));
    }
    @Test
    void shouldThrowExceptionWhenEmailIsNull() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Email(null)
        );
    }
    @Test
    void shouldThrowExceptionWhenEmailDoesNotContainAt() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Email("invalid email")
        );
    }
}
