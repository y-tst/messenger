package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MailServerTest {

   private MailServer mailServer;

    @Mock
    private TemplateEngine templateEngine;

    @Mock
    private Client client;


    @BeforeEach
    public void setUp() {
//        TemplateEngine templateEngine = mock(TemplateEngine.class);
//        Client client = mock(Client.class);
        try {
            mailServer = new MailServer(templateEngine, client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSend() {

        String email = "user@example.com";
        String messageContent = "Hello, this is a test email.";

        mailServer.send(email, messageContent);

        verify(client, times(1)).getEmail();
//        verify(templateEngine,times(1)).generateMessage(messageContent, client);
    }

    @Test
    public void testSendWithEmptyToAddress() {

        String email = "";
        String messageContent = "Hello, this is a test email.";

        mailServer.send(email, messageContent);

        verify(mailServer, times(1)).send(email,messageContent);
    }

    @Test
    public void testSendWithNullToAddress() {

        String email = null;
        String messageContent = "Hello, this is a test email.";

        mailServer.send(email, messageContent);

        assertThrows(RuntimeException.class, () -> {
            mailServer.send(email, messageContent);
        });
    }

    @Test
    public void testSendWithEmptyBody() {

        String email = "user@example.com";
        String messageContent = "";

        mailServer.send(email, messageContent);

        verify(mailServer, times(1)).send(email,messageContent);
    }

    @Test
    public void testSendWithNullBody() {

        String email = "user@example.com";
        String messageContent = null;

        mailServer.send(email, messageContent);

        verify(mailServer, times(1)).send(email,messageContent);
    }


    @Test
    public void testSendEmail() {

        String email = "user@example.com";
        String messageContent = "Hello, this is a test email.";

        mailServer.send(email, messageContent);

        verify(mailServer.getClient(), times(1));
//        verify(mailServer.getTemplateEngine(), times(1)).generateMessage(Mockito.any(Template.class), Mockito.any(Client.class));
    }
}
