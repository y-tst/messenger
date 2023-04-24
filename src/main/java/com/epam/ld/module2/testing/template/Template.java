package com.epam.ld.module2.testing.template;

import java.util.Map;

public class Template {

    private String templateText;

    public Template(String templateText) {
        this.templateText = templateText;
    }

    public String getTemplateText() {
        return templateText;
    }

    public String replacePlaceholders(Map<String, String> values) throws RuntimeException {
        String result = templateText;

        for (Map.Entry<String, String> entry : values.entrySet()) {
            String placeholder = "#{" + entry.getKey() + "}";
            String value = entry.getValue();
            result = result.replace(placeholder, value);
        }

        return result;
    }
}
