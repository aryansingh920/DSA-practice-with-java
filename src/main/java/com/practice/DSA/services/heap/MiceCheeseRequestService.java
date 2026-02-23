package com.practice.DSA.services.heap;

import java.util.Arrays;

public class MiceCheeseRequestService {
    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int totalPoints = 0;
        int[] diff = new int[n];

        // 1. Assume Mouse 2 eats everything initially
        // 2. Calculate the 'gain' if Mouse 1 eats it instead
        for (int i = 0; i < n; i++) {
            totalPoints += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }

        // 3. Sort the differences (ascending by default in Java)
        Arrays.sort(diff);

        // 4. Since we want the MAX gain, we pick the k largest values.
        // These are at the end of the sorted array.
        for (int i = 0; i < k; i++) {
            totalPoints += diff[n - 1 - i];
        }

        return totalPoints;
    }
}
