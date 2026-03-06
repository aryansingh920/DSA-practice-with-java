package com.practice.DSA.services.hash;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;


class NextGreaterElementTest {

    @Test
    void testStandardCase() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] expected = {-1, 3, -1};
        assertArrayEquals(expected, p496.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testNoGreaterElement() {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] expected = {3, -1};
        assertArrayEquals(expected, p496.nextGreaterElement(nums1, nums2));
    }

    @Test
    void testEmptySubset() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        int[] expected = {};
        assertArrayEquals(expected, p496.nextGreaterElement(nums1, nums2));
    }
}
