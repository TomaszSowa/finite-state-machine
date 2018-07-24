package com.sowa.fsm;

import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final String PATH = "./src/main/resources/";
        String transitionsFile;
        String sequenceFile;
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input a transitions file name");
        transitionsFile = sc.next();
        Graph graph = new Graph(PATH + transitionsFile);

        System.out.println("Please input a sequence file name");
        sequenceFile = sc.next();

        try {
            graph.buildGraph();
            graph.checkSequence(PATH + sequenceFile);
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.err.println("File not found");
        }

    }
}
