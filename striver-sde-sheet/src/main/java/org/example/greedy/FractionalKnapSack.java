package org.example.greedy;

import java.util.Arrays;
import java.util.Comparator;

//TC: O(NlogN)
//SC: O(1)
//Problem link: https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
//Level: Medium
public class FractionalKnapSack {

    double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, new CustomComparator());
        double ans = 0;
        for (int i = 0; i < arr.length && w >= 0; i++) {
            int t = w > arr[i].weight ? arr[i].weight : w;
            ans += (double) arr[i].value / arr[i].weight * t;
            w -= t;
        }
        return ans;
    }
}

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class CustomComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double av = (double) a.value / a.weight;
        double bv = (double) b.value / b.weight;
        return av > bv ? -1 : 1;
    }
}

