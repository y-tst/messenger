package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MailServerTest {

    private MailServer mailServer;

    @BeforeEach
    public void setUp() {
        TemplateEngine templateEngine = mock(TemplateEngine.class);
        Client client = mock(Client.class);
        mailServer = new MailServer(templateEngine, client);
    }

    @Test
    public void testSend() {

        String email = "user@example.com";
        String body = "Hello, this is a test email.";

        mailServer.send(email, body);
    }

    @Test
    public void testSendWithEmptyToAddress() {

        String email = "";
        String messageContent = "Hello, this is a test email.";

        mailServer.send(email, messageContent);
    }

    @Test
    public void testSendWithNullToAddress() {
        // Test data
        String email = null;
        String messageContent = "Hello, this is a test email.";

        mailServer.send(email, messageContent);
    }

    @Test
    public void testSendWithEmptyBody() {

        String email = "user@example.com";
        String messageContent = "";

        mailServer.send(email, messageContent);
    }

    @Test
    public void testSendWithNullBody() {

        String email = "user@example.com";
        String messageContent = null;

        mailServer.send(email, messageContent);
    }


    @Test
    public void testSendEmail() {

        String email = "user@example.com";
        String messageContent = "Hello, this is a test email.";

        mailServer.send(email, messageContent);

//        verify(mailServer.getClient(), times(1));
        verify(mailServer.getTemplateEngine(), atLeastOnce());
    }
}
