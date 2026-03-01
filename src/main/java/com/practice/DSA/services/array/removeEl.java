package com.practice.DSA.services.array;

public class removeEl {
    public static int removeElement(int[] nums, int val) {
        int result = 0, i = 0, j = 0,temp;

        while (j < nums.length) {
            if (nums[i] == val) {
                if (nums[j] == val) {
                } else {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                    result++;

                    i++;
                }
            } else {
                i++;
                result++;

            }
            j++;

        }

        return result;
    }
}
