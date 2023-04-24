package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import java.util.Map;

public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param client   the client
     * @return the string
     */
    public String generateMessage(Template template, Client client) {
        return null;
    }

    public String generateMessage(String templateText, Map<String, String> values) {
        Template template = new Template(templateText);
        if (templateText.chars().filter(ch -> ch == '#').count() <= values.size()) {
            String message = template.replacePlaceholders(values);
            return message;
        }
        else throw new RuntimeException("Missing values for template replacement");
    }
}
