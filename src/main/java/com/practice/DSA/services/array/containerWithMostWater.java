package com.practice.DSA.services.array;

import org.springframework.stereotype.Service;

@Service
public class containerWithMostWater {

    public containerWithMostWater() {
    } // required for Spring

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int currArea;
        int maxArea = 0;

        while (l < r) {
            currArea = (r - l) * (Math.min(height[l], height[r]));
            maxArea = Math.max(maxArea, currArea);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
