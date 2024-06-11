package org.example.linkedlist;

import java.util.HashMap;
import java.util.Map;

//Time Complexity: O(1)
//Space Complexity: O(capacity)
//Problem link: https://leetcode.com/problems/lru-cache/
//Level: Medium
class LRUCache {

    private class DLL {
        DLL prev;
        DLL next;
        int key;
        int val;

        public DLL(int k, int v) {
            key = k;
            val = v;
        }
    }

    Map<Integer, DLL> map;
    int count, capacity;
    DLL head, tail;

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLL(0, 0);
        tail = new DLL(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLL location = map.get(key);
            relocate(location);
            return location.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLL location = map.get(key);
            relocate(location);
            location.val = value;
        } else {
            if (count == capacity) {
                deleteLeastRecentlyUsed();
                count--;
            }
            addToDLL(key, value);
        }
    }

    private void addToDLL(int key, int val) {
        DLL newNode = new DLL(key, val);
        map.put(key, newNode);
        DLL n = head.next;
        head.next = newNode;
        newNode.next = n;
        newNode.prev = head;
        n.prev = newNode;
        count++;
    }

    private void deleteLeastRecentlyUsed() {
        DLL p = tail.prev;
        tail.prev = p.prev;
        p.prev.next = tail;
        map.remove(p.key);
    }

    private void relocate(DLL location) {
        // clearing out location
        DLL p = location.prev;
        DLL n = location.next;
        p.next = n;
        n.prev = p;
        // putting location right next ot head
        DLL hn = head.next;
        head.next = location;
        location.next = hn;
        location.prev = head;
        hn.prev = location;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
