package com.practice.DSA.controllers.hash;


import java.util.LinkedList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.DSA.DataTransferObject.LruRequest;
import com.practice.DSA.enums.ResponseStatus;
import com.practice.DSA.helper.APIResponse;
import com.practice.DSA.services.hash.LRU.LRUService;
import com.practice.DSA.services.service;


@RestController("HashController")
@RequestMapping("/dsa/hash")
public class HashController {
    private final service HashService;

    public HashController(service HashService) {
        this.HashService = HashService;
    }

    @GetMapping({ "", "/" })
    public APIResponse<String> getMethodName() {
        return new APIResponse<>(
                ResponseStatus.SUCCESS.getCode(),
                ResponseStatus.SUCCESS.getMessage(),
                HashService.getMessage());
    }

    @PostMapping(
        value = "/LRUCache",
        consumes= MediaType.APPLICATION_JSON_VALUE,
        produces=MediaType.APPLICATION_JSON_VALUE)
    public APIResponse<LinkedList<Integer>> getLRUCache(@RequestBody LruRequest object) {
        // int capacity = object.getValue().get(0).get(0);
        LRUService lruService = new LRUService();

        return new APIResponse<>(
            ResponseStatus.SUCCESS.getCode(),
            ResponseStatus.SUCCESS.getMessage(),
            lruService.run(object)
        );
    }
    

}
