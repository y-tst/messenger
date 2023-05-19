package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.custom_annotatoins.AnnotationProcessor;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        /* Using Console Input */

//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Type message template in format: 'Hello, #{name}! Your email is #{email}.',\n" +
//                "(where #{...} - mandatory parameters, could be any number of them,\n" +
//                "text could be due to your needs) end press 'Enter':");
//        String customTemplate = scan.nextLine();
//
//        System.out.println("Type client's name:");
//        String userName = scan.nextLine();
//
//        String userEmail;
//
//        do {
//            System.out.println("Type correct client's email:");
//            userEmail = scan.nextLine();
//        }
//        while (!EmailVerifier.isValidEmail(userEmail));
//
//
//        Client client = new Client(userName, userEmail);
//
//        System.out.println("Sending email:\n" +
//                "________________________________________________");
//
//        MailServer mailServer = new MailServer(new TemplateEngine(), client);
//        Messenger messenger = new Messenger(mailServer, new TemplateEngine());
//
//        messenger.sendMessage(client, new Template(customTemplate));
//

        /* Using File processor */

        String inputFilePath = "src/main/resources/input.txt";
        String outputFilePath = "src/main/resources/output.txt";

        try {
            FileProcessor.processFile(inputFilePath, outputFilePath);
            System.out.println("File processed successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred while processing the file: " + e.getMessage());
        }


        /* Working with Custom Annotations */

        AnnotationProcessor.processAnnotations(EmailVerifier.class);
    }
}
