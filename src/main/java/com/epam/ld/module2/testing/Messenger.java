package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

public class Messenger {
    private MailServer mailServer;
    private TemplateEngine templateEngine;

    public Messenger(MailServer mailServer, TemplateEngine templateEngine) {
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    public void sendMessage(Client client, Template template) {
        String messageContent = templateEngine.generateMessage(template, client);
        mailServer.send(client.getEmail(), messageContent);
    }

    public String preparedMessage(Client client, Template template) {
        String messageContent = templateEngine.generateMessage(template, client);
        return mailServer.message(client.getEmail(), messageContent);
    }
}
