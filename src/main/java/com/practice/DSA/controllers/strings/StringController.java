package com.practice.DSA.controllers.strings;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.DSA.enums.ResponseStatus;
import com.practice.DSA.helper.APIResponse;
import com.practice.DSA.services.service;
import com.practice.DSA.services.strings.lengthOfLongestSubstring;

@RestController("StringController")
@RequestMapping("/dsa/string")
public class StringController {
    private final service StringService;

    public StringController(service StringService) {
        this.StringService = StringService;
    }

    @GetMapping({ "", "/" })
    public APIResponse<String> getMethodName() {
        return new APIResponse<>(
                ResponseStatus.SUCCESS.getCode(),
                ResponseStatus.SUCCESS.getMessage(),
                StringService.getMessage());
    }

    @GetMapping(value = "/lengthOfLongestSubstring", produces = MediaType.APPLICATION_JSON_VALUE)
    public APIResponse<Map<String, Integer>> getlengthOfLongestSubstring(
            @RequestParam(defaultValue = "") String string) {
        return new APIResponse<>(
                ResponseStatus.SUCCESS.getCode(),
                ResponseStatus.SUCCESS.getMessage(),
                Map.of("answer", lengthOfLongestSubstring.f(string)));
    }

}
