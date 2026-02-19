package com.practice.DSA.controllers.array;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.DSA.enums.ResponseStatus;
import com.practice.DSA.helper.APIResponse;
import com.practice.DSA.services.array.containerWithMostWater;
import com.practice.DSA.services.array.searchInSortedRotatedArray;
import com.practice.DSA.services.service;

@RestController("ArrayController")
@RequestMapping("/dsa/array")
public class ArrayController {
    private final service ArrayService;

    public ArrayController(service ArrayService) {
        this.ArrayService = ArrayService;
    }

    @GetMapping({ "", "/" })
    public APIResponse<String> getMethodName() {
        return new APIResponse<>(
                ResponseStatus.SUCCESS.getCode(),
                ResponseStatus.SUCCESS.getMessage(),
                ArrayService.getMessage());
    }

    @PostMapping(value = "/containerWithMostWater", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public APIResponse<Integer> containerWithMostWater(@RequestBody Map<String, List<Integer>> body) {

        List<Integer> heightList = body.get("height");
        if (heightList == null) {
            throw new IllegalArgumentException("Missing 'height'");
        }

        int[] height = new int[heightList.size()];
        for (int i = 0; i < heightList.size(); i++) {
            height[i] = heightList.get(i);
        }

        int ans = containerWithMostWater.maxArea(height);

        return new APIResponse<>(
                ResponseStatus.SUCCESS.getCode(),
                ResponseStatus.SUCCESS.getMessage(),
                ans);
    }

    @PostMapping(value = "/searchInSortedRotatedArray", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public APIResponse<Integer> searchInSortedRotatedArray(
            @RequestBody Map<String, List<Integer>> body,
            @RequestParam int target) {

        List<Integer> numsList = body.get("nums");
        if (numsList == null) {
            throw new IllegalArgumentException("Missing 'height'");
        }

        int[] nums = new int[numsList.size()];
        for (int i = 0; i < numsList.size(); i++) {
            nums[i] = numsList.get(i);
        }

        int ans = searchInSortedRotatedArray.search(nums, target);

        return new APIResponse<>(
                ResponseStatus.SUCCESS.getCode(),
                ResponseStatus.SUCCESS.getMessage(),
                ans);
    }

}
