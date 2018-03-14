package com.sowa.fsm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {

    private List<State> graph = new ArrayList<>();

    public void buildGraph() throws FileNotFoundException {

        /* move filename & path to the constructor parameter */
        final String FILENAME = "even0bin.txt";
        Scanner scanner =  new Scanner(new File("./src/main/resources/" + FILENAME));

        while (scanner.hasNextLine()) {
            String[] state = scanner.nextLine().split(" ");
            Map<String, String> transitions = mapTransitions(scanner, Integer.parseInt(state[2]));
            graph.add(new State(state[0], Boolean.parseBoolean(state[1]), transitions));
        }
    }

    private Map<String, String> mapTransitions(Scanner scanner, int lines) {

        Map<String, String> transitions = new HashMap<>();
        String[] line;
        String value;

        for (int i = 0; i < lines; i++) {
            line = scanner.nextLine().split(" ", 2);
            value = line[0];
            assignKeys(transitions, line[1], value);
        }
        return transitions;
    }

    private void assignKeys(Map<String, String> transitions, String keys, String value) {

        String key;

        for (int i = 1; i < keys.length() - 1; i++) {
            key = keys.substring(i, i + 1);
            transitions.put(key, value);
        }
    }
}
