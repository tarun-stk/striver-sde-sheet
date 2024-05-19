package org.example.stack;

import java.util.Stack;

//TC: O(n)
//SC: O(n)
//Problem link: https://leetcode.com/problems/valid-parentheses/
// Level: Easy
public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }
                else
                    return false;
            }
            if(s.charAt(i) == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }
                else
                    return false;
            }
            if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
