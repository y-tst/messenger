package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.TemplateEngine;

public class MailServer {

    private TemplateEngine templateEngine;
    private Client client;

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    public Client getClient() {
        return client;
    }

    public MailServer(TemplateEngine templateEngine, Client client) {
        this.templateEngine = templateEngine;
        this.client = client;
    }

    public void send(String email, String messageContent) {

        System.out.println("Mail sent to: " + email);
        System.out.println("Body: " + messageContent);
    }

    public String message(String email, String messageContent) {
        return ("Mail sent to: " + email + "\nBody: " + messageContent);

    }
}
