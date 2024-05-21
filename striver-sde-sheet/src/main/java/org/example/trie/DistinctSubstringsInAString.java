package org.example.trie;

//TC: O(N^2) -> N -> length of word
//SC: O(N) -> total number of chars stored in Trie
//Problem link: https://www.naukri.com/code360/problems/count-distinct-substrings_985292
//Level: Medium
public class DistinctSubstringsInAString {
    static class Trie {
        Trie[] node;

        public Trie() {
            node = new Trie[26];
        }
    }

    public static int countDistinctSubstrings(String s)
    {
        //	  Write your code here.
        Trie root = new Trie();
        int count = 0;
        for(int i = 0; i < s.length(); i ++){
            Trie node = root;
            for(int j = i; j < s.length(); j ++){
                int k = s.charAt(j)-'a';
                if(node.node[k] == null){
                    node.node[k] = new Trie();
                    count ++;
                }
                node = node.node[k];
            }
        }
        return count+1;
    }
}
