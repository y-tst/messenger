package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

    public static void processFile(String inputFilePath, String outputFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            System.out.println("Reading the file" +
                    "\n________________________________________________");

            String templateFromFile = reader.readLine();
            String userNameFromFile = reader.readLine();
            String userEmailFromFile = reader.readLine();

            if (!EmailVerifier.isValidEmail(userEmailFromFile)) {
                System.out.println("The email from file is incorrect! Fix it in the file and try again!");
                return;
            }

            System.out.println("Processing the data and writing the file" +
                    "\n________________________________________________"  +
                    "\n________________________________________________");

            Client client = new Client(userNameFromFile, userEmailFromFile);
            MailServer mailServer = new MailServer(new TemplateEngine(), client);
            Messenger messenger = new Messenger(mailServer, new TemplateEngine());

            String processedMessage =  messenger.preparedMessage(client, new Template(templateFromFile));

            writer.write(processedMessage);

            System.out.println("Done" +
                    "\n________________________________________________"  +
                    "\n________________________________________________"  +
                    "\n________________________________________________");
        }
    }
}
