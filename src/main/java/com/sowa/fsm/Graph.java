package com.sowa.fsm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {

    private List<State> graph = new ArrayList<>();

    public void buildGraph() throws FileNotFoundException {

        final String FILENAME = "even0bin.txt";
        Scanner scanner =  new Scanner(new File("./src/main/resources/" + FILENAME));

        while (scanner.hasNextLine()) {
            String[] state = scanner.nextLine().split(" ");

            /** change this to dictionary */
            String[] sets = buildSets(scanner, Integer.parseInt(state[2]));
        }
    }

    private String[] buildSets(Scanner scanner, int lines) {

        /** change this to dictionary */
        String[] sets = new String[lines];

        for (int i = 0; i < lines; i++) {
            sets[i] = scanner.nextLine();
        }
        return sets;
    }
}
