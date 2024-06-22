package org.example.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//TC: O(1) for both put and get
//SC: O(capacity)
//Problem link: https://leetcode.com/problems/lfu-cache/
//Level: Hard
class LFUCache {

    TreeMap<Integer, DLL> treeMap;
    Map<Integer, NodeContent> map;
    int limit, current;

    public LFUCache(int capacity) {
        treeMap = new TreeMap<>();
        map = new HashMap<>();
        limit = capacity;
        current = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        NodeContent nodeContent = map.get(key);
        int currentFrequency = nodeContent.frequency;
        Node nodeLocation = map.get(key).location;
        removeFromCurrentFrequency(key, nodeLocation, currentFrequency);
        reAddToCacheWithIncreasedFrequency(key, currentFrequency + 1, nodeLocation, nodeContent);
        return nodeContent.value;
    }

    public void put(int key, int value) {
        int currentFrequency = 0;
        Node nodeLocation = null;
        NodeContent nodeContent = null;
        if (map.containsKey(key)) {
            nodeContent = map.get(key);
            nodeLocation = nodeContent.location;
            nodeContent.value = value;
            currentFrequency = nodeContent.frequency;
            removeFromCurrentFrequency(key, nodeLocation, currentFrequency);
        } else {
            if (current == limit) {
                removeLeastLFU();
                current -= 1;
            }
            nodeLocation = new Node(key);
            nodeContent = new NodeContent(key, value, nodeLocation);
            current += 1;
        }
        reAddToCacheWithIncreasedFrequency(key, currentFrequency + 1, nodeLocation, nodeContent);
    }

    private void reAddToCacheWithIncreasedFrequency(int key, int increasedFrequency, Node nodeLocation, NodeContent nodeContent) {
        if (!treeMap.containsKey(increasedFrequency)) {
            treeMap.put(increasedFrequency, new DLL());
        }
        nodeContent.frequency += 1;
        Node head = treeMap.get(increasedFrequency).head;
        Node next = head.next;
        nodeLocation.prev = head;
        nodeLocation.next = next;
        head.next = nodeLocation;
        next.prev = nodeLocation;
        map.put(key, nodeContent);
    }

    private void removeLeastLFU() {
        int leastFrequency = treeMap.firstKey();
        removeFromCurrentFrequency(treeMap.get(leastFrequency).tail.prev.value, treeMap.get(leastFrequency).tail.prev, leastFrequency);
    }

    private void removeFromCurrentFrequency(int key, Node location, int frequency) {
        /*If this is the only node with particular frequency*/
        if (location.next.value == -1 && location.prev.value == -1) {
            /*remove from the map*/
            map.remove(key);
            /*remove frequency from the treemap*/
            treeMap.remove(frequency);
            return;
        }
        Node prevNode = location.prev;
        Node nextNode = location.next;
        /*delink the current node*/
        location.next = null;
        location.prev = null;
        /*re-attach the list*/
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        map.remove(key);
    }

    class NodeContent {
        int key, frequency, value;
        Node location;

        public NodeContent(int key, int value, Node location) {
            this.key = key;
            this.value = value;
            this.location = location;
            this.frequency = 0;
        }
    }

    class Node {
        int value;
        Node next, prev;

        public Node(int value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    class DLL {
        Node head;
        Node tail;

        public DLL() {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }
    }

}


