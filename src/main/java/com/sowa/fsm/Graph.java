package com.sowa.fsm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {

    private Map<String, State> graph = new HashMap<>();

    public void buildGraph(String filePath) throws FileNotFoundException {

        Scanner graphScanner =  new Scanner(new File(filePath));

        while (graphScanner.hasNextLine()) {
            String[] state = graphScanner.nextLine().split(" ");
            Map<Character, String> transitions = mapTransitions(graphScanner, Integer.parseInt(state[2]));
            State newState = new State(state[0], Boolean.parseBoolean(state[1]), transitions);
            graph.put(newState.getId(), newState);
        }
        graphScanner.close();
    }

    public void checkSequence(String filePath) throws FileNotFoundException {

        Scanner sequenceScanner =  new Scanner(new File(filePath));
        while (sequenceScanner.hasNextLine()) {
            System.out.println(sequenceScanner.nextLine());
        }

        sequenceScanner.close();
    }

    private Map<Character, String> mapTransitions(Scanner graphScanner, int lines) {

        Map<Character, String> transitions = new HashMap<>();
        String[] line;
        String value;

        for (int i = 0; i < lines; i++) {
            line = graphScanner.nextLine().split(" ", 2);
            value = line[0];
            assignKeys(transitions, line[1], value);
        }
        return transitions;
    }

    private void assignKeys(Map<Character, String> transitions, String keys, String value) {

        char key;

        for (int i = 1; i < keys.length() - 1; i++) {
            key = keys.charAt(i);
            transitions.put(key, value);
        }
    }
}
