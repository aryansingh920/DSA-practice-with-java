package com.practice.DSA.services.hash.LRU;

import java.util.HashMap;
import java.util.Map;

import com.practice.DSA.helper.Node;

public class LRUCache {
    // head as LRU side and tail as MRU side
    private final int capacity;
    private final Node head = new Node(-1, -1);
    private final Node tail = new Node(-1, -1);

    private final Map<Integer, Node> cacheMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.prev = null;
        this.tail.next = null;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {

        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        Node currentNode = cacheMap.get(key);
        int value = currentNode.value;
        // move to MRU
        // remove first from current space
        removeNode(currentNode);
        // add at the end
        Node beforeTail = this.tail.prev;
        currentNode.prev = beforeTail;
        currentNode.next = this.tail;
        beforeTail.next = currentNode;
        tail.prev = currentNode;
        return value;

    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);

            // cache value updated
            node.value = value;

            // move it to MRU
            Node beforeNode = node.prev;
            Node afterNode = node.next;
            beforeNode.next = afterNode;
            afterNode.prev = beforeNode;

            node.prev = this.tail.prev;
            node.next = this.tail;
            this.tail.prev.next = node;
            this.tail.prev = node;

        } else {
            Node newNode = new Node(key, value);
            if (isFull()) {
                // remove the LRU node
                int keyToBeRemoved = this.head.next.key;
                removeNode(this.head.next);
                cacheMap.remove(keyToBeRemoved);
            }
            // add node at the end
            Node beforeTail = this.tail.prev;
            newNode.prev = beforeTail;
            newNode.next = tail;
            beforeTail.next = newNode;
            tail.prev = newNode;
            cacheMap.put(key, newNode);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // optional cleanup:
        node.prev = null;
        node.next = null;
    }

    private boolean isFull() {
        return cacheMap.size() == capacity;
    }

}
