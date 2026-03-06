package com.practice.DSA.services.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class p496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }


        int[] output = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            output[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return output;
    }
}
