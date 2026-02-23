package com.practice.DSA.controllers.heap;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.DSA.DataTransferObject.MiceCheeseRequest;
import com.practice.DSA.enums.ResponseStatus;
import com.practice.DSA.helper.APIResponse;
import com.practice.DSA.services.heap.MiceCheeseRequestService;
import com.practice.DSA.services.heap.kthLargestElement;
import com.practice.DSA.services.service;

@RestController("HeapController")
@RequestMapping("/dsa/heap")
public class HeapController {
    private final service HeapService;

    public HeapController(service HeapService) {
        this.HeapService = HeapService;
    }

    @GetMapping({ "", "/" })
    public APIResponse<String> getMethodName() {
        return new APIResponse<>(
                ResponseStatus.SUCCESS.getCode(),
                ResponseStatus.SUCCESS.getMessage(),
                HeapService.getMessage());
    }

    @PostMapping(value = "/miceAndCheese", produces = MediaType.APPLICATION_JSON_VALUE)
    public APIResponse<Integer> getMiceAndCheese(@RequestBody MiceCheeseRequest object) {

        int[] reward1 = object.getReward1().stream().mapToInt(Integer::intValue).toArray();
        int[] reward2 = object.getReward2().stream().mapToInt(Integer::intValue).toArray();

        int result = MiceCheeseRequestService.miceAndCheese(reward1, reward2, object.getK());

        return new APIResponse<>(
                ResponseStatus.SUCCESS.getCode(),
                ResponseStatus.SUCCESS.getMessage(),
                result);
    }

    @PostMapping(value = "/kthLargestElement", produces = MediaType.APPLICATION_JSON_VALUE)
    public APIResponse<Integer> getKthLargestElement(
            @RequestBody List<Integer> nums,
            @RequestParam int k) {

        int[] numList = nums.stream().mapToInt(Integer::intValue).toArray();

        int result = kthLargestElement.findKthLargest(numList, k);

        return new APIResponse<>(
                ResponseStatus.SUCCESS.getCode(),
                ResponseStatus.SUCCESS.getMessage(),
                result);
    }
}
