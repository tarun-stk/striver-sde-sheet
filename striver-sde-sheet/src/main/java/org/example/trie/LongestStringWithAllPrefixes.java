package org.example.trie;

//TC: O(N) N-> total number of chars inserted into trie
//SC: O(N)
//Problem link: https://www.naukri.com/code360/problems/complete-string_2687860
//Level: Medium
public class LongestStringWithAllPrefixes {

    static class Node {
        Node[] node;
        boolean isEnd;

        public Node() {
            node = new Node[26];
            isEnd = false;
        }
    }

    public static String completeString(int n, String[] a) {

        Node root = new Node();
        int max = 0;
        String ans = "";
        for (int i = 0; i < n; i++) {
            Node node = root;
            for (int j = 0; j < a[i].length(); j++) {
                int c = a[i].charAt(j) - 'a';
                if (node.node[c] == null) {
                    node.node[c] = new Node();
                }
                node = node.node[c];
            }
            node.isEnd = true;
        }

        for (int i = 0; i < n; i++) {
            Node node = root;
            int j = 0;
            for (; j < a[i].length(); j++) {
                int c = a[i].charAt(j) - 'a';
                node = node.node[c];
                if (!node.isEnd) {
                    break;
                }
            }
            if (j > max) {
                max = j;
                ans = a[i].substring(0, j);
            } else if (max == j) {
                int diff = a[i].substring(0, j).compareTo(ans);
                if (diff < 0) {
                    ans = a[i].substring(0, j);
                }
            }
        }

        return ans.equals("") ? "None" : ans;
    }
}
