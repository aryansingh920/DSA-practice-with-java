
package com.practice.DSA.services.array;

public class searchInSortedRotatedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[l] <= nums[mid]) {
                // Target lies in left half
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // Right half is sorted
            else {
                // Target lies in right half
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
