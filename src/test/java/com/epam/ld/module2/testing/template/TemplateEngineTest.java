package com.epam.ld.module2.testing.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class TemplateEngineTest {

    private TemplateEngine templateEngine;

    @BeforeEach
    void setUp() {
        templateEngine = new TemplateEngine();
    }

    @Test
    void testGenerateMessageWithValidTemplateAndValues() {
        String templateText = "Hello, #{name}! Your email is #{email}.";
        Map<String, String> values = new HashMap<>();
        values.put("name", "John");
        values.put("email", "john@example.com");
        String expectedMessage = "Hello, John! Your email is john@example.com.";

        String message = templateEngine.prepareMessage(templateText, values);

        assertEquals(expectedMessage, message);
    }

    @Test
    void testGenerateMessageWithMissingValueThrowsException() {
        String templateText = "Hello, #{name}! Your email is #{email}.";
        Map<String, String> values = new HashMap<>();
        values.put("name", "John");
        // Missing "email" value

        assertThrows(RuntimeException.class, () -> {
            templateEngine.prepareMessage(templateText, values);
        });
    }

    @Test
    void testGenerateMessageWithExtraValueIgnored() {
        String templateText = "Hello, #{name}!";
        Map<String, String> values = new HashMap<>();
        values.put("name", "John");
        values.put("email", "john@example.com"); // Extra value

        String expectedMessage = "Hello, John!";
        String message = templateEngine.prepareMessage(templateText, values);

        assertEquals(expectedMessage, message);
    }

    @Test
    void testGenerateMessageWithSpecialCharacters() {
        String templateText = "Hello, #{name}!";
        Map<String, String> values = new HashMap<>();
        values.put("name", "Jöhn"); // Special character

        String expectedMessage = "Hello, Jöhn!";
        String message = templateEngine.prepareMessage(templateText, values);

        assertEquals(expectedMessage, message);
    }
}