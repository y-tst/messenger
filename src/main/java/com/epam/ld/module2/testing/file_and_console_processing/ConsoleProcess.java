package com.epam.ld.module2.testing.file_and_console_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleProcess {

    public static void processConsoleInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            System.out.println("Input: " + input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
