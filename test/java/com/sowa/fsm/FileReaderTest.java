package com.sowa.fsm;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class FileReaderTest {

    String fileName = "even0bin.txt";
    String path = "./src/main/resources/" + fileName;
    FileReader fileReader = new FileReader(path);

    @Test
    void testRead() throws FileNotFoundException {
        fileReader.read();
    }
}