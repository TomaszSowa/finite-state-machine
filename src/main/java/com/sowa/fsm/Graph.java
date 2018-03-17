package com.sowa.fsm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {

    private Map<String, State> graph = new HashMap<>();
    String filePath;
    String startingState;

    public Graph(String filePath) {
        this.filePath = filePath;
        try {
            this.startingState = new Scanner(new File(filePath)).nextLine().split(" ")[0];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void buildGraph() throws FileNotFoundException {

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
        String sequence;
        String stateId = startingState;

        while (sequenceScanner.hasNextLine()) {
            sequence = sequenceScanner.nextLine();
            printState(startingState);

            for (int i = 1; i < sequence.length() - 1; i++) {
                stateId = changeState(sequence.charAt(i), stateId);
                if (stateId == null) break;
            }

            if (stateId == null || graph.get(stateId).isAccepting() == false) {
                System.out.println("\nNot accepted");
            } else {
                System.out.println("\nAccepted");
            }
            stateId = startingState;
        }
        sequenceScanner.close();
    }

    private void printState(String state) {

        if (graph.get(state).isAccepting()) {
            System.out.print("((" + state + "))");
        } else {
            System.out.print("(" + state + ")");
        }
    }

    private String changeState(char ch, String stateId) {
        stateId = graph.get(stateId).getTransitions().get(ch);
        System.out.print(" --" + ch + "--> ");
        if (stateId != null) {
            printState(stateId);
        } else {
            System.out.print("Wrong character!");
        }
        return stateId;
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
