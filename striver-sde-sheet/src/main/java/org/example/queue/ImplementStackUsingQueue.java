package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;

/*Using only one queue*/

//Time Complexity: O(n)
//Space Complexity: O(n)
//Problem link: https://leetcode.com/problems/implement-stack-using-queues/
//Level: Easy
public class ImplementStackUsingQueue {
    Queue<Integer> q;

    public ImplementStackUsingQueue() {
        q = new LinkedList<>();
    }

    public void push(int x) {  //O(n)
        q.offer(x);
    }

    public int pop() {  // O(n)
        int s = q.size(), c = 0;
        while (c < s - 1) {
            q.offer(q.poll());
            c++;
        }
        return q.poll();
    }

    public int top() {  // O(n)
        int s = q.size(), c = 0, lastElement = -1;
        while (c < s) {
            lastElement = q.poll();
            q.offer(lastElement);
            c++;
        }
        return lastElement;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/*Using only one queue and much better way*/
class MyStack {

    Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<>();

    }

    public void push(int x) {
        q1.offer(x);
        int s = q1.size(), c = 0;
        while (c < s - 1) {
            q1.offer(q1.poll());
            c++;
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

