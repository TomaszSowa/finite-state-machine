package com.sowa.fsm;

import java.io.FileNotFoundException;
//import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final String PATH = "./src/main/resources/";
        final String TRANSITIONS_FILE = "even0bin.txt";
        final String SEQUENCEFILE_FILE = "01.txt";

        Graph graph = new Graph();
        System.out.println("Starting FSM...");

        try {
            graph.buildGraph(PATH + TRANSITIONS_FILE);
            graph.checkSequence(PATH + SEQUENCEFILE_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /* test
        String[] splitted = "Split,split2,split3".split(",", 2);
        for (String str : splitted) System.out.println(str);
        Scanner sc = new Scanner(System.in);
        String aa = sc.nextLine();
        System.out.println("'" + aa + "'");
        */

    }
}
