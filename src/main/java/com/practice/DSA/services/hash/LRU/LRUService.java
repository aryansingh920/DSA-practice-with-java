package com.practice.DSA.services.hash.LRU;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.DSA.DataTransferObject.LruRequest;

@Service
public class LRUService {

    public LinkedList<Integer> run(LruRequest req) {
        LinkedList<String> commands = req.getCommand();
        LinkedList<List<Integer>> values = req.getValue();

        if (commands == null || values == null || commands.size() != values.size()) {
            throw new IllegalArgumentException("commands and value must be non-null and same length");
        }

        LinkedList<Integer> outputs = new LinkedList<>();
        LRUCache cache = null;

        for (int i = 0; i < commands.size(); i++) {
            String cmd = commands.get(i);
            List<Integer> args = values.get(i);

            switch (cmd) {
                case "LRUCache" -> {
                    if (args == null || args.size() != 1) {
                        throw new IllegalArgumentException("LRUCache expects [capacity]");
                    }
                    cache = new LRUCache(args.get(0));
                    outputs.add(null); // LeetCode-style output for constructor
                }
                case "put" -> {
                    if (cache == null)
                        throw new IllegalStateException("LRUCache not initialized");
                    if (args == null || args.size() != 2) {
                        throw new IllegalArgumentException("put expects [key, value]");
                    }
                    cache.put(args.get(0), args.get(1));
                    outputs.add(null); // put returns null
                }
                case "get" -> {
                    if (cache == null)
                        throw new IllegalStateException("LRUCache not initialized");
                    if (args == null || args.size() != 1) {
                        throw new IllegalArgumentException("get expects [key]");
                    }
                    outputs.add(cache.get(args.get(0)));
                }
                default -> throw new IllegalArgumentException("Unknown command: " + cmd);
            }
        }

        return outputs;
    }
}
