package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.file_and_console_processing.ConsoleProcess;
import com.epam.ld.module2.testing.file_and_console_processing.ProcessFile;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class ConsoleProcessingTest {

    @Test
    public void testFileReading() throws IOException {

        String mockInput = "Mocked input";
        System.setIn(new java.io.ByteArrayInputStream(mockInput.getBytes()));

        ConsoleProcess.processConsoleInput();
        System.setIn(System.in);
    }
}
