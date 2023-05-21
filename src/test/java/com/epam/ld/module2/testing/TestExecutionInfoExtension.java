package com.epam.ld.module2.testing;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionListener;
import org.junit.jupiter.api.extension.TestExtensionContext;
import java.io.FileWriter;
import java.io.IOException;

public class TestExecutionInfoExtension implements TestExecutionListener {

    @Override
    public void testStarted(TestExtensionContext context) throws Exception {
        // Get the test display name
        String testName = context.getDisplayName();

        // Create a file to store the test execution information
        String fileName = testName + ".txt";
        FileWriter fileWriter = new FileWriter(fileName, true);

        // Write the test execution details to the file
        try {
            fileWriter.write("Test started: " + testName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
    }

    @Override
    public void testFinished(TestExtensionContext context) throws Exception {
        // Get the test display name
        String testName = context.getDisplayName();

        // Append the test execution details to the file
        String fileName = testName + ".txt";
        FileWriter fileWriter = new FileWriter(fileName, true);

        try {
            fileWriter.write("Test finished: " + testName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
    }
}

