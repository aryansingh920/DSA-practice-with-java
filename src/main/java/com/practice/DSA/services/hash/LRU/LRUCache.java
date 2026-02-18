package com.practice.DSA.services.hash.LRU;

import java.util.HashMap;
import java.util.Map;

import com.practice.DSA.helper.Node;



public class LRUCache {
    private final int capacity;
    private Map<Integer, Node> cacheMap = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        return 0;
    }

    public void put(int key, int value) {
        if (keyExists(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
        } else {
            if (isFull()) {

            } else {

            }

        }
    }

    private boolean isFull() {
        return cacheMap.size() == capacity;
    }

    private boolean  keyExists(int key) {
        return cacheMap.get(key) != null;
    }

}

