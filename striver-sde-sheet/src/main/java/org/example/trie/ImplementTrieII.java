package org.example.trie;

//TC: O(N) -> N -> length of word
//SC: O(N) -> total number of chars stored in Trie
//Problem link: https://www.naukri.com/code360/problems/implement-trie_1387095
//Level: Medium
public class ImplementTrieII {
    class Node {
        Node[] node;
        // boolean isEnd;;
        int word;
        int pre;

        public Node() {
            node = new Node[26];
            // isEnd = false;
            word = 0;
            pre = 0;
        }
    }

    Node root;

    public ImplementTrieII() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node r = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (r.node[j] == null) {
                r.node[j] = new Node();
            }
            // r.pre ++;
            r = r.node[j];
            r.pre++;
        }
        r.word++;
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node r = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (r.node[j] == null) {
                return 0;
            }
            r = r.node[j];
        }
        return r.word;
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node r = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (r.node[j] == null) {
                return 0;
            }
            r = r.node[j];
        }
        return r.pre;
    }

    public void erase(String word) {
        // Write your code here.
        Node r = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            r.node[j].pre--;
            r = r.node[j];
        }
        r.word--;
    }
}
