package com.epam.ld.module2.testing.file_and_console_processing;

import java.io.BufferedReader;
import java.io.IOException;

public class ProcessFile {
    public static void processFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
