package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.file_and_console_processing.ProcessFile;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class FileProcessingTest {

    @Test
    public void testFileReading() throws IOException {

        BufferedReader mockReader = mock(BufferedReader.class);

        when(mockReader.readLine())
                .thenReturn("Line 1")
                .thenReturn("Line 2")
                .thenReturn(null);

        ProcessFile.processFile(mockReader);

        verify(mockReader, times(3)).readLine();
        verify(mockReader).close();
    }
}
