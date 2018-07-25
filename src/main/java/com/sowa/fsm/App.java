package com.sowa.fsm;

import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final String PATH = "./src/main/resources/";
        Graph graph = new Graph(PATH);

        graph.buildGraph();
        graph.checkSequence();

    }
}
