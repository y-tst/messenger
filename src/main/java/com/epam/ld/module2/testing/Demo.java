package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Type message template in format: 'Hello, #{name}! Your email is #{email}.',\n" +
                "(where #{...} - mandatory parameters, could be any number of them,\n" +
                "text could be due to your needs) end press 'Enter':");
        String customTemplate = scan.nextLine();

        System.out.println("Type client's name:");
        String userName = scan.nextLine();

        System.out.println("Type client's email:");
        String userEmail = scan.nextLine();

        Client client = new Client(userName, userEmail);

        System.out.println("Sending email:\n" +
                "________________________________________________");

        Messenger.sendMessage(client, new Template(customTemplate));
    }
}
