package org.example.trie;

//TC: O(32*N) -> N -> length of word
//SC: O(N) -> total number of chars stored in Trie
//Problem link: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
//Level: Medium
public class MaxXor {
    class Solution {

        class Trie{
            Trie[] link;
            public Trie(){
                link = new Trie[2];
            }
        }

        int ans = 0;
        public int findMaximumXOR(int[] nums) {
            Trie root = new Trie();
            for(int i = 0; i < nums.length; i ++){
                Trie temp = root;
                String bs = Integer.toBinaryString(nums[i]);
                bs = String.format("%32s", bs).replace(' ', '0');
                // System.out.println("bs: " + bs);
                for(int j = 0; j < 32; j ++){
                    char c = bs.charAt(j);
                    if(c == '0'){
                        if(temp.link[0] == null){
                            temp.link[0] = new Trie();
                        }
                        temp = temp.link[0];
                    }
                    else if(c == '1'){
                        if(temp.link[1] == null){
                            temp.link[1] = new Trie();
                        }
                        temp = temp.link[1];
                    }
                }
            }

            for(int i = 0; i < nums.length; i ++){
                Trie temp = root;
                int t = 0;
                String bs = Integer.toBinaryString(nums[i]);
                bs = String.format("%32s", bs).replace(' ', '0');
                // System.out.println("bs: " + bs);
                for(int j = 0; j < 32; j ++){
                    char c = bs.charAt(j);
                    if(c == '0'){
                        if(temp.link[1] != null){
                            temp = temp.link[1];
                            t += Math.pow(2, 32-j-1);
                        }
                        else{
                            temp = temp.link[0];
                        }

                    }
                    else if(c == '1'){
                        if(temp.link[0] != null){
                            temp = temp.link[0];
                            t += Math.pow(2, 32-j-1);
                        }
                        else{
                            temp = temp.link[1];
                        }
                    }
                }
                ans = Math.max(ans, t);
            }

            return ans;
        }
    }
}
