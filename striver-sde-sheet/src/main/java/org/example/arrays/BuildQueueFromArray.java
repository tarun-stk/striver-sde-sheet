package org.example.arrays;

//Time Complexity: O(1)
//Space Complexity: O(1)
//Problem link: https://www.geeksforgeeks.org/problems/implement-queue-using-array/1
//Level: Medium
public class BuildQueueFromArray {
    int front, rear;
    int arr[] = new int[100005];

    BuildQueueFromArray() {
        front = 0;
        rear = 0;
    }

    //Function to push an element x in a queue.
    void push(int x) {
        // Your code here
        arr[rear] = x;
        rear++;
    }

    //Function to pop an element from queue and return that element.
    int pop() {
        // Your code here
        if (front < rear && rear != 0) {
            int e = arr[front];
            front++;
            return e;
        }
        return -1;

    }
}
