package com.sowa.fsm;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class GraphTest {

    String fileName = "even0bin.txt";
    String path = "./src/main/resources/" + fileName;
    Graph graph = new Graph();

    @Test
    void testRead() throws FileNotFoundException {
        graph.buildGraph();
    }
}