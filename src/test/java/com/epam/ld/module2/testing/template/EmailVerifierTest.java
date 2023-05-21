package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.EmailVerifier;
import com.epam.ld.module2.testing.OutputTestExecutionInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@OutputTestExecutionInfo
public class EmailVerifierTest {

    @DisplayName("Parametrized tests - Valid email addresses")
    @ParameterizedTest
    @ValueSource(strings = {
            "test@example.com",
            "user123@gmail.com",
            "john.doe@example.co.uk"
    })
    void isValidEmail_ValidEmails_ReturnsTrue(String email) {
        assertTrue(EmailVerifier.isValidEmail(email));
    }

    @DisplayName("Parametrized tests - Invalid email addresses")
    @ParameterizedTest
    @ValueSource(strings = {
            "notanemail",
            "user@",
            "@example.com",
            "user@example@com",
            "user@example.#com"
    })
    void isValidEmail_InvalidEmails_ReturnsFalse(String email) {
        assertFalse(EmailVerifier.isValidEmail(email));
    }

    @DisplayName("Dynamic test cases")
    @TestFactory
    Collection<DynamicTest> dynamicTests() {
        return Arrays.asList(
                dynamicTest("Valid email address", () -> {
                    assertTrue(EmailVerifier.isValidEmail("test@example.com"));
                }),
                dynamicTest("Invalid email address", () -> {
                    assertFalse(EmailVerifier.isValidEmail("notanemail"));
                })
        );
    }
}

