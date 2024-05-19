package org.example.trie;

//TC: O(M) -> M, length of word in three methods
//SC: O(N) -> total number of chars inserted into trie, in worst case each node will have 26 nodes
//like for words, aaaaaaa, bbbbbbb, ccccccc
//Problem link: https://leetcode.com/problems/implement-trie-prefix-tree/
//Level: Medium
public class ImplementTrie {
    class Trie {

        class Node {
            Node[] node;
            boolean isEnd;

            public Node() {
                node = new Node[26];
                isEnd = false;
            }
        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node r = root;
            for (int i = 0; i < word.length(); i++) {
                if (r.node[word.charAt(i) - 'a'] == null) {
                    r.node[word.charAt(i) - 'a'] = new Node();
                }
                r = r.node[word.charAt(i) - 'a'];
            }
            r.isEnd = true;
        }

        public boolean search(String word) {
            Node r = root;
            for (int i = 0; i < word.length(); i++) {
                if (r.node[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                r = r.node[word.charAt(i) - 'a'];
            }
            return r.isEnd;
        }

        public boolean startsWith(String word) {
            Node r = root;
            for (int i = 0; i < word.length(); i++) {
                if (r.node[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                r = r.node[word.charAt(i) - 'a'];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
