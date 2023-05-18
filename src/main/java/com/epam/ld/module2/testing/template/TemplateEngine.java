package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {

    public String generateMessage(Template template, Client client) {
        Map<String, String> values = new HashMap<>();
        values.put("name", client.getName());
        values.put("email", client.getEmail());

        return createMessage(template.getTemplateText(), values);
    }

    public String createMessage(String templateText, Map<String, String> values) {
        Template template = new Template(templateText);
        if (templateText.chars().filter(ch -> ch == '#').count() <= values.size()) {
            String message = template.replacePlaceholders(values);
            return message;
        }
        else throw new RuntimeException("Missing values for template replacement");
    }
}
