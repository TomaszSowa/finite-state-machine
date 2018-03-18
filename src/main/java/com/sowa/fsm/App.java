package com.sowa.fsm;

import java.io.FileNotFoundException;
//import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final String PATH = "./src/main/resources/";
//        final String TRANSITIONS_FILE = "even0bin.txt";
//        final String SEQUENCEFILE_FILE = "01.txt";
        final String TRANSITIONS_FILE = "bbab.txt";
        final String SEQUENCEFILE_FILE = "ab.txt";

        Graph graph = new Graph(PATH + TRANSITIONS_FILE);

        try {
            graph.buildGraph();
            graph.checkSequence(PATH + SEQUENCEFILE_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
