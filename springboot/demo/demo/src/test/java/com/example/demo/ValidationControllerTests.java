package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationControllerTests {

    private final ValidationController controller = new ValidationController();

    @Test
    void testStrongPassword() {
        String result = controller.checkPasswordQuality("StrongPass1!");
        assertEquals("Very Strong", result);
    }

    @Test
    void testWeakPassword() {
        String result = controller.checkPasswordQuality("abc");
        assertEquals("Very Weak", result);
    }

    @Test
    void testValidEmail() {
        assertTrue(controller.validateEmail("test@example.com"));
    }

    @Test
    void testInvalidEmail() {
        assertFalse(controller.validateEmail("invalidemail"));
    }
}
