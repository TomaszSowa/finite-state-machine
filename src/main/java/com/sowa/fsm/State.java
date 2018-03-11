package com.sowa.fsm;

public class State {

    private String id;
    private boolean accepting = false;
    private String[] sets;

    public State(String id, boolean accepting, String[] sets) {
        this.id = id;
        this.accepting = accepting;
        this.sets = sets;
    }

    public String getId() {
        return id;
    }

    public boolean isAccepting() {
        return accepting;
    }

    public String[] getSets() {
        return sets;
    }

}
