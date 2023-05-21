package com.epam.ld.module2.testing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.assertTrue;

public class TemporaryFolderTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testTemporaryFolder() throws IOException {

        File tempFile = tempFolder.newFile("temp.txt");

        String sourceFilePath = "src/main/resources/correctInput.txt";
        String destinationFilePath = "temp.txt";

        assertTrue(tempFile.canWrite());

        try (
                InputStream inputStream = new FileInputStream(sourceFilePath);
                OutputStream outputStream = new FileOutputStream(destinationFilePath)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred during file copy: " + e.getMessage());
        }

        assertTrue(tempFile.exists());
        assertTrue(tempFile.canRead());
        System.out.println("Temp file content:\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(destinationFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        File tempDir = tempFolder.newFolder("tempDir");
        assertTrue(tempDir.exists());
    }
}

