package com.epam.ld.module2.testing.custom_annotatoins;

import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void processAnnotations(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MailAnnotation.class)) {
                MailAnnotation annotation = method.getAnnotation(MailAnnotation.class);
                System.out.println("Method: " + method.getName() + ", Value: " + annotation.domainName());
            }
        }
    }
}

