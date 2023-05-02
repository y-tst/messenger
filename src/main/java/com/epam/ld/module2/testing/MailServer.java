package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.TemplateEngine;

/**
 * Mail server class.
 */
public class MailServer {

    private TemplateEngine templateEngine;
    private Client client;

    public MailServer(TemplateEngine templateEngine, Client client) {
        this.templateEngine = templateEngine;
        this.client = client;
    }

    /**
     * Send notification.
     *
     * @param email  the addresses
     * @param messageContent the message content
     */
    public void send(String email, String messageContent) {

        if (!EmailVerifier.isValidEmail(email) || email == "")
            System.out.println("Email is invalid, provide the correct one, please");
        else {
            System.out.println("Mail sent to: " + email);
            System.out.println("Body: " + messageContent);
        }
    }

    public Object getClient() {
        return  this.client;
    }

    public Object getTemplateEngine() {
        return this.templateEngine;
    }
}
