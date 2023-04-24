package com.epam.ld.module2.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MailServerTest {

    private MailService mailService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        mailService = new MailService();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testSendMail() {
        String to = "john@example.com";
        String subject = "Test Subject";
        String body = "Test Body";
        String expectedOutput = "Mail sent to: " + to + "\nSubject: " + subject + "\nBody: " + body;

        mailService.sendMail(to, subject, body);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}
