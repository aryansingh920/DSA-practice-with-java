package com.practice.DSA.DataTransferObject;

import java.util.LinkedList;
import java.util.List;

public class LruRequest {
    private LinkedList<String> command;
    private LinkedList<List<Integer>> value;

    public LinkedList<String> getCommand() {
        return command;
    }

    public void setCommand(LinkedList<String> command) {
        this.command = command;
    }

    public LinkedList<List<Integer>> getValue() {
        return value;
    }

    public void setValue(LinkedList<List<Integer>> value) {
        this.value = value;
    }
}
