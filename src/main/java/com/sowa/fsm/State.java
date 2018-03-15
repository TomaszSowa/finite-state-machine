package com.sowa.fsm;

import java.util.Map;

public class State {

    private String id;
    private boolean accepting;
    private Map<Character, String> transitions;

    public State(String id, boolean accepting, Map<Character, String> transitions) {
        this.id = id;
        this.accepting = accepting;
        this.transitions = transitions;
    }

    public String getId() {
        return id;
    }

    public boolean isAccepting() {
        return accepting;
    }

    public Map<Character, String> getTransitions() {
        return transitions;
    }
}
